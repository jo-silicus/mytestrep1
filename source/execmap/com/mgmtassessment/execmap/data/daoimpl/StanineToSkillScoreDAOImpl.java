/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : kapilpra
 * @date : Aug 28, 2006
 * @version:
 *
 * @history Description Reference Name Date
 *
 */

package com.mgmtassessment.execmap.data.daoimpl;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mgmtassessment.execmap.data.dao.types.SkillTriRel;
import com.mgmtassessment.execmap.data.dao.types.TestSesScrDet;
import com.mgmtassessment.execmap.data.dao.types.TestSesSkillScrDet;
import com.mgmtassessment.execmap.data.dao.types.TestSesSkillScrDetKey;
import com.mgmtassessment.execmap.data.daoapi.StanineToSkillScoreDAO;

/**
 * This class calculates skill scores for each skill id from stanine scores for
 * ExecMap User and stores it into database.
 */

public class StanineToSkillScoreDAOImpl extends HibernateDaoSupport implements
        StanineToSkillScoreDAO {
    /**
     * log variable for system health check.
     */
    private static Log log = LogFactory
                                      .getLog(StanineToSkillScoreDAOImpl.class);

    /**
     * query for fetching skillId's.
     */
    private static final String SQL_SKILL_ID =
                                 "select distinct skillId from SkillMaster";

    /**
     * query for fetching stanine score for each skill score.
     */
    private static final String SQL_SKILL_STANINE_SCORE =
         "select str, tssd from SkillTriRel str, TestSesScrDet tssd where "
         + "tssd.comp_id.sesId = ? and str.comp_id.triId = tssd.comp_id.triId "
         + "and tssd.comp_id.acctId = ? and str.comp_id.skillId in (select "
         + "distinct A.comp_id.skillId from SkillTriRel A)"
         + " order by str.comp_id.skillId";

    /**
     * @return skill ids from SKILL_MAS table.
     */
    public List getTotalSkillID() {
        log.info("Fetch skill ID's");
        List skillIDs = new LinkedList();
        List totalSkillID = new LinkedList();
        String allSkillIDQuery = SQL_SKILL_ID;
        skillIDs = getHibernateTemplate().find(SQL_SKILL_ID);
        Iterator totalSkillIDIterator = skillIDs.iterator();
        while (totalSkillIDIterator.hasNext()) {
            totalSkillID.add(new Integer((Short)
                            totalSkillIDIterator.next()));
        }
        log.info("returns total skill ID's");
        return totalSkillID;
    }

    /**
     * @param acctId
     *            Testee account Id.
     * @param sesId
     *            Testee session Id. This method fetches stanine score
     *            corresponding to each skill score from database and put in
     *            'allSkillStanineScore' TreeMap. Arguments: acct_id - Testee
     *            account Id. ses_id - Testee session Id. Returns:
     *            allSkillStanineScore - contains trigramID, subtestID
     *            stanineScore for each SkillScore
     * @return TreeMap
     */
    public TreeMap fetchSkillStanineScore(String acctId, String sesId) {
        log.info("Fetch stanine scores corresponding to skill ID's");
        TreeMap allStanineScore = null;
        TreeMap allSkillStanineScore = new TreeMap();
        allStanineScore = new TreeMap();
        int oldSkillID = 1;
        Object[] params = new Object[] {sesId, acctId};
        List tempList = getHibernateTemplate().find(SQL_SKILL_STANINE_SCORE,
                params);
        Iterator tempListIterator = tempList.iterator();
        while (tempListIterator.hasNext()) {
            Object[] row = (Object[])
                             tempListIterator.next();
            SkillTriRel skillTriRel = (SkillTriRel)
                                                row[0];
            TestSesScrDet testSesScrDet = (TestSesScrDet)
                                                row[1];
            int skillID = skillTriRel.getComp_id().getSkillId().intValue();
            String trigramID = skillTriRel.getComp_id().getTriId();
            String subTestID = testSesScrDet.getComp_id().getSubTestId();
            int stan_score = testSesScrDet.getStanScore().intValue();
            if (oldSkillID != skillID) {
                allSkillStanineScore.put(new Integer(oldSkillID),
                        allStanineScore);
                oldSkillID = skillID;
                allStanineScore = new TreeMap();
            }
            List scoreSubtestID = new LinkedList();
            scoreSubtestID.add(subTestID.trim());
            scoreSubtestID.add(new Integer(stan_score));
            allStanineScore.put(trigramID.trim(), scoreSubtestID);
        }
        allSkillStanineScore.put(new Integer(oldSkillID), allStanineScore);
        return allSkillStanineScore;
    }

    /**
     * @param acctId
     *            Testee account Id.
     * @param sesId
     *            Testee session Id.
     * @param allSkillScore
     *            skillID and corresponding score. This method insert skill
     *            score in table TEST_SES_SKILL_SCR_DET for given acct_id and
     *            ses_id.
     * @return
     */
    public void insertSkillScore(String acctId, String sesId,
            TreeMap allSkillScore) {
        log.info("Try to save data in test_ses_skill_scr_det table");
        Set allSkillSet = allSkillScore.keySet();
        Iterator allSkill = allSkillSet.iterator();
        while (allSkill.hasNext()) {
            Short skillID = new Short(((Integer)
                                  allSkill.next()).shortValue());
            TestSesSkillScrDetKey testSesSkillScrDetKey =
                new TestSesSkillScrDetKey(acctId, new Integer(sesId), skillID);
            BigDecimal averageRounded = new BigDecimal((Float)
                              allSkillScore.get(new Integer(skillID)));
            TestSesSkillScrDet testSesSkillScrDet = new TestSesSkillScrDet(
                    testSesSkillScrDetKey, averageRounded);
            getHibernateTemplate().save(testSesSkillScrDet);
        }
    }
}