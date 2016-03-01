/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : AhmedZia
 * @date : Aug 12, 2006
 * @version:
 *
 * @history Description Reference Name Date
 *
 */

package com.mgmtassessment.execmap.webapp.main.company.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;


import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.company.form.CompanyAccountForm;

/**
 * Implementation of <strong>Action</strong> that delete the
 * disable company from the database.
 *
 */

public class DeleteCompanyAction extends ExecmapAction {

    /**
     * <p>
     * The user's based on {@link CompanyAccountForm} properties.
     * </p>
     * <p>
     * This <code>Action</code> looks for <code>CompanyAccountForm</code>
     * and properties on the given form,
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
     * @param usrContext
     *            The UserContext which provide details of User
     * @param serviceProxy
     *            The ServiceProxy which creates bean to call business layer
     *            methods.
     *
     * @return Action to forward to message.jsp
     * @exception java.lang.Exception
     *                if an input/output error or servlet exception occurs
     */

    private static Log log = LogFactory.getLog(DeleteCompanyAction.class);

    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy serviceProxy)
            throws Exception {

        CompanyAccountForm coAcctForm = (CompanyAccountForm)form;

        ActionMessages messages = validateFormValues(coAcctForm);

        if (!messages.isEmpty()) {
            saveMessages(request, messages);
            return mapping.findForward(IConstants.FAILURE);
        }

        /** Account IDs of Companies which are selected to delete */
        String[] acctIds = coAcctForm.getSelectedCheckboxes();

        log.info("Account Ids:"+acctIds);

        /**
         * get the ServiceProxy, get the Login Service Facade from it and invoke
         * the save methods.
         *
         * TODO implement this.
         */
        serviceProxy.getCompanyManager().deleteCompany(acctIds);

        /**
         * TODO connect to the persistence layer to extract the uid , pwd and
         * acct id and make a hash of both to verify pwd and return principal to
         * the session. For now let the control go to the admin screen.
         */

        return mapping.findForward(IConstants.SUCCESS_KEY);

    }

    /**
     * Validate Action Form Values retrieve from JSP.
     *
     * @param coAcctForm
     * @return messages
     */
    private ActionMessages validateFormValues(CompanyAccountForm coAcctForm){

        ActionMessages messages = new ActionMessages();

       if (coAcctForm.getSelectedCheckboxes()== null) {
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                    "label.delete.company",true));
        }

        return messages;
    }

}
