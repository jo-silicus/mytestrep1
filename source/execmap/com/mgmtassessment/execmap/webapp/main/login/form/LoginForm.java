/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : DasAshim
 * @date : Jul 11, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.webapp.main.login.form;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mgmtassessment.execmap.business.api.login.LoginManagerFacade;
import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapForm;

/**
 * This class is a placeholder for form values.LoginForm represents getter and
 * setter method for all the values that are going to present on JSP.
 */

public class LoginForm
        extends ExecmapForm {

    /** acctId */
    private String acctid           = null;

    /** userid */
    private String userid           = null;

    /** password */
    private String password         = null;

    /** New Password */
    private String newPassword;

    /** email */
    private String email;

    /** reminderPhrase */
    private String reminderPhrase;

    /** retypePassword */
    private String retypePassword;

    /** activity role Id */
    private String roleId           = null;

    /** language list */
    private Map    languages        = null;

    /** languaged selected by default or user */
    private String selectedLanguage = null;
    

    


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
    public void setRetypePassword(
            String retypePassword) {
        this.retypePassword = retypePassword;
    }

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
    public void setAcctid(
            String acctid) {
        this.acctid = acctid;
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
    public void setPassword(
            String password) {
        this.password = password;
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
    public void setUserid(
            String userid) {
        this.userid = userid;
    }

    /**
     * Reset the attributes for this form.
     */
    public void reset(
            ActionMapping mapping, HttpServletRequest request) {
        this.acctid = IConstants.BLANK;
        this.userid = IConstants.BLANK;
        this.password = IConstants.BLANK;
        ApplicationContext appContext = WebApplicationContextUtils
                .getWebApplicationContext(this
                        .getServlet().getServletContext());
        LoginManagerFacade loginManagerFacade = (LoginManagerFacade) appContext
                .getBean(IConstants.LOGIN_MANAGER);
        loginManagerFacade
                .setApplicationContext(appContext);

        try {
            languages = loginManagerFacade
                    .getLanguages();
        }
        catch (DataNotFoundException e) {
            // TODO Auto-generated catch block
            e
                    .printStackTrace();
        }
        Locale locale = (Locale) request.getLocale();
        if (locale != null) {
            this.selectedLanguage = locale
                    .getLanguage();
        } else
            this.selectedLanguage = IConstants.BLANK;
       
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
    public void setNewPassword(
            String newPassword) {
        this.newPassword = newPassword;
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
    public void setEmail(
            String email) {
        this.email = email;
    }

    /**
     * @return Returns the reminderPhrase.
     */
    public String getReminderPhrase() {
        return reminderPhrase;
    }

    /**
     * @param reminderPhrase
     *            The reminderPhrase to set.
     */
    public void setReminderPhrase(
            String reminderPhrase) {
        this.reminderPhrase = reminderPhrase;
    }

    /**
     * @return Returns the roleId.
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     *            The roleId to set.
     */
    public void setRoleId(
            String roleId) {
        this.roleId = roleId;
    }

    /**
     * @return Returns the languages.
     */
    public Map getLanguages() {
        return languages;
    }

    /**
     * @param languages
     *            The languages to set.
     */
    public void setLanguages(
            Map languages) {
        this.languages = languages;
    }

    /**
     * @return Returns the selectedLanguage.
     */
    public String getSelectedLanguage() {
        return selectedLanguage;
    }

    /**
     * @param selectedLanguage
     *            The selectedLanguage to set.
     */
    public void setSelectedLanguage(
            String selectedLanguage) {
        this.selectedLanguage = selectedLanguage;
    }

 
   

}
