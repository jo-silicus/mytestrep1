/*
 * Created on Apr 18, 2006 TODO To change the template for this generated file
 * go to Window - Preferences - Java - Code Style - Code Templates
 */
package com.mgmtassessment.execmap.brules.rule.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.TreeSet;

import com.mgmtassessment.execmap.brules.rule.RuleExec;
import com.mgmtassessment.execmap.brules.rule.RuleExecSummary;
import com.mgmtassessment.execmap.brules.rule.RuleLeadership;
import com.mgmtassessment.execmap.brules.rule.api.ParaGen;
import com.mgmtassessment.execmap.business.model.ReportModel;
import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;
import com.mgmtassessment.execmap.common.util.TranslateMessageHelper;
import com.mgmtassessment.execmap.data.daoapi.ReportDAO;

/**
 * @author singhrau
 * This class generates html code for reports.
 */
public class ParaGenImpl implements ParaGen {
/**
 * Map to store para description corresponding to its ruleId.
 */
    private HashMap                ruleAndPara;
/**
 * Set to store all paraIds corresponding to a report.
 */
    private TreeSet                paraIdSet;
/**
 * reference for the object of RuleLeadership class to generate Leadership A
 * and E reports.
 * Its object is created in application context.
 */
    private RuleLeadership         ruleLeadership;
/**
 * reference for the object of RuleExecSummary class to generate Leadership
 * management report
 * Its object is created in application context.
 */
    private RuleExecSummary        ruleExecSummary;
/**
 * reference for the object of ruleLeadership class to generate
 * Executive reports.
 * Its object is created in application context.
 */
    private RuleExec               ruleExec;
/**
 * to store accountId of the user.
 */
    private String                 acctID                 = "";
/**
 * to store session Id of the user.
 */
    private String                 sesID                  = "";
/**
 * to store report Id which is to be generated.
 */
    private String                 rptId                  = "";
/**
 * Iterator for paraId.
 */
    private Iterator               paraIdIiterator;
/**
 * for storing heading of a graph.
 */
    private String                 graphHeading           = null;
/**
 * for storing heading of each row of a graph.
 */
    private String[]               rowHeading;
/**
 * to store length of a bar in a graph.
 */
    private float[]                barSize;
/**
 * to store no of rows in a graph.
 */
    private int                    nrows                  = 0;
/**
 * to store graphHeadingId of a graph.
 */
    private int                    graphHeadingID         = 0;
/**
 * reference of the report DAO object which is created in application context.
 */
    private ReportDAO              reportDAO;
/**
 * used to pickup strings from the corresponding resource file.
 */
    private TranslateMessageHelper translateMessageHelper =
                                            new  TranslateMessageHelper();
/**
 * to get the language.
 */
    private Locale                 locale;

    /**
     * @param acctID of the user
     * @param sesID of the user
     * @param reportModel of the user
     * @param imgPath from where image to be picked
     * @throws DataNotFoundException when query does not return any thing
     * @return the complete report as a string
     */
    public String getReport(String acctID, String sesID,
            ReportModel reportModel, String imgPath)
            throws DataNotFoundException {

        this.acctID = acctID;
        this.sesID = sesID;
        this.rptId = reportModel.getRptId();
        String report = "";
        this.locale = reportModel.getLocale();
        String lang = reportModel.getLocale().getLanguage();
        if (lang.equals(null)) {
            lang = "EN";
        }
        getCondID();
        getPara(lang);
        report = formatReport(lang, imgPath);
        return report;
    }

    /*
     * This method is called by getReport to populate the paraIdSet by the
     * condition IDs depending upon the applicable rule id for the given value
     * of account id(acctID), session id(sesID) and the activity id(rptId).
     */
    private void getCondID() throws DataNotFoundException {
        Collection applicableRuleId = getReportDAO().getConditionID(rptId);
        Iterator applicableRuleIdIterator = applicableRuleId.iterator();
        paraIdSet = new TreeSet();

        if (IConstants.EXECMAP_EXECUTIVE_SUMMARY.equals(rptId)) {
            getRuleExecSummary().setRuleExecSummary(acctID, sesID);
        } else if (IConstants.LEADERSHIP_A_REPORT.equals(rptId)
                || IConstants.LEADERSHIP_E_REPORT.equals(rptId)) {
            getRuleLeadership().setRuleLeadership(acctID, sesID);
        } else if (IConstants.GENERAL_INDIVIDUAL_REPORT.equals(rptId))
            getRuleExec().setRuleExec(acctID, sesID);

        while (applicableRuleIdIterator.hasNext()) {
            LinkedHashMap temp = (LinkedHashMap) applicableRuleIdIterator
                    .next();
            int index = ((Integer) temp.get("COND_ID")).intValue();
            boolean pickPara = false;
            if (IConstants.EXECMAP_EXECUTIVE_SUMMARY.equals(rptId)) {
                pickPara = ruleExecSummary.executeRule(index);
            } else if ((IConstants.LEADERSHIP_A_REPORT.equals(rptId))
                    || IConstants.LEADERSHIP_E_REPORT.equals(rptId)) {
                pickPara = ruleLeadership.executeRule(index);
            } else if (IConstants.GENERAL_INDIVIDUAL_REPORT.equals(rptId)) {
                pickPara = ruleExec.executeRule(index);
            }

            if (pickPara) {
                paraIdSet.add(new Integer(index));
            }

        }
    }

    /*
     * This method is called by getReport to populate the hashmaps ruleAndPara
     * and ruleAndParaId depending upon the condition ids provided by paraIdSet.
     */
    private void getPara(String lang) throws DataNotFoundException {
        ArrayList result = (ArrayList) getReportDAO().getParaIDAndParaDesc(
                rptId, paraIdSet, lang);
        ruleAndPara = (HashMap) result.get(1);
    }

    /**
     * Main method for the formatting of the reports.
     * @param lang
     * @return formated report
     */
    private String formatReport(String lang, String imgPath)
            throws DataNotFoundException {
        String report = "";
        String graph = null;
        String barIndicator = "<img>";
        int spos = 0;
        int epos = 0;
        StringBuffer tempBuff = null;
        paraIdIiterator = paraIdSet.iterator();
        // initializing the array to put page break
        int[] pBreak;
        int[] pExec = {1, 51, 65, 105, 145, 162};
        pBreak = pExec;
        String pageBreak = "<p style='page-break-before: always'>";
        int pBCount = 0;

        report = translateMessageHelper.getExecmapMessage(
                "paragen.formatreport.report.value", locale);

        while (paraIdIiterator.hasNext()) {
            Integer ruleID = (Integer) paraIdIiterator.next();
            String temp = (String) ruleAndPara.get(ruleID);
            if (temp != null) {
                if (ruleID.intValue() == 1) {
                    temp = genOpeningPage(temp, lang, imgPath);
                } else {
                    spos = ((String) ruleAndPara.get(ruleID))
                            .indexOf(barIndicator);

                    if (spos != -1) {
                        epos = spos + barIndicator.length();
                        setGraphValues(ruleID.intValue());
                        if ((IConstants.LEADERSHIP_A_REPORT.equals(rptId))
                                || (IConstants.LEADERSHIP_E_REPORT
                                        .equals(rptId))) {
                            graph = drawLeadershipBarGraph();
                        } else {
                            graph = drawBarGraph();
                            if (ruleID.intValue() == 120) {
                                graph = graph + skillSummary(acctID, sesID);
                            }
                        }

                        tempBuff = new StringBuffer(temp);
                        tempBuff.replace(spos, epos, graph);
                        temp = new String(tempBuff);
                    }

                }

                for (int i = pBCount; i < pBreak.length - 1; i++) {
                    if ((ruleID.intValue() > pBreak[i])
                            && (ruleID.intValue() < pBreak[i + 1])) {
                        pBCount = i + 1;
                        temp = pageBreak + temp;
                        break;

                    }

                }

                report = report + temp;
            }
        }

        return report;
    }

    /*
     * This method generates an opening page for the reports. Paragraphs stored
     * in the database contains some non-HTML tags( <cobrand>, <user>,
     * <testdate> which are being used to insert the specified information for
     * the particular user.
     */

    private String genOpeningPage(String para, String lang, String imgPath)
            throws DataNotFoundException {
        String cobrandIndicator = "<cobrand>";
        String userIndicator = "<user>";
        String dateIndicator = "<testdate>";
        String changeIndicator = "<change>";
        String expirationIndicator = "<expiration>";
        StringBuffer tempBuff = null;
        int spos = 0;
        int epos = 0;
        String repString = "";

        tempBuff = new StringBuffer(para);
        tempBuff.replace(spos, epos, repString);
        para = new String(tempBuff);

        spos = para.indexOf(cobrandIndicator);
        if (spos != -1) {
            epos = spos + cobrandIndicator.length();
            String cobrand = getReportDAO().getCobrand(acctID);

            if (cobrand != null) {
                repString = "<img src='" + imgPath + "\\" + cobrand.trim()
                        + "' >";
            } else {
                repString = "<img src='" + imgPath + "\\Execmap_logo.gif' >";
            }
            tempBuff = new StringBuffer(para);
            tempBuff.replace(spos, epos, repString);
            para = new String(tempBuff);
        }

        spos = para.indexOf(userIndicator);
        if (spos != -1) {
            epos = spos + userIndicator.length();
            String username = getReportDAO().getUserName(acctID, sesID);
            if (username != null) {
                repString = username.trim();
            } else {
                repString = "";
            }
            tempBuff = new StringBuffer(para);
            tempBuff.replace(spos, epos, repString);
            para = new String(tempBuff);
        }

        spos = para.indexOf(dateIndicator);
        if (spos != -1) {
            epos = spos + dateIndicator.length();

            repString = DateFormat.getDateInstance(DateFormat.LONG).format(
                    getReportDAO().getDateIndicator(acctID, sesID));

            tempBuff = new StringBuffer(para);
            tempBuff.replace(spos, epos, repString);
            para = new String(tempBuff);
        }

        spos = para.indexOf(changeIndicator);
        if (spos != -1) {
            epos = spos + changeIndicator.length();

            repString = "" + getReportDAO().getChangeInAnswers(acctID, sesID);

            tempBuff = new StringBuffer(para);
            tempBuff.replace(spos, epos, repString);
            para = new String(tempBuff);
        }

        spos = para.indexOf(expirationIndicator);
        if (spos != -1) {
            epos = spos + expirationIndicator.length();

            repString = "" + getReportDAO().getNoOfExpirations(acctID, sesID);

            tempBuff = new StringBuffer(para);
            tempBuff.replace(spos, epos, repString);
            para = new String(tempBuff);
        }

        return para;
    }

    /*
     * This method sets the graph heading, row heading, no. of horizontal bars
     * and the size of the bars for the graphs contained in some paragraphs of
     * the reports
     */

    // to show only the graph for skill_stanine score
    private void setGraphValues(int condID) throws DataNotFoundException {
        int[] skillID = null;
        int skillGrpID = 0;
        int cnt = 0;
        String temp = getReportDAO().getSkillGroupID("" + condID, rptId);
        if (temp == null) {
            temp = "0";
        }

        skillGrpID = new Integer(temp).intValue();
        if (skillGrpID != 0) {

            graphHeadingID = skillGrpID;
            // graphHeading =
            // reportData.getSkillGroupDesc(\"\"+skillGrpID).trim();
            graphHeading = translateMessageHelper.getExecmapMessage(
                    "table.skill_grp_mas.skill_grp_desc." + skillGrpID, locale);

            cnt = (new Integer(getReportDAO().getSkillCount("" + skillGrpID)))
                    .intValue();

            skillID = new int[cnt];
            rowHeading = new String[cnt];
            barSize = new float[cnt];
            nrows = cnt;

            Collection skillscoredata = getReportDAO().getSkillScore(acctID,
                    sesID, "" + skillGrpID);
            Iterator Iterator_skillscoredata = skillscoredata.iterator();
            if (cnt > 0) {
                for (int i = 0; i < cnt; i++) {

                    if (Iterator_skillscoredata.hasNext()) {
                        LinkedHashMap skillscore = (LinkedHashMap)
                        Iterator_skillscoredata.next();
                        barSize[i] = ((BigDecimal) skillscore
                                .get("skill_stan_scr")).floatValue();

                    }

                }
            }

            Collection skillids = getReportDAO().getSkillIds("" + skillGrpID);
            Iterator Iterator_skillids = skillids.iterator();

            if (cnt > 0) {
                for (int i = 0; i < cnt; i++) {

                    if (Iterator_skillids.hasNext()) {
                        LinkedHashMap tempSkillId = (LinkedHashMap)
                        Iterator_skillids.next();
                        skillID[i] = ((Integer) tempSkillId.get("skill_id"))
                                .intValue();
                    }
                }
            }
            if (cnt > 0) {
                for (int i = 0; i < cnt; i++) {

                    rowHeading[i] = getReportDAO()
                            .getSkillName("" + skillID[i]).trim();

                    if (IConstants.GENERAL_INDIVIDUAL_REPORT.equals(rptId)) {
                        if ((skillGrpID == 6) || (skillGrpID == 7)
                                || (skillGrpID == 8) || (skillGrpID == 9)
                                || (skillGrpID == 10)) {
                            if ((skillID[i] == 1) || (skillID[i] == 2)
                                    || (skillID[i] == 29) || (skillID[i] == 31)
                                    || (skillID[i] == 32) || (skillID[i] == 57)
                                    || (skillID[i] == 58)) {
                                rowHeading[i] = translateMessageHelper
                                        .getExecmapMessage(
                                          "table.skill_mas.skill_name.reports."
                                                        + skillID[i], locale);
                            } else {
                                rowHeading[i] = translateMessageHelper
                                        .getExecmapMessage(
                                                "table.skill_mas.skill_name."
                                                        + skillID[i], locale);
                            }
                        }
                    } else if (IConstants.LEADERSHIP_A_REPORT.equals(rptId)) {
                        if ((skillGrpID == 6) || (skillGrpID == 12)
                                || (skillGrpID == 13) || (skillGrpID == 14)) {
                            if (skillGrpID == 14 && skillID[i] == 60) {
                                rowHeading[i] = translateMessageHelper
                                     .getExecmapMessage(
                                      "table.skill_mas.skill_name.leadAreport."
                                                        + skillID[i], locale);

                            } else if ((skillID[i] == 1) || (skillID[i] == 2)
                                    || (skillID[i] == 27) || (skillID[i] == 59)
                                    || (skillID[i] == 60) || (skillID[i] == 65)
                                    || (skillID[i] == 66) || (skillID[i] == 67)
                                    || (skillID[i] == 70) || (skillID[i] == 60)
                                    || (skillID[i] == 72)) {
                                rowHeading[i] = translateMessageHelper
                                        .getExecmapMessage(
                                          "table.skill_mas.skill_name.reports."
                                                        + skillID[i], locale);
                            } else {
                                rowHeading[i] = translateMessageHelper
                                        .getExecmapMessage(
                                                "table.skill_mas.skill_name."
                                                        + skillID[i], locale);
                            }
                        }
                    } else if (IConstants.LEADERSHIP_E_REPORT.equals(rptId)) {
                        /*
                         * Skill headings on the Y Axis are different than what
                         * the name appears the database for leadership E report
                         */
                        if ((skillGrpID == 6) || (skillGrpID == 15)
                                || (skillGrpID == 16) || (skillGrpID == 17)
                                || (skillGrpID == 18)) {
                            if ((skillGrpID == 15)
                                    && (skillID[i] == 59 || skillID[i] == 60)) {
                                rowHeading[i] = translateMessageHelper
                                      .getExecmapMessage(
                                      "table.skill_mas.skill_name.leadEreport1."
                                                        + skillID[i], locale);

                            } else if ((skillID[i] == 1) || (skillID[i] == 2)
                                  || (skillID[i] == 27) || (skillID[i] == 59)
                                  || (skillID[i] == 60) || (skillID[i] == 61)
                                  || (skillID[i] == 6) || (skillID[i] == 62)
                                  || (skillID[i] == 63) || (skillID[i] == 64)
                                  || (skillID[i] == 65) || (skillID[i] == 66)
                                  || (skillID[i] == 67) || (skillID[i] == 68)
                                  || (skillID[i] == 70) || (skillID[i] == 71)
                                  || (skillID[i] == 72) || (skillID[i] == 73)) {
                                rowHeading[i] = translateMessageHelper
                                     .getExecmapMessage(
                                     "table.skill_mas.skill_name.leadEreport2."
                                                        + skillID[i], locale);
                            } else {
                                rowHeading[i] = translateMessageHelper
                                        .getExecmapMessage(
                                                "table.skill_mas.skill_name."
                                                        + skillID[i], locale);
                            }
                        }
                    }

                }

            }
        }

    }

    /**
     * Generates the graphs specific to the leadership reports only
     * @return String
     */
    private String drawLeadershipBarGraph() {

        // buffer for holding the graph
        StringBuffer tempBuffer = new StringBuffer();

        tempBuffer
                .append("<center><table width=640 border=1 bordercolor=#C0C0C0"
                        + "cellspacing=0 cellpadding=0><tr><td>");
        tempBuffer
                .append("<table width=100% cellpadding=0 cellspacing=0 ><tr><td"
                       + " width= 98></td>");
        tempBuffer
                .append("<td colspan=9 width=538><p align=center><font "
                        + "color=#0000FF>");
        tempBuffer.append(graphHeading);
        tempBuffer.append("</font></td></tr>");
        float nSize;
        // for generating the header of graph
        for (int i = 0; i < nrows; i++) {
            nSize = barSize[i];
            tempBuffer
                    .append("<tr><td width=98 nowrap bgcolor=#0080C0><font "
                            + "face=Arial size=2 color=#FFFFFF>");
            tempBuffer.append(rowHeading[i]);
            tempBuffer
                    .append("</font></td><td colspan=9 bgcolor=#D3D3D3><table "
                            + "cellspacing=0 cellpadding=0>");
            tempBuffer.append("<tr><td width=44% align=center>");
            tempBuffer.append(nSize);
            tempBuffer.append("</td>");
            /*
             * for generating the actual graphs with the display of white bar
             * wrt center line
             */
            if (nSize < 4) {

                tempBuffer
                        .append("<td><hr width=3 size=25 color=#00FF00 "
                                + "noshade></td>");
                tempBuffer
                        .append("<td><hr width=100 size=10 color=#000000 "
                                + "noshade></td>");
                tempBuffer.append("<td width=1 bgcolor=#000000></td>");
                tempBuffer
                        .append("<td><hr width=103 size=10 color=#000000 "
                                + "noshade></td>");
                tempBuffer.append("</tr></table></td></tr>");

            } else if (nSize == 4) {

                tempBuffer
                        .append("<td><hr width=50 size=10 color=#000000 "
                                + "noshade></td>");
                tempBuffer
                        .append("<td><hr width=3 size=25 color=#00FF00 "
                                + "noshade></td>");
                tempBuffer
                        .append("<td><hr width=50 size=10 color=#000000 "
                                + "noshade></td>");
                tempBuffer.append("<td width=1 bgcolor=#000000></td>");
                tempBuffer
                        .append("<td><hr width=103 size=10 color=#000000 "
                                + "noshade></td>");
                tempBuffer.append("</tr></table></td></tr>");

            } else if (nSize == 5) {

                tempBuffer
                        .append("<td><hr width=103 size=10 color=#000000 "
                                + "noshade></td>");
                tempBuffer.append("<td width=1 bgcolor=#000000></td>");
                tempBuffer
                        .append("<td><hr width=3 size=25 color=#00FF00 "
                                + "noshade></td>");
                tempBuffer
                        .append("<td><hr width=100 size=10 color=#000000 "
                                + "noshade></td>");
                tempBuffer.append("</tr></table></td></tr>");

            } else if (nSize == 6) {

                tempBuffer
                        .append("<td><hr width=103 size=10 color=#000000 "
                                + "noshade></td>");
                tempBuffer.append("<td width=1 bgcolor=#000000></td>");
                tempBuffer
                        .append("<td><hr width=50 size=10 color=#000000 "
                                + "noshade></td>");
                tempBuffer
                        .append("<td><hr width=3 size=25 color=#00FF00 "
                                + "noshade></td>");
                tempBuffer
                        .append("<td><hr width=50 size=10 color=#000000 "
                                + "noshade></td>");
                tempBuffer.append("</tr></table></td></tr>");

            } else {

                tempBuffer
                        .append("<td><hr width=103 size=10 color=#000000 "
                                + "noshade></td>");
                tempBuffer.append("<td width=1 bgcolor=#000000></td>");
                tempBuffer
                        .append("<td><hr width=100 size=10 color=#000000 "
                                + "noshade></td>");
                tempBuffer
                        .append("<td><hr width=3 size=25 color=#00FF00 "
                                + "noshade></td>");
                tempBuffer.append("</tr></table></td></tr>");

            }
        }

        tempBuffer
                .append("<tr><td width=98><p align=left>&nbsp;</td><td colspan"
                        + "=9><p align=center><font size=4>Target</font></td>"
                        + "</tr></table></td></tr></table></center>");
        return tempBuffer.toString();
    }

    private String drawBarGraph() {
        String graph = "";
        graph = graph
                + "<center><table width=640 border=1 bordercolor=#C0C0C0 "
                + "cellspacing=0 cellpadding=0><tr><td><table width=640 "
                + "cellpadding=0><tr><td width=98></td><td colspan=9 width=538>"
                + "<p align=center><font color=#0000FF>" + graphHeading +
                "</font></td></tr>";
        // execmap changes by Pawan on 21/09/01..start
        // for execmap report and skillgrpid = 10 the graph is bit different
        // with heading \"Environments\"
        int nSize;
        if (graphHeadingID == 10) {
            for (int i = 0; i < nrows; i++) {
                nSize = (int) (barSize[i] * 58 + ((barSize[i] - 1) * 2));
                graph = graph
                        + "  <tr>"
                        + "    <td width=98 rowspan=2 nowrap bgcolor=#0080C0>"
                        + "<font face=Arial size=2 color=#FFFFFF>"
                        + rowHeading[i] + "</font></td><td colspan=9 width=538 "
                        + "bgcolor=#D3D3D3><hr width=" + nSize + " size=10 "
                        + "color=#000000 align=left noshade></td></tr>";
                if (i == 0) {
                    graph = graph + translateMessageHelper.getAssesmentMessage(
                            "paragen.drawbargraph.execmapgraph.skillgrp.10" + i,
                            locale);
                } else if (i == 1) {
                    graph = graph + translateMessageHelper.getAssesmentMessage(
                            "paragen.drawbargraph.execmapgraph.skillgrp.10" + i,
                            locale);
                }
            }
        } else {

            for (int i = 0; i < nrows; i++) {

                nSize = (int) (barSize[i] * 58 + ((barSize[i] - 1) * 2));
                graph = graph + "  <tr><td width=98 nowrap bgcolor=#0080C0>"
                        + "<font face=Arial size=2 color=#FFFFFF>" +
                        rowHeading[i] + "</font></td><td colspan=9 width=538 "
                        + "bgcolor=#D3D3D3><hr width=" + nSize + " size=10 "
                        + "color=#000000 align=left noshade></td></tr>";
            }
        }

        /*
         * This is done as the execmap reports place some other text at the end
         * of graph below SCALE
         */
        if ((graphHeadingID == 6) || (graphHeadingID == 7)
                || (graphHeadingID == 8) || (graphHeadingID == 9)
                || (graphHeadingID == 11)) {
            graph = graph
                    + translateMessageHelper.getAssesmentMessage(
                            "paragen.drawbargraph.execmapgraph.skillgrp."
                                    + graphHeadingID, locale);
        }
        // graph for environments does not contain the scale
        else if (graphHeadingID == 10) {
            graph = graph + "</table></td></tr></table></center>";
        } else
            graph = graph + "<tr><td colspan=10 width=638></td></tr><tr><td "
            + "bgcolor=#008080 width=98><p align=left><font color=#FFFF00>Scale"
            + "</font></td><td bgcolor=#008080 width=60><p align=right><font "
            + "color=#FFFF00>1</font></td><td bgcolor=#008080 width=60><p align"
            + "=right><font color=#FFFF00>2</font></td><td bgcolor=#008080 "
            + "width=60><p align=right><font color=#FFFF00>3</font></td><td "
            + "bgcolor=#008080 width=60><p align=right><font color=#FFFF00>4"
            + "</font></td><td bgcolor=#008080 width=60><p align=right><font "
            + "color=#FFFF00>5</font></td><td bgcolor=#008080 width=60><p align"
            + "=right><font color=#FFFF00>6</font></td><td bgcolor=#008080 "
            + "width=60><p align=right><font color=#FFFF00>7</font></td><td "
            + "bgcolor=#008080 width=60><p align=right><font color=#FFFF00>8"
            + "</font></td><td bgcolor=#008080 width=60><p align=right><font "
            + "color=#FFFF00>9</font></td></tr><tr><td width=632 colspan=10>"
            + "&nbsp</td></tr><tr><td width=98></td><td bgcolor=#C0C0C0 colspan"
            + "=3 align=center width=178><strong><font face=Arial size=2>"
            + "Undeveloped</font></strong></td><td bgcolor=#C0C0C0 colspan=3 "
            + "align=center width=178><strong><font face=Arial size=2>Expected"
            + "</font></strong></td><td bgcolor=#C0C0C0 colspan=3 align=center "
            + "width=178><strong><font face=Arial size=2>Superior</font>"
            + "</strong></td></tr></table></td></tr></table></center>";

        return graph;

    }

    private String skillSummary(String acctID, String sesID)
            throws DataNotFoundException {
        String graph = "<p>&nbsp;</p>";
        int[] skillID = {1, 2, 3, 4, 5, 6, 7, 8};
        String[] skillName = null;
        int[] stanScore = null;
        int srows = skillID.length + 1;
        skillName = new String[srows];
        stanScore = new int[srows];
        for (int i = 0; i < srows; i++) {
            skillName[i] = new String("");
        }

        for (int i = 0; i < skillID.length; i++) {
            String skill_name = getReportDAO().getSkillName("" + skillID[i])
                    .trim();
            if (!skill_name.equals(null)) {
                switch (i) {
                    case 5:
                        skillName[i] = translateMessageHelper
                            .getAssesmentMessage(
                             "selectskill.form.skills.decision_making", locale);
                        break;
                    case 6:
                        skillName[i] = translateMessageHelper
                            .getExecmapMessage(
                             "paragen.skillsummary.skillname.psvalue", locale);
                        break;
                    case 7:
                        skillName[i] = translateMessageHelper
                          .getExecmapMessage(
                          "paragen.skillsummary.skillname.creatvalue", locale);
                        break;
                    default:
                        skillName[i] = translateMessageHelper
                                .getExecmapMessage(
                                        "table.skill_mas.skill_name."
                                                + skillID[i], locale);

                }
            }

            stanScore[i] = getReportDAO().getSkillStanScore(acctID, sesID,
                    skillID[i]).intValue();
        }

        graph = graph + "<table border=0 width=85% cellpadding=0>";
        for (int i = 1; i <= (int) (Math.ceil(skillID.length / 4.0)); i++) {
            graph = graph + "<tr>";
            for (int j = ((i - 1) * 4 + 1) - 1; j < (i * 4); j++) {
                graph = graph
                        + "<td width=18% bgcolor=#0080C0 align=left nowrap>"
                        + "<font face= Arial  size= 1 color= #FFFFFF >" +
                        skillName[j] + "</font></td><td width= 6%  align= "
                        + "center bgcolor= #D3D3D3 >" + stanScore[j] + "</td>";
            }
            graph = graph + "</tr>";
        }
        graph = graph + "</table>";
        return graph;
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

    /**
     * @return Returns the ruleExec.
     */
    public RuleExec getRuleExec() {
        return ruleExec;
    }

    /**
     * @param ruleExec The ruleExec to set.
     */
    public void setRuleExec(RuleExec ruleExec) {
        this.ruleExec = ruleExec;
    }

    /**
     * @return Returns the ruleExecSummary.
     */
    public RuleExecSummary getRuleExecSummary() {
        return ruleExecSummary;
    }

    /**
     * @param ruleExecSummary The ruleExecSummary to set.
     */
    public void setRuleExecSummary(RuleExecSummary ruleExecSummary) {
        this.ruleExecSummary = ruleExecSummary;
    }

    /**
     * @return Returns the ruleLeadership.
     */
    public RuleLeadership getRuleLeadership() {
        return ruleLeadership;
    }

    /**
     * @param ruleLeadership The ruleLeadership to set.
     */
    public void setRuleLeadership(RuleLeadership ruleLeadership) {
        this.ruleLeadership = ruleLeadership;
    }

    /**
     * @return Returns the translateMessageHelper.
     */
    public TranslateMessageHelper getTranslateMessageHelper() {
        return translateMessageHelper;
    }

    /**
     * @param translateMessageHelper The translateMessageHelper to set.
     */
    public void setTranslateMessageHelper(
            TranslateMessageHelper translateMessageHelper) {
        this.translateMessageHelper = translateMessageHelper;
    }

}