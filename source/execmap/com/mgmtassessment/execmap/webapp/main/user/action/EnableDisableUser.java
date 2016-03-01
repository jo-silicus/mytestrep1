/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : sharmrahu
 * @date : Aug 24, 2006
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
import com.mgmtassessment.execmap.common.exceptions.DataSaveException;
import com.mgmtassessment.execmap.common.exceptions.ExecmapSecurityBreachException;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.user.form.UserAccountForm;

/**
 * Implementation of <strong>Action</strong> that enables /disables a user.
 */
public class EnableDisableUser
        extends ExecmapAction {

    /**
     * Implementation of inherited method from ExecmapAction, reposible for
     * updating the user record.
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
     * @return Action to forward to search user page.
     * @exception DataSaveException
     *                if there is some error in updating the data.
     * @exception ExecmapSecurityBreachException
     *                if there is a security breach.
     */
    public ActionForward executeAction(
            ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response, UserContext usrContext,
            ServiceProxy servPrxy)
            throws DataSaveException, ExecmapSecurityBreachException {
        UserAccountForm userAccountForm = (UserAccountForm) form;
        UserAccountModel userAccountModel = new UserAccountModel();
        // Setting the AccountId,groupId and userid
        String accountID = request
                .getParameter("companyAccountID");
        String groupID = request
                .getParameter("groupID");
        String userID = request
                .getParameter("userID");
        if ((groupID == null) || ("".equals(groupID))) {
            groupID = null;
        }
        if ((userID == null) || ("".equals(userID))) {
            userID = null;
        }
        boolean securityBreach=false;
        if ((accountID == null) || ("".equals(accountID))) {
            accountID = null;
        }
        int roleID = usrContext.getUserInfo().getActivityRoleID();
        switch (roleID) {
            case IConstants.EXECMAP_COMPANY_USER_ROLE_ID:
                securityBreach=(userID!=null)&&(
                        securityBreach||!userID.equalsIgnoreCase(
                        usrContext.getUserInfo().getLogonUserId().trim()));
                userID = usrContext.getUserInfo().getLogonUserId().trim();
            case IConstants.EXECMAP_GROUP_COORDINATOR_ROLE_ID:
                securityBreach=(groupID!=null)&&(
                        securityBreach||!groupID.equalsIgnoreCase(
                        usrContext.getUserInfo().getGroupId().trim()));
                groupID = usrContext.getUserInfo().getGroupId().trim();
            case IConstants.EXECMAP_SUPERVISOR_ROLE_ID:
                securityBreach=(accountID!=null)&&(securityBreach||
                !accountID.equalsIgnoreCase(
                        usrContext.getUserInfo().getAccountId()));
                accountID = usrContext.getUserInfo().getAccountId();
            case IConstants.EXECMAP_ADMIN_ROLE_ID:
                break;

            default:
                securityBreach=true;
                break;
        }

        if(securityBreach)
        {
            throw new ExecmapSecurityBreachException("security.breach.message");
        }
        userAccountModel
                .setUserCompanyAccountID(accountID);
        userAccountModel
                .setUserGroupID(groupID);
        userAccountModel
                .setUserID(userID);
        // updating the useraccount
        servPrxy
                .getUserManager().enableDisableUserAccount(
                        userAccountModel);

        userAccountForm
                .setUserCompanyAccountID(accountID);
        userAccountForm
                .setUserGroupID(groupID);
        userAccountForm
                .setUserID(userID);

        return mapping
                .findForward(IConstants.SUCCESS_KEY);

    }

}
