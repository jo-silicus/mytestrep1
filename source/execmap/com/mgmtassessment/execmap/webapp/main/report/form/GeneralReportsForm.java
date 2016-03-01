/**
 *  @Copyright Management Assessment Partners (MAP) AG.
 *  All Rights Reserved.
 *
 *  @author : kumarra
 *  @date   : Aug 2, 2006
 *  @version:
 *
 *  @history
 *  Description         Reference       Name        Date
 *
 */

package com.mgmtassessment.execmap.webapp.main.report.form;

import com.mgmtassessment.execmap.common.framework.webapp.ExecmapForm;


/**
 * This class is a placeholder for form values.GeneralReportsForm represents
 * getter and setter method for all the values that are going to present on
 * JSP.
 *
 */
public class GeneralReportsForm extends ExecmapForm {

    /**
     * String for storing name of the html report created.
     */
    private String fileName = null;
    /**
     * report id for each reports.
     */
    private String rptId = null;
   /**
    * @return Returns the fileNmae.
    */
    public String getFileName() {
        return fileName;
    }
    /**
     * @param fileName FileName to set.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    /**
     * @return Returns the rptId.
     */
    public String getRptId() {
        return rptId;
    }
    /**
     * @param rptId The rptId to set.
     */
    public void setRptId(String rptId) {
        this.rptId = rptId;
    }
}