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

package com.mgmtassessment.execmap.data.daoimpl;

import java.util.HashMap;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;
import com.mgmtassessment.execmap.common.util.search.HQLSearch;
import com.mgmtassessment.execmap.data.dao.types.CompanyUserMaster;
import com.mgmtassessment.execmap.data.dao.types.CompanyUserMasterKey;
import com.mgmtassessment.execmap.data.daoapi.LoginDAO;

/**
 * LoginDAOImpl provide an implementation of LoginDAO
 * interface and it performs the functionality like changing
 * the users password and sending the mail containing
 * the password.
 *
 */

public class LoginDAOImpl extends HibernateDaoSupport implements LoginDAO {

    HibernateTemplate hibernateTemplate = null;

    /**
     * the hql search object.
     */
    private HQLSearch hqlsearch;

    /**.
     * Updates the password
     * @param acctId
     * @param usrId
     * @param pwd
     */
    public void updatePassword(String acctId, String usrId, String pwd) {

        try {

            CompanyUserMasterKey companyUserMasterKey =
                new CompanyUserMasterKey(
                    acctId, usrId);

            CompanyUserMaster companyUserMaster = 
                (CompanyUserMaster)getHibernateTemplate()
                    .get(CompanyUserMaster.class, companyUserMasterKey);

           companyUserMaster.setPasswd(pwd);

            hibernateTemplate = getHibernateTemplate();
            hibernateTemplate.saveOrUpdate(companyUserMaster);
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
     * this method returns the list from acct_mas table based on accountId
     @param accountId
     *        the accountId entered by the user
     * @return List
     *        returns a list containing user data
     *
     * * @throws DataNotFoundException
     *         exception thrown if no user exists for the data entered
     */
    public List getValidateUserList(String accountId)
    throws DataNotFoundException
    {
        List resultList = null;
        HashMap placeHolders = new HashMap();
        if (accountId != null) {
            placeHolders.put("ACCTID", accountId);
        }

              resultList = hqlsearch.search("ValidateUser",placeHolders);

        return resultList;

    }

    /**
     * this method returns the list from intellicue_sys_mass
     * table based on accountId, userId ,password
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
   public  List getValidateAdminList(String accountId ,
           String userId,String password) throws DataNotFoundException
    {
        List resultList = null;
        HashMap placeHolders = new HashMap();
        if (accountId != null) {
            placeHolders.put("ACCTID", accountId);
        }
        if (userId !=null) {
            placeHolders.put("USERID", userId);
        }
        if (password !=null){
            placeHolders.put("PASSWORD", password);
        }

            resultList = hqlsearch.search("ValidateAdmin",placeHolders);

        return resultList;
    }

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
  public List getValidateUserList(String accountId ,
          String userId,String password) throws DataNotFoundException
   {
       List resultList = null;
       HashMap placeHolders = new HashMap();
       if (accountId != null) {
           placeHolders.put("ACCTID", accountId);
       }
       if (userId !=null) {
           placeHolders.put("USERID", userId);
       }
       if (password !=null){
           placeHolders.put("PASSWORD", password);
       }

       resultList = hqlsearch.search("ValidateCompanyUser",placeHolders);

       return resultList;
   }

  /**
   * a class level method to find the group status of the user
   *
   * @param accountId
   *            the accountId entered by the user
   * @param UserId
   *            the userId entered by the user
   *
   * @return String
   *         enable disable status of the group
   * @throws DataNotFoundException
   *             exception thrown if group status is "D"
   */

   public String getGroupStatus (String accountId ,
           String userId) throws DataNotFoundException
   {
       List resultList;
       String group_Status = null ;
       HashMap placeHolders = new HashMap();
       if (accountId != null) {
           placeHolders.put("ACCTID", accountId);
       }
       if (userId !=null) {
           placeHolders.put("USERID", userId);
       }


      resultList = hqlsearch.search("GetGroupStatus",placeHolders);

      if(resultList.size() > 0)
      {
               group_Status = (String)resultList.get(0);
      }

       return group_Status ;

   }
   /**
    * method to find the lock status of  the user
    *
    * @param accountId
    *            the accountId entered by the user
    * @param UserId
    *          the userId entered by the user
     * @return String
    *         lock status of the user account
    * @throws DataNotFoundException
    *             exception thrown if group status is "D"
    */
   public List getlockStatus (String accountId ,
           String userId) throws DataNotFoundException
   {
       List resultList;
       int lock_Status  ;
       HashMap placeHolders = new HashMap();
       if (accountId != null) {
           placeHolders.put("ACCTID", accountId);
       }
       if (userId !=null) {
           placeHolders.put("USERID", userId);
       }


      resultList = hqlsearch.search("GetLockStatus",placeHolders);



    return resultList ;
   }

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
   public void updateAccountLock(String accountId, String userId,int count)
   {

       CompanyUserMasterKey companyUserMasterKey =
           new CompanyUserMasterKey(
                   accountId, userId);

       CompanyUserMaster companyUserMaster =
           (CompanyUserMaster)getHibernateTemplate()
               .get(CompanyUserMaster.class, companyUserMasterKey);

       companyUserMaster.setAcctLocked(new Integer(count));

       hibernateTemplate = getHibernateTemplate();
       hibernateTemplate.saveOrUpdate(companyUserMaster);
       hibernateTemplate.flush();
   }

/**.
 * @return Returns the hqlsearch.
 */
public HQLSearch getHqlsearch() {
    return hqlsearch;
}
/**
 * @param hqlsearch The hqlsearch to set.
 */
public void setHqlsearch(HQLSearch hqlsearch) {
    this.hqlsearch = hqlsearch;
}
}
