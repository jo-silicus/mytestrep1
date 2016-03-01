/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : sharmrahu
 * @date : Aug 2, 2006
 * @version:
 * @history Class is responsible for all implementations of group level
 *          operations performs save,update,retrive operations on group
 */

package com.mgmtassessment.execmap.business.impl.group;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.mail.MailException;

import com.mgmtassessment.execmap.business.api.group.GroupManagerFacade;
import com.mgmtassessment.execmap.business.api.mail.MailWriterFacade;
import com.mgmtassessment.execmap.business.model.GroupAccountModel;
import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.exceptions.DataCreateException;
import com.mgmtassessment.execmap.common.exceptions.DataDeleteException;
import com.mgmtassessment.execmap.common.exceptions.DataMoveException;
import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;
import com.mgmtassessment.execmap.common.exceptions.DataSaveException;
import com.mgmtassessment.execmap.common.exceptions.EmailException;
import com.mgmtassessment.execmap.common.framework.business.AbstractFacadeImpl;
import com.mgmtassessment.execmap.common.util.search.HQLSearch;
import com.mgmtassessment.execmap.data.dao.types.ActvRolMaster;
import com.mgmtassessment.execmap.data.dao.types.CompanyAcctMaster;
import com.mgmtassessment.execmap.data.dao.types.CompanyGroupMaster;
import com.mgmtassessment.execmap.data.dao.types.CompanyGroupMasterKey;
import com.mgmtassessment.execmap.data.dao.types.CompanyUserMaster;
import com.mgmtassessment.execmap.data.dao.types.CompanyUserMasterKey;
import com.mgmtassessment.execmap.data.daoapi.CompanyAccountDAO;
import com.mgmtassessment.execmap.data.daoapi.GroupAccountDAO;
import com.mgmtassessment.execmap.data.daoapi.UserAccountDAO;

/**
 * Class is responsible for all implementations of group level operations
 * performs save,update,retrive operations on group.
 *
 * @author sharmrahu
 */
public class GroupManagerFacadeImpl
        extends AbstractFacadeImpl
        implements GroupManagerFacade {

    /** Log factory for this class. * */
    private static Log     log = LogFactory
                                       .getLog(GroupManagerFacadeImpl.class);
    /**
     * groupAccountDAO that is used throughout the class.
     */
    private GroupAccountDAO   groupAccountDAO;

    /**
     * Initialize the companyAccountDAO object in order to initialize the
     * companyAccountDAO bean.
     */
    private CompanyAccountDAO companyAccountDAO;

    /**
     * UserDAo to retrive company manager record for sending email.
     */
    private UserAccountDAO    userAccountDAO;

    /**
     * mailer to send mail on successful creation.
     */
    private MailWriterFacade  mailer;

    /**
     * @return Returns the companyAccountDAO.
     */
    public CompanyAccountDAO getCompanyAccountDAO() {
        return companyAccountDAO;
    }

    /**
     * @param companyAccountDAO
     *            The companyAccountDAO to set.
     */
    public void setCompanyAccountDAO(
            CompanyAccountDAO companyAccountDAO) {
        this.companyAccountDAO = companyAccountDAO;
    }

    /**
     * @return Returns the groupAccountDAO.
     */
    public GroupAccountDAO getGroupAccountDAO() {
        return groupAccountDAO;
    }

    /**
     * @param groupAccountDAO
     *            The groupAccountDAO to set.
     */
    public void setGroupAccountDAO(
            GroupAccountDAO groupAccountDAO) {
        this.groupAccountDAO = groupAccountDAO;
    }

    /**
     * @param groupAccountModel
     *            function makes a Group hibernate object from the model Object.
     * @return CompanyGroupMaster record that is formed.
     */
    private CompanyGroupMaster makeGroupAccountObject(
            final GroupAccountModel groupAccountModel) {
        Set groupUserSet = new HashSet();

        // user account
        CompanyUserMasterKey userAccountKey = new CompanyUserMasterKey(
                groupAccountModel
                        .getCompanyAccountID(), groupAccountModel
                        .getUserID());
        CompanyUserMaster userAccount = new CompanyUserMaster();

        // group Account
        CompanyGroupMasterKey groupAccountKey = new CompanyGroupMasterKey(
                groupAccountModel
                        .getCompanyAccountID(), groupAccountModel
                        .getUserGroupID());

        CompanyGroupMaster groupAccount = new CompanyGroupMaster();

        // setting user Details
        userAccount
                .setComp_id(userAccountKey);
        userAccount
                .setFirstName(groupAccountModel
                        .getUserFirstName());
        userAccount
                .setLastName(groupAccountModel
                        .getUserLastName());
        userAccount
                .setPasswd(groupAccountModel
                        .getUserPassword());
        userAccount
                .setUsrEmail(groupAccountModel
                        .getUserEmail());
        userAccount
                .setNotes1(groupAccountModel
                        .getUserNotes1());
        userAccount
                .setNotes2(groupAccountModel
                        .getUserNotes2());
        userAccount
                .setStartFlg(groupAccountModel
                        .getUserStartFlag());
        userAccount
                .setUsrStat(groupAccountModel
                        .getUserStatus());
        if(groupAccountModel.getUserAccountLockedStatus(
                )!=null)
        {
            userAccount.setAcctLocked(new Integer(
                groupAccountModel.getUserAccountLockedStatus()));
        }
        else
        {
            userAccount.setAcctLocked(new Integer(0));
        }
        // setting the role ID to be
        Short actvRolId = new Short(
                (short) 3);
        ActvRolMaster actvRolMaster = new ActvRolMaster(
                actvRolId, "Group Manager");
        userAccount
                .setActvRolMa(actvRolMaster);
        userAccount
                .setReminderPhrase(groupAccountModel
                        .getUserReminderPhrase());

        // setting group Details
        groupUserSet
                .add(userAccount);
        groupAccount
                .setComp_id(groupAccountKey);
        groupAccount
                .setGrpInfo(groupAccountModel
                        .getGroupInfo());
        groupAccount
                .setGrpStat(groupAccountModel
                        .getGroupStatus());
        groupAccount
                .setCoUsrMas(groupUserSet);

        // updating the user Account
        userAccount
                .setCoGrpMa(groupAccount);
        userAccount
                .setGrpId(groupAccountModel
                        .getUserGroupID());

        return groupAccount;
    }

    /**
     * This method saves information related to a specified group.
     *
     * @param addGroupAccount
     *            group modal containing the record of the group to be inserted.
     * @exception DataCreateException
     *                if there is some error related to the data to be inserted.
     * @exception EmailException
     *                in case of email failure.
     */
    public void saveGroup(
            GroupAccountModel addGroupAccount)
            throws DataCreateException,EmailException {
        addGroupAccount.setUserAccountLockedStatus("0");
        CompanyGroupMaster groupAccount = makeGroupAccountObject(
                addGroupAccount);

        try {
            // saving the group Object
            groupAccountDAO
                    .saveGroup(groupAccount);
            log.info("group saved acctID:"+addGroupAccount.getCompanyAccountID()
                    +"grpID:"+addGroupAccount.getUserGroupID());
            log.info("group updated acctID:"+
                    addGroupAccount.getCompanyAccountID()
                    +" grpID:"+addGroupAccount.getUserGroupID()
                    +" managerID:"+addGroupAccount.getUserID());
        }
        catch (DataIntegrityViolationException e) {
            throw new DataCreateException(
                    "groupbean.add.failurereason", e);
        }
        // retriving company details for mail.
        try {
        CompanyAcctMaster companyDetails = companyAccountDAO
                .getCompanyDetails(addGroupAccount
                        .getCompanyAccountID());
         CompanyUserMaster companyManager=(CompanyUserMaster
                 )userAccountDAO.getCompanyManager(addGroupAccount
                .getCompanyAccountID());

            mailer
                    .sendAddGroupMail(
                            addGroupAccount
                                    .getUserEmail(), addGroupAccount
                                    .getCompanyAccountID(), addGroupAccount
                                    .getUserFirstName(), addGroupAccount
                                    .getUserID(), addGroupAccount
                                    .getUserPassword(), companyDetails
                                    .getCoName(), companyManager
                                    .getFirstName(), companyDetails
                                    .getCoEmail());
            log.info("create group mail sent accttID:"+
                    addGroupAccount.getCompanyAccountID()
                    +" grpID:"+addGroupAccount.getUserGroupID()
                    +" mailId:"+addGroupAccount
                    .getUserEmail());
        }
        catch (MailException ex) {
            throw  new EmailException("email.failure",ex);
        }
        catch (DataNotFoundException ex) {
            throw  new EmailException("email.failure",ex);
        }
    }

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
    public GroupAccountModel retriveGroup(
            GroupAccountModel findGroupDetails)
            throws DataNotFoundException {
        // making the key to be used
        CompanyGroupMasterKey companyGroupMasterKey = new CompanyGroupMasterKey(
                findGroupDetails
                        .getCompanyAccountID(), findGroupDetails
                        .getUserGroupID());
        GroupAccountModel groupAccountModelretrived = null;
        // retriving the data using the key
        CompanyGroupMaster retrivedGroup = (CompanyGroupMaster) groupAccountDAO
                .retriveGroup(companyGroupMasterKey);
        // if some object is retrived then set the model object fields
        if (retrivedGroup != null) {
            CompanyUserMaster groupManager=(CompanyUserMaster
            )userAccountDAO.getGroupManager(findGroupDetails
                     .getCompanyAccountID(),findGroupDetails
                     .getUserGroupID());
            groupAccountModelretrived = new GroupAccountModel();
            groupAccountModelretrived
                    .setCompanyAccountID(retrivedGroup
                            .getComp_id().getAcctId());
            groupAccountModelretrived
                    .setGroupInfo(retrivedGroup
                            .getGrpInfo());
            groupAccountModelretrived
                    .setGroupStatus(retrivedGroup
                            .getGrpStat());
            groupAccountModelretrived
                    .setUserID(groupManager.getComp_id(
                                    ).getUsrId());

            groupAccountModelretrived
                    .setUserGroupID(retrivedGroup
                            .getComp_id().getGrpId());

            groupAccountModelretrived
                    .setUserEmail(groupManager.getUsrEmail());

            groupAccountModelretrived
                    .setUserFirstName(groupManager.getFirstName());

            groupAccountModelretrived
                    .setUserLastName(groupManager.getLastName());

            groupAccountModelretrived
                    .setUserPassword(groupManager.getPasswd());
            groupAccountModelretrived
                    .setUserReminderPhrase(groupManager.getReminderPhrase());
        } else {
            throw new DataNotFoundException(
                    "groupbean.getgroup2.failurereason");
        }
        return groupAccountModelretrived;
    }

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
    public void updateGroup(
            GroupAccountModel updateGroupAccount)
            throws DataSaveException, EmailException {
        // retriving group mamager data
        CompanyUserMaster companyUserMaster = (
                CompanyUserMaster) groupAccountDAO
                .retriveManager(updateGroupAccount);
        // update the data in the model object to be inseted
        updateGroupAccount
                .setUserNotes1(companyUserMaster
                        .getNotes1());
        updateGroupAccount
                .setUserNotes2(companyUserMaster
                        .getNotes2());
        updateGroupAccount
                .setUserStartFlag(companyUserMaster
                        .getStartFlg());
        Integer accountStat=companyUserMaster.getAcctLocked();
        if(accountStat==null)
        {
            updateGroupAccount.setUserAccountLockedStatus("0");
        }
        else
        {
            updateGroupAccount.setUserAccountLockedStatus(""+
                companyUserMaster.getAcctLocked());
        }
        try {
            // form a corresponding group object to be updated
            CompanyGroupMaster groupAccount = makeGroupAccountObject(
                    updateGroupAccount);
            groupAccountDAO
                    .updateGroup(groupAccount);
            log.info("update group accttID:"+
                    updateGroupAccount.getCompanyAccountID()
                    +" grpID:"+updateGroupAccount.getUserGroupID());
            }
        catch (DataIntegrityViolationException e) {
            throw new DataSaveException(
                    "groupbean.edit.failurereason", e);
        }

        try {
            mailer
                    .sendEditGroupMail(
                            updateGroupAccount
                                    .getUserEmail(), updateGroupAccount
                                    .getCompanyAccountID(), updateGroupAccount
                                    .getUserFirstName(), updateGroupAccount
                                    .getUserID(), updateGroupAccount
                                    .getUserPassword());
            log.info("update group mail sent accttID:"+
                    updateGroupAccount.getCompanyAccountID()
                    +" grpID:"+updateGroupAccount.getUserGroupID()
                    +" mailId:"+updateGroupAccount
                    .getUserEmail());
        }
        catch (MailException e) {
            throw new EmailException("email.failure",e);
        }

    }

    /**
     * it changes the group status to enable or disable based on the user
     * action.
     *
     * @param accountId
     *           the account id of the user
     * @param grpId
     *           the group id of the user
     * @return boolean
     *
     * @exception DataNotFoundException
     *             exception thrown if data for the group couldn't be retrieved
     * @exception DataSaveException
     *              exception thrown if save option is unsuccesfull
     */

    public boolean enableDisableGroup(
            String acctId, String grpId)
            throws DataNotFoundException, DataSaveException {
        CompanyGroupMaster companyGroupMaster = new CompanyGroupMaster();
        // form a CompanyGroupMasterKey object to be passed to teh retrievegroup
        // method of groupAccountDAO
        CompanyGroupMasterKey companyGroupMasterKey = new CompanyGroupMasterKey(
                acctId, grpId);

        try {
            companyGroupMaster = (CompanyGroupMaster) groupAccountDAO

                    .retriveGroup(companyGroupMasterKey);
        }
        catch (DataRetrievalFailureException ex) {
            throw new DataNotFoundException(
                    "the group data can't be retrieved", ex);
        }
        String currentGroupStatus = companyGroupMaster
                .getGrpStat();

        if (currentGroupStatus
                .equalsIgnoreCase("E")) {
            companyGroupMaster
                    .setComp_id(companyGroupMaster
                            .getComp_id());
            companyGroupMaster
                    .setCoAcctMa(companyGroupMaster
                            .getCoAcctMa());

            companyGroupMaster
                    .setCoUsrMas(companyGroupMaster
                            .getCoUsrMas());
         //   companyGroupMaster
             //       .setGroupManagerId(companyGroupMaster
            //                .getGroupManagerId());
            companyGroupMaster
                    .setGrpEmail(companyGroupMaster
                            .getGrpEmail());
            companyGroupMaster
                    .setGrpInfo(companyGroupMaster
                            .getGrpInfo());
            companyGroupMaster
                    .setGrpStat("D");

        } else {
            companyGroupMaster
                    .setComp_id(companyGroupMaster
                            .getComp_id());
            companyGroupMaster
                    .setCoAcctMa(companyGroupMaster
                            .getCoAcctMa());

            companyGroupMaster
                    .setCoUsrMas(companyGroupMaster
                            .getCoUsrMas());
          //  companyGroupMaster
           //         .setGroupManagerId(companyGroupMaster
                 //           .getGroupManagerId());
            companyGroupMaster
                    .setGrpEmail(companyGroupMaster
                            .getGrpEmail());
            companyGroupMaster
                    .setGrpInfo(companyGroupMaster
                            .getGrpInfo());
            companyGroupMaster
                    .setGrpStat("E");
        }

        try {
            groupAccountDAO
                    .updateGroup(companyGroupMaster);
        }

        catch (DataIntegrityViolationException ex) {
            throw new DataSaveException(
                    "error.enable.disable.group", ex);
        }
        return true;

    }

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
    public List deleteDisableGroup(
            String acctId)
            throws DataNotFoundException {
        HQLSearch hqlsearch = (HQLSearch) appCtxt
                .getBean("hqlSearch");
        List finalGroupList = new ArrayList();

        try {
            List resultList;
            List groupList = new ArrayList();
            HashMap placeHolders = new HashMap();
            placeHolders
                    .put(
                            "ACCTID", acctId);
            resultList = hqlsearch
                    .search(
                            "GroupMasterQueryKey", placeHolders);
            if (resultList
                    .size() > 0) {
                Integer listCount = (Integer) resultList
                        .get(0);
                int count = listCount
                        .intValue();
                if (count > 0) {
                    CompanyAcctMaster companyAcctMaster = companyAccountDAO
                            .getAllDetailsOfCompany(acctId);
                    groupList
                            .add(companyAcctMaster);

                }
            }
            Iterator groupIterator = groupList
                    .iterator();
            while (groupIterator
                    .hasNext()) {

                CompanyAcctMaster companyAcctMaster = (
                        CompanyAcctMaster) groupIterator
                        .next();
                Set companyGroupMasterSet = companyAcctMaster
                        .getCoGrpMas();
                Set finalCompanyGroupMasterSet = new HashSet();
                Iterator companyGroupMasterIterator = companyGroupMasterSet
                        .iterator();
                while (companyGroupMasterIterator
                        .hasNext()) {
                    CompanyGroupMaster companyGroupMaster = (
                            CompanyGroupMaster) companyGroupMasterIterator
                            .next();
                    if (companyGroupMaster
                            .getGrpStat().trim().equalsIgnoreCase(
                                    "D")) {
                        finalCompanyGroupMasterSet
                                .add(companyGroupMaster);
                    }
                }
                companyAcctMaster
                        .setCoGrpMas(finalCompanyGroupMasterSet);
                finalGroupList
                        .add(companyAcctMaster);
            }
        }

        catch (DataRetrievalFailureException ex) {
            throw new DataNotFoundException(
                    "error.disable.group.list", ex);
        }
        catch (Exception ex) {
            throw new DataNotFoundException(
                    "error.disable.group.list", ex);
        }
        return finalGroupList;

    }

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
    public void deleteSelectedGroup(
            String accountId, String[] grpIds)
            throws DataDeleteException {
        try {
            groupAccountDAO
                    .deleteGroups(
                            accountId, grpIds);
        }

        catch (DataRetrievalFailureException ex) {
            throw new DataDeleteException(
                    "error.delete.group", ex);
        }
    }

    /**
     * To find Groups matching the criteria.
     *
     * @param companyGroups
     *            retrived group list to be matched against the criteria.
     * @param groupID
     *            criteria agains which the search works.
     * @return Collection containing the groups
     */
    private SortedSet groupsCriteria(
            Collection companyGroups, String groupID) {
        SortedSet matchingGroupsList = null;
        Iterator companyGroupsIterator = companyGroups
                .iterator();
        while (companyGroupsIterator
                .hasNext()) {
            CompanyGroupMaster companyGroupMaster = (
                    CompanyGroupMaster) companyGroupsIterator
                    .next();
            Pattern patternGroupID = Pattern
                    .compile(
                            groupID, Pattern.CASE_INSENSITIVE);
            Matcher matchingGroup = patternGroupID
                    .matcher(companyGroupMaster
                            .getComp_id().getGrpId().trim());
            if (matchingGroup
                    .matches()) {
                if (matchingGroupsList == null) {
                    matchingGroupsList = new TreeSet(
                            new CompareGroupID());
                }
                matchingGroupsList
                        .add(companyGroupMaster);
            }
        }
        return matchingGroupsList;
    }

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
    public Map getListOfGroups(
            String accountID, String groupID, int page)
            throws DataNotFoundException {
        // retriving the whole set
        Set groupAccountSet = groupAccountDAO
                .getAllGroupsOfCompany(accountID);

        SortedSet companyGroups = new TreeSet(
                new CompareGroupID());

        SortedSet totalCompanyGroups = new TreeSet(
                new CompareGroupID());
        totalCompanyGroups
                .addAll(groupAccountSet);

        companyGroups
                .addAll(groupAccountSet);
        // matching the groupID
        if (groupID != null) {
            groupID = groupID+"*";
            groupID = groupID
                    .replace(
                            '?', '.');
            groupID = groupID
                    .replace(
                            '*', '#');
            groupID = groupID
                    .replaceAll(
                            "#", ".*");

            companyGroups = groupsCriteria(
                    groupAccountSet, groupID);
        }
        if (companyGroups == null) {
            throw new DataNotFoundException(
                    "error.searchNotFound");
        }
        log.info(" group search accttID:"+
                accountID+" grpID:"+groupID
                +" set:"+companyGroups);
        int size=IConstants.SearchResultSize;
        int maxPages = (int) Math
                .ceil((((float) companyGroups
                        .size()) /(float)size));
        int startPos = size * page;
        if (startPos > companyGroups
                .size()) {
            page = (companyGroups
                    .size()) / size;
            startPos = size * page;
        }
        int endPos = size * (page + 1);
        if (endPos > companyGroups
                .size()) {
            endPos = companyGroups
                    .size();
        }
        if (startPos < endPos) {

            // adding a element that is greater than the greatest element of
            // the
            // set
            CompanyGroupMaster companyGroupMaster = (
                    CompanyGroupMaster) companyGroups
                    .last();
            String lastAccountId = companyGroupMaster
                    .getComp_id().getAcctId().trim();
            String lastGrpId = companyGroupMaster
                    .getComp_id().getGrpId().trim();
            if (""
                    .equals(lastAccountId)) {
                lastAccountId = companyGroupMaster
                        .getComp_id().getAcctId();

            }
            if (""
                    .equals(lastGrpId)) {
                lastGrpId = companyGroupMaster
                        .getComp_id().getGrpId();

            }
            lastAccountId = lastAccountId
                    + "12345";
            lastGrpId = lastGrpId
                    + "12345";
            CompanyGroupMasterKey companyGroupMasterKey = new
            CompanyGroupMasterKey(lastAccountId, lastGrpId);
            companyGroupMaster = new CompanyGroupMaster();
            companyGroupMaster
                    .setComp_id(companyGroupMasterKey);
            companyGroups
                    .add(companyGroupMaster);

            Object[] arrayOfObjects = companyGroups
                    .toArray();
            companyGroups = companyGroups
                    .tailSet(arrayOfObjects[startPos]);
            companyGroups = companyGroups
                    .headSet(arrayOfObjects[endPos]);

        }

        Map resultData = new HashMap();
        resultData
                .put(
                        "resultList", companyGroups);
        resultData
                .put(
                        "maxPages", ""
                                + maxPages);
        resultData
                .put(
                        "fullList", totalCompanyGroups);

        return resultData;
    }

    /**
     * @return Returns the mailer.
     */
    public MailWriterFacade getMailer() {
        return mailer;
    }

    /**
     * @param mailer
     *            The mailer to set.
     */
    public void setMailer(
            MailWriterFacade mailer) {
        this.mailer = mailer;
    }

    /**
     * @return Returns the userAccountDAO.
     */
    public UserAccountDAO getUserAccountDAO() {
        return userAccountDAO;
    }

    /**
     * @param userAccountDAO
     *            The userAccountDAO to set.
     */
    public void setUserAccountDAO(
            UserAccountDAO userAccountDAO) {
        this.userAccountDAO = userAccountDAO;
    }

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
    public void moveUsers(
            String accountID, String initialGroupID, String finalGroupID)
            throws DataMoveException {
        try {
            Set users = groupAccountDAO
                    .getAllUsersOfGroup(
                            accountID, initialGroupID);
            if (users == null) {
                throw new DataMoveException(
                        "groupbean.movegroupusers.failurereason");
            }
            log.info(" move users accttID:"+
                    accountID+" initial grpID:"+initialGroupID
                    +" final GroupID:"+finalGroupID);
            Iterator userIterator = users
                    .iterator();
            while (userIterator
                    .hasNext()) {
                CompanyUserMaster companyUserMaster = (
                        CompanyUserMaster) userIterator
                        .next();
                Short rolID = companyUserMaster
                        .getActvRolMa().getActvRolId();
                if (rolID
                        .equals(new Short(
                                ""+IConstants.EXECMAP_COMPANY_USER_ROLE_ID))) {
                    companyUserMaster
                            .setGrpId(finalGroupID);
                    userAccountDAO
                            .updateUser(companyUserMaster);
                }
            }
        }
        catch (DataIntegrityViolationException e) {
            throw new DataMoveException(
                    "groupbean.movegroupusers.failurereason", e);
        }

    }
}
