/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : DasAshim
 * @date : Aug 21, 2006
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

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;

import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.common.util.webapp.AssessmentContext;

import com.mgmtassessment.execmap.webapp.main.assessment.form.AssessmentMultiForm;
import com.mgmtassessment.execmap.business.model.ImageTextAssessmentModel;
import com.mgmtassessment.execmap.business.api.assessment.AssessmentManagerFacade;

import com.mgmtassessment.execmap.common.util.webapp.AnswerModel;
import com.mgmtassessment.execmap.common.util.webapp.AnswerListModel;
import com.mgmtassessment.execmap.common.util.webapp.AnswerSaveModel;
import com.mgmtassessment.execmap.common.util.webapp.AnswerListMultiModel;

/**
 * Action class for the assessment activity.It is used by the assessments which
 * may have multiple answer for each activity.
 */

public class AssessmentMultipleAnswerAction extends ExecmapAction {
    /**
     * Specifying the logger for the class.
     */
    private static Log log = LogFactory
                                   .getLog(AssessmentMultipleAnswerAction.class);

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
     * @return Action to forward to
     * @exception java.lang.Exception
     *                if an input/output error or servlet exception occurs
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy serviceProxy) throws Exception {

        /**
         * Extract attributes we will need.
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
        AssessmentMultiForm assessMultiForm = (AssessmentMultiForm) form;

        /**
         * pageNoFromUrl would store the page No if the request is from the link
         * on the page list. If the request is from Next button the form would
         * be populated with the page number.
         */

        String pageNoFromUrl = request.getParameter("Pageno");
        Integer pageNo = Integer.parseInt(assessMultiForm.getPageNo());

        if (pageNoFromUrl == null
                || (pageNoFromUrl != null && !pageNo.equals(0))) {
            pageNo = Integer.parseInt(assessMultiForm.getPageNo());
        } else {
            pageNo = Integer.parseInt(pageNoFromUrl);
            assessMultiForm.setUrlsetflag(true);
        }

        // Remove any prevoius answerlistmodel
        // if(assessMultiForm.getStartCounting().equals(1))
        // {
        // assessCtxt.getAssessmentAns().removeAnswerList();
        // }

        List navigateList = new ArrayList();

        /**
         * Whenever the pageNo is 0 then it is an instruction page and
         * subsequently place to set the trigram id for an activity.
         */
        if (pageNo == 0) {
            assessCtxt.getAssessmentAns().setTriGram(mapping.getParameter());
        }
        /**
         * If the Page No is NOT 0 then the Page is Assessment sub test related
         * page and has questions and answers. If the page No is 0 then it is
         * Assessment Instruction. For re-answer functionality (the User can go
         * back and change his answer) if the current page number is less than
         * the size of answer model then it means that the user has gone back to
         * change his answer.
         */
        if (pageNo != 0 && pageNoFromUrl == null) {
            Integer questionNo = assessMultiForm.getQuestionNo() == null ? 0
                    : Integer.parseInt(assessMultiForm.getQuestionNo());
            assessMultiForm.setStartCounting("1");
            AnswerModel ansModel = assessCtxt.getAssessmentAns();
            AnswerListModel ansListModel;

            AnswerListMultiModel answerMultiModel;
            if (questionNo > 0) {
                if (ansModel.getAnswerList().size() < questionNo) {
                    ansListModel = new AnswerListModel();
                    ansListModel.testQuestionId = Byte.valueOf((Integer
                            .valueOf(pageNo.intValue() - 1)).byteValue());
                    /**
                     * Based on the number of multiple correct answer set i.e
                     * start position and end position create a new instance of
                     * AnswerListMultiModel, set its start and end position
                     * value and finally add the AnswerListMultiModel objects to
                     * AnsListModel. Note the value of ansListModel.answerNo and
                     * answerMultiModel.answerNoStartPos should hold same value
                     */
                    if ((!"DMS".equals(mapping.getParameter()))
                            && (!"ESS".equals(mapping.getParameter()))) {

                        String[] answers;

                        if (assessMultiForm.getSelectedCheckboxes() == null) {

                            answers = new String[2];
                            answers[0] = "1";
                            answers[1] = "0";

                        } else {
                            answers = assessMultiForm.getSelectedCheckboxes();
                        }

                        /** Setting AnswerMultiModel */
                        if (answers.length % 2 == 0) {
                            ansListModel.multiAnsModel = new ArrayList<AnswerListMultiModel>();

                            for (int i = 0; i < answers.length; i++) {
                                answerMultiModel = new AnswerListMultiModel();
                                answerMultiModel.answerNoStartPos = Byte
                                        .valueOf(Byte.parseByte(answers[i]));
                                answerMultiModel.answerNoStartPos--;
                                i++;
                                answerMultiModel.answerNoEndPos = Byte
                                        .valueOf(Byte.parseByte(answers[i]));
                                ansListModel.multiAnsModel
                                        .add(answerMultiModel);
                            }
                            ansModel.addAnswerModel(ansListModel);
                            assessMultiForm.setSelectedCheckboxes(null);
                        }
                    }
                    /*
                     * The else part is for storing the answer in case of ESS.
                     * Corressponding to each answer,a MultiModel is created and
                     * added to the Answer Model Corresponding to the answer
                     * given
                     */
                    if ("ESS".equals(mapping.getParameter())) {
                        String[] answers = assessMultiForm
                                .getSelectedCheckboxes();
                        ansListModel.multiAnsModel = new ArrayList<AnswerListMultiModel>();
                        int length = (answers == null) ? 0 : answers.length;
                        for (int i = 0; i < length; i++) {
                            answerMultiModel = new AnswerListMultiModel();
                            answerMultiModel.answerNoStartPos = Byte
                                    .valueOf(Byte.parseByte(answers[i]));
                            ansListModel.multiAnsModel.add(answerMultiModel);
                        }
                        ansModel.addAnswerModel(ansListModel);
                    }
                    if ("DMS".equals(mapping.getParameter())) {
                        ansListModel.multiAnsModel = new ArrayList<AnswerListMultiModel>();
                        answerMultiModel = new AnswerListMultiModel();

                        if (assessMultiForm.isDmsFlag()) {
                            answerMultiModel.answerNoStartPos = Byte
                                    .parseByte((assessMultiForm
                                            .getDmsStartPosition() == null ? ("" + 0)
                                            : assessMultiForm
                                                    .getDmsStartPosition()));
                            answerMultiModel.answerNoEndPos = Byte
                                    .parseByte((assessMultiForm
                                            .getDmsEndPosition() == null ? ("" + 0)
                                            : assessMultiForm
                                                    .getDmsStartPosition()));
                            ansListModel
                                    .setAnswerNo(Byte
                                            .parseByte(("" + answerMultiModel.answerNoStartPos)
                                                    + ("" + answerMultiModel.answerNoEndPos)));

                            ansListModel.multiAnsModel.add(answerMultiModel);
                            ansModel.addAnswerModel(ansListModel);
                        }
                    }
                } else {
                    ansListModel = (AnswerListModel) ansModel.getAnswerList()
                            .get(questionNo - 1);
                    ansListModel.testQuestionId = Byte.valueOf(questionNo
                            .byteValue());

                    if ("NST".equals(mapping.getParameter())) {
                        String[] answers;
                        if (assessMultiForm.getSelectedCheckboxes() == null) {
                            answers = new String[2];
                            answers[0] = "1";
                            answers[1] = "0";
                        } else {
                            answers = assessMultiForm.getSelectedCheckboxes();
                        }
                        /** Setting AnswerMultiModel */
                        if (answers.length % 2 == 0) {
                            ansListModel.multiAnsModel = new ArrayList<AnswerListMultiModel>();
                            for (int i = 0; i < answers.length; i++) {
                                answerMultiModel = new AnswerListMultiModel();
                                answerMultiModel.answerNoStartPos = Byte
                                        .valueOf(Byte.parseByte(answers[i]));
                                answerMultiModel.answerNoStartPos--;
                                i++;
                                answerMultiModel.answerNoEndPos = Byte
                                        .valueOf(Byte.parseByte(answers[i]));
//                                ansListModel.multiAnsModel.add((questionNo-1),answerMultiModel);
                             ansListModel.multiAnsModel.add(answerMultiModel);
                             ansModel.getAnswerList().set((questionNo-1),ansListModel);
                            }
//                            ansModel.addAnswerModel(ansListModel);
                        }
                    }
                    if ("ESS".equals(mapping.getParameter())) {
                        String[] answers = assessMultiForm
                                .getSelectedCheckboxes();
                        ansListModel.multiAnsModel = new ArrayList<AnswerListMultiModel>();
                        int length = (answers == null) ? 0 : answers.length;
                        for (int i = 0; i < length; i++) {
                            answerMultiModel = new AnswerListMultiModel();
                            answerMultiModel.answerNoStartPos = Byte
                                    .valueOf(Byte.parseByte(answers[i]));
                            ansListModel.multiAnsModel.add(answerMultiModel);
                        }
                        ansModel.addAnswerModel(ansListModel);
                    }
                    ansModel.timesAnswerChanged++;

                }
                assessMultiForm.setSelectedCheckboxes(null);
            }
        }

        /**
         * If the finish button was clicked save the data to the database, reset
         * the user assessment session data, foward the page to next assessment.
         * If next button was clicked get the page model from facade and
         * populate it in the form.
         */

        if (!assessMultiForm.nextFinish && !assessMultiForm.timerSet) {
            String timer = "0";
            if (assessMultiForm.getStartCounting().equals("1")) {
                timer = assessMultiForm.getTimer();
            }

            ImageTextAssessmentModel pageModel = preparePageModel(mapping,
                    assessMultiForm, request, pageNo, usrContext, serviceProxy);
            // Populate the form with Model Data
            assessMultiForm.populateForm(pageModel);
            log.info("populating the save model from the session context");
            if (!assessMultiForm.getStartCounting().equals("0")) {
                assessMultiForm.setTimer(timer);
            }

            for (int i = 0; i < Integer.parseInt(assessMultiForm
                    .getQuestionlistsize()); i++) {
                navigateList.add(i + 1);
            }
            assessMultiForm.setNavigationlist(navigateList);
            Integer questionNo = assessMultiForm.getQuestionNo() == null ? 0
                    : Integer.parseInt(assessMultiForm.getQuestionNo());
            if (pageNo > 0) {
            if ((assessCtxt.getAssessmentAns().getAnswerList().size() > 0)
                    && (assessCtxt.getAssessmentAns().
                            getAnswerList().size() > questionNo - 1)) {

                List answerlistModel = assessCtxt.getAssessmentAns()
                        .getAnswerList();
                AnswerListModel answermodel = (AnswerListModel) answerlistModel
                        .get(pageNo - 1);
                List<AnswerListMultiModel> multiAnsModel = answermodel
                        .getMultiAnsModel();
                String[] answerlist = new String[10];
                Iterator multianswerListIterator = multiAnsModel.iterator();
                int i = 0;
                while (multianswerListIterator.hasNext()) {
                    AnswerListMultiModel answerListMultiModel =
                        (AnswerListMultiModel) multianswerListIterator.next();

                    answerlist[i] = answerListMultiModel
                        .getAnswerNoStartPos().toString().equals("0") ? "0"
                          : ((Integer)(answerListMultiModel.getAnswerNoStartPos()
                                    .intValue() + 1)).toString();


                    if (("" + answerListMultiModel.getAnswerNoStartPos())
                            .equals("" + 0)) {
                        answerListMultiModel.answerNoStartPos++;
                    }

                    i++;
                    if("NST".equals(mapping.getParameter())){
                    answerlist[i] = ("" + (answerListMultiModel
                            .getAnswerNoEndPos()));
                    i++;
                    }
                }
                assessMultiForm.setSelectedCheckboxes(answerlist);
            }
        }
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
            String langid = request.getLocale().getDisplayLanguage();
            // /Commented out for debugging
            serviceProxy.getAssessmentManager().saveDataTestSessionMaster(
                    saveModel, langid, usrContext);
            // After the answer is saved, reset the trigram id and remove
            // objects from answerlist.
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
     * @return
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
     * @param assessForm
     * @param request
     * @param pageNo
     * @param usrContext
     * @param serviceProxy
     * @return
     */
    ImageTextAssessmentModel pgModel;

    private ImageTextAssessmentModel preparePageModel(ActionMapping mapping,
            AssessmentMultiForm assessMultiForm, HttpServletRequest request,
            Integer pageNo, UserContext usrContext, ServiceProxy serviceProxy) {

        /**
         * For those assessment which requires model preparation based on the
         * answer like DMS assessment use the method getPageModelwith answer
         */

        if ("DMS".equals(mapping.getParameter())) {
            if (pageNo >= 1 && assessMultiForm.isDmsFlag() != true) {
                int answerno = (Integer.parseInt(assessMultiForm
                        .getDmsStartPosition()));
                pgModel = (ImageTextAssessmentModel) serviceProxy
                        .getAssessmentManager().getPageModel(
                                mapping.getParameter(), request.getLocale(),
                                pageNo, answerno);

            } else {
                pgModel = (ImageTextAssessmentModel) serviceProxy
                        .getAssessmentManager().getPageModel(
                                mapping.getParameter(), request.getLocale(),
                                pageNo);
                assessMultiForm.setDmsStartPosition("0");
            }

        } else {
            pgModel = (ImageTextAssessmentModel) serviceProxy
                    .getAssessmentManager()
                    .getPageModel(mapping.getParameter(), request.getLocale(),
                            pageNo);
        }

        return pgModel;

    }

}
