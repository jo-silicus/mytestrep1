/**
 *  @Copyright Management Assessment Partners (MAP) AG
 *  All Rights Reserved.
 *
 *  @author : kapilpra
 *  @date   : Aug 30, 2006
 *  @version:
 *
 *  @history
 *  Description         Reference       Name        Date
 *
 */

package com.mgmtassessment.execmap.webapp.main.report.form;

import com.mgmtassessment.execmap.common.framework.webapp.ExecmapForm;

/**
 * Form which contain accountId and GrouId.
 */

public class SkillSelectionForm extends ExecmapForm {

    /**
     * accountId.
     */
    private String acctID;
    /**
     * GroupId.
     */
    private String groupID;
    /**
     * @return Returns the acctID.
     */
    public String getAcctID() {
        return acctID;
    }
    /**
     * @param acctID The acctID to set.
     */
    public void setAcctID(String acctID) {
        this.acctID = acctID;
    }
    /**
     * @return Returns the groupID.
     */
    public String getGroupID() {
        return groupID;
    }
    /**
     * @param groupID The groupID to set.
     */
    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }
}
