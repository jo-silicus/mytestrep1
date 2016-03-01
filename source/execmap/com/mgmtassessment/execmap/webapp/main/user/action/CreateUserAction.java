/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : sharmrahu
 * @date : Aug 11, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.webapp.main.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.business.model.UserAccountModel;
import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.exceptions.DataCreateException;
import com.mgmtassessment.execmap.common.exceptions.EmailException;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.user.form.UserAccountForm;

/**
 * The class is implementation of <strong>Action</strong> that is responsible
 * to add the details of a particular  user.
 */
public class CreateUserAction extends ExecmapAction {

     /**
     * Implementation of inherited method from ExecmapAction,
     * reposible for executing the action to add the user for the
     * required group.
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
     * @return Action to forward to confermaition page.
     * @exception DataCreateException
     *                if there is some error in iserting the data.
     * @exception EmailException
     *                if there is some error insending mail.
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy servPrxy)
             throws DataCreateException, EmailException  {

        UserAccountModel userAccountModel = populateModel(
                (UserAccountForm) form);
        servPrxy.getUserManager().saveUser(userAccountModel);
        return mapping.findForward(IConstants.SUCCESS_KEY);
    }

    /**
     * The function is responsible for converting the data from the
     *  form in the required model object.
     * @param userAccountForm from which details are retrieved.
     * @return UserAccountModel corresponding object.
     */
    private UserAccountModel populateModel(UserAccountForm userAccountForm) {
        UserAccountModel userAccountModel = new UserAccountModel();
        userAccountModel.setUserCompanyAccountID(userAccountForm
                .getUserCompanyAccountID());
        userAccountModel.setUserID(userAccountForm.getUserID());
        userAccountModel.setUserRoleID("5");
        userAccountModel.setUserStartFlag("T");
        userAccountModel.setUserFirstName(userAccountForm.getUserFirstName());
        userAccountModel.setUserLastName(userAccountForm.getUserLastName());
        userAccountModel.setUserEmail(userAccountForm.getUserEmail());
        userAccountModel.setUserNotes(userAccountForm.getUserNotes());
        userAccountModel.setUserGroupID(userAccountForm.getUserGroupID());
        userAccountModel.setUserPassword(userAccountForm.getUserPassword());
        userAccountModel.setUserStatus(userAccountForm.getUserStatus());
        userAccountModel.setUserReminderPhrase(userAccountForm
                .getUserReminderPhrase());
        return userAccountModel;
    }

}
