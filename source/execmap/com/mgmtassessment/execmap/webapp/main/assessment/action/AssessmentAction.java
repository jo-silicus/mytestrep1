/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : DasAshim
 * @date : Aug 13, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.webapp.main.assessment.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.business.model.ImageTextAssessmentModel;
import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.AnswerListModel;
import com.mgmtassessment.execmap.common.util.webapp.AnswerModel;
import com.mgmtassessment.execmap.common.util.webapp.AnswerSaveModel;
import com.mgmtassessment.execmap.common.util.webapp.AssessmentContext;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.assessment.form.AssessmentForm;

/**
 * Action class for the assessment activity.It is used by the assessments which
 * have only single answer for each activity.
 */

public class AssessmentAction extends ExecmapAction {

    private static Log log = LogFactory.getLog(AssessmentAction.class);

    /**
     * <p>
     * The user's based on {@link AssessmentForm} properties.
     * </p>
     * <p>
     * This <code>Action</code> looks for <code>CompanyAccountForm</code>
     * and properties on the given form,
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
     * @param serviceProxy
     *            The service proxy
     * @param usrContext
     *            the user details in session
     * @return Action to forward to
     * @exception java.lang.Exception
     *                if an input/output error or servlet exception occurs
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy serviceProxy) throws Exception {

        /**
         * Get the session from Http request.
         */

        HttpSession session = request.getSession();

        /**
         * All the answers related to the sub-tests will be stored in the
         * session <code>AssessmentContext</code>.
         * 
         * @see AsnwerModel Stores the answers for most of the answers for a
         *      user session trigram assesment.
         */

        AssessmentContext assessCtxt = (AssessmentContext) session
                .getAttribute(IConstants.ASSESSMENT_CONTEXT);
        if (null == assessCtxt) {
            assessCtxt = new AssessmentContext();
            session.setAttribute(IConstants.ASSESSMENT_CONTEXT, assessCtxt);

        }

        ActionForward actionForward;
        AssessmentForm assessForm = (AssessmentForm) form;

        /**
         * pageNoFromUrl would store the page No if the request is from the link
         * on the page list. If the request is from Next button the form would
         * be populated with the page number.
         */

        String pageNoFromUrl = request.getParameter("Pageno");
        Integer pageNo = Integer.parseInt(assessForm.getPageNo());

        /*
         * if (pageNoFromUrl == null || (pageNoFromUrl != null &&
         * !pageNo.equals(0))) { pageNo =
         * Integer.parseInt(assessForm.getPageNo()); } else { pageNo =
         * Integer.parseInt(pageNoFromUrl); assessForm.setUrlsetflag(true); }
         */

        // Remove any prevoius answerlistmodel
        // if(assessForm.getStartCounting().equals(1))
        // {
        // assessCtxt.getAssessmentAns().removeAnswerList();
        // }
        List navigateList = new ArrayList();

        /**
         * Whenever the pageNo is 0 then it is an instruction page and
         * subsequently place to set the trigram id for an activity.
         */
        if (pageNo == 0) {

            if (assessForm.getNextcount().equals("0")) {

                assessCtxt.getAssessmentAns().removeAnswerList();
            }

            assessCtxt.getAssessmentAns().setTriGram(mapping.getParameter());
            // Remove any previous answerlistmodel, when the page
            // is 0 i.e instruction page and for the first time only.
            // Note: Page No can become 0 if the user clicks on the
            // instruction button, while taking assessment.
            // First time, for 0 page the nextCount will be null.

            if (Integer.parseInt(assessForm.getNextcount()) == 0) {
                assessCtxt.getAssessmentAns().removeAnswerList();
            }
        }
        /**
         * If the Page No is NOT 0 then the Page is Assessment sub test related
         * page and has questions and answers. If the page No is 0 then it is
         * Assessment Instruction. For re-answer functionality (the User can go
         * back and change his answer) if the current page number is less than
         * the size of answer model then it means that the user has gone back to
         * change his answer.
         */

        if ((pageNo != 0 && pageNoFromUrl == null)
                || (pageNo == 0 && assessForm.getNextcount() != "0")) {
            Integer questionNo = assessForm.getQuestionNo() == null ? 0
                    : Integer.parseInt(assessForm.getQuestionNo());
            assessForm.setStartCounting("1");
            AnswerModel ansModel = assessCtxt.getAssessmentAns();
            AnswerListModel ansListModel;
            if (questionNo > 0) {
                if (ansModel.getAnswerList().size() < questionNo) {
                    ansListModel = new AnswerListModel();
                    ansListModel.testQuestionId = Byte.valueOf((Integer
                            .valueOf(questionNo)).byteValue());
                    ansListModel.answerNo = (assessForm.getAnswerNo() == null) ? 0
                            : Byte.valueOf(Byte.parseByte(assessForm
                                    .getAnswerNo()));
                    ansModel.addAnswerModel(ansListModel);
                } else {
                    ansListModel = (AnswerListModel) ansModel.getAnswerList()
                            .get(questionNo - 1);
                    ansListModel.testQuestionId = Byte.valueOf(questionNo
                            .byteValue());
                    ansListModel.answerNo = (assessForm.getAnswerNo() == null) ? 0
                            : Byte.valueOf(Byte.parseByte(assessForm
                                    .getAnswerNo()));
                    ansModel.timesAnswerChanged++;
                }
                assessForm.setAnswerNo("0");
            }
            assessCtxt.setAssessmentAns(ansModel);

        }

        /**
         * If the finish button was clicked save the data to the database, reset
         * the user assessment session data, foward the page to next assessment.
         * If next button was clicked get the page model from facade and
         * populate it in the form.
         */

        if (!assessForm.nextFinish && !assessForm.timerSet) {
            String timer = "0";
            if (assessForm.getStartCounting().equals("1")) {
                timer = assessForm.getTimer();
            }

            ImageTextAssessmentModel pageModel = preparePageModel(mapping,
                    assessForm, request, pageNo, usrContext, serviceProxy);
            // Populate the form with Model Data
            assessForm.populateForm(pageModel);
            if (!assessForm.getStartCounting().equals("0")) {
                assessForm.setTimer(timer);
            }

            for (int i = 0; i < Integer.parseInt(assessForm
                    .getQuestionlistsize()); i++) {
                navigateList.add(i + 1);

            }
            assessForm.setNavigationlist(navigateList);
            Integer questionNo = assessForm.getQuestionNo() == null ? 0
                    : Integer.parseInt(assessForm.getQuestionNo());

            if (pageNo > 0) {
                if ((assessCtxt.getAssessmentAns().getAnswerList().size() > 0)
                        && (assessCtxt.getAssessmentAns().getAnswerList()
                                .size() > questionNo - 1)) {

                    List answerlistModel = assessCtxt.getAssessmentAns()
                            .getAnswerList();
                    AnswerListModel answermodel = (AnswerListModel) answerlistModel
                            .get(pageNo - 1);
                    String answer = answermodel.getAnswerNo().toString();
                    assessForm.setAnswerNo(answer);
                }
            }
            actionForward = mapping.findForward(IConstants.SUCCESS_KEY);
        } else {

            // Check if the finish is invoked due to time out, and store the
            // counter in
            // @see AnswerModel
            if (assessForm.timerSet) {
                assessCtxt.getAssessmentAns().timesActivityExpired++;
            }
            AnswerSaveModel saveModel = prepareAnswerModel(usrContext, session,
                    assessCtxt);
            log.info("populating the save model from the session context");
            String langid = request.getLocale().getLanguage();
            // /Commented out for debugging
            serviceProxy.getAssessmentManager().saveDataTestSessionMaster(
                    saveModel, langid, usrContext);
            // After the answer is saved, reset the trigram id and remove
            // objects from answerlist.
            assessCtxt.getAssessmentAns().triGram = null;
            assessCtxt.getAssessmentAns().removeAnswerList();
            assessForm.setNextFinish(false);
            assessForm.setPageNo("0");
            assessForm.setQuestionNo("0");
            assessForm.setNextcount("0");
            assessForm.setStartCounting("0");
            assessForm.setQuestionlistsize("0");
            assessForm.setTimerSet(false);
            pageNo = 0;
            if (mapping.getParameter().equalsIgnoreCase("EFC")
                    && usrContext.getUserInfo().getSoundData().equals('F')) {
                actionForward = mapping
                        .findForward(IConstants.COMPLETE_KEY_MEMWS);
            } else {
                actionForward = mapping.findForward(IConstants.COMPLETE_KEY);
            }
        }

        return actionForward;

    }

    /**
     * This is a helper method to populate the AnswerSaveModel. This method
     * should be invoked just before saving the user answer to the database.
     * 
     * @param usrCtxt
     *            The Usercontext stored in session
     * @param session
     *            The session
     * @param assessCtxt
     *            The assessment details stored in session
     * @return ansSaveModel The answer details
     */
    private AnswerSaveModel prepareAnswerModel(UserContext usrCtxt,
            HttpSession session, AssessmentContext assessCtxt) {

        AnswerSaveModel ansSaveModel = new AnswerSaveModel();
        ansSaveModel.setAnsModel(assessCtxt.getAssessmentAns());
        ansSaveModel.setAccountId(usrCtxt.getUserInfo().getAccountId());
        ansSaveModel.setUserId(usrCtxt.getUserInfo().getLogonUserId());
        ansSaveModel.setSessionId(session.getId().substring(0, 9));
        return ansSaveModel;
    }

    /**
     * Helper method to prepare a page Model for an assessment activity. Gets
     * the pageModel Data from the Facade Layer. Note: The trigram for the
     * assessment is set as the parameter in the
     * 
     * @see struts-config.xml file.
     * @param mapping
     *            action mapping
     * @param assessForm
     *            The assessment form
     * @param request
     *            httprequest
     * @param pageNo
     *            The page no which is 0 for instruction 1 for first question
     *            and so on
     * @param usrContext
     *            The user details in session
     * @param serviceProxy
     *            serviceProxy
     * @return pgModel
     */

    private ImageTextAssessmentModel preparePageModel(ActionMapping mapping,
            AssessmentForm assessForm, HttpServletRequest request,
            Integer pageNo, UserContext usrContext, ServiceProxy serviceProxy) {

        ImageTextAssessmentModel pgModel;

        pgModel = (ImageTextAssessmentModel) serviceProxy
                .getAssessmentManager().getPageModel(mapping.getParameter(),
                        request.getLocale(), pageNo);

        return pgModel;

    }
}
