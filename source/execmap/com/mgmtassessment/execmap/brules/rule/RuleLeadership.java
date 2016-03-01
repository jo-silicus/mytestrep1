package com.mgmtassessment.execmap.brules.rule;

import java.util.HashMap;
import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;
import com.mgmtassessment.execmap.data.daoapi.ReportDAO;

/**
 * This file is meant for execmap reports section only. It is the parallel of
 * Rule.java for the Leadership reports A and E. It also caters to the
 * Customized reports.
 * @author kumarra
 * @version 1.0
 */

public class RuleLeadership {

    /**
     * Map to store skillscores of a user.
     */
    private HashMap   skillScore;

    /**
     * reference to the object created in application context.
     */
    private ReportDAO reportDAO;

    /**
     * @param acctID of the user.
     * @param sesID of the user.
     * @throws DataNotFoundException thrown from DAO.
     */
    public void setRuleLeadership(String acctID, String sesID)
            throws DataNotFoundException {

        int[] skillIDArray = { 6, 27, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68,
                69, 70, 71, 72, 73 };
        skillScore = (HashMap) getReportDAO().getLeadershipSkillScore(acctID,
                sesID, skillIDArray);
    }

    /**
     * Provides the stanine score for a skill
     * @param skillID representing the skill
     * @return the skill score as float
     */
    public float getSkill(int skillID) {
        float score = 0.0f;
        try {
            score = ((Float) skillScore.get(new Integer(skillID))).floatValue();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
        return score;
    }

    /**
     * * Validates whether the condition ID for a report is valid or not.
     * @param index representing the condID against a report(activity)
     * @return boolean whether the particular condition is validated or not
     */
    public boolean executeRule(int index) {
        float score = 0.0f;
        switch (index) {
            case 1: // Everyone
                return true;
            case 2: // Everyone
                return true;
            case 3: // Everyone
                return true;
            case 4: // Skill 27>5
                score = getSkill(27);
                if (score > 5) {
                    return true;
                }
                break;
            case 5: // Skill 27=5
                score = getSkill(27);
                if (score == 5) {
                    return true;
                }
                break;
            case 6: // Skill 27<5
                score = getSkill(27);
                if (score < 5) {
                    return true;
                }
                break;
            case 7: // Skill 59>5
                score = getSkill(59);
                if (score > 5) {
                    return true;
                }
                break;
            case 8: // Skill 59=5
                score = getSkill(59);
                if (score == 5) {
                    return true;
                }
                break;
            case 9: // Skill 59<5
                score = getSkill(59);
                if (score < 5) {
                    return true;
                }
                break;
            case 10: // Skill 60>5
                score = getSkill(60);
                if (score > 5) {
                    return true;
                }
                break;
            case 11: // Skill 60=5
                score = getSkill(60);
                if (score == 5) {
                    return true;
                }
                break;
            case 12: // Skill 60<5
                score = getSkill(60);
                if (score < 5) {
                    return true;
                }
                break;
            case 13: // Skill 61>5
                score = getSkill(61);
                if (score > 5) {
                    return true;
                }
                break;
            case 14: // Skill 61=5
                score = getSkill(61);
                if (score == 5) {
                    return true;
                }
                break;
            case 15: // Skill 61<5
                score = getSkill(61);
                if (score < 5) {
                    return true;
                }
                break;
            case 16: // Everyone
                return true;
            case 17: // Skill 6>5
                score = getSkill(6);
                if (score > 5) {
                    return true;
                }
                break;
            case 18: // Skill 6=5
                score = getSkill(6);
                if (score == 5) {
                    return true;
                }
                break;
            case 19: // Skill 6<5
                score = getSkill(6);
                if (score < 5) {
                    return true;
                }
                break;
            case 20: // Skill 62>5
                score = getSkill(62);
                if (score > 5)
                    return true;
                break;
            case 21: // Skill 62=5
                score = getSkill(62);
                if (score == 5)
                    return true;
                break;
            case 22: // Skill 62<5
                score = getSkill(62);
                if (score < 5)
                    return true;
                break;
            case 23: // Skill 63>5
                score = getSkill(63);
                if (score > 5)
                    return true;
                break;
            case 24: // Skill 63=5
                score = getSkill(63);
                if (score == 5)
                    return true;
                break;
            case 25: // Skill 63<5
                score = getSkill(63);
                if (score < 5)
                    return true;
                break;
            case 26: // Skill 59>5
                score = getSkill(59);
                if (score > 5)
                    return true;
                break;
            case 27: // Skill 59=5
                score = getSkill(59);
                if (score == 5)
                    return true;
                break;
            case 28: // Skill 59<5
                score = getSkill(59);
                if (score < 5)
                    return true;
                break;
            case 29: // Everyone
                return true;
            case 30: // Skill 64>5
                score = getSkill(64);
                if (score > 5)
                    return true;
                break;
            case 31: // Skill 64=5
                score = getSkill(64);
                if (score == 5)
                    return true;
                break;
            case 32: // Skill 64<5
                score = getSkill(64);
                if (score < 5)
                    return true;
                break;
            case 33: // Skill 65>5
                score = getSkill(65);
                if (score > 5)
                    return true;
                break;
            case 34: // Skill 65=5
                score = getSkill(65);
                if (score == 5)
                    return true;
                break;
            case 35: // Skill 65<5
                score = getSkill(65);
                if (score < 5)
                    return true;
                break;
            case 36: // Skill 66>5
                score = getSkill(66);
                if (score > 5)
                    return true;
                break;
            case 37: // Skill 66=5
                score = getSkill(66);
                if (score == 5)
                    return true;
                break;
            case 38: // Skill 66<5
                score = getSkill(66);
                if (score < 5)
                    return true;
                break;
            case 39: // Skill 67>5
                score = getSkill(67);
                if (score > 5)
                    return true;
                break;
            case 40: // Skill 67=5
                score = getSkill(67);
                if (score == 5)
                    return true;
                break;
            case 41: // Skill 67<5
                score = getSkill(67);
                if (score < 5)
                    return true;
                break;
            case 42: // Skill 68>5
                score = getSkill(68);
                if (score > 5)
                    return true;
                break;
            case 43: // Skill 68=5
                score = getSkill(68);
                if (score == 5)
                    return true;
                break;
            case 44: // Skill 68<5
                score = getSkill(68);
                if (score < 5)
                    return true;
                break;
            case 45: // Everyone
                return true;
            /*
             * The contents of rules 46,47,48 swapped with 52,53,54 on 14 March
             * to change the order of 80 20 and Ready Aim Fire paras in the
             * Leadership A report
             */
            case 46: // Skill 60>5
                score = getSkill(60);
                if (score > 5)
                    return true;
                break;
            case 47: // Skill 60=5
                score = getSkill(60);
                if (score == 5)
                    return true;
                break;
            case 48: // Skill 60<5
                score = getSkill(60);
                if (score < 5)
                    return true;
                break;

            case 49: // Skill 71>5
                score = getSkill(71);
                if (score > 5)
                    return true;
                break;
            case 50: // Skill 71=5
                score = getSkill(71);
                if (score == 5)
                    return true;
                break;
            case 51: // Skill 71<5
                score = getSkill(71);
                if (score < 5)
                    return true;
                break;
            case 52: // Skill 70>5
                score = getSkill(70);
                if (score > 5)
                    return true;
                break;
            case 53: // Skill 70=5
                score = getSkill(70);
                if (score == 5)
                    return true;
                break;
            case 54: // Skill 70<5
                score = getSkill(70);
                if (score < 5)
                    return true;
                break;
            case 55: // Skill 72>5
                score = getSkill(72);
                if (score > 5)
                    return true;
                break;
            case 56: // Skill 72=5
                score = getSkill(72);
                if (score == 5)
                    return true;
                break;
            case 57: // Skill 72<5
                score = getSkill(72);
                if (score < 5)
                    return true;
                break;
            case 58: // Skill 73>5
                score = getSkill(73);
                if (score > 5)
                    return true;
                break;
            case 59: // Skill 73=5
                score = getSkill(73);
                if (score == 5)
                    return true;
                break;
            case 60: // Skill 73<5
                score = getSkill(73);
                if (score < 5)
                    return true;
                break;
        }// end of switch
        return false;
    }// end of executeRule Method

    /**
     * @return Returns the reportDAO.
     */
    public ReportDAO getReportDAO() {
        return reportDAO;
    }

    /**
     * @param reportDAO The reportDAO to set.
     */
    public void setReportDAO(ReportDAO reportDAO) {
        this.reportDAO = reportDAO;
    }

}// end of class

