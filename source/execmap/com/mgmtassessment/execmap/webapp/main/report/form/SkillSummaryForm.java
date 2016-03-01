/**
 *  @Copyright Management Assessment Partners (MAP) AG
 *  All Rights Reserved.
 *
 *  @author : goenkani
 *  @date   : Jul 11, 2006
 *  @version:
 *  @history
 *  This class is used to populate the jsp with scores in
 *  all tests attended by a user.
 */
package com.mgmtassessment.execmap.webapp.main.report.form;

import com.mgmtassessment.execmap.business.model.SkillSummaryReportModel;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapForm;


/**
 * Action Form for Skill Summary Report.
 *
 */
public class SkillSummaryForm extends ExecmapForm {
    /**
     * Model for Skill Summary Report.
     */
    private SkillSummaryReportModel skillSummaryReportModel;
    /**
     * skills which user has selected to view the score.
     */
    private String[] skills;
    /**
     * all skills are appended to form a string.
     */
    private String url;
    /**
     * accountId.
     */
    private String acctId;
    /**
     * groupId.
     */
    private String grpId;
    /**
     * @return Returns the acctId.
     */
    public String getAcctId() {
        return acctId;
    }

    /**
     * @param acctId The acctId to set.
     */
    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    /**
     * @return Returns the grpId.
     */
    public String getGrpId() {
        return grpId;
    }

    /**
     * @param grpId The grpId to set.
     */
    public void setGrpId(String grpId) {
        this.grpId = grpId;
    }

    /**
     * @return Returns the url.
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url The url to set.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return Returns the skills.
     */
    public String[] getSkills() {
        return skills;
    }

    /**
     * @param skills The skills to set.
     */
    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    /**
     * @return Returns the skillSummaryReportModel.
     */
    public SkillSummaryReportModel getSkillSummaryReportModel() {
        return skillSummaryReportModel;
    }

    /**
     * @param skillSummaryReportModel The skillSummaryReportModel to set.
     */
    public void setSkillSummaryReportModel(
            SkillSummaryReportModel skillSummaryReportModel) {
        this.skillSummaryReportModel = skillSummaryReportModel;
    }
}