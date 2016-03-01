/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : kapilpra
 * @date : Jul 21, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.business.api.report;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

import com.mgmtassessment.execmap.business.model.ReportModel;
import com.mgmtassessment.execmap.business.model.SkillSummaryReportModel;
import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;
import com.mgmtassessment.execmap.common.exceptions.ExecMapRuntimeException;
import com.mgmtassessment.execmap.common.framework.business.AbstractFacade;

/**
 * Interface for generating all types of reports.
 *
 * @author kapilpra
 */

public interface ReportManagerFacade extends AbstractFacade {

    /**
     * Generate Individual user Score report in various tests.
     * @param accountid of the user.
     * @param userid of the user.
     * @param repPath where report will be stored.
     * @return List
     * @throws DataNotFoundException thrown by DAO
     */
    List getIndividualUserTestSessionDetails(String repPath, String accountid,
            String userid) throws DataNotFoundException;

    /**
     * @param repName
     * @param rptId
     * converts the given html report into PDF
     */
    void convertIntoPDF(String repPath, String repName, String imgPath,
            String rptId);

    /**
     * Generate all the leadership reports and general individual report.
     * @param repPath
     * @param accountid
     * @param userid
     * @param reportModel
     * @return String
     */

    String getReport(String accountid, String userid, ReportModel reportModel,
            String repPath, String imgPath) throws DataNotFoundException;

    /**
     * Generate Assessment Summary report and store an MSExcel format of report
     * at repPath.
     * @param repPath
     * @param accountid
     * @param grpid
     * @return list with assessment report of the group
     */
    List getAssessmentSummaryReport(String repPath, String accountid,
            String grpid) throws DataNotFoundException;

    /**
     * Get list of enable or disable companies depending upon the status.
     * @param status
     * @return list of all the enabled or disabled companies
     */
    List getListofEnableOrDisableCompanies(String repPath, String status)
                                                throws DataNotFoundException;

    /**
     * returns all companies for all leadership reports and Individual User
     * reports.
     * @param rptId
     * @return Map containing all the companies with given rptId
     */
    SortedMap getAllCompanies(String rptId) throws DataNotFoundException;

    /**
     * returns all companies.
     */
    SortedMap getAllCompanies() throws DataNotFoundException;

    /**
     * @param acctId
     * @return all groups with acctId
     */
    SortedSet getAllGroups(String acctId) throws DataNotFoundException;

    /**
     * @param accountId
     * @param grpId
     * @param skills
     * @return skillSummaryReportModel for Skill Summary Report.
     */
    SkillSummaryReportModel getSkillSummary(String repPath, String accountId,
                    String grpId, String[] skills)
                        throws DataNotFoundException;

    /**
     * @param acctId
     * @param grpId
     * @param rptId
     * @return map with all users with these acctId, grpId and rptId
     */
    Map getAllUsers(String acctId, String grpId, String rptId)
                                                throws DataNotFoundException;

    /**
     * @param acctId
     * @param usrId
     * @return grpId corresponding to acctId and usrId.
     */
    String getGrpId(String acctId, String usrId) throws DataNotFoundException;

    /**
     * @param acctId
     * @return company name corresponding to acctId
     * @throws DataNotFoundException
     */
    String getCompName(String acctId) throws DataNotFoundException;

}
