/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : sharmrahu
 * @date : Aug 11, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.webapp.main.user.form;

import java.io.Serializable;

import org.apache.struts.upload.FormFile;

import com.mgmtassessment.execmap.business.model.UserAccountModel;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapForm;

/**
 * class responsible to get all new-user related data from the user, to be used
 * in user administeration(add/edit/view).
 */

public class UserAccountForm extends ExecmapForm implements Serializable {
    /**
     * AccountID of the User.
     */
    private String   userCompanyAccountID;

    /**
     * groupID of the user.
     */
    private String   userGroupID;

    /**
     * EmailId of the user.
     */
    private String   userEmail;

    /**
     * userID of the user.
     */
    private String   userID;

    /**
     * password of the user.
     */
    private String   userPassword;

    /**
     * retype-password of the user.
     */
    private String   userRetypePassword;

    /**
     * reminder phrase of the user.
     */
    private String   userReminderPhrase;

    /**
     * user's first name.
     */
    private String   userFirstName;

    /**
     * user's last name.
     */
    private String   userLastName;

    /**
     * status of the user.
     */
    private String   userStatus;

    /**
     * user notes.
     */
    private String   userNotes;

    /**
     * The file that the user has uploaded
     */
    private FormFile file;

    /**
     * @return Returns the file.
     */
    public FormFile getFile() {
        return file;
    }

    /**
     * @param file
     *            The file to set.
     */
    public void setFile(FormFile file) {
        this.file = file;
    }

    /**
     * @return Returns the userFirestName.
     */
    public String getUserFirstName() {
        return userFirstName;
    }

    /**
     * @param userFirstName
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
     * @return Returns the userlastName.
     */
    public String getUserLastName() {
        return userLastName;
    }

    /**
     * @param userlastName
     *            The userlastName to set.
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
     * This method populates the form with the required values from the model
     * object
     * 
     * @param userAccountModel
     */
    public void populateForm(UserAccountModel userAccountModel) {
        userGroupID = userAccountModel.getUserGroupID();
        userEmail = userAccountModel.getUserEmail();
        userFirstName = userAccountModel.getUserFirstName();
        userLastName = userAccountModel.getUserLastName();
        userID = userAccountModel.getUserID();
        userNotes = userAccountModel.getUserNotes();
        userPassword = userAccountModel.getUserPassword();
        userRetypePassword = userAccountModel.getUserPassword();
        userReminderPhrase = userAccountModel.getUserReminderPhrase();
        userStatus = userAccountModel.getUserStatus();
        userCompanyAccountID = userAccountModel.getUserCompanyAccountID();
    }

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
     * @return Returns the userRetypePassword.
     */
    public String getUserRetypePassword() {
        return userRetypePassword;
    }

    /**
     * @param userRetypePassword
     *            The userRetypePassword to set.
     */
    public void setUserRetypePassword(String userRetyprPassword) {
        this.userRetypePassword = userRetyprPassword;
    }
}
