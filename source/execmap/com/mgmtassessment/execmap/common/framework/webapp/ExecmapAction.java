/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : DasAshim
 * @date : Jul 20, 2006
 * @version: 1.0
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.common.framework.webapp;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.exceptions.ExecMapException;
import com.mgmtassessment.execmap.common.exceptions.ExecMapRuntimeException;
import com.mgmtassessment.execmap.common.exceptions.ExecMapScriptException;
import com.mgmtassessment.execmap.common.exceptions.ExecmapSecurityBreachException;
import com.mgmtassessment.execmap.common.util.ExceptionUtil;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;

/**
 * This is the base Action class for the Execmap Application.
 * All the Action class in the Execmap Application extends this
 * class. It implements the command pattern execute method as custom
 * executeAction method. It acts as control point for all request actions.
 * It implements the concerns for :
 * <ul>
 * <li> Checks if the javascript is enabled.
 * <li> Checks if all actions are authenticated request.
 * <li> Puts the session in context if not present.
 * <li> Gets handler to the spring container proxy for facade manager's.
 * <li> Central point for catching and logging for checked 
 *      unchecked and system level exceptions.
 * <li> Central point for page redirection. @see struts-config.xml
 * </ul> 
 * 
 */
public abstract class ExecmapAction extends Action {

    /** Log factory for this class. * */
    private static Log log = LogFactory.getLog(ExecmapAction.class);

    /** Spring Application Context. * */
    private ApplicationContext appContext;

    /**
     * The execute method all Action class must implement.
     */
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ActionForward forwardPage = null;
        boolean isValid = true;
        
        try {
        	/**
        	 * Check for javascript enabled at client browser.
        	 */
            if(form!=null) {
               String enabledJS=((ExecmapForm)
                    form).getEnableScript();
              if (!("Enabled".equals(enabledJS))) {
                 if (!("Disabled".equals(enabledJS))) {
                    throw new ExecMapScriptException("errors.enableJavaScript");
                 }
              }
            }
            /**
             * Check for security role check and session time out
             * before execute action.
             */
            
            if (!("NOSESS").equals(mapping.getParameter())){
              	if (request.getSession()!= null){
               	  if ( getUserContext(request).getUserInfo() == null ){
            		ActionErrors errors = new ActionErrors();
            		ActionMessage errorMsg = null;
                    errorMsg = new ActionMessage("errors.session.expired", true);
                    errors.add(ActionErrors.GLOBAL_MESSAGE, errorMsg);
                    saveMessages(request, errors);
                    isValid = false;
              	    }
            	  }	
            	  if(request.getSession() == null){
            		  ActionErrors errors = new ActionErrors();
              		  ActionMessage errorMsg = null;
                      errorMsg = new ActionMessage("errors.session.not.logged", true);
                      errors.add(ActionErrors.GLOBAL_MESSAGE, errorMsg);
                      saveMessages(request, errors);
                      isValid = false;
                 }
            }
            //Main Execute Action
            if (isValid){
              forwardPage = executeAction(mapping, form, request, response,
                    getUserContext(request), getServiceProxy());
            }else{
            	log.debug("Fowarding to login page due to invalid session");
            	forwardPage = mapping.findForward(IConstants.LOGIN_KEY);
            }
        }
        catch (ExecmapSecurityBreachException e) {
            getServiceProxy().getMailWriterFacade().sendSecurityBreachMail(
            		getServiceProxy().getMailWriterFacade().getSystemAdminEmailId(),
                    getUserContext(request).getUserInfo(),
                    request.getRequestURL().toString() + "?"
                            + request.getQueryString());
            request.getSession().invalidate();
            forwardPage = mapping.findForward(IConstants.SECURITY_BREACH);
        }
        catch (ExecMapScriptException e) {
            request.getSession().invalidate();
            forwardPage = mapping.findForward(IConstants.ERROR_JS);
        }
        catch (ExecMapException emMapex) {
            // Log the Exception to the log file.
            log.error(ExceptionUtil.getInstance().getDetailedMessage(emMapex),
                    emMapex);
            forwardPage = processExceptions(request, mapping, emMapex);
        }
        catch (ExecMapRuntimeException exMapRex) {
            // Log RuntimeException to log file
            log.error(ExceptionUtil.getInstance()
                    .getRuntimeExceptionDetailMessage(exMapRex), exMapRex);
            forwardPage = processRuntimeExceptions(request, mapping, exMapRex);
        }
        catch (Throwable th) {
            // Log System Exception
            log.fatal("SYSTEM FAILURE: ", th);
            forwardPage = mapping.findForward(IConstants.SYSTEM_FAILURE_KEY);
        }
        return forwardPage;
    }

    /**
     * The method that needs to be overriden by the subclass of ExecmapAction.
     */

    abstract public ActionForward executeAction(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response, UserContext usrContext,
            ServiceProxy servPrxy) throws Exception;

    /**
     * This method gets an Instance of ServiceProxy. The service Proxy will in
     * return the domain Facade Interface for a module.
     * 
     * @return ServiceProxy
     */
    protected ServiceProxy getServiceProxy() {
        appContext = getApplicationContext();
        ServiceProxy sProxy = (ServiceProxy) appContext
                .getBean(IConstants.SERVICE_PROXY);
        sProxy.setAppContext(appContext);
        return sProxy;
    }

    /**
     * This is a helper method that returns UserConext of the User logged in.
     * Note: The User context must be setup when the User has been authenticated
     * into the system. The right place for it to set it up would be in the
     * 
     * @see <code>LoginAction</code> class.
     * @param HttpServletRequest
     * @return UserContext
     */

    protected UserContext getUserContext(HttpServletRequest req) {
        HttpSession session = req.getSession();
        UserContext userCtxt = (UserContext) session
                .getAttribute(IConstants.USER_CONTEXT);
        if (null == userCtxt) {
            userCtxt = new UserContext();
            session.setAttribute(IConstants.USER_CONTEXT, userCtxt);
        }
        return userCtxt;
    }

    /**
     * This is a private method to get the Spring Context from the Servlet
     * container.
     * 
     * @return ApplicationContext
     */
    private ApplicationContext getApplicationContext() {
        appContext = WebApplicationContextUtils.getWebApplicationContext(this
                .getServlet().getServletContext());
        return appContext;

    }

    /**
     * This method extracts the messages from the exception and then checks if
     * the action input path is configured in the struts-config file in the
     * action element. If no input path is defined then it is forwarded to
     * system failure path.
     * 
     * @param request
     * @param mapping
     * @param emapEx
     * @return
     */

    protected ActionForward processExceptions(HttpServletRequest request,
            ActionMapping mapping, ExecMapException emapEx) {
        ActionErrors errors = new ActionErrors();
        ActionForward forward = null;
        Locale locale = request.getLocale();
        getExceptionMessages(errors, emapEx, locale);

        String input = mapping.getInput();

        if (input != null) {
            forward = new ActionForward(input);
        } else {
            forward = mapping.findForward(IConstants.FAILURE_KEY);
        }
        // Check if it chained exception, get the messages
        // for all the subexceptions in the chain.
        List exceptions = emapEx.getExceptions();
        if (exceptions != null && !exceptions.isEmpty()) {
            Iterator iter = exceptions.iterator();
            while (iter.hasNext()) {
                getExceptionMessages(errors, (ExecMapException) iter.next(),
                        locale);
            }
        }
        // save messages in request
        saveMessages(request, errors);

        return forward;

    }

    /**
     * This method gets the keys from the Exception thrown and puts in the
     * ActionErrors as ActionMessages.
     * 
     * @param errors
     * @param exmapEx
     * @param locale
     */

    protected void getExceptionMessages(ActionErrors errors,
            ExecMapException exmapEx, Locale locale) {

        ActionMessage errorMsg = null;
        Object[] args = exmapEx.getMessageKeyArgs();

        if (args != null && args.length > 0) {
            errorMsg = new ActionMessage(exmapEx.getMessage(), true, args);
        } else {
            errorMsg = new ActionMessage(exmapEx.getMessage(), true);
        }

        errors.add(ActionErrors.GLOBAL_MESSAGE, errorMsg);
    }

    /**
     * This method extracts the messages from RuntimeException and then checks
     * if the action input path is configured in the struts-config file in the
     * action element. If no input path is defined then it is forwarded to
     * system failure path.
     * 
     * @param request
     * @param mapping
     * @param emapEx
     * @return
     */

    protected ActionForward processRuntimeExceptions(
            HttpServletRequest request, ActionMapping mapping,
            ExecMapRuntimeException emapEx) {
        ActionErrors errors = new ActionErrors();
        ActionForward forward = null;
        Locale locale = request.getLocale();
        getRuntimeExceptionMessages(errors, emapEx, locale);

        String input = mapping.getInput();

        if (input != null) {
            forward = new ActionForward(input);
        } else {
            forward = mapping.findForward(IConstants.FAILURE_KEY);
        }
        // Check if it chained exception, get the messages
        // for all the subexceptions in the chain.
        List exceptions = emapEx.getExceptions();
        if (exceptions != null && !exceptions.isEmpty()) {
            Iterator iter = exceptions.iterator();
            while (iter.hasNext()) {
                getExceptionMessages(errors, (ExecMapException) iter.next(),
                        locale);
            }
        }
        // save messages in request
        saveMessages(request, errors);

        return forward;

    }

    /**
     * This method gets the keys from the RuntimeException thrown and puts in
     * the ActionErrors as ActionMessages.
     * 
     * @param errors
     * @param exmapEx
     * @param locale
     */

    protected void getRuntimeExceptionMessages(ActionErrors errors,
            ExecMapRuntimeException exmapEx, Locale locale) {

        ActionMessage errorMsg = null;
        Object[] args = exmapEx.getMessageKeyArgs();

        if (args != null && args.length > 0) {
            errorMsg = new ActionMessage(exmapEx.getMessage(), true, args);
        } else {
            errorMsg = new ActionMessage(exmapEx.getMessage(), true);
        }

        errors.add(ActionErrors.GLOBAL_MESSAGE, errorMsg);
    }
}
