/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @author : TODO 
 *  @date   : Jul 21, 2006
 *  @version: 
 * 
 *  @history
 *  Description         Reference       Name        Date
 *               
 */

package com.mgmtassessment.execmap.business.model;

import java.util.Vector;

import com.mgmtassessment.execmap.common.framework.business.AbstractModel;


/**
 * TODO Write java docs comments for this type
 * 
 */

public class ReportInfo extends AbstractModel{
	
	private String selectedReportType;
    private String fullReport;
    private Vector reportTypes;
	/**
	 * @return Returns the fullReport.
	 */
	public String getFullReport() {
		return fullReport;
	}
	/**
	 * @param fullReport The fullReport to set.
	 */
	public void setFullReport(String fullReport) {
		this.fullReport = fullReport;
	}
	/**
	 * @return Returns the reportTypes.
	 */
	public Vector getReportTypes() {
		return reportTypes;
	}
	/**
	 * @param reportTypes The reportTypes to set.
	 */
	public void setReportTypes(Vector reportTypes) {
		this.reportTypes = reportTypes;
	}
	/**
	 * @return Returns the selectedReportType.
	 */
	public String getSelectedReportType() {
		return selectedReportType;
	}
	/**
	 * @param selectedReportType The selectedReportType to set.
	 */
	public void setSelectedReportType(String selectedReportType) {
		this.selectedReportType = selectedReportType;
	}
}