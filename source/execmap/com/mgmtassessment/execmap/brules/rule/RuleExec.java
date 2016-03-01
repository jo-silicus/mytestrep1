package com.mgmtassessment.execmap.brules.rule;

import java.util.HashMap;
import java.util.Hashtable;

import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;
import com.mgmtassessment.execmap.data.daoapi.ReportDAO;

/**
 * This file is meant for execmap reports section only and is parallel of
 * Rule.java. It sets all the conditions for generating the paras in the
 * reports.Passing a conditionID against a report will be validated in this file
 * based on skill and stanine score and return whether it is valid for that
 * particular report or not.
 * @version 1.0
 */

public class RuleExec {
    /**
     * skillScore contains skillid and its corresponding skillScore.
     */
    private HashMap   skillScore;

    /**
     * reportDAO is called when information is to be fetched from database.
     */
    private ReportDAO reportDAO;

    /**
     * stores the audioFlag value for test MEM.
     */
    private String    audioFlag     = null;

    /**
     * stores the min,max,mean,median and variance for different
     * Skills1,2,3,29,30,31,32,33,55,56,57,58 required in reports.
     */
    private Hashtable skillStatData = null;

    /**
     * @param acctID of the user.
     * @param sesID of the user.
     * @throws DataNotFoundException
     * Signifies the constructor of the class for general reports.
     */
    public void setRuleExec(String acctID, String sesID) throws
                                                        DataNotFoundException {
        skillScore = new HashMap();
        int[] skillIDArray = {1, 2, 3, 5, 29, 30, 31, 32, 33, 55, 56, 57, 58 };
        skillScore = (HashMap) getReportDAO().getLeadershipSkillScore(acctID,
                sesID, skillIDArray);
        audioFlag = getReportDAO().getAudioFlag(acctID, sesID);
    }

    /**
     * Provides the stanine score for a skill.
     *
     * @param skillID
     *            representing the skill
     * @return the skill score as float
     */
    public float getSkill(int skillID) {
        float score = 0.0f;
        try {
            score = ((Float) skillScore.get(new Integer(skillID))).floatValue();
        }
        catch (NullPointerException npe) {
            npe.printStackTrace();
        }
        return score;
    }

    /**
     * @param skill
     * Provides the statistical data for a skill as a hashtable.
     * representing the skill for which the statistical data is
     * required.
     * @return the statistical data as Hashtable
     */
    public Hashtable getStatData(int skill) {
        Hashtable statData = null;
        try {
            statData = (Hashtable) skillStatData.get(new Integer(skill));
        } catch (Exception npe) {
            npe.printStackTrace();
        }
        return statData;
    }

    /**
     * Provides the status of audio flag for MEMX test.
     *
     * @return flag status as String
     */
    private String getAudioFlag() {
        return audioFlag;
    }

    /**
     * Validates whether the condition ID for a report is valid or not.
     *
     * @param index
     *            representing the condID against a report(activity)
     * @return boolean whether the particular condition is validated or not
     */
    public boolean executeRule(int index) {
        float score = 0.0f;
        float a = 0.0f;
        float b = 0.0f;
        float c = 0.0f;
        float figScore = 0.0f;
        float symScore = 0.0f;
        float semScore = 0.0f;
        Hashtable statData = null;

        switch (index) {
            case 1: // Opening
                return true;
            case 2: // Content Explanation
                return true;
            case 3: // Figural Hi
                score = getSkill(1);
                if (score > 6) {
                    return true;
                }
                break;
            case 4: // Figural Avg
                score = getSkill(1);
                if (score >= 4 && score <= 6) {
                    return true;
                }
                break;
            case 5: // Figural Low
                score = getSkill(1);
                if (score < 4)
                    return true;
                break;
            case 6: // Median at least .6 greater than Mean(Median - Mean > .6)
                statData = getStatData(1);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (b - a > 0.6) {
                    return true;
                }
                break;
            case 7: // Median within .6 of Mean(|Median - Mean| <= .6)
                statData = getStatData(1);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (Math.abs(b - a) <= 0.6) {
                    return true;
                }
                break;
            case 8: // Median at least .6 less than Mean(Mean - Median < .6 )
                statData = getStatData(1);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (a - b > 0.6) {
                    return true;
                }
                break;
            case 9: // Minimum < 4 and at least 2 less than mean
                statData = getStatData(1);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Min")).floatValue();
                if ((b < 4) && (a - b > 2)) {
                    return true;
                }
                break;
            case 10: // Max > 6 and at least 2 greater than mean
                statData = getStatData(1);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((b > 6) && (b - a > 2)) {
                    return true;
                }
                break;
            case 11: // Min > 3 and Max < 7 and Min within 1 of max
                statData = getStatData(1);
                a = ((Float) statData.get("Min")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((a > 3) && (b < 7) && (Math.abs(b - a) <= 1)) {
                    return true;
                }
                break;
            case 12: // Min > 3 and Max < 7 and Min outside 1 of max
                statData = getStatData(1);
                a = ((Float) statData.get("Min")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((a > 3) && (b < 7) && (Math.abs(b - a) > 1)) {
                    return true;
                }
                break;
            case 13: // Variation < 1
                statData = getStatData(1);
                c = ((Float) statData.get("Variation")).floatValue();
                if (c < 1) {
                    return true;
                }
                break;
            case 14: // Variation >= 1 <= 2
                statData = getStatData(1);
                c = ((Float) statData.get("Variation")).floatValue();
                if ((c >= 1) && (c <= 2)) {
                    return true;
                }
                break;
            case 15: // Variation > 2
                statData = getStatData(1);
                c = ((Float) statData.get("Variation")).floatValue();
                if (c > 2) {
                    return true;
                }
                break;
            case 16: // Symbolic Hi
                score = getSkill(2);
                if (score > 6) {
                    return true;
                }
                break;
            case 17: // Symbolic Avg
                score = getSkill(2);
                if (score >= 4 && score <= 6) {
                    return true;
                }
                break;
            case 18: // Symbolic Low
                score = getSkill(2);
                if (score < 4) {
                    return true;
                }
                break;
            case 19: // Median at least .6 greater than Mean(Median - Mean >
                        // .6)
                statData = getStatData(2);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (b - a > 0.6) {
                    return true;
                }
                break;
            case 20: // Median within .6 of Mean(|Median - Mean| <= .6)
                statData = getStatData(2);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (Math.abs(b - a) <= 0.6) {
                    return true;
                }
                break;
            case 21: // Median at least .6 less than Mean(Mean - Median < .6
                        // )
                statData = getStatData(2);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (a - b > 0.6)
                    return true;
                break;
            case 22: // Minimum < 4 and at least 2 less than mean
                statData = getStatData(2);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Min")).floatValue();
                if ((b < 4) && (a - b > 2))
                    return true;
                break;
            case 23: // Max > 6 and at least 2 greater than mean
                statData = getStatData(2);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((b > 6) && (b - a > 2))
                    return true;
                break;
            case 24: // Min > 3 and Max < 7 and Min within 1 of max
                statData = getStatData(2);
                a = ((Float) statData.get("Min")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((a > 3) && (b < 7) && (Math.abs(b - a) <= 1)) {
                    return true;
                }
                break;
            case 25: // Min > 3 and Max < 7 and Min outside 1 of max
                statData = getStatData(2);
                a = ((Float) statData.get("Min")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((a > 3) && (b < 7) && (Math.abs(b - a) > 1)) {
                    return true;
                }
                break;
            case 26: // Variation < 1
                statData = getStatData(2);
                c = ((Float) statData.get("Variation")).floatValue();
                if (c < 1) {
                    return true;
                }
                break;
            case 27: // Variation >= 1 <= 2
                statData = getStatData(2);
                c = ((Float) statData.get("Variation")).floatValue();
                if ((c >= 1) && (c <= 2)) {
                    return true;
                }
                break;
            case 28: // Variation > 2
                statData = getStatData(2);
                c = ((Float) statData.get("Variation")).floatValue();
                if (c > 2) {
                    return true;
                }
                break;
            case 29: // Semantic Hi
                score = getSkill(3);
                if (score > 6) {
                    return true;
                }
                break;
            case 30: // Semantic Avg
                score = getSkill(3);
                if (score >= 4 && score <= 6)
                    return true;
                break;
            case 31: // Semantic Low
                score = getSkill(3);
                if (score < 4)
                    return true;
                break;
            case 32: // Median at least .6 greater than Mean(Median - Mean >
                        // .6)
                statData = getStatData(3);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (b - a > 0.6)
                    return true;
                break;
            case 33: // Median within .6 of Mean(|Median - Mean| <= .6)
                statData = getStatData(3);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (Math.abs(b - a) <= 0.6)
                    return true;
                break;
            case 34: // Median at least .6 less than Mean(Mean - Median < .6
                        // )
                statData = getStatData(3);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (a - b > 0.6)
                    return true;
                break;
            case 35: // Minimum < 4 and at least 2 less than mean
                statData = getStatData(3);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Min")).floatValue();
                if ((b < 4) && (a - b > 2))
                    return true;
                break;
            case 36: // Max > 6 and at least 2 greater than mean
                statData = getStatData(3);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((b > 6) && (b - a > 2))
                    return true;
                break;
            case 37: // Min > 3 and Max < 7 and Min within 1 of max
                statData = getStatData(3);
                a = ((Float) statData.get("Min")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((a > 3) && (b < 7) && (Math.abs(b - a) <= 1))
                    return true;
                break;
            case 38: // Min > 3 and Max < 7 and Min outside 1 of max
                statData = getStatData(3);
                a = ((Float) statData.get("Min")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((a > 3) && (b < 7) && (Math.abs(b - a) > 1))
                    return true;
                break;
            case 39: // Variation < 1
                statData = getStatData(3);
                c = ((Float) statData.get("Variation")).floatValue();
                if (c < 1)
                    return true;
                break;
            case 40: // Variation >= 1 <= 2
                statData = getStatData(3);
                c = ((Float) statData.get("Variation")).floatValue();
                if ((c >= 1) && (c <= 2))
                    return true;
                break;
            case 41: // Variation > 2
                statData = getStatData(3);
                c = ((Float) statData.get("Variation")).floatValue();
                if (c > 2)
                    return true;
                break;
            case 42: // Versatile
                figScore = getSkill(1);
                symScore = getSkill(2);
                semScore = getSkill(3);
                if ((figScore > 5) && (symScore > 5) && (semScore > 5))
                    return true;
                break;
            case 43: // Balanced Within 1 Stanines of each other
                figScore = getSkill(1);
                symScore = getSkill(2);
                semScore = getSkill(3);
                a = Math.abs(figScore - symScore);
                b = Math.abs(figScore - semScore);
                c = Math.abs(symScore - semScore);
                if ((a > 1) || (b > 1) || (c > 1))
                    return false;
                else
                    return true;
            case 44: // Dominant
                figScore = getSkill(1);
                symScore = getSkill(2);
                semScore = getSkill(3);
                a = Math.abs(figScore - symScore);
                b = Math.abs(figScore - semScore);
                c = Math.abs(symScore - semScore);
                if ((a > 2) || (b > 2) || (c > 2))
                    return true;
                else
                    return false;
            case 45: // All
                return true;
            case 46: // Memory Hi
                score = getSkill(5);
                if (score > 6)
                    return true;
                break;
            case 47: // Memory Avg
                score = getSkill(5);
                if (score >= 4 && score <= 6)
                    return true;
                break;
            case 48: // Memory Low
                score = getSkill(5);
                if (score < 4)
                    return true;
                break;
            case 49: // MEM flag = A
                if (getAudioFlag() != null) {
                    if (getAudioFlag().equalsIgnoreCase("A"))
                        return true;
                }
                break;
            case 50: // MEM flag = V
                if (getAudioFlag() != null) {
                    if (getAudioFlag().equalsIgnoreCase("V"))
                        return true;
                }
                break;
            case 51: // MEM flag = B
                if (getAudioFlag() != null) {
                    if (getAudioFlag().equalsIgnoreCase("B"))
                        return true;
                }
                break;
            case 52: // All
                return true;
            case 53: // Clarity of purpose < 4
                score = getSkill(29);
                if (score < 4)
                    return true;
                break;
            case 54: // Clarity of purpose 4-6
                score = getSkill(29);
                if (score >= 4 && score <= 6)
                    return true;
                break;
            case 55: // Clarity of purpose > 6
                score = getSkill(29);
                if (score > 6)
                    return true;
                break;
            case 56: // Median at least .6 greater than Mean(Median - Mean >
                        // .6)
                statData = getStatData(29);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (b - a > 0.6)
                    return true;
                break;
            case 57: // Median within .6 of Mean(|Median - Mean| <= .6)
                statData = getStatData(29);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (Math.abs(b - a) <= 0.6)
                    return true;
                break;
            case 58: // Median at least .6 less than Mean(Mean - Median < .6
                        // )
                statData = getStatData(29);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (a - b > 0.6)
                    return true;
                break;
            case 59: // Minimum < 4 and at least 2 less than mean
                statData = getStatData(29);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Min")).floatValue();
                if ((b < 4) && (a - b > 2))
                    return true;
                break;
            case 60: // Max > 6 and at least 2 greater than mean
                statData = getStatData(29);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((b > 6) && (b - a > 2))
                    return true;
                break;
            case 61: // Min > 3 and Max < 7 and Min within 1 of max
                statData = getStatData(29);
                a = ((Float) statData.get("Min")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((a > 3) && (b < 7) && (Math.abs(b - a) <= 1))
                    return true;
                break;
            case 62: // Min > 3 and Max < 7 and Min outside 1 of max
                statData = getStatData(29);
                a = ((Float) statData.get("Min")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((a > 3) && (b < 7) && (Math.abs(b - a) > 1))
                    return true;
                break;
            case 63: // Variation < 1
                statData = getStatData(29);
                c = ((Float) statData.get("Variation")).floatValue();
                if (c < 1)
                    return true;
                break;
            case 64: // Variation >= 1 <= 2
                statData = getStatData(29);
                c = ((Float) statData.get("Variation")).floatValue();
                if ((c >= 1) && (c <= 2))
                    return true;
                break;
            case 65: // Variation > 2
                statData = getStatData(29);
                c = ((Float) statData.get("Variation")).floatValue();
                if (c > 2)
                    return true;
                break;
            case 66: // All
                return true;
            case 67: // Decision Making < 4
                score = getSkill(30);
                if (score < 4)
                    return true;
                break;
            case 68: // Decision Making 4-6
                score = getSkill(30);
                if (score >= 4 && score <= 6)
                    return true;
                break;
            case 69: // Decision Making > 6
                score = getSkill(30);
                if (score > 6)
                    return true;
                break;
            case 70: // Median at least .6 greater than Mean(Median - Mean >
                        // .6)
                statData = getStatData(30);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (b - a > 0.6)
                    return true;
                break;
            case 71: // Median within .6 of Mean(|Median - Mean| <= .6)
                statData = getStatData(30);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (Math.abs(b - a) <= 0.6)
                    return true;
                break;
            case 72: // Median at least .6 less than Mean(Mean - Median < .6
                        // )
                statData = getStatData(30);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (a - b > 0.6)
                    return true;
                break;
            case 73: // Minimum < 4 and at least 2 less than mean
                statData = getStatData(30);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Min")).floatValue();
                if ((b < 4) && (a - b > 2))
                    return true;
                break;
            case 74: // Max > 6 and at least 2 greater than mean
                statData = getStatData(30);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((b > 6) && (b - a > 2))
                    return true;
                break;
            case 75: // Min > 3 and Max < 7 and Min within 1 of max
                statData = getStatData(30);
                a = ((Float) statData.get("Min")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((a > 3) && (b < 7) && (Math.abs(b - a) <= 1))
                    return true;
                break;
            case 76: // Min > 3 and Max < 7 and Min outside 1 of max
                statData = getStatData(30);
                a = ((Float) statData.get("Min")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((a > 3) && (b < 7) && (Math.abs(b - a) > 1))
                    return true;
                break;
            case 77: // Variation < 1
                statData = getStatData(30);
                c = ((Float) statData.get("Variation")).floatValue();
                if (c < 1)
                    return true;
                break;
            case 78: // Variation >= 1 <= 2
                statData = getStatData(30);
                c = ((Float) statData.get("Variation")).floatValue();
                if ((c >= 1) && (c <= 2))
                    return true;
                break;
            case 79: // Variation > 2
                statData = getStatData(30);
                c = ((Float) statData.get("Variation")).floatValue();
                if (c > 2)
                    return true;
                break;
            case 80: // Dealing with Min Information
                score = getSkill(57);
                if (score < 4)
                    return true;
                break;
            case 81: // Dealing with Min Information
                score = getSkill(57);
                if (score >= 4 && score <= 6)
                    return true;
                break;
            case 82: // Dealing with Min Information
                score = getSkill(57);
                if (score > 6)
                    return true;
                break;
            case 83: // Median at least .6 greater than Mean(Median - Mean >
                        // .6)
                statData = getStatData(57);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (b - a > 0.6)
                    return true;
                break;
            case 84: // Median within .6 of Mean(|Median - Mean| <= .6)
                statData = getStatData(57);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (Math.abs(b - a) <= 0.6)
                    return true;
                break;
            case 85: // Median at least .6 less than Mean(Mean - Median < .6
                        // )
                statData = getStatData(57);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (a - b > 0.6)
                    return true;
                break;
            case 86: // Minimum < 4 and at least 2 less than mean
                statData = getStatData(57);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Min")).floatValue();
                if ((b < 4) && (a - b > 2))
                    return true;
                break;
            case 87: // Max > 6 and at least 2 greater than mean
                statData = getStatData(57);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((b > 6) && (b - a > 2))
                    return true;
                break;
            case 88: // Min > 3 and Max < 7 and Min within 1 of max
                statData = getStatData(57);
                a = ((Float) statData.get("Min")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((a > 3) && (b < 7) && (Math.abs(b - a) <= 1))
                    return true;
                break;
            case 89: // Min > 3 and Max < 7 and Min outside 1 of max
                statData = getStatData(57);
                a = ((Float) statData.get("Min")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((a > 3) && (b < 7) && (Math.abs(b - a) > 1))
                    return true;
                break;
            case 90: // Variation < 1
                statData = getStatData(57);
                c = ((Float) statData.get("Variation")).floatValue();
                if (c < 1)
                    return true;
                break;
            case 91: // Variation >= 1 <= 2
                statData = getStatData(57);
                c = ((Float) statData.get("Variation")).floatValue();
                if ((c >= 1) && (c <= 2))
                    return true;
                break;
            case 92: // Variation > 2
                statData = getStatData(57);
                c = ((Float) statData.get("Variation")).floatValue();
                if (c > 2)
                    return true;
                break;
            case 93: // Directing < 4
                score = getSkill(31);
                if (score < 4)
                    return true;
                break;
            case 94: // Directing 4-6
                score = getSkill(31);
                if (score >= 4 && score <= 6)
                    return true;
                break;
            case 95: // Directing > 6
                score = getSkill(31);
                if (score > 6)
                    return true;
                break;
            case 96: // Median at least .6 greater than Mean(Median - Mean >
                        // .6)
                statData = getStatData(31);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (b - a > 0.6)
                    return true;
                break;
            case 97: // Median within .6 of Mean(|Median - Mean| <= .6)
                statData = getStatData(31);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (Math.abs(b - a) <= 0.6)
                    return true;
                break;
            case 98: // Median at least .6 less than Mean(Mean - Median < .6
                        // )
                statData = getStatData(31);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (a - b > 0.6)
                    return true;
                break;
            case 99: // Minimum < 4 and at least 2 less than mean
                statData = getStatData(31);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Min")).floatValue();
                if ((b < 4) && (a - b > 2))
                    return true;
                break;
            case 100: // Max > 6 and at least 2 greater than mean
                statData = getStatData(31);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((b > 6) && (b - a > 2))
                    return true;
                break;
            case 101: // Min > 3 and Max < 7 and Min within 1 of max
                statData = getStatData(31);
                a = ((Float) statData.get("Min")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((a > 3) && (b < 7) && (Math.abs(b - a) <= 1))
                    return true;
                break;
            case 102: // Min > 3 and Max < 7 and Min outside 1 of max
                statData = getStatData(31);
                a = ((Float) statData.get("Min")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((a > 3) && (b < 7) && (Math.abs(b - a) > 1))
                    return true;
                break;
            case 103: // Variation < 1
                statData = getStatData(31);
                c = ((Float) statData.get("Variation")).floatValue();
                if (c < 1)
                    return true;
                break;
            case 104: // Variation >= 1 <= 2
                statData = getStatData(31);
                c = ((Float) statData.get("Variation")).floatValue();
                if ((c >= 1) && (c <= 2))
                    return true;
                break;
            case 105: // Variation > 2
                statData = getStatData(31);
                c = ((Float) statData.get("Variation")).floatValue();
                if (c > 2)
                    return true;
                break;
            case 106: // All
                return true;
            case 107: // Planning < 4
                score = getSkill(32);
                if (score < 4)
                    return true;
                break;
            case 108: // Planning 4-6
                score = getSkill(32);
                if (score >= 4 && score <= 6)
                    return true;
                break;
            case 109: // Planning > 6
                score = getSkill(32);
                if (score > 6)
                    return true;
                break;
            case 110: // Median at least .6 greater than Mean(Median - Mean >
                        // .6)
                statData = getStatData(32);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (b - a > 0.6)
                    return true;
                break;
            case 111: // Median within .6 of Mean(|Median - Mean| <= .6)
                statData = getStatData(32);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (Math.abs(b - a) <= 0.6)
                    return true;
                break;
            case 112: // Median at least .6 less than Mean(Mean - Median < .6
                        // )
                statData = getStatData(32);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (a - b > 0.6)
                    return true;
                break;
            case 113: // Minimum < 4 and at least 2 less than mean
                statData = getStatData(32);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Min")).floatValue();
                if ((b < 4) && (a - b > 2))
                    return true;
                break;
            case 114: // Max > 6 and at least 2 greater than mean
                statData = getStatData(32);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((b > 6) && (b - a > 2))
                    return true;
                break;
            case 115: // Min > 3 and Max < 7 and Min within 1 of max
                statData = getStatData(32);
                a = ((Float) statData.get("Min")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((a > 3) && (b < 7) && (Math.abs(b - a) <= 1))
                    return true;
                break;
            case 116: // Min > 3 and Max < 7 and Min outside 1 of max
                statData = getStatData(32);
                a = ((Float) statData.get("Min")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((a > 3) && (b < 7) && (Math.abs(b - a) > 1))
                    return true;
                break;
            case 117: // Variation < 1
                statData = getStatData(32);
                c = ((Float) statData.get("Variation")).floatValue();
                if (c < 1) {
                    return true;
                }
                break;
            case 118: // Variation >= 1 <= 2
                statData = getStatData(32);
                c = ((Float) statData.get("Variation")).floatValue();
                if ((c >= 1) && (c <= 2)) {
                    return true;
                }
                break;
            case 119: // Variation > 2
                statData = getStatData(32);
                c = ((Float) statData.get("Variation")).floatValue();
                if (c > 2) {
                    return true;
                }
                break;
            case 120: // Budgeting
                score = getSkill(58);
                if (score < 4) {
                    return true;
                }
                break;
            case 121: // Budgeting
                score = getSkill(58);
                if (score >= 4 && score <= 6) {
                    return true;
                }
                break;
            case 122: // /Budgeting
                score = getSkill(58);
                if (score > 6) {
                    return true;
                }
                break;
            case 123: // Median at least .6 greater than Mean(Median - Mean >
                        // .6)
                statData = getStatData(58);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (b - a > 0.6) {
                    return true;
                }
                break;
            case 124: // Median within .6 of Mean(|Median - Mean| <= .6)
                statData = getStatData(58);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (Math.abs(b - a) <= 0.6) {
                    return true;
                }
                break;
            case 125: // Median at least .6 less than Mean(Mean - Median < .6
                        // )
                statData = getStatData(58);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (a - b > 0.6) {
                    return true;
                }
                break;
            case 126: // Minimum < 4 and at least 2 less than mean
                statData = getStatData(58);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Min")).floatValue();
                if ((b < 4) && (a - b > 2)) {
                    return true;
                }
                break;
            case 127: // Max > 6 and at least 2 greater than mean
                statData = getStatData(58);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((b > 6) && (b - a > 2)) {
                    return true;
                }
                break;
            case 128: // Min > 3 and Max < 7 and Min within 1 of max
                statData = getStatData(58);
                a = ((Float) statData.get("Min")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((a > 3) && (b < 7) && (Math.abs(b - a) <= 1)) {
                    return true;
                }
                break;
            case 129: // Min > 3 and Max < 7 and Min outside 1 of max
                statData = getStatData(58);
                a = ((Float) statData.get("Min")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((a > 3) && (b < 7) && (Math.abs(b - a) > 1)) {
                    return true;
                }
                break;
            case 130: // Variation < 1
                statData = getStatData(58);
                c = ((Float) statData.get("Variation")).floatValue();
                if (c < 1) {
                    return true;
                }
                break;
            case 131: // Variation >= 1 <= 2
                statData = getStatData(58);
                c = ((Float) statData.get("Variation")).floatValue();
                if ((c >= 1) && (c <= 2)) {
                    return true;
                }
                break;
            case 132: // Variation > 2
                statData = getStatData(58);
                c = ((Float) statData.get("Variation")).floatValue();
                if (c > 2) {
                    return true;
                }
                break;
            case 133: // Counselling < 4
                score = getSkill(33);
                if (score < 4) {
                    return true;
                }
                break;
            case 134: // Counselling 4-6
                score = getSkill(33);
                if (score >= 4 && score <= 6) {
                    return true;
                }
                break;
            case 135: // Counselling > 6
                score = getSkill(33);
                if (score > 6) {
                    return true;
                }
                break;
            case 136: // Median at least .6 greater than Mean(Median - Mean >
                        // .6)
                statData = getStatData(33);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (b - a > 0.6) {
                    return true;
                }
                break;
            case 137: // Median within .6 of Mean(|Median - Mean| <= .6)
                statData = getStatData(33);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (Math.abs(b - a) <= 0.6) {
                    return true;
                }
                break;
            case 138: // Median at least .6 less than Mean(Mean - Median < .6
                        // )
                statData = getStatData(33);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (a - b > 0.6) {
                    return true;
                }
                break;
            case 139: // Minimum < 4 and at least 2 less than mean
                statData = getStatData(33);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Min")).floatValue();
                if ((b < 4) && (a - b > 2)) {
                    return true;
                }
                break;
            case 140: // Max > 6 and at least 2 greater than mean
                statData = getStatData(33);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((b > 6) && (b - a > 2)) {
                    return true;
                }
                break;
            case 141: // Min > 3 and Max < 7 and Min within 1 of max
                statData = getStatData(33);
                a = ((Float) statData.get("Min")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((a > 3) && (b < 7) && (Math.abs(b - a) <= 1)) {
                    return true;
                }
                break;
            case 142: // Min > 3 and Max < 7 and Min outside 1 of max
                statData = getStatData(33);
                a = ((Float) statData.get("Min")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((a > 3) && (b < 7) && (Math.abs(b - a) > 1)) {
                    return true;
                }
                break;
            case 143: // Variation < 1
                statData = getStatData(33);
                c = ((Float) statData.get("Variation")).floatValue();
                if (c < 1) {
                    return true;
                }
                break;
            case 144: // Variation >= 1 <= 2
                statData = getStatData(33);
                c = ((Float) statData.get("Variation")).floatValue();
                if ((c >= 1) && (c <= 2)) {
                    return true;
                }
                break;
            case 145: // Variation > 2
                statData = getStatData(33);
                c = ((Float) statData.get("Variation")).floatValue();
                if (c > 2) {
                    return true;
                }
                break;
            case 146: // All
                return true;
            case 147: // Perspective < 4
                score = getSkill(55);
                if (score < 4) {
                    return true;
                }
                break;
            case 148: // Perspective 4-6
                score = getSkill(55);
                if (score >= 4 && score <= 6) {
                    return true;
                }
                break;
            case 149: // Perspective > 6
                score = getSkill(55);
                if (score > 6) {
                    return true;
                }
                break;
            case 150: // Median at least .6 greater than Mean(Median - Mean >
                        // .6)
                statData = getStatData(55);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (b - a > 0.6) {
                    return true;
                }
                break;
            case 151: // Median within .6 of Mean(|Median - Mean| <= .6)
                statData = getStatData(55);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (Math.abs(b - a) <= 0.6) {
                    return true;
                }
                break;
            case 152: // Median at least .6 less than Mean(Mean - Median < .6
                        // )
                statData = getStatData(55);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (a - b > 0.6) {
                    return true;
                }
                break;
            case 153: // Minimum < 4 and at least 2 less than mean
                statData = getStatData(55);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Min")).floatValue();
                if ((b < 4) && (a - b > 2)) {
                    return true;
                }
                break;
            case 154: // Max > 6 and at least 2 greater than mean
                statData = getStatData(55);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((b > 6) && (b - a > 2)) {
                    return true;
                }
                break;
            case 155: // Min > 3 and Max < 7 and Min within 1 of max
                statData = getStatData(55);
                a = ((Float) statData.get("Min")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((a > 3) && (b < 7) && (Math.abs(b - a) <= 1)) {
                    return true;
                }
                break;
            case 156: // Min > 3 and Max < 7 and Min outside 1 of max
                statData = getStatData(55);
                a = ((Float) statData.get("Min")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((a > 3) && (b < 7) && (Math.abs(b - a) > 1)) {
                    return true;
                }
                break;
            case 157: // Variation < 1
                statData = getStatData(55);
                c = ((Float) statData.get("Variation")).floatValue();
                if (c < 1) {
                    return true;
                }
                break;
            case 158: // Variation >= 1 <= 2
                statData = getStatData(55);
                c = ((Float) statData.get("Variation")).floatValue();
                if ((c >= 1) && (c <= 2)) {
                    return true;
                }
                break;
            case 159: // Variation > 2
                statData = getStatData(55);
                c = ((Float) statData.get("Variation")).floatValue();
                if (c > 2) {
                    return true;
                }
                break;
            case 160: // Setting < 4
                score = getSkill(56);
                if (score < 4) {
                    return true;
                }
                break;
            case 161: // Setting 4-6
                score = getSkill(56);
                if (score >= 4 && score <= 6) {
                    return true;
                }
                break;
            case 162: // Setting > 6
                score = getSkill(56);
                if (score > 6) {
                    return true;
                }
                break;
            case 163: // Median at least .6 greater than Mean(Median - Mean >
                        // .6)
                statData = getStatData(56);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (b - a > 0.6) {
                    return true;
                }
                break;
            case 164: // Median within .6 of Mean(|Median - Mean| <= .6)
                statData = getStatData(56);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (Math.abs(b - a) <= 0.6) {
                    return true;
                }
                break;
            case 165: // Median at least .6 less than Mean(Mean - Median < .6
                        // )
                statData = getStatData(56);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Median")).floatValue();
                if (a - b > 0.6) {
                    return true;
                }
                break;
            case 166: // Minimum < 4 and at least 2 less than mean
                statData = getStatData(56);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Min")).floatValue();
                if ((b < 4) && (a - b > 2)) {
                    return true;
                }
                break;
            case 167: // Max > 6 and at least 2 greater than mean
                statData = getStatData(56);
                a = ((Float) statData.get("Mean")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((b > 6) && (b - a > 2)) {
                    return true;
                }
                break;
            case 168: // Min > 3 and Max < 7 and Min within 1 of max
                statData = getStatData(56);
                a = ((Float) statData.get("Min")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((a > 3) && (b < 7) && (Math.abs(b - a) <= 1)) {
                    return true;
                }
                break;
            case 169: // Min > 3 and Max < 7 and Min outside 1 of max
                statData = getStatData(56);
                a = ((Float) statData.get("Min")).floatValue();
                b = ((Float) statData.get("Max")).floatValue();
                if ((a > 3) && (b < 7) && (Math.abs(b - a) > 1)) {
                    return true;
                }
                break;
            case 170: // Variation < 1
                statData = getStatData(56);
                c = ((Float) statData.get("Variation")).floatValue();
                if (c < 1) {
                    return true;
                }
                break;
            case 171: // Variation >= 1 <= 2
                statData = getStatData(56);
                c = ((Float) statData.get("Variation")).floatValue();
                if ((c >= 1) && (c <= 2)) {
                    return true;
                }
                break;
            case 172: // Variation > 2
                statData = getStatData(56);
                c = ((Float) statData.get("Variation")).floatValue();
                if (c > 2) {
                    return true;
                }
                break;
        } // end of switch
        return false;
    } // end of executeRule Method

    /**
     * @return Returns the reportDAO.
     */
    public ReportDAO getReportDAO() {
        return reportDAO;
    }

    /**
     * @param reportDAO
     *            The reportDAO to set.
     */
    public void setReportDAO(ReportDAO reportDAO) {
        this.reportDAO = reportDAO;
    }

}
