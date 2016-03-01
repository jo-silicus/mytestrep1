/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : sharmrahu
 * @date : Aug 2, 2006
 * @version:
 * @history class responsible to get all group related data from the user, to be
 *          used in group administeration(add/edit/view) *
 */

package com.mgmtassessment.execmap.webapp.main.group.form;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.business.model.GroupAccountModel;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapForm;

/**
 * class responsible to get all group related data from the user, to be used in
 * group administeration(add/edit/view).
 * 
 * @author sharmrahu
 */
public class GroupAccountForm extends ExecmapForm implements Serializable {

    /**
     * GroupID of a perticular group.
     */
    private String groupID;

    /**
     * GroupInformation related to a perticular group.
     */
    private String groupInformation;

    /**
     * Status of the group.
     */
    private String groupStatus;

    /**
     * Manager's first name.
     */
    private String groupManagerFirstName;

    /**
     * Manager's last name.
     */
    private String groupManagerLastName;

    /**
     * Manager's userID.
     */
    private String groupManagerUserID;

    /**
     * Manager's Password.
     */
    private String groupManagerPassword;

    /**
     * Manager's RetypePassword.
     */
    private String groupManagerRetypePassword;

    /**
     * Manager's Email.
     */
    private String groupManagerEmail;

    /**
     * Manager's reminder pharse.
     */
    private String groupManagerReminderPhrase;

    /**
     * AccountId of all the groups.
     */
    private String companyAccountID;

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
     * @return Returns the groupID.
     */
    public String getGroupID() {
        return groupID;
    }

    /**
     * @param groupID
     *            The groupID to set.
     */
    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    /**
     * @return Returns the groupInformation.
     */
    public String getGroupInformation() {
        return groupInformation;
    }

    /**
     * @param groupInformation
     *            The groupInformation to set.
     */
    public void setGroupInformation(String groupInformation) {
        this.groupInformation = groupInformation;
    }

    /**
     * @return Returns the groupManagerEmail.
     */
    public String getGroupManagerEmail() {
        return groupManagerEmail;
    }

    /**
     * @param groupManagerEmail
     *            The groupManagerEmail to set.
     */
    public void setGroupManagerEmail(String groupManagerEmail) {
        this.groupManagerEmail = groupManagerEmail;
    }

    /**
     * @return Returns the groupManagerPassword.
     */
    public String getGroupManagerPassword() {
        return groupManagerPassword;
    }

    /**
     * @param groupManagerPassword
     *            The groupManagerPassword to set.
     */
    public void setGroupManagerPassword(String groupManagerPassword) {
        this.groupManagerPassword = groupManagerPassword;
    }

    /**
     * @return Returns the groupManagerUserID.
     */
    public String getGroupManagerUserID() {
        return groupManagerUserID;
    }

    /**
     * @param groupManagerUserID
     *            The groupManagerUserID to set.
     */
    public void setGroupManagerUserID(String groupManagerUserID) {
        this.groupManagerUserID = groupManagerUserID;
    }

    /**
     * @return Returns the groupReminderPhrase.
     */
    public String getGroupReminderPhrase() {
        return groupManagerReminderPhrase;
    }

    /**
     * @param groupReminderPhrase
     *            The groupReminderPhrase to set.
     */
    public void setGroupReminderPhrase(String groupReminderPhrase) {
        this.groupManagerReminderPhrase = groupReminderPhrase;
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
     * This method resets the form values
     * 
     * @param ActionMapping
     * @param HttpServletRequest
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {

        groupID = null;
        groupInformation = null;
        groupStatus = null;
        groupManagerFirstName = null;
        groupManagerLastName = null;
        groupManagerUserID = null;
        groupManagerEmail = null;
        groupManagerReminderPhrase = null;

        super.reset(mapping, request);
    }

    /**
     * This method populates the form with the required values from the model
     * object
     * 
     * @param groupAccountModel
     */
    public void populateForm(GroupAccountModel groupAccountModel) {

        groupID = groupAccountModel.getUserGroupID();
        groupInformation = groupAccountModel.getGroupInfo();
        groupStatus = groupAccountModel.getGroupStatus();
        groupManagerFirstName = groupAccountModel.getUserFirstName();
        groupManagerLastName = groupAccountModel.getUserLastName();
        groupManagerUserID = groupAccountModel.getUserID();
        groupManagerEmail = groupAccountModel.getUserEmail();
        groupManagerReminderPhrase = groupAccountModel.getUserReminderPhrase();
        groupManagerPassword = groupAccountModel.getUserPassword();
        groupManagerRetypePassword = groupAccountModel.getUserPassword();
        companyAccountID = groupAccountModel.getCompanyAccountID();
    }

    /**
     * @return Returns the groupManagerReminderPhrase.
     */
    public String getGroupManagerReminderPhrase() {
        return groupManagerReminderPhrase;
    }

    /**
     * @param groupManagerReminderPhrase
     *            The groupManagerReminderPhrase to set.
     */
    public void setGroupManagerReminderPhrase(String groupManagerReminderPhrase) {
        this.groupManagerReminderPhrase = groupManagerReminderPhrase;
    }

    /**
     * @return Returns the groupManagerFirstName.
     */
    public String getGroupManagerFirstName() {
        return groupManagerFirstName;
    }

    /**
     * @param groupManagerFirstName
     *            The groupManagerFirstName to set.
     */
    public void setGroupManagerFirstName(String groupManagerFirstName) {
        this.groupManagerFirstName = groupManagerFirstName;
    }

    /**
     * @return Returns the groupManagerLastName.
     */
    public String getGroupManagerLastName() {
        return groupManagerLastName;
    }

    /**
     * @param groupManagerLastName
     *            The groupManagerLastName to set.
     */
    public void setGroupManagerLastName(String groupManagerLastName) {
        this.groupManagerLastName = groupManagerLastName;
    }

    /**
     * @return Returns the groupManagerRetypePassword.
     */
    public String getGroupManagerRetypePassword() {
        return groupManagerRetypePassword;
    }

    /**
     * @param groupManagerRetypePassword
     *            The groupManagerRetypePassword to set.
     */
    public void setGroupManagerRetypePassword(String groupManagerRetypePassword) {
        this.groupManagerRetypePassword = groupManagerRetypePassword;
    }

}
