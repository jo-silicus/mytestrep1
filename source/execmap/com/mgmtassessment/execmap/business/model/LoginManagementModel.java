/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : singhrau
 * @date : Sep 14, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.business.model;

import com.mgmtassessment.execmap.common.framework.business.AbstractModel;

/**
 * This is a model class to display data on JSP.
 */

public class LoginManagementModel extends AbstractModel {
    /**
     * to store acctId of the locked user to be displayed on jsp.
     */
    private String acctId   = null;
    /**
     * to store grpId of the locked user to be displayed on jsp.
     */
    private String grpId    = null;
    /**
     * to store usrId of the locked user to be displayed on jsp.
     */
    private String usrId    = null;
    /**
     * to store userName of the locked user to be displayed on jsp.
     */
    private String userName = null;

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
     * @return Returns the userName.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName The userName to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
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

}
