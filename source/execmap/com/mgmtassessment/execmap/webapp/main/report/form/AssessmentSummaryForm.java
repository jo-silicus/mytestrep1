package com.mgmtassessment.execmap.webapp.main.report.form;

import java.util.ArrayList;
import java.util.List;

import com.mgmtassessment.execmap.common.framework.webapp.ExecmapForm;

/**
 * Action Form used to populate jsp for Assesment Summary.
 */

public class AssessmentSummaryForm extends ExecmapForm {

    /**
     * String for storing account Id.
     */
    private String acctId                   = null;

    /**
     * String for storing Grp Id.
     */
    private String grpId                    = null;

    /**
     * String to check whether results are available or not.
     */
    private String check                    = null;

    /**
     * List for storing details of users in a group.
     */
    private List   assessmentSummaryDetails = new ArrayList();

    /**
     * @return Returns the acctId.
     */
    public String getAcctId() {
        return acctId;
    }

    /**
     * @param acctId
     *            The acctId to set.
     */
    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    /**
     * @return Returns the assessmentSummaryDetails.
     */
    public List getAssessmentSummaryDetails() {
        return assessmentSummaryDetails;
    }

    /**
     * @param assessmentSummaryDetails
     *            The assessmentSummaryDetails to set.
     */
    public void setAssessmentSummaryDetails(List assessmentSummaryDetails) {
        this.assessmentSummaryDetails = assessmentSummaryDetails;
    }

    /**
     * @return Returns the grpId.
     */
    public String getGrpId() {
        return grpId;
    }

    /**
     * @param grpId
     *            The grpId to set.
     */
    public void setGrpId(String grpId) {
        this.grpId = grpId;
    }

    /**
     * @return Returns the check.
     */
    public String getCheck() {
        return check;
    }

    /**
     * @param check
     *            The check to set.
     */
    public void setCheck(String check) {
        this.check = check;
    }
}