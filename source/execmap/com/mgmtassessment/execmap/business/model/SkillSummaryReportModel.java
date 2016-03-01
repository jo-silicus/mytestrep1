/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : chabrani
 * @date : Aug 22, 2006
 * @version:
 *
 * @history Description Reference Name Date
 *
 */

package com.mgmtassessment.execmap.business.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mgmtassessment.execmap.common.framework.business.AbstractModel;

/**
 * This class is a model for Skill Summary Report.
 * All the information regarding skill summary report
 * is populated in this class.
 */

public class SkillSummaryReportModel extends AbstractModel {
    /**
     * log variable for system health check.
     */
    private static Log log = LogFactory.getLog(SkillSummaryReportModel.class);
    /**
     * AccountId of Company.
     */
    private String acctID;

    /**
     * GroupId of user.
     */
    private String groupID;

    /**
     * Group Manager.
     */
    private String groupmanager;

    /**
     * Company Manager.
     */
    private String companymanager;

    /**
     * Number of users corresponding to Accountid and GroupId.
     */
    private int rows;

    /**
     * Number of skills selected.
     */
    private int cols;

    /**
     * These sre strings which display on Report.
     */
    private LinkedList skillShort;

    /**
     * These are tool tips for skillShort.
     */
    private LinkedList skillFull;

    /**
     * Contains all the information(ID,Testee,Scores of all skills).
     */
    private LinkedList result;

    /**
     * Skills pass to the url.
     */
    private String url;

    /**
     * sort variable.
     */
    private String sort;

    /**
     * @param c
     * The skills which are displayed on the jsp.
     * @return String
     */
    public String setSkillShort(int c) {
        switch (c) {
            case 1:
                return "Fig";
            case 2:
                return "Sym";
            case 3:
                return "seM";
            case 4:
                return "Cog";
            case 5:
                return "Mem";
            case 6:
                return "Eva";
            case 7:
                return "coN";
            case 8:
                return "Div";
            case 9:
                return "R";
            case 10:
                return "RR";
            case 11:
                return "Rcu";
            case 12:
                return "Ari";
            case 13:
                return "Mat";
            case 14:
                return "Uni";
            case 15:
                return "Cla";
            case 16:
                return "Rel";
            case 17:
                return "Sys";
            case 18:
                return "Tra";
            case 19:
                return "Imp";
            case 29:
                return "ClP";
            case 30:
                return "DeM";
            case 31:
                return "DiA";
            case 32:
                return "PlA";
            case 33:
                return "Cou";
            case 34:
                return "ReT";
            case 35:
                return "UoD";
            case 36:
                return "Wri";
            case 37:
                return "Num";
            case 38:
                return "OrC";
            case 39:
                return "EDM";
            case 40:
                return "PrS";
            case 41:
                return "JPO";
            case 42:
                return "SUM";
            case 43:
                return "LoI";
            case 44:
                return "WoC";
            case 45:
                return "LeT";
            case 46:
                return "CoU";
            case 55:
                return "PeR";
            case 56:
                return "SeT";
            default:
                return "Unk";
        }
    }

    /**
     * @param c
     * These are the tool tips for above abbrevated skills.
     * @return String
     */
    public String setSkillFull(int c) {
        switch (c) {
            case 1:
                return "Figural";
            case 2:
                return "Symbolic";
            case 3:
                return "Semantic";
            case 4:
                return "Cognition";
            case 5:
                return "Memory";
            case 6:
                return "Evaluation";
            case 7:
                return "Convergent Production";
            case 8:
                return "Divergent Production";
            case 9:
                return "Reading";
            case 10:
                return "Reading Readiness";
            case 11:
                return "Reading Concepts Use";
            case 12:
                return "Arithmetics";
            case 13:
                return "Mathematics";
            case 14:
                return "Units";
            case 15:
                return "Classes";
            case 16:
                return "Relations";
            case 17:
                return "Systems";
            case 18:
                return "Transformations";
            case 19:
                return "Implications";
            case 29:
                return "Clarity of Purpose";
            case 30:
                return "Decision Making";
            case 31:
                return "Directing Ability";
            case 32:
                return "Planning Ability";
            case 33:
                return "Counseling";
            case 34:
                return "Reading Text";
            case 35:
                return "Use of Documents";
            case 36:
                return "Writing";
            case 37:
                return "Numeracy";
            case 38:
                return "Oral Communication";
            case 39:
                return "Essential Decision Making";
            case 40:
                return "Problem Solving";
            case 41:
                return "Job Planning & Organizing";
            case 42:
                return "Significant Use of Memory";
            case 43:
                return "Locating Information";
            case 44:
                return "Working Context";
            case 45:
                return "Leadership Traits";
            case 46:
                return "Computer Use";
            case 55:
                return "Perspective";
            case 56:
                return "Setting";
            default:
                return "Unknown";
        }
    }

    /**
     * @param skill
     * Sort the skill summary report according to name and
     * various skills.
     * @param skill
     */
    public void sortOn(String skill) {
        try {
            log.info("Sorting of skill summary report model.");
            HashMap colResult = new HashMap();
            HashMap dupResult = new HashMap();
            LinkedList sortedResult = new LinkedList();
            int scoreLoop = 0;
            int col = 0;
            int duplicaterecords = 1;
            if (!(skill.equals("name") || skill.equals("id"))) {
                col = Integer.parseInt(skill);
            }
            Iterator resultIterator = result.iterator();
            while (resultIterator.hasNext()) {
                UserScoreInfoModel infoModel = (UserScoreInfoModel)
                                                resultIterator.next();
                String user = infoModel.getUserName();
                if (skill.equals("name")) {
                    if (colResult.containsKey(user)) {
                        dupResult
                                .put(user + "" + duplicaterecords++, infoModel);
                    } else {
                        colResult.put(user, infoModel);
                    }
                } else {
                    scoreLoop = col;
                    Iterator scoreIterator = infoModel.getUserScore()
                            .iterator();
                    while (scoreLoop >= 1) {
                        scoreLoop--;
                        if (scoreIterator.hasNext()) {
                            scoreIterator.next();
                        }
                    }
                    Float colScore = (Float)
                                      scoreIterator.next();
                    if (colResult.containsKey(colScore)) {
                        dupResult.put(colScore + "" + duplicaterecords++,
                                infoModel);
                    } else {
                        colResult.put(colScore, infoModel);
                    }
                }
            }
            int cRow = colResult.size();
            Set colKeys = colResult.keySet();
            Iterator colKeysIterator = colKeys.iterator();
            while (colKeysIterator.hasNext()) {
                if (skill.equals("name")) {
                    String tmpS = (String)
                                   colKeysIterator.next();
                    sortedResult.addLast(tmpS);
                } else {
                    Float tmpF = (Float)
                                  colKeysIterator.next();
                    sortedResult.addLast(tmpF);
                }
            }
            Collections.sort(sortedResult);
            if (!skill.equals("name")) {
                Collections.reverse(sortedResult);
            }
            LinkedList finalSortedResult = new LinkedList();
            for (int i = 0; i < cRow; i++) {
                String tmp = "";
                if (skill.equals("name")) {
                    String tmpS = (String)
                                   sortedResult.get(i);
                    finalSortedResult.addLast((UserScoreInfoModel)
                                             colResult.get(tmpS));
                    tmp = tmpS;
                } else {
                    Float tmpF = (Float)
                                  sortedResult.get(i);
                    finalSortedResult.addLast((UserScoreInfoModel)
                                             colResult.get(tmpF));
                    tmp = tmpF.toString();
                }
                Set dupKeys = dupResult.keySet();
                Iterator dupKeysIterator = dupKeys.iterator();
                while (dupKeysIterator.hasNext()) {
                    String dupStr = (String)
                                     dupKeysIterator.next();
                    if (dupStr.startsWith(tmp.toString())) {
                        finalSortedResult
                                .addLast((UserScoreInfoModel)
                                         (dupResult.get(dupStr)));
                    }
                }
            }
            result = finalSortedResult;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @param col column of matrix
     * @param row row of matrix
     * Get the score for a particular skill of a user.
     * @return String
     */
    public String getCell(int row, int col) {
        Float[] s = (Float[])
                     result.get(row);
        return String.valueOf(s[col]);
    }

    /**
     * @return Returns the acctID.
     */
    public String getAcctID() {
        return acctID;
    }

    /**
     * @param acctID
     * The acctID to set.
     */
    public void setAcctID(String acctID) {
        this.acctID = acctID;
    }

    /**
     * @return Returns the cols.
     */
    public int getCols() {
        return cols;
    }

    /**
     * @param cols
     * The cols to set.
     */
    public void setCols(int cols) {
        this.cols = cols;
    }

    /**
     * Returns the companymanager.
     * @return String
     */
    public String getCompanymanager() {
        return companymanager;
    }

    /**
     * @param companymanager
     * The companymanager to set.
     */
    public void setCompanymanager(String companymanager) {
        this.companymanager = companymanager;
    }

    /**
     * @return Returns the groupID.
     */
    public String getGroupID() {
        return groupID;
    }

    /**
     * @param groupID
     * The groupID to set.
     */
    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    /**
     * @return Returns the groupmanager.
     */
    public String getGroupmanager() {
        return groupmanager;
    }

    /**
     * @param groupmanager
     * The groupmanager to set.
     */
    public void setGroupmanager(String groupmanager) {
        this.groupmanager = groupmanager;
    }

    /**
     * @return Returns the result.
     */
    public LinkedList getResult() {
        return result;
    }

    /**
     * @param result
     * The result to set.
     */
    public void setResult(LinkedList result) {
        this.result = result;
    }

    /**
     * @return Returns the rows.
     */
    public int getRows() {
        return rows;
    }

    /**
     * @param rows
     * The rows to set.
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * @return Returns the sort.
     */
    public String getSort() {
        return sort;
    }

    /**
     * @param sort
     * The sort to set.
     */
    public void setSort(String sort) {
        this.sort = sort;
    }

    /**
     * @return Returns the skillFull.
     */
    public LinkedList getSkillFull() {
        return skillFull;
    }

    /**
     * @param skillFull
     * The skillFull to set.
     */
    public void setSkillFull(LinkedList skillFull) {
        this.skillFull = skillFull;
    }

    /**
     * @return Returns the skillShort.
     */
    public LinkedList getSkillShort() {
        return skillShort;
    }

    /**
     * @param skillShort
     * The skillShort to set.
     */
    public void setSkillShort(LinkedList skillShort) {
        this.skillShort = skillShort;
    }

    /**
     * @return String
     * Returns the url.
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     * The url to set.
     */
    public void setUrl(String url) {
        this.url = url;
    }
}