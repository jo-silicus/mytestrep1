/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : singhrau
 * @date : Aug 25, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.data.daoimpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mgmtassessment.execmap.common.util.search.HQLSearch;
import com.mgmtassessment.execmap.data.dao.types.CompanyUserMaster;
import com.mgmtassessment.execmap.data.dao.types.CompanyUserMasterKey;
import com.mgmtassessment.execmap.data.dao.types.TestSesScrDet;
import com.mgmtassessment.execmap.data.dao.types.TestSessionMaster;
import com.mgmtassessment.execmap.data.dao.types.TestSessionMasterKey;
import com.mgmtassessment.execmap.data.dao.types.TrigramMaster;
import com.mgmtassessment.execmap.data.daoapi.AssessmentDAO;

/**
 * This class is the implementation to the assessment dao.It consists of methods
 * to check the user availability, to store data in test_se_mas,test_ses_scr_det
 * and test_ses_skill_scr_det.
 */

public class AssessmentDAOImpl extends HibernateDaoSupport implements
        AssessmentDAO {

    private static Log        log    = LogFactory
                                         .getLog(AssessmentDAOImpl.class);

    /**
     * the hql search object.
     */
    private HQLSearch         hqlsearch;

    /**
     * the hibernate template object.
     */
    private HibernateTemplate hibernateTemplate = null;

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
     * returns maximum session id for given AccountID and userID from
     * test_ses_mas.
     * @param accountid the user's account id
     * @param userid the user's user id
     * @return maximum session id
     * @throws DataRetrievalFailureException
     */
    public int getMaxSessionID(String accountid, String userid)
            throws DataRetrievalFailureException {

        List resultList;
        HashMap placeHolders = new HashMap();
        int sessionid = 0;

        if (accountid != null) {
            placeHolders.put("acctid", accountid);
        }
        if (userid != null) {
            placeHolders.put("userid", userid);
        }
        try {
            resultList = hqlsearch.search("FindSessionIdKey", placeHolders);
            int count = ((Integer) resultList.get(0)).intValue();
            if (count != 0) {
                resultList = hqlsearch.search("GetMaximumSessionIdKey",
                        placeHolders);

                sessionid = ((Integer) resultList.get(0)).intValue();

            } else {
                sessionid = 0;
            }
        } catch (Exception e) {

            throw new DataRetrievalFailureException("", e);

        }
        return sessionid;
    }

    /**
     * get the value of start flag from co_usr_mas for given AccountID and
     * UserID.
     * @param accountid the user's account id
     * @param userid the user's userid
     * @return Value of start flag in co_usr_mas
     * @throws DataRetrievalFailureException
     */
    public String getStartTestFlag(String accountid, String userid)
            throws DataRetrievalFailureException {
        String startFlag = "F";

        List resultList;
        HashMap placeHolders = new HashMap();
        int session = 0;

        if (accountid != null) {
            placeHolders.put("acctid", accountid);
        }
        if (userid != null) {
            placeHolders.put("userid", userid);
        }
        try {
            resultList = hqlsearch.search("GetStartTestFlagKey", placeHolders);

            if (resultList.size() > 0) {
                startFlag = resultList.get(0).toString();

            }

        } catch (Exception e) {
            throw new DataRetrievalFailureException("", e);
        }
        return startFlag;
    }

    /**
     * gets the value of complete flag in test_ses_mas for accountID and UserID.
     * @param accountid the user's account id
     * @param sessionid the session id from the table test_ses_mas
     * @param userid the user's userid
     * @return value of complete flag
     * @throws DataRetrievalFailureException
     */
    public String getCompleteFlag(String accountid, String userid,
            String sessionid) throws DataRetrievalFailureException {

        String completeFlag = "";
        Integer sesid = new Integer(Integer.parseInt(sessionid));
        List resultList;
        HashMap placeHolders = new HashMap();
        int session = 0;

        if (accountid != null) {
            placeHolders.put("acctid", accountid);
        }
        if (userid != null) {
            placeHolders.put("userid", userid);
        }
        if (sessionid != null) {
            placeHolders.put("sessionid", sesid);
        }
        try {
            resultList = hqlsearch.search("CountCompleteFlagKey", placeHolders);
            int count = ((Integer) resultList.get(0)).intValue();
            if (count != 0) {
                resultList = hqlsearch.search("GetCompleteFlagKey",
                        placeHolders);
                completeFlag = resultList.get(0).toString();

            } else {
                completeFlag = "";
            }

        } catch (Exception e) {
            throw new DataRetrievalFailureException("", e);
        }
        return completeFlag;
    }

    /**
     * return how many days left out of 14 days to appear in the exam from
     * test_ses_mas.
     * @param accountid the user's account id
     * @param sessionid the session id from the table test_ses_mas
     * @param userid the user's userid
     * @return days left out of 14 days to appear in test.
     * @throws DataRetrievalFailureException
     */
    public int getDays14Crossed(String accountid, String userid,
            String sessionid) throws DataRetrievalFailureException {
        int daysLeft = 0;

        List resultList;
        Integer sesid = new Integer(Integer.parseInt(sessionid));
        HashMap placeHolders = new HashMap();

        if (accountid != null) {
            placeHolders.put("acctid", accountid);
        }
        if (userid != null) {
            placeHolders.put("userid", userid);
        }
        if (sessionid != null) {
            placeHolders.put("sessionid", sesid);
        }
        try {
            resultList = hqlsearch.search("GetDays14CrossedKey", placeHolders);

            if (resultList.size() > 0) {
                daysLeft = ((Short) resultList.get(0)).shortValue();
            }
        } catch (Exception e) {
            throw new DataRetrievalFailureException("", e);
        }
        return daysLeft;
    }

    /**
     * sets the complete flag to show that testee has completed all the test.
     * @param accountid the user's account id
     * @param sessionid the session id from the table test_ses_mas
     * @param flag the complete flag value which may have value 'F' means all
     *        test not completed, 'N' which means all test not completed but 14
     *        days is over and 'T' means completed all Test.
     */
    public void setCompleteFlag(String accountid, String sessionid, String flag) {

        hibernateTemplate = getHibernateTemplate();
        TestSessionMasterKey testSessionMasterKey = new TestSessionMasterKey(
                accountid, new Integer(sessionid));
        TestSessionMaster testSessionMaster =
                             (TestSessionMaster) getHibernateTemplate()
                .get(TestSessionMaster.class, testSessionMasterKey);

        testSessionMaster.setCompFlg(flag);
        hibernateTemplate.saveOrUpdate(testSessionMaster);

    }

    /**
     * sets the start flag which means whether user can start start test.
     * @param accountid the user's account id
     * @param userid the user's userid
     * @param startFlag which may have value 'F' means user cannot start test
     *        and 'T' means user can start test.
     */
    public void setStartFlag(String accountid,
                        String userid, String startFlag) {

        hibernateTemplate = getHibernateTemplate();
        CompanyUserMasterKey companyUserMasterKey = new CompanyUserMasterKey(
                accountid, userid);
        CompanyUserMaster companyUserMaster =
                        (CompanyUserMaster) getHibernateTemplate()
                .get(CompanyUserMaster.class, companyUserMasterKey);

        companyUserMaster.setStartFlg(startFlag);
        hibernateTemplate.saveOrUpdate(companyUserMaster);

    }

    /**
     * the method first gets the max value of session id in test_ses_mas and
     * then (for a new user) increments this value by one and inserts it
     * corresponding to the new user's accountid and userid.
     * @param testsessionmaster the tesetsessionmaster object from the manager
     * @throws DataRetrievalFailureException
     */
    public int getAndInsertSessionID(TestSessionMaster testsessionmaster)
            throws DataRetrievalFailureException {

        String accountid = testsessionmaster.getComp_id().getAcctId();
        List resultList;
        HashMap placeHolders = new HashMap();
        int sessionid = 0;

        if (accountid != null) {
            placeHolders.put("acctid", accountid);
        }

        try {
            
            resultList= hqlsearch.search("SearchAccountIdQueryKey", placeHolders);
            int count = ((Integer) resultList.get(0)).intValue();
            if (count != 0) {
            
            resultList = hqlsearch.search("SessionQueryKey", placeHolders);

            if (resultList.size() > 0) {
                sessionid = ((Integer) resultList.get(0)).intValue();
                sessionid = sessionid + 1;
                testsessionmaster.getComp_id().setSesId(new Integer(sessionid));
            }
        }
            else{
                sessionid = new Integer(1);
                testsessionmaster.getComp_id().setSesId(new Integer(sessionid));
            }
        } catch (Exception e) {
            throw new DataRetrievalFailureException("", e);
        }

        try {

            hibernateTemplate = getHibernateTemplate();
            hibernateTemplate.save(testsessionmaster);

        } catch (Exception e) {

            throw new DataRetrievalFailureException("", e);
        }

        return (sessionid);

    }

    /**
     * this method gets the session id for an existing user from the table
     * test_ses_mas and updates the fields like timesanswerchanged and times
     * activity expired.
     * @param testsessionmaster the tesetsessionmaster object from the manager
     * @throws DataRetrievalFailureException
     */
    public void getAndupdateSessionID(TestSessionMaster testsessionmaster)
            throws DataRetrievalFailureException {

        hibernateTemplate = getHibernateTemplate();
        TestSessionMasterKey testSessionMasterKey = new TestSessionMasterKey(
                testsessionmaster.getComp_id().getAcctId(), testsessionmaster
                        .getComp_id().getSesId());

        TestSessionMaster testSessionMaster =
                           (TestSessionMaster) getHibernateTemplate()
                .get(TestSessionMaster.class, testSessionMasterKey);
        // testSessionMaster.setComp_id(testSessionMasterKey);
        testSessionMaster.setTimesAnserChanged(testsessionmaster
                .getTimesAnserChanged());
        testSessionMaster.setTimesExpired(testsessionmaster.getTimesExpired());
        // testSessionMaster.setDtEnd((Timestamp) new Date());
        hibernateTemplate.saveOrUpdate(testSessionMaster);

    }

    /**
     * this method stores the score of the user in the table test_ses_scr_det.
     * @param testsesscrdet the testsesscrdet object from the manager
     * @throws DataRetrievalFailureException
     */
    public void saveDataTestSesScrDet(TestSesScrDet testsesscrdet)
            throws DataRetrievalFailureException {

        try {

            hibernateTemplate = getHibernateTemplate();
            hibernateTemplate.saveOrUpdate(testsesscrdet);
        } catch (Exception e) {
            throw new DataRetrievalFailureException("", e);
        }

    }

    /**
     * this method calculates the stanine score from the corresponding raw score
     * for a particular user.
     * @param rawscore the rawscore of the user
     * @param trigramid the trigramid of the assessment
     * @throws DataRetrievalFailureException
     */

    public BigDecimal calculateStanineScore(String trigramid,
            BigDecimal rawscore) throws DataRetrievalFailureException {

        BigDecimal staninescore = new BigDecimal(0);
        HashMap placeHolders = new HashMap();
        List stanScore;
        if(trigramid.equalsIgnoreCase("MEMWS")){
                trigramid="MEM";
        }
        placeHolders.put("TRIID", trigramid);
        placeHolders.put("RAWSCORE", rawscore);
        try {
            stanScore = hqlsearch.search("StanineScoreQueyKey", placeHolders);
            if (stanScore.size() > 0) {

                staninescore = (BigDecimal) stanScore.get(0);
            }

        }

        catch (Exception e) {
            throw new DataRetrievalFailureException("", e);
        }

        int stanineScore = (staninescore).intValue();
        if (stanineScore < 1) {
            staninescore = new BigDecimal(1);
        } else if (stanineScore > 9) {
            staninescore = new BigDecimal(9);
        }

        return staninescore;
    }

    /**
     * this method calculates the stanine score from the corresponding raw score
     * and Standard deviation for a particular user for NFU assessment.
     * @param rawscore the rawscore of the user
     * @param trigramid the trigramid of the assessment
     * @param stddeviation the standard deviation of the slider
     * @throws DataRetrievalFailureException
     */

    public BigDecimal calculateNfuStanineScore(String trigramid,
            BigDecimal rawscore, BigDecimal stddeviation)
            throws DataRetrievalFailureException {

        BigDecimal staninescore = new BigDecimal(0);
        HashMap placeHolders = new HashMap();
        List stanScore;
        placeHolders.put("TRIID", trigramid);
        placeHolders.put("RAWSCORE", rawscore);
        stddeviation = stddeviation.setScale(30, BigDecimal.ROUND_HALF_UP);
        placeHolders.put("STDDEVIATION", stddeviation);
        try {
            stanScore = hqlsearch
                    .search("StanineScoreNFUQueyKey", placeHolders);
            if (stanScore.size() > 0) {

                staninescore = (BigDecimal) stanScore.get(0);
            }

        }

        catch (Exception e) {
            throw new DataRetrievalFailureException("", e);
        }

        int stanineScore = (staninescore).intValue();
        if (stanineScore < 1) {
            staninescore = new BigDecimal(1);
        } else if (stanineScore > 9) {
            staninescore = new BigDecimal(9);
        }

        return staninescore;
    }

    /**
     * this method is use to retrieve the sequenceId which is the no of
     * rowscorresponding to the given accountId and sessionId.
     * @param accountid
     * @param sessionID
     * @return int
     */
    public int sequenceID(String accountid, String sessionID)
            throws DataRetrievalFailureException {
        HashMap placeHolders = new HashMap();
        List query = new ArrayList();
        int sequenceID;
        placeHolders.put("ACCTID", accountid);
        placeHolders.put("SESSIONID", sessionID);

        try {
            query = hqlsearch.search("GetSequenceIdQueryKey", placeHolders);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            throw new DataRetrievalFailureException("", e);
        }

        sequenceID = ((Integer) query.get(0)).intValue();

        return sequenceID;
    }

    /**
     * this method retrieves the trigramId given in the triGramMaster table c
     * corresponding to the given sessionId.
     * @param sequenceID
     * @return String
     */
    public String getTriGramId(String sequenceID)
            throws DataRetrievalFailureException {
        HashMap placeHolders = new HashMap();
        List query = new ArrayList();
        String triGramId = null;
        placeHolders.put("SEQUENCEID", sequenceID);
        try {
            query = hqlsearch.search("GetTriGramIdQueryKey", placeHolders);

            Iterator iterator = query.iterator();

            while (iterator.hasNext()) {
                TrigramMaster trigramMaster = (TrigramMaster) iterator.next();

                triGramId = trigramMaster.getTriId().trim();

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            throw new DataRetrievalFailureException("", e);
        }

        return triGramId;
    }

}
