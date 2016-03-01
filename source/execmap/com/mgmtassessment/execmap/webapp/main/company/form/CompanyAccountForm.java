/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : DasAshim
 * @date : Jul 24, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.webapp.main.company.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.business.model.CompanyAccountModel;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapForm;

/**
 * This class is a placeholder for form values.CompanyAccountForm represents
 * getter and setter method for all the values that are going to present on JSP.
 *
 */

public class CompanyAccountForm extends ExecmapForm implements Serializable {

  
    /**
     * Company Name.
     */
    public String     companyName;

   /**
    * Company's Information.
    */
    public String     companyInfo;

    /**
     * Company Address1.
     */
    public String     companyAddr1;

    /**
     * Company Address2.
     */
    public String     companyAddr2;

    /**
     * Company City.
     */
    public String     companyCity;

    /**
     * Company State.
     */
    public String     companyState;

    /**
     * Company Zip Code.
     */
    public String     companyZip;

    /**
     * Company City.
     */
    public String     companyCtry;

    /**
     * Company's Email ID.
     */
    public String     companyEmail;

    /**
     * Company Manager's First Name.
     */
    public String     companyManagerFirstName;

    /**
     * Company Managers Last Name.
     */
    public String     companyManagerLastName;

    /**
     * Company Manager's User ID.
     */
    public String     companyMgrUserId;

    /**
     * Company Managers Passwword.
     */
    public String     companyMgrPasswd;

    /**
     * Company Manager's Password Reminder Phrase.
     */
    public String     companyPwdReminderPhrase;

    /**
     * Company's CoBrand Flag.
     */
    public String     companyCoBrandFlag;

    /**
     * Company CoBrand Information.
     */
    public String     companyCoBrandInfo;

    /**
     * Company Technical Contact Name.
     */
    public String     companyTechContactName;

    /**
     * Company Technical Contact Email.
     */
    public String     companyTechContactEmail;

    /**
     * Company Report Format.
     */
    public String     companyReportFormat;

    /**
     * List of Images.
     */
    public List       imagesList         = new ArrayList();

    /**
     * radio value from JSP
     */
    public String     radioValue;

    /**
     * Collection of Disable Companies.
     */
    public Collection disableCompanies;

    /**
     * Array Of company Account IDs
     */
    public String     companyAcctId;

    /**
     * Array of Checkboxes selected by user 
     * to delete companies.
     */
    public String[]   selectedCheckboxes = null;

    /**
     * Total number of users in a company.
     */
    public String     totalUsers;

    /**
     * Name of the image to displayed.
     */
    public String     imageName;

    /**
     * Reminder phrase.
     */
    public String     reminderPhrase;
    
    /**
     * Flag to show enable and disable company.
     */
    public String     enableDisable;
    
    /**
     * user locked status.
     */
    private String userAccountLockedStatus;
    

    /**
     * @return Returns the userAccountLockedStatus.
     */
    public String getUserAccountLockedStatus() {
        return userAccountLockedStatus;
    }

    /**
     * @param userAccountLockedStatus The userAccountLockedStatus to set.
     */
    public void setUserAccountLockedStatus(String userAccountLockedStatus) {
        this.userAccountLockedStatus = userAccountLockedStatus;
    }

    /**
     * @return Returns the enableDisable.
     */
    public String getEnableDisable() {
        return enableDisable;
    }

    /**
     * @param enableDisable The enableDisable to set.
     */
    public void setEnableDisable(String enableDisable) {
        this.enableDisable = enableDisable;
    }

    /**
     * @return Returns the reminderPhrase.
     */
    public String getReminderPhrase() {
        return reminderPhrase;
    }

    /**
     * @param reminderPhrase
     *            The reminderPhrase to set.
     */
    public void setReminderPhrase(String reminderPhrase) {
        this.reminderPhrase = reminderPhrase;
    }

    /**
     * @return Returns the imageName.
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * @param imageName
     *            The imageName to set.
     */
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    /**
     * @return Returns the totalUsers.
     */
    public String getTotalUsers() {
        return totalUsers;
    }

    /**
     * @param totalUsers
     *            The totalUsers to set.
     */
    public void setTotalUsers(String totalUsers) {
        this.totalUsers = totalUsers;
    }

    /**
     * @return Returns the companyAcctId.
     */
    public String getCompanyAcctId() {
        return companyAcctId;
    }

    /**
     * @param companyAcctId
     *            The companyAcctId to set.
     */
    public void setCompanyAcctId(String companyAcctId) {
        this.companyAcctId = companyAcctId;
    }

    /**
     * @return Returns the disableCompanies.
     */
    public Collection getDisableCompanies() {
        return disableCompanies;
    }

    /**
     * @param disableCompanies
     *            The disableCompanies to set.
     */
    public void setDisableCompanies(Collection disableCompanies) {
        this.disableCompanies = disableCompanies;
    }

    /**
     * @return Returns the radioValue.
     */
    public String getRadioValue() {
        return radioValue;
    }

    /**
     * @param radioValue
     *            The radioValue to set.
     */
    public void setRadioValue(String radioValue) {
        this.radioValue = radioValue;
    }

    /**
     * @return Returns the imagesList.
     */
    public List getImagesList() {
        return imagesList;
    }

    /**
     * @param imagesList
     *            The imagesList to set.
     */
    public void setImagesList(List imagesList) {
        this.imagesList = imagesList;
    }

    /**
     * @return Returns the companyAddr1.
     */
    public String getCompanyAddr1() {
        return companyAddr1;
    }

    /**
     * @param companyAddr1
     *            The companyAddr1 to set.
     */
    public void setCompanyAddr1(String companyAddr1) {
        this.companyAddr1 = companyAddr1;
    }

    /**
     * @return Returns the companyAddr2.
     */
    public String getCompanyAddr2() {
        return companyAddr2;
    }

    /**
     * @param companyAddr2
     *            The companyAddr2 to set.
     */
    public void setCompanyAddr2(String companyAddr2) {
        this.companyAddr2 = companyAddr2;
    }

    /**
     * @return Returns the companyCity.
     */
    public String getCompanyCity() {
        return companyCity;
    }

    /**
     * @param companyCity
     *            The companyCity to set.
     */
    public void setCompanyCity(String companyCity) {
        this.companyCity = companyCity;
    }

    /**
     * @return Returns the companyCoBrandFlag.
     */
    public String getCompanyCoBrandFlag() {
        return companyCoBrandFlag;
    }

    /**
     * @param companyCoBrandFlag
     *            The companyCoBrandFlag to set.
     */
    public void setCompanyCoBrandFlag(String companyCoBrandFlag) {
        this.companyCoBrandFlag = companyCoBrandFlag;
    }

    /**
     * @return Returns the companyCoBrandInfo.
     */
    public String getCompanyCoBrandInfo() {
        return companyCoBrandInfo;
    }

    /**
     * @param companyCoBrandInfo
     *            The companyCoBrandInfo to set.
     */
    public void setCompanyCoBrandInfo(String companyCoBrandInfo) {
        this.companyCoBrandInfo = companyCoBrandInfo;
    }

    /**
     * @return Returns the companyCtry.
     */
    public String getCompanyCtry() {
        return companyCtry;
    }

    /**
     * @param companyCtry
     *            The companyCtry to set.
     */
    public void setCompanyCtry(String companyCtry) {
        this.companyCtry = companyCtry;
    }

    /**
     * @return Returns the companyEmail.
     */
    public String getCompanyEmail() {
        return companyEmail;
    }

    /**
     * @param companyEmail
     *            The companyEmail to set.
     */
    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    /**
     * @return Returns the companyInfo.
     */
    public String getCompanyInfo() {
        return companyInfo;
    }

    /**
     * @param companyInfo
     *            The companyInfo to set.
     */
    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    /**
     * @return Returns the companyMgrPasswd.
     */
    public String getCompanyMgrPasswd() {
        return companyMgrPasswd;
    }

    /**
     * @param companyMgrPasswd
     *            The companyMgrPasswd to set.
     */
    public void setCompanyMgrPasswd(String companyMgrPasswd) {
        this.companyMgrPasswd = companyMgrPasswd;
    }

    /**
     * @return Returns the companyMgrUserId.
     */
    public String getCompanyMgrUserId() {
        return companyMgrUserId;
    }

    /**
     * @param companyMgrUserId
     *            The companyMgrUserId to set.
     */
    public void setCompanyMgrUserId(String companyMgrUserId) {
        this.companyMgrUserId = companyMgrUserId;
    }

    /**
     * @return Returns the companyName.
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName
     *            The companyName to set.
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return Returns the companyPwdReminderPhrase.
     */
    public String getCompanyPwdReminderPhrase() {
        return companyPwdReminderPhrase;
    }

    /**
     * @param companyPwdReminderPhrase
     *            The companyPwdReminderPhrase to set.
     */
    public void setCompanyPwdReminderPhrase(String companyPwdReminderPhrase) {
        this.companyPwdReminderPhrase = companyPwdReminderPhrase;
    }

    /**
     * @return Returns the companyReportFormat.
     */
    public String getCompanyReportFormat() {
        return companyReportFormat;
    }

    /**
     * @param companyReportFormat
     *            The companyReportFormat to set.
     */
    public void setCompanyReportFormat(String companyReportFormat) {
        this.companyReportFormat = companyReportFormat;
    }

    /**
     * @return Returns the companyState.
     */
    public String getCompanyState() {
        return companyState;
    }

    /**
     * @param companyState
     *            The companyState to set.
     */
    public void setCompanyState(String companyState) {
        this.companyState = companyState;
    }

    /**
     * @return Returns the companyTechContactEmail.
     */
    public String getCompanyTechContactEmail() {
        return companyTechContactEmail;
    }

    /**
     * @param companyTechContactEmail
     *            The companyTechContactEmail to set.
     */
    public void setCompanyTechContactEmail(String companyTechContactEmail) {
        this.companyTechContactEmail = companyTechContactEmail;
    }

    /**
     * @return Returns the companyTechContactName.
     */
    public String getCompanyTechContactName() {
        return companyTechContactName;
    }

    /**
     * @param companyTechContactName
     *            The companyTechContactName to set.
     */
    public void setCompanyTechContactName(String companyTechContactName) {
        this.companyTechContactName = companyTechContactName;
    }

    /**
     * @return Returns the companyZip.
     */
    public String getCompanyZip() {
        return companyZip;
    }

    /**
     * @param companyZip
     *            The companyZip to set.
     */
    public void setCompanyZip(String companyZip) {
        this.companyZip = companyZip;
    }

    /**
     * This method resets the form values
     * 
     * @param ActionMapping
     * @param HttpServletRequest
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {

        companyName = null;
        companyInfo = null;
        companyAddr1 = null;
        companyAddr2 = null;
        companyCity = null;
        companyState = null;
        companyZip = null;
        companyCtry = null;
        companyEmail = null;
        companyManagerFirstName = null;
        companyManagerLastName = null;
        companyMgrUserId = null;
        companyMgrPasswd = null;
        companyPwdReminderPhrase = null;
        companyCoBrandFlag = null;
        companyCoBrandInfo = null;
        companyTechContactName = null;
        companyTechContactEmail = null;
        companyReportFormat = null;
        super.reset(mapping, request);
    }

    /**
     * This method populates the CompanyForm from the CompanyModel. This method
     * would be used when an existing Company needs to be modified or viewed.
     * 
     * @param CompanyAcctountModel
     */
    public void populateForm(CompanyAccountModel coAcctModel) {

        companyAcctId = coAcctModel.getCompanyAcctId();
        companyName = coAcctModel.getCompanyName();
        companyInfo = coAcctModel.getCompanyInfo();
        companyAddr1 = coAcctModel.getCompanyAddr1();
        companyAddr2 = coAcctModel.getCompanyAddr2();
        companyCity = coAcctModel.getCompanyCity();
        companyState = coAcctModel.getCompanyState();
        companyZip = coAcctModel.getCompanyZip();
        companyCtry = coAcctModel.getCompanyCtry();
        companyEmail = coAcctModel.getCompanyEmail();
        companyManagerFirstName = coAcctModel.getCompanyManagerFirstName();
        companyManagerLastName = coAcctModel.getCompanyManagerLastName();
        companyMgrUserId = coAcctModel.getCompanyMgrUserId();
        companyMgrPasswd = coAcctModel.getCompanyMgrPasswd();
        companyPwdReminderPhrase = coAcctModel.getCompanyPwdReminderPhrase();
        companyCoBrandFlag = coAcctModel.getCompanyCoBrandFlag();
        companyCoBrandInfo = coAcctModel.getCompanyCoBrandInfo();
        companyTechContactName = coAcctModel.getCompanyTechContactName();
        companyTechContactEmail = coAcctModel.getCompanyTechContactEmail();
        if (coAcctModel.getCompanyReportFormat().equals("1")) {
            companyReportFormat = "ExecMap Individual Report";
        }
        if (coAcctModel.getCompanyReportFormat().equals("2")) {
            companyReportFormat = "ExecMap Leadership A Report";
        }
        if (coAcctModel.getCompanyReportFormat().equals("3")) {
            companyReportFormat = "ExecMap Leadership B Report";
        }
        if (coAcctModel.getCompanyReportFormat().equals("4")) {
            companyReportFormat = "ExecMap Summary Report";
        }
        companyCoBrandFlag = "Y";
        imageName = coAcctModel.getCompanyCoBrandInfo();
        enableDisable = coAcctModel.getEnableDisable();
    }

    /**
     * @return Returns the companyManagerFirstName.
     */
    public String getCompanyManagerFirstName() {
        return companyManagerFirstName;
    }

    /**
     * @param companyManagerFirstName
     *            The companyManagerFirstName to set.
     */
    public void setCompanyManagerFirstName(String companyManagerFirstName) {
        this.companyManagerFirstName = companyManagerFirstName;
    }

    /**
     * @return Returns the companyManagerLastName.
     */

    public String getCompanyManagerLastName() {
        return companyManagerLastName;
    }

    /**
     * @param companyManagerLastName
     *            The companyManagerLastName to set.
     */
    public void setCompanyManagerLastName(String companyManagerLastName) {
        this.companyManagerLastName = companyManagerLastName;
    }

    /**
     * @return Returns the selectedCheckboxes.
     */
    public String[] getSelectedCheckboxes() {
        return selectedCheckboxes;
    }

    /**
     * @param selectedCheckboxes
     *            The selectedCheckboxes to set.
     */
    public void setSelectedCheckboxes(String[] selectedCheckboxes) {
        this.selectedCheckboxes = selectedCheckboxes;
    }

}
