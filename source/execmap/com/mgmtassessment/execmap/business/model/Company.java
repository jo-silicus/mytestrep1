/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @author : TODO
 *  @date   : Jul 21, 2006
 *  @version: 
 * 
 *  @history
 *  Description         Reference       Name        Date
 *               
 */

package com.mgmtassessment.execmap.business.model;

import java.io.Serializable;
import com.mgmtassessment.execmap.common.framework.business.AbstractModel;

/**
 * TODO Write java docs comments for this type
 * 
 */

public class Company extends AbstractModel implements Serializable{
	
	String companyName;
    String accountID;
    Group[] group;

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setGroup(Group[] group) {
        this.group = group;
    }

    public Group[] getGroup() {
        return group;
    }
}