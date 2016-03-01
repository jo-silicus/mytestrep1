/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @author : barthwpr 
 *  @date   : Aug 24, 2006
 *  @version: 
 * 
 *  @history
 *  Description         Reference       Name        Date
 *               
 */

package com.mgmtassessment.execmap.webapp.main.group.form;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.common.framework.webapp.ExecmapForm;
import com.mgmtassessment.execmap.webapp.main.group.action.EnableDisableGroup;

/**
 * TODO from class associated with GroupManagementAction class
 * 
 */


public class GroupManagementForm extends ExecmapForm implements Serializable {
	
	private static Log log = LogFactory.getLog(GroupManagementForm.class);
	/**
	 * accouuntId of the user that login's
	 */
	private String accountId ;
	
	/**
     * This method resets the form values
     * 
     * @param ActionMapping
     * @param HttpServletRequest
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {

    	accountId = null;

        super.reset(mapping, request);
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
}
