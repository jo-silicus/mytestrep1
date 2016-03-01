/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : sharmrahu
 * @date : Aug 2, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.webapp.main.group.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.business.model.GroupAccountModel;
import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.exceptions.DataSaveException;
import com.mgmtassessment.execmap.common.exceptions.EmailException;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.group.form.GroupAccountForm;

/**
 * The class is implementation of <strong>Action</strong> that updates the
 * group to a given company.
 */

public class UpdateGroupAccountAction
        extends ExecmapAction {
    /**
     * if there is some error insending mail. Implementation of inherited method
     * from ExecmapAction, reposible for executing the action to update the
     * group for the required company.
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
     * @return Action to forward to search group page.
     * @exception DataSaveException
     *                if there is some error in updating the data.
     * @exception EmailException
     *                if there is some error insending mail.
     */
    public ActionForward executeAction(
            ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response, UserContext usrContext,
            ServiceProxy servPrxy)
            throws DataSaveException, EmailException {

        GroupAccountForm groupAccountForm = (GroupAccountForm) form;
        // retriving group details from form
        GroupAccountModel groupAccountModel = populateModel(groupAccountForm);

        // updating the group
        servPrxy
                .getGroupManager().updateGroup(
                        groupAccountModel);
        return mapping
                .findForward(IConstants.SUCCESS_KEY);
    }

    /**
     * The function is responsible for converting the data from the
     *  form in the required model object.
     * @param groupAccountForm data from form is retrived.
     *
     * @return GroupAccountModel correspond model object.
     */
    private GroupAccountModel populateModel(
            GroupAccountForm groupAccountForm) {
        GroupAccountModel groupAccountModel = new GroupAccountModel();

        groupAccountModel
                .setCompanyAccountID(groupAccountForm
                        .getCompanyAccountID());

        groupAccountModel
                .setGroupInfo(groupAccountForm
                        .getGroupInformation());
        groupAccountModel
                .setGroupStatus(groupAccountForm
                        .getGroupStatus());
        groupAccountModel
                .setUserActivityRoleID("3");
        groupAccountModel
                .setUserEmail(groupAccountForm
                        .getGroupManagerEmail());
        groupAccountModel
                .setUserGroupID(groupAccountForm
                        .getGroupID());
        groupAccountModel
                .setUserID(groupAccountForm
                        .getGroupManagerUserID());
        groupAccountModel
                .setUserFirstName(groupAccountForm
                        .getGroupManagerFirstName());
        groupAccountModel
                .setUserLastName(groupAccountForm
                        .getGroupManagerLastName());
        groupAccountModel
                .setUserNotes1("Not provided");
        groupAccountModel
                .setUserNotes2("Not provided");
        groupAccountModel
                .setUserPassword(groupAccountForm
                        .getGroupManagerPassword());
        groupAccountModel
                .setUserReminderPhrase(groupAccountForm
                        .getGroupReminderPhrase());
        groupAccountModel
                .setUserStartFlag("T");
        groupAccountModel
                .setUserStatus(groupAccountForm
                        .getGroupStatus());

        return groupAccountModel;
    }

}
