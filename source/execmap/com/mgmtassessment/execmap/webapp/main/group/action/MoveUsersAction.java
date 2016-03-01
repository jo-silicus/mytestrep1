/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : sharmrahu
 * @date : Aug 30, 2006
 * @version:
 *
 * @history Description Reference Name Date
 *
 */

package com.mgmtassessment.execmap.webapp.main.group.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.exceptions.DataMoveException;
import com.mgmtassessment.execmap.common.exceptions.ExecmapSecurityBreachException;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.group.form.GroupAccountForm;

/**
 * Implementation of <strong>Action</strong> that moves the users of one group
 * to another group.
 *
 */

public class MoveUsersAction extends ExecmapAction {
    /**
     * Implementation of inherited method from ExecmapAction, reposible for
     * executing the action to move users of a group.
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
     * @exception DataMoveException
     *                if there is some error in updating the data.
     * @exception ExecmapSecurityBreachException
     *                if there is a security breach.
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy servPrxy)
           throws DataMoveException, ExecmapSecurityBreachException {
        String companyAccountID = request.getParameter("companyAccountID");
        String fromGroupAccountID = request.getParameter("fromGroupID");
        String toGroupAccountID = request.getParameter("toGroupID");

        int roleID = usrContext.getUserInfo().getActivityRoleID();
        if ((fromGroupAccountID == null) || ("".equals(fromGroupAccountID))) {
            fromGroupAccountID = null;
        }
        if ((companyAccountID == null) || ("".equals(companyAccountID))) {
            companyAccountID = null;
        }
        boolean securityBreach=false;
        switch (roleID) {
            case IConstants.EXECMAP_COMPANY_USER_ROLE_ID:
            case IConstants.EXECMAP_GROUP_COORDINATOR_ROLE_ID:
                securityBreach=(fromGroupAccountID!=null)&&(
                        securityBreach||!fromGroupAccountID.equalsIgnoreCase(
                        usrContext.getUserInfo().getGroupId().trim()));
                fromGroupAccountID = usrContext.getUserInfo(
                        ).getGroupId().trim();
            case IConstants.EXECMAP_SUPERVISOR_ROLE_ID:
                securityBreach=(companyAccountID!=null)&&(securityBreach||
                !companyAccountID.equalsIgnoreCase(
                        usrContext.getUserInfo().getAccountId()));
                companyAccountID = usrContext.getUserInfo().getAccountId();
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
        servPrxy.getGroupManager().moveUsers(companyAccountID,
                fromGroupAccountID, toGroupAccountID);
        ((GroupAccountForm) form).setCompanyAccountID(companyAccountID);
        return mapping.findForward(IConstants.SUCCESS);
    }

}
