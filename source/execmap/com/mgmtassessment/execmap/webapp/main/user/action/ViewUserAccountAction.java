/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : sharmrahu
 * @date : Aug 14, 2006
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
import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;
import com.mgmtassessment.execmap.common.exceptions.ExecmapSecurityBreachException;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.user.form.UserAccountForm;

/**
 * The class is implementation of <strong>Action</strong> that is responsible
 * to retrive the details of a particular user.
 */
public class ViewUserAccountAction
        extends ExecmapAction {

    /**
     * Implementation of inherited method from ExecmapAction, reposible for
     * executing the action to retrive the details of a particular user.
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
     * @return Action to forward to view/edit user page.
     * @exception DataNotFoundException
     *                if nothing matching is found.
     * @exception ExecmapSecurityBreachException
     *                if there is a security breach.
     */
    public ActionForward executeAction(
            ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response, UserContext usrContext,
            ServiceProxy servPrxy)
            throws DataNotFoundException, ExecmapSecurityBreachException {

        UserAccountModel findUser = new UserAccountModel();
        // Setting the required details
        String accountId = (String) request
                .getParameter("companyAccountID");
        String groupId = (String) request
                .getParameter("groupID");
        String userId = (String) request
                .getParameter("userID");
        if ((accountId == null) || ("".equals(accountId))) {
            accountId = null;
        }
        if ((groupId == null) || ("".equals(groupId))) {
            groupId = null;
        }
        if ((userId == null) || ("".equals(userId))) {
            userId = null;
        }
        boolean securityBreach=false;
        int roleID = usrContext
                .getUserInfo().getActivityRoleID();
        switch (roleID) {
            case IConstants.EXECMAP_COMPANY_USER_ROLE_ID:
                securityBreach=(userId!=null)&&(
                        securityBreach||!userId.equalsIgnoreCase(
                        usrContext.getUserInfo().getLogonUserId().trim()));
                userId = usrContext.getUserInfo().getLogonUserId().trim();
            case IConstants.EXECMAP_GROUP_COORDINATOR_ROLE_ID:
                securityBreach=(groupId!=null)&&(
                        securityBreach||!groupId.equalsIgnoreCase(
                        usrContext.getUserInfo().getGroupId().trim()));
                groupId = usrContext.getUserInfo().getGroupId().trim();
            case IConstants.EXECMAP_SUPERVISOR_ROLE_ID:
                securityBreach=(accountId!=null)&&(securityBreach||
                !accountId.equalsIgnoreCase(
                        usrContext.getUserInfo().getAccountId()));
                accountId = usrContext.getUserInfo().getAccountId();
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
        findUser
                .setUserCompanyAccountID(accountId);
        findUser
                .setUserGroupID(groupId);
        findUser
                .setUserID(userId);

        findUser = servPrxy
                .getUserManager().retriveUser(
                        findUser);

        ((UserAccountForm) form)
                .populateForm(findUser);
        return mapping
                .findForward(IConstants.SUCCESS_KEY);
    }

}
