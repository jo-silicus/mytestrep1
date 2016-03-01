/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : sharmrahu
 * @date : Aug 2, 2006
 * @version:
 * @history Implementation class used to insert, retrive, update data in the
 *          GrompManagerMaster table also updates the userMaster table
 */

package com.mgmtassessment.execmap.data.daoimpl;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mgmtassessment.execmap.business.model.GroupAccountModel;
import com.mgmtassessment.execmap.data.dao.types.CompanyAcctMaster;
import com.mgmtassessment.execmap.data.dao.types.CompanyGroupMaster;
import com.mgmtassessment.execmap.data.dao.types.CompanyGroupMasterKey;
import com.mgmtassessment.execmap.data.dao.types.CompanyUserMaster;
import com.mgmtassessment.execmap.data.dao.types.CompanyUserMasterKey;
import com.mgmtassessment.execmap.data.daoapi.GroupAccountDAO;

/**
 * Implementation class used to insert, retrive, update data in the
 * GrompManagerMaster table also updates the userMaster table.
 *
 * @author sharmrahu
 */
public class GroupAccountDAOImpl extends HibernateDaoSupport implements
        GroupAccountDAO {

    /**
     * template that is used throughout to perform all inset,update retrive etc.
     */
    private HibernateTemplate hibernateTemplate = null;

    /**
     * To save a new group record.
     *
     * @param object group object to be saved.
     */
    public void saveGroup(Object object) {

        try {
            // saving the data
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
     * To update a given group record.
     *
     * @param object group object to be updated.
     */
    public void updateGroup(Object object) {

        try {
            // updating the data
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
     * To retrive a perticular group.
     *
     * @param keyID group key against which record has to be retrieved.
     * @return Object group's retrieved record.
     */
    public Object retriveGroup(Serializable keyID) {

        Object object = null;
        try {
            // retriving the data belonging to a perticular group
            hibernateTemplate = getHibernateTemplate();
            object = hibernateTemplate.get(CompanyGroupMaster.class, keyID);

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

    /**
     * Returns a perticular user- used to get group manager record.
     *
     * @param groupAccountModel group record whose manager is required.
     * @return Object user object of the group manager.
     */
    public Object retriveManager(GroupAccountModel groupAccountModel) {

        Object object = null;
        try {
            // Key Object to know about the group Manager
            CompanyUserMasterKey companyUserMasterKey = new
            CompanyUserMasterKey(
                    groupAccountModel.getCompanyAccountID(), groupAccountModel
                            .getUserID());
            // retriving the record from company usermaster
            hibernateTemplate = getHibernateTemplate();
            object = hibernateTemplate.get(CompanyUserMaster.class,
                    companyUserMasterKey);

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

    /**
     * this method is used to delete the selected groups.
     *
     * @param accountId
     *         accountId for the group to be deleted
     * @param grpIds
     *        group Id's for the selected groups that are to be deleted
     * @exception DataRetrievalFailureException
     *       exception thrown if group can't be deleted
     */
    public void deleteGroups(String accountId, String[] grpIds) throws DataRetrievalFailureException {

            for (int i = 0; i <= (grpIds.length) - 1; i++)
            {
                String grpId = grpIds[i];
                System.out.println("" + grpId);
                CompanyGroupMasterKey companyGroupMasterKey = new
                CompanyGroupMasterKey(
                        accountId, grpId);
                CompanyGroupMaster companyGroupMaster = (CompanyGroupMaster)
                getHibernateTemplate()
                        .get(CompanyGroupMaster.class, companyGroupMasterKey);
                CompanyUserMaster companyUserObject = null;
                Set companyUserMasterSet = new HashSet();
                Set companyGroupMasterSet = new HashSet();
                Hibernate.initialize(companyGroupMaster.getCoUsrMas());
                Collection companyUsersData = companyGroupMaster.getCoUsrMas();
                Iterator companyUsersDataIterator = companyUsersData.iterator();
                while (companyUsersDataIterator.hasNext()) {
                    companyUserObject = (CompanyUserMaster
                            ) companyUsersDataIterator.next();
                    companyUserMasterSet.add(companyUserObject);

                }
                companyGroupMaster.setCoUsrMas(companyUserMasterSet);
                //companyGroupMaster.setGroupManagerId(null);
                hibernateTemplate = getHibernateTemplate();
                hibernateTemplate.saveOrUpdate(companyGroupMaster);
                hibernateTemplate.flush();
                companyGroupMasterSet.add(companyGroupMaster);

                hibernateTemplate = getHibernateTemplate();
                hibernateTemplate.delete(companyGroupMaster);
            }


    }

    /**
     * Returns the list of groups of a perticular company.
     *
     * @param acctId account ID for which groups are retrieved.
     * @return Set conating all groups of a company.
     */
    public Set getAllGroupsOfCompany(String acctId) {
        CompanyAcctMaster companyAcctMaster = (
                CompanyAcctMaster) getHibernateTemplate()
                .get(CompanyAcctMaster.class, acctId);
        if (companyAcctMaster != null) {

            Hibernate.initialize(companyAcctMaster.getCoGrpMas());

        }
        return companyAcctMaster.getCoGrpMas();
    }
    /**
     * Returns the list of all users within a group.
     *
     * @param acctID account ID for which users are retrieved.
     * @param groupID group ID for which users are retrieved.
     * @return Set conating the list of users.
     */
    public Set getAllUsersOfGroup(String acctID, String groupID) {
        CompanyGroupMasterKey companyGroupMasterKey = new CompanyGroupMasterKey(
                acctID, groupID);
        CompanyGroupMaster companyGroupMaster = (
                CompanyGroupMaster) getHibernateTemplate()
                .get(CompanyGroupMaster.class, companyGroupMasterKey);
        if (companyGroupMaster != null) {

            Hibernate.initialize(companyGroupMaster.getCoUsrMas());

        }
        return companyGroupMaster.getCoUsrMas();
    }
}
