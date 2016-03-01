/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : DasAshim
 * @date : Jul 18, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.webapp.main.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.business.model.GlobalSettingsModel;
import com.mgmtassessment.execmap.business.model.LoginModel;
import com.mgmtassessment.execmap.business.model.UserAccountModel;
import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.common.util.webapp.UserLoginInfo;
import com.mgmtassessment.execmap.webapp.main.login.form.LoginForm;

/**
 * Implementation of <strong>Action</strong> that changes the user's
 * {@link java.util.Locale} and forwards to a page, based on request level
 * parameters that are set (language).
 */

public class LoginAction extends ExecmapAction {

    private static Log log = LogFactory.getLog(LoginAction.class);

    /**
     * <p>
     * The user's based on {@link ActionForm} properties.
     * </p>
     * <p>
     * This <code>Action</code> looks for <code>loginForm</code> and
     * properties on the given form,
     * <p>
     *
     * @param mapping
     *            The ActionMapping used to select this instance
     * @param form
     *            The optional ActionForm bean for this request (if any)
     * @param request
     *            The HTTP request we are processing
     * @param response
     *            The HTTP response we are creating
     * @return Action to forward to
     * @exception java.lang.Exception
     *                if an input/output error or servlet exception occurs
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy serviceProxy) throws Exception {

        // Extract attributes we will need
        HttpSession session = request.getSession();

        LoginForm loginFrm = (LoginForm)
        form;
        String loginId = loginFrm.getUserid();
        String acctId = loginFrm.getAcctid();
        String password = loginFrm.getPassword();
        boolean accountStatus = false;
        String adminAccountId;
        Integer applicationCounter = (Integer)
        session.getAttribute("applicationCounter");
        if (applicationCounter == null) {
            applicationCounter = new Integer(0);
        } else {
            applicationCounter = new Integer(applicationCounter.intValue() + 1);
        }
        session.setAttribute("applicationCounter", applicationCounter);
        /**
         * get the ServiceProxy, get the Login Service Facade from it and invoke
         * the relevent methods. TODO implement this.
         */
        GlobalSettingsModel globalSettingsModel = serviceProxy
                .getGlobalSettingManager().getGlobalSetting();

        adminAccountId = globalSettingsModel.getIntlcAcctId();
        if (!adminAccountId.equals(acctId)) {
            accountStatus =

            serviceProxy.getLoginManager().accountLockStatus(acctId, loginId);
        }
        if (accountStatus) {

            int countValue = applicationCounter.intValue();

            serviceProxy.getLoginManager().updateAccountLock(acctId, loginId,
                    countValue);

        }

        LoginModel loginModel = serviceProxy.getLoginManager()
                .validateLoginUser(acctId, loginId, password);
        if (!adminAccountId.equals(acctId)) {
            serviceProxy.getLoginManager()
                    .updateAccountLock(acctId, loginId, 0);
        }
        UserLoginInfo userLoginInfo = new UserLoginInfo();
        userLoginInfo.setLogonUserId(loginModel.getUserid());
        userLoginInfo.setAccountId(loginModel.getAcctid());
        userLoginInfo.setActivityRoleID(new Byte(loginModel.getRoleId()));
        if (!userLoginInfo.getAccountId().equals(adminAccountId)) {
            userLoginInfo.setReportId(serviceProxy.getLoginManager().
                                        getReportId(loginModel.getAcctid()));
        } else {
            userLoginInfo.setReportId(new Byte("0"));
        }
        if (!(loginModel.getRoleId()).equals(""
                + IConstants.EXECMAP_ADMIN_ROLE_ID)) {
            UserAccountModel findUser = new UserAccountModel();
            findUser.setUserCompanyAccountID(loginFrm.getAcctid());
            findUser.setUserID(loginFrm.getUserid());
            findUser = serviceProxy.getUserManager().retriveUser(findUser);
            userLoginInfo.setGroupId(findUser.getUserGroupID());
        }
        usrContext.setUserInfo(userLoginInfo);

        /**
         * connect to the persistence layer to extract the uid , pwd and acct id
         * and make a hash of both to verify pwd and return principal to the
         * session. For now let the control go to the admin screen.
         */

        return mapping.findForward(IConstants.SUCCESS_KEY);

    }
}
