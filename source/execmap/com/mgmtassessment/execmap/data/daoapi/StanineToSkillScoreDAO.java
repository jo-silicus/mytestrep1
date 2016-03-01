/**
 *  @Copyright Management Assessment Partners (MAP) AG
 *  All Rights Reserved.
 *
 *  @author : kapilpra
 *  @date   : Aug 28, 2006
 *  @version:
 *
 *  @history
 *  Description         Reference       Name        Date
 *
 */

package com.mgmtassessment.execmap.data.daoapi;

import java.util.List;
import java.util.TreeMap;

/**
 * This class is for fetching and inserting skill scores.
 */

public interface StanineToSkillScoreDAO {
    /**
     * @return skill ids from SKILL_MAS table.
     */
    List getTotalSkillID();
    /**
     * @param acctId
     * Testee account Id.
     * @param sesId
     * Testee session Id.
     * This method fetches stanine score corresponding to each skill
     * score from database and put in allSkillStanineScore TreeMap.
     * @return allSkillStanineScore - contains trigramID, subtestID
     * stanineScore for each SkillScore.
     */
    TreeMap fetchSkillStanineScore(String acctId, String sesId);
    /**
     * @param acctId
     * Testee account Id.
     * @param sesId
     * Testee session Id.
     * @param allSkillScore
     * skillID and corresponding score.
     * This method insert skill score in table TEST_SES_SKILL_SCR_DET
     * for given acct_id and ses_id.
     * Arguments:   acct_id - Testee account Id. ses_id - Testee session Id.
     * allSkillScore - skillID and corresponding score Returns:     none
     */
    void insertSkillScore(String acctId, String sesId, TreeMap allSkillScore);
}
