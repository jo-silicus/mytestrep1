/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : singhrau
 * @date : Aug 4, 2006
 * @version:
 *
 * @history Description Reference Name Date
 *
 */

package com.mgmtassessment.execmap.business.model;

import com.mgmtassessment.execmap.common.framework.business.AbstractModel;

/**
 * Model class for reports contains
 * report ID of various reports.
 * @author singhrau
 *
 */
public class ReportModel
        extends AbstractModel {
/**
 * String to store rptId.
 */
    private String rptId = null;

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