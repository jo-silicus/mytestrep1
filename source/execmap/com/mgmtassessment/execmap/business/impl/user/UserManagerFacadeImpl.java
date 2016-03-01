/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : sharmrahu
 * @date : Oct 11, 2006
 * @version:
 * @history Class is responsible for all implementations of user level
 *          operations performs save,update,retrive operations on user.
 */

package com.mgmtassessment.execmap.business.impl.user;

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
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.mail.MailException;

import com.mgmtassessment.execmap.business.api.mail.MailWriterFacade;
import com.mgmtassessment.execmap.business.api.user.UserManagerFacade;
import com.mgmtassessment.execmap.business.model.UserAccountModel;
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
import com.mgmtassessment.execmap.data.dao.types.CompanyUserMaster;
import com.mgmtassessment.execmap.data.dao.types.CompanyUserMasterKey;
import com.mgmtassessment.execmap.data.daoapi.CompanyAccountDAO;
import com.mgmtassessment.execmap.data.daoapi.GroupAccountDAO;
import com.mgmtassessment.execmap.data.daoapi.UserAccountDAO;

/**
 * Class is responsible for all implementations of user level operations
 * performs save,update,retrive operations on user.
 *
 * @author sharmrahu
 */
public class UserManagerFacadeImpl
        extends AbstractFacadeImpl
        implements UserManagerFacade {
    /**
     * TO maintain logger.
     */
    private static Log        log = LogFactory
                                          .getLog(UserManagerFacadeImpl.class);

    /**
     * userAccountDAO that is used throughout the class.
     */
    private UserAccountDAO    userAccountDAO;

    /**
     * Initialize the companyAccountDAO object in order to initialize the
     * companyAccountDAO bean.
     */
    private CompanyAccountDAO companyAccountDAO;

    /**
     * Initialize the groupAccountDAO object in order to initialize the
     * groupAccountDAO bean.
     */
    private GroupAccountDAO   groupAccountDAO;

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
     * @param userAccountModel
     *            function makes a User hibernate object from the model Object.
     * @return CompanyUserMaster record that is formed.
     */
    private CompanyUserMaster makeUserAccountObject(
            UserAccountModel userAccountModel) {
        // user account key
        CompanyUserMasterKey companyUserMasterKey = new CompanyUserMasterKey(
                userAccountModel
                        .getUserCompanyAccountID(), userAccountModel
                        .getUserID());
        // User account
        CompanyUserMaster companyUserMaster = new CompanyUserMaster();
        companyUserMaster
                .setComp_id(companyUserMasterKey);
        companyUserMaster
                .setFirstName(userAccountModel
                        .getUserFirstName());
        companyUserMaster
                .setLastName(userAccountModel
                        .getUserLastName());
        companyUserMaster
                .setGrpId(userAccountModel
                        .getUserGroupID());
        companyUserMaster
                .setStartFlg(userAccountModel
                        .getUserStartFlag());
        companyUserMaster
                .setUsrStat(userAccountModel
                        .getUserStatus());
        companyUserMaster
                .setUsrEmail(userAccountModel
                        .getUserEmail());
        companyUserMaster
                .setReminderPhrase(userAccountModel
                        .getUserReminderPhrase());
        companyUserMaster
                .setPasswd(userAccountModel
                        .getUserPassword());
        companyUserMaster
                .setNotes1(userAccountModel
                        .getUserNotes());
        if(userAccountModel.getUserAccountLockedStatus(
                )!=null)
        {
            companyUserMaster.setAcctLocked(new Integer(
                userAccountModel.getUserAccountLockedStatus()));
        }
        else
        {
            companyUserMaster.setAcctLocked(new Integer(0));
        }
        // setting activity Role ID
        Short actvRolId = new Short(
                (short)5);
        ActvRolMaster actvRolMaster = new ActvRolMaster(
                actvRolId, "");
        companyUserMaster
                .setActvRolMa(actvRolMaster);
        return companyUserMaster;

    }

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
            throws DataCreateException, EmailException {
        try {
            userAccountModel.setUserAccountLockedStatus("0");
            // creating a record
            CompanyUserMaster newUserRecord = makeUserAccountObject(
                    userAccountModel);
            // saving the record
            userAccountDAO
                    .saveUser(newUserRecord);
            // retriving company details for mail.
            try {
            CompanyAcctMaster companyDetails = companyAccountDAO
                    .getCompanyDetails(userAccountModel
                            .getUserCompanyAccountID());
            // retriving group details for mail.
            CompanyUserMaster groupManager=(CompanyUserMaster
                   )userAccountDAO.getGroupManager(userAccountModel
                            .getUserCompanyAccountID(),userAccountModel
                            .getUserGroupID());

                mailer
                        .sendAddCoUserMail(
                                userAccountModel
                                        .getUserEmail(), userAccountModel
                                        .getUserCompanyAccountID(),
                                userAccountModel
                                        .getUserFirstName(), userAccountModel
                                        .getUserID(), userAccountModel
                                        .getUserPassword(), companyDetails
                                        .getCoName(), groupManager
                                        .getUsrEmail(), userAccountModel
                                        .getUserGroupID());
            }
            catch (MailException e) {
                throw new EmailException(
                        "email.failure", e);
            }
            catch (DataNotFoundException e) {
                throw new EmailException(
                        "email.failure", e);
            }
        }
        catch (DataIntegrityViolationException ex) {

            throw new DataCreateException(
                    "companyuserbean.add.failurereason2", ex);

        }
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
            throws DataNotFoundException {

        UserAccountModel retrivedUserAccountModel = null;
        try {
            CompanyUserMasterKey companyUserMasterKey = new
            CompanyUserMasterKey(
                    findUserDetails
                            .getUserCompanyAccountID(), findUserDetails
                            .getUserID());
            // retriving the record.
            CompanyUserMaster retrivedCompanyUserMaster = (CompanyUserMaster)
            userAccountDAO.retriveUser(companyUserMasterKey);
            retrivedUserAccountModel = null;
            // setting the details in Model Object
            if (retrivedCompanyUserMaster != null) {
                retrivedUserAccountModel = new UserAccountModel();
                retrivedUserAccountModel
                        .setUserCompanyAccountID(retrivedCompanyUserMaster
                                .getComp_id().getAcctId());
                retrivedUserAccountModel
                        .setUserID(retrivedCompanyUserMaster
                                .getComp_id().getUsrId());
                retrivedUserAccountModel
                        .setUserEmail(retrivedCompanyUserMaster
                                .getUsrEmail());
                retrivedUserAccountModel
                        .setUserFirstName(retrivedCompanyUserMaster
                                .getFirstName());
                retrivedUserAccountModel
                        .setUserGroupID(retrivedCompanyUserMaster
                                .getGrpId());
                retrivedUserAccountModel
                        .setUserLastName(retrivedCompanyUserMaster
                                .getLastName());
                retrivedUserAccountModel
                        .setUserNotes(retrivedCompanyUserMaster
                                .getNotes1());
                retrivedUserAccountModel
                        .setUserPassword(retrivedCompanyUserMaster
                                .getPasswd());
                retrivedUserAccountModel
                        .setUserReminderPhrase(retrivedCompanyUserMaster
                                .getReminderPhrase());
                retrivedUserAccountModel
                        .setUserRoleID(""
                                + retrivedCompanyUserMaster
                                        .getActvRolMa().getActvRolId());
                retrivedUserAccountModel
                        .setUserStartFlag(retrivedCompanyUserMaster
                                .getStartFlg());
                retrivedUserAccountModel
                        .setUserStatus(retrivedCompanyUserMaster
                                .getUsrStat());
            } else {
                throw new DataNotFoundException(
                        "companyuserbean.getCompanyUser.failurereason");
            }
        }
        catch (DataRetrievalFailureException ex) {
            throw new DataNotFoundException(
                    "companyuserbean.getCompanyUser.failurereason", ex);
        }

        return retrivedUserAccountModel;
    }

    /**
     * The method retrives information of the user with the specified user
     * details -- userID and accountID for company user profile action
     *
     * @param findUserDetails, details of the user- accountID and UserID.
     * @return  UserAccountModel, returns full details of the user.
     * @exception DataNotFoundException, if nothing matches.
     */
    public UserAccountModel retriveCompanyUser(
            UserAccountModel findUserDetails)
            throws DataNotFoundException {
        UserAccountModel retrivedUserAccountModel = null;
        try {
            CompanyUserMasterKey companyUserMasterKey = new
            CompanyUserMasterKey(
                    findUserDetails
                            .getUserCompanyAccountID(), findUserDetails
                            .getUserID());
            // retriving the record.
            CompanyUserMaster retrivedCompanyUserMaster = (CompanyUserMaster)
            userAccountDAO.retriveUser(companyUserMasterKey);
            retrivedUserAccountModel = null;
            // setting the details in Model Object
            if (retrivedCompanyUserMaster != null
                    && retrivedCompanyUserMaster
                            .getUsrStat().trim().equals(
                                    "E")) {
                retrivedUserAccountModel = new UserAccountModel();
                retrivedUserAccountModel
                        .setUserCompanyAccountID(retrivedCompanyUserMaster
                                .getComp_id().getAcctId());
                retrivedUserAccountModel
                        .setUserID(retrivedCompanyUserMaster
                                .getComp_id().getUsrId());
                retrivedUserAccountModel
                        .setUserEmail(retrivedCompanyUserMaster
                                .getUsrEmail());
                retrivedUserAccountModel
                        .setUserFirstName(retrivedCompanyUserMaster
                                .getFirstName());
                retrivedUserAccountModel
                        .setUserGroupID(retrivedCompanyUserMaster
                                .getGrpId());
                retrivedUserAccountModel
                        .setUserLastName(retrivedCompanyUserMaster
                                .getLastName());
                retrivedUserAccountModel
                        .setUserNotes(retrivedCompanyUserMaster
                                .getNotes1());
                retrivedUserAccountModel
                        .setUserPassword(retrivedCompanyUserMaster
                                .getPasswd());
                retrivedUserAccountModel
                        .setUserReminderPhrase(retrivedCompanyUserMaster
                                .getReminderPhrase());
                retrivedUserAccountModel
                        .setUserRoleID(""
                                + retrivedCompanyUserMaster
                                        .getActvRolMa().getActvRolId());
                retrivedUserAccountModel
                        .setUserStartFlag(retrivedCompanyUserMaster
                                .getStartFlg());
                retrivedUserAccountModel
                        .setUserStatus(retrivedCompanyUserMaster
                                .getUsrStat());
            }
        }
        catch (DataRetrievalFailureException e) {
            throw new DataNotFoundException(
                    "companyuserbean.getCompanyUser.failurereason", e);
        }

        return retrivedUserAccountModel;
    }

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
            throws DataSaveException {
        try {
            // making user key
            CompanyUserMasterKey companyUserMasterKey = new
            CompanyUserMasterKey(
                    updateuserAccount
                            .getUserCompanyAccountID(), updateuserAccount
                            .getUserID());
            // retriving the record
            CompanyUserMaster companyUserMaster = (CompanyUserMaster)
            userAccountDAO.retriveUser(companyUserMasterKey);
            // setting the roleID and startFlag.
            updateuserAccount
                    .setUserStartFlag(companyUserMaster
                            .getStartFlg());
            updateuserAccount
                    .setUserRoleID(""
                            + companyUserMaster
                                    .getActvRolMa().getActvRolId());
            Integer accountStat=companyUserMaster.getAcctLocked();
            if(accountStat==null)
            {
                updateuserAccount.setUserAccountLockedStatus("0");
            }
            else
            {
               updateuserAccount.setUserAccountLockedStatus(""+
                    companyUserMaster.getAcctLocked());
            }
            // making corresponding user hibernate object.
            companyUserMaster = makeUserAccountObject(updateuserAccount);
            // updating the table object
            userAccountDAO
                    .updateUser(companyUserMaster);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataSaveException(
                    "", e);
        }

    }

    /**
     * it moves the user from one group to another
     *
     * @param accountId
     *        the accountId of the user to be moved
     * @param grpId
     *       the group Id of the user to be moved
     * @param selectedGroupId
     *        the group Id selected to which the user has to be moved
     * @throws DataMoveException
     *         exception thrown if the move operation is not successfull
     */

    public void moveUser(
            String accountId, String usrId, String grpId,
            String selectedGroupId) throws DataMoveException{

        HQLSearch hqlsearch = (HQLSearch) appCtxt
                .getBean("hqlSearch");
        HashMap placeHolders = new HashMap();
        List userIdList = new ArrayList();
        placeHolders
                .put(
                        "ACCTID", accountId);
        placeHolders
                .put(
                        "GRPID", grpId);
        placeHolders
                .put(
                        "USRID", usrId);
        try {
            List resultList = hqlsearch
                    .search(
                            "MoveGroupUsersQueryKey", placeHolders);
            System.out
                    .println("list of user id's"
                            + resultList);
            Iterator userIterator = resultList
                    .iterator();
            while (userIterator
                    .hasNext()) {
                CompanyUserMaster companyUserMaster = (CompanyUserMaster)
                userIterator.next();
                userIdList
                        .add(companyUserMaster
                                .getComp_id().getUsrId());
            }

        userAccountDAO
                .saveMoveUsers(
                        accountId, grpId, usrId, selectedGroupId, userIdList);
        }
        catch (DataIntegrityViolationException ex) {
            throw new DataMoveException(
                    "user.movegroupusers.failurereason", ex);
        }
        catch (DataNotFoundException ex)
        {
            throw new DataMoveException(
                    "user.movegroupusers.failurereason", ex);
        }
    }

    /**
     * To find Groups matching the criteria.
     *
     * @param companyGroups full list of groups to be parsed.
     * @param groupID  criteria to be matched.
     * @return sortedset containing the list of groups.
     */
    private SortedSet usersCriteria(
            Collection companyUsers, String userName) {
        SortedSet matchingUsersList = null;
        Iterator companyUsersIterator = companyUsers
                .iterator();
        int breakApart = userName
                .indexOf(' ');
        String matchFirstName = userName;
        String matchLastName = null;
        if (breakApart != -1) {
            matchFirstName = userName
                    .substring(
                            0, breakApart);
            matchFirstName = matchFirstName
                    .trim();
            matchLastName = userName
                    .substring(breakApart);
            matchLastName = matchLastName
                    .trim();
        }
        while (companyUsersIterator
                .hasNext()) {
            CompanyUserMaster companyUserMaster = (CompanyUserMaster)
            companyUsersIterator.next();
            String matchUserFirstName = companyUserMaster
                    .getFirstName().trim();
            Pattern patternUserFirstName = Pattern
                    .compile(
                            matchFirstName
                                    .trim(), Pattern.CASE_INSENSITIVE);
            Matcher matchingUserFirstName = patternUserFirstName
                    .matcher(matchUserFirstName);
            boolean matchLastNameResult = true;
            if (matchLastName != null
                    && !""
                            .equals(matchLastName)) {
                String matchUserLastName = companyUserMaster
                        .getLastName().trim();
                Pattern patternUserLastName = Pattern
                        .compile(
                                matchLastName
                                        .trim(), Pattern.CASE_INSENSITIVE);
                Matcher matchingUserLastName = patternUserLastName
                        .matcher(matchUserLastName);
                matchLastNameResult = matchingUserLastName
                        .matches();
            }

            if (matchingUserFirstName
                    .matches()
                    && matchLastNameResult) {
                if (matchingUsersList == null) {
                    matchingUsersList = new TreeSet(
                            new CompareUserName());
                }
                matchingUsersList
                        .add(companyUserMaster);
            }
        }
        return matchingUsersList;
    }

    /**
     * This method saves information related to a specified user.
     *
     * @param userAccountModel
     * @return messages
     */
    public ActionMessages createUser(
            Collection userDetail) {

        HQLSearch hqlsearch = (HQLSearch) appCtxt
                .getBean("hqlSearch");
        ActionMessages messages = new ActionMessages();
        List resultList;
        HashMap placeHolders = new HashMap();
        Iterator userItr = userDetail
                .iterator();
        while (userItr
                .hasNext()) {
            UserAccountModel userAccountModel = (UserAccountModel) userItr
                    .next();

            String acctId = userAccountModel
                    .getUserCompanyAccountID();
            String grpId = userAccountModel
                    .getUserGroupID();
            String usrId = userAccountModel
                    .getUserID();

            // creating a record
            CompanyUserMaster newUserRecord = makeUserAccountObject(
                    userAccountModel);

            try {
                // saving the record

                userAccountDAO
                        .saveUser(newUserRecord);
            }
            catch (Exception e) {
                placeHolders
                        .put(
                                "ACCTID", acctId);
                placeHolders
                        .put(
                                "USRID", usrId);
                try {
                    resultList = hqlsearch
                            .search(
                                    "CountCompanyUserMasterQuery",
                                    placeHolders);
                    Integer intCount = (Integer) resultList
                            .get(0);
                    int count = intCount
                            .intValue();
                    if (count > 0) {
                        log
                                .info("User already exist for ACCOUNTID:"
                                        + "" + acctId + "and USERID" + usrId);
                        messages
                                .add(
                                        ActionMessages.GLOBAL_MESSAGE,
                                        new ActionMessage(
                                                ""));
                    }
                }
                catch (Exception ex) {
                    log
                            .info("User cannot be created for AccountID :"
                                    + acctId + ",GROUPID:" + grpId
                                    + "and USERID:" + usrId);
                    messages
                            .add(
                                    ActionMessages.GLOBAL_MESSAGE,
                                    new ActionMessage(
                                            ""));
                }

            }
        }

        return messages;
    }

    /**
     * This method is used to retrive users matching the given userID,groupID
     * and accountID
     *
     * @param accountID
     *            accoundID of(selected by) the user to know which groups it
     *            can. see.
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
            throws DataNotFoundException {
        // retriving the whole set
        Set userAccountSet = new HashSet(
                userAccountDAO
                        .getAllUsersOfGroup(
                                accountID, groupID));
        SortedSet companyUsers = new TreeSet(
                new CompareUserName());
        companyUsers
                .addAll(userAccountSet);
        // matching the groupID
        if (userName != null) {
            userName= userName+"*";
            userName = userName
                    .replace(
                            '?', '.');
            userName = userName
                    .replace(
                            '*', '#');
            userName = userName
                    .replaceAll(
                            "#", ".*");
            companyUsers = usersCriteria(
                    userAccountSet, userName);
        }
        if (companyUsers == null) {
            throw new DataNotFoundException(
                    "error.searchNotFound");
        }
        int size=IConstants.SearchResultSize;
        int maxPages = (int) Math
                .ceil((((float) companyUsers
                        .size()) /(float)size));
        int startPos = size * page;
        if (startPos > companyUsers
                .size()) {
            page = (companyUsers
                    .size()) / size;
            startPos = size * page;
        }
        int endPos = size * (page + 1);
        if (endPos > companyUsers
                .size()) {
            endPos = companyUsers
                    .size();
        }
        // trimming down to page size
        if (startPos < endPos) {

            CompanyUserMaster lastcompanyUserMaster = (CompanyUserMaster
                    ) companyUsers.last();
            String lastUserId = lastcompanyUserMaster
                    .getComp_id().getUsrId().trim();
            String lastUserLastName = lastcompanyUserMaster
                    .getLastName().trim();
            String lastUserFirstName = lastcompanyUserMaster
                    .getFirstName().trim();
            if (""
                    .equals(lastUserId)) {
                lastUserId = lastcompanyUserMaster
                        .getComp_id().getUsrId();
            }
            if (""
                    .equals(lastUserLastName)) {
                lastUserLastName = lastcompanyUserMaster
                        .getLastName();
            }
            if (""
                    .equals(lastUserFirstName)) {
                lastUserFirstName = lastcompanyUserMaster
                        .getFirstName();
            }
            lastUserId = lastUserId
                    + "12345";
            lastUserLastName = lastUserLastName
                    + "12345";
            lastUserFirstName = lastUserFirstName
                    + "12345";
            CompanyUserMaster companyUserMaster = new CompanyUserMaster();
            CompanyUserMasterKey companyUserMasterKey = new
            CompanyUserMasterKey();
            companyUserMasterKey
                    .setUsrId(lastUserId);
            companyUserMaster
                    .setComp_id(companyUserMasterKey);
            companyUserMaster
                    .setFirstName(lastUserFirstName);
            companyUserMaster
                    .setLastName(lastUserLastName);
            companyUsers
                    .add(companyUserMaster);

            Object[] arryOfSet = companyUsers
                    .toArray();
            companyUsers = companyUsers
                    .tailSet(arryOfSet[startPos]);
            companyUsers = companyUsers
                    .headSet(arryOfSet[endPos]);
        }
        Map resultMap = new HashMap();
        resultMap
                .put(
                        "resultList", companyUsers);
        resultMap
                .put(
                        "maxPages", ""
                                + maxPages);
        return resultMap;

    }

    /**
     * function to change the status of User account.
     *
     * @param userAccountModel
     *            user modal containing the record of the user to be updated.
     * @exception DataSaveException,
     *          if there is some error related to the data to be updated.
     */
    public void enableDisableUserAccount(
            UserAccountModel enableDisableUser)
            throws DataSaveException {
        CompanyUserMaster companyUserMaster = makeUserAccountObject(
                enableDisableUser);

        try {
            companyUserMaster = (CompanyUserMaster) userAccountDAO
                    .retriveUser(companyUserMaster
                            .getComp_id());

            if ("D"
                    .equals(companyUserMaster
                            .getUsrStat().trim())) {
                companyUserMaster
                        .setUsrStat("E");
            } else {
                companyUserMaster
                        .setUsrStat("D");
            }

            userAccountDAO
                    .updateUser(companyUserMaster);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataSaveException(
                    "companyuserbean.edit.failurereason", e);
        }
    }

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
            throws DataNotFoundException {
        HQLSearch hqlsearch = (HQLSearch) appCtxt
                .getBean("hqlSearch");
        List finalUserList = new ArrayList();

        try {
            List resultList;
            List companyList = new ArrayList();
            HashMap placeHolders = new HashMap();
            placeHolders
                    .put(
                            "ACCTID", acctId);
            placeHolders
                    .put(
                            "GRPID", groupId);
            resultList = hqlsearch
                    .search(
                            "UserMasterQueryKey", placeHolders);
            if (resultList
                    .size() > 0) {
                Integer listCount = (Integer) resultList
                        .get(0);
                int count = listCount
                        .intValue();
                if (count > 0) {
                    CompanyAcctMaster companyAcctMaster = companyAccountDAO
                            .getAllDetailsOfCompany(acctId);
                    companyList
                            .add(companyAcctMaster);

                }
            }
            Iterator companyIterator = companyList
                    .iterator();
            while (companyIterator
                    .hasNext()) {

                CompanyAcctMaster companyAcctMaster = (
                        CompanyAcctMaster) companyIterator.next();
                Set companyGroupMasterSet = companyAcctMaster
                        .getCoGrpMas();
                Set newGroups = new HashSet();
                Iterator companyGroupMasterIterator = companyGroupMasterSet
                        .iterator();
                while (companyGroupMasterIterator
                        .hasNext()) {
                    CompanyGroupMaster companyGroupMaster = (CompanyGroupMaster
                            ) companyGroupMasterIterator.next();
                    if (groupId
                            .equalsIgnoreCase(companyGroupMaster
                                    .getComp_id().getGrpId().trim())) {
                        Set companyUserMasterSet = companyGroupMaster
                                .getCoUsrMas();
                        Iterator companyUserMasterIterator =
                        companyUserMasterSet
                                .iterator();
                        Set newcompanyUserMasterSet = new HashSet();
                        while (companyUserMasterIterator
                                .hasNext()) {
                            CompanyUserMaster companyUserMaster = (
                                    CompanyUserMaster) companyUserMasterIterator
                                    .next();
                            if (acctId
                                    .equalsIgnoreCase(companyUserMaster
                                            .getComp_id().getAcctId().trim())
                                    && groupId
                                            .equalsIgnoreCase(companyUserMaster
                                                    .getGrpId().trim())
                                    && companyUserMaster
                                            .getUsrStat().trim()
                                            .equalsIgnoreCase(
                                                    "D")) {
                                newcompanyUserMasterSet
                                        .add(companyUserMaster);

                            }
                        }
                        if (newcompanyUserMasterSet
                                .size() > 0) {
                            companyGroupMaster
                                    .setCoUsrMas(newcompanyUserMasterSet);
                        } else {
                            companyGroupMaster
                                    .setCoUsrMas(null);
                        }
                        newGroups
                                .add(companyGroupMaster);
                    }

                }
                companyAcctMaster
                        .setCoGrpMas(newGroups);
                finalUserList
                        .add(companyAcctMaster);
            }
        }
        catch (Exception ex) {
            throw new DataNotFoundException(
                    "error.disable.group.list",
                    ex);
        }
        return finalUserList;
    }

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
            throws DataDeleteException {
        try {
            userAccountDAO
                    .deleteSelectedUser(
                            accountId, userIds);
        }
        catch (DataAccessException ex) {
            throw new DataDeleteException(
                    "error.delete.user", ex);
        }
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
}
