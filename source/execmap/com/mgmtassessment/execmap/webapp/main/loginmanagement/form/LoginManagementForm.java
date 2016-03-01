/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : singhrau
 * @date : Sep 14, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.webapp.main.loginmanagement.form;

import java.util.List;

import com.mgmtassessment.execmap.common.framework.webapp.ExecmapForm;

/**
 * This class is a placeholder for form values.CompanyAccountForm represents
 * getter and setter method for all the values that are going to present on JSP.
 */

public class LoginManagementForm extends ExecmapForm {
    /**
     * list to contain all the locked users.
     */
    private List     lockedUsers;

    /**
     * String array to preserve states of the checkboxes in the jsp.
     */
    private String[] selectedCheckboxes;

    /**
     * @return Returns the selectedCheckboxes.
     */
    public String[] getSelectedCheckboxes() {
        return selectedCheckboxes;
    }

    /**
     * @param selectedCheckboxes The selectedCheckboxes to set.
     */
    public void setSelectedCheckboxes(String[] selectedCheckboxes) {
        this.selectedCheckboxes = selectedCheckboxes;
    }

    /**
     * @return Returns the lockedUsers.
     */
    public List getLockedUsers() {
        return lockedUsers;
    }

    /**
     * @param lockedUsers The lockedUsers to set.
     */
    public void setLockedUsers(List lockedUsers) {
        this.lockedUsers = lockedUsers;
    }

}
