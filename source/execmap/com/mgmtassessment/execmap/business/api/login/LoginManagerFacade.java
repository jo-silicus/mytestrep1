/**
 *  @Copyright Management Assessment Partners (MAP) AG
 *  All Rights Reserved.
 *
 *  @author : barthwpr
 *  @date   : Sep 8, 2006
 *  @version:
 *
 *  @history
 *  Description         Reference       Name        Date
 *
 */

package com.mgmtassessment.execmap.business.api.login;

import java.util.Map;

import com.mgmtassessment.execmap.business.model.LoginModel;
import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;
import com.mgmtassessment.execmap.common.exceptions.DataSaveException;
import com.mgmtassessment.execmap.common.exceptions.EmailException;
import com.mgmtassessment.execmap.common.framework.business.AbstractFacade;

/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : barthwpr
 * @date : sep 9, 2006
 * @version:
 * @history Class is responsible for all login related operation
 */
public interface LoginManagerFacade extends AbstractFacade {
    /**
     *  this method is used to validate the login credentials of the uswer
     * @param accountId
     *        the accountId entered by the user
     * @param UserId
     *        the userId entered by the user
     * @param password
     *        the password entered by the user
     * @return LoginModel
     *login model object containig the accountId
     *         ,userId and the activity roleId of the user
     * @throws DataNotFoundException
     *         exception thrown if no user exists for the data entered
     */
    LoginModel validateLoginUser(String accountId
            ,String UserId,String password)
    throws DataNotFoundException;

    /**
     * This method updates Company User Password.
     *
     * @param loginModel
     * @throws DataSaveException
     */
    public void updatePassword(LoginModel loginModel)throws DataSaveException;

    /**
     * This method sends an email to the Company User whi has forget the
     * password.
     *
     * @param loginModel
     * @throws DataNotFoundException
     */
    public void passwordReminder(LoginModel
            loginModel)throws DataNotFoundException,EmailException;
    /**
     *Method to retrieve all languages supported by the system.
     *@return map
     *             containig all the languages with their ISO names.
     *@exception DataNotFoundException,
     *             if nothing is found.
     */
    Map getLanguages() throws DataNotFoundException;

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
            throws DataNotFoundException;
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
    throws DataSaveException;

    /**
     * method to retrieve reportId for a acctId.
     * @param accountId of the user.
     * @return reportId corressponding to the accountId
     */
    public Byte getReportId(String accountId) throws DataNotFoundException;


}


