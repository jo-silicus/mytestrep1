/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : AhmedZia
 * @date : Aug 1, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.business.impl.company;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.mail.MailException;

import com.mgmtassessment.execmap.business.api.company.CompanyManagerFacade;
import com.mgmtassessment.execmap.business.impl.mail.MailWriterFacadeImpl;
import com.mgmtassessment.execmap.business.model.CompanyAccountModel;
import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.exceptions.DataCreateException;
import com.mgmtassessment.execmap.common.exceptions.DataDeleteException;
import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;
import com.mgmtassessment.execmap.common.exceptions.DataSaveException;
import com.mgmtassessment.execmap.common.exceptions.EmailException;
import com.mgmtassessment.execmap.common.framework.business.AbstractFacadeImpl;
import com.mgmtassessment.execmap.common.util.search.HQLSearch;
import com.mgmtassessment.execmap.data.dao.types.AcctMaster;
import com.mgmtassessment.execmap.data.dao.types.ActvRolMaster;
import com.mgmtassessment.execmap.data.dao.types.CompanyAcctMaster;
import com.mgmtassessment.execmap.data.dao.types.CompanyGroupMaster;
import com.mgmtassessment.execmap.data.dao.types.CompanyGroupMasterKey;
import com.mgmtassessment.execmap.data.dao.types.CompanyUserMaster;
import com.mgmtassessment.execmap.data.dao.types.CompanyUserMasterKey;
import com.mgmtassessment.execmap.data.dao.types.ReportMaster;
import com.mgmtassessment.execmap.data.daoapi.CompanyAccountDAO;
import com.mgmtassessment.execmap.data.daoapi.UserAccountDAO;

/**
 * CompanyManagerFacadeImpl class implements the methods provided by the
 * interface CompanyManagerFacade. This class executes all the company related
 * business like creating new company, view the existing company details and
 * editing of the company details.
 */

public class CompanyManagerFacadeImpl extends AbstractFacadeImpl implements
        CompanyManagerFacade {
    /** Log factory for this class. * */
    private static Log     log = LogFactory
                                       .getLog(CompanyManagerFacadeImpl.class);

    /**
     * Initialize the companyAccountDAO object in order to initialize the
     * companyAccountDAO bean.
     */
    CompanyAccountDAO  companyAccountDAO ;
    /**
     * Initialize the userAccountDAO object in order to initialize the
     * UserAccountDAO bean.
     */
    UserAccountDAO userAccountDAO;

    /**
     * Initialize the hqlsearch object in order to initialize the HQLSearch
     * bean.
     */
    HQLSearch  hqlsearch ;

    /**
     * Initialize the mailer object in order to
     * initialize the MailWriterFacadeImpl
     * bean.
     */
    MailWriterFacadeImpl   mailer ;

    /**
     * This method creates a new Company as well as Company Manager, Group
     * Manager and a TEST user.Company will have one DEFAULT GROUP as GENERAL
     * and the GENERAL group will have one default user whose userId and
     * password will TEST.
     * <p>
     * saveCompany will get the data from CompanyAccountModel which is being
     * populated by CompanyAccountForm.
     * <p>
     *
     * @param coAcctModel
     * @throws DataCreateException,EmailException
     */
    public void saveCompany(CompanyAccountModel coAcctModel)
            throws DataCreateException,EmailException {

        try {

            Set userDetail = new HashSet();
            Set groupDetail = new HashSet();

            int lastAcctNo = companyAccountDAO.getLastAccount();
            lastAcctNo++;
            String acctId = generateAccountid(lastAcctNo);
            Date date = new Date();

            CompanyUserMaster companyUserMaster = new CompanyUserMaster();

            CompanyAcctMaster companyAcctMaster = new CompanyAcctMaster();

            /** Account Master Details */
            AcctMaster acctMaster = new AcctMaster(acctId, "C", new Date());

            // Company User Master Key Detail
            CompanyUserMasterKey companyUserMasterKey =
                new CompanyUserMasterKey(
                    acctId, coAcctModel.getCompanyMgrUserId());

            if (log.isDebugEnabled())
                log.debug("Creating New Company Manager with " +
                        "Account Id : "
                        +lastAcctNo );

            /** Adding Company Manager Detail in Co_Usr_MA table*/
            companyUserMaster.setComp_id(companyUserMasterKey);
            companyUserMaster.setPasswd(coAcctModel.getCompanyMgrPasswd());
            companyUserMaster.setFirstName(coAcctModel
                    .getCompanyManagerFirstName());
            companyUserMaster.setLastName(coAcctModel
                    .getCompanyManagerLastName());
            companyUserMaster.setUsrEmail(coAcctModel.getCompanyEmail());
            companyUserMaster.setNotes1("Not provided");
            companyUserMaster.setNotes2("Not provided");
            companyUserMaster.setStartFlg("T");
            companyUserMaster.setUsrStat("E");
            companyUserMaster.setReminderPhrase(coAcctModel
                    .getCompanyPwdReminderPhrase());
            companyUserMaster.setAcctLocked(new Integer(
                    coAcctModel.getUserAccountLockedStatus()));

            Short actvRolId = new Short((short) 2);
            ActvRolMaster actvRolMaster = new ActvRolMaster(actvRolId,
                    "Company Manager");
            companyUserMaster.setActvRolMa(actvRolMaster);


            // Create Default Group Manager
           CompanyUserMaster companyUserMaster2=
               createDefaultGroupManager(coAcctModel,acctId);

            // Create Default TEST user under new company
           CompanyUserMaster companyUserMaster3 =
               createDefaultUser(coAcctModel, acctId);

            // making a usermaster Set
            userDetail.add(companyUserMaster);
            userDetail.add(companyUserMaster2);
            userDetail.add(companyUserMaster3);

            // Company Group Master Key Details
            CompanyGroupMasterKey companyGroupMasterKey =
                new CompanyGroupMasterKey(
                    acctId, "GENERAL");

           /** Creating GENERAL Group in Co_grp_mas */
            CompanyGroupMaster companyGroupMaster = new CompanyGroupMaster();
            companyGroupMaster.setComp_id(companyGroupMasterKey);
            companyGroupMaster.setGrpInfo("DEFAULT GROUP");
            companyGroupMaster.setGrpStat("E");
            companyUserMaster.setCoGrpMa(companyGroupMaster);
            companyUserMaster.setGrpId("GENERAL");

            companyGroupMaster.setCoUsrMa(companyUserMaster);
            companyGroupMaster.setCoUsrMas(userDetail);

            // Company Account Master Details
            companyAcctMaster.setAcctId(acctId);
            companyAcctMaster.setAcctTyp("C");
            companyAcctMaster.setAcctStat("E");
            companyAcctMaster.setCrtDt(new Date());
            companyAcctMaster.setCobraInfo(coAcctModel.getCompanyCoBrandInfo());
            companyAcctMaster.setCoName(coAcctModel.getCompanyName());
            companyAcctMaster.setCoInfo(coAcctModel.getCompanyInfo());
            companyAcctMaster.setCoAddr1(coAcctModel.getCompanyAddr1());
            companyAcctMaster.setCoAddr2(coAcctModel.getCompanyAddr2());
            companyAcctMaster.setCoCity(coAcctModel.getCompanyCity());
            companyAcctMaster.setCoState(coAcctModel.getCompanyState());
            companyAcctMaster.setCoCountry(coAcctModel.getCompanyCtry());
            companyAcctMaster.setCoZip(coAcctModel.getCompanyZip());
            companyAcctMaster.setCoEmail(coAcctModel.getCompanyEmail());
            companyAcctMaster.setTocName(coAcctModel
                    .getCompanyTechContactName());
            companyAcctMaster.setTocEmail(coAcctModel
                    .getCompanyTechContactEmail());
            companyAcctMaster.setCoUsrMa(companyUserMaster);
            companyGroupMaster.setCoAcctMa(companyAcctMaster);

            ReportMaster reportMaster = new ReportMaster();
            reportMaster.setRptId(new Short(coAcctModel
                    .getCompanyReportFormat()));
            companyAcctMaster.setRptMa(reportMaster);

            groupDetail.add(companyGroupMaster);
            companyUserMaster.setCoGrpMas(groupDetail);
            companyAcctMaster.setCoGrpMas(groupDetail);
            companyAcctMaster.setAcctMa(acctMaster);
            companyAcctMaster.setCoUsrMa(companyUserMaster);

            // Account Master Details
            acctMaster.setAcctStat("E");
            acctMaster.setCoAcctMa(companyAcctMaster);

            companyAccountDAO.saveCompany(acctMaster);

            companyAccountDAO.updateLastAccountId(lastAcctNo);

            try {
                mailer.sendAddCompanyMail(coAcctModel.getCompanyEmail(),
                        acctId, coAcctModel.getCompanyName(), coAcctModel
                                .getCompanyMgrUserId(), coAcctModel
                                .getCompanyMgrPasswd());
            }
            catch (MailException ex) {
                throw  new EmailException("email.failure",ex);

            }
        }
        catch (DataIntegrityViolationException ex) {
            throw new DataCreateException("errors.company.create.invaliddata",
                    ex);
        }

    }

    /**
     * This private method internally called by saveCompany to create a
     * DEFAULTGROUP as GENERAL while creating a new company.
     *
     * @param coAcctModel
     * @param companyAcctMaster
     * @param companyGroupMaster
     * @param acctId
     * @param companyAccountDAO
     * @throws DataCreateException
     */

    private CompanyUserMaster createDefaultGroupManager
            (CompanyAccountModel coAcctModel,String acctId)
            throws DataCreateException {

        /** Adding GENERAL Group Manager Details in Co_Usr_Ma */

        CompanyUserMasterKey companyUserMasterKey = new CompanyUserMasterKey(
                acctId, "GENERALADMIN");
        CompanyUserMaster companyUserMaster = new CompanyUserMaster();
        companyUserMaster.setComp_id(companyUserMasterKey);
        companyUserMaster.setGrpId("GENERAL");
        companyUserMaster.setPasswd(coAcctModel.getCompanyMgrPasswd());
        companyUserMaster
                .setFirstName(coAcctModel.getCompanyManagerFirstName());
        companyUserMaster.setLastName(coAcctModel.getCompanyManagerLastName());
        companyUserMaster.setUsrEmail(coAcctModel.getCompanyEmail());
        companyUserMaster.setNotes1("Not provided");
        companyUserMaster.setNotes2("Not provided");
        companyUserMaster.setStartFlg("T");
        companyUserMaster.setUsrStat("E");
        companyUserMaster.setReminderPhrase(coAcctModel
                .getCompanyPwdReminderPhrase());
        companyUserMaster.setAcctLocked(new Integer(
                coAcctModel.getUserAccountLockedStatus()));

        Short actvRolId = new Short((short) 3);
        ActvRolMaster actvRolMaster = new ActvRolMaster(actvRolId,
                "Group Manager");
        companyUserMaster.setActvRolMa(actvRolMaster);

        return companyUserMaster;

    }

    /**
     * This private method internally called by saveCompany to create a TEST
     * user under GENERAL group while creating a new company.
     *
     * @param coAcctModel
     * @param acctMaster
     * @param companyAcctMaster
     * @param companyGroupMaster
     * @param acctId
     * @param companyAccountDAO
     */

    private CompanyUserMaster createDefaultUser(
            CompanyAccountModel coAcctModel,String acctId) {


        /** Adding DEAFULT TEST USER Details in Co_Usr_Ma */
        CompanyUserMasterKey companyUserMasterKey = new CompanyUserMasterKey(
                acctId, "TEST");
        CompanyUserMaster companyUserMaster = new CompanyUserMaster();
        companyUserMaster.setComp_id(companyUserMasterKey);
        companyUserMaster.setGrpId("GENERAL");
        companyUserMaster.setPasswd("TEST");
        companyUserMaster
                .setFirstName(coAcctModel.getCompanyManagerFirstName());
        companyUserMaster.setLastName(coAcctModel.getCompanyManagerLastName());
        companyUserMaster.setUsrEmail(coAcctModel.getCompanyEmail());
        companyUserMaster.setNotes1("Not provided");
        companyUserMaster.setNotes2("Not provided");
        companyUserMaster.setStartFlg("T");
        companyUserMaster.setUsrStat("E");
        companyUserMaster.setReminderPhrase(coAcctModel
                .getCompanyPwdReminderPhrase());
        companyUserMaster.setAcctLocked(new Integer(
                coAcctModel.getUserAccountLockedStatus()));

        Short actvRolId = new Short((short) 5);
        ActvRolMaster actvRolMaster = new ActvRolMaster(actvRolId,
                "Company User");
        companyUserMaster.setActvRolMa(actvRolMaster);
        return companyUserMaster;

   }

    /**
     * This method internally called by saveCompany to generate new accountId
     * for the company.
     *
     * @param lstAcctNo
     * @return acctId
     */

    private String generateAccountid(int lstAcctNo) {
        Calendar rightNow = Calendar.getInstance();
        int year = (((rightNow.get(Calendar.YEAR)) * 1000000) + lstAcctNo);
        String acctId = String.valueOf(year);
        return acctId;
    }

    /**
     * This method is going to view the details of the COMPANY as well as
     * COMPANY MANAGER.
     * <p>
     * viewCompanyDetails will populate the CompanyAccountModel on the basis of
     * acctId provided by the user.
     * <p>
     *
     * @param acctId
     * @return coAcctModel
     * @throws DataNotFoundException
     */
    public CompanyAccountModel viewCompanyDetails(String acctId)
            throws DataNotFoundException {

        CompanyAcctMaster companyAcctMaster = new CompanyAcctMaster();

        try {
            companyAcctMaster = companyAccountDAO.getCompanyDetails(acctId);
            CompanyAccountModel coAcctModel = new CompanyAccountModel();

            coAcctModel.setCompanyAcctId(companyAcctMaster.getAcctId());
            coAcctModel.setCompanyName(companyAcctMaster.getCoName());
            coAcctModel.setCompanyInfo(companyAcctMaster.getCoInfo());
            coAcctModel.setCompanyAddr1(companyAcctMaster.getCoAddr1());
            coAcctModel.setCompanyAddr2(companyAcctMaster.getCoAddr2());
            coAcctModel.setCompanyCity(companyAcctMaster.getCoCity());
            coAcctModel.setCompanyCtry(companyAcctMaster.getCoCountry());
            coAcctModel.setCompanyState(companyAcctMaster.getCoState());
            coAcctModel.setCompanyZip(companyAcctMaster.getCoZip());
            coAcctModel.setCompanyEmail(companyAcctMaster.getCoEmail());
            coAcctModel.setCompanyCoBrandInfo(companyAcctMaster.getCobraInfo());
            coAcctModel.setCompanyManagerFirstName(companyAcctMaster
                    .getCoUsrMa().getFirstName());
            coAcctModel.setCompanyManagerLastName(companyAcctMaster
                    .getCoUsrMa().getLastName());
            coAcctModel.setCompanyMgrUserId(companyAcctMaster.getCoUsrMa()
                    .getComp_id().getUsrId());
            coAcctModel.setCompanyMgrPasswd(companyAcctMaster.getCoUsrMa()
                    .getPasswd());
            coAcctModel.setCompanyPwdReminderPhrase(companyAcctMaster
                    .getCoUsrMa().getReminderPhrase());
            coAcctModel.setCompanyTechContactName(companyAcctMaster
                    .getTocName());
            coAcctModel.setCompanyTechContactEmail(companyAcctMaster
                    .getTocEmail());
            coAcctModel.setCompanyReportFormat(companyAcctMaster.getRptMa()
                    .getRptId().toString());
            coAcctModel.setEnableDisable(companyAcctMaster.getAcctStat());

            return coAcctModel;

        }
        catch (DataRetrievalFailureException ex) {
            throw new DataNotFoundException("errors.company.not.found", ex);
        }
    }

    /**
     * This method will edit the details of the COMPANY as well as the COMPANY
     * MANAGER.
     * <p>
     * updateCompany get the updated data from CompanyAccountModel
     * <p>
     *
     * @param coAcctModel
     * @throws DataSaveException
     */
    public void updateCompany(CompanyAccountModel coAcctModel)
            throws DataSaveException,EmailException{

        Set userDetail = new HashSet();
        Set groupDetail = new HashSet();

        String acctId = coAcctModel.getCompanyAcctId();
        Date date = new Date();

        CompanyUserMaster companyUserMaster = new CompanyUserMaster();

        CompanyAcctMaster companyAcctMaster = new CompanyAcctMaster();

        try {
            // Account Master Details
            AcctMaster acctMaster = new AcctMaster(acctId, "C", new Date());

            // Company User Master Key Details
            CompanyUserMasterKey companyUserMasterKey =
                new CompanyUserMasterKey(
                    acctId, coAcctModel.getCompanyMgrUserId());

            // Company User Master Details
            companyUserMaster.setComp_id(companyUserMasterKey);
            companyUserMaster.setPasswd(coAcctModel.getCompanyMgrPasswd());
            companyUserMaster.setFirstName(coAcctModel
                    .getCompanyManagerFirstName());
            companyUserMaster.setLastName(coAcctModel
                    .getCompanyManagerLastName());
            companyUserMaster.setUsrEmail(coAcctModel.getCompanyEmail());
            companyUserMaster.setNotes1("Not provided");
            companyUserMaster.setNotes2("Not provided");
            companyUserMaster.setStartFlg("T");
            companyUserMaster.setUsrStat("E");
            companyUserMaster.setReminderPhrase(coAcctModel
                    .getCompanyPwdReminderPhrase());
            companyUserMaster.setAcctLocked(new Integer(
                    coAcctModel.getUserAccountLockedStatus()));
            Short actvRolId = new Short((short) 2);
            ActvRolMaster actvRolMaster = new ActvRolMaster(actvRolId,
                    "Company Manager");
            companyUserMaster.setActvRolMa(actvRolMaster);

            // making a usermaster Set
            userDetail.add(companyUserMaster);

            // Company Group Master Key Details
            CompanyGroupMasterKey companyGroupMasterKey =
                new CompanyGroupMasterKey(
                    acctId, "GENERAL");

            // Company Group Master Details
            CompanyGroupMaster companyGroupMaster = new CompanyGroupMaster();
            companyGroupMaster.setComp_id(companyGroupMasterKey);
            companyGroupMaster.setGrpInfo("DEFAULT GROUP");
            companyGroupMaster.setGrpStat("E");
            companyUserMaster.setCoGrpMa(companyGroupMaster);
            companyUserMaster.setGrpId("GENERAL");

            companyGroupMaster.setCoUsrMa(companyUserMaster);
            companyGroupMaster.setCoUsrMas(userDetail);

            // Company Account Master Details
            companyAcctMaster.setAcctId(acctId);
            companyAcctMaster.setAcctTyp("C");
            companyAcctMaster.setAcctStat(coAcctModel.getEnableDisable());
            companyAcctMaster.setCrtDt(new Date());
            companyAcctMaster.setCobraInfo(coAcctModel.getCompanyCoBrandInfo());
            companyAcctMaster.setCoName(coAcctModel.getCompanyName());
            companyAcctMaster.setCoInfo(coAcctModel.getCompanyInfo());
            companyAcctMaster.setCoAddr1(coAcctModel.getCompanyAddr1());
            companyAcctMaster.setCoAddr2(coAcctModel.getCompanyAddr2());
            companyAcctMaster.setCoCity(coAcctModel.getCompanyCity());
            companyAcctMaster.setCoState(coAcctModel.getCompanyState());
            companyAcctMaster.setCoCountry(coAcctModel.getCompanyCtry());
            companyAcctMaster.setCoZip(coAcctModel.getCompanyZip());
            companyAcctMaster.setCoEmail(coAcctModel.getCompanyEmail());
            companyAcctMaster.setTocName(coAcctModel
                    .getCompanyTechContactName());
            companyAcctMaster.setTocEmail(coAcctModel
                    .getCompanyTechContactEmail());
            companyAcctMaster.setCoUsrMa(companyUserMaster);
            companyGroupMaster.setCoAcctMa(companyAcctMaster);

            ReportMaster reportMaster = new ReportMaster();
            reportMaster.setRptId(new Short(coAcctModel
                    .getCompanyReportFormat()));
            companyAcctMaster.setRptMa(reportMaster);

            groupDetail.add(companyGroupMaster);
            companyUserMaster.setCoGrpMas(groupDetail);
            companyAcctMaster.setCoGrpMas(groupDetail);
            companyAcctMaster.setAcctMa(acctMaster);
            companyAcctMaster.setCoUsrMa(companyUserMaster);

            // Account Master Details
            acctMaster.setAcctStat(coAcctModel.getEnableDisable());
            acctMaster.setCoAcctMa(companyAcctMaster);

            companyAccountDAO.saveCompany(acctMaster);

            try {
                mailer.sendEditCompanyMail(coAcctModel.getCompanyEmail(),
                        acctId, coAcctModel.getCompanyName(), coAcctModel
                                .getCompanyMgrUserId(), coAcctModel
                                .getCompanyMgrPasswd());
            }
            catch (MailException ex) {
                throw  new EmailException("email.failure",ex);
            }

        }
        catch (DataIntegrityViolationException ex) {
            throw new DataSaveException(
                    "errors.company.create.invaliddata", ex);
        }

    }


    /**
     * This method enable/disable the companies.
     *
     * @param acctId
     */
    public void enableDisableCompany(String acctId) throws DataCreateException{

        AcctMaster acctMaster = new AcctMaster();
        CompanyAcctMaster companyAcctMaster = new CompanyAcctMaster();

        try {

            acctMaster = companyAccountDAO.getAcctMasterDetail(acctId);
            String currentStatus = acctMaster.getAcctStat();

            if (log.isDebugEnabled())
                log.debug("Current Status of Company : "
                        +currentStatus);

            ReportMaster reportMaster = new ReportMaster();
            reportMaster.setRptId(new Short(acctMaster.getCoAcctMa().getRptMa()
                    .getRptId()));

            if (currentStatus.equalsIgnoreCase("E")) {
                acctMaster.setAcctId(acctMaster.getAcctId());
                acctMaster.setAcctStat("D");
                acctMaster.setAcctTyp(acctMaster.getAcctTyp());
                acctMaster.setCrtDt(acctMaster.getCrtDt());
                companyAcctMaster.setAcctStat("D");
                companyAcctMaster.setAcctId(acctId);
                companyAcctMaster.setAcctTyp(acctMaster.getCoAcctMa()
                        .getAcctTyp());
                companyAcctMaster.setCrtDt(acctMaster.getCoAcctMa().getCrtDt());
                companyAcctMaster.setCobraInfo(acctMaster.getCoAcctMa()
                        .getCobraInfo());
                companyAcctMaster.setCoName(acctMaster.getCoAcctMa()
                        .getCoName());
                companyAcctMaster.setCoInfo(acctMaster.getCoAcctMa()
                        .getCoInfo());
                companyAcctMaster.setCoAddr1(acctMaster.getCoAcctMa()
                        .getCoAddr1());
                companyAcctMaster.setCoAddr2(acctMaster.getCoAcctMa()
                        .getCoAddr2());
                companyAcctMaster.setCoCity(acctMaster.getCoAcctMa()
                        .getCoCity());
                companyAcctMaster.setCoState(acctMaster.getCoAcctMa()
                        .getCoState());
                companyAcctMaster.setCoCountry(acctMaster.getCoAcctMa()
                        .getCoCountry());
                companyAcctMaster.setCoZip(acctMaster.getCoAcctMa().getCoZip());
                companyAcctMaster.setCoEmail(acctMaster.getCoAcctMa()
                        .getCoEmail());
                companyAcctMaster.setTocName(acctMaster.getCoAcctMa()
                        .getTocName());
                companyAcctMaster.setTocEmail(acctMaster.getCoAcctMa()
                        .getTocEmail());
                companyAcctMaster.setRptMa(reportMaster);
                acctMaster.setCoAcctMa(companyAcctMaster);

            } else {
                acctMaster.setAcctId(acctMaster.getAcctId());
                acctMaster.setAcctStat("E");
                acctMaster.setAcctTyp(acctMaster.getAcctTyp());
                acctMaster.setCrtDt(acctMaster.getCrtDt());
                companyAcctMaster.setAcctStat("E");
                companyAcctMaster.setAcctId(acctId);
                companyAcctMaster.setAcctTyp(acctMaster.getCoAcctMa()
                        .getAcctTyp());
                companyAcctMaster.setCrtDt(acctMaster.getCoAcctMa().getCrtDt());
                companyAcctMaster.setCobraInfo(acctMaster.getCoAcctMa()
                        .getCobraInfo());
                companyAcctMaster.setCoName(acctMaster.getCoAcctMa()
                        .getCoName());
                companyAcctMaster.setCoInfo(acctMaster.getCoAcctMa()
                        .getCoInfo());
                companyAcctMaster.setCoAddr1(acctMaster.getCoAcctMa()
                        .getCoAddr1());
                companyAcctMaster.setCoAddr2(acctMaster.getCoAcctMa()
                        .getCoAddr2());
                companyAcctMaster.setCoCity(acctMaster.getCoAcctMa()
                        .getCoCity());
                companyAcctMaster.setCoState(acctMaster.getCoAcctMa()
                        .getCoState());
                companyAcctMaster.setCoCountry(acctMaster.getCoAcctMa()
                        .getCoCountry());
                companyAcctMaster.setCoZip(acctMaster.getCoAcctMa().getCoZip());
                companyAcctMaster.setCoEmail(acctMaster.getCoAcctMa()
                        .getCoEmail());
                companyAcctMaster.setTocName(acctMaster.getCoAcctMa()
                        .getTocName());
                companyAcctMaster.setTocEmail(acctMaster.getCoAcctMa()
                        .getTocEmail());
                companyAcctMaster.setRptMa(reportMaster);
                acctMaster.setCoAcctMa(companyAcctMaster);
            }

            companyAccountDAO.updateCompany(acctMaster);

        }
        catch (DataIntegrityViolationException ex) {
            throw new DataCreateException("errors.company.create.invaliddata",
                    ex);
        }

    }

    /**
     * This method delete the disable companies.
     *
     * @param array of acctIds of Disable companies
     * @throws DataDeleteException
     *
     */
    public void deleteCompany(String[] acctIds) throws DataDeleteException {

        try {

            companyAccountDAO.deleteCompanyDetails(acctIds);

        }
        catch (DataIntegrityViolationException ex) {
            throw new DataDeleteException("errors.company.delete", ex);
        }
    }

    /**
     * This method returns the collection of Disable Companies
     * whose status is 'D'.
     *
     * @return collection of companies
     * @throws DataNotFoundException
     *
     */
    public Collection showDisableCompanies()throws DataNotFoundException  {

        String acctId;
        HashMap placeHolders = new HashMap();
        CompanyAccountModel coAcctModel = new CompanyAccountModel();
        String totalUsers = null;
        List disableCompanies = new ArrayList();
        List resultList;
        try {
            resultList = hqlsearch.search("DisableCompanyQueryKey");
            Iterator resultIterator = resultList.iterator();
            while (resultIterator.hasNext()) {
                CompanyAcctMaster companyAcctMaster = (
                        CompanyAcctMaster) resultIterator
                        .next();
                acctId = companyAcctMaster.getAcctId();
                companyAcctMaster = companyAccountDAO.getCompanyDetails(acctId);
                placeHolders.put("ACCTID", acctId);
                List counter = hqlsearch.search("AccountMasterQueryDisableKey",
                        placeHolders);
                totalUsers = counter.get(0).toString();

                if (log.isDebugEnabled())
                    log.debug("Total Number of Users in AccountID: "
                            +acctId+"is:"+totalUsers );

                companyAcctMaster.setAcctId(companyAcctMaster.getAcctId());
                companyAcctMaster.setCoName(companyAcctMaster.getCoName());
                companyAcctMaster.getCoUsrMa().setFirstName(
                        companyAcctMaster.getCoUsrMa().getFirstName());
                companyAcctMaster.getCoUsrMa().setLastName(
                        companyAcctMaster.getCoUsrMa().getLastName());
                companyAcctMaster.setCoEmail(companyAcctMaster.getCoEmail());
                companyAcctMaster.setTotalUsers(totalUsers);

                disableCompanies.add(companyAcctMaster);
            }

        }
        catch (Exception ex) {
            throw new DataNotFoundException("errors.company.not.found", ex);
        }

        return disableCompanies;
    }

    /**
     * This method retrives the companies using HQL.
     *
     * @param companyName ,
     *            criteria agains which the search works.
     * @param accountId ,
     *            accoundID of the user to know which company it can see.
     * @return companyList , list that is retrieved from the Db.
     */
    private Collection fetchListOfCompanies(String companyName,String accountId)
    {

        List resultList;
        Collection companyRecordsFillDetails = new ArrayList();
        List companyList = null;
        HashMap placeHolders = new HashMap();
        if (companyName != null) {
            placeHolders.put("COMPNAME", companyName);
        }
        if (accountId != null) {
            placeHolders.put("ACCTID", accountId);
        }
        try {
            resultList = hqlsearch
                    .search("AccountMasterQueryKey", placeHolders);

            log.info("matching company list retrieved " + resultList
                    + "  records from DB against acctID :" + accountId
                    + " compname:" + companyName);
            if (resultList.size() > 0) {
                Integer intCount = (Integer) resultList.get(0);
                int count = intCount.intValue();
                if (count > 0) {

                    companyList = hqlsearch.search(
                            "AccountMasterQueryDetailKey", placeHolders);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return companyList;
    }

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
            int page) throws DataNotFoundException {
        Collection listOfCompanies = null;
        if ((companyName != null) && (!"".equals(companyName))) {
            companyName = companyName+"*";
            companyName = companyName.replace('*', '#');
            companyName = companyName.replaceAll("#", "%");
            listOfCompanies = fetchListOfCompanies(companyName, accountId);
        } else {
            listOfCompanies = fetchListOfCompanies(null, accountId);
        }
        if (listOfCompanies == null) {
            throw new DataNotFoundException("error.searchNotFound");
        }
        SortedSet listofMatchingCompanies = null;
        int maxPages = 0;
        listofMatchingCompanies = new TreeSet(new CompareCompanyName());
        listofMatchingCompanies.addAll(listOfCompanies);
        log.info("matching company list contains:" + listofMatchingCompanies);
        // trimming down to page size
        int size=IConstants.SearchResultSize;
        maxPages = (int) Math
                .ceil((((float) listofMatchingCompanies.size()) /(float)size));
        int startPos = size * page;
        if (startPos > listofMatchingCompanies.size()) {
            page = (listofMatchingCompanies.size()) / size;
            startPos =size * page;
        }
        int endPos = size * (page + 1);
        if (endPos > listofMatchingCompanies.size()) {
            endPos = listofMatchingCompanies.size();
        }
        if (startPos < endPos) {

            // adding a element that is greater than the greatest element of
            // the set
            CompanyAcctMaster companyAcctMaster = (CompanyAcctMaster)
            listofMatchingCompanies.last();
            String lastCompName = companyAcctMaster.getCoName().trim();
            String lastCompAccountID = companyAcctMaster.getAcctId().trim();

            if ("".equals(lastCompName)) {
                lastCompName = companyAcctMaster.getCoName();
            }
            if ("".equals(lastCompAccountID)) {
                lastCompAccountID = companyAcctMaster.getAcctId();
            }
            lastCompName = lastCompName + "1245";
            lastCompAccountID = lastCompAccountID + "12345";
            companyAcctMaster = new CompanyAcctMaster();
            companyAcctMaster.setCoName(lastCompName);
            companyAcctMaster.setAcctId(lastCompAccountID);
            listofMatchingCompanies.add(companyAcctMaster);

            Object[] arrayOfObjects = listofMatchingCompanies.toArray();
            listofMatchingCompanies = listofMatchingCompanies
                    .tailSet(arrayOfObjects[startPos]);
            listofMatchingCompanies = listofMatchingCompanies
                    .headSet(arrayOfObjects[endPos]);

        }

        Map resultData = new HashMap();
        resultData.put("resultList", listofMatchingCompanies);
        resultData.put("maxPages", "" + maxPages);

        return resultData;
    }

    /**
     * calls the companyaccountdao getAllDetailsOfCompany method.
     *
     * @param acctId
     */
    public CompanyAcctMaster getAllDetailsOfCompany(String acctId) {
        return (companyAccountDAO.getAllDetailsOfCompany(acctId));
    }

    /**
     * @return Returns the log.
     */
    public static Log getLog() {
        return log;
    }

    /**
     * @param log The log to set.
     */
    public static void setLog(Log log) {
        CompanyManagerFacadeImpl.log = log;
    }

    /**
     * @return Returns the companyAccountDAO.
     */
    public CompanyAccountDAO getCompanyAccountDAO() {
        return companyAccountDAO;
    }

    /**
     * @param companyAccountDAO The companyAccountDAO to set.
     */
    public void setCompanyAccountDAO(CompanyAccountDAO companyAccountDAO) {
        this.companyAccountDAO = companyAccountDAO;
    }

    /**
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

    /**
     * @return Returns the mailer.
     */
    public MailWriterFacadeImpl getMailer() {
        return mailer;
    }

    /**
     * @param mailer The mailer to set.
     */
    public void setMailer(MailWriterFacadeImpl mailer) {
        this.mailer = mailer;
    }

    /**
     * @return Returns the userAccountDAO.
     */
    public UserAccountDAO getUserAccountDAO() {
        return userAccountDAO;
    }

    /**
     * @param userAccountDAO The userAccountDAO to set.
     */
    public void setUserAccountDAO(UserAccountDAO userAccountDAO) {
        this.userAccountDAO = userAccountDAO;
    }


}