/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : sharmrahu
 * @date : Aug 2, 2006
 * @version:
 * @historyClass representing the model object for group save/update /retrive
 *               operations.
 */

package com.mgmtassessment.execmap.business.model;

import com.mgmtassessment.execmap.common.framework.business.AbstractModel;

/**
 * Class representing the model object for group save/update /retrive
 * operations.
 *
 * @author sharmrahu
 */

public class GroupAccountModel extends AbstractModel {
    /**
     * accountId of the group.
     */
    private String companyAccountID;

    /**
     * groupId of the Group -- user signifies the of Group Manager.
     */
    private String userGroupID;

    /**
     * any extra info ralated to group.
     */

    private String groupInfo;

    /**
     * userId of the Manager.
     */
    private String userID;

    /**
     * password of the manager.
     */
    private String userPassword;

    /**
     * first name of the manager.
     */
    private String userFirstName;

    /**
     * Last Name of the manager.
     */
    private String userLastName;

    /**
     * RoleId of the manager.
     */
    private String userActivityRoleID;

    /**
     * Email Id of the Manager.
     */
    private String userEmail;

    /**
     * Status of the Manager.
     */
    private String userStatus;

    /**
     * Start Flag of Manager.
     */
    private String userStartFlag;

    /**
     * any other notes that of Manager.
     */
    private String userNotes1;

    /**
     * any other notes that of Manager.
     */
    private String userNotes2;

    /**
     * ReminderPhrase of manager.
     */
    private String userReminderPhrase;

    /**
     * status of Group.
     */
    private String groupStatus;
    /**
     * Account locked status.
     */
    private String userAccountLockedStatus;

    /**
     * @return Returns the companyAccountID.
     */
    public String getCompanyAccountID() {
        return companyAccountID;
    }

    /**
     * @param companyAccountID
     *            The companyAccountID to set.
     */
    public void setCompanyAccountID(String companyAccountID) {
        this.companyAccountID = companyAccountID;
    }

    /**
     * @return Returns the userActivityRoleID.
     */
    public String getUserActivityRoleID() {
        return userActivityRoleID;
    }

    /**
     * @param userActivityRoleID
     *            The userActivityRoleID to set.
     */
    public void setUserActivityRoleID(String userActivityRoleID) {
        this.userActivityRoleID = userActivityRoleID;
    }

    /**
     * @return Returns the userEmail.
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param userEmail
     *            The userEmail to set.
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * @return Returns the userGroupID.
     */
    public String getUserGroupID() {
        return userGroupID;
    }

    /**
     * @param userGroupID
     *            The userGroupID to set.
     */
    public void setUserGroupID(String userGroupID) {
        this.userGroupID = userGroupID;
    }

    /**
     * @return Returns the userID.
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID
     *            The userID to set.
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * @return Returns the userNotes1.
     */
    public String getUserNotes1() {
        return userNotes1;
    }

    /**
     * @param userNotes1
     *            The userNotes1 to set.
     */
    public void setUserNotes1(String userNotes1) {
        this.userNotes1 = userNotes1;
    }

    /**
     * @return Returns the userNotes2.
     */
    public String getUserNotes2() {
        return userNotes2;
    }

    /**
     * @param userNotes2
     *            The userNotes2 to set.
     */
    public void setUserNotes2(String userNotes2) {
        this.userNotes2 = userNotes2;
    }

    /**
     * @return Returns the userPassword.
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword
     *            The userPassword to set.
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * @return Returns the userStartFlag.
     */
    public String getUserStartFlag() {
        return userStartFlag;
    }

    /**
     * @param userStartFlag
     *            The userStartFlag to set.
     */
    public void setUserStartFlag(String userStartFlag) {
        this.userStartFlag = userStartFlag;
    }

    /**
     * @return Returns the userStatus.
     */
    public String getUserStatus() {
        return userStatus;
    }

    /**
     * @param userStatus
     *            The userStatus to set.
     */
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * @return Returns the groupInfo.
     */
    public String getGroupInfo() {
        return groupInfo;
    }

    /**
     * @param groupInfo
     *            The groupInfo to set.
     */
    public void setGroupInfo(String groupInfo) {
        this.groupInfo = groupInfo;
    }

    /**
     * @return Returns the groupStatus.
     */
    public String getGroupStatus() {
        return groupStatus;
    }

    /**
     * @param groupStatus
     *            The groupStatus to set.
     */
    public void setGroupStatus(String groupStatus) {
        this.groupStatus = groupStatus;
    }

    /**
     * @return Returns the userReminderPhrase.
     */
    public String getUserReminderPhrase() {
        return userReminderPhrase;
    }

    /**
     * @param userReminderPhrase
     *            The userReminderPhrase to set.
     */
    public void setUserReminderPhrase(String userReminderPhrase) {
        this.userReminderPhrase = userReminderPhrase;
    }

    /**
     * @return Returns the userFirstName.
     */
    public String getUserFirstName() {
        return userFirstName;
    }

    /**
     * @param userFirstName
     *            The userFirstName to set.
     */
    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    /**
     * @return Returns the userLastName.
     */
    public String getUserLastName() {
        return userLastName;
    }

    /**
     * @param userLastName
     *            The userLastName to set.
     */
    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    /**
     * @return Returns the userAccountLockedStatus.
     */
    public String getUserAccountLockedStatus() {
        return userAccountLockedStatus;
    }

    /**
     * @param userAccountLockedStatus The userAccountLockedStatus to set.
     */
    public void setUserAccountLockedStatus(
            String userAccountLockedStatus) {
        this.userAccountLockedStatus = userAccountLockedStatus;
    }

}
