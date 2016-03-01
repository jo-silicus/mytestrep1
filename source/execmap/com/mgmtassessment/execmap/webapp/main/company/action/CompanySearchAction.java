/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : sharmrahu
 * @date : Aug 17, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.webapp.main.company.action;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.company.form.CompanySearchForm;

/**
 * Implementation of <strong>Action</strong> that searches through the database
 * for the companies matching the criteria.
 */
public class CompanySearchAction extends ExecmapAction {
    /**
     * <p>
     * This <code>Action</code> fetches companies matching the creteria.
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
     * @return Action to forward to company Search page.
     * @exception DataNotFoundException
     *                if nothing matching is found.
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy servPrxy)
            throws DataNotFoundException {

        CompanySearchForm companySearchForm = (CompanySearchForm) form;
        String pagernumber = companySearchForm.getPageCount();
        // check the page to be displayed
        if ((pagernumber == null) || ("".equals(pagernumber))) {
            pagernumber = "0";
        }
        int page = Integer.parseInt(pagernumber);
        // retrives the list accourding to the page
        Collection searchResult = null;
        String companyAccountID = null;
        int roleID = usrContext.getUserInfo().getActivityRoleID();
        switch (roleID) {
            case IConstants.EXECMAP_COMPANY_USER_ROLE_ID:
            case IConstants.EXECMAP_GROUP_COORDINATOR_ROLE_ID:
            case IConstants.EXECMAP_SUPERVISOR_ROLE_ID:
                companyAccountID = usrContext.getUserInfo().getAccountId();

            case IConstants.EXECMAP_ADMIN_ROLE_ID:
                break;

            default:
                break;
        }
        companySearchForm.setCompanyCountFrom("0");
        companySearchForm.setCompanyCountTo("0");
        companySearchForm.setPageCount("0");
        companySearchForm.setMaxCompanyPageCount("0");
        Map resultMap = servPrxy.getCompanyManager()
                .getListOfCompanies(companySearchForm.getSeachCompanyName(),
                        companyAccountID, page);

        searchResult = (Collection) resultMap.get("resultList");
        companySearchForm.setCompanyCountTo(""
                + (page * IConstants.SearchResultSize + searchResult.size()));
        companySearchForm.setCompanyCountFrom("" + (page * IConstants.SearchResultSize + 1));
        companySearchForm.setMaxCompanyPageCount((String) resultMap
                .get("maxPages"));

        companySearchForm.setCompanyList(searchResult);
        companySearchForm.setPageCount("" + (page + 1));
        companySearchForm.setSelectedCompany(null);
        return mapping.findForward(IConstants.SUCCESS);
    }
}
