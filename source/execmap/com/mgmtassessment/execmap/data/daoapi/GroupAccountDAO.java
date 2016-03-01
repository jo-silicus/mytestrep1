/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : sharmrahu
 * @date : Aug 2, 2006
 * @version:
 * @history Class used to insert, retrive, update data in the GrompManagerMaster
 *          table also updates the userMaster table
 */

package com.mgmtassessment.execmap.data.daoapi;

import java.io.Serializable;
import java.util.Set;

import org.springframework.dao.DataRetrievalFailureException;

import com.mgmtassessment.execmap.business.model.GroupAccountModel;

/**
 * Class used to insert, retrive, update data in the GrompManagerMaster table
 * also updates the userMaster table.
 *
 * @author sharmrahu
 */
public interface GroupAccountDAO {
    /**
     * To save a new group record.
     *
     * @param object group object to be saved.
     */
    void saveGroup(Object object);

    /**
     * To update a given group record.
     *
     * @param object group object to be updated.
     */
    void updateGroup(Object object);

    /**
     * To retrive a perticular group.
     *
     * @param object group key against which record has to be retrieved.
     * @return Object group's retrieved record.
     */
    Object retriveGroup(Serializable object);

    /**
     * Returns a perticular user- used to get group manager record.
     *
     * @param groupAccountModel group record whose manager is required.
     * @return Object user object of the group manager.
     */
    Object retriveManager(GroupAccountModel groupAccountModel);

    /**
     * this method is used to delete the selected groups.
     *
     * @param accountId
     *         accountId for the group to be deleted
     * @param grpIds
     *        group Id's for the selected groups that are to be deleted
     * @return void
     *
     * @exception DataRetrievalFailureException
     *       exception thrown if group can't be deleted
     */
    public void deleteGroups(String accountId, String[] grpIds) throws DataRetrievalFailureException;

    /**
     * Returns the list of groups of a perticular company.
     *
     * @param acctId account ID for which groups are retrieved.
     * @return Set conating all groups of a company.
     */
      Set getAllGroupsOfCompany(String acctId);

    /**
     * Returns the list of all users within a group.
     *
     * @param acctID account ID for which users are retrieved.
     * @param groupID group ID for which users are retrieved.
     * @return Set conating the list of users.
     */
     Set getAllUsersOfGroup(String acctID, String groupID);
}
