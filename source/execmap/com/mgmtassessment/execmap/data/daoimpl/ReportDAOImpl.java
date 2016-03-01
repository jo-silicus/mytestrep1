/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : goenkani
 * @date : Jul 21, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.data.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.mgmtassessment.execmap.business.model.AssessmentSummaryModel;
import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;
import com.mgmtassessment.execmap.data.daoapi.ReportDAO;

/**
 * ReportDAOImpl implements ReportDao interface and gives the implementation of
 * the methods for the reports generation.
 */

public class ReportDAOImpl implements ReportDAO {

    /** logger for this class. */
    private static Log log = LogFactory
                                  .getLog(ReportDAOImpl.class);

    /**
     * reference for the object created in application context.
     */
    private JdbcTemplate        jdbcTemplate;

    private static final String SQL_PARTICULAR_COMPANY_USER =
        "select A.ses_id,comp_flg,tri_id,sub_test_id,raw_scr, stan_score "
        + "from SQLsysintcue3180.test_ses_mas A,"
        + "SQLsysintcue3180.test_ses_scr_det B "
        + " where B.acct_id = ?  AND B.ses_id=(SELECT MAX(ses_id) "
        + "from SQLsysintcue3180.test_ses_mas WHERE acct_id = ? AND usr_id = ?)"
        + " and B.acct_id = A.acct_id and B.ses_id = A.ses_id";

    private static final String SQL_CONDITION_ID                    = "SELECT COND_ID FROM SQLsysintcue3180.rpt_para_det WHERE rpt_id =?";

    private static final String SQL_SESSION_ID                      = "SELECT MAX(SES_ID) 'SES_ID' FROM SQLsysintcue3180.TEST_SES_MAS WHERE ACCT_ID =? AND USR_ID=? AND COMP_FLG = 'T'";

    private static final String SQL_LEADERSHIP_A_SKILL              = "SELECT SKILL_STAN_SCR FROM SQLsysintcue3180.test_ses_skill_scr_det WHERE ACCT_ID =? AND SES_ID =?  AND SKILL_ID =?";

    private static final String SQL_AUDIO_FLAG                      = "SELECT audio_flg FROM SQLsysintcue3180.test_ses_scr_det WHERE ACCT_ID = ? AND SES_ID = ? AND TRI_ID = 'MEM'";

    private static final String SQL_PARAGRAPH                       = "SELECT A.PARA_ID,B.PARA_DESC FROM SQLsysintcue3180.rpt_para_det A,SQLsysintcue3180.rpt_para_mas B WHERE A.rpt_id =?  AND A.COND_ID =? AND B.PARA_ID = A.PARA_ID AND B.Lang_id =? ";

    private static final String SQL_COBRAND                         = "SELECT cobra_Info FROM SQLsysintcue3180.co_acct_mas WHERE acct_id =? ";

    private static final String SQL_USER_NAME_CO_USR_MAS            = "SELECT first_name+' '+last_name FROM SQLsysintcue3180.co_usr_mas WHERE acct_id =? AND usr_id = (SELECT usr_id FROM SQLsysintcue3180.test_ses_mas WHERE acct_id =? AND ses_id =?)";

    private static final String SQL_DATE_INDICATOR                  = "SELECT dt_end FROM SQLsysintcue3180.test_ses_mas WHERE acct_id =? AND ses_id =? ";

    private static final String SQL_NOTES                           = "SELECT NOTES1 FROM SQLsysintcue3180.CO_USR_MAS WHERE acct_id = '$ACCT_ID' AND usr_id = (SELECT usr_id FROM SQLsysintcue3180.test_ses_mas WHERE acct_id = '$ACCT_ID' AND ses_id = ?)";

    private static final String SQL_SKILL_GRP_ID_GENERAL_INDIVIDUAL = "SELECT skill_grp_id FROM SQLsysintcue3180.skill_grp_cond_rel WHERE cond_id =?";

    private static final String SQL_SKILL_GRP_ID_LEADERSHIP         = "SELECT skill_grp_id FROM SQLsysintcue3180.skill_grp_cond_rel WHERE cond_id =? AND rpt_id =? ";

    private static final String SQL_SKILL_COUNT                     = "SELECT COUNT(skill_id) FROM SQLsysintcue3180.skill_grp_skill_rel WHERE skill_grp_id =? ";

    private static final String SQL_SKILL_STAN_SCR                  = "SELECT skill_stan_scr FROM SQLsysintcue3180.test_ses_skill_scr_det WHERE acct_id =? AND ses_id =? AND   skill_id IN   (SELECT skill_id FROM SQLsysintcue3180.skill_grp_skill_rel  WHERE skill_grp_id =?) ";

    private static final String SQL_SKILL_ID                        = "SELECT skill_id FROM SQLsysintcue3180.skill_grp_skill_rel WHERE skill_grp_id =? ";

    private static final String SQL_SKILL_NAME                      = "SELECT skill_name FROM SQLsysintcue3180.skill_mas WHERE skill_id =? ";

    private static final String SQL_LIST_USER_ID                    = "select A.usr_id from SQLsysintcue3180.co_usr_mas A, SQLsysintcue3180.test_ses_mas B, SQLsysintcue3180.test_ses_scr_det C  where A.acct_id =B.acct_id AND A.acct_id= C.acct_id AND A.usr_id=B.usr_id AND B.ses_id=C.ses_id AND A.acct_id= ? AND A.grp_id = ? order by A.usr_id";

    private static final String SQL_USER_COMP_ACTIVITIES            = "select first_name+' '+last_name usr_name, usr_email, A.ses_id, A.dt_start, A.comp_flg ,B.tri_id+B.sub_test_id 'test_id' from SQLsysintcue3180.test_ses_mas A, SQLsysintcue3180.test_ses_scr_det B, SQLsysintcue3180.co_usr_mas C where C.acct_id=A.acct_id and C.usr_id=A.usr_id and C.acct_id=B.acct_id and A.ses_id=B.ses_id and C.acct_id = ? AND C.usr_id = ? order by A.acct_id";

    private static final String SQL_LIST_ENABLE_COMPANIES           = "select A.acct_id,A.co_name,C.usr_id,A.co_email from SQLsysintcue3180.CO_ACCT_MAS A,SQLsysintcue3180.ACCT_MAS B,SQLsysintcue3180.CO_USR_MAS C where A.ACCT_ID=B.ACCT_ID and A.ACCT_ID=C.ACCT_ID and B.acct_stat = ? and C.actv_rol_id=2 order by A.acct_id";

    private static final String SQL_LIST_ALL_COMPANIES              = "SELECT ACCT_ID, CO_NAME FROM SQLsysintcue3180.co_acct_mas order by ACCT_ID";

    private static final String SQL_LIST_ALL_COMPANIES_WITH_RPTID   = "SELECT ACCT_ID, CO_NAME FROM SQLsysintcue3180.co_acct_mas where rpt_Id =? order by ACCT_ID";

    private static final String SQL_LIST_ALL_GROUPS                 = "SELECT grp_id from SQLsysintcue3180.co_grp_mas where acct_id =? order by grp_id";

    private static final String SQL_LIST_ALL_USERS_WITH_COMP_FLG_T  = "SELECT A.usr_id, A.first_name +' '+ A.last_name name from SQLsysintcue3180.co_usr_mas A, SQLsysintcue3180.test_ses_mas B where A.acct_id =B.acct_id and A.usr_id = B.usr_id and A.acct_id=? and A.grp_id =? and B.comp_flg='T' and A.actv_rol_id=5 order by A.first_name";

    private static final String SQL_LIST_ALL_USERS                  = "SELECT usr_id, first_name +' '+ last_name name from SQLsysintcue3180.co_usr_mas  where acct_id=? and grp_id =? and actv_rol_id=5 order by first_name";

    private static final String SQL_NO_OF_CHANGES                   = "SELECT times_answer_changed from SQLsysintcue3180.test_ses_mas where acct_id=? and ses_id=?";

    private static final String SQL_TIMES_EXPIRED                   = "SELECT times_expired from SQLsysintcue3180.test_ses_mas where acct_id=? and ses_id=?";

    private static final String SQL_GRP_ID                          = " SELECT grp_id from SQLsysintcue3180.co_usr_mas where acct_id=? and usr_id=?";

    private static final String SQL_COMP_NAME                       = "SELECT co_name from SQLsysintcue3180.co_acct_mas where acct_id=?";

    /**
     * @param accountid of the user.
     * @param userid of the user.
     * This function is used for the generation of Individual reports
     * which contains user's score in each test.
     * @return a list containing test details for an user
     * @throws DataNotFoundException if no data found
     */
    public List getIndividualUserTestDetails(String accountid, String userid)
            throws DataNotFoundException {
        String queryString = SQL_PARTICULAR_COMPANY_USER;
        Object[] params = new Object[]{accountid, accountid, userid};
        List sesDetails = getJdbcTemplate().queryForList(queryString, params);
        return sesDetails;
    }

    /**
     * @param jdbcTemplate The jdbcTemplate to set.
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * @return Returns the jdbcTemplate.
     */
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    /**
     * @param rptId ID of a particular report
     * This function returns a collection of condition
     * ID's of a particular report
     * @return collection containing all the condition Ids related to a report.
     */
    public Collection getConditionID(String rptId)
                          throws DataNotFoundException {

        String queryString = SQL_CONDITION_ID;
        Object[] params = new Object[]{rptId};
        List condid = getJdbcTemplate().queryForList(queryString, params);
        return condid;

    }

    /**
     * @param acctId accountid of the user.
     * @param userId userid of the user.
     * This function returns the latest session ID of a user.
     * @return latest session Id for the given acctId & userId.
     */
    public String getLatestSessionID(String acctId, String userId)
            throws DataNotFoundException {
        String sesId = null;
        String queryString = SQL_SESSION_ID;
        Object[] params = new Object[]{acctId, userId};
        sesId = (String) getJdbcTemplate().queryForObject(queryString, params,
                String.class);

        return sesId;

    }

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
    public Map getLeadershipSkillScore(String acctID, String sesID,
            int[] skillIDArray) throws DataNotFoundException {
        Map result = new HashMap();
        String queryString = SQL_LEADERSHIP_A_SKILL;
        for (int skillID = 0; skillID < skillIDArray.length; skillID++) {
            Object[] params = new Object[]
                                        {acctID, sesID, skillIDArray[skillID]};
            List skillIdScore = getJdbcTemplate().queryForList(queryString,
                    params);

            if (skillIdScore.iterator().hasNext()) {
                result.put(new Integer(skillIDArray[skillID]), new Float(""
                        + (((LinkedHashMap) skillIdScore.iterator().next())
                                .get("SKILL_STAN_SCR"))));
            } else {
                result.put(new Integer(skillIDArray[skillID]), new Float(0));
            }
        }

        return result;
    }

    /**
     * @param accountID accountid of user
     * @param SessionID sessionid of user
     * @param SkillID's skill ID's of user
     * This function returns the user's stanine score for a particular skill.
     * @return It determines the user's stanine score for a particular skill
     */
    public Float getSkillStanScore(String acctID, String sesID, int skillID)
            throws DataNotFoundException {
        String queryString = SQL_LEADERSHIP_A_SKILL;
        Object[] params = new Object[]{acctID, sesID, skillID};
        Float skillIdScore = (Float) getJdbcTemplate().queryForObject(
                queryString, params, Float.class);

        return skillIdScore;
    }

    /**
     * @param accountId accountid of the user.
     * @param sessionId sessionid of user
     * This function retuns the audio status.
     * @return audio flag status
     */
    public String getAudioFlag(String acctID, String sesID)
            throws DataNotFoundException {
        String audioFlag = "";
        String queryString = SQL_AUDIO_FLAG;
        Object[] params = new Object[]{acctID, sesID};
        audioFlag = (String) getJdbcTemplate().queryForObject(queryString,
                params, String.class);

        return audioFlag;
    }

    /**
     * @param rptId ID of a particular report
     * @param Language current locale language
     * @param Para-Set Set of para ID's
     * this function reutrns a Collection of paraid's it determines para desc
     * associated with a perticular id.
     * @return Collection Given a list of paraid's it determines para desc
     *         associated with a perticular id
     */
    public Collection getParaIDAndParaDesc(String rptId, Set paraIdSet,
            String lang) throws DataNotFoundException {

        HashMap ruleAndPara = new HashMap();
        HashMap ruleAndParaId = new HashMap();
        Iterator paraIdIiterator = paraIdSet.iterator();

        String queryString = SQL_PARAGRAPH;
        while (paraIdIiterator.hasNext()) {
            Integer ruleId = (Integer) paraIdIiterator.next();
            Object[] params = new Object[]{rptId, ruleId, lang};

            final HashMap paraIdDesc = new HashMap();
            getJdbcTemplate().query(queryString, params,
                    new RowCallbackHandler() {
                        public void processRow(ResultSet rs)
                                throws SQLException {

                            String paraID = rs.getString("PARA_ID");
                            String para = rs.getString("PARA_DESC");
                            paraIdDesc.put("PARA_ID", paraID);
                            paraIdDesc.put("PARA_DESC", para);
                        }
                    });

            String para = (String) paraIdDesc.get("PARA_DESC");
            String paraID = (String) paraIdDesc.get("PARA_ID");
            if (para != null) {
                ruleAndParaId.put(ruleId, paraID.trim());
                ruleAndPara.put(ruleId, para.trim());
            }
        }

        ArrayList result = new ArrayList();
        result.add((Object) ruleAndParaId);
        result.add((Object) ruleAndPara);

        return result;
    }

    /**
     * @param accountId accountid of the user.
     * This function returns name of the image of the company
     * associated with the accountId.
     * @return name of the image of the company associated with the accountId
     */
    public String getCobrand(String accountid) throws DataNotFoundException {

        String cobrand = null;
        String queryString = SQL_COBRAND;
        Object[] params = new Object[]{accountid};
        cobrand = (String) getJdbcTemplate().queryForObject(queryString,
                params, String.class);

        return cobrand;
    }

    /**
     * @param accountid accountid of the user.
     * @param sessionId sessionid of the user.
     * This function returns name of the user associated with the
     * accpuntId & sessionId.
     * @return Name of the user associated with the accpuntId & sessionId
     */
    public String getUserName(String accountid, String sesId)
            throws DataNotFoundException {

        String username = null;
        String queryString = SQL_USER_NAME_CO_USR_MAS;
        Object[] params = new Object[]{accountid, accountid, sesId};
        username = (String) getJdbcTemplate().queryForObject(queryString,
                params, String.class);

        return username;

    }

    /**
     * @param accountid accountid of the user.
     * @param sessionId sessionid of the user.
     * This function returns end date for the user with
     * accountId & sessionId.
     * @return end date for the user with accountId & sessionId
     */
    public Date getDateIndicator(String accountid, String sessionid)
            throws DataNotFoundException {

        Date dateind = null;
        String queryString = SQL_DATE_INDICATOR;
        Object[] params = new Object[]{accountid, sessionid};
        dateind = (Date) getJdbcTemplate().queryForObject(queryString, params,
                Date.class);

        return dateind;

    }

    /**
     * @param conditionid conditionid.
     * @param activityid activityid.
     * This function returns skill-group-id for a particular account.
     * @return String Given a particular account information it retrives the
     *         skill-group-id for it
     */
    public String getSkillGroupID(String conditionid, String activityid)
            throws DataNotFoundException {

        String groupId = null;
        final HashMap grpIds = new HashMap();
        String queryString = null;
        if (activityid.equals(IConstants.LEADERSHIP_A_REPORT)
                || activityid.equals(IConstants.LEADERSHIP_E_REPORT)) {
            queryString = SQL_SKILL_GRP_ID_LEADERSHIP;
            Object[] params = new Object[]{conditionid, activityid};
            groupId = (String) getJdbcTemplate().queryForObject(queryString,
                    params, String.class);

        } else if (activityid.equals(IConstants.GENERAL_INDIVIDUAL_REPORT)
                || activityid.equals(IConstants.EXECMAP_EXECUTIVE_SUMMARY)) {
            queryString = SQL_SKILL_GRP_ID_GENERAL_INDIVIDUAL;
            Object[] params = new Object[]{conditionid};

            jdbcTemplate.query(queryString, params, new RowCallbackHandler() {
                private int i = 1;

                public void processRow(ResultSet rs) throws SQLException {
                    String grpId = (rs.getString("skill_grp_id"));
                    grpIds.put("" + (i++), grpId);
                }
            });
            if (activityid.equals(IConstants.GENERAL_INDIVIDUAL_REPORT)
                    && conditionid.equals("2")) {
                groupId = (String) grpIds.get("2");
            } else {
                groupId = (String) grpIds.get("1");
            }
        }

        return groupId;

    }

    /**
     * @param skillGroupId for which skill count is required.
     * This function returns skill count for a particular
     * Skill-Group-id.
     * @return String Given a particular Skill-Group-id it retrives the skill
     *         count for it
     */
    public String getSkillCount(String skillGroupId)
            throws DataNotFoundException {

        String skillCount = null;
        String queryString = SQL_SKILL_COUNT;
        Object[] params = new Object[]{skillGroupId};
        skillCount = (String) getJdbcTemplate().queryForObject(queryString,
                params, String.class);

        return skillCount;

    }

    /**
     * @param accountid of the user.
     * @param sessionid of the user.
     * @param skillGroupId for which score is required.
     * This function retrives the score for skills for a
     * particular Skill-Group-id.
     * @return Collection Given a particular Skill-Group-id it retrives the
     *         score for skills it
     */
    public Collection getSkillScore(String accountid, String sessionid,
            String skillGroupId) throws DataNotFoundException {

        List skillScoreList = new ArrayList();
        String queryString = SQL_SKILL_STAN_SCR;
        Object[] params = new Object[]{accountid, sessionid, skillGroupId};
        skillScoreList = getJdbcTemplate().queryForList(queryString, params);

        return skillScoreList;

    }

    /**
     * @param skillGroupId for which skill ids are required.
     * This function retrives the skill ids for a particular Skill-Group-id.
     * @return Collection Given a particular Skill-Group-id it retrives the
     *         skill ids for it
     */
    public Collection getSkillIds(String skillGroupId)
            throws DataNotFoundException {

        List skillIdList = new ArrayList();
        String queryString = SQL_SKILL_ID;
        Object[] params = new Object[]{skillGroupId};
        skillIdList = getJdbcTemplate().queryForList(queryString, params);

        return skillIdList;

    }

    /**
     * @param skillId for which skill name is required.
     * This function returns skill name for a particular skill id.
     * @return String Given a particular skill id it retrives the name for it
     */
    public String getSkillName(String skillId) throws DataNotFoundException {

        String skillName = null;
        String queryString = SQL_SKILL_NAME;
        Object[] params = new Object[]{skillId};
        skillName = (String) getJdbcTemplate().queryForObject(queryString,
                params, String.class);
        return skillName;

    }

    /**
     * @param accountid of the company.
     * @param grpid of the group.
     * This function returns list with all the user
     * information about report.
     * @return list with all the user information about report
     */
    public List getAssessmentSummaryReport(String accountid, String grpid)
            throws DataNotFoundException {
        List users = new ArrayList();
        List summaryAssesmentInfo = new ArrayList();
        String queryString = SQL_LIST_USER_ID;
        String userid = null;
        Object[] params = new Object[]{accountid, grpid};
        users = getJdbcTemplate().queryForList(queryString, params);

        Iterator usersIterator = users.iterator();
        while (usersIterator.hasNext()) {
            LinkedHashMap userMap = (LinkedHashMap) usersIterator.next();
            final AssessmentSummaryModel assessmentSummaryModel =
                                   new AssessmentSummaryModel();
            userid = ((String) userMap.get("usr_id")).toString();
            queryString = SQL_USER_COMP_ACTIVITIES;
            params[0] = accountid;
            params[1] = userid;

            getJdbcTemplate().query(queryString, params,
                    new RowCallbackHandler() {
                        private String testid = "";

                        private int    i      = 1;

                        public void processRow(ResultSet rs)
                                throws SQLException {
                            if (i == 1) {
                                testid = rs.getString("test_id").trim();
                                assessmentSummaryModel.setUsrName(rs.getString(
                                        "usr_name").trim());
                                assessmentSummaryModel.setUsrEmail(rs
                                        .getString("usr_email").trim());
                                assessmentSummaryModel.setSesId(rs.getString(
                                        "ses_id").trim());
                                assessmentSummaryModel.setStartDate(rs
                                        .getDate("dt_start"));
                                assessmentSummaryModel.setCompFlg(rs.getString(
                                        "comp_flg").trim());
                                i++;
                            } else {
                                testid += ", " + rs.getString("test_id").trim();
                            }
                            assessmentSummaryModel.setTestIdCompleted(testid);
                        }

                    });

            summaryAssesmentInfo.add(assessmentSummaryModel);

        }

        return summaryAssesmentInfo;

    }

    /**
     * @param status of the company.
     * This function returns List of Enabled or Disabled Companies.
     * @return List of Enabled or Disabled Companies.
     */
    public List getListofEnableOrDisableCompanies(String status)
            throws DataNotFoundException {
        List enableCompaniesList = new ArrayList();
        List finalenabledisableCompaniesList = new ArrayList();
        String queryString = SQL_LIST_ENABLE_COMPANIES;
        Object[] params = new Object[]{status};
        enableCompaniesList = getJdbcTemplate().queryForList(queryString,
                params);
        Iterator tempIterator = enableCompaniesList.iterator();
        while (tempIterator.hasNext()) {
            LinkedHashMap linkedHashMap = (LinkedHashMap) tempIterator.next();
            queryString = "select count(usr_id) 'User Accounts' "
                    + "from SQLsysintcue3180.co_usr_mas C where C.acct_id = ? ";
            params = new Object[]{linkedHashMap.get("acct_id")};
            Integer useraccounts = new Integer(getJdbcTemplate().queryForInt(
                    queryString, params));
            linkedHashMap.put("User Accounts", useraccounts);
            finalenabledisableCompaniesList.add(linkedHashMap);
        }
        return finalenabledisableCompaniesList;
    }

    /**
     * @param rptId associated with the companies.
     * This function returns a sorted map of companies with rptId.
     * @return a sorted map of companies with rptId
     */
    public SortedMap getAllCompanies(String rptId)
                         throws DataNotFoundException {
        final SortedMap companies = new TreeMap();
        String query = SQL_LIST_ALL_COMPANIES_WITH_RPTID;
        if (rptId == null || rptId.equals("Ind")) {
            query = SQL_LIST_ALL_COMPANIES;
            getJdbcTemplate().query(query, new RowCallbackHandler() {
                public void processRow(ResultSet rs) {
                    try {
                        String coName = rs.getString("co_name");
                        String acctId = rs.getString("acct_id");
                        companies.put(acctId, coName);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            });
            return companies;
        }
        Object[] params = new Object[]{rptId};
        getJdbcTemplate().query(query, params, new RowCallbackHandler() {
            public void processRow(ResultSet rs) {
                try {
                    String coName = rs.getString("co_name");
                    String acctId = rs.getString("acct_id");
                    companies.put(acctId, coName);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        return companies;
    }

    /**
     * This function returns a sorted map of all the companies.
     * @return a sorted map of all the companies
     */
    public SortedMap getAllCompanies() throws DataNotFoundException {
        final SortedMap companies = new TreeMap();
        String query = SQL_LIST_ALL_COMPANIES;
        getJdbcTemplate().query(query, new RowCallbackHandler() {
            public void processRow(ResultSet rs) {
                try {
                    String coName = rs.getString("co_name");
                    String acctId = rs.getString("acct_id");
                    companies.put(acctId, coName);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        return companies;
    }

    /**
     * @param acctId of the company.
     * This function returns SortedSet of all the groups in acctId.
     * @return SortedSet of all the groups in acctId.
     */
    public SortedSet getAllGroups(String acctId) throws DataNotFoundException {
        final SortedSet groupsList = new TreeSet();
        String query = SQL_LIST_ALL_GROUPS;
        Object[] params = new Object[]{acctId};
        getJdbcTemplate().query(query, params, new RowCallbackHandler() {
            public void processRow(ResultSet rs) {
                try {
                    String grpId = (String) rs.getString("grp_id");
                    groupsList.add(grpId);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        return groupsList;
    }

    /**
     * @param acctId accountId accountid of user
     * @param grpId grouppId of user
     * @param rptId ID of report
     * This function returns Map with all users of acctId
     * and grpId having rptId.
     * @return Map with all users of acctId and grpId having rptId.
     */
    public Map getAllUsers(String acctId, String grpId, String rptId)
            throws DataNotFoundException {
        String queryString = SQL_LIST_ALL_USERS_WITH_COMP_FLG_T;
        if (rptId.equals("Ind")) {
            queryString = SQL_LIST_ALL_USERS;
        }
        final Map usrList = new HashMap();
        Object[] params = new Object[]{acctId, grpId};
        getJdbcTemplate().query(queryString, params, new RowCallbackHandler() {
            public void processRow(ResultSet rs) {
                try {
                    String usrId = rs.getString("usr_id");
                    String usrName = rs.getString("name");
                    usrList.put(usrId, usrName);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        return usrList;
    }

    /**
     * @param accountId accountid of user
     * @param sessionId sessionid of user
     * This function returns no of times user, with this
     * accountId & sessionId, changed his answers.
     * @return no of times user, with this accountId & sessionId, changed his
     *         answers
     */
    public int getChangeInAnswers(String acctID, String sesID)
            throws DataNotFoundException {
        String query = SQL_NO_OF_CHANGES;
        Object[] params = new Object[]{acctID, sesID};
        int change = getJdbcTemplate().queryForInt(query, params);
        return change;
    }

    /**
     * @param accountId accountid of user
     * @param sessionId sessionid of user
     * This function returns no of times duration of an assessment expired.
     * @return no of times duration of an assessment expired.
     */
    public int getNoOfExpirations(String acctID, String sesID)
            throws DataNotFoundException {
        String query = SQL_TIMES_EXPIRED;
        Object[] params = new Object[]{acctID, sesID};
        int noOfTimesExpired = getJdbcTemplate().queryForInt(query, params);
        return noOfTimesExpired;

    }

    /**
     * @param
     * @param acctId accountid of user
     * @param usrId userid of user
     * This function returns grpId corresponding to acctId and usrId.
     * @return grpId corresponding to acctId and usrId
     * @throws DataNotFoundException
     */
    public String getGrpId(String acctId, String usrId)
            throws DataNotFoundException {
        String query = SQL_GRP_ID;
        Object[] params = new Object[]{acctId, usrId};
        String grpId = (String) getJdbcTemplate().queryForObject(query, params,
                String.class);
        return grpId;
    }

    /**
     * @param acctId accountid of company
     * This function returns company name corresponding to acctId.
     * @return company name corresponding to acctId
     * @throws DataNotFoundException
     */
    public String getCompName(String acctId) throws DataNotFoundException {
        String query = SQL_COMP_NAME;
        Object[] params = new Object[]{acctId};
        String compName = (String) getJdbcTemplate().queryForObject(query,
                params, StringBuffer.class);
        return compName;
    }
}