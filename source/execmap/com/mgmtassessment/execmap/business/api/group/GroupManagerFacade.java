/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : sharmrahu
 * @date : Aug 2, 2006
 * @version:
 * @history Class is responsible for all group level operations performs
 *          save,update,retrive operations
 */

package com.mgmtassessment.execmap.business.api.group;

import java.util.List;
import java.util.Map;

import com.mgmtassessment.execmap.business.model.GroupAccountModel;
import com.mgmtassessment.execmap.common.exceptions.DataCreateException;
import com.mgmtassessment.execmap.common.exceptions.DataDeleteException;
import com.mgmtassessment.execmap.common.exceptions.DataMoveException;
import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;
import com.mgmtassessment.execmap.common.exceptions.DataSaveException;
import com.mgmtassessment.execmap.common.exceptions.EmailException;
import com.mgmtassessment.execmap.common.framework.business.AbstractFacade;

/**
 * Class is responsible for all group level operations performs
 * save,update,retrive operations.
 *
 * @author sharmrahu
 */
public interface GroupManagerFacade extends AbstractFacade {

    /**
     * This method saves information related to a specified group.
     *
     * @param addgroupAccount
     *            group modal containing the record of the group to be inserted.
     * @exception DataCreateException
     *                if there is some error related to the data to be inserted.
     *   @exception EmailException
     *                in case of email failure.
     */
    void saveGroup(GroupAccountModel addgroupAccount)
            throws DataCreateException,EmailException;

    /**
     * The method retrives information of the group with the specified Group
     * details -- groupID and accountID.
     *
     * @param findGroupDetails
     *            group modal containing the group id and company id of the
     *            group to be found.
     * @return GroupAccountModel , group modal containing the record of the
     *         group.
     * @exception DataNotFoundException
     *                if nothing matching is found.
     */
    public GroupAccountModel retriveGroup(GroupAccountModel findGroupDetails)
            throws DataNotFoundException;

    /**
     * It updates the group information.
     *
     * @param updategroupAccount,
     *            the updated group record to be saved. *
     * @exception DataSaveException
     *                if there is some error related to the data to be updated.
     *  @exception EmailException
     *                in case of email failure.
     */
    public void updateGroup(GroupAccountModel updategroupAccount)
            throws DataSaveException, EmailException;

    /**
     * This method handles the enable and disable of the group
     *
     * @param acctId
     *            account Id of the group to be updated.
     * @param grpId
     *            group Id of the group to be updated
     * @return boolean
     * @throws DataNotFoundException,DataSaveException
     */
    public boolean enableDisableGroup(String acctId, String grpId)
            throws DataNotFoundException, DataSaveException;

    /**
     * this method is used to retreive disabled groups of particular company
     *
     * @param accountId
     *           the account id of the user
     * @return List
     *          list of groups that are disabled for a particular account id
     * @throws DataNotFoundException
     *           exception thrown if list of disabled groups can't be retrieved
     */
    public List deleteDisableGroup(String acctId) throws DataNotFoundException;

    /**
     * this method is used to delete the selected groups.
     *
     * @param accountId
     *         accountId for the group to be deleted
     * @param grpIds
     *        group Id's for the selected groups that are to be deleted
     * @return void
     *
     * @exception DataDeleteException
     *       exception thrown if group can't be deleted
     */
    public void deleteSelectedGroup(String accountId, String[] grpIds)
            throws DataDeleteException;

    /**
     * This method is used to retrive groups matching the given groupID and
     * accountID
     *
     * @param accountID
     *            accoundID of(selected by) the user to know which groups it can
     *            see.
     * @param groupID
     *            criteria agains which the search works.
     * @param page
     *            implements paging of records.
     * @return Map containing the groups and a maximum page cout.
     * @exception DataNotFoundException
     *                if nothing matching is found.
     */
    public Map getListOfGroups(String accountID, String groupID, int page)
            throws DataNotFoundException;

    /**
     * This method is used to move users of a group to another selected group.
     *
     * @param accountID
     *            account Id of the groups to be updated.
     * @param initialGroupID
     *            group Id from which users are to be moved.
     * @param finalGroupID
     *            group Id to which users are to be moved. *
     * @exception DataMoveException
     *                if there is some error related to the data to be updated.
     */
    void moveUsers(String accountID, String initialGroupID, String finalGroupID)
            throws DataMoveException;
}
