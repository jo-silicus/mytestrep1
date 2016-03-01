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

import com.mgmtassessment.execmap.common.framework.business.AbstractModel;
import com.mgmtassessment.execmap.business.model.User;

/**
 * TODO Write java docs comments for this type
 * 
 */

public class Group extends AbstractModel{
	
	String groupName;
    User[] user;

    public void setGroupID(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupID() {
        return groupName;
    }

    public void setUser(User[] user) {
        this.user = user;
    }

    public User[] getUser() {
        return user;
    }
}
