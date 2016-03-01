/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @author : barthwpr 
 *  @date   : Aug 24, 2006
 *  @version: 
 * 
 *  @history
 *  Description         Reference       Name        Date
 *               
 */

package com.mgmtassessment.execmap.webapp.main.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.business.model.UserAccountModel;
import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.user.form.UserAccountForm;

/**
 * TODO Write java docs comments for this type
 * 
 */

public class UpdateCompanyUserAction extends ExecmapAction {

    /**
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @param usrContext
     * @param servPrxy
     *            Implementation of inherited method from ExecmapAction,
     *            reposible for executing the action to add the user for the
     *            required group.
     * @return ActionForward
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy servPrxy) throws Exception {
        // retriving from form
        UserAccountModel userAccountModel = populateModel((UserAccountForm) form);

        // updating the user
        servPrxy.getUserManager().updateUser(userAccountModel);
        return mapping.findForward(IConstants.SUCCESS_KEY);
    }

    /**
     * @param userAccountForm
     *            The function is responsible for converting the data from the
     *            form in the required model object.
     * @return UserAccountModel
     */
    private UserAccountModel populateModel(UserAccountForm userAccountForm) {
        UserAccountModel userAccountModel = new UserAccountModel();
        userAccountModel.setUserCompanyAccountID(userAccountForm
                .getUserCompanyAccountID());
        userAccountModel.setUserID(userAccountForm.getUserID());
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
