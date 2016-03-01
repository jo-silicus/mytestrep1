/**
 *  @Copyright Management Assessment Partners (MAP) AG
 *  All Rights Reserved.
 *
 *  @author : barthwpr
 *  @date   : Aug 19, 2006
 *  @version:
 *
 *  @history this class is used to move a selected user to another group
 *  Description         Reference       Name        Date
 *
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
import com.mgmtassessment.execmap.webapp.main.user.form.UserSearchForm;

/**.
 *  this class is used to move a selected user to another group
 */

public class MoveUserAction extends ExecmapAction {
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
     * @return Action to forward to user search page
     * @throws Exception
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy servPrxy) throws Exception {
        UserSearchForm userSearchForm = (UserSearchForm) form;

        String accountId = request.getParameter("companyAccountID");
        String grpId = request.getParameter("groupID");
        String selectedGroupId = request.getParameter("groupIDSelected");
        String usrId = request.getParameter("userID");
        userSearchForm.setCompanyAccountID(accountId);
        userSearchForm.setUsersGroupID(grpId);
        /**
         * get the ServiceProxy to get the usermanager and call the moveUser
         * method
         */

        servPrxy.getUserManager().moveUser(accountId, usrId, grpId,
                selectedGroupId);

        return mapping.findForward(IConstants.SUCCESS);

    }

}
