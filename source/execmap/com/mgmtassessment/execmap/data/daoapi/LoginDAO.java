/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : AhmedZia
 * @date : Aug 21, 2006
 * @version:
 *
 * @history Description Reference Name Date
 *
 */

package com.mgmtassessment.execmap.data.daoapi;

import java.util.List;

import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;
import com.mgmtassessment.execmap.common.exceptions.DataSaveException;

/**
 * LoginDAO provides an interface for all the login related.
 * business.
 *
 */

public interface LoginDAO {

    /**
     * Interface for changing the password of a user.
     * @param acctId
     * @param usrId
     * @param pwd
     */
    public void updatePassword(String acctId, String usrId, String pwd);
    /**
     * this method validates the user on accountId userId
     * password and returns teh userlist containing all
     * data corresponding to user
     *@param accountId
     *        the accountId entered by the user
     *  @return List
     *         list containig the user data
     * @throws DataNotFoundException
     *         exception thrown if no user exists for the data entered
     */
    List getValidateUserList(String accountId)throws DataNotFoundException ;

    /**
     * this method returns the list from
     * intellicue_sys_mas table based on accountId, userId ,password
     *@param accountId
     *        the accountId entered by the user
     * @param UserId
     *        the userId entered by the user
     * @param password
     *        the password entered by the user
     * @return List
     *         list containig the user data
     * @throws DataNotFoundException
     *         exception thrown if no user exists for the data entered
     */
    List getValidateAdminList(String accountId ,
            String userId,String password)
    throws DataNotFoundException;

    /**
     * this method validates the user on accountId userId
     * password and returns teh userlist containing all
     * data corresponding to user
     *@param accountId
     *        the accountId entered by the user
     * @param UserId
     *        the userId entered by the user
     * @param password
     *        the password entered by the user
     *  @return List
     *         list containig the user data
     * @throws DataNotFoundException
     *         exception thrown if no user exists for the data entered
     */
    List getValidateUserList(String accountId ,
            String userId,String password)
    throws DataNotFoundException;

    /**
     * this method gets the group status
       *@param accountId
      *        the accountId entered by the user
      * @param UserId
      *        the userId entered by the user
      * @return String
      *         the group status of the user entered
      * @throws DataNotFoundException
      *         exception thrown if no user exists for the data entered
      */
    String getGroupStatus (String accountId ,
            String userId)
    throws DataNotFoundException;
    /**
     * method to find the lock status of  the user
     *
     * @param accountId
     *            the accountId entered by the user
     * @param UserId
     *          the userId entered by the user
      * @return List
     *         user data conatinig role_id and account status
     * @throws DataNotFoundException
     *             exception thrown if group status is "D"
     */
    public List getlockStatus (String accountId ,
            String userId) throws DataNotFoundException;
    /**
     *method to update the account_locked column by value of count
     * @param accountId
     *        the userId entered by the user
     * @param userId
     *        the userId entered by the user
     * @param count
     *        this the no of time user
     *        tries to login
     */
    public void updateAccountLock(String accountId, String userId,int count);
}
