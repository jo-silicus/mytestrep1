/**
 *  @Copyright Management Assessment Partners (MAP) AG
 *  All Rights Reserved.
 *
 *  @author : barthwpr
 *  @date   : Sep 8, 2006
 *  @version:
 *
 *  @history
 *  this class is the implementation class for all
 *  the login methods in the loginManagerFacade
 */

package com.mgmtassessment.execmap.business.impl.login;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.MailException;

import com.mgmtassessment.execmap.business.api.login.LoginManagerFacade;
import com.mgmtassessment.execmap.business.impl.mail.MailWriterFacadeImpl;
import com.mgmtassessment.execmap.business.model.LoginModel;
import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;
import com.mgmtassessment.execmap.common.exceptions.DataSaveException;
import com.mgmtassessment.execmap.common.exceptions.EmailException;
import com.mgmtassessment.execmap.common.framework.business.AbstractFacadeImpl;
import com.mgmtassessment.execmap.common.util.TranslateHelper;
import com.mgmtassessment.execmap.common.util.search.HQLSearch;
import com.mgmtassessment.execmap.data.dao.types.CompanyUserMaster;
import com.mgmtassessment.execmap.data.daoapi.LoginDAO;

/**
 * LoginManagerFacadeImpl which performs all the login related
 * functionality. It allows valid users to access the application.
 * Also allows users to retrieve their password.
 *
 */

public class LoginManagerFacadeImpl extends AbstractFacadeImpl implements
        LoginManagerFacade {
/**
 * Logger for LoginManagerFacadeImpl.
 */
    private static Log log = LogFactory.getLog(LoginManagerFacadeImpl.class);


    /**.
     * LoginDao object
     *
     */
    private static LoginDAO loginDAO;

    /**
     * @return Returns the loginDAO.
     */
    public LoginDAO getLoginDAO() {
        return loginDAO;
    }

    /**
     * Initialize the mailer object in order to initialize the
     * MailWriterFacadeImpl bean.
     */
    private MailWriterFacadeImpl mailer;

    /**
     * @param mailer
     *            The mailer to set.
     */
    public void setMailer(MailWriterFacadeImpl mailer) {
        this.mailer = mailer;
    }

    /**
     * @param loginDAO
     *            The loginDAO to set.
     */
    public void setLoginDAO(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    /**
     * this method is used to validate the login credentials of the uswer
     *
     * @param accountId
     *            the accountId entered by the user
     * @param userId
     *            the userId entered by the user
     * @param password
     *            the password entered by the user
     * @return LoginModel login model object containig the accountId ,userId and
     *         the activity roleId of the user
     * @throws DataNotFoundException
     *             exception thrown if no user exists for the data entered
     */
    public LoginModel validateLoginUser(String accountId, String userId,
            String password) throws DataNotFoundException {
        String account_type = null;

        String account_status = null;

        String role_id;

        LoginModel loginModel = null;

        List validateUserList = null;

        try {
            validateUserList = loginDAO.getValidateUserList(accountId);
        } catch (DataNotFoundException ex) {
            throw new DataNotFoundException(
                    "loginbean.validate.failurereason5", ex);
        }

        if (validateUserList.size() > 0) {
            int rows = validateUserList.size();

            Iterator validateUserIterator = validateUserList.iterator();

            if (validateUserIterator.hasNext()) {
                Object[] userData = (Object[]) validateUserIterator.next();

                account_type = userData[0].toString();

                account_status = userData[1].toString();

            }
        }

        if (account_type.equals("A") && account_status.equals("E")) {
            loginModel = validateAdmin(accountId, userId, password);
        } else if (account_type.equals("A") && account_status.equals("D")) {
            throw new
            DataNotFoundException("loginbean.validate.failurereason1");
        } else if (account_type.equals("C") && account_status.equals("E")) {

            loginModel = validateCompanyUser(accountId, userId, password);

        } else if (account_type.equals("C") && account_status.equals("D")) {
            throw new
            DataNotFoundException("loginbean.validate.failurereason3");
        }

        return loginModel;
    }

    /**
     * a class level method to validate if the user is execmap administrator
     *
     * @param accountId
     *            the accountId entered by the user
     * @param UserId
     *            the userId entered by the user
     * @param password
     *            the password entered by the user
     * @return LoginModel login model object containig the accountId ,userId and
     *         the activity roleId of the user
     * @throws DataNotFoundException
     *             exception thrown if no user exists for the data entered
     */
    private static LoginModel validateAdmin(String accountId, String userId,
            String password) throws DataNotFoundException {
        LoginModel loginModel = new LoginModel();
        try {
            List validateAdminList = loginDAO.getValidateAdminList(accountId,
                    userId, password);

            if (validateAdminList.size() > 0) {

                loginModel.setAcctid(accountId);
                loginModel.setUserid(userId);
                loginModel.setRoleId("1");
            }
        } catch (DataNotFoundException ex) {
            throw new DataNotFoundException(
                    "loginbean.validateadmin.failurereason2", ex);

        }
        return loginModel;
    }

    /**
     * a class level method to validate if the user is a company user
     *
     * @param accountId
     *            the accountId entered by the user
     * @param UserId
     *            the userId entered by the user
     * @param password
     *            the password entered by the user
     * @return LoginModel login model object containig the accountId ,userId and
     *         the activity roleId of the user
     * @throws DataNotFoundException
     *             exception thrown if no user exists for the data entered
     */
    private static LoginModel validateCompanyUser(String accountId,
            String userId, String password) throws DataNotFoundException {
        LoginModel loginModel = new LoginModel();

        String role_Id = null;
        String account_status = null;
        List validateUserList = null;
        String lock_Status = null;
        try {
            validateUserList = loginDAO.getValidateUserList(accountId, userId,
                    password);
        } catch (DataNotFoundException ex) {
            throw new DataNotFoundException(
                    "loginbean.validateinduserpwd.failurereason1", ex);
        }

        if (validateUserList.size() > 0) {

            Iterator validateUserIterator = validateUserList.iterator();

            if (validateUserIterator.hasNext()) {
                Object[] userData = (Object[]) validateUserIterator.next();

                role_Id = userData[0].toString().trim();

                account_status = userData[1].toString().trim();

            }
        }

        if (account_status.equals("D"))
            throw new
            DataNotFoundException("loginbean.validate.failurereason1");

        else if (account_status.equals("E") && role_Id.equals("2")) {
            loginModel.setAcctid(accountId);
            loginModel.setUserid(userId);
            loginModel.setRoleId("2");
            return loginModel;
        } else if (account_status.equals("E") && role_Id.equals("3")) {
            boolean group_Status = validateGroupStatus(accountId, userId);

            if (group_Status) {
                loginModel.setAcctid(accountId);
                loginModel.setUserid(userId);
                loginModel.setRoleId("3");

            } else
                throw new DataNotFoundException(
                        "loginbean.validategroupstatus.failurereason1");
        } else if (account_status.equals("E") && role_Id.equals("5")) {
            boolean group_Status = validateGroupStatus(accountId, userId);

            if (group_Status) {
                loginModel.setAcctid(accountId);
                loginModel.setUserid(userId);
                loginModel.setRoleId("5");

            } else
                throw new DataNotFoundException(
                        "loginbean.validategroupstatus.failurereason1");
        } else
            throw new DataNotFoundException
            ("loginbean.validate.failurereason6");

        return loginModel;

    }

    /**
     * a class level method to find teh group status of the user
     *
     * @param accountId
     *            the accountId entered by the user
     * @param UserId
     *            the userId entered by the user
     *
     * @return boolean
     *         enable disable status of the group
     * @throws DataNotFoundException
     *             exception thrown if group status is "D"
     */
    static boolean validateGroupStatus(String accountId, String userId)
            throws DataNotFoundException {
        try {
            String group_Status = (loginDAO.getGroupStatus(accountId, userId))
                    .trim();

            if (group_Status.equals("E"))
                return true;
            else
                return false;
        } catch (DataNotFoundException ex) {
            throw new DataNotFoundException(
                    "loginbean.validategroupstatus.failurereason2", ex);
        }
    }

    /**
     * method to find the account lock status of the user
     *
     * @param accountId
     *            the accountId entered by the user
     * @param UserId
     *            the userId entered by the user
     *
     * @return boolean
     *         enable disable status of the account lock
     * @throws DataNotFoundException
     *             exception thrown if no account is locked
     */
    public  boolean accountLockStatus(String accountId, String userId)
            throws DataNotFoundException {
        List resultList ;
        String role_Id=null;
        String lock_Status = null;
        try {
            resultList = (loginDAO.getlockStatus(accountId, userId));
        }
        catch (DataNotFoundException ex) {
            throw new DataNotFoundException(
                    "loginbean.validatecompanyuserpwd.failurereason2", ex);
        }
        if (resultList.size() > 0) {

            Iterator validateUserIterator = resultList.iterator();

            if (validateUserIterator.hasNext()) {
                Object[] userData = (Object[]) validateUserIterator.next();

                role_Id = userData[0].toString().trim();


                lock_Status = userData[1].toString().trim();

            }
        }
            if  (lock_Status.equals("3")&& role_Id.equals("2"))
                throw new DataNotFoundException(
                        "loginbean.validatelockstatus.failurereason2");
            else if  (lock_Status.equals("3")&& role_Id.equals("3"))
                throw new DataNotFoundException(
                "loginbean.validatelockstatus.failurereason3");
            else if  (lock_Status.equals("3")&& role_Id.equals("5"))
                throw new DataNotFoundException(
                "loginbean.validatelockstatus.failurereason5");

            else
                return true ;
            }
    /**
     *method to update the account_locked column by value of count
     * @param accountId
     *        the userId entered by the user
     * @param userId
     *        the userId entered by the user
     * @param count
     *        this the no of time user
     *        tries to login
     * @throws DataSaveException
     *         exception thrown if the data couldn't be updated
     */
    public void updateAccountLock(String accountId, String userId,int count)
    throws DataSaveException
    {
        try
        {
            loginDAO.updateAccountLock(accountId,userId,count);
        }

        catch (Exception ex) {
            throw new DataSaveException
            ("loginbean.validatecompanyuserpwd.failurereason2",ex);
        }

    }



    /**
     *Method to retrieve all languages supported by the system.
     *@exception DataNotFoundException,
     *             if nothing is found.
     */

    public Map getLanguages() throws DataNotFoundException {
        TranslateHelper translateHelper = (TranslateHelper) appCtxt
                .getBean("langHelper");
        return translateHelper.getLanguages();
    }

    /**
     * Sends the mail to user who has forget the password
     *
     * @param loginModel
     * @throws DataNotFoundException
     */
    public void passwordReminder(LoginModel loginModel)
            throws DataNotFoundException,EmailException {

        String acctId = loginModel.getAcctid();
        String usrId = loginModel.getUserid();
        String email = loginModel.getEmail();
        String password = null;

        List counter;
        HashMap placeHolders = new HashMap();
        HQLSearch hqlsearch = (HQLSearch) appCtxt.getBean("hqlSearch");
        placeHolders.put("ACCTID", acctId);
        placeHolders.put("USRID", usrId);
        placeHolders.put("EMAIL",email);
        try {

            log.debug("Searching User...Account ID:"
                    +acctId+"UserID:"+usrId);

            counter = hqlsearch.search("PasswordReminderQuery", placeHolders);

            log.info("Found user:"+counter);

            Iterator itr = counter.iterator();
            while (itr.hasNext()) {
                CompanyUserMaster companyUserMaster = (CompanyUserMaster) itr
                        .next();
                password = companyUserMaster.getPasswd();
            }

            try {

                mailer.sendPasswordMail(email, password);

            } catch (MailException ex) {
                throw  new EmailException("email.failure",ex);

            }

        } catch (Exception ex) {
            throw new DataNotFoundException("errors.account.userid.notfound",
                    ex);
        }

    }

    /**
     * This method allows the user to Update the Password.
     *
     * @param loginModel
     * @throws DataSaveException
     */
    public void updatePassword(LoginModel loginModel) throws DataSaveException {
        String acctId = loginModel.getAcctid();
        String usrId = loginModel.getUserid();
        String password = loginModel.getPassword();
        String newPassword = loginModel.getNewPassword();
        try {
            boolean totalUsers = doesUserExist(acctId, usrId, password);
            loginDAO.updatePassword(acctId, usrId, newPassword);
        } catch (Exception ex) {
            throw new DataSaveException("errors.account.userid.pwd.notfound",
                    ex);
        }

    }

    /**
     * Checks whether user already exist or not.
     *
     * @param acctId
     * @param usrId
     * @param pwd
     * @return boolean value whether user exist or not.
     * @throws DataNotFoundException
     */
    private boolean doesUserExist(String acctId, String usrId, String pwd)
            throws DataNotFoundException {
        boolean user = true;
        List counter;
        HashMap placeHolders = new HashMap();
        HQLSearch hqlsearch = (HQLSearch) appCtxt.getBean("hqlSearch");
        placeHolders.put("ACCTID", acctId);
        placeHolders.put("USRID", usrId);
        placeHolders.put("PASSWD", pwd);
        try {

            log.debug("Searching User...Account ID:"
                    +acctId+"UserID:"+usrId);

            counter = hqlsearch
                    .search("CountCompanyUserQueryKey", placeHolders);
            Integer intCount = (Integer) counter.get(0);

            int count = intCount.intValue();

            log.debug("No of Users Found"+count);

            if (count > 0) {
                user = true;
            } else {
                user = false;
            }

        } catch (Exception ex) {
            throw new DataNotFoundException(
                    "errors.account.userid.pwd.notfound", ex);
        }

        return user;
    }

    /**
     * method to retrieve reportId for a acctId.
     * @param accountId of the user.
     * @return reportId corressponding to the accountId
     */
    public Byte getReportId(String accountId) throws DataNotFoundException {
        Byte reportId = null;
        Short rptId = null;
        List reportIdList;
        HashMap placeHolders = new HashMap();
        HQLSearch hqlsearch = (HQLSearch) appCtxt.getBean("hqlSearch");
        placeHolders.put("ACCTID", accountId);
        reportIdList = hqlsearch.search("ReportIdKey", placeHolders);
        if (reportIdList.size()>0) {
            rptId = (Short)reportIdList.get(0);
        }
        reportId = new Byte(rptId.toString());
        return reportId;
    }
}
