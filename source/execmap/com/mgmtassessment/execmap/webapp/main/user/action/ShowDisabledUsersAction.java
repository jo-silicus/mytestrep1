/**
 *  @Copyright Management Assessment Partners (MAP) AG
 *  All Rights Reserved.
 *
 *  @author : barthwpr
 *  @date   : Aug 26, 2006
 *  @version:
 *
 *  @history  this class is used to populate a
 * list of disabled users belonging to
 * group
 *  Description         Reference       Name        Date
 *
 */

package com.mgmtassessment.execmap.webapp.main.user.action;

import java.util.ArrayList;
import java.util.List;

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
import com.mgmtassessment.execmap.webapp.main.user.form.ShowDisabledUsersForm;

/**.
 * this class is used to populate a
 * list of disabled users belonging to
 * group
 *
 */

public class ShowDisabledUsersAction extends ExecmapAction {
    private static Log log = LogFactory.getLog(ShowDisabledUsersAction.class);

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
     * @return Action to forward to delete disabled users  page
     * @throws Exception
     */

    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy servPrxy) throws Exception {

        ShowDisabledUsersForm showDisabledUsersForm
        = (ShowDisabledUsersForm)
        form;
        List listOfDisabledUsers = new ArrayList();
        String accountId = request.getParameter("companyAccountID");
        String groupId = request.getParameter("groupID");

        /**
         * get the ServiceProxy to get the usermanager and call the
         * deleteDisableUser method
         */
        listOfDisabledUsers = servPrxy.getUserManager().deleteDisableUser(
                accountId, groupId);
        showDisabledUsersForm.setListOfDisabledUsers(listOfDisabledUsers);
        return mapping.findForward(IConstants.SUCCESS_KEY);

    }
}
