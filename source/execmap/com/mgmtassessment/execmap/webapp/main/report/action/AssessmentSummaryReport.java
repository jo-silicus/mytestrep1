/**
 *  @Copyright Management Assessment Partners (MAP) AG.
 *  All Rights Reserved.
 *
 *  @author : singhrau
 *  @date   : Aug 10, 2006
 *  @version:
 *
 *  @history
 *  Description         Reference       Name        Date
 *
 */

package com.mgmtassessment.execmap.webapp.main.report.action;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.exceptions.
                                                ExecmapSecurityBreachException;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.report.form.AssessmentSummaryForm;

/**
 * Action class for Assessment Summary Report. This class is
 * responsible for populating the Action form by getting data from manager
 * class.
 */

public class AssessmentSummaryReport extends ExecmapAction {
    /**
     * logger for EnableDisableListCompanyAction class.
     */
    private static Log log = LogFactory
                  .getLog(AssessmentSummaryReport.class);
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
     * @return Action to forward to EnableCompaniesList.jsp
     * @exception java.lang.Exception
     *                if an input/output error or servlet exception occurs.
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response,
        UserContext usrContext, ServiceProxy servPrxy)
        throws Exception {
        AssessmentSummaryForm assessmentSummaryForm = (AssessmentSummaryForm)
                                                                           form;

        String acctid = request.getParameter("acctId");
        String grpid = request.getParameter("grpId");
        int roleID = usrContext.getUserInfo().getActivityRoleID();
        switch (roleID) {
            case IConstants.EXECMAP_GROUP_COORDINATOR_ROLE_ID:
                if (!(usrContext.getUserInfo().getGroupId().equals(grpid))) {
                    throw new ExecmapSecurityBreachException();
                }
            case IConstants.EXECMAP_SUPERVISOR_ROLE_ID:
                if (!acctid.equals(usrContext.getUserInfo().getAccountId())) {
                    throw new ExecmapSecurityBreachException();
                }
            default:
                break;
        }
        String repPath = request.getSession().getServletContext()
                         .getRealPath("\\html\\reports");
        List assessmentSummaryDetails = servPrxy.getReportManager().
        getAssessmentSummaryReport(repPath, acctid, grpid);
        Iterator itr = assessmentSummaryDetails.iterator();
        if (!itr.hasNext()) {
           assessmentSummaryForm.setCheck(IConstants.PARAM_VAL_FALSE);
        }
        assessmentSummaryForm.setAcctId(acctid);
        assessmentSummaryForm.setGrpId(grpid);
        assessmentSummaryForm.setAssessmentSummaryDetails(
               assessmentSummaryDetails);
        log.info("Assessment report for group with accountid " + acctid
                + " & group id " + grpid + " is generated");
        return mapping.findForward("success");
    }

}
