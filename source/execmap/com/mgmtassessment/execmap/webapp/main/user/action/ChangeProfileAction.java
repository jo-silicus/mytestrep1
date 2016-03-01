/**
 *  @Copyright Management Assessment Partners (MAP) AG
 *  All Rights Reserved.
 *
 *  @author : barthwpr
 *  @date   : Aug 24, 2006
 *  @version:
 *
 *  @history this class is used to show
 *  user details for change profile action
 *
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

/**.
 * this class is used to show user details for change profile action
 *
 */

public class ChangeProfileAction extends ExecmapAction {
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
     * @return Action to forward to change profile page
     * @throws Exception
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy servPrxy) throws Exception {

        UserAccountModel searchUser = new UserAccountModel();
        String accountId = usrContext.getUserInfo().getAccountId();
        String userId = usrContext.getUserInfo().getLogonUserId();

        searchUser.setUserCompanyAccountID(accountId);
        searchUser.setUserID(userId);

        searchUser = servPrxy.getUserManager().retriveCompanyUser(searchUser);
        ((UserAccountForm)form)
        .populateForm(searchUser);
        return mapping.findForward(IConstants.SUCCESS_KEY);

    }

}
