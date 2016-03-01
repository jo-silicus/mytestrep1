/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : DasAshim
 * @date : Jul 24, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.business.api.company;

import java.util.Collection;
import java.util.Map;

import com.mgmtassessment.execmap.business.model.CompanyAccountModel;
import com.mgmtassessment.execmap.common.exceptions.DataCreateException;
import com.mgmtassessment.execmap.common.exceptions.DataDeleteException;
import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;
import com.mgmtassessment.execmap.common.exceptions.DataSaveException;
import com.mgmtassessment.execmap.common.exceptions.EmailException;
import com.mgmtassessment.execmap.common.framework.business.AbstractFacade;
import com.mgmtassessment.execmap.data.dao.types.CompanyAcctMaster;

/**
 * CompanyManagerFacade provides an interface to all the company related
 * transactions like creating new company , view the company details and edit
 * the company details.
 */

public interface CompanyManagerFacade extends AbstractFacade {

    /**
     * This method saves Company Account Information.
     *
     * @param  coAcctModel
     * @throws DataCreateException,EmailException
     */

    public void saveCompany(CompanyAccountModel coAcctModel)
            throws DataCreateException,EmailException;

    /**
     * Fetches the Company Account Information for an Account Id.
     *
     * @param acctid
     * @return CompanyAccountModel
     * @throws DataNotFoundException
     */
    public CompanyAccountModel viewCompanyDetails(String acctid)
            throws DataNotFoundException;

    /**
     * This method updates Company Account Information
     *
     * @param coAcctModel
     * @throws DataSaveException
     *
     */

    public void updateCompany(CompanyAccountModel coAcctModel)
            throws DataSaveException,EmailException;

    /**
     * This method handles the enable and disable of the company.
     *
     * @param acctId
     * @throws DataSaveException
     */
    public void enableDisableCompany(String acctId) throws DataCreateException;

    /**
     * This methos delete the disable company.
     *
     * @param acctId
     * @throws DataDeleteException
     */
    public void deleteCompany(String[] acctIds) throws DataDeleteException;

    /**
     * This method return a collection of all disabled companies
     *
     * @return Collection of Disable Companies
     * @throws DataNotFoundException
     */
    public Collection showDisableCompanies()throws DataNotFoundException ;

    /**
     * This method is responsible for retriving the list of compaines that are
     * matching the search criteria, made by company name or accountId.
     *
     * @param companyName ,
     *            criteria agains which the search works.
     * @param accountId ,
     *            accoundID of the user to know which company it can see.
     * @param page,
     *            implements paging of records.
     * @return Map containing the companies and a maximum page cout.
     * @exception DataNotFoundException
     *                if nothing matching is found.
     */
    public Map getListOfCompanies(String companyName, String accountId,
            int page) throws DataNotFoundException;

    /**
     * calls the companyaccountdao getAllDetailsOfCompany method
     *
     * @param acctId
     */
    public CompanyAcctMaster getAllDetailsOfCompany(String acctId);
}
