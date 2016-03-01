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

public class DataMoveException extends ExecMapException{
   
	/**
	 * Constructor for DataMoveException
	 * @param msg
	 */
	public DataMoveException( String msg){
		super(msg);
	}
	
	/**
	 * Constructor for DataMoveException
	 * @param msg
	 * @param ex
	 */
	public DataMoveException( String msg, Throwable ex){
		super ( msg,ex);
	}
}
