/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : AhmedZia
 * @date : Aug 28, 2006
 * @version:
 *
 * @history Description Reference Name Date
 *
 */

package com.mgmtassessment.execmap.webapp.main.login.action;

import java.util.regex.Pattern;

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
import com.mgmtassessment.execmap.webapp.main.login.form.LoginForm;
import com.mgmtassessment.execmap.webapp.main.login.form.PasswordReminderForm;
import com.mgmtassessment.execmap.webapp.main.user.form.UserCreationForm;

/**
 * Implementation of <strong>Action</strong> that sends the email to Company
 * User to inform about the password on verifying the accountID and UserId.
 *
 */

public class PasswordReminder extends ExecmapAction {

    /**
     * <p>
     * The user's based on {@link PasswordReminderForm} properties.
     * </p>
     * <p>
     * This <code>Action</code> looks for <code>PasswordReminderForm</code>
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

    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy serviceProxy) throws Exception {

        // Extract attributes we will need
        HttpSession session = request.getSession();

        PasswordReminderForm passwordReminderForm = (PasswordReminderForm) form;

        ActionMessages messages = validateFormValues(passwordReminderForm);
        if (!messages.isEmpty()) {
            saveMessages(request, messages);
            return mapping.findForward(IConstants.FAILURE);
        }

        LoginModel loginModel = populateModel(passwordReminderForm);

        /**
         * TODO connect to the persistence layer to extract the uid , pwd and
         * acct id and make a hash of both to verify pwd and return principal to
         * the session. For now let the control go to the admin screen.
         */
        serviceProxy.getLoginManager().passwordReminder(loginModel);

        return mapping.findForward(IConstants.SUCCESS);

    }

    /**
     * Populate login model.
     *
     * @param passwordReminderForm
     * @return
     */
    private LoginModel populateModel(PasswordReminderForm passwordReminderForm) {

        LoginModel loginModel = new LoginModel();

        loginModel.acctid = passwordReminderForm.getAcctid();
        loginModel.userid = passwordReminderForm.getUserid();
        loginModel.email = passwordReminderForm.getEmail();

        return loginModel;
    }

    /**
     * Validate Form Values
     *
     * @param userCreationForm
     * @return
     */
    public ActionMessages validateFormValues(
            PasswordReminderForm passwordReminderForm) {

        ActionMessages messages = new ActionMessages();

        if (!INT_REGEX.matcher(passwordReminderForm.getEmail()).matches()) {

            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                    "login.email.invalid", true));
        }

        return messages;
    }

    /**
     * Regular expression for checking EMAIL.
     */
    private final static Pattern INT_REGEX = 
        Pattern.compile(

        "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)"
           + "*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)"
          + "*(\\.[_A-Za-z0-9-]+)", //$NON-NLS-1$
    Pattern.CASE_INSENSITIVE);

}
