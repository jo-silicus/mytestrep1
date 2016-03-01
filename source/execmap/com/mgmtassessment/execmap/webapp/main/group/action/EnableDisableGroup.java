/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : barthwpr
 * @date : Aug 14, 2006
 * @version:
 * @history this class is used to enable disable a group
 *
 */

package com.mgmtassessment.execmap.webapp.main.group.action;

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
import com.mgmtassessment.execmap.webapp.main.group.form.GroupSearchForm;

/**.
 *  this class is used to enable disable a group
 *
 */

public class EnableDisableGroup extends ExecmapAction {
    /**
     * Implementation of inherited method from ExecmapAction, reposible for
     * executing the action to forward the user to add Group page.
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
     * @return Action to forward to the group search page
     * @throws Exception
     */
    private static Log log = LogFactory.getLog(EnableDisableGroup.class);

    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy servPrxy) throws Exception {
        GroupSearchForm groupSearchForm = (GroupSearchForm)
        form;

        /**
         * get the ServiceProxy to get the groupmanager and call the
         * enableDisableGroup
         */
        String accountId = (String)
        request.getParameter("companyAccountID");

        String grpId = (String)
        request.getParameter("groupID");

        groupSearchForm.setCompanyAccountID(accountId);

        boolean success = servPrxy.getGroupManager().enableDisableGroup(
                accountId, grpId);
        if (success) {
            return mapping.findForward(IConstants.SUCCESS);
        } else {
            return mapping.findForward(IConstants.FAILURE_KEY);
        }
    }

}
