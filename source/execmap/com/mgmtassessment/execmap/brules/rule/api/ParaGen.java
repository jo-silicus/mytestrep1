/*
 * Created on Apr 18, 2006 TODO To change the template for this generated file
 * go to Window - Preferences - Java - Code Style - Code Templates
 */
package com.mgmtassessment.execmap.brules.rule.api;

import com.mgmtassessment.execmap.business.model.ReportModel;
import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;

/**
 * @author singhrau
 * This class generates html code for reports.
 */
public interface ParaGen {
    /**
     * @param acctID of the user
     * @param sesID of the user
     * @param reportModel of the user
     * @param imgPath from where image to be picked
     * @throws DataNotFoundException when query does not return any thing
     * @return the complete report as a string
     */
    public String getReport(String acctID, String sesID,
            ReportModel reportModel, String imgPath)
            throws DataNotFoundException;
}