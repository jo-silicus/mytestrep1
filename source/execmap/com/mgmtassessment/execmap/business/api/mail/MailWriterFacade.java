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

package com.mgmtassessment.execmap.business.api.mail;

import com.mgmtassessment.execmap.common.framework.business.AbstractFacade;
import com.mgmtassessment.execmap.common.util.webapp.UserLoginInfo;

/**
 * This class provides interface for sending emails during the application.
 *
 */

public interface MailWriterFacade extends AbstractFacade {

    /**
     *This method send mail to administrator when company is added.
     *
     * @param to
     * @param acctid
     * @param name
     * @param userid
     * @param password
     */
    public void sendAddCompanyMail(String to, String acctid, String name,
            String userid, String password);

    /**
     *This method send mail to administrator when company is edited.
     *
     * @param to
     * @param acctid
     * @param name
     * @param userid
     * @param password
     */
    public void sendEditCompanyMail(String to, String acctid, String name,
            String userid, String password);

    /**
     *This method send mail to administrator when group is added.
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
            String supEmail);

    /**
     *This method send mail to administrator when group is edited.
     * @param to
     * @param acctid
     * @param name
     * @param userid
     * @param password
     */
    public void sendEditGroupMail(String to, String acctid, String name,
            String userid, String password);

    /**
     *This method send mail to user when user is added.
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
            String grpName);

    /**
     *This method send mail to when user when user forgets the password.
     *
     * @param sEMailAddress
     * @param sPassword
     */
    public void sendPasswordMail(String sEMailAddress, String sPassword);

    /**
     * This method send the mail to admin regarding securtiy breach.
     * @param userLoginInfo
     * @param sEMailAddress
     * @param sPassword
     * @return
     */
    public void sendSecurityBreachMail(String sEMailAddress, UserLoginInfo userLoginInfo, String url);
    
    /**
     * This method returns the global system administrator's
     * email id.
     * @return emailid
     */
    public String getSystemAdminEmailId();
}
