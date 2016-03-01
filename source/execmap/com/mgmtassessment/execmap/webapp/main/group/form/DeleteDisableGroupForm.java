/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @author : barthwpr 
 *  @date   : Aug 16, 2006
 *  @version: 
 * 
 *  @history
 *  Description         Reference       Name        Date
 *               
 */

package com.mgmtassessment.execmap.webapp.main.group.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mgmtassessment.execmap.common.framework.webapp.ExecmapForm;

/**
 * TODO this class conatins a list of disabled groups of a particular company
 * 
 */

public class DeleteDisableGroupForm extends ExecmapForm implements Serializable {
    /**
     * list of disabled groups of a particular accountid
     */
    private List listOfDisabledGroups = new ArrayList();
    /**
     * an array for storing selected groupid's for deleting them
     */
    private String[] selectedCheckboxes = null;
    /**
     * a hidden filed in deletedisablegroupcontent jsp
     */
    
    private String accountId = null;
    
    
   
    

    /**
     * @return Returns the listOfDisabledGroups.
     */
    public List getListOfDisabledGroups() {
        return listOfDisabledGroups;
    }

    /**
     * @param listOfDisabledGroups The listOfDisabledGroups to set.
     */
    public void setListOfDisabledGroups(List listOfDisabledGroups) {
        this.listOfDisabledGroups = listOfDisabledGroups;
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


}
