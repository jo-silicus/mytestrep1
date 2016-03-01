/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : KapilPra
 * @date : Sep 2, 2006
 * @version:
 *
 * @history Description Reference Name Date
 *
 */

package com.mgmtassessment.execmap.webapp.main.assessment.action;

import java.util.ArrayList;
import java.util.List;

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
import com.mgmtassessment.execmap.common.util.webapp.AnswerListMultiModel;
import com.mgmtassessment.execmap.common.util.webapp.AnswerModel;
import com.mgmtassessment.execmap.common.util.webapp.AnswerSaveModel;
import com.mgmtassessment.execmap.common.util.webapp.AssessmentContext;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.assessment.form.AssessmentMultiForm;

/**
 * Action class for the MEM assessment activity.
 * It is used by the MEM assessments which
 * have multiple answer for each activity.
 * Some of the answer are also text based.
 */

public class MemAssessmentAction extends ExecmapAction {
    /**
     *Specifying the logger for the class.
     */
    private static Log log = LogFactory.getLog(AssessmentAction.class);

    /**
     * <p>
     * The user's based on {@link AssessmentMultiForm} properties.
     * </p>
     * <p>
     * This <code>Action</code> looks for <code>AssessmentMultiForm</code>
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
     * 
     * @return Action to forward to
     * @exception java.lang.Exception
     *                if an input/output error or servlet exception occurs
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy serviceProxy) throws Exception {

        /**
         * Extract attributes we will need.
         * 
         */
        HttpSession session = request.getSession();

        /**
         * All the answers related to the sub-tests will be stored in the
         * session <code>AssessmentContext</code>.
         *
         * @see AsnwerModel Stores the answers for most of the answers for a
         *     user session trigram assesment.
         * 
         */

        AssessmentContext assessCtxt = (AssessmentContext) session
                .getAttribute(IConstants.ASSESSMENT_CONTEXT);
        if (null == assessCtxt) {
            assessCtxt = new AssessmentContext();
            session.setAttribute(IConstants.ASSESSMENT_CONTEXT, assessCtxt);
        }
        ActionForward actionForward;
        AssessmentMultiForm assessMultiForm = (AssessmentMultiForm) form;

        /**
         * pageNoFromUrl would store the page No if the request is from the link
         * on the page list. If the request is from Next button the form would
         * be populated with the page number.
         */

        String pageNoFromUrl = request.getParameter("Pageno");
        Integer pageNo = Integer.parseInt(assessMultiForm.getPageNo());

        /**
         * Whenever the pageNo is 0 then it is an instruction page and
         * subsequently place to set the trigram id for an activity.
         */
        if (pageNo == 0) {
            assessCtxt.getAssessmentAns().setTriGram(mapping.getParameter());
        }

        List navigateList = new ArrayList();
        /**
         * If the Page No is NOT 0 then the Page is Assessment sub test related
         * page and has questions and answers. If the page No is 0 then it is
         * Assessment Instruction.
         *
         * For re-answer functionality (the User can go back and change his
         * answer) if the current page number is less than the size of answer
         * model then it means that the user has gone back to change his answer.
         */
        if (pageNo != 0 && pageNoFromUrl == null) {
            Integer questionNo = assessMultiForm.getQuestionNo() == null ? 0
                    : Integer.parseInt(assessMultiForm.getQuestionNo());
            assessMultiForm.setStartCounting("1");
            AnswerModel ansModel = assessCtxt.getAssessmentAns();
            AnswerListModel ansListModel;

            AnswerListMultiModel answerMultiModel;
            if (questionNo > 0) {
                /*
                 * This method is for storing the answer of the MEM with sound,
                 * which user has to select the options instead of storing in
                 * the textboxes.
                 */
                if (mapping.getParameter().equalsIgnoreCase("MEM")) {
                    if (pageNo > 15) {
                        ansListModel = new AnswerListModel();
                        ansListModel.testQuestionId = Byte.valueOf((Integer
                                .valueOf(questionNo)).byteValue());
                        ansListModel.multiAnsModel = new ArrayList<AnswerListMultiModel>();
                        answerMultiModel = new AnswerListMultiModel();
                        answerMultiModel.answerNoStartPos = (assessMultiForm
                                .getAnswerNo() == null) ? 0 : Byte
                                .parseByte(assessMultiForm.getAnswerNo());
                        ansListModel.multiAnsModel.add(answerMultiModel);
                        ansModel.addAnswerModel(ansListModel);
                    }
                }
                /*
                 * This method is for storing the answer of the MEM without
                 * sound, which user has to select the options instead of
                 * storing in the textboxes.
                 */

                if (mapping.getParameter().equalsIgnoreCase("MEM")) {
                    if (pageNo > 9) {
                        ansListModel = new AnswerListModel();
                        ansListModel.testQuestionId = Byte.valueOf((Integer
                                .valueOf(questionNo)).byteValue());
                        ansListModel.multiAnsModel = new ArrayList<AnswerListMultiModel>();
                        answerMultiModel = new AnswerListMultiModel();
                        answerMultiModel.answerNoStartPos = (assessMultiForm
                                .getAnswerNo() == null) ? 0 : Byte
                                .parseByte(assessMultiForm.getAnswerNo());
                        ansListModel.multiAnsModel.add(answerMultiModel);
                        ansModel.addAnswerModel(ansListModel);
                    }
                }
                /**
                 * Based on the user answer, it create a new instance of
                 * AnswerListMultiModel, set its start position value depending
                 * on the value of the textbox.For each question 4 list are
                 * created.Finally add the AnswerListMultiModelss objects to
                 * AnsListModel.
                 */
                else if (pageNo == (questionNo * 3) + 1) {
                    ansListModel = new AnswerListModel();
                    ansListModel.testQuestionId = Byte.valueOf((Integer
                            .valueOf(questionNo)).byteValue());
                    ArrayList answers = new ArrayList();
                    answers.add(assessMultiForm.getTextbox0());
                    answers.add(assessMultiForm.getTextbox1());
                    answers.add(assessMultiForm.getTextbox2());
                    answers.add(assessMultiForm.getTextbox3());
                    if (pageNo > 8) {
                        answers.add(assessMultiForm.getTextbox4());
                    }

                    ansListModel.multiAnsModel = new ArrayList<AnswerListMultiModel>();
                    for (int i = 0; i < answers.size(); i++) {

                        answerMultiModel = new AnswerListMultiModel();

                        answerMultiModel.answerNoStartPos = (answers.get(i) == null || answers
                                .get(i).equals("")) ? 0 : Byte
                                .parseByte((String) ((answers.get(i))));

                        ansListModel.multiAnsModel.add(answerMultiModel);
                    }
                    ansModel.addAnswerModel(ansListModel);

                }
            }
            assessCtxt.setAssessmentAns(ansModel);
        }
        /**
         * If the finish button was clicked save the data to the database, reset
         * the user assessment session data, foward the page to next assessment.
         *
         * If next button was clicked get the page model from facade and
         * populate it in the form.
         *
         */

        if (!assessMultiForm.nextFinish) {

            String timer = "0";
            if (assessMultiForm.getStartCounting().equals("1")) {
                timer = assessMultiForm.getTimer();
            }
            /**
             * Gets the pageModel Data from the Facade Layer. Note: The trigram
             * for the assessment is set as the parameter in the
             *
             * @see struts-config.xml file.
             */

            ImageTextAssessmentModel pageModel;
            pageModel = (ImageTextAssessmentModel) serviceProxy
                    .getAssessmentManager()
                    .getPageModel(mapping.getParameter(), request.getLocale(),
                            pageNo);

            assessMultiForm.populateForm(pageModel);

            if (pageNo == 0 && "NFU".equals(mapping.getParameter())) {
                assessMultiForm
                        .setTimer(assessMultiForm.getAnswerInstruction());
                assessMultiForm.setAnswerInstruction(null);
            }

            if (!assessMultiForm.getStartCounting().equals("0")) {
                assessMultiForm.setTimer(timer);
            }

            /*
             * Gets the timer for submitting the form for individual form
             */

            assessMultiForm.setMemtimer(pageModel.getTime());

            for (int i = 0; i < (Integer.parseInt(assessMultiForm
                    .getQuestionlistsize()) - 1) / 3; i++) {
                navigateList.add(i + 1);

            }
            assessMultiForm.setNavigationlist(navigateList);

            actionForward = mapping.findForward(IConstants.SUCCESS_KEY);
        } else {

            // Check if the finish is invoked due to time out, and store the
            // counter in
            // @see AnswerModel

            if (assessMultiForm.timerSet) {
                assessCtxt.getAssessmentAns().timesActivityExpired++;
            }
            AnswerSaveModel saveModel = prepareAnswerModel(usrContext, session,
                    assessCtxt);
            log.info("populating the save model from the session context");
            String langid = request.getLocale().getDisplayLanguage();
            serviceProxy.getAssessmentManager().saveDataTestSessionMaster(
                    saveModel, langid, usrContext);

            /*
             * After the answer is saved, reset the trigram id and remove
             * objects from answerlist.
             */
            assessCtxt.getAssessmentAns().triGram = null;
            assessCtxt.getAssessmentAns().removeAnswerList();
            assessMultiForm.setNextFinish(false);
            assessMultiForm.setPageNo("0");
            assessMultiForm.setQuestionNo("0");
            assessMultiForm.setNextcount("0");
            assessMultiForm.setStartCounting("0");
            assessMultiForm.setQuestionlistsize("0");
            assessMultiForm.setTimerSet(false);
            pageNo = 0;
            actionForward = mapping.findForward(IConstants.COMPLETE_KEY);
        }

        return actionForward;

    }

    /**
     * This is a helper method to populate the AnswerSaveModel. This method
     * should be invoked just before saving the user answer to the database.
     * 
     * @param usrCtxt
     * @param session
     * @param assessCtxt
     * @return anssavemodel
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
}