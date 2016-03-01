/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : AhmedZia
 * @date : Jul 23, 2006
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
import org.springframework.context.ApplicationContext;

import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.login.form.LoginForm;
import com.mgmtassessment.execmap.webapp.main.login.form.PasswordReminderForm;

/**
 * Implementation of <strong>Action</strong> that sends the email to Company
 * User to inform about the password on verifying the accountID and UserId.
 *
 */

public class ForgetPassword extends ExecmapAction {

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

        /**
         * TODO connect to the persistence layer to extract the uid , pwd and
         * acct id and make a hash of both to verify pwd and return principal to
         * the session. For now let the control go to the admin screen.
         */

        return mapping.findForward(IConstants.SUCCESS);

    }

}
