/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @author : barthwpr 
 *  @date   : Aug 26, 2006
 *  @version: 
 * 
 *  @history
 *  Description         Reference       Name        Date
 *               
 */

package com.mgmtassessment.execmap.webapp.main.user.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mgmtassessment.execmap.common.framework.webapp.ExecmapForm;

/**
 * TODO form class associated with the  ShowDisabledUsersAction class 
 *  
 */

public class ShowDisabledUsersForm extends ExecmapForm implements Serializable {
    /**
     * list of disabled users of a particular accountid and groupId
     */
    private List listOfDisabledUsers = new ArrayList();
    
    /**
     * hidden field in deleteusercontent.jsp
     */
    private String accountId = null;
    
    /**
     * hidden field in deleteusercontent.jsp
     */
    private String groupId = null;
    
    /**
     * an array for storing selected userid's for deleting them
     */
    private String[] selectedCheckboxes = null;

    /**
     * @return Returns the listOfDisabledUsers.
     */
    public List getListOfDisabledUsers() {
        return listOfDisabledUsers;
    }

    /**
     * @param listOfDisabledUsers The listOfDisabledUsers to set.
     */
    public void setListOfDisabledUsers(List listOfDisabledUsers) {
        this.listOfDisabledUsers = listOfDisabledUsers;
    }

    /**
     * @return Returns the accountId.
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * @param accountId The accountId to set.
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

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
     * @return Returns the groupId.
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * @param groupId The groupId to set.
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

}
