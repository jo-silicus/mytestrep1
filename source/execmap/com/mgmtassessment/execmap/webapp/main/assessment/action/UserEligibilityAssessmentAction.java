/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : barthwpr
 * @date : Sep 4, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.webapp.main.assessment.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.AssessmentContext;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.data.daoimpl.AssessmentDAOImpl;
import com.mgmtassessment.execmap.webapp.main.assessment.form.AssessmentInstForm;
import com.mgmtassessment.execmap.webapp.main.group.action.EnableDisableGroup;

/**
 * this class is used to check the eligibility of a user for appearing in a
 * test.
 */

public class UserEligibilityAssessmentAction extends ExecmapAction {

    private static Log log = LogFactory
                                   .getLog(UserEligibilityAssessmentAction.class);

    /**
     * @param mapping
     *            the action mapping
     * @param form
     *            the action form
     * @param request
     *            the HTTP request
     * @param response
     *            the HTTP response
     * @param usrContext
     *            the usercontext
     * @param servPrxy
     *            Implementation of inherited method from ExecmapAction,
     *            reposible for executing the action to toggle the group status.
     * @return ActionForward
     * @throws Exception
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy servPrxy) throws Exception {

        HttpSession session = request.getSession();
        String accountId = usrContext.getUserInfo().getAccountId();
        String userid = usrContext.getUserInfo().getLogonUserId();
        AssessmentContext assessCtxt = (AssessmentContext) session
                .getAttribute(IConstants.ASSESSMENT_CONTEXT);
        if (null == assessCtxt) {
            assessCtxt = new AssessmentContext();
            session.setAttribute(IConstants.ASSESSMENT_CONTEXT, assessCtxt);

        }
        AssessmentInstForm instForm = (AssessmentInstForm) form;

        String triGramId = null;
        String forwardName = null;

        int sessionIdValue = servPrxy.getAssessmentManager().getMaxSessionID(
                accountId, userid);

        String sessionId = Integer.toString(sessionIdValue);
        if (!sessionId.equals("0")) {
            boolean eligibility = servPrxy.getAssessmentManager()
                    .checkUserEligibility(accountId, userid, sessionId);

            if (eligibility) {
                int noOFRows = servPrxy.getAssessmentManager().sequenceID(
                        accountId, sessionId);

                String sequenceID = Integer.toString((noOFRows + 1));

                triGramId = (servPrxy.getAssessmentManager()
                        .getTriGramId(sequenceID)).trim();
                if (usrContext.getUserInfo().getSoundData().equals('F')
                        && triGramId.equalsIgnoreCase("MEM")) {
                    triGramId = triGramId + "WS";
                }
                forwardName = triGramId;
                log.info("Forwarding the trigram id on basis" +
                        " of which next test is displayed");
            } else {

                instForm.setFailFlag("1");
                forwardName = IConstants.FAILURE_KEY;
               log.info("User not eligible to appear in the test");
            }

        } else {
            String startFlag = servPrxy.getAssessmentManager()
                    .getStartTestFlag(accountId, userid);
            if (startFlag.equalsIgnoreCase("T")) {
                /**
                 * insert the start date for the for the new user in table
                 * test_ses_mas
                 */
                servPrxy.getAssessmentManager().insertRowTestSessionMaster(
                        usrContext);
                forwardName = "EMS";
                
            }
        }
        return mapping.findForward(forwardName);

    }

}
