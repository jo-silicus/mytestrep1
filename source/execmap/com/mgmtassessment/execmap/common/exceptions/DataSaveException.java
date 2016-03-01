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
 * TODO Write java docs comments for this type
 * 
 */

public class DataSaveException extends ExecMapException{
	
	/**
	 * Constructor for DataSaveException
	 * @param msg
	 */
	public DataSaveException( String msg){
		super (msg);
	}
    
	/**
	 * Constructor for DataSaveException
	 * @param msg
	 * @param ex
	 */
	public DataSaveException( String msg, Throwable ex){
		super(msg,ex);
	}
}
