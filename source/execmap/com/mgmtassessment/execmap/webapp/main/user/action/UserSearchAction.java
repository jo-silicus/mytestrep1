/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : sharmrahu
 * @date : Aug 18, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.webapp.main.user.action;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;
import com.mgmtassessment.execmap.common.exceptions.ExecmapSecurityBreachException;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.data.dao.types.CompanyAcctMaster;
import com.mgmtassessment.execmap.webapp.main.user.form.UserSearchForm;

/**
 * Implementation of <strong>Action</strong> that searches through the database
 * for the users matching the criteria.
 */
public class UserSearchAction
        extends ExecmapAction {
    /**
     * <p>
     * This <code>Action</code> fetches users matching the criteria.
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
     * @param usrContext
     *            The UserContext which provide details of User
     * @param servPrxy
     *            The ServiceProxy which creates bean to call business layer
     *            methods.
     * @return Action to forward to group Search page.
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

        UserSearchForm userSearchForm = (UserSearchForm) form;
        String pagernumber = userSearchForm
                .getUserPageCount();
        // check the page to be displayed
        if ((pagernumber == null)
                || (""
                        .equals(pagernumber))) {
            pagernumber = "0";
        }
        int page = Integer
                .parseInt(pagernumber);
        // retrives the matching string
        String matchUserID = userSearchForm
                .getSeachUserID();
        if ((matchUserID == null)
                || (""
                        .equals(matchUserID))) {
            matchUserID = null;
        }
        String companyAccountID = request
                .getParameter("companyAccountID");
        String groupAccountID = request
                .getParameter("groupID");
        if ((groupAccountID == null) || ("".equals(groupAccountID))) {
            groupAccountID = null;
        }
        if ((companyAccountID == null) || ("".equals(companyAccountID))) {
            companyAccountID = null;
        }
        boolean securityBreach=false;
        int roleID = usrContext
                .getUserInfo().getActivityRoleID();
        switch (roleID) {
            case IConstants.EXECMAP_COMPANY_USER_ROLE_ID:
            case IConstants.EXECMAP_GROUP_COORDINATOR_ROLE_ID:
                securityBreach=(groupAccountID!=null)&&(
                        securityBreach||!groupAccountID.equalsIgnoreCase(
                        usrContext.getUserInfo().getGroupId().trim()));
                groupAccountID = usrContext.getUserInfo().getGroupId().trim();
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
        userSearchForm
                .setMaxUserPageCount("0");
        userSearchForm
                .setUserPageCount("0");
        userSearchForm
                .setSelectedUser(null);
        userSearchForm
                .setUserCountFrom("0");
        userSearchForm
                .setUserCountTo("0");
        userSearchForm
                .setCompanyAccountID(companyAccountID);
        userSearchForm
                .setUsersGroupID(groupAccountID);
        // retrives the list accourding to the page and GroupID
        Map resultMap = servPrxy
                .getUserManager().getListOfUsers(
                        companyAccountID, groupAccountID, matchUserID, page);
        Collection searchResult = (Collection) resultMap
                .get("resultList");
        String maxPages = (String) resultMap
                .get("maxPages");
        userSearchForm
                .setUserList(searchResult);
        userSearchForm
                .setMaxUserPageCount(maxPages);
        userSearchForm
                .setUserPageCount(""
                        + (page + 1));
        userSearchForm
                .setSelectedUser(null);
        userSearchForm
                .setUserCountFrom(""
                        + (page * IConstants.SearchResultSize + 1));
        userSearchForm
                .setUserCountTo(""
                        + (page * IConstants.SearchResultSize + searchResult
                                .size()));
        CompanyAcctMaster companyAcctMaster = servPrxy
                .getCompanyManager().getAllDetailsOfCompany(
                        companyAccountID);

        userSearchForm
                .setGroupdetails(companyAcctMaster
                        .getCoGrpMas());
        return mapping
                .findForward(IConstants.SUCCESS);
    }

}
