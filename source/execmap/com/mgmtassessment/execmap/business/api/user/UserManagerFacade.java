/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : sharmrahu
 * @date : Oct 11, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.business.api.user;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.struts.action.ActionMessages;

import com.mgmtassessment.execmap.business.model.UserAccountModel;
import com.mgmtassessment.execmap.common.exceptions.DataCreateException;
import com.mgmtassessment.execmap.common.exceptions.DataDeleteException;
import com.mgmtassessment.execmap.common.exceptions.DataMoveException;
import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;
import com.mgmtassessment.execmap.common.exceptions.DataSaveException;
import com.mgmtassessment.execmap.common.exceptions.EmailException;
import com.mgmtassessment.execmap.common.framework.business.AbstractFacade;

/**
 * Class is responsible for all user level operations performs
 * save,update,retrive operations.
 *
 * @author sharmrahu
 */

public interface UserManagerFacade
        extends AbstractFacade {
    /**
     * This method saves information related to a specified user.
     *
     * @param userAccountModel
     *            user modal containing the record of the user to be inserted.
     * @exception DataCreateException
     *                if there is some error related to the data to be inserted.
     * @exception EmailException
     *                in case of email failure.
     */
    public void saveUser(
            UserAccountModel userAccountModel)
            throws DataCreateException, EmailException;

    /**
     * The method retrives information of the user with the specified user
     * details -- userID and accountID.
     *
      * @param findUserDetails
     *            user modal containing the group id,user id and company id of
     *            the user to be found.
     * @return UserAccountModel , user modal containing the record of the user.
     * @exception DataNotFoundException
     *                if nothing matching is found.
     */
    public UserAccountModel retriveUser(
            UserAccountModel findUserDetails)
            throws DataNotFoundException;

    /**
     * The method retrives information of the user with the specified user
     * details -- userID and accountID for company user profile action
     *
     * @param findUserDetails
     *            user modal containing the group id,user id and company id of
     *            the user to be found.
     * @return UserAccountModel , user modal containing the record of the user.
     * @exception DataNotFoundException
     *                if nothing matching is found.
     */
    public UserAccountModel retriveCompanyUser(
            UserAccountModel findUserDetails)
            throws DataNotFoundException;

    /**
     * It updates the User information.
     *
     * @param updateuserAccount,
     *            the updated user record to be saved.
     * @exception DataSaveException
     *                if there is some error related to the data to be updated.
     */
    public void updateUser(
            UserAccountModel updateuserAccount)
            throws DataSaveException;

    /**
     * it moves the user from one group to another
     *
     * @param accountId
     *        the accountId of the user to be moved
     * @param grpId
     *       the group Id of the user to be moved
     * @param selectedGroupId
     *        the group Id selected to which the user has to be moved
     * @return
     * @throws DataMoveException
     *         exception thrown if the move operation is not successfull
     */

    public void moveUser(
            String accountId, String usrId, String grpId,
String selectedGroupId)throws DataMoveException;

    /**
     * This method is used to retrive users matching the given userID,groupID
     * and accountID
     *
      * @param accountID
     *            accoundID of(selected by)
     *            the user to know which groups it can.
     *            see.
     * @param groupID
     *            group Id of(selected by) the user to know which groups it can.
     * @param groupID
     *            criteria agains which the search works.
     * @param page
     *            implements paging of records.
     * @return Map containing the users and a maximum page cout.
     * @exception DataNotFoundException
     *                if nothing matching is found.
     */
    public Map getListOfUsers(
            String accountID, String groupID, String userName, int page)
            throws DataNotFoundException;

    /**
     * function to change the status of User account.
     *
     * @param userAccountModel
     *            user modal containing the record of the user to be updated.
     */
    public void enableDisableUserAccount(
            UserAccountModel enableDisableUser)
            throws DataSaveException;

    /**
     * this method is used to retreive disabled users of particular group
     *
     * @param acctId
     *        the account Id for which the disabled user list is to be retrieved
     * @param groupId
     *        the group Id for which the users list has to be retrieved
     * @return List
     * @throws DataNotFoundException
     *         excepton thrown if  no user can be found
     */
    public List deleteDisableUser(
            String acctId, String groupId)
            throws DataNotFoundException;

    /**
     * this method is used to delete disabled users of particular group
     *
     * @param accountId
     *        accountId of the company for which the user is to be deleted
     * @param usrIds
     *        the selected users that are to be deleted
     * @return void
     *  @throws DataDeleteException
     *         exception thrown if the user can't be deleted
     */
    public void deleteSelectedUser(
            String accountId, String[] userIds)
            throws DataDeleteException;

    /**
     * This method saves information related to a specified user.
     *
     * @param userAccountModel
     */
    public ActionMessages createUser(
            Collection userDetail);
}
