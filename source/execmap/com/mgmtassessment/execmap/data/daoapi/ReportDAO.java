/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : goenkani
 * @date : Jul 21, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.data.daoapi;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;

/**
 * ReportDao provides an interface for the generation of reports.
 */

public interface ReportDAO {

    /**
     * @param accountid of the user.
     * @param userid of the user.
     * This function is used for the generation of Individual reports
     * which contains user's score in each test.
     * @return a list containing test details for an user
     * @throws DataNotFoundException if no data found
     */
    List getIndividualUserTestDetails(String accountid, String userid)
                                                  throws DataNotFoundException;

    /**
     * @param acctId accountid of the user.
     * @param userId userid of the user.
     * This function returns the latest session ID of a user.
     * @return latest session Id for the given acctId & userId.
     */
    String getLatestSessionID(String acctId, String userId)
                                                   throws DataNotFoundException;

    /**
     * @param rptId ID of a particular report
     * This function returns a collection of condition
     * ID's of a particular report
     * @return collection containing all the condition Ids related to a report.
     */
    Collection getConditionID(String rptId) throws DataNotFoundException;

    /**
     * @param accountID accountid of the user.
     * @param SessionID sessionid of user
     * @param SkillID's various skill ID's
     * This function returns Map having skill ID as well as score
     * given leader ship skills for a perticular user it determines
     * the user's score for a perticular user.
     * @return Map having skill ID as well as score given leader ship skills for
     *         a perticular user it determines the user's score for a perticular
     *         user.
     */
    Map getLeadershipSkillScore(String acctID, String sesID, int[] skillIDArray)
                                                   throws DataNotFoundException;

    /**
     * @param accountId accountid of the user.
     * @param sessionId sessionid of user
     * This function retuns the audio status.
     * @return audio flag status
     */
    String getAudioFlag(String acctID, String sesID)
                                                   throws DataNotFoundException;

    /**
     * @param rptId ID of a particular report
     * @param Language current locale language
     * @param Para-Set Set of para ID's
     * this function reutrns a Collection of paraid's it determines para desc
     * associated with a perticular id.
     * @return Collection Given a list of paraid's it determines para desc
     *         associated with a perticular id
     */
    Collection getParaIDAndParaDesc(String rptId, Set paraIdSet, String lang)
                                                   throws DataNotFoundException;

    /**
     * @param accountId accountid of the user.
     * This function returns name of the image of the company
     * associated with the accountId.
     * @return name of the image of the company associated with the accountId
     */
    String getCobrand(String accountid) throws DataNotFoundException;

    /**
     * @param accountid accountid of the user.
     * @param sessionId sessionid of the user.
     * This function returns name of the user associated with the
     * accpuntId & sessionId.
     * @return Name of the user associated with the accpuntId & sessionId
     */
    String getUserName(String accountid, String ses_id) throws
                                                         DataNotFoundException;

    /**
     * @param accountid accountid of the user.
     * @param sessionId sessionid of the user.
     * This function returns end date for the user with
     * accountId & sessionId.
     * @return end date for the user with accountId & sessionId
     */
    Date getDateIndicator(String accountid, String sessionid) throws
                                                        DataNotFoundException;

    /**
     * @param conditionid conditionid.
     * @param activityid activityid.
     * This function returns skill-group-id for a particular account.
     * @return String Given a particular account information it retrives the
     *         skill-group-id for it
     */
    String getSkillGroupID(String conditionid, String activityid) throws
                                                        DataNotFoundException;

    /**
     * @param skillGroupId for which skill count is required.
     * This function returns skill count for a particular
     * Skill-Group-id.
     * @return String Given a particular Skill-Group-id it retrives the skill
     *         count for it
     */
    String getSkillCount(String skillGroupId) throws DataNotFoundException;

    /**
     * @param accountid of the user.
     * @param sessionid of the user.
     * @param skillGroupId for which score is required.
     * This function retrives the score for skills for a
     * particular Skill-Group-id.
     * @return Collection Given a particular Skill-Group-id it retrives the
     *         score for skills it
     */
    Collection getSkillScore(String accountid, String sessionid,
            String skillGroupId) throws DataNotFoundException;

    /**
     * @param skillGroupId for which skill ids are required.
     * This function retrives the skill ids for a particular Skill-Group-id.
     * @return Collection Given a particular Skill-Group-id it retrives the
     *         skill ids for it
     */
    Collection getSkillIds(String skillGroupId) throws DataNotFoundException;

    /**
     * @param skillId for which skill name is required.
     * This function returns skill name for a particular skill id.
     * @return String Given a particular skill id it retrives the name for it
     */
    String getSkillName(String skillId) throws DataNotFoundException;
    /**
     * @param accountID accountid of user
     * @param SessionID sessionid of user
     * @param SkillID's skill ID's of user
     * This function returns the user's stanine score for a particular skill.
     * @return It determines the user's stanine score for a particular skill
     */
    Float getSkillStanScore(String acctID, String sesID, int skillID) throws
                                                        DataNotFoundException;

    /**
     * @param accountid of the company.
     * @param grpid of the group.
     * This function returns list with all the user
     * information about report.
     * @return list with all the user information about report
     */
    List getAssessmentSummaryReport(String accountid, String grpid) throws
                                                        DataNotFoundException;

    /**
     * @param status of the company.
     * This function returns List of Enabled or Disabled Companies.
     * @return List of Enabled or Disabled Companies.
     */
    List getListofEnableOrDisableCompanies(String status) throws
                                                        DataNotFoundException;

    /**
     * @param rptId associated with the companies.
     * This function returns a sorted map of companies with rptId.
     * @return a sorted map of companies with rptId
     */
    SortedMap getAllCompanies(String rptId) throws DataNotFoundException;

    /**
     * This function returns a sorted map of all the companies.
     * @return a sorted map of all the companies
     */
    SortedMap getAllCompanies() throws DataNotFoundException;

    /**
     * @param acctId of the company.
     * This function returns SortedSet of all the groups in acctId.
     * @return SortedSet of all the groups in acctId.
     */
    SortedSet getAllGroups(String acctId) throws DataNotFoundException;

    /**
     * @param acctId accountId accountid of user
     * @param grpId grouppId of user
     * @param rptId ID of report
     * This function returns Map with all users of acctId
     * and grpId having rptId.
     * @return Map with all users of acctId and grpId having rptId.
     */
    Map getAllUsers(String acctId, String grpId, String rptId) throws
                                                        DataNotFoundException;

    /**
     * @param accountId accountid of user
     * @param sessionId sessionid of user
     * This function returns no of times user, with this
     * accountId & sessionId, changed his answers.
     * @return no of times user, with this accountId & sessionId, changed his
     *         answers
     */
    int getChangeInAnswers(String acctID, String sesID) throws
                                                        DataNotFoundException;

    /**
     * @param accountId accountid of user
     * @param sessionId sessionid of user
     * This function returns no of times duration of an assessment expired.
     * @return no of times duration of an assessment expired.
     */
    int getNoOfExpirations(String acctID, String sesID) throws
                                                        DataNotFoundException;

    /**
     * @param
     * @param acctId accountid of user
     * @param usrId userid of user
     * This function returns grpId corresponding to acctId and usrId.
     * @return grpId corresponding to acctId and usrId
     * @throws DataNotFoundException
     */
    String getGrpId (String acctId, String usrId) throws DataNotFoundException;

    /**
     * @param acctId accountid of company
     * This function returns company name corresponding to acctId.
     * @return company name corresponding to acctId
     * @throws DataNotFoundException
     */
    String getCompName(String acctId) throws DataNotFoundException;
}