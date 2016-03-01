/**
 *  @Copyright Management Assessment Partners (MAP) AG
 *  All Rights Reserved.
 *
 *  @author : ChabraNi
 *  @date   : Aug 24, 2006
 *  @version:
 *
 *  @history
 *  Description         Reference       Name        Date
 *
 */

package com.mgmtassessment.execmap.business.model;

import java.util.LinkedList;

/**
 * This class is a model for
 * testeeID, username and his score
 * on all skills.
 *
 */

public class UserScoreInfoModel {
    /**
     * Testee ID.
     */
    private String testeeId;
    /**
     * Username.
     */
    private String userName;
    /**
     * List of all scores on various skills
     * selected on AdminGroupReport jsp.
     */
    private LinkedList userScore;

    /**
     * @return Returns the testeeId.
     */
    public String getTesteeId() {
        return testeeId;
    }

    /**
     * @param testeeId
     * The testeeId to set.
     */
    public void setTesteeId(String testeeId) {
        this.testeeId = testeeId;
    }

    /**
     * @return Returns the userName.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     * The userName to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return Returns the userScore.
     */
    public LinkedList getUserScore() {
        return userScore;
    }

    /**
     * @param userScore
     * The userScore to set.
     */
    public void setUserScore(LinkedList userScore) {
        this.userScore = userScore;
    }
}