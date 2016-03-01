/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : kumarra
 * @date : Aug 2, 2006
 * @version:
 *
 */

package com.mgmtassessment.execmap.webapp.main.report.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.business.model.ReportModel;
import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.exceptions.ExecmapSecurityBreachException;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.report.form.GeneralReportsForm;

/**
 * Implementation of action that generates General Individual report,Leadership
 * A report, Leadership E report and Execmap Executive Summary report.
 *
 */

public class GeneralReportsAction extends ExecmapAction {
    /**
     * logger for EnableDisableListCompanyAction class.
     */
    private static Log log = LogFactory
                  .getLog(GeneralReportsAction.class);
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
     * @param servPrxy
     *            The ServiceProxy which creates bean to call business layer
     *            methods.
     * @return Action to forward to Reports.jsp
     * @exception java.lang.Exception
     *                if an input/output error or servlet exception occurs.
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy servPrxy)
            throws Exception {

        GeneralReportsForm generalReportsForm = (GeneralReportsForm)
                                                         form;
        String accountid = request.getParameter("acctId");
        String userid = request.getParameter("usrId");
        int roleID = usrContext.getUserInfo().getActivityRoleID();
        switch (roleID) {
            case IConstants.EXECMAP_GROUP_COORDINATOR_ROLE_ID:
                String usrCntxtGrpId = usrContext.getUserInfo().getGroupId();
                String grpId = servPrxy.getReportManager().getGrpId(
                        usrContext.getUserInfo().getAccountId(), userid);
                if (!usrCntxtGrpId.equals(grpId)) {
                    throw new ExecmapSecurityBreachException();
                }
            case IConstants.EXECMAP_SUPERVISOR_ROLE_ID:
               if (!accountid.equals(usrContext.getUserInfo().getAccountId())) {
                    throw new ExecmapSecurityBreachException();
                }
                accountid = usrContext.getUserInfo().getAccountId();
            default:
                break;
        }
        String report = null;
        String repPath = request.getSession().getServletContext()
        .getRealPath("\\html\\reports");
        String imgPath = request.getSession().getServletContext()
        .getRealPath(IConstants.IMAGES_PATH);
        ReportModel reportModel = populateModel(request);
        generalReportsForm.setRptId(reportModel.getRptId());
        report = servPrxy.getReportManager().getReport(accountid, userid,
                reportModel, repPath, imgPath);
        if (report != null) {
            generalReportsForm.setFileName(report);
        }
        log.info("Report with report id " + reportModel.getRptId() + " is "
                + "generated for user with accountid " + accountid + "& userId"
                + userid);
        return (mapping.findForward(IConstants.SUCCESS_KEY));
    }

    /**
     * @param request to get rptId from the url.
     * @return reportModel
     */
    private ReportModel populateModel(HttpServletRequest request) {
        ReportModel reportModel = new ReportModel();
        reportModel.setLocale(Locale.ENGLISH);
        reportModel.setRptId(request.getParameter("rptId"));
        return reportModel;
    }
}