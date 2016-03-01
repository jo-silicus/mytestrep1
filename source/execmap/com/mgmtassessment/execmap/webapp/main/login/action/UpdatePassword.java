/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : AhmedZia
 * @date : Aug 21, 2006
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
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.mgmtassessment.execmap.business.model.LoginModel;
import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.company.form.CompanyAccountForm;
import com.mgmtassessment.execmap.webapp.main.login.form.ChangePasswordForm;
import com.mgmtassessment.execmap.webapp.main.login.form.LoginForm;

/**
 * Implementation of <strong>Action</strong> that updates the User's password.
 *
 */

public class UpdatePassword extends ExecmapAction {

    /**
     * <p>
     * The user's based on {@link LoginForm} properties.
     * </p>
     * <p>
     * This <code>Action</code> looks for <code>LoginForm</code> and
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
     * @param usrContext
     *            The UserContext which provide details of User
     * @param servPrxy
     *            The ServiceProxy which creates bean to call business layer
     *            methods.
     *
     * @return Action to forward to message.jsp
     * @exception java.lang.Exception
     *                if an input/output error or servlet exception occurs
     */

    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy servPrxy) throws Exception {

        // Extract attributes we will need
        HttpSession session = request.getSession();

        ChangePasswordForm loginFrm = (ChangePasswordForm) form;
        

        ActionMessages messages = validateFormValues(loginFrm);
        if (!messages.isEmpty()) {
            saveMessages(request, messages);
            return mapping.findForward(IConstants.FAILURE);
        }

        LoginModel loginModel = populateModel(loginFrm);

        /**
         * TODO connect to the persistence layer to extract the uid , pwd and
         * acct id and make a hash of both to verify pwd and return principal to
         * the session. For now let the control go to the admin screen.
         */
         servPrxy.getLoginManager().updatePassword(loginModel);

            loginFrm.reset(mapping, request);
            return mapping.findForward(IConstants.SUCCESS);
        

    }

    /**
     * Validates the form values.
     *
     * @param loginFrm
     * @return messages
     */
    private ActionMessages validateFormValues(ChangePasswordForm loginFrm) {

        ActionMessages messages = new ActionMessages();

        if (!loginFrm.getNewPassword().equals(loginFrm.getRetypePassword())) {

            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                    "label.newpassword.equal",true));
        }

        return messages;
    }

    /**
     * Populates the Login Model.
     *
     * @param loginFrm
     * @return loginModel
     */
    private LoginModel populateModel(ChangePasswordForm loginFrm) {

        LoginModel loginModel = new LoginModel();

        loginModel.acctid = loginFrm.getAcctid();
        loginModel.userid = loginFrm.getUserid();
        loginModel.password = loginFrm.getPassword();
        loginModel.newPassword = loginFrm.getNewPassword();

        return loginModel;
    }

}
