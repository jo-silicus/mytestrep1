/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : AhmedZia
 * @date : Aug 1, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.data.daoapi;

import java.util.Collection;

import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;
import com.mgmtassessment.execmap.data.dao.types.AcctMaster;
import com.mgmtassessment.execmap.data.dao.types.CompanyAcctMaster;

/**
 * CompanyAccountDAO provides an interface to create,edit and view the company
 * details.
 */

public interface CompanyAccountDAO {

    /**
     * saveCompany method to save the CompanyAcctMaster object.
     */

    public void saveCompany(Object object);

    /**
     * getcompanyDetails method to get a CompanyAcctMaster initialized object.
     *
     * @param acctId
     * @return CompanyAcctMaster Object
     */

    public CompanyAcctMaster getCompanyDetails(
            String acctid)throws DataNotFoundException;

    /**
     * This method returns the Account Master Detail.
     *
     * @param acctId
     * @return AcctMaster object
     */
    public AcctMaster getAcctMasterDetail(String acctId);

    /**
     * @return last account no from ExecmapSysMa table
     */
    public int getLastAccount();

    /**
     * @param lastAcctId
     */
    public void updateLastAccountId(Integer lastAcctId);

    /**
     * @param acctId
     */
    public void deleteCompanyDetails(String[] acctIds);

    /**
     * get all details of a company.
     *
     * @param acctId
     * @return CompanyAcctMaster
     */
    public CompanyAcctMaster getAllDetailsOfCompany(String acctId);

    /**
     * saveCompany method to save the CompanyAcctMaster object.
     * 
     * @param object
     */

    public void updateCompany(Object object);

}
