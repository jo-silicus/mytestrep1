/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : AhmedZia
 * @date : Aug 1, 2006
 * @version:
 *
 * @history Description Reference Name Date
 *
 */

package com.mgmtassessment.execmap.data.daoimpl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;
import com.mgmtassessment.execmap.data.dao.types.AcctMaster;
import com.mgmtassessment.execmap.data.dao.types.CompanyAcctMaster;
import com.mgmtassessment.execmap.data.dao.types.CompanyGroupMaster;
import com.mgmtassessment.execmap.data.dao.types.CompanyUserMaster;
import com.mgmtassessment.execmap.data.daoapi.CompanyAccountDAO;
import com.mgmtassessment.execmap.data.daoapi.UserAccountDAO;

/**
 * CompanyAccountDAOImpl implement the interface CompanyAccountDAO and perform
 * all the hibernate related save,update and view of the company details.
 *
 */

public class CompanyAccountDAOImpl extends HibernateDaoSupport implements
        CompanyAccountDAO {

    /**
     * Initialize hibernateTemplate object to call save,
     * update or delete methods of hibernate.
     */
    HibernateTemplate hibernateTemplate = null;

    /**
     * Initialize userAccountDAO  object to call getManager method.
     */
    UserAccountDAO userAccountDAO;


    /**
     * @return Returns the userAccountDAO.
     */
    public UserAccountDAO getUserAccountDAO() {
        return userAccountDAO;
    }

    /**
     * @param userAccountDAO The userAccountDAO to set.
     */
    public void setUserAccountDAO(
            UserAccountDAO userAccountDAO) {
        this.userAccountDAO = userAccountDAO;
    }

    /**
     * This method calls the hibernate saveOrUpdate method to create and update
     * the company related details.
     *
     * @param object
     */
    public void saveCompany(Object object) {

            hibernateTemplate = getHibernateTemplate();
            hibernateTemplate.saveOrUpdate(object);
            hibernateTemplate.flush();

    }

    /**
     * This method calls the hibernate saveOrUpdate method to create and update
     * the company related details.
     *
     * @param object
     */
    public void updateCompany(Object object) {

            hibernateTemplate = getHibernateTemplate();
            hibernateTemplate.getSessionFactory().getCurrentSession().clear();
            hibernateTemplate.saveOrUpdate(object);
            hibernateTemplate.flush();


    }
    /**
     * This method returns the details related to the Company as well as Company
     * Manager.
     *
     * @param acctId
     * @return companyAcctMaster
     */
    public CompanyAcctMaster getCompanyDetails(
            String acctId)throws DataNotFoundException {

        CompanyAcctMaster companyAcctMaster =
            (CompanyAcctMaster) getHibernateTemplate()
                .get(CompanyAcctMaster.class, acctId);
        CompanyUserMaster companyUserObject = null;

        Hibernate.initialize(companyAcctMaster.getCoGrpMas());
        Collection companyGroupData = companyAcctMaster.getCoGrpMas();
       companyUserObject = (CompanyUserMaster)userAccountDAO.getCompanyManager(acctId);
            Set companyGroupMasterSet = new HashSet();
            companyAcctMaster.setCoUsrMa(companyUserObject);
            companyAcctMaster.setCoGrpMas(companyGroupMasterSet);

        return companyAcctMaster;
    }



    /**
     * This method returns the Account Master detail for
     * the account Id passed as an argument.
     *
     * @param acctId
     * @return accMaster
     */
    public AcctMaster getAcctMasterDetail(String acctId) {

        AcctMaster acctMaster = (AcctMaster)getHibernateTemplate().get(
                AcctMaster.class, acctId);

        Hibernate.initialize(acctMaster.getCoAcctMa());
        CompanyAcctMaster companyAcctMaster = acctMaster.getCoAcctMa();
        acctMaster.setCoAcctMa(companyAcctMaster);
        return acctMaster;

    }

    public void deleteCompanyDetails(String[] Id) {

        try {
            for (int i = 0; i < (Id.length); i++) {
                String acctId = Id[i];
                AcctMaster acctMaster = (AcctMaster)getHibernateTemplate()
                        .load(AcctMaster.class, acctId);
                CompanyAcctMaster companyAcctMaster =
                    (CompanyAcctMaster)getHibernateTemplate()
                        .get(CompanyAcctMaster.class, acctId);
                CompanyUserMaster companyUserObject = null;
                Set companyUserMasterSet = new HashSet();
                Set companyGroupMasterSet = new HashSet();

                Hibernate.initialize(companyAcctMaster.getCoGrpMas());
                Collection companyGroupData = companyAcctMaster.getCoGrpMas();
                Iterator companyGroupDataIterator = companyGroupData.iterator();

                while (companyGroupDataIterator.hasNext()) {
                    CompanyGroupMaster companyGroup =
                        (CompanyGroupMaster)companyGroupDataIterator
                            .next();
                    Hibernate.initialize(companyGroup.getCoUsrMas());
                    Collection companyUsersData = companyGroup.getCoUsrMas();
                    Iterator companyUsersDataIterator = companyUsersData
                            .iterator();
                    while (companyUsersDataIterator.hasNext()) {
                        companyUserObject =
                            (CompanyUserMaster)companyUsersDataIterator
                                .next();
                        companyUserMasterSet.add(companyUserObject);

                    }
                    companyGroup.setCoUsrMas(companyUserMasterSet);
                    companyGroupMasterSet.add(companyGroup);

                }
                companyAcctMaster.setCoGrpMas(companyGroupMasterSet);
                acctMaster.setCoAcctMa(companyAcctMaster);
                hibernateTemplate = getHibernateTemplate();
                hibernateTemplate.delete(acctMaster);

            }
        }
        catch (DataAccessException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method returns the last account number
     * from intellicueSysMa table.
     *
     * @return lastAccountno.
     */
    public int getLastAccount() {

        List lst = null;

        lst = getHibernateTemplate().find(
                "Select lstAcctNo from ExecmapSysMaster");
        return new Integer(lst.get(0).toString()).intValue();

    }

    /**
     * This method updates the Last account number
     * after generating account number for the company.
     *
     * @param lastAcctId
     */
    public void updateLastAccountId(Integer lastAcctId) {

        try {
            Session session = SessionFactoryUtils.getSession(
                    getSessionFactory(), false);
            Transaction tx = session.beginTransaction();

            String hqlUpdate = "update ExecmapSysMaster " +
                    "set lstAcctNo= :lastAcctId";
            session.createQuery(hqlUpdate).setString("lastAcctId",
                    lastAcctId.toString()).executeUpdate();
            tx.commit();
        }
        catch (DataAccessResourceFailureException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (HibernateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * Get all the details of a company manager with company details.
     *
     * @param acctId
     * @return CompanyAcctMaster
     */
    public CompanyAcctMaster getAllDetailsOfCompany(String acctId) {
        CompanyAcctMaster companyAcctMaster =
            (CompanyAcctMaster)getHibernateTemplate()
                .get(CompanyAcctMaster.class, acctId);
        if (companyAcctMaster != null) {

            Hibernate.initialize(companyAcctMaster.getCoGrpMas());
            Collection companyGroups = companyAcctMaster.getCoGrpMas();
            Iterator iteratorCompanyGroups = companyGroups.iterator();
            while (iteratorCompanyGroups.hasNext()) {
                CompanyGroupMaster newCompanyGroup =
                    (CompanyGroupMaster)iteratorCompanyGroups
                        .next();
                Hibernate.initialize(newCompanyGroup.getCoUsrMas());
                Collection companyusers = newCompanyGroup.getCoUsrMas();
                Iterator iteratorCompanyusers = companyusers.iterator();
                while (iteratorCompanyusers.hasNext())

                {
                    CompanyUserMaster newCompanyuser =
                        (CompanyUserMaster)iteratorCompanyusers
                            .next();

                }
            }

        }
        return companyAcctMaster;
    }

}
