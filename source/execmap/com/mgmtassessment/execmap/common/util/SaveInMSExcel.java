/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : singhrau
 * @date : Sep 4, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.common.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mgmtassessment.execmap.business.model.AssessmentSummaryModel;
import com.mgmtassessment.execmap.business.model.SkillSummaryReportModel;
import com.mgmtassessment.execmap.business.model.UserScoreInfoModel;
import com.mgmtassessment.execmap.common.exceptions.ExecMapRuntimeException;

/**
 * This class generates html code to save as .xsl.
 */

public class SaveInMSExcel {

/**
 * Logger to log all the information.
 */
    private static Log log = LogFactory.getLog(SaveInMSExcel.class);

    /**
     * generates Assessment Summary Report in .xls format.
     * @param accountid
     * @param grpId of the group.
     * @param assessmentSummaryDetails list with all the details of the group
     */
    public void generateExcelForAssesSummRep(String repPath, String accountId,
            String grpId, List assessmentSummaryDetails) {
        String report = "<HTML><BODY><table width=\"978\" border=\"1\">"
             + "<tr bgcolor=\"#023F70\"><td width=\"14%\"><p align=\"center\">"
             + "<font color=\"#ffffff\">Account </font></p></td>"
             + "<td width=\"10%\"><p align=\"center\" ><font color=\"#ffffff\">"
             + "Group</font></p></td><td width=\"7%\"><p align=\"center\" >"
             + "<font color=\"#ffffff\">User Name</font></p></td>"
             + "<td width=\"12%\"><p align=\"center\" ><font color=\"#ffffff\">"
             + "Email</font></p></td>"
             + "<td width=\"7%\"><p align=\"center\" ><font color=\"#ffffff\">"
             + "Session </font></p></td>"
             + "<td width=\"10%\"><p align=\"center\" ><font color=\"#ffffff\">"
             + "Start Date</font></p></td>"
             + "<td width=\"10%\"><p align=\"center\" ><font color=\"#ffffff\">"
             + "Assessment Completed </font></p></td>"
             + "<td width=\"30%\"><p align=\"center\" ><font color=\"#ffffff\">"
             + "Activities Completed </font></p></td></tr>";
        Iterator itr = assessmentSummaryDetails.iterator();
        while (itr.hasNext()) {
            AssessmentSummaryModel assessmentSummaryModel =
                                                    (AssessmentSummaryModel) itr
                    .next();
            report = report + "<tr><td width=\"14%\"><p align=\"center\"> "
                    + accountId + "</p></td>"
                    + "<td width=\"10%\"><p align=\"center\"> " + grpId
                    + "</p></td>" + "<td width=\"7%\"><p align=\"center\"> "
                    + assessmentSummaryModel.getUsrName() + "</p></td>"
                    + "<td width=\"12%\"><p align=\"center\"><a href=mailto:"
                    + assessmentSummaryModel.getUsrEmail() + ">"
                    + assessmentSummaryModel.getUsrEmail() + "</a></p></td>"
                    + "<td width=\"7%\"><p align=\"center\">"
                    + assessmentSummaryModel.getSesId() + "</p></td>"
                    + "<td width=\"10%\"><p align=\"center\"> "
                    + assessmentSummaryModel.getStartDate() + "</p></td>"
                    + "<td width=\"10%\"><p align=\"center\">"
                    + assessmentSummaryModel.getCompFlg() + " </p></td>"
                    + "<td width=\"30%\"><p align=\"center\">"
                    + assessmentSummaryModel.getTestIdCompleted()
                    + "</p></td></tr>";
        }
        report = report + "</table></BODY></HTML>";
        String repName = accountId + grpId + "AssessmentSummary.xls";
        try {
            PrintWriter pr = new PrintWriter(new FileWriter(repPath + "\\"
                    + repName));
            if (pr != null) {
                pr.print(report);
            }
            pr.close();
        } catch (IOException t) {
            log.info("Requested path not found");
            throw new ExecMapRuntimeException();
        }
    }

    /**
     * @param repPath Report path where excel report is stored.
     * @param accountId AccountID.
     * @param usrId UserID.
     * @param individualUserDetails List of all scores in tests given by a user.
     *        Generates Individual Summary Report in .xls format.
     */
    public void generateExcelForIndividualSummaryRep(String repPath,
            String accountId, String usrId, List individualUserDetails) {
        String report = null;
        HashMap hashmap;
        Iterator indUserIterator = individualUserDetails.iterator();
        if (indUserIterator.hasNext()) {
            hashmap = (HashMap) indUserIterator.next();
            report = "<html><body><table border=0 height=20 width=\"80%\" "
                + "cellspacing=0 cellpadding=0 ><tr><td align=center height=21 "
                + "width=\"100%\"><font color=#008000>U S E R&nbsp;&nbsp;"
                + "S C O R E &nbsp;&nbsp;&nbsp;&nbsp;R E P O R T</font></td>"
                + "</tr></table><br>"
                + "<table width=\"978\" border=\"1\">"
                + "<tr bgcolor=\"#023F70\">"
                + "<td align=\"left\"><font color=\"#ffffff\">Account-Id :"
                + "</font></td>"
                + "<td align=\"left\"><font color=\"#ffffff\">" + accountId + ""
                + "</font></td>"
                + "<td align=\"left\"><font color=\"#ffffff\">User-Id :"
                + "</font></td>"
                + "<td align=\"left\"><font color=\"#ffffff\">" + usrId + ""
                + "</font></td></tr>"
                + "<tr bgcolor=\"#023F70\">"
                + "<td align=\"left\"><font color=\"#ffffff\">Session-Id :"
                + "</font></td>"
                + "<td align=\"left\"><font color=\"#ffffff\">"
                + hashmap.get("ses_id") + "</font></td>"
                + "<td align=\"left\"><font color=\"#ffffff\">Completion Flag :"
                + "</font></td>"
                + "<td align=\"left\"><font color=\"#ffffff\">"
                + hashmap.get("comp_flg") + "</font></td></tr></table>"
                + "<br><table width=\"978\" border=\"1\">"
                + "<tr bgcolor=\"#023F70\"><td width=\"15%\""
                + "height=\"21\" align=\"center\"><font color=\"#ffffff\">"
                + "ACTIVITY</font></td><td width=\"15%\" height=\"21\""
                + "align=\"center\"><font color=\"#ffffff\">RAW-SCORE"
                + "</font></td><td width=\"30%\" height=\"21"
                + "\"align=\"center\"><font color=\"#ffffff\">STANNINE-SCORE"
                + "</font></td></tr>";
        }
        indUserIterator = individualUserDetails.iterator();
        while (indUserIterator.hasNext()) {
            hashmap = (HashMap) indUserIterator.next();
            report = report + "<tr><td align=center height=21 width=\"15%\">"
                    + ((String)hashmap.get("tri_id")).trim()
                    + hashmap.get("sub_test_id")
                    + "</td><td align=center height=21 width=\"15%\">"
                    + hashmap.get("raw_scr")
                    + "</td><td align=center height=21 width=\"20%\">"
                    + hashmap.get("stan_score") + "</td></tr>";
        }
        report = report + "</table></body></html>";
        String repName = accountId + usrId + "IndividualReport.xls";
        try {
            PrintWriter pr = new PrintWriter(new FileWriter(repPath + "\\"
                    + repName));
            if (pr != null) {
                pr.print(report);
            }
            pr.close();
        } catch (IOException t) {
            log.info("Requested path not found");
            throw new ExecMapRuntimeException();
        }
    }

    /**
     * generates Enabled/Disabled companies Report in .xls format.
     * @param accountid
     * @param grpid
     * @param assessmentSummaryDetails
     */
    public void generateExcelForEnabledDisabledComp(String repPath,
            List companiesList) {
        HashMap hashMap;
        String report = "<html><body><table width=\"978\" border=\"1\">"
                + "<tr bgcolor=\"#023F70\"><td width=\"15%\"><p align=\""
                + "center\" ><font color=\"#ffffff\">Account </font></p></td>"
                + "<td width=\"25%\"><p align=\"center\" ><font color="
                + "\"#ffffff\">Company</font></p></td><td width=\"25%\"><p "
                + "align=\"center\" ><font color=\"#ffffff\">Supervisor Name"
                + "</font></p></td><td width=\"25%\"><p align=\"center\" ><font"
                + " color=\"#ffffff\">Email</font></p></td><td width=\"10%\"><p"
                + " align=\"center\" ><font color=\"#ffffff\">Total User "
                + "Accounts</font></p></td></tr>";

        Iterator itr = companiesList.iterator();
        while (itr.hasNext()) {
            hashMap = (HashMap) itr.next();
            report = report + "<tr><td width=\"15%\"><p align=\"center\"> "
                    + hashMap.get("acct_id") + "</p></td>"
                    + "<td width=\"25%\"><p align=\"center\"> "
                    + hashMap.get("co_name") + "</p></td>"
                    + "<td width=\"25%\"><p align=\"center\"> "
                    + hashMap.get("company_manager_id") + "</p></td>"
                    + "<td width=\"25%\"><p align=\"center\"><a href=mailto:"
                    + hashMap.get("co_email") + ">" + hashMap.get("co_email")
                    + "</a></p></td>"
                    + "<td width=\"10%\"><p align=\"center\">"
                    + hashMap.get("User Accounts") + "</p></td></tr>";
        }
        report = report + "</table></body></html>";
        try {
            PrintWriter pr = new PrintWriter(new FileWriter(repPath + "\\"
                    + "EnabledDisabled.xls"));
            if (pr != null) {
                pr.print(report);
            }
            pr.close();
        } catch (IOException t) {
            log.info("Requested path not found");
            throw new ExecMapRuntimeException();
        }
    }

    /**
     * @param repPath Report path where excel report is stored.
     * @param skillSummaryReportModel for a prticular acctId and
     *        grpId. Generates Skill Summary Report in .xls format.
     */
    public void generateExcelForISkillSummaryRep(String repPath,
            SkillSummaryReportModel skillSummaryReportModel) {
        String report = null;
        report = "<html><body><table border=\"1\" width=\"33%\" height=\"43\" "
                + "cellspacing=\"1\" cellpadding=\"0\">"
                + "<tr><td width=\"39%\" height=\"19\" bgcolor=\"#023F70\">"
                + "<font color=\"#ffffff\">Supervisor</font></td>"
                + "<td width=\"61%\" height=\"19\" bgcolor=\"#023F70\">"
                + "<font color=\"#ffffff\">"
                + skillSummaryReportModel.getCompanymanager()
                + "</font></td></tr>"
                + "<tr><td width=\"39%\" height=\"19\" bgcolor=\"#023F70\">"
                + "<font color=\"#ffffff\">Coordinator</font></td>"
                + "<td width=\"61%\" height=\"19\" bgcolor=\"#023F70\">"
                + "<font color=\"#ffffff\">"
                + skillSummaryReportModel.getGroupID()
                + "</font></td></tr>"
                + "<tr><td width=\"39%\" height=\"19\" bgcolor=\"#023F70\">"
                + "<font color=\"#ffffff\">Group</font></td>"
                + "<td width=\"61%\" height=\"19\" bgcolor=\"#023F70\">"
                + "<font color=\"#ffffff\">"
                + skillSummaryReportModel.getGroupmanager()
                + "</font></td></tr></table><p><br></p>"
                + "<table border=\"1\" width=\"352\">"
                + "<tr><td width=\"100%\" align=\"center\" bgcolor=\"#023F70\""
                + "height=\"21\"><font color=\"#ffffff\">"
                + "S K I L L&nbsp;S C O R E&nbsp;S U M M A R Y</font></td></tr>"
                + "<tr><td width=\"10%\" height=\"21\" bgcolor=\"#023F70\">"
                + "<font color=\"#ffffff\"><strong>ID</strong></font></td>"
                + "<td width=\"30%\" height=\"21\" bgcolor=\"#023F70\">"
                + "<font color=\"#ffffff\">Testee</font></td>";

        Iterator skillShortIterator = skillSummaryReportModel.getSkillShort()
                .iterator();
        while (skillShortIterator.hasNext()) {
            report = report
                    + "<td height=\"21\" align=\"center\" bgcolor=\"#023F70\">"
                    + "<font color=\"#ffffff\">" + skillShortIterator.next()
                    + "" + "</font></td>";
        }
        report = report + "</tr>";
        Iterator resultIterator = skillSummaryReportModel.getResult()
                .iterator();
        while (resultIterator.hasNext()) {
            UserScoreInfoModel userScoreInfoModel = (UserScoreInfoModel)
                                                                resultIterator
                    .next();
            report = report
                    + "<tr><td height=\"21\" bgcolor=\"#023F70\">"
                    + "<font color=\"#ffffff\"><strong>"
                    + userScoreInfoModel.getTesteeId()
                    + ""
                    + "</font></strong></td><td height=\"21\" "
                    + "bgcolor=\"#023F70\"><font color=\"#ffffff\">"
                    + userScoreInfoModel.getUserName() + "" + "</font></td>";
            Iterator userScoreIterator = userScoreInfoModel.getUserScore()
                    .iterator();
            while (userScoreIterator.hasNext()) {
                report = report + "<td height=\"21\" align=\"center\">"
                        + userScoreIterator.next() + "" + "</td>";
            }
            report = report + "</tr>";
        }
        report = report + "</table></body></html>";
        String repName = skillSummaryReportModel.getAcctID()
                + skillSummaryReportModel.getGroupID()
                + "SkillSummaryReport.xls";
        try {
            PrintWriter pr = new PrintWriter(new FileWriter(repPath + "\\"
                    + repName));
            if (pr != null) {
                pr.print(report);
            }
            pr.close();
        } catch (IOException t) {
            log.info("Requested path not found");
            throw new ExecMapRuntimeException();
        }
    }

}
