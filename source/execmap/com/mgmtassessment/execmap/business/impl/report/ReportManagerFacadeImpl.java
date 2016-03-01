/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author :
 * @date : Aug 1, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.business.impl.report;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.IncorrectResultSizeDataAccessException;

import com.mgmtassessment.execmap.brules.rule.api.ParaGen;
import com.mgmtassessment.execmap.business.api.report.ReportManagerFacade;
import com.mgmtassessment.execmap.business.model.ReportModel;
import com.mgmtassessment.execmap.business.model.SkillSummaryReportModel;
import com.mgmtassessment.execmap.business.model.UserScoreInfoModel;
import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;
import com.mgmtassessment.execmap.common.exceptions.ExecMapRuntimeException;
import com.mgmtassessment.execmap.common.framework.business.AbstractFacadeImpl;
import com.mgmtassessment.execmap.common.util.SaveInMSExcel;
import com.mgmtassessment.execmap.common.util.search.HQLSearch;
import com.mgmtassessment.execmap.data.dao.types.CompanyUserMaster;
import com.mgmtassessment.execmap.data.daoapi.ReportDAO;
import com.mgmtassessment.execmap.webapp.converters.pdf.HTML2PDFConverter;

/**
 * ReportManagerFacadeImpl class implements the methods provided by the
 * interface ReportManagerFacade. This class is used for generating all types of
 * reports.
 */

public class ReportManagerFacadeImpl extends AbstractFacadeImpl implements
        ReportManagerFacade {

    /**
     * Logger variable.
     */
    private static Log log = LogFactory
                                      .getLog(ReportManagerFacadeImpl.class);

    /**
     * This property is set using Spring.
     */
    private ReportDAO     reportDAO;

    /**
     * Object to generate html to save as .xls.
     */
    private SaveInMSExcel saveInMSExcel = new SaveInMSExcel();

    /**
     * String to store whole html report.
     */
    private String        report        = null;

    /**
     * @param repPath report path of file
     * @param acct_id Account ID
     * @param user_id User ID Function used to get the individual marks in all
     *        tests from DAO class.
     * @throws DataNotFoundException Exception
     * @return List
     */
    public List getIndividualUserTestSessionDetails(String repPath,
            String acct_id, String user_id) throws DataNotFoundException {
        log.info("Fetching Individual user test score details");
        List userScoreDetails = reportDAO.getIndividualUserTestDetails(acct_id,
                user_id);
        saveInMSExcel.generateExcelForIndividualSummaryRep(repPath, acct_id,
                user_id, userScoreDetails);
        return userScoreDetails;
    }

    /**
     * Function responsible for generating all the leadership reports.
     * @param accountid
     * @param userid
     * @param reportModel
     * @return String
     */
    public String getReport(String accountid, String userid,
            ReportModel reportModel, String repPath, String imgPath)
            throws DataNotFoundException {
        log.info("Start Generate Leadership reports "
                 + "and General Individual report");
        String sesId = null;
        String repName = null;
        report = null;
        sesId = reportDAO.getLatestSessionID(accountid, userid);

        try {
            report = ((ParaGen) appCtxt.getBean(IConstants.PARAGEN)).getReport(
                    accountid, sesId, reportModel, imgPath);
        } catch (IncorrectResultSizeDataAccessException ex) {
            throw new DataNotFoundException("user.not.appeared.assessment", ex);
        }

        report = report + "</BODY></HTML>";
        int ranNum = (int) Math.rint(Math.random() * 10000);
        repName = accountid + userid + sesId + ranNum;
        try {
            PrintWriter pr = new PrintWriter(new FileWriter(repPath + "\\"
                    + repName + ".html"));
            if (pr != null) {
                pr.print(report);
            }

            pr.close();
            PrintWriter pr1 = new PrintWriter(new FileWriter(repPath + "\\"
                    + repName + ".doc"));
            if (pr1 != null) {
                pr1.print(report);
            }

            pr1.close();
        } catch (IOException t) {
            log.info("Requested path not found");
            throw new ExecMapRuntimeException();
        }
        return repName;
    }

    public void convertIntoPDF(String repPath, String repName, String imgPath,
            String rptId) {
        HTML2PDFConverter converter = new HTML2PDFConverter();
        converter.html2xml(repPath, repName + ".html");

        if (rptId.equals("1")) {
            converter.xml2pdfForGenInd(repPath, imgPath, repName + ".xml");
        } else {
            converter.xml2pdfForLead(repPath, imgPath, repName + ".xml", rptId);
        }
    }

    /**
     * @param accountid
     * @param grpid Group ID Function used to get the assessment summary report
     *        information from DAO class.
     * @return List
     */
    public List getAssessmentSummaryReport(String repPath, String accountid,
            String grpid) throws DataNotFoundException {

        List assessmentSummaryDetails = reportDAO.getAssessmentSummaryReport(
                accountid, grpid);
        saveInMSExcel.generateExcelForAssesSummRep(repPath, accountid, grpid,
                assessmentSummaryDetails);
        return assessmentSummaryDetails;
    }

    /**
     * Get list of enable or disable companies depending upon the status.
     * @param status
     * @return
     */
    public List getListofEnableOrDisableCompanies(String repPath, String status)
            throws DataNotFoundException {
        List companiesList = reportDAO
                .getListofEnableOrDisableCompanies(status);
        saveInMSExcel.generateExcelForEnabledDisabledComp(repPath,
                companiesList);
        return companiesList;
    }

    /**
     * @param rptId Returns all the companies associated withr rptId.
     * @return SortedMap
     */
    public SortedMap getAllCompanies(String rptId)
                         throws DataNotFoundException {
        SortedMap companies = reportDAO.getAllCompanies(rptId);
        return companies;
    }

    /**
     * Returns all the companies.
     * @return SortedMap
     */
    public SortedMap getAllCompanies() throws DataNotFoundException {
        SortedMap companies = reportDAO.getAllCompanies();
        return companies;
    }

    /**
     * @param acctId Returns all the groups associated with the acctId.
     * @return SortedSet
     */
    public SortedSet getAllGroups(String acctId) throws DataNotFoundException {
        SortedSet groupsNames = reportDAO.getAllGroups(acctId);
        return groupsNames;
    }

    /**
     * @param accountId
     * @param groupId
     * @param skills returns skillsummaryreportmodel for Skill Summary Report.
     * @return SkillSummaryReportModel
     */
    public SkillSummaryReportModel getSkillSummary(String repPath,
            String accountId, String groupId, String[] skills)
            throws DataNotFoundException {

        HashMap placeHolders = new HashMap();
        HQLSearch hqlsearch = (HQLSearch) appCtxt.getBean("hqlSearch");
        SkillSummaryReportModel skillSummaryReportModel =
                               new SkillSummaryReportModel();
        skillSummaryReportModel.setAcctID(accountId);
        try {
            skillSummaryReportModel.setGroupID(groupId);
            int cols = skills.length;
            LinkedList skillShort = new LinkedList();
            LinkedList skillFull = new LinkedList();
            for (int i = 0; i < (skills.length); i++) {
                skillShort.addLast(skillSummaryReportModel
                        .setSkillShort(Integer.parseInt(skills[i])));
                skillFull.addLast(skillSummaryReportModel.setSkillFull(Integer
                        .parseInt(skills[i])));
            }
            skillSummaryReportModel.setCols(cols);
            skillSummaryReportModel.setSkillShort(skillShort);
            skillSummaryReportModel.setSkillFull(skillFull);
            /**
             * Get the group manager
             */
            placeHolders.put("ACCTID", accountId);
            placeHolders.put("GRPID", groupId);
            List tempList = hqlsearch.search("GroupManagerKey", placeHolders);
            if (tempList.size() > 0) {
                CompanyUserMaster companyUserMaster =
                               (CompanyUserMaster)
                                tempList.get(0);
                skillSummaryReportModel.setGroupmanager(""
                        + companyUserMaster.getFirstName() + " "
                        + companyUserMaster.getLastName());
            } else {
                skillSummaryReportModel.setGroupmanager("NONE");
            }
            /**
             * Get the company manager
             */
            tempList = hqlsearch.search("CompanyManagerKey", placeHolders);
            if (tempList.size() > 0) {
                CompanyUserMaster companyUserMaster =
                                       (CompanyUserMaster)
                                        tempList.get(0);
                skillSummaryReportModel.setCompanymanager(""
                        + companyUserMaster.getFirstName() + " "
                        + companyUserMaster.getLastName());
            } else {
                skillSummaryReportModel.setCompanymanager("NONE");
            }
            /**
             * Get the number of rows
             */
            tempList = hqlsearch.search("CountTesteeUserKey", placeHolders);
            int rows = tempList.size();
            skillSummaryReportModel.setRows(rows);
            /*
             * store all the information.
             */
            LinkedList tempResult = new LinkedList();
            Iterator iterator = tempList.iterator();
            String temptesteeId = null;
            for (int i = 0; i < rows; i++) {
                UserScoreInfoModel userScoreInfoModel =
                                new UserScoreInfoModel();
                if (iterator.hasNext()) {
                    Object[] row = (Object[]) iterator.next();
                    temptesteeId = row[0].toString();
                    userScoreInfoModel.setTesteeId(temptesteeId);
                    userScoreInfoModel.setUserName(row[1].toString());
                }
                LinkedList tempData = new LinkedList();
                for (int j = 0; j < cols; j++) {
                    placeHolders.clear();
                    placeHolders.put("USRID", temptesteeId);
                    placeHolders.put("ACCTID", accountId);
                    placeHolders.put("ACCTIDD", accountId);
                    placeHolders.put("SKILLID", Integer.parseInt(skills[j]));
                    List scoreList = hqlsearch.search("StanScoreKey",
                            placeHolders);
                    if (scoreList.size() > 0) {
                        tempData.addLast(new Float(((BigDecimal) scoreList
                                .get(0)).floatValue()));
                    } else {
                        tempData.addLast(new Float(0));
                    }
                }
                userScoreInfoModel.setUserScore(tempData);
                tempResult.addLast(userScoreInfoModel);
            }
            skillSummaryReportModel.setResult(tempResult);
        } catch (DataNotFoundException e) {
            throw new DataNotFoundException("skill.score.not.found", e);
        }
        saveInMSExcel.generateExcelForISkillSummaryRep(repPath,
                skillSummaryReportModel);
        return skillSummaryReportModel;
    }

    /**
     * @param acctId
     * @param grpId
     * @param rptId Get all users corresponding to acctId and grpId.
     * @return Map
     */
    public Map getAllUsers(String acctId, String grpId, String rptId)
            throws DataNotFoundException {
        return reportDAO.getAllUsers(acctId, grpId, rptId);
    }

    /**
     * @param acctId
     * @param usrId
     * @return groupid corresponding to acctId and usrId
     * @throws DataNotFoundException
     */

    public String getGrpId(String acctId, String usrId) throws
                                                         DataNotFoundException {
        return reportDAO.getGrpId(acctId, usrId);
    }

    /**
     * @param acctId
     * @return company name corresponding to acctId
     * @throws DataNotFoundException
     */
    public String getCompName(String acctId) throws DataNotFoundException {
        return reportDAO.getCompName(acctId);
    }

    /**
     * @return ReportDAO Returns the reportDAO.
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
     * @return Returns the report.
     */
    public String getReport() {
        return report;
    }

    /**
     * @param report The report to set.
     */
    public void setReport(String report) {
        this.report = report;
    }
}