/**
 *  @Copyright Management Assessment Partners (MAP) AG
 *  All Rights Reserved.
 *
 *  @author : barthwpr
 *  @date   : Sep 11, 2006
 *  @version:
 *
 *  @history
 * this class is used to open role based help for user
 *
 */

package com.mgmtassessment.execmap.webapp.main.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;

/**.
 * this class is used to open role based help for user
 *
 */

public class Help extends ExecmapAction {
    /**
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @param usrContext
     * @param servPrxy
     *
     * Implementation of inherited method from ExecmapAction, reposible for
     * executing the action to toggle the group status.
     * @return ActionForward
     */
    private static Log log = LogFactory.getLog(Help.class);

    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy servPrxy) throws Exception {

        String roleId = usrContext.getUserInfo().getActivityRoleID().toString();
        String forwardName = IConstants.FAILURE_KEY;
        if (roleId.equals(""+IConstants.EXECMAP_ADMIN_ROLE_ID)) {
            forwardName = "global";
        } else if (roleId.equals(""+IConstants.EXECMAP_SUPERVISOR_ROLE_ID ))
        {
            forwardName = "company";

        } else if
        (roleId.equals(""+IConstants.EXECMAP_GROUP_COORDINATOR_ROLE_ID)) {
            forwardName = "group";
        } else if (roleId.equals(""+IConstants.EXECMAP_COMPANY_USER_ROLE_ID)) {
            forwardName = "user";
        }
        return mapping.findForward(forwardName);

    }

}
