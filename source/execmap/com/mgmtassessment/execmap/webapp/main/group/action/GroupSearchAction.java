/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : sharmrahu
 * @date : Aug 18, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.webapp.main.group.action;

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
import com.mgmtassessment.execmap.webapp.main.group.form.GroupSearchForm;

/**
 * Implementation of <strong>Action</strong> that searches through the database
 * for the groups matching the criteria.
 */
public class GroupSearchAction extends ExecmapAction {
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
     *
     * @return Action to forward to group Search page.
     * @exception DataNotFoundException
     *                if nothing matching is found.
     * @exception ExecmapSecurityBreachException
     *                if there is a security breach.
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy servPrxy
            ) throws DataNotFoundException,ExecmapSecurityBreachException {

        GroupSearchForm groupSearchForm = (GroupSearchForm) form;
        String pagernumber = groupSearchForm.getGroupPageCount();
        // check the page to be displayed
        if ((pagernumber == null) || ("".equals(pagernumber))) {
            pagernumber = "0";
        }
        int page = Integer.parseInt(pagernumber);
        // retrives the matching string
        String matchGroupID = groupSearchForm.getSeachGroupID();
        if ((matchGroupID == null) || ("".equals(matchGroupID))) {
            matchGroupID = null;
        }

        boolean securityBreach=false;
        String companyAccountID = request.getParameter("companyAccountID");
        if ((companyAccountID == null) || ("".equals(companyAccountID))) {
            companyAccountID = null;
        }
        int roleID = usrContext.getUserInfo().getActivityRoleID();
        switch (roleID) {
            case IConstants.EXECMAP_COMPANY_USER_ROLE_ID:
            case IConstants.EXECMAP_GROUP_COORDINATOR_ROLE_ID:
                securityBreach=(matchGroupID!=null)&&(
                        securityBreach||!matchGroupID.equalsIgnoreCase(
                        usrContext.getUserInfo().getGroupId().trim()));
                matchGroupID = usrContext.getUserInfo().getGroupId().trim();
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
        // retrives the list accourding to the page and GroupID
        Collection searchResult = null;
        Map returnedData = null;
        groupSearchForm.setGroupCountFrom("0");
        groupSearchForm.setGroupCountTo("0");
        groupSearchForm.setMaxGroupPageCount("0");

        groupSearchForm.setGroupList(searchResult);
        groupSearchForm.setGroupPageCount("" + (page + 1));
        groupSearchForm.setSelectedGroup(null);

        groupSearchForm.setCompanyAccountID(companyAccountID);
        returnedData = servPrxy.getGroupManager().getListOfGroups(
                companyAccountID, matchGroupID, page);
        searchResult = (Collection) returnedData.get("resultList");
        groupSearchForm.setGroupCountFrom("" + (page * IConstants.SearchResultSize + 1));
        groupSearchForm.setGroupCountTo("" + (page * IConstants.SearchResultSize + searchResult.size()));
        groupSearchForm.setTotalGroupList((Collection) returnedData
                .get("fullList"));
        groupSearchForm.setMaxGroupPageCount((String) returnedData
                .get("maxPages"));

        groupSearchForm.setGroupList(searchResult);
        groupSearchForm.setGroupPageCount("" + (page + 1));
        groupSearchForm.setSelectedGroup(null);

        groupSearchForm.setCompanyAccountID(companyAccountID);
        return mapping.findForward(IConstants.SUCCESS);
    }

}
