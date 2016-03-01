/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @author : AhmedZia 
 *  @date   : Aug 2, 2006
 *  @version: 
 * 
 *  @history
 *  Description         Reference       Name        Date
 *               
 */

package com.mgmtassessment.execmap.data.dao.types;

import java.io.Serializable;
import java.util.Set;

/**
 * TODO Write java docs comments for this type
 * 
 */

public class ActivityRoleMaster implements Serializable {
	
	
	/** identifier field */
    private short actvRolId;
    
    /** identifier field */
    private String rolDesc;
    
    /** nullable persistent field */
    private Set coUsrMa;
    
    /** full constructor */
    public ActivityRoleMaster(short actvRolId,  String rolDesc,Set coUsrMa ){
    	
    	this.actvRolId = actvRolId;
    	this.rolDesc =rolDesc;
    	this.coUsrMa= coUsrMa;
       }
    
    
    /** default constructor */
    public ActivityRoleMaster() {
    }
    
    /** minimal constructor */
    public ActivityRoleMaster(short actvRolId,  String rolDesc){
    	this.actvRolId = actvRolId;
    	this.rolDesc =rolDesc;    	
    }


	/**
	 * @return Returns the actvRolId.
	 */
	public short getActvRolId() {
		return actvRolId;
	}


	/**
	 * @param actvRolId The actvRolId to set.
	 */
	public void setActvRolId(short actvRolId) {
		this.actvRolId = actvRolId;
	}


	/**
	 * @return Returns the coUsrMa.
	 */
	public Set getCoUsrMa() {
		return coUsrMa;
	}


	/**
	 * @param coUsrMa The coUsrMa to set.
	 */
	public void setCoUsrMa(Set coUsrMa) {
		this.coUsrMa = coUsrMa;
	}


	/**
	 * @return Returns the rolDesc.
	 */
	public String getRolDesc() {
		return rolDesc;
	}


	/**
	 * @param rolDesc The rolDesc to set.
	 */
	public void setRolDesc(String rolDesc) {
		this.rolDesc = rolDesc;
	}
	
	

}
