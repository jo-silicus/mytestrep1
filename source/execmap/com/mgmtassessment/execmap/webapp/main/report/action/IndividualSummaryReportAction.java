/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : goenkani
 * @date : Jul 25, 2006
 * @history This class is responsible for populating the Action form by getting
 *          data from the Manager class.
 */

package com.mgmtassessment.execmap.webapp.main.report.action;

import java.util.HashMap;
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
import com.mgmtassessment.execmap.webapp.main.report.form.
                             IndividualSummaryReportForm;

/**
 * Action class populates the test score into the
 * IndividualSummaryReportForm by getting details from the
 * ReportManagerFacade interface.
 */
public class IndividualSummaryReportAction extends ExecmapAction {

    /**
     * logger for IndividualSummaryReportAction class.
     */
    private static Log log = LogFactory
                                   .getLog(IndividualSummaryReportAction.class);

    /**
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request (if any).
     * @param request The HTTP request we are processing.
     * @param response The HTTP response we are creating.
     * @param usrContext The UserContext which provide details of User
     * @param serviceProxy The ServiceProxy which creates bean to call business
     *        layer methods.
     * @return Action to forward to IndividualScoreReport.jsp
     * @exception java.lang.Exception if an input/output error or servlet
     *            exception occurs.
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy serviceProxy)
            throws Exception {

        String accountid = request.getParameter("acctId");
        String userid = request.getParameter("usrId");
        int roleID = usrContext.getUserInfo().getActivityRoleID();
        switch (roleID) {
            case IConstants.EXECMAP_GROUP_COORDINATOR_ROLE_ID:
                String usrCntxtGrpId = usrContext.getUserInfo().getGroupId();
                String grpId = serviceProxy.getReportManager().getGrpId(
                        usrContext.getUserInfo().getAccountId(), userid);
                if (!usrCntxtGrpId.equals(grpId)) {
                    throw new ExecmapSecurityBreachException();
                }
            case IConstants.EXECMAP_SUPERVISOR_ROLE_ID:
                if (!accountid.equals(usrContext.getUserInfo()
                        .getAccountId())) {
                    throw new ExecmapSecurityBreachException();
                }
            default:
                break;
        }
        String repPath = request.getSession().getServletContext().getRealPath(
                "\\html\\reports");
        IndividualSummaryReportForm individualSummaryReportForm =
                           (IndividualSummaryReportForm)
                                                   form;
        populateForm(
                serviceProxy.getReportManager()
                        .getIndividualUserTestSessionDetails(repPath,
                        accountid, userid), individualSummaryReportForm);
        individualSummaryReportForm.setAcctid(accountid);
        individualSummaryReportForm.setUserid(userid);
        /**
         * TODO connect to the persistence layer to extract the scores in all
         * tests for an individual user and return principal to the session.
         */
        return mapping.findForward(IConstants.SUCCESS_KEY);
    }

    /**
     * @param userDetails Contains all the test details for a particular user.
     * @param individualSummaryReportForm Action form which is to be populated
     *        for Individual Summary Report. This function populates values in
     *        the corresponding Action form.
     */
    private void populateForm(List userDetails,
            IndividualSummaryReportForm individualSummaryReportForm) {
        individualSummaryReportForm.setUserScoreDetails(userDetails);
        Iterator iterator = userDetails.iterator();
        log.info("Populates the list into IndividualSummaryReportForm by"
                 + " getting data from database.");
        if (iterator.hasNext()) {
            HashMap hashmap = (HashMap)
                                   iterator.next();
            individualSummaryReportForm.setSessId("" + hashmap.get("ses_id"));
            individualSummaryReportForm.setCompFlag(""
                    + hashmap.get("comp_flg"));
        } else {
            individualSummaryReportForm.setCheck("false");
        }
    }
}