package com.mgmtassessment.execmap.brules.rule;

import java.util.HashMap;

import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;
import com.mgmtassessment.execmap.data.daoapi.ReportDAO;


/**
 * Description: This class encapsulates the business logic for ExecMap Executive
 * Reports.
 *
 * @version 1.0
 * @author Nitin Goenka
 * @see RuleEvaluatorShort.java
 */

public class RuleExecSummary {

/**
 * HashMap for storing skillScores.
 */
    private HashMap skillScore;
/**
 *
 */
    private boolean flag1 = false;
/**
 *
 */
    private boolean flag2 = false;
/**
 *
 */
    private boolean flag3 = false;
/**
 *
 */
    private boolean flag4 = false;
/**
 * reference for accessing reportDAOImpl methods.
 */
    private ReportDAO reportDAO;

/**
 * @param acctID of the user.
 * @param sesID of the user.
 * @throws DataNotFoundException
 * gets skill scores from the database
 */
    public void setRuleExecSummary(String acctID, String sesID)
                                                 throws DataNotFoundException {
        skillScore = new HashMap();
        int [] skillIDArray = new int[59];
        for (int skillID = 0; skillID < skillIDArray.length; skillID++) {
            skillIDArray[skillID] = skillID + 1;
        }
        skillScore = (HashMap)(getReportDAO().getLeadershipSkillScore(acctID,
        sesID, skillIDArray));
    }
/**
 *
 * @param skillID
 * @return
 * @return score from skillScore MashMap
 */
    public float getSkill(int skillID) {
        float score = 0.0f;
        try {
            score = ((Float)skillScore.get(new Integer(skillID))).floatValue();
        } catch (Exception npe) {
            npe.printStackTrace();
        }
        return score;
    }

    public boolean executeRule(int index) {

        float figScore = 0.0f; // 1
        float symScore = 0.0f; // 2
        float semScore = 0.0f; // 3
        float classScore = 0.0f; // 15
        float evalScore = 0.0f; // 6

        float clarityOfPurposeScore = 0.0f; // 29
        float decisionMakingScore = 0.0f; // 30
        float directingScore = 0.0f; // 31
        float planningScore = 0.0f; // 32
        float counsellingScore = 0.0f; // 33

        float divergentProdScore = 0.0f; // 8
        float intutionScore = 0.0f; // 24

        float dealMinInfoScore = 0.0f; // 57
        float budgetingScore = 0.0f; // 58
        float flexibilityScore = 0.0f; // 59

        switch (index) {
        case 1: // Skills 1,2,3 >4 & Skill 30>5 & Skill 33<5

            return true;

        case 2: // Skills 1,2,3 >4 & Skill 30>5 & Skill 31>6 & Skill 33<5
                // (SULDDOM)
            figScore = getSkill(1);
            symScore = getSkill(2);
            semScore = getSkill(3);
            decisionMakingScore = getSkill(30);
            counsellingScore = getSkill(33);
            directingScore = getSkill(31);
            if ((figScore > 4) && (symScore > 4) && (semScore > 4)
                    && (directingScore > 6) && (decisionMakingScore > 5)
                    && (counsellingScore < 5)) {
                flag1 = true;
                return true;
            }

            break;
        case 3: // Skills 1,2,3 >4 & Skill 15>6 & Skill 30>5 & Skill 33>5
                figScore = getSkill(1);
            symScore = getSkill(2);
            semScore = getSkill(3);
            decisionMakingScore = getSkill(30);
            counsellingScore = getSkill(33);
            classScore = getSkill(15);
            if ((!flag1) && (figScore > 4) && (symScore > 4)
                    && (semScore > 4) && (classScore > 6)
                    && (decisionMakingScore > 5) && (counsellingScore > 5)) {
                flag1 = true;
                return true;
            }
            break;
        case 4: // Skills 1>4 & Skills 2&3>2 & Skill 6 <5 & Skill 33 >4
                // Congenial
            figScore = getSkill(1);
            symScore = getSkill(2);
            semScore = getSkill(3);
            evalScore = getSkill(6);
            counsellingScore = getSkill(33);
            if ((!flag1) && (figScore > 4) && (symScore > 2)
                    && (semScore > 2) && (evalScore < 5)
                    && (counsellingScore > 4)) {
                flag1 = true;
                return true;
            }
            break;
        case 5: // Skills 1,3 >3 Skill 2 >2 & Skill 30>4 & Skill 33>3
                // Situational
            figScore = getSkill(1);
            symScore = getSkill(2);
            semScore = getSkill(3);
            decisionMakingScore = getSkill(30);
            counsellingScore = getSkill(33);
            if ((!flag1) && (figScore > 2) && (symScore > 2)
                    && (semScore > 3) && (decisionMakingScore > 4)
                    && (counsellingScore > 3)) {
                flag1 = true;
                return true;
            }
            break;
        case 6: // Condition 1,2,3,4 not met General
            if (!flag1) {
                flag4 = true;
                return true;
            }
            break;
        case 7: // Skill 1,2,3 >3 & RND Avg(Skill 31,32,58)>RND Avg(Skills 8,
                // 24, 59)
            figScore = getSkill(1);
            symScore = getSkill(2);
            semScore = getSkill(3);
            directingScore = getSkill(31);
            planningScore = getSkill(32);
            budgetingScore = getSkill(58);
            divergentProdScore = getSkill(8);
            intutionScore = getSkill(24);
            flexibilityScore = getSkill(59);
            if ((!flag4)
                    && (figScore > 3)
                    && (symScore > 3)
                    && (semScore > 3)
                    && (Math
                            .round((directingScore + planningScore
                                    + budgetingScore) / 3)) > (Math
                            .round((divergentProdScore
                                    + intutionScore + flexibilityScore) / 3))) {
                flag2 = true;
                return true;
            }

            break;
        case 8: // Skill 1,2,3 >3 & RND Avg(Skill 31,32,58)<RND Avg(Skills 8,
                // 24, 59)
            figScore = getSkill(1);
            symScore = getSkill(2);
            semScore = getSkill(3);
            directingScore = getSkill(31);
            planningScore = getSkill(32);
            budgetingScore = getSkill(58);
            divergentProdScore = getSkill(8);
            intutionScore = getSkill(24);
            flexibilityScore = getSkill(59);
            if ((!flag4)
                    && (figScore > 3)
                    && (symScore > 2)
                    && (semScore > 3)
                    && (Math
                            .round((directingScore + planningScore
                                    + budgetingScore) / 3)) < (Math
                            .round((divergentProdScore + intutionScore
                                    + flexibilityScore) / 3))) {
                flag2 = true;
                return true;
            }

            break;
        case 9: // Skill 1,2,3 >3 RND Avg(Skill 31,32,58)=RND Avg(Skills 8, 24,
                // 59)
            figScore = getSkill(1);
            symScore = getSkill(2);
            semScore = getSkill(3);
            directingScore = getSkill(31);
            planningScore = getSkill(32);
            budgetingScore = getSkill(58);
            divergentProdScore = getSkill(8);
            intutionScore = getSkill(24);
            flexibilityScore = getSkill(59);
            if ((!flag4)
                    && (figScore > 3)
                    && (symScore > 2)
                    && (semScore > 3)
                    && (Math
                            .round((directingScore + planningScore
                                    + budgetingScore) / 3)) == (Math
                            .round((divergentProdScore + intutionScore
                                    + flexibilityScore) / 3))) {
                flag2 = true;
                return true;
            }

            break;
        case 10: // Condition 6,7,8 not met
            if (!flag2) {
                return true;
            }
            break;
        case 11: // Skill 29 <4
            clarityOfPurposeScore = getSkill(29);
            if (clarityOfPurposeScore < 4) {
                return true;
            }
            break;
        case 12: // Skill 29 >3<7
            clarityOfPurposeScore = getSkill(29);
            if ((clarityOfPurposeScore > 3) && (clarityOfPurposeScore < 7)) {
                return true;
            }
            break;
        case 13: // Skill 29 >6
            clarityOfPurposeScore = getSkill(29);
            if (clarityOfPurposeScore > 6) {
                return true;
            }
            break;
        case 14: // Skill 30 > 5 and Skill 57>5
            decisionMakingScore = getSkill(30);
            dealMinInfoScore = getSkill(57);
            if ((decisionMakingScore > 5) && (dealMinInfoScore > 5)) {
                return true;
            }
            break;
        case 15: // Skill 30 > 5 and Skill 57=5
            decisionMakingScore = getSkill(30);
            dealMinInfoScore = getSkill(57);
            if ((decisionMakingScore > 5) && (dealMinInfoScore == 5)) {
                return true;
            }
            break;
        case 16: // Skill 30 > 5 and Skill 57<5
            decisionMakingScore = getSkill(30);
            dealMinInfoScore = getSkill(57);
            if ((decisionMakingScore > 5) && (dealMinInfoScore < 5)) {
                return true;
            }
            break;
        case 17: // Skill 30 = 5 and Skill 57>5
            decisionMakingScore = getSkill(30);
            dealMinInfoScore = getSkill(57);
            if ((decisionMakingScore == 5) && (dealMinInfoScore > 5)) {
                return true;
            }
            break;
        case 18: // Skill 30 = 5 and Skill 57=5
            decisionMakingScore = getSkill(30);
            dealMinInfoScore = getSkill(57);
            if ((decisionMakingScore == 5) && (dealMinInfoScore == 5)) {
                return true;
            }
            break;
        case 19: // Skill 30 = 5 and Skill 57<5
            decisionMakingScore = getSkill(30);
            dealMinInfoScore = getSkill(57);
            if ((decisionMakingScore == 5) && (dealMinInfoScore < 5)) {
                return true;
            }
            break;
        case 20: // Skill 30 < 5 and Skill 57>5
            decisionMakingScore = getSkill(30);
            dealMinInfoScore = getSkill(57);
            if ((decisionMakingScore < 5) && (dealMinInfoScore > 5)) {
                return true;
            }
            break;
        case 21: // Skill 30 < 5 and Skill 57=5
            decisionMakingScore = getSkill(30);
            dealMinInfoScore = getSkill(57);
            if ((decisionMakingScore < 5) && (dealMinInfoScore == 5)) {
                return true;
            }
            break;
        case 22: // Skill 30 < 5 and Skill 57<5
            decisionMakingScore = getSkill(30);
            dealMinInfoScore = getSkill(57);
            if ((decisionMakingScore < 5) && (dealMinInfoScore < 5)) {
                return true;
            }
            break;
        case 23: // Skill 1,2 >2 Skill 3 >3 Skill 30 >5 Skill 33>3<7
            figScore = getSkill(1);
            symScore = getSkill(2);
            semScore = getSkill(3);
            decisionMakingScore = getSkill(30);
            counsellingScore = getSkill(33);
            if ((figScore > 2) && (symScore > 2) && (semScore > 3)
                    && (decisionMakingScore > 5) && (counsellingScore > 3)
                    && (counsellingScore < 7)) {
                flag3 = true;
                return true;
            }
            break;
        case 24: // Skill 1,2>2 Skill 3 >3 Skill 30 >3<6 Skill 33>3<7
            figScore = getSkill(1);
            symScore = getSkill(2);
            semScore = getSkill(3);
            decisionMakingScore = getSkill(30);
            counsellingScore = getSkill(33);
            if ((figScore > 2) && (symScore > 2) && (semScore > 3)
                    && (decisionMakingScore > 3) && (decisionMakingScore < 6)
                    && (counsellingScore > 3) && (counsellingScore < 7)) {
                flag3 = true;
                return true;
            }
            break;
        case 25: // Skill 1,2 >2 Skill 3 >3 Skill 30 >3<6 Skill 33>6
            figScore = getSkill(1);
            symScore = getSkill(2);
            semScore = getSkill(3);
            decisionMakingScore = getSkill(30);
            counsellingScore = getSkill(33);
            if ((figScore > 2) && (symScore > 2) && (semScore > 3)
                    && (decisionMakingScore > 3) && (decisionMakingScore < 6)
                    && (counsellingScore > 6)) {
                flag3 = true;
                return true;
            }
            break;
        case 26: // Conditions 22, 23, 24 not met
            if (!flag3) {
                return true;
            }
            break;
        case 27: // Skill 59 >5
            flexibilityScore = getSkill(59);
            if (flexibilityScore > 5) {
                return true;
            }
            break;
        case 28: // Skill 59>3<6 )
            flexibilityScore = getSkill(59);
            if ((flexibilityScore > 3) && (flexibilityScore < 6)) {
                return true;
            }
            break;
        case 29: // Skill 59 <4
            flexibilityScore = getSkill(59);
            if (flexibilityScore < 4) {
                return true;
            }
            break;
        case 30: // Avg(Skill 24, 8)>5
            intutionScore = getSkill(24);
            divergentProdScore = getSkill(8);
            if (Math.round((intutionScore + divergentProdScore) / 2) > 5) {
                return true;
            }
            break;
        case 31: // Avg(Skill 24, 8)>3<6
            intutionScore = getSkill(24);
            divergentProdScore = getSkill(8);
            if ((Math.round((intutionScore + divergentProdScore) / 2) > 3)
                && (Math.round((intutionScore + divergentProdScore) / 2) < 6)) {
                return true;
            }
            break;
        case 32: // Avg(Skill 24, 8)<4
            intutionScore = getSkill(24);
            divergentProdScore = getSkill(8);
            if (Math.round((intutionScore + divergentProdScore) / 2) < 4) {
                return true;
            }
            break;

        default :

        }
        return false;
    }

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
}
