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

package com.mgmtassessment.execmap.business.impl.mail;

import java.util.HashMap;
import java.util.ResourceBundle;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.mgmtassessment.execmap.business.api.mail.MailWriterFacade;
import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.business.AbstractFacadeImpl;
import com.mgmtassessment.execmap.common.util.TranslateHelper;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.common.util.webapp.UserLoginInfo;

/**
 * MailWriterFacadeImpl provides method for sending email
 * in various modules of application.
 *
 */

public class MailWriterFacadeImpl extends AbstractFacadeImpl implements
        MailWriterFacade {

    
    TranslateHelper langHelper;
     
    /**
     * Initialize the mailSender object in order to initialize the mailSender
     * bean.
     */
    private MailSender        mailSender;

    /**
     * Initialize the SimpleMailMessage object in order to initialize the
     * message bean.
     */
    private SimpleMailMessage message;

    /**
     *
     * @param mailSender
     */
    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     *
     * @param message
     */
    public void setMessage(SimpleMailMessage message) {
        this.message = message;
    }

    /**
     * This method send mail to administrator when company is added.
     *
     * @param to
     * @param acctid
     * @param name
     * @param userid
     * @param password
     */
    public void sendAddCompanyMail(String to, String acctid, String name,
            String userid, String password) {

        
        String msg = langHelper.getMailMessage("addcompany.mail.format");
        msg = msg.replace("$acctid",acctid);
        msg = msg.replace("$userid",userid);
        msg = msg.replace("$password",password);
        msg = msg.replace("$name",name);
        
        
        SimpleMailMessage mailMsg = new SimpleMailMessage(this.message);
        mailMsg.setTo(to);
        mailMsg.setText(msg);
        mailMsg.setSubject("Welcome to ExecMap");
        mailSender.send(mailMsg);
    }

    /**
     * This method send mail to administrator when company is edited.
     *
     * @param to
     * @param acctid
     * @param name
     * @param userid
     * @param password
     */
    public void sendEditCompanyMail(String to, String acctid, String name,
            String userid, String password) {

        String msg = langHelper.getMailMessage("editcompany.mail.format");
        msg = msg.replace("$acctid",acctid);
        msg = msg.replace("$userid",userid);
        msg = msg.replace("$password",password);
        msg = msg.replace("$name",name);

        SimpleMailMessage mailMsg = new SimpleMailMessage(this.message);
        mailMsg.setTo(to);
        mailMsg.setText(msg);
        mailMsg.setSubject("ExecMap Account Information Updated");
        mailSender.send(mailMsg);

    }

    /**
     * This method send mail to administrator when group is added.
     *
     * @param to
     * @param acctid
     * @param name
     * @param userid
     * @param password
     * @param coname
     * @param supName
     * @param supEmail
     */
    public void sendAddGroupMail(String to, String acctid, String name,
            String userid, String password, String coname, String supName,
            String supEmail) {
        
        String msg = langHelper.getMailMessage("addgroup.mail.format");
        msg = msg.replace("$acctid",acctid);
        msg = msg.replace("$userid",userid);
        msg = msg.replace("$password",password);
        msg = msg.replace("$name",name);
        msg = msg.replace("$coname",coname);
        msg = msg.replace("$supName",supName);
        msg = msg.replace("$supEmail",supEmail);

        SimpleMailMessage mailMsg = new SimpleMailMessage(this.message);
        mailMsg.setTo(to);
        mailMsg.setText(msg);
        mailMsg.setSubject("Welcome to ExecMap-Group Account Information");
        mailSender.send(mailMsg);

    }

    /**
     * This method send mail to administrator when group is edited.
     *
     * @param to
     * @param acctid
     * @param name
     * @param userid
     * @param password
     */
    public void sendEditGroupMail(String to, String acctid, String name,
            String userid, String password) {

        String msg = langHelper.getMailMessage("editgroup.mail.format");
        msg = msg.replace("$acctid",acctid);
        msg = msg.replace("$userid",userid);
        msg = msg.replace("$password",password);
        msg = msg.replace("$name",name);


        SimpleMailMessage mailMsg = new SimpleMailMessage(this.message);
        mailMsg.setTo(to);
        mailMsg.setText(msg);
        mailMsg.setSubject("ExecMap Group Account Information Updated");
        mailSender.send(mailMsg);

    }

    /**
     * This method send mail to user  when user is added.
     *
     * @param to
     * @param acctid
     * @param name
     * @param userid
     * @param password
     * @param coName
     * @param grpemail
     * @param grpName
     */
    public void sendAddCoUserMail(String to, String acctid, String name,
            String userid, String password, String coName, String grpemail,
            String grpName) {

        String msg = langHelper.getMailMessage("addcompanyuser.mail.format");
        msg = msg.replace("$acctid",acctid);
        msg = msg.replace("$userid",userid);
        msg = msg.replace("$password",password);
        msg = msg.replace("$name",name);
        msg = msg.replace("$coName",coName);
        msg = msg.replace("$grpemail",grpemail);
        msg = msg.replace("$grpName",grpName);

        SimpleMailMessage mailMsg = new SimpleMailMessage(this.message);
        mailMsg.setTo(to);
        mailMsg.setText(msg);
        mailMsg.setSubject("Welcome to ExecMap");
        mailSender.send(mailMsg);
    }

    /**
     * This method send the mail to user who forget their password.
     *
     * @param sEMailAddress
     * @param sPassword
     */
    public void sendPasswordMail(String sEMailAddress, String sPassword) {

        String msg = langHelper.getMailMessage("password.reminder.mail.format");
        msg = msg.replace("$sPassword",sPassword);

        SimpleMailMessage mailMsg = new SimpleMailMessage(this.message);
        mailMsg.setTo(sEMailAddress);
        mailMsg.setText(msg);
        mailMsg.setSubject("Password Reminder");
        mailSender.send(mailMsg);
    }

    /**
     * This method send the mail to admin regarding securtiy breach.
     * @param userLoginInfo to retrieve accountId, userId and grpId
     * @param sEMailAddress
     * @param sPassword
     * @return
     */
    public void sendSecurityBreachMail(String sEMailAddress, UserLoginInfo
                                                    userLoginInfo, String url) {

        String msg = langHelper.getMailMessage("security.breach.mail.format");
        msg = msg.replace("$acctId", userLoginInfo.getAccountId());
        msg = msg.replace("$userId", userLoginInfo.getLogonUserId());
        msg = msg.replace("$groupId", userLoginInfo.getGroupId());
        msg = msg.replace("$url", url);
        SimpleMailMessage mailMsg = new SimpleMailMessage(this.message);
        mailMsg.setTo(sEMailAddress);
        mailMsg.setText(msg);
        mailMsg.setSubject("Regarding Security Breach");
        mailSender.send(mailMsg);
    }

    /**
     * This method returns the global system administrator's
     * email id.
     * @return emailid
     */
    public String getSystemAdminEmailId(){
    	return langHelper.getMailMessage
    	             ("global.system.administrator.email");
    	 
    }
    
    /**
     * @param langHelper The langHelper to set.
     */
    public void setLangHelper(TranslateHelper langHelper) {
        this.langHelper = langHelper;
    }
}