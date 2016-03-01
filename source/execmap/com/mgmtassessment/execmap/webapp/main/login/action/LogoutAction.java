/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * 
 * @author : AhmedZia
 * @date : Sep 17, 2006
 * @version:
 * 
 * @history Description Reference Name Date
 * 
 */

package com.mgmtassessment.execmap.webapp.main.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.common.util.webapp.UserLoginInfo;

/**
 * TODO Write java docs comments for this type
 * 
 */

public class LogoutAction extends ExecmapAction {

    /**
     * <p>
     * The user's based on {@link ActionForm} properties.
     * </p>
     * <p>
     * This <code>Action</code> looks for <code>loginForm</code> and
     * properties on the given form,
     * <p>
     * 
     * @param mapping
     *            The ActionMapping used to select this instance
     * @param form
     *            The optional ActionForm bean for this request (if any)
     * @param request
     *            The HTTP request we are processing
     * @param response
     *            The HTTP response we are creating
     * @return Action to forward to
     * @exception java.lang.Exception
     *                if an input/output error or servlet exception occurs
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy serviceProxy) throws Exception {

        HttpSession session = request.getSession();
        usrContext.getUserInfo().setAccountId("");
        usrContext.getUserInfo().setGroupId("");
        usrContext.getUserInfo().setLogonUserId("");
       
        session.removeAttribute(IConstants.USER_CONTEXT);
        
        
        session.invalidate();

        return mapping.findForward(IConstants.SUCCESS_KEY);
    }

}
