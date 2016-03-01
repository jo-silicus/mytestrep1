/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author singhrau
 * @date : Aug 16, 2006
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
import com.mgmtassessment.execmap.webapp.main.assessment.
                                     form.AssessmentInstForm;

/**
 * This action class is used to check for the
 * sound availability and for displaying the three
 * instruction pages before the beginning of the
 * first assessment for a user.
 */

public class PreAssessmentAction extends ExecmapAction {
    /**
     *Specifying the logger for the class.
     */
    private static Log log = LogFactory
    .getLog(PreAssessmentAction.class);
    /**
     * the execute method.
     * @param form the action form
     * @param mapping the action mapping
     * @param request the HTTP request
     * @param response the HTTP response
     * @param serviceProxy the service proxy
     * @param usrContext the usercontext
     * @return forwad mapping
     * @throws Exception
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy serviceProxy)
            throws Exception {
        
        HttpSession session = request.getSession();

        /**
         * All the answers related to the sub-tests will be stored in the
         * session <code>AssessmentContext</code>.
         * @see AsnwerModel Stores the answers for most of the answers for a
         *      user session trigram assesment.
         */

        AssessmentContext assessCtxt = (AssessmentContext) session
                .getAttribute(IConstants.ASSESSMENT_CONTEXT);
        if (assessCtxt != null) {
            assessCtxt = null;
            session.setAttribute(IConstants.ASSESSMENT_CONTEXT, assessCtxt);
        }

        AssessmentInstForm assessInstForm = (AssessmentInstForm) form;
        if (assessInstForm.isCheckFlagsoundset()) {
            if (assessInstForm.isSoundCheck()) {
                if (!assessInstForm.isCheckboxValue()) {
                    usrContext.getUserInfo().setSoundData('T');
                }
            } else {
                usrContext.getUserInfo().setSoundData('F');
            }
        } else {
            usrContext.getUserInfo().setSoundData('F');
        }
        log.info("Sound information set in the user context");
        return mapping.findForward(IConstants.SUCCESS_KEY);

    }
}
