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

package com.mgmtassessment.execmap.business.impl.assessment;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mgmtassessment.execmap.business.api.assessment.StanineToSkillScore;
import com.mgmtassessment.execmap.data.daoapi.StanineToSkillScoreDAO;

/**
 * This class calculates skills scores from stanine scores.
 */

public class StanineToSkillScoreImpl implements StanineToSkillScore {
    /**
     * log variable for system health check.
     */
    private static Log             log = LogFactory
                                        .getLog(StanineToSkillScoreImpl.class);

    /**
     * DAO class for fetching and inserting skill scores.
     */
    private StanineToSkillScoreDAO stanineToSkillScoreDAO;

    /**
     * stores all the stanine score of one skill.
     */
    private TreeMap                stanineScore;

    /**
     * stores all skill id and corresponding stanine score.
     */
    private TreeMap                allSkillStanineScore;

    /**
     * stores all skill id and corresponding skill scores.
     */
    private TreeMap                allSkillScore;

    /**
     * depicts average score for a particular skill id.
     */
    private float                  average;

    /**
     * stores all skill ids in Vector.
     */
    private List                   totalSkillID;

    /**
     * @param acctId
     *            Testee account Id.
     * @param sesId
     *            Testee session Id. Converts the stanine score to skill score
     *            and stores it into database.
     * @return
     */
    public void stanineToSkillScore(String acctId, String sesId) {

        log.info("populating all skill ids from database "
                 + "and initializing skill score to 0");
        putInitialValue(acctId, sesId);

        log.info("fetching stanine score correponding"
                + "to each skill for a particular acctId and sesId.");
        allSkillStanineScore = getStanineToSkillScoreDAO()
                .fetchSkillStanineScore(acctId, sesId);

        log.info("calculating and setting each skill score for each skill id.");
        getSkill(acctId, sesId);

        log.info("storing skill scores to database.");
        stanineToSkillScoreDAO.insertSkillScore(acctId, sesId, allSkillScore);
    }

    /**
     * @param acctId
     *            Testee account Id.
     * @param sesId
     *            Testee session Id. populates all skill ids from
     *            <code>Skill_Mas</code> table into <code>totalSkillID</code>
     *            as LinkedList, inializes and set all skills scores to zero in
     *            <code>allSkillScore</code> treemap.
     * @return
     */
    private void putInitialValue(String acctId, String sesId) {

        log.info("fetching all skill ids from database in a List.");
        totalSkillID = getStanineToSkillScoreDAO().getTotalSkillID();
        Iterator totalSkillIDIterator = totalSkillID.iterator();
        allSkillScore = new TreeMap();
        while (totalSkillIDIterator.hasNext()) {
            allSkillScore.put(totalSkillIDIterator.next(), new Float(0.0f));
        }
    }

    /**
     * @param acctId
     *            Testee account Id.
     * @param sesId
     *            Testee session Id. Calculates and put skill scores into
     *            <code>allSkillScore</code> TreeMap object.
     * @return
     */
    private void getSkill(String acctId, String sesId) {

        /**
         * depicts stanineScore object that contains all tests stanine score for
         * that particular skill id.
         */
        stanineScore = new TreeMap();

        /**
         * getting iterator for traversing in data.
         */
        Iterator allSkillID = totalSkillID.iterator();

        /**
         * calculating each skill scores.
         */
        while (allSkillID.hasNext()) {
            int skillID = ((Integer)
                        allSkillID.next()).intValue();
            stanineScore = (TreeMap)
                        allSkillStanineScore.get(new Integer(skillID));
            if (stanineScore != null && skillID >= 1) {
                try {
                    if ((skillID <= 8 && skillID != 3) || skillID == 58
                            || skillID == 20 || skillID == 22 || skillID == 23
                            || skillID == 59 || skillID == 73) {
                        // calculate skill score for skill ids 58, 1 to 8
                        // excluding 3, 15 , 17 to 23, 59, 73
                        convertStanineToSkillScore1(skillID, stanineScore);
                    } else if (skillID == 3 || (skillID >= 15 && skillID <= 19)
                            || (skillID == 24) || (skillID == 27)
                            || (skillID >= 29 && skillID <= 33)
                            || (skillID >= 55 && skillID <= 57)
                            || (skillID >= 60 && skillID <= 72)) {
                        // calculate skill score for skill ids 3, 15 to 19, 29
                        // to 33 and 55 to 57,60-72
                        convertStanineToSkillScore2(skillID, stanineScore);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                convertStanineToSkillScore3(skillID);
            }
        }
    }

    /**
     * @param skillID
     *            skill Id for which scores to be calculated
     * @param stanineScore
     *            TreeMap stanineScore, contains trigramId as key and
     *            scoreSubTestId vector(subtestid, stanine score) as value.
     *            Calculate skill score for skill ids 58, 1 to 8 excluding 3.
     * @return
     */
    private void convertStanineToSkillScore1(int skillID,
             TreeMap stanineScore) {

        /**
         * calculates simple average of all tests for a particular skill id.
         */
        log.info("Calculates simple average of all tests "
                 + "for a particular skill id.");
        int sum = 0;
        int testCounter = 0;
        Set keySet = stanineScore.keySet();
        List list = new LinkedList(keySet);
        Iterator keys = list.iterator();
        while (keys.hasNext()) {
            sum += ((Integer)
                    ((List)
                    stanineScore.get(keys.next())).get(1)).intValue();
            testCounter++;
        }

        /**
         * setting testCounter value to 1 if it is zero otherwise it will
         * generate divide by zero error.
         */
        if (testCounter == 0) {
            testCounter = 1;
        }
        average = sum / (float) testCounter;
        float averageRounded = Math.round(average);

        /**
         * settong score to 1.0f if it is less than 1.
         */
        if (averageRounded < 1) {
            averageRounded = 1.0f;
        } else if (averageRounded > 9) {
            averageRounded = 9.0f;
        }
        allSkillScore.put(new Integer(skillID), new Float(averageRounded));
    }

    /**
     * @param skillID
     *            skillID for which score is to calculated
     * @param stanineScore
     *            stanine Score of all subtest required for the corresponding
     *            skill Id. This methods calculate skill score for skill ids 3,
     *            29 to 33 and 55 to 57
     * @return
     */
    private void convertStanineToSkillScore2(int skillID,
            TreeMap stanineScore) {

        int sum = 0;
        /**
         * stores values for two tests categories in case 55, 56,65.
         */
        float score1 = 0;
        float score2 = 0;
        float score = 0;
        /**
         * stores number of tests present for calculating average in case 55,
         * 56, 65.
         */
        int count1 = 0;
        int count2 = 0;
        int testCounter = 0;

        /**
         * stores intermediate score case 65.
         */
        float average1 = 0;

        Set keySet = stanineScore.keySet();
        List list = new LinkedList(keySet);
        Iterator keys = list.iterator();
        float averageRounded = 0.0f;

        Float fScore_skill_1;
        Float fScore_skill_33;

        // stores the key returned by keys.next()
        Object tempObject = null;
        // stores the key returned by keys.next as String
        String triId = null;
        switch (skillID) {
            case 3:
                // formula used for this skill Semantic AVG(EMSX+CMIX+CMSX+DMSX)
                while (keys.hasNext()) {
                    tempObject = keys.next();
                    triId = tempObject.toString().trim();

                    // excluding scores for NMT Test since it is not in formula
                    if (!triId.equalsIgnoreCase("NMT")) {
                        sum += ((Integer)
                                ((List)
                             stanineScore.get(tempObject)).get(1)).intValue();
                        // System.out.println("sum after adding score for triId
                        // |" +
                        // triId + "| is |" + sum + "|");
                        testCounter++;
                    }
                }

                // setting testCounter value to 1 if it is zero otherwise it
                // will
                // generate divide by zero error
                if (testCounter == 0) {
                    testCounter = 1;
                }

                // System.out.println("Sum was: " + sum + " and Counter is: " +
                // testCounter);
                average = sum / (float)
                                 testCounter;
                averageRounded = Math.round(average);

                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
            case 15:
                // formula used for this skill Classes (EFCX+ESCX)/2
                while (keys.hasNext()) {
                    tempObject = keys.next();
                    triId = tempObject.toString().trim();
                    // excluding scores for CFC Test since it is not in formula
                    if (!triId.equalsIgnoreCase("CFC")) {
                        sum += ((Integer)
                                ((List)
                          stanineScore.get(tempObject)).get(1)).intValue();
                        testCounter++;
                    }
                }
                // setting testCounter value to 1 if it is zero otherwise it
                // will
                // generate divide by zero error
                if (testCounter == 0) {
                    testCounter = 1;
                }
                average = sum / (float)
                                testCounter;
                averageRounded = Math.round(average);

                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
            case 16:
                // formula used for this skill Relationships (CSRX + (2*CMIX))/3
                while (keys.hasNext()) {
                    tempObject = keys.next();
                    triId = tempObject.toString().trim();

                    // excluding scores for CSR Test since it is not in formula
                    if (triId.equalsIgnoreCase("CSR")) {
                        sum += ((Integer)
                                ((List)
                           stanineScore.get(tempObject)).get(1)).intValue();
                        testCounter++;
                    }
                    if (triId.equalsIgnoreCase("CMI")) {
                        sum = sum
                                + 2
                                * ((Integer)
                                ((List)
                            stanineScore.get(tempObject)).get(1)).intValue();
                        testCounter = testCounter + 2;
                    }
                }
                // setting testCounter value to 1 if it is zero otherwise it
                // will
                // generate divide by zero error
                if (testCounter == 0) {
                    testCounter = 1;
                }
                average = sum / (float)
                                   testCounter;
                averageRounded = Math.round(average);
                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
            case 17:
                // formula used for this skill Systems (CFSX + CMSX + DMSX +
                // EMSX +
                // ESSX + MEMX)/6
                while (keys.hasNext()) {
                    tempObject = keys.next();
                    triId = tempObject.toString().trim();
                    // excluding scores for CSS,MFS,MSSa,MSSv,NSS Tests since it
                    // is
                    // not in formula
                    if (!(triId.equalsIgnoreCase("CSS")
                            || triId.equalsIgnoreCase("MFS")
                            || triId.equalsIgnoreCase("MSSa")
                            || triId.equalsIgnoreCase("MSSv") || triId
                            .equalsIgnoreCase("NSS"))) {
                        sum += ((Integer)
                                ((List)
                            stanineScore.get(tempObject)).get(1)).intValue();
                        testCounter++;
                    }
                }
                // setting testCounter value to 1 if it is zero otherwise it
                // will
                // generate divide by zero error
                if (testCounter == 0) {
                    testCounter = 1;
                }
                average = sum / (float)
                                  testCounter;
                averageRounded = Math.round(average);

                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
            case 18:
                // formula used for this skill Transformations (NMTX + NSTX)/2
                while (keys.hasNext()) {
                    tempObject = keys.next();
                    triId = tempObject.toString().trim();
                    // excluding scores for CFT Test since it is not in formula
                    if (!(triId.equalsIgnoreCase("CFT"))) {
                        sum += ((Integer)
                                ((List)
                          stanineScore.get(tempObject)).get(1)).intValue();
                        testCounter++;
                    }
                }
                // setting testCounter value to 1 if it is zero otherwise it
                // will
                // generate divide by zero error
                if (testCounter == 0) {
                    testCounter = 1;
                }
                average = sum / (float)
                                  testCounter;
                averageRounded = Math.round(average);
                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
            case 19:
                // formula used for this skill Implications (CMIX + EMSX)/2
                while (keys.hasNext()) {
                    tempObject = keys.next();
                    triId = tempObject.toString().trim();
                    // excluding scores for MMI,NSI Test since it is not in
                    // formula
                    if (!(triId.equalsIgnoreCase("MMI") || triId
                            .equalsIgnoreCase("NSI"))) {
                        sum += ((Integer)
                                ((List)
                              stanineScore.get(tempObject)).get(1)).intValue();
                        testCounter++;
                    }
                }
                // setting testCounter value to 1 if it is zero otherwise it
                // will
                // generate divide by zero error
                if (testCounter == 0) {
                    testCounter = 1;
                }
                average = sum / (float)
                                  testCounter;
                averageRounded = Math.round(average);
                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
            case 24:
                // formula used for this skill Intuition
                // ((2(CMIX+EMSX))+CFSX+CMIX+CMSX+CSRX)/8
                while (keys.hasNext()) {
                    tempObject = keys.next();
                    triId = tempObject.toString().trim();
                    if ((triId.equalsIgnoreCase("CMI"))) {
                        sum += 3 * ((Integer)
                                   ((List)
                             stanineScore.get(tempObject)).get(1)).intValue();
                        testCounter = testCounter + 3;
                    } else if ((triId.equalsIgnoreCase("EMS"))) {
                        sum += 2 * ((Integer)
                                    ((List)
                             stanineScore.get(tempObject)).get(1)).intValue();
                        testCounter = testCounter + 2;
                    } else {
                        sum += ((Integer)
                                ((List)
                            stanineScore.get(tempObject)).get(1)).intValue();
                        testCounter++;
                    }
                }
                // setting testCounter value to 1 if it is zero otherwise it
                // will
                // generate divide by zero error
                if (testCounter == 0) {
                    testCounter = 1;
                }
                average = sum / (float)
                                 testCounter;
                averageRounded = Math.round(average);
                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
            case 27:
                // formula used for this skill Round((NMTX_NSTX+CMIX+CSRX)/4,0)
                while (keys.hasNext()) {
                    tempObject = keys.next();
                    triId = tempObject.toString().trim();
                    if (!(triId.equalsIgnoreCase("DFU"))
                            && !(triId.equalsIgnoreCase("DSR"))
                            && !(triId.equalsIgnoreCase("EMS"))) {
                        sum += ((Integer)
                                ((List)
                          stanineScore.get(tempObject)).get(1)).intValue();
                        System.out.println("sum after adding score for triId |"
                                + triId + "| is |" + sum + "|");
                        testCounter++;
                    }
                }
                // setting testCounter value to 1 if it is zero otherwise it
                // will
                // generate divide by zero error
                if (testCounter == 0) {
                    testCounter = 1;
                }
                average = sum / (float) testCounter;
                averageRounded = Math.round(average);
                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
            case 29:
                // formula used for this skill Clarity of Purpose
                // AVG(EMSX+CMIX+CSRX+NMTX+ESSX-(DMSX-5))
                while (keys.hasNext()) {
                    tempObject = keys.next();
                    triId = tempObject.toString().trim();
                    if (triId.equalsIgnoreCase("DMS")) {
                        sum = sum
                                - (((Integer)
                                   ((List)
                         stanineScore.get(tempObject)).get(1)).intValue() - 5);
                        testCounter++;
                    } else if (!triId.equalsIgnoreCase("CFS")) {
                        sum += ((Integer)
                                ((List)
                              stanineScore.get(tempObject)).get(1)).intValue();
                        testCounter++;
                    }
                }
                // setting testCounter value to 1 if it is zero otherwise it
                // will
                // generate divide by zero error
                if (testCounter == 0) {
                    testCounter = 1;
                }
                average = sum / (float)
                                 testCounter;
                averageRounded = Math.round(average);
                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
            case 30:
                // formula used for skill Decision Making
                // AVG(EMSX+NMTX+ESSX+EFCX+CMSX+ESCX)
                while (keys.hasNext()) {
                    tempObject = keys.next();
                    triId = tempObject.toString().trim();
                    // excluding scores for CMI Test since it is not in formula
                    if (!triId.equalsIgnoreCase("CMI")) {
                        sum += ((Integer)
                                ((List)
                          stanineScore.get(tempObject)).get(1)).intValue();
                        testCounter++;
                    }
                }
                // setting testCounter value to 1 if it is zero otherwise it
                // will
                // generate divide by zero error
                if (testCounter == 0) {
                    testCounter = 1;
                }
                average = sum / (float)
                                  testCounter;
                averageRounded = Math.round(average);
                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
            case 31:
                // formula used for this skill Directing Abilities
                // (CMIX+(2*ESSX)+MEMX+CMSX+DMSX)/6
                while (keys.hasNext()) {
                    tempObject = keys.next();
                    triId = tempObject.toString().trim();
                    if (triId.equalsIgnoreCase("ESS")) {
                        sum = sum
                                + 2
                                * ((Integer)
                                   ((List)
                              stanineScore.get(tempObject)).get(1)).intValue();
                        testCounter = testCounter + 2;
                    } else if (!(triId.equalsIgnoreCase("EFC")
                            || triId.equalsIgnoreCase("EMS") || triId
                            .equalsIgnoreCase("ESC"))) {
                        sum += ((Integer)
                                ((List)
                            stanineScore.get(tempObject)).get(1)).intValue();
                        testCounter++;
                    }
                }
                // setting testCounter value to 1 if it is zero otherwise it
                // will
                // generate divide by zero error
                if (testCounter == 0) {
                    testCounter = 1;
                }
                average = sum / (float)
                                  testCounter;
                averageRounded = Math.round(average);
                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
            case 32:
                // formula used for this skill Planning Abillities
                // (EMSX+(2*CMIX)+CSRX+ESSX+EFCX+MEMX+ESCX)/8
                while (keys.hasNext()) {
                    tempObject = keys.next();
                    triId = tempObject.toString().trim();
                    if (triId.equalsIgnoreCase("CMI")) {
                        sum = sum
                                + 2
                                * ((Integer)
                                   ((List)
                            stanineScore.get(tempObject)).get(1)).intValue();
                        testCounter = testCounter + 2;
                    } else if (!triId.equalsIgnoreCase("CMS")) {
                        sum += ((Integer)
                                 ((List)
                           stanineScore.get(tempObject)).get(1)).intValue();
                        testCounter++;
                    }
                }
                // setting testCounter value to 1 if it is zero otherwise it
                // will
                // generate divide by zero error
                if (testCounter == 0) {
                    testCounter = 1;
                }
                average = sum / (float)
                                  testCounter;
                averageRounded = Math.round(average);
                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
            case 33:
                // formula used for this skill Counseling Abilities
                // (EMSX+CMIX+(2*(NSTX+NMTX)/2)+(2*CMSX)+DMSX)/7
                while (keys.hasNext()) {
                    tempObject = keys.next();
                    triId = tempObject.toString().trim();
                    if (triId.equalsIgnoreCase("CMS")) {
                        sum = sum
                                + 2
                                * ((Integer)
                                   ((List)
                              stanineScore.get(tempObject)).get(1)).intValue();
                        testCounter = testCounter + 2;
                    } else {
                        sum += ((Integer) ((List) stanineScore.get(tempObject))
                                .get(1)).intValue();
                        testCounter++;
                    }
                }
                // setting testCounter value to 1 if it is zero otherwise it
                // will
                // generate divide by zero error
                if (testCounter == 0) {
                    testCounter = 1;
                }
                average = sum / (float)
                                  testCounter;
                averageRounded = Math.round(average);
                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
            case 55:
                // formula used for this skill Perspective
                // 5+(((EMSX+CFSX+ESSX+CMSX)/4)-((CSRX+EFCX+MEMX+ESCX)/4))
                while (keys.hasNext()) {
                    tempObject = keys.next();
                    triId = tempObject.toString().trim();
                    if (triId.equalsIgnoreCase("EMS")
                            || triId.equalsIgnoreCase("CFS")
                            || triId.equalsIgnoreCase("ESS")
                            || triId.equalsIgnoreCase("CMS")) {
                        score1 += ((Integer)
                                   ((List)
                            stanineScore.get(tempObject)).get(1)).intValue();
                        // incrementing counter for calculating average
                        count1++;
                    } else if (triId.equalsIgnoreCase("CSR")
                            || triId.equalsIgnoreCase("EFC")
                            || triId.equalsIgnoreCase("MEM")
                            || triId.equalsIgnoreCase("ESC")) {
                        score2 += ((Integer)
                                   ((List)
                             stanineScore.get(tempObject)).get(1)).intValue();
                        // incrementing counter for calculating average
                        count2++;
                    }
                }
                // setting counter values to 1 if it is zero
                if (count1 == 0) {
                    count1 = 1;
                }
                if (count2 == 0) {
                    count2 = 1;
                }
                // calculating average score
                average = 5 + (float)
                             ((score1 / count1) - (score2 / count2));
                averageRounded = Math.round(average);
                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
            case 56:
                // formula used for this skill Setting
                // 5-(((CMIX+NSTX+NMTX+DMSX)/4)-(CSRX+ESSX+EFCX+ESCX)/4))
                while (keys.hasNext()) {
                    tempObject = keys.next();
                    triId = tempObject.toString().trim();
                    if (triId.equalsIgnoreCase("CMI")
                            || triId.equalsIgnoreCase("NST")
                            || triId.equalsIgnoreCase("NMT")
                            || triId.equalsIgnoreCase("DMS")) {
                        score1 += ((Integer)
                                   ((List)
                              stanineScore.get(tempObject)).get(1)).intValue();
                        // incrementing counter for calculating average
                        count1++;
                    } else if (triId.equalsIgnoreCase("CSR")
                            || triId.equalsIgnoreCase("ESS")
                            || triId.equalsIgnoreCase("EFC")
                            || triId.equalsIgnoreCase("ESC")) {
                        score2 += ((Integer)
                                   ((List)
                              stanineScore.get(tempObject)).get(1)).intValue();
                        // incrementing counter for calculating average
                        count2++;
                    }
                }
                // setting counter values to 1 if it is zero
                if (count1 == 0) {
                    count1 = 1;
                }
                if (count2 == 0) {
                    count2 = 1;
                }
                // calculating average score
                average = 5 - (float)
                             ((score1 / count1) - (score2 / count2));
                averageRounded = Math.round(average);
                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
            case 57:
                // formula used for this skill Dealing with Minimum Information
                // (2*CMIX + NMT + MEM)/4
                while (keys.hasNext()) {
                    tempObject = keys.next();
                    triId = tempObject.toString().trim();
                    if (triId.equalsIgnoreCase("CMI")) {
                        sum = sum
                                + 2
                                * ((Integer)
                                   ((List)
                            stanineScore.get(tempObject)).get(1)).intValue();
                        testCounter = testCounter + 2;
                    } else {
                        sum += ((Integer)
                                ((List)
                            stanineScore.get(tempObject)).get(1)).intValue();
                        testCounter++;
                    }
                }
                // setting testCounter value to 1 if it is zero otherwise it
                // will
                // generate divide by zero error
                if (testCounter == 0) {
                    testCounter = 1;
                }
                average = sum / (float)
                                 testCounter;
                averageRounded = Math.round(average);
                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
            case 60:
                // formula used for this skill Resourcefulness
                // ((2(CMIX+EMSX))+CFSX+CMSX+CSRX+NMTX+NSTX+DMSX)/10
                while (keys.hasNext()) {
                    tempObject = keys.next();
                    triId = tempObject.toString().trim();
                    if ((triId.equalsIgnoreCase("CMI"))) {
                        sum += 2 * ((Integer)
                                    ((List)
                             stanineScore.get(tempObject)).get(1)).intValue();
                        testCounter = testCounter + 2;
                    } else if ((triId.equalsIgnoreCase("EMS"))) {
                        sum += 2 * ((Integer)
                                   ((List)
                             stanineScore.get(tempObject)).get(1)).intValue();
                        testCounter = testCounter + 2;
                    } else {
                        sum += ((Integer)
                                ((List)
                             stanineScore.get(tempObject)).get(1)).intValue();
                        testCounter++;
                    }
                }
                // setting testCounter value to 1 if it is zero otherwise it
                // will
                // generate divide by zero error
                if (testCounter == 0) {
                    testCounter = 1;
                }
                average = sum / (float)
                                 testCounter;
                averageRounded = Math.round(average);
                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
            case 65:
                // formula used for this skill Commitment
                // (((EFCX+ESCX)/2)+CMIX+CMSX+NMTX+NSTX)/5
                while (keys.hasNext()) {
                    tempObject = keys.next();
                    triId = tempObject.toString().trim();
                    if ((triId.equalsIgnoreCase("EFC") || triId
                            .equalsIgnoreCase("ESC"))) {
                        score1 = score1
                                + ((Integer)
                                  ((List)
                              stanineScore.get(tempObject)).get(1)).intValue();
                    } else {
                        score2 = score2
                                + ((Integer)
                                   ((List)
                              stanineScore.get(tempObject)).get(1)).intValue();
                    }
                }
                // setting testCounter value to 1 if it is zero otherwise it
                // will
                // generate divide by zero error
                if (score1 == 0) {
                    count1 = 1;
                } else {
                    count1 = 2;
                }
                average1 = score1 / count1;
                score = average1 + score2;
                if (score == 0) {
                    count2 = 1;
                } else {
                    count2 = 5;
                }
                average = score / (float)
                                     count2;
                averageRounded = Math.round(average);
                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
            case 68:
                // formula used for this skill Motivation (Skill 1 + Skill 33
                // +(NMTX
                // + NSTX)/2)/3
                fScore_skill_1 = (Float)
                                  (allSkillScore.get(new Integer(1)));
                fScore_skill_33 = (Float)
                                  (allSkillScore.get(new Integer(33)));
                score1 = (fScore_skill_1.floatValue() + fScore_skill_33
                        .floatValue());
                while (keys.hasNext()) {
                    tempObject = keys.next();
                    triId = tempObject.toString().trim();
                    sum += ((Integer)
                            ((List)
                         stanineScore.get(tempObject)).get(1)).intValue();
                    count1++;
                }
                // setting testCounter value to 1 if it is zero otherwise it
                // will
                // generate divide by zero error
                if (count1 == 0) {
                    count1 = 1;
                }
                average1 = sum / (float)
                                   count1;
                score2 = score1 + average1;
                // setting testCounter value to 1 if it is zero otherwise it
                // will
                // generate divide by zero error
                if (score2 == 0) {
                    testCounter = 1;
                } else {
                    testCounter = 3;
                }
                average = score2 / (float)
                                    testCounter;
                averageRounded = Math.round(average);
                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
        } // end of switch statement
    }
    /**
     * @param skillID
     *            skillID for which score is to calculated. This methods
     *            calculate skill score for skill ids 61-64,66,67,69-72.
     * @return
     */
    private void convertStanineToSkillScore3(int skillID) {

        // stores values for two tests categories
        float score1 = 0;
        int testCounter = 0;
        float averageRounded = 0.0f;

        Float fScore_skill_1;
        Float fScore_skill_3;
        Float fScore_skill_4;
        Float fScore_skill_7;
        Float fScore_skill_16;
        Float fScore_skill_17;
        Float fScore_skill_18;
        Float fScore_skill_22;
        Float fScore_skill_23;
        Float fScore_skill_24;
        Float fScore_skill_30;
        Float fScore_skill_31;
        Float fScore_skill_33;
        Float fScore_skill_59;
        Float fScore_skill_60;
        Float fScore_skill_61;
        Float fScore_skill_62;
        Float fScore_skill_65;

        switch (skillID) {
            case 61:
                // formula used for this skill Prioritization ((2(Skill
                // 7))+Skill
                // 31)/3
                fScore_skill_7 = (Float)
                               (allSkillScore.get(new Integer(7)));
                fScore_skill_31 = (Float)
                               (allSkillScore.get(new Integer(31)));
                score1 = ((fScore_skill_7.floatValue()) * 2)
                        + fScore_skill_31.floatValue();
                // setting testCounter value to 1 if it is zero otherwise it
                // will
                // generate divide by zero error
                if (score1 == 0) {
                    testCounter = 1;
                } else {
                    testCounter = 3;
                }
                average = score1 / (float)
                                    testCounter;
                averageRounded = Math.round(average);

                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
            case 62:
                // formula used for this skill Analysis (Skill 59+Skill
                // 7-(|Skill
                // 22-5|+|Skill 1-5|))/2
                fScore_skill_59 = (Float)
                                 (allSkillScore.get(new Integer(7)));
                fScore_skill_7 = (Float)
                                 (allSkillScore.get(new Integer(31)));
                fScore_skill_22 = (Float)
                                 (allSkillScore.get(new Integer(22)));
                fScore_skill_1 = (Float)
                                 (allSkillScore.get(new Integer(1)));
                score1 = (fScore_skill_59.floatValue()
                        + fScore_skill_7.floatValue() - (Math
                        .abs(fScore_skill_22.floatValue() - 5) + Math
                        .abs(fScore_skill_1.floatValue() - 5)));
                // setting testCounter value to 1 if it is zero otherwise it
                // will
                // generate divide by zero error
                if (score1 == 0) {
                    testCounter = 1;
                } else {
                    testCounter = 2;
                }
                average = score1 / (float)
                                    testCounter;
                averageRounded = Math.round(average);

                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
            case 63:
                // formula used for this skill Insight (Skill 4 + Skill 24)/2
                fScore_skill_4 = (Float)
                                 (allSkillScore.get(new Integer(4)));
                fScore_skill_24 = (Float)
                                 (allSkillScore.get(new Integer(24)));
                score1 = (fScore_skill_4.floatValue() + fScore_skill_24
                        .floatValue());
                // setting testCounter value to 1 if it is zero otherwise it
                // will
                // generate divide by zero error
                if (score1 == 0) {
                    testCounter = 1;
                } else {
                    testCounter = 2;
                }
                average = score1 / (float)
                                    testCounter;
                averageRounded = Math.round(average);
                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
            case 64:
                // formula used for this skill Clarification (Skill 3 + Skill
                // 23)/2
                fScore_skill_3 = (Float)
                                 allSkillScore.get(new Integer(3));
                fScore_skill_23 = (Float)
                                 allSkillScore.get(new Integer(23));
                score1 = (fScore_skill_3.floatValue() + fScore_skill_23
                        .floatValue());
                // setting testCounter value to 1 if it is zero otherwise it
                // will
                // generate divide by zero error
                if (score1 == 0) {
                    testCounter = 1;
                } else {
                    testCounter = 2;
                }
                average = score1 / (float)
                                    testCounter;
                averageRounded = Math.round(average);
                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
            case 66:
                // formula used for this skill Cross-Culture (Skill 3 + Skill 17
                // +
                // Skill 33) + (2-|Skill 1-5| - |Skill 30-5|))/3
                fScore_skill_3 = (Float)
                                (allSkillScore.get(new Integer(3)));
                fScore_skill_17 = (Float)
                                (allSkillScore.get(new Integer(17)));
                fScore_skill_33 = (Float)
                                (allSkillScore.get(new Integer(33)));
                fScore_skill_1 = (Float)
                                (allSkillScore.get(new Integer(1)));
                fScore_skill_30 = (Float)
                                (allSkillScore.get(new Integer(30)));
                score1 = (fScore_skill_3.floatValue()
                        + fScore_skill_17.floatValue() + fScore_skill_33
                        .floatValue())
                        + (2 - Math.abs(fScore_skill_1.floatValue() - 5) - Math
                                .abs(fScore_skill_30.floatValue() - 5));
                // setting testCounter value to 1 if it is zero otherwise it
                // will
                // generate divide by zero error
                if (score1 == 0) {
                    testCounter = 1;
                } else {
                    testCounter = 3;
                }
                average = score1 / (float) testCounter;
                averageRounded = Math.round(average);
                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
            case 67:
                // formula used for this skill TeamWork (Skill 16 + Skill 31
                // +Skill
                // 33)/3
                fScore_skill_16 = (Float)
                                  (allSkillScore.get(new Integer(16)));
                fScore_skill_31 = (Float)
                                  (allSkillScore.get(new Integer(31)));
                fScore_skill_33 = (Float)
                                  (allSkillScore.get(new Integer(33)));
                score1 = (fScore_skill_16.floatValue()
                        + fScore_skill_31.floatValue() + fScore_skill_33
                        .floatValue());
                // setting testCounter value to 1 if it is zero otherwise it
                // will
                // generate divide by zero error
                if (score1 == 0) {
                    testCounter = 1;
                } else {
                    testCounter = 3;
                }
                average = score1 / (float)
                                    testCounter;
                averageRounded = Math.round(average);
                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
            case 69:
                // formula used for this skill Energy ((Skill 30 + Skill 31) +
                // (2-|Skill 1-5| - |Skill 33-5|))/2
                fScore_skill_30 = (Float)
                                 (allSkillScore.get(new Integer(30)));
                fScore_skill_31 = (Float)
                                 (allSkillScore.get(new Integer(31)));
                fScore_skill_33 = (Float)
                                 (allSkillScore.get(new Integer(33)));
                fScore_skill_1 = (Float)
                                 (allSkillScore.get(new Integer(1)));
                score1 = (fScore_skill_30.floatValue() + fScore_skill_31
                        .floatValue())
                        + (2 - Math.abs(fScore_skill_1.floatValue() - 5) - Math
                                .abs(fScore_skill_33.floatValue() - 5));
                // setting testCounter value to 1 if it is zero otherwise it
                // will
                // generate divide by zero error
                if (score1 == 0) {
                    testCounter = 1;
                } else {
                    testCounter = 2;
                }
                average = score1 / (float)
                                    testCounter;
                averageRounded = Math.round(average);
                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
            case 70:
                // formula used for this skill Focus 1+((Skill 61+Skill 17+Skill
                // 62
                // + Skill 7)/4)
                fScore_skill_61 = (Float)
                                 (allSkillScore.get(new Integer(61)));
                fScore_skill_17 = (Float)
                                 (allSkillScore.get(new Integer(17)));
                fScore_skill_62 = (Float)
                                 (allSkillScore.get(new Integer(62)));
                fScore_skill_7 = (Float)
                                 (allSkillScore.get(new Integer(7)));
                score1 = (fScore_skill_61.floatValue()
                        + fScore_skill_17.floatValue()
                        + fScore_skill_62.floatValue() + fScore_skill_7
                        .floatValue());
                // setting testCounter value to 1 if it is zero otherwise it
                // will
                // generate divide by zero error
                if (score1 == 0) {
                    testCounter = 1;
                } else {
                    testCounter = 4;
                }
                average = score1 / (float)
                                    testCounter;
                averageRounded = Math.round(average);
                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
            case 71:
                // formula used for this skill Receptivity (Skill 3 + Skill 33 +
                // Skill 18)/3
                fScore_skill_3 = (Float)
                                (allSkillScore.get(new Integer(3)));
                fScore_skill_33 = (Float)
                                (allSkillScore.get(new Integer(33)));
                fScore_skill_18 = (Float)
                                (allSkillScore.get(new Integer(18)));
                score1 = (fScore_skill_3.floatValue()
                        + fScore_skill_33.floatValue() + fScore_skill_18
                        .floatValue());
                // setting testCounter value to 1 if it is zero otherwise it
                // will
                // generate divide by zero error
                if (score1 == 0) {
                    testCounter = 1;
                } else {
                    testCounter = 3;
                }
                average = score1 / (float)
                                      testCounter;
                averageRounded = Math.round(average);
                // settong score to 1.0f if it is less than 1
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
            case 72:
                /**
                 * formula used for this skill Persistence (Skill 60 + Skill 61 +
                 * Skill 65)/3.
                 */
                fScore_skill_60 = (Float)
                                 (allSkillScore.get(new Integer(60)));
                fScore_skill_61 = (Float)
                                 (allSkillScore.get(new Integer(61)));
                fScore_skill_65 = (Float)
                                 (allSkillScore.get(new Integer(65)));
                score1 = (fScore_skill_60.floatValue()
                        + fScore_skill_61.floatValue() + fScore_skill_65
                        .floatValue());
                /**
                 * setting testCounter value to 1 if it is zero otherwise it
                 * will generate divide by zero error.
                 */
                if (score1 == 0) {
                    testCounter = 1;
                } else {
                    testCounter = 3;
                }
                average = score1 / (float) testCounter;
                averageRounded = Math.round(average);
                /**
                 * settong score to 1.0f if it is less than 1.
                 */
                if (averageRounded < 1) {
                    averageRounded = 1.0f;
                } else if (averageRounded > 9) {
                    averageRounded = 9.0f;
                }
                allSkillScore.put(new Integer(skillID), new Float(
                        averageRounded));
                break;
        }
    }
    /**
     * @return Returns the stanineToSkillScoreDAO.
     */
    public StanineToSkillScoreDAO getStanineToSkillScoreDAO() {
        return stanineToSkillScoreDAO;
    }

    /**
     * @param stanineToSkillScoreDAO
     *            The stanineToSkillScoreDAO to set.
     */
    public void setStanineToSkillScoreDAO(
            StanineToSkillScoreDAO stanineToSkillScoreDAO) {
        this.stanineToSkillScoreDAO = stanineToSkillScoreDAO;
    }
}