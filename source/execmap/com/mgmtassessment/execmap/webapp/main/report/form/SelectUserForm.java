/**
 *  @Copyright Management Assessment Partners (MAP) AG
 *  All Rights Reserved.
 *
 *  @author : singhrau
 *  @date   : Aug 17, 2006
 *  @version:
 *
 *  @history
 *  Description         Reference       Name        Date
 *
 */

package com.mgmtassessment.execmap.webapp.main.report.form;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import com.mgmtassessment.execmap.common.framework.webapp.ExecmapForm;

/**
 * Action form for drop downs in user selection page.
 */

public class SelectUserForm extends ExecmapForm {
    /**
     * AccountId of company.
     */
    private String acctId = null;
    /**
     * Group ID.
     */
    private String grpId = null;
    /**
     * User ID.
     */
    private String usrId = null;
    /**
     * boolean variable checks whether
     * drop down for compnay should be displayed or not.
     */
    private boolean compDropDown = false;
    /**
     * boolean variable checks whether
     * drop down for group should be displayed or not.
     */
    private boolean grpDropDown = false;
    /**
     * List of companies.
     */
    private SortedMap compList = new TreeMap();
    /**
     * List of groups pertaining to accountID.
     */
    private SortedSet grpList = new TreeSet();
    /**
     * List of users pertaining to accountID and groupID.
     */
    private Map usrList = new HashMap();
    /**
     * boolean variable checks whether
     * drop down for users should be displayed or not.
     */
    private String usrListFlag = null;

    /**
     * @return Returns the usrListFlag.
     */
    public String getUsrListFlag() {
        return usrListFlag;
    }

    /**
     * @param usrListFlag The usrListFlag to set.
     */
    public void setUsrListFlag(String usrListFlag) {
        this.usrListFlag = usrListFlag;
    }

    /**
     * @return Returns the usrId.
     */
    public String getUsrId() {
        return usrId;
    }

    /**
     * @param usrId The usrId to set.
     */
    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    /**
     * @return Returns the usrList.
     */
    public Map getUsrList() {
        return usrList;
    }

    /**
     * @param usrList The usrList to set.
     */
    public void setUsrList(Map usrList) {
        this.usrList = usrList;
    }


    /**
     * @return Returns the compList.
     */
    public SortedMap getCompList() {
        return compList;
    }

    /**
     * @param compList The compList to set.
     */
    public void setCompList(SortedMap compList) {
        this.compList = compList;
    }

    /**
     * @return Returns the grpList.
     */
    public SortedSet getGrpList() {
        return grpList;
    }

    /**
     * @param grpList The grpList to set.
     */
    public void setGrpList(SortedSet grpList) {
        this.grpList = grpList;
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
     * @return Returns the compDropDown.
     */
    public boolean isCompDropDown() {
        return compDropDown;
    }

    /**
     * @param compDropDown The compDropDown to set.
     */
    public void setCompDropDown(boolean compDropDown) {
        this.compDropDown = compDropDown;
    }

    /**
     * @return Returns the grpDropDown.
     */
    public boolean isGrpDropDown() {
        return grpDropDown;
    }

    /**
     * @param grpDropDown The grpDropDown to set.
     */
    public void setGrpDropDown(boolean grpDropDown) {
        this.grpDropDown = grpDropDown;
    }
}
