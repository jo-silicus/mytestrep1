/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : sharmrahu
 * @date : Oct 11, 2006
 * @version:
 * @history Implementation class used to insert, retrive, update data in the
 *          UserMaster table.
 */

package com.mgmtassessment.execmap.data.daoimpl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;
import com.mgmtassessment.execmap.data.dao.types.ActvRolMaster;
import com.mgmtassessment.execmap.data.dao.types.CompanyUserMaster;
import com.mgmtassessment.execmap.data.dao.types.CompanyUserMasterKey;
import com.mgmtassessment.execmap.data.daoapi.UserAccountDAO;

/**
 * Implementation class used to insert, retrive, update data in the UserMaster
 * table.
 *
 * @author sharmrahu
 */
public class UserAccountDAOImpl extends HibernateDaoSupport implements
        UserAccountDAO {
    /**
     * template that is used throughout to perform all insert,update retrive
     * etc.
     */
    private HibernateTemplate hibernateTemplate = null;

    /**
     * To save a new user record.
     *
     * @param object user object to be saved.
     */
    public void saveUser(Object object) {
        try {
            // saving the user
            hibernateTemplate = getHibernateTemplate();
            hibernateTemplate.save(object);
            hibernateTemplate.flush();
        }
        catch (DataAccessResourceFailureException e) {

            e.printStackTrace();
        }
        catch (HibernateException e) {

            e.printStackTrace();
        }
        catch (IllegalStateException e) {

            e.printStackTrace();
        }
    }

    /**
     * To update a given user record.
     *
     * @param object user object to be updated.
     */
    public void updateUser(Object object) {

        try {
            // updating the user
            hibernateTemplate = getHibernateTemplate();
            hibernateTemplate.getSessionFactory().getCurrentSession().clear();
            hibernateTemplate.update(object);
            hibernateTemplate.flush();
        }
        catch (DataAccessResourceFailureException e) {

            e.printStackTrace();
        }
        catch (HibernateException e) {

            e.printStackTrace();
        }
        catch (IllegalStateException e) {

            e.printStackTrace();
        }
    }

    /**
     * To retrive a perticular user.
     *
     * @param keyID user Key against which record has to be retrieved.
     * @return Object user object retrieved..
     */
    public Object retriveUser(Serializable keyID) {

        Object object = null;
        try {
            // retriving the data belonging to a perticular user
            hibernateTemplate = getHibernateTemplate();
            object = hibernateTemplate.get(CompanyUserMaster.class, keyID);

        }
        catch (DataAccessResourceFailureException e) {

            e.printStackTrace();
        }
        catch (HibernateException e) {

            e.printStackTrace();
        }
        catch (IllegalStateException e) {

            e.printStackTrace();
        }
        return object;
    }

    /**.
     * to save user to another group
     *
     * @param accountId
     *        the accountId of the user to be moved
     * @param grpId
     *       the group Id of the user to be moved
     * @param selectedGroupId
     *        the group Id selected to which the user has to be moved
     * @param userIdList
     *         all the users of the group
     * @return
     *
     */
    public void saveMoveUsers(String accountId, String grpId, String usrId,
            String selectedGroupId, List userIdList) {
        Iterator userIdListIterator = userIdList.iterator();
        while (userIdListIterator.hasNext()) {
            String userId = (String)
            userIdListIterator.next();
            CompanyUserMasterKey companyUserMasterKey =
                new CompanyUserMasterKey(
                    accountId, userId);
            CompanyUserMaster companyUserMaster =
                (CompanyUserMaster) getHibernateTemplate()
                    .get(CompanyUserMaster.class, companyUserMasterKey);
            if (companyUserMaster.getGrpId().trim().equalsIgnoreCase(grpId)
                    && companyUserMaster.getActvRolMa().
                    getActvRolId()
                    == (short)5
                    && companyUserMaster.getComp_id().getUsrId().trim()
                            .equalsIgnoreCase(usrId)) {
                System.out.println("Inside move user dao");
                companyUserMaster.setGrpId(selectedGroupId);
                getHibernateTemplate().update(companyUserMaster);
            }

        }
    }

    /**
     * Returns the list of users of a pericular group of a company.
     *
     * @param acctId account ID for uhich record has to be retrieved.
     * @param groupId group ID for uhich record has to be retrieved.
     * @return Collection conatining list of records.
     */
    public Collection getAllUsersOfGroup(String acctId, String groupId) {
        String parameters[] =
        {
                "acctId", "grpId","actvRolMa"
                };
        Object parameterValues[] = {
                acctId, groupId, new ActvRolMaster((short)5,"Company User")
                };
        List userList = getHibernateTemplate()
                .findByNamedParam(
                        "from CompanyUserMaster where comp_id.acctId " +
                        "= :acctId and grpId = :grpId and " +
                        "actvRolMa = :actvRolMa",
                        parameters, parameterValues);

        return userList;
    }

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
   public void deleteSelectedUser(String accountId, 
           String[] userIds) throws DataAccessException
    {
       for (int i = 0;i <= (userIds.length)-1 ; i++)
        {
            String usrId =
                userIds[i];
            hibernateTemplate = getHibernateTemplate();
            CompanyUserMasterKey companyUserMasterKey = new
            CompanyUserMasterKey(
                    accountId,usrId);
            CompanyUserMaster  companyUserMaster = (CompanyUserMaster
                    ) getHibernateTemplate().get(
                            CompanyUserMaster.class,
                            companyUserMasterKey);
                hibernateTemplate = getHibernateTemplate();
                hibernateTemplate.delete(companyUserMaster);
    }
    }
 /**
 * method that returns company manager record of a particular accountID.
 * @param accountID
 *              accountID of the company whose manager is to be retrieved.
 * @return Object,
 *              company user object retrived.
 * @exception
 *         DataNotFoundexception,
 *         if no record is found.
 */
   public Object getCompanyManager(
           String accountID)throws DataNotFoundException
   {
       String parameters[] = {
               "acctId","actvRolMa"
               };
       Object parameterValues[] = {
               accountID, new ActvRolMaster((short)2,"Company Manager")
               };
       List userList;
    try {
        userList = getHibernateTemplate()
                   .findByNamedParam(
                           "from CompanyUserMaster where comp_id.acctId " +
                           "= :acctId and " +
                           "actvRolMa = :actvRolMa",
                           parameters, parameterValues);
    }
    catch (DataAccessException e) {
        throw new DataNotFoundException("error.search",e);
    }

       return userList.get(0);
   }
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
   public Object getGroupManager(String accountID,
           String groupID)throws DataNotFoundException
   {
       String parameters[] = {
               "acctId", "grpId","actvRolMa"
               };
       Object parameterValues[] = {
               accountID, groupID, new ActvRolMaster((short)3,"Group Manager")
               };
       List userList;
    try {
        userList = getHibernateTemplate()
                   .findByNamedParam(
                           "from CompanyUserMaster where comp_id.acctId " +
                           "= :acctId and grpId = :grpId and " +
                           "actvRolMa = :actvRolMa",
                           parameters, parameterValues);
    }
    catch (DataAccessException e) {
       throw new DataNotFoundException("error.search",e);

    }

       return userList.get(0);
   }
}
