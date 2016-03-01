/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @author : DasAshim 
 *  @date   : Jul 11, 2006
 *  @version: 
 * 
 *  @history
 *  Description         Reference       Name        Date
 *               
 */

package com.mgmtassessment.execmap.common.framework.business;

import org.springframework.context.ApplicationContext;

/**
 * TODO Write java docs comments for this type
 * 
 */

public abstract class AbstractFacadeImpl implements AbstractFacade{
	
	/** Spring Application context for container **/
	protected static  ApplicationContext appCtxt ;
	
	/** 
	 * Sets the container Application Context.  
	 * @param ApplicationContext ctxt
	 */ 
	public void setApplicationContext(ApplicationContext ctxt){
		this.appCtxt = ctxt;
	}

}
