/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @author : DasAshim 
 *  @date   : Jul 25, 2006
 *  @version: 
 * 
 *  @history
 *  Description         Reference       Name        Date
 *               
 */

package com.mgmtassessment.execmap.common.util.webapp;

import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionBindingEvent;

import java.io.Serializable;

import com.mgmtassessment.execmap.common.util.webapp.UserLoginInfo;

/**
 * TODO Write java docs comments for this type
 * 
 */

public class UserContext implements 
             HttpSessionBindingListener, Serializable {
	
    private UserLoginInfo userInfo = null;    	
	
    /**
     * Public Constructor
     */
    
    public UserContext(){
    	super();
    	new UserLoginInfo();
    }
    
	/**
	 * The container calls this method when it is being 
	 * unbound from the Session 
	 */
	
     public void valueUnbound(HttpSessionBindingEvent event){
    	 //do cleanup
         userInfo = null;    	 
     }
     
     /**
 	 * The container calls this method when it is being 
 	 * bound to the Session
 	 * 
 	 */ 
     
     public void valueBound(HttpSessionBindingEvent event){
    	 /** Do nothing **/
     }

	/**
	 * @return Returns the userInfo.
	 */
	public UserLoginInfo getUserInfo() {
		return userInfo;
	}

	/**
	 * @param userInfo The userInfo to set.
	 */
	public void setUserInfo(UserLoginInfo userInfo) {
		this.userInfo = userInfo;
	}
     
}
