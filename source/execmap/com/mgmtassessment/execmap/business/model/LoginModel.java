/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @author : AhmedZia 
 *  @date   : Aug 21, 2006
 *  @version: 
 * 
 *  @history
 *  Description         Reference       Name        Date
 *               
 */

package com.mgmtassessment.execmap.business.model;

import com.mgmtassessment.execmap.common.framework.business.AbstractModel;

/**
 * TODO Write java docs comments for this type
 * 
 */

public class LoginModel extends AbstractModel {
    
    
    public String acctid;

    public String userid;

    public String password;

    public String newPassword;
    
    public String email;
    
    public String reminderPhrase;
    
    /**
     * groupId of the user that logs in
     */
    
    public String groupId ;
    
    /**
     * roleId of the user that logs in
     */
    
    public String roleId ;

    /**
     * @return Returns the groupId.
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * @param groupId The groupId to set.
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * @return Returns the roleId.
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * @param roleId The roleId to set.
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * @return Returns the email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email The email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return Returns the reminderPhrase.
     */
    public String getReminderPhrase() {
        return reminderPhrase;
    }

    /**
     * @param reminderPhrase The reminderPhrase to set.
     */
    public void setReminderPhrase(String reminderPhrase) {
        this.reminderPhrase = reminderPhrase;
    }

    /**
     * @return Returns the acctid.
     */
    public String getAcctid() {
        return acctid;
    }

    /**
     * @param acctid The acctid to set.
     */
    public void setAcctid(String acctid) {
        this.acctid = acctid;
    }

    /**
     * @return Returns the newPassword.
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * @param newPassword The newPassword to set.
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    /**
     * @return Returns the password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return Returns the userid.
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid The userid to set.
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

}
