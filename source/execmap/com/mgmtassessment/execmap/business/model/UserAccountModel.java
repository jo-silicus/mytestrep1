/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : sharmrahu
 * @date : Aug 11, 2006
 * @version:
 * @history Class representing the model object for user save/update /retrive
 *          operations.
 */

package com.mgmtassessment.execmap.business.model;

import com.mgmtassessment.execmap.common.framework.business.AbstractModel;

/**
 * Class representing the model object for user save/update /retrive operations.
 *
 * @author sharmrahu
 */

public class UserAccountModel extends AbstractModel {
    /**
     * accountID of the user.
     */
    private String userCompanyAccountID;

    /**
     * groupID of the user.
     */

    private String userGroupID;

    /**
     * password of the user.
     */

    private String userPassword;

    /**
     * ID of the user.
     */

    private String userID;

    /**
     * status of the user.
     */

    private String userStatus;

    /**
     * first name of the user.
     */

    private String userFirstName;

    /**
     * last name of the user.
     */

    private String userLastName;

    /**
     * email id of the user.
     */

    private String userEmail;

    /**
     * any notes.
     */

    private String userNotes;

    /**
     * roleID of the user.
     */
    private String userRoleID;

    /**
     * Start flag for the user.
     */
    private String userStartFlag;

    /**
     * Reminder phrase of the user.
     */

    private String userReminderPhrase;

    /**
     * user locked status.
     */
    private String userAccountLockedStatus;

    /**
     * @return Returns the userCompanyAccountID.
     */
    public String getUserCompanyAccountID() {
        return userCompanyAccountID;
    }

    /**
     * @param userCompanyAccountID
     *            The userCompanyAccountID to set.
     */
    public void setUserCompanyAccountID(String userCompanyAccountID) {
        this.userCompanyAccountID = userCompanyAccountID;
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
     * @return Returns the userFirestName.
     */
    public String getUserFirstName() {
        return userFirstName;
    }

    /**
     * @param userFirestName
     *            The userFirestName to set.
     */
    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
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
     * @return Returns the userNotes.
     */
    public String getUserNotes() {
        return userNotes;
    }

    /**
     * @param userNotes
     *            The userNotes to set.
     */
    public void setUserNotes(String userNotes) {
        this.userNotes = userNotes;
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
     * @return Returns the userRoleID.
     */
    public String getUserRoleID() {
        return userRoleID;
    }

    /**
     * @param userRoleID
     *            The userRoleID to set.
     */
    public void setUserRoleID(String userRoleID) {
        this.userRoleID = userRoleID;
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
