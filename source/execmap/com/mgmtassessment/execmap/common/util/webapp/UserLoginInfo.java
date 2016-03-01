/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : DasAshim
 * @date : Jul 25, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.common.util.webapp;

import java.io.Serializable;

/**
 * This a helper class which contains, information regarding user loggged in
 * TODO Write java docs comments for this type
 */

public class UserLoginInfo implements Serializable {

    /** Account Id of the User Logged in * */
    private String  accountId;

    /** User Id of the User Logged in * */
    private String  logonUserId;

    /** GroupId to which the User Belongs to * */
    private String  groupId;

    /** Ueer Id within the group * */
    private Byte  reportId;

    /** RoleId associated with user */
    private Byte activityRoleID;
    
    /** The sound enabling or disabling flag*/
    private Character    soundData    = null;

    /**
     * @return Returns the accountId.
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * @param accountId
     *            The accountId to set.
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

     /**
     * @return Returns the groupId.
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * @param groupId
     *            The groupId to set.
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * @return Returns the logonUserId.
     */
    public String getLogonUserId() {
        return logonUserId;
    }

    /**
     * @param logonUserId
     *            The logonUserId to set.
     */
    public void setLogonUserId(String logonUserId) {
        this.logonUserId = logonUserId;
    }

   /**
     * @return Returns the activityRoleID.
     */
    public Byte getActivityRoleID() {
        return activityRoleID;
    }

    /**
     * @param activityRoleID
     *            The activityRoleID to set.
     */
    public void setActivityRoleID(Byte activityRoleID) {
        this.activityRoleID = activityRoleID;
    }

    /**
     * @return Returns the soundData.
     */
    public Character getSoundData() {
        return soundData;
    }

    /**
     * @param soundData The soundData to set.
     */
    public void setSoundData(Character soundData) {
        this.soundData = soundData;
    }

    /**
     * @return Returns the reportId.
     */
    public Byte getReportId() {
        return reportId;
    }

    /**
     * @param reportId The reportId to set.
     */
    public void setReportId(Byte reportId) {
        this.reportId = reportId;
    }
}