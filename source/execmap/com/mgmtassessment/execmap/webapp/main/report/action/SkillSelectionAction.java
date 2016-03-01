/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : kapilpra
 * @date : Aug 30, 2006
 * @version:
 *
 * @history Description Reference Name Date
 *
 */

package com.mgmtassessment.execmap.webapp.main.report.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.report.form.SkillSelectionForm;
import com.mgmtassessment.execmap.webapp.main.report.form.SkillSummaryForm;

/**
 * class sets the accountId and GroupID for Skill Summary Report generation.
 */

public class SkillSelectionAction extends ExecmapAction {

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
     * @return Action to forward to
     * @exception java.lang.Exception
     *                if an input/output error or servlet exception occurs.
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy serviceProxy)
            throws Exception {

        SkillSummaryForm skillSummaryForm = (SkillSummaryForm)
                                                             form;
        String accountId = request.getParameter("acctId");
        String grpId = request.getParameter("grpId");
        if (accountId == null || grpId == null) {
            accountId = usrContext.getUserInfo().getAccountId();
            grpId = serviceProxy.getReportManager().getGrpId(accountId,
                                     usrContext.getUserInfo().getLogonUserId());
        }
        skillSummaryForm.setAcctId(accountId);
        skillSummaryForm.setGrpId(grpId);
        /**
         * TODO connect to the persistence layer to extract the scores in all
         * tests for an individual user and return principal to the session.
         */
        return mapping.findForward(IConstants.SUCCESS_KEY);
    }
}
