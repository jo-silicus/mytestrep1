/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : AhmedZia
 * @date : Aug 28, 2006
 * @version:
 *
 * @history Description Reference Name Date
 *
 */

package com.mgmtassessment.execmap.webapp.main.login.form;

import com.mgmtassessment.execmap.common.framework.webapp.ExecmapForm;

/**
 * This class is a placeholder for form values.PasswordReminderForm represents
 * getter and setter method for all the values that are going to present on JSP.
 *
 */

public class PasswordReminderForm extends ExecmapForm {
    
    /** acctId */
    private String acctid;

    /** User Id */
    private String userid;

    /** Email */
    private String email;

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
     * @return Returns the email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            The email to set.
     */
    public void setEmail(String email) {
        this.email = email;
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
