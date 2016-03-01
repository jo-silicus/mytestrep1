/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : singhrau
 * @date : Aug 30, 2006
 * @version:
 *
 * @history Description Reference Name Date
 *
 */

package com.mgmtassessment.execmap.webapp.main.report.form;

import com.mgmtassessment.execmap.common.framework.webapp.ExecmapForm;

/**
 * Action Form for PDF conversion.
 */

public class PDFConverterForm extends ExecmapForm {

    /**
     * reportId a number assigned to each type
     * of report.
     */
    private String rptId   = null;
    /**
     * repName of pdf file.
     */
    private String repName = null;

    /**
     * @return Returns the repName.
     */
    public String getRepName() {
        return repName;
    }

    /**
     * @param repName
     *            The repName to set.
     */
    public void setRepName(String repName) {
        this.repName = repName;
    }

    /**
     * @return Returns the rptId.
     */
    public String getRptId() {
        return rptId;
    }

    /**
     * @param rptId
     *            The rptId to set.
     */
    public void setRptId(String rptId) {
        this.rptId = rptId;
    }
}