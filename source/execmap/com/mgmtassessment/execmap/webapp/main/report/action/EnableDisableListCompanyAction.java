/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : goenkani
 * @date : Aug 11, 2006
 * @version:
 * @history This class is responsible for populating the Action form by getting
 *          data from manager class.
 */

package com.mgmtassessment.execmap.webapp.main.report.action;

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
import com.mgmtassessment.execmap.webapp.main.report.form.
                                    EnableCompaniesListForm;

/**
 * Action class for Enable and Disable List of Companies. This class is
 * responsible for populating the EnableCompaniesListForm by getting data
 * from the ReportManagerFacade interface.
 */

public class EnableDisableListCompanyAction extends ExecmapAction {
    /**
     * logger for EnableDisableListCompanyAction class.
     */
    private static Log log = LogFactory
                  .getLog(EnableDisableListCompanyAction.class);

    /**
     * @param mapping
     *            The ActionMapping used to select this instance.
     * @param form
     *            The optional ActionForm bean for this request (if any).
     * @param request
     *            The HTTP request we are processing.
     * @param response
     *            The HTTP response we are creating.
     * @param usrContext
     *            The UserContext which provide details of User
     * @param serviceProxy
     *            The ServiceProxy which creates bean to call business layer
     *            methods.
     * @return Action to forward to EnableCompaniesList.jsp
     * @exception java.lang.Exception
     *                if an input/output error or servlet exception occurs.
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy serviceProxy)
            throws Exception {

        String repPath = request.getSession().getServletContext().getRealPath(
                "\\html\\reports");
        String status = request.getParameter("status");
        EnableCompaniesListForm companiesListForm =
                                    (EnableCompaniesListForm) form;
        populateForm(serviceProxy.getReportManager()
                .getListofEnableOrDisableCompanies(repPath,
                        status),
                companiesListForm);

        /**
         * TODO connect to the persistence layer to extract the list of enable
         * companies and return principal to the session. For now let the
         * control go to the admin screen.
         */

        return mapping.findForward(IConstants.SUCCESS_KEY);
    }

    /**
     * @param companiesList
     *            Contains a list of companies.
     * @param companiesListForm
     *            Action form which is to be populated for displaying companies
     *            on jsp. It populates the corresponding Action form.
     * @return
     */
    private void populateForm(List companiesList,
            EnableCompaniesListForm companiesListForm) {
        log.info("Populates the list into EnableCompaniesListForm by"
                 + " getting data from database.");
        companiesListForm.setEnableCompanies(companiesList);
    }
}