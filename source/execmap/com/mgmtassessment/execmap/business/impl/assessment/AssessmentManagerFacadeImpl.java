/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : DasAshim
 * @date : Aug 11, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.business.impl.assessment;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mgmtassessment.execmap.business.api.assessment
       .AssessmentManagerFacade;
import com.mgmtassessment.execmap.business.api.assessment.AssessmentPrepare;
import com.mgmtassessment.execmap.business.api.assessment.StanineToSkillScore;
import com.mgmtassessment.execmap.business.model.AssessmentMainModel;
import com.mgmtassessment.execmap.business.model.ImageTextAssessmentModel;
import com.mgmtassessment.execmap.common.framework.business.AbstractFacadeImpl;
import com.mgmtassessment.execmap.common.util.search.HQLSearch;
import com.mgmtassessment.execmap.common.util.webapp.AnswerListModel;
import com.mgmtassessment.execmap.common.util.webapp.AnswerListMultiModel;
import com.mgmtassessment.execmap.common.util.webapp.AnswerSaveModel;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.data.dao.types.TestSesScrDet;
import com.mgmtassessment.execmap.data.dao.types.TestSesScrDetKey;
import com.mgmtassessment.execmap.data.dao.types.TestSessionMaster;
import com.mgmtassessment.execmap.data.dao.types.TestSessionMasterKey;
import com.mgmtassessment.execmap.data.daoapi.AssessmentDAO;
import com.mgmtassessment.execmap.data.daoapi.RawMaxScore;
import com.mgmtassessment.execmap.webapp.main.assessment.action.UserEligibilityAssessmentAction;

/**
 * This is the implementation for the assessment manager facade.
 */

public class AssessmentManagerFacadeImpl extends AbstractFacadeImpl implements
        AssessmentManagerFacade {
    /**
     *Specifying the logger for the class.
     */
    private static Log log = LogFactory
    .getLog(AssessmentManagerFacadeImpl.class);
    /*
     * declaring HQL search for the HQL query
     */
    HQLSearch     hqlsearch;
    /*
     * declaring assessmentdao which will be called
     * for any transaction with database.
     */
    AssessmentDAO assessmentdao;

    /**
     * @return Returns the assessmentdao.
    */
    public AssessmentDAO getAssessmentdao() {
        return assessmentdao;
    }

    /**
     * @param assessmentdao The assessmentdao to set.
     */
    public void setAssessmentdao(AssessmentDAO assessmentdao) {
        this.assessmentdao = assessmentdao;
    }

    /**
     * @return Returns the hqlsearch.
     */
    public HQLSearch getHqlsearch() {
        return hqlsearch;
    }

    /**
     * @param hqlsearch The hqlsearch to set.
     */
    public void setHqlsearch(HQLSearch hqlsearch) {
        this.hqlsearch = hqlsearch;
    }

    /**
     * This method prepares a model for an assessment activity. It takes a
     * trigram, Locale and PageNo as an argument and returns the model for an
     * assessment page. for a trigram assessment. Note: VERY IMPORTANT-- The
     * caller of this method is responsible for casting the pagemodel type for
     * an assessment page for a trigram.
     * @param trigram The assessment trigram
     * @param locale The locale
     * @param pageNo The page no
     * @return A model of type ImageTextAssessmentModel
     */

    public Object getPageModel(String trigram, Locale locale, Integer pageNo) {

        AssessmentMainModel activityModel = prepareModelForActivity(trigram,
                locale);
        ImageTextAssessmentModel assessModel = 
                  (ImageTextAssessmentModel) activityModel
                .getInstructionModel().get(pageNo.intValue());
        assessModel.setPageNo(pageNo.toString());
        assessModel.setQuestionlistsize(""
                + (activityModel.getInstructionModel().size() - 1));
        log.info("return the assessment model for the assessment");
        return assessModel;
    }

    /**
     * This method prepares a model for an assessment activity for those type of
     * assessment where assessment model would depend on the answer selected. It
     * takes a trigram, Locale, PageNo and answer as an argument and returns the
     * model for an assessment page. for a trigram assessment. Note: VERY
     * IMPORTANT-- The caller of this method is responsible for casting the
     * pagemodel type for an assessment page for a trigram. The implementation
     * of this method should have the logic to return Model depending on the
     * answer.
     * @param trigram The assessment trigram
     * @param locale The locale
     * @param pageNo The page no
     * @param answer the answer no to the question
     * @return Object of the type ImageTextAssessmentModel
     */

    public Object getPageModel(String trigram, Locale locale, Integer pageNo,
            Integer answer) {

        ImageTextAssessmentModel assessModel = new ImageTextAssessmentModel();

        if (pageNo == 1) {

            trigram = trigram + ("" + pageNo);
            AssessmentMainModel activityModel = prepareModelForActivity(
                    trigram, locale);
            assessModel = (ImageTextAssessmentModel) activityModel
                    .getInstructionModel().get(answer.intValue());
            assessModel.setPageNo(pageNo.toString());
            assessModel.setQuestionlistsize(""
                    + (activityModel.getInstructionModel().size() - 3));
        }

        if (pageNo == 2) {
            trigram = trigram + ("" + pageNo);
            AssessmentMainModel activityModel = prepareModelForActivity(
                    trigram, locale);
            assessModel = (ImageTextAssessmentModel) activityModel
                    .getInstructionModel().get(answer.intValue());

            assessModel.setPageNo(pageNo.toString());
            assessModel.setQuestionlistsize(""
                    + (activityModel.getInstructionModel().size() - 3));

        }

        if (pageNo == 3) {
            trigram = trigram + ("" + pageNo);
            AssessmentMainModel activityModel = prepareModelForActivity(
                    trigram, locale);
            assessModel = (ImageTextAssessmentModel) activityModel
                    .getInstructionModel().get(answer.intValue());

            assessModel.setPageNo(pageNo.toString());
            assessModel.setQuestionlistsize(""
                    + (activityModel.getInstructionModel().size() - 3));

        }

        return assessModel;

    }

    /**
     * this mthod calls the method to prepare the model for an assessment.
     * @param trigram The assessment trigram
     * @param locale The locale
     * @return A model of the type AssessmentMainModel
     */
    private AssessmentMainModel prepareModelForActivity(String trigram,
            Locale locale) {

        AssessmentPrepare assessmentPrepare = (AssessmentPrepare) appCtxt
                .getBean(trigram.trim().toUpperCase());

        AssessmentMainModel assessModel = assessmentPrepare
                .prepareModel(locale);
        log.info("Model for the assessment prepared");
        return assessModel;

    }

    /**
     * this method checks for the eligibility of a user for giving the
     * asssessment.
     * @param accountId The user's account id
     * @param userid The user's userid
     * @param sessionId the session id from tes_ses_mas table
     * @return a boolean specifying the eligibility of the user
     */

    public boolean checkUserEligibility(String accountId, String userid,
            String sessionId) {

        boolean coUserCanStartTest = false;

        int daysLeft = assessmentdao.getDays14Crossed(accountId, userid,
                sessionId);
        if ((daysLeft < 0)) {
            String startTest = assessmentdao
                    .getStartTestFlag(accountId, userid);
            if (startTest.equalsIgnoreCase("T")) {
                String completeFlag = assessmentdao.getCompleteFlag(accountId,
                        userid, sessionId);
                if (completeFlag.equalsIgnoreCase("T")) {
                    coUserCanStartTest = true;

                } else if (completeFlag.equalsIgnoreCase("N")) {
                    coUserCanStartTest = true;

                } else if (completeFlag.equalsIgnoreCase("F")) {
                    coUserCanStartTest = false;
                } else {
                    coUserCanStartTest = false;

                }

            }
        } else {
            String startTest = assessmentdao
                    .getStartTestFlag(accountId, userid);
            if (startTest.equalsIgnoreCase("F")) {
                coUserCanStartTest = false;

            } else {
                coUserCanStartTest = true;
            }
        }

        return coUserCanStartTest;
    }

    /**
     * saves the user specific data in the the table test_ses_mas calls on the
     * methods to calculte the raw score based on the user's answers calls on
     * the method to calulate the stanine score calls on the method of dao to
     * store the data in test_ses_score_det calls on the method to calculte the
     * skill score corresponding to the stanine score and finally it calls on
     * the method to store this skill score in the table test_ses_skill_scr_det.
     * @param answermodel the assessment related details
     * @param langid the language id
     */

    public void saveDataTestSessionMaster(AnswerSaveModel answermodel,
            String langid, UserContext usercontext) {

        String questionid = null;
        String answerid = null;
        int maxsessionid = assessmentdao.getMaxSessionID(usercontext
                .getUserInfo().getAccountId(), usercontext.getUserInfo()
                .getLogonUserId());
        answermodel.setSessionId("" + maxsessionid);
        TestSessionMaster testsessionmaster = new TestSessionMaster();
        TestSessionMasterKey testsessionmasterkey = new TestSessionMasterKey(
                answermodel.getAccountId(), new Integer(maxsessionid));
        testsessionmaster.setComp_id(testsessionmasterkey);
        String completeFlag = "F";
        // TODO check if checkUserEligibility is to be called or not
        if (maxsessionid != 0) {
            completeFlag = assessmentdao.getCompleteFlag(answermodel
                    .getAccountId(), answermodel.getUserId(),
                    ("" + maxsessionid));
        }
        if (!completeFlag.equalsIgnoreCase("F")) {

            insertRowTestSessionMaster(maxsessionid, usercontext);
        } else {

            if (answermodel.getAnsModel().getTriGram()
                          .equalsIgnoreCase("NFU")) {
                testsessionmaster.setCompFlg("T");
                testsessionmaster.setDtEnd(new Timestamp(System
                        .currentTimeMillis()));
                assessmentdao.setStartFlag(answermodel.getAccountId(),
                        answermodel.getUserId(), "F");
            } else {
                testsessionmaster.setDtEnd(null);
                int daysLeft = assessmentdao.getDays14Crossed(answermodel
                        .getAccountId(), answermodel.getUserId(),
                        ("" + maxsessionid));
                if (daysLeft < 0) {

                    testsessionmaster.setCompFlg("N");
                }
            }

            testsessionmaster.setTimesAnserChanged(new Integer(
                    (int) answermodel.getAnsModel().getTimesAnswerChanged()));
            testsessionmaster.setTimesExpired((new Integer((int) answermodel
                    .getAnsModel().getTimesActivityExpired())));
            log.info("updating the session id");
            assessmentdao.getAndupdateSessionID(testsessionmaster);

        }

        int sizeofquestionlist = answermodel.getAnsModel().getAnswerList()
                .size();
        for (int question = 1; question < sizeofquestionlist; question++) {
            questionid = "" + (question);
            answerid = (answermodel.getAnsModel().getAnswerList().get(question))
                    .toString();
        }
        RawMaxScore rawMaxScore = (RawMaxScore) appCtxt.getBean("RawMaxScore");

        BigDecimal rawScr = rawMaxScore.calculateRawScore(answermodel
                .getAnsModel(),langid);
        log.info("Raw Score for the Assessment calculated");
        BigDecimal stanScore;
        BigDecimal stddeviation;
        if (answermodel.getAnsModel().getTriGram().equalsIgnoreCase("NFU")) {
            stddeviation = calculateStdDeviation(answermodel);
            log.info("Standard deviation for the NFU Assessment calculated");
            stanScore = assessmentdao.calculateNfuStanineScore(answermodel
                    .getAnsModel().getTriGram(), rawScr, stddeviation);
            log.info("Stanine Score for the NFU Assessment calculated");
        } else {
            stanScore = assessmentdao.calculateStanineScore(answermodel
                    .getAnsModel().getTriGram(), rawScr);
            log.info("Stanine Score for the Assessment calculated");
            stddeviation = new BigDecimal(0.0);
        }
        String subtestid = "x";
        if(answermodel.getAnsModel().getTriGram().equalsIgnoreCase("MEMWS")){
            answermodel
            .getAnsModel().setTriGram("MEM");
            subtestid="x1";
        }
        TestSesScrDet testsesscrdet = new TestSesScrDet();
        TestSesScrDetKey testsesscrdetkey = new TestSesScrDetKey(answermodel
                .getAccountId(), new Integer(maxsessionid), answermodel
                .getAnsModel().getTriGram(), subtestid);

        testsesscrdet.setComp_id(testsesscrdetkey);
        testsesscrdet.setRawScr(rawScr);
        testsesscrdet.setStanScore(stanScore);
        testsesscrdet.setAudioFlg(usercontext.getUserInfo().getSoundData()
                .toString());
        testsesscrdet.setExclFlg(null);

        if (answermodel.getAnsModel().getTriGram().equals("NFU")) {
            // testsesscrdet.setDeviation((Integer) stddeviation.intValue());
        } else {
            // testsesscrdet.setDeviation(null);
        }
        assessmentdao.saveDataTestSesScrDet(testsesscrdet);
        log.info("Raw & Stanine Score added in the " +
                "testsesscrdet for a assessment");
        if (answermodel.getAnsModel().getTriGram().equals("NFU")) {
            StanineToSkillScore stanineToSkillScore =
                        (StanineToSkillScore) appCtxt
                    .getBean("StanineToSkillScore");
            stanineToSkillScore.stanineToSkillScore(answermodel.getAccountId(),
                    (new Integer(maxsessionid)).toString());
            log.info("Skill has been calculated for a " +
                    "particular user after all assessments");
        }
    }

    /**
     * this method is used for inserting a new row in the table
     * test_ses_mas.this methos is used if the user is a new user and doesn't
     * have a previous entry in the table.
     * @param usercontext the user context
     */

    public void insertRowTestSessionMaster(UserContext usercontext) {
        TestSessionMaster testsessionmaster = new TestSessionMaster();
        TestSessionMasterKey testsessionmasterkey = new TestSessionMasterKey(
                usercontext.getUserInfo().getAccountId(), new Integer(0));
        testsessionmaster.setComp_id(testsessionmasterkey);
        testsessionmaster.setUsrId(usercontext.getUserInfo().getLogonUserId());
        testsessionmaster.setCompFlg("F");
        testsessionmaster.setTimesAnserChanged(0);
        testsessionmaster.setTimesExpired(0);
        testsessionmaster.setDtEnd(null);
        testsessionmaster.setDtStart(new Timestamp(System.currentTimeMillis()));
        assessmentdao.getAndInsertSessionID(testsessionmaster);
        log.info("User info added in testsession master");
    }

    /**
     * this method is used for inserting a new row in the table
     * test_ses_mas.this method is used for a user who already has completed all
     * the assessment and has a entry in the table but has come to take the
     * assessments again.
     * @param testsessionmaster the object of test session master
     * @param usercontext the user context
     */

    public void insertRowTestSessionMaster(int maxsessionid,
            UserContext usercontext) {
        TestSessionMaster testsessionmaster = new TestSessionMaster();
        TestSessionMasterKey testsessionmasterkey = new TestSessionMasterKey(
                usercontext.getUserInfo().getAccountId(), new Integer(maxsessionid));
        testsessionmaster.setComp_id(testsessionmasterkey);
        testsessionmaster.setUsrId(usercontext.getUserInfo().getLogonUserId());
        testsessionmaster.setCompFlg("F");
        testsessionmaster.setTimesAnserChanged(0);
        testsessionmaster.setTimesExpired(0);
        testsessionmaster.setDtEnd(null);
        testsessionmaster.setDtStart(new Timestamp(System.currentTimeMillis()));
        assessmentdao.getAndInsertSessionID(testsessionmaster);
    }

    /**
     * This method retrieve the various position of the slider from the answer model
     * and  calculate the standard deviation.
     * @param answermodel
     * @return Standard deviation.
     */
    public BigDecimal calculateStdDeviation(AnswerSaveModel answermodel) {
        BigDecimal standarddeviation;
        List slidervalues = new ArrayList();
        double totalslider = 0;
        List userAnswerList = answermodel.getAnsModel().getAnswerList();
        Map userAnswersMap = new HashMap();
        Iterator userAnswerListIterator = userAnswerList.iterator();
        while (userAnswerListIterator.hasNext()) {
            AnswerListModel answerListModel =
                  (AnswerListModel) userAnswerListIterator.next();
            userAnswersMap.put(answerListModel.getTestQuestionId().toString(),
                    answerListModel.getMultiAnsModel());
        }
        userAnswerListIterator = userAnswerList.iterator();
        while (userAnswerListIterator.hasNext()) {
            String strqno = ""
                    + ((AnswerListModel) userAnswerListIterator.next())
                            .getTestQuestionId();
            List multianswerList = ((List) userAnswersMap.get(strqno));
            Iterator multianswerListIterator = multianswerList.iterator();
            while (multianswerListIterator.hasNext()) {
                AnswerListMultiModel answerListMultiModel 
                    = (AnswerListMultiModel) multianswerListIterator.next();
                Integer answerID = new Integer((answerListMultiModel
                        .getAnswerNoStartPos()).intValue());
                if (answerID > 50) {
                    answerID = (answerID - 50);
                }
                totalslider = totalslider + answerID.doubleValue() / 12.5;
                slidervalues.add(answerID.doubleValue() / 12.5);
            }
        }
        double mean = totalslider / (slidervalues.size());
        double sumofsquares = 0.0;
        for (int i = 0; i < slidervalues.size(); i++) {
            sumofsquares = sumofsquares
                    + Math.pow(((new Double("" + slidervalues.get(i))
                            .doubleValue()) - mean), 2.0);
        }
        double Std = (Math.sqrt((double) sumofsquares
                / (slidervalues.size() - 1)));
        standarddeviation = new BigDecimal(Std);

        return standarddeviation;
    }

    /**
     * returns maximum session id for given AccountID and userID from
     * test_ses_mas. calls the assessment dao method with the same name.
     * @param accountid
     * @param userid
     * @return the maximum session id for a particular user id and accountid
     *         from the table test_ses_mas for an existing user and o sessionid
     *         for a new user
     */

    public int getMaxSessionID(String accountid, String userid) {
        int sessionId = assessmentdao.getMaxSessionID(accountid, userid);
        return sessionId;
    }

    /**
     * This method counts the no of entries for a particular account id and
     * sessionid in the table test_ses_mas. the count is used to determine which
     * assessment is supposed to be opened for a user.
     * @param accountid
     * @param sessionID
     * @return sessionid
     */
    public int sequenceID(String accountid, String sessionID) {
        int sequenceID = assessmentdao.sequenceID(accountid, sessionID);
        return sequenceID;
    }

    /**
     * tis method returs the trigram id based on the sequence id.
     * @param sequenceID
     * @return trigramid
     */

    public String getTriGramId(String sequenceID) {
        String triGramId = assessmentdao.getTriGramId(sequenceID);
        return triGramId;
    }

    /**
     * this method is used to get the start test flag from the table co_usr_mas.
     * @param accountId the user's account id
     * @param userid the user's userid.
     * @return the start test flag
     */
    
    public String getStartTestFlag(String accountId, String userid) {
        String startTest = assessmentdao.getStartTestFlag(accountId, userid);
        return startTest;
    }
}
