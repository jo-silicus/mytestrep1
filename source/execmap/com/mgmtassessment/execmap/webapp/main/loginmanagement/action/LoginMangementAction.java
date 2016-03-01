/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : singhrau
 * @date : Sep 14, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.webapp.main.loginmanagement.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.loginmanagement.form.LoginManagementForm;

/**
 * This action class retrieves users whose accounts are locked.
 */

public class LoginMangementAction extends ExecmapAction {

    /*
     * (non-Javadoc)
     * @see com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction#
     * executeAction(org.apache.struts.action.ActionMapping,
     *      org.apache.struts.action.ActionForm,
     *      javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse,
     *      com.mgmtassessment.execmap.common.util.webapp.UserContext,
     *      com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy)
     */
    /**
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @param usrContext
     * @param servPrxy
     * @return success if executed successfully
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy servPrxy) throws Exception {

        LoginManagementForm loginmanagementform = (LoginManagementForm)
                                                                       form;

        if (loginmanagementform.getSelectedCheckboxes() != null) {
            for (int i = 0; i < loginmanagementform.getSelectedCheckboxes().
                                                                length; i++) {
                String accountId = loginmanagementform.getSelectedCheckboxes()
                                                           [i].substring(0, 10);
                String userId = loginmanagementform.getSelectedCheckboxes()[i].
                                                                  substring(10);
                servPrxy.getLoginManagementFacade().UnlockUser(accountId,
                        userId);
            }
        }
        String acctId = usrContext.getUserInfo().getAccountId();
        String grpId = usrContext.getUserInfo().getGroupId();
        String usrId = usrContext.getUserInfo().getLogonUserId();
        String actvRollId = usrContext.getUserInfo().getActivityRoleID()
                .toString();

        List lockedUsers = servPrxy.getLoginManagementFacade().getLockedUsers(
                actvRollId, acctId, grpId, usrId);
        loginmanagementform.setLockedUsers(lockedUsers);

        return mapping.findForward(IConstants.SUCCESS_KEY);
    }

}
