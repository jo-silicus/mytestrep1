/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @author : DasAshim 
 *  @date   : Sep 4, 2006
 *  @version: 
 * 
 *  @history
 *  Description         Reference       Name        Date
 *               
 */

package com.mgmtassessment.execmap.common.exceptions;

import com.mgmtassessment.execmap.common.exceptions.ExecMapException;


/**
 * 
 * This is a checked exception for data not found.
 * TODO Write java docs comments for this type
 * 
 */

public class DataNotFoundException extends ExecMapException {

	
	/**
	 * Constructor for DataNotFoundException
	 * @param msg
	 */
	public DataNotFoundException(String msg){
		super(msg);
	}
	
	/**
	 * Constructor for DataNotFoundException
	 * @param msg
	 * @param ex
	 */
	public DataNotFoundException(String msg, Throwable ex){
		super(msg,ex);
	}
}
