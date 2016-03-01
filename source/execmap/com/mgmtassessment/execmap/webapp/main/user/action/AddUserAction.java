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

import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.user.form.UserAccountForm;

/**
 * Implementation of <strong>Action</strong> that forwards to the page were
 * user can add a user.
 */

public class AddUserAction
        extends ExecmapAction {
    /**
     * Implementation of inherited method from ExecmapAction, reposible for
     * executing the action to forward the user to add user page.
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
     * @return Action to forward to add user page.
     */
    public ActionForward executeAction(
            ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response, UserContext usrContext,
            ServiceProxy servPrxy) {
        String accountId = (String) request
                .getParameter("companyAccountID");
        ((UserAccountForm) form)
                .setUserCompanyAccountID(accountId);
        String groupId = (String) request
                .getParameter("groupId");
        ((UserAccountForm) form)
                .setUserGroupID(groupId);
        int roleID = usrContext
                .getUserInfo().getActivityRoleID();
        switch (roleID) {
            case IConstants.EXECMAP_COMPANY_USER_ROLE_ID:
            case IConstants.EXECMAP_GROUP_COORDINATOR_ROLE_ID:
                groupId = usrContext
                        .getUserInfo().getGroupId();
            case IConstants.EXECMAP_SUPERVISOR_ROLE_ID:
                accountId = usrContext
                        .getUserInfo().getAccountId();

            case IConstants.EXECMAP_ADMIN_ROLE_ID:
                break;

            default:
                break;
        }

        return mapping
                .findForward(IConstants.SUCCESS);
    }

}
