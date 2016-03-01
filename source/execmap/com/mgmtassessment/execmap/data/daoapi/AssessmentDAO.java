/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : singhrau
 * @date : Aug 25, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.data.daoapi;

import java.math.BigDecimal;

import org.springframework.dao.DataRetrievalFailureException;

import com.mgmtassessment.execmap.data.dao.types.TestSesScrDet;
import com.mgmtassessment.execmap.data.dao.types.TestSessionMaster;

/**
 * This class is the facade for assessment dao. It consists of methods to check
 * the user availability, to store data in test_se_mas,test_ses_scr_det and
 * test_ses_skill_scr_det.
 */

public interface AssessmentDAO {

    /**
     * returns maximum session id for given AccountID and userID from
     * test_ses_mas.
     * @param accountid
     *            the user's account id
     * @param userid
     *            the user's user id
     * @return maximum session id
     * @throws DataRetrievalFailureException
     */

    public int getMaxSessionID(String accountid, String userid)
            throws DataRetrievalFailureException;

    /**
     * get the value of start flag from co_usr_mas for given AccountID and
     * UserID.
     * @param accountid
     *            the user's account id
     * @param userid
     *            the user's userid
     * @return Value of start flag in co_usr_mas
     * @throws DataRetrievalFailureException
     */

    public String getStartTestFlag(String accountid, String userid)
            throws DataRetrievalFailureException;

    /**
     * gets the value of complete flag in test_ses_mas for accountID and UserID.
     * @param accountid
     *            the user's account id
     * @param sessionid
     *            the session id from the table test_ses_mas
     * @param userid
     *            the user's userid
     * @return value of complete flag
     * @throws DataRetrievalFailureException
     */

    public String getCompleteFlag(String accountid, String userid,
           String sessionid) throws DataRetrievalFailureException;

    /**
     * return how many days left out of 14 days to appear in the exam from
     * test_ses_mas.
     * @param accountid
     *            the user's account id
     * @param sessionid
     *            the session id from the table test_ses_mas
     * @param userid
     *            the user's userid
     * @return days left out of 14 days to appear in test.
     * @throws DataRetrievalFailureException
     */

    public int getDays14Crossed(String accountid, String userid,
            String sessionid) throws DataRetrievalFailureException;

    /**
     * sets the complete flag to show that testee has completed all the test.
     * @param accountid
     *            the user's account id
     * @param sessionid
     *            the session id from the table test_ses_mas
     * @param flag
     *            the complete flag value which may have value 'F' means all
     *            test not completed, 'N' which means all test not completed but
     *            14 days is over and 'T' means completed all Test.
     */

    public void setCompleteFlag(String accountid, String sessionid, String flag);

    /**
     * sets the start flag which means whether user can start start test.
     * @param accountid
     *            the user's account id
     * @param userid
     *            the user's userid
     * @param startFlag
     *            which may have value 'F' means user cannot start test and 'T'
     *            means user can start test.
     */

    public void setStartFlag(String accountid, String userid, String startFlag);

    /**
     * the method first gets the max value of session id in test_ses_mas and
     * then (for a new user) increments this value by one and inserts it
     * corresponding to the new user's accountid and userid.
     * @param testsessionmaster
     *            the tesetsessionmaster object from the manager
     * @throws DataRetrievalFailureException
     */

    public int getAndInsertSessionID(TestSessionMaster testsessionmaster);

    /**
     * this method gets the session id for an existing user from the table
     * test_ses_mas and updates the fields like timesanswerchanged and times
     * activity expired.
     * @param testsessionmaster
     *            the tesetsessionmaster object from the manager
     * @throws DataRetrievalFailureException
     */

    public void getAndupdateSessionID(TestSessionMaster testsessionmaster)
            throws DataRetrievalFailureException;

    /**
     * this method stores the score of the user in the table test_ses_scr_det.
     * @param testsesscrdet
     *            the testsesscrdet object from the manager
     * @throws DataRetrievalFailureException
     */

    public void saveDataTestSesScrDet(TestSesScrDet testsesscrdet)
            throws DataRetrievalFailureException;

    /**
     * this method calculates the stanine score from the corresponding raw score
     * for a particular user.
     * @param rawscore
     *            the rawscore of the user
     * @param trigramid
     *            the trigramid of the assessment
     * @throws DataRetrievalFailureException
     */

    public BigDecimal calculateStanineScore(String trigramid,
            BigDecimal rawscore) throws DataRetrievalFailureException;

    /**
     * this method is use to retrieve the sequenceId which is the no of
     * rowscorresponding to the given accountId and sessionId.
     * @param accountid
     * @param sessionID
     * @return int
     */
    public int sequenceID(String accountid, String sessionID);

    /**
     * this method retrieves the trigramId given in the triGramMaster table c
     * corresponding to the given sessionId.
     * @param sequenceID
     * @return String
     */

    public String getTriGramId(String sequenceID);

    /**
     * this method calculates the stanine score from the corresponding raw score
     * and Standard deviation for a particular user for NFU assessment.
     * @param rawscore
     *            the rawscore of the user
     * @param trigramid
     *            the trigramid of the assessment
     * @param stddeviation
     *            the standard deviation of the slider
     * @throws DataRetrievalFailureException
     */
    public BigDecimal calculateNfuStanineScore(String trigramid,
            BigDecimal rawscore, BigDecimal stddeviation)
            throws DataRetrievalFailureException;

}
