/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : sharmrahu
 * @date : Aug 2, 2006
 * @version:
 * @history Class used to insert, retrive, update data in the companyUserMaster
 */

package com.mgmtassessment.execmap.data.daoapi;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;

/**
 * Class used to insert, retrive, update data in the companyUserMaster table.
 *
 * @author sharmrahu
 */
public interface UserAccountDAO {
    /**
     * To save a new user record.
     *
     * @param object user object to be saved.
     */
    void saveUser(Object object);

    /**
     * To update a given user record.
     *
     * @param object user object to be updated.
     */
    void updateUser(Object object);

    /**
     * To retrive a perticular user.
     *
     * @param object user Key against which record has to be retrieved.
     * @return Object user object retrieved..
     */
    Object retriveUser(Serializable object);

    /**.
     * to save user to another group
     *
     * @param accountId
     *        the accountId of the user to be moved
     * @param grpId
     *       the group Id of the user to be moved
     * @param selectedGroupId
     *        the group Id selected to which the user has to be moved
     * @return
     *
     */
    void saveMoveUsers(String accountId, String grpId, String usrId,
            String selectedGroupId, List userIdList);

    /**
     * Returns the list of users of a pericular group of a company.
     *
     * @param acctId account ID for uhich record has to be retrieved.
     * @param groupId group ID for uhich record has to be retrieved.
     * @return Collection conatining list of records.
     */
    Collection getAllUsersOfGroup(String acctId, String groupId);

    /**.
     * this method is used to delete disabled users of particular group
     *
     * @param accountId
     *        the account Id of the user to be deleted
     * @param userIds
     *        the selected users that are to be deleted
     * @throws DataAccessException
     *         excepton thrown if  no user can be found
     */
    void deleteSelectedUser(String accountId,
            String[] userIds) throws DataAccessException;

    /**
     * method that returns group manager record of a particular groupID.
     * @param accountID
     *              accountID of the company whose manager is to be retrieved.
     * @param groupID
     *              groupID of the group whose manager is to be retrieved.
     * @return Object,
     *              company user object retrived.
     * @exception
     *         DataNotFoundException,
     *         if no record is found.
     */
     Object getGroupManager(String accountID
            ,String groupID)throws DataNotFoundException;
    /**
     * method that returns company manager record of a particular accountID.
     * @param accountID
     *              accountID of the company whose manager is to be retrieved.
     * @return Object,
     *              company user object retrived.
     * @exception
     *         DataNotFoundException,
     *         if no record is found.
     */
    Object getCompanyManager(
            String accountID)throws DataNotFoundException;
}
