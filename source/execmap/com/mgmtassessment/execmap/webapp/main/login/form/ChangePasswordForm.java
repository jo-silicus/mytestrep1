/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : AhmedZia
 * @date : Sep 13, 2006
 * @version:
 *
 * @history Description Reference Name Date
 *
 */

package com.mgmtassessment.execmap.webapp.main.login.form;

import com.mgmtassessment.execmap.common.framework.webapp.ExecmapForm;

/**
 * ChangePassword ActionForm.
 *
 */

public class ChangePasswordForm extends ExecmapForm {

    /** acctId */
    private String acctid;

    /** userid */
    private String userid;

    /** password */
    private String password;

    /** New Password */
    private String newPassword;

    /** retypePassword */
    private String retypePassword;

    /**
     * @return Returns the acctid.
     */
    public String getAcctid() {
        return acctid;
    }

    /**
     * @param acctid
     *            The acctid to set.
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
     * @param newPassword
     *            The newPassword to set.
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
     * @param password
     *            The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return Returns the retypePassword.
     */
    public String getRetypePassword() {
        return retypePassword;
    }

    /**
     * @param retypePassword
     *            The retypePassword to set.
     */
    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }

    /**
     * @return Returns the userid.
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid
     *            The userid to set.
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

}
