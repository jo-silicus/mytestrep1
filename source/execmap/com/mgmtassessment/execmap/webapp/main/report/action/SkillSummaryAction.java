/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : goenkani
 * @date : Jul 25, 2006
 * @history
 */

package com.mgmtassessment.execmap.webapp.main.report.action;

import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.business.model.SkillSummaryReportModel;
import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.exceptions.
                                                ExecmapSecurityBreachException;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.report.form.SkillSummaryForm;

/**
 * This class is responsible for populating the Action form by getting data from
 * the Manager class.
 */
public class SkillSummaryAction extends ExecmapAction {

    /**
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
     * @param serviceProxy
     *            The ServiceProxy which creates bean to call business layer
     *            methods.
     * @return Action to forward to SkillSummary.jsp
     * @exception java.lang.Exception
     *                if an input/output error or servlet exception occurs
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy serviceProxy)
            throws Exception {

        /**
         * Extract attributes we will need. TODO move this up to ExecmapAction
         */
        String repPath = request.getSession().getServletContext().getRealPath(
                "\\html\\reports");
        String sort = (String)
                              request.getParameter("sort");
        SkillSummaryForm skillSummaryForm = (SkillSummaryForm)
                                                              form;
        String accountId = request.getParameter("acctId");
        String grpId = request.getParameter("grpId");
        int roleID = usrContext.getUserInfo().getActivityRoleID();
        switch (roleID) {
            case IConstants.EXECMAP_GROUP_COORDINATOR_ROLE_ID:
                if (!(usrContext.getUserInfo().getGroupId().equals(grpId))) {
                    throw new ExecmapSecurityBreachException();
                }
            case IConstants.EXECMAP_SUPERVISOR_ROLE_ID:
               if (!accountId.equals(usrContext.getUserInfo().getAccountId())) {
                    throw new ExecmapSecurityBreachException();
                }
            default:
                break;
        }
        skillSummaryForm.setAcctId(accountId);
        skillSummaryForm.setGrpId(grpId);
        String[] skills;
        skills = skillSummaryForm.getSkills();
        String url = "";
        if (sort == null) {
            for (int i = 0; i < skills.length; i++) {
                url = url + "" + skills[i] + "a";
            }
            populateForm(serviceProxy.getReportManager().getSkillSummary(
                    repPath, accountId, grpId, skills), skillSummaryForm, url);
        } else {
            url = (String)
                          request.getParameter("skills");
            String copyurl = url;
            LinkedList linkedList = new LinkedList();
            int startindex = 0;
            int endindex = 0;
            while (url.length() > 0) {
                endindex = url.indexOf("a");
                linkedList.addLast(url.substring(startindex, endindex));
                url = url.substring(endindex + 1, url.length());
            }
            skills = new String[linkedList.size()];
            Iterator iterator = linkedList.iterator();
            while (iterator.hasNext()) {
                skills[startindex] = (String)
                                            iterator.next();
                startindex++;
            }
            SkillSummaryReportModel sortSkillSummaryReportModel = serviceProxy
                    .getReportManager().getSkillSummary(repPath, accountId,
                            grpId, skills);
            sortSkillSummaryReportModel.sortOn(sort);
            populateForm(sortSkillSummaryReportModel, skillSummaryForm,
                         copyurl);
        }
        /**
         * TODO connect to the persistence layer to extract the scores in all
         * tests for an individual user and return principal to the session.
         */
        return mapping.findForward(IConstants.SUCCESS_KEY);
    }

    /**
     * @param skillSummaryReportModel
     *            Contains all the information for Skill Summary Report.
     * @param skillSummaryForm
     *            Action Form in which data is populated to show on jsp.
     * @param url
     *            Comprises of skills and delimiters and pass to the url. This
     *            function populates values in the corresponding Action form.
     */
    private void populateForm(
            final SkillSummaryReportModel skillSummaryReportModel,
            final SkillSummaryForm skillSummaryForm, final String url) {
        skillSummaryForm.setSkillSummaryReportModel(skillSummaryReportModel);
        skillSummaryForm.setUrl(url);
    }
}
