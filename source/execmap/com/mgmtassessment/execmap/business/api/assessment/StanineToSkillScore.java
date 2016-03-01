/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : kapilpra
 * @date : Aug 28, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.business.api.assessment;

/**
 * This class calculates skills scores
 * from stanine scores.
 */

public interface StanineToSkillScore {
    /**
     * @param acctId
     * Testee account Id.
     * @param sesId
     * Testee session Id.
     * Converts the stanine score to skill score and stores it into database.
     * @return
     */
    void stanineToSkillScore(String acctId, String sesId);
}
