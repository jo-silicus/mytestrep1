/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : DasAshim
 * @date : Aug 11, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.business.api.assessment;

import java.util.Locale;

import com.mgmtassessment.execmap.common.framework.business.AbstractFacade;
import com.mgmtassessment.execmap.common.util.webapp.AnswerSaveModel;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.data.dao.types.TestSessionMaster;

/**
 * This is the interface for the assessment manager.it consists of the methods
 * used for implementing the business logic for the assessment activities.
 * @author singhrau
 */
public interface AssessmentManagerFacade extends AbstractFacade {

    /**
     * This method prepares a model for an assessment activity. It takes a
     * trigram, Locale and PageNo as an argument and returns the model for an
     * assessment page. for a trigram assessment. Note: VERY IMPORTANT-- The
     * caller of this method is responsible for casting the pagemodel type for
     * an assessment page for a trigram.
     * @param trigram The assessment trigram
     * @param locale The locale
     * @param pageNo The page no
     * @return Object of the type ImageTextAssessmentModel
     */
    public Object getPageModel(String trigram, Locale locale, Integer pageNo);

    /**
     * This method prepares a model for an assessment activity for those type of
     * assessment where assessment model would depend on the answer selected. It
     * takes a trigram, Locale, PageNo and answer as an argument and returns the
     * model for an assessment page. for a trigram assessment. Note: VERY
     * IMPORTANT-- The caller of this method is responsible for casting the
     * pagemodel type for an assessment page for a trigram. The implementation
     * of this method should have the logic to return Model depending on the
     * answer.
     * @param trigram trigram the assessment trigram
     * @param locale The locale
     * @param pageNo The page no
     * @param answer The answer to a specific question
     * @return Object of the type ImageTextAssessmentModel
     */

    public Object getPageModel(String trigram, Locale locale, Integer pageNo,
            Integer answer);

    /**
     * Saves the data for a User in testsessionmaster based on whether he is a
     * new user or existing one per session.
     * @param answermodel consist of the answers to questions.
     * @param lang The language id.
     */

    public void saveDataTestSessionMaster(AnswerSaveModel answermodel,
            String lang, UserContext usercontext);

    /**
     * Checks whether the User is eligible for appearing in the assessment or
     * not per session.
     * @param accountId The user's account id.
     * @param userid The User's userid
     * @param sessionId The session id from tes_ses_mas table.
     * @return coUserCanStartTest a boolean which decides if the user can take
     *         test or not.
     */

    public boolean checkUserEligibility(String accountId, String userid,
            String sessionId);

    /**
     * Method Name: getMaxSessionID Description: returns maximum session id for
     * given AccountID and userID from test_ses_mas. Arguments:
     * @param accountid
     * @param userid
     * @return maximum session id
     */
    public int getMaxSessionID(String accountid, String userid);

    /**
     * This method counts the no of entries for a particular account id and
     * sessionid in the table test_ses_mas. the count is used to determine which
     * assessment is supposed to be opened for a user.
     * @param accountid
     * @param sessionID
     * @return sessionid
     */

    public int sequenceID(String accountid, String sessionID);

    /**
     * tis method returs the trigram id based on the sequence id.
     * @param sequenceID
     * @return trigramid
     */

    public String getTriGramId(String sequenceID);

    /**
     * this method is used to get the start test flag from the table co_usr_mas.
     * @param accountId the user's account id
     * @param userid the user's userid.
     * @return the start test flag
     */

    public String getStartTestFlag(String accountId, String userid);

    /**
     * this method is used for inserting a new row in the table
     * test_ses_mas.this methos is used if the user is a new user and doesn't
     * have a previous entry in the table.
     * @param usercontext the user context
     */

    public void insertRowTestSessionMaster(UserContext usercontext);

    /**
     * this method is used for inserting a new row in the table
     * test_ses_mas.this method is used for a user who already has completed all
     * the assessment and has a entry in the table but has come to take the
     * assessments again.
     * @param testsessionmaster the object of test session master
     * @param usercontext the user context
     */

    public void insertRowTestSessionMaster(int maxsessionid,
            UserContext usercontext);
}
