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

public class DataDeleteException extends ExecMapException {
    
	/**
	 * Constructor for DataDeleteException
	 * @param msg
	 */
	public DataDeleteException (String msg){
		super(msg);
	}
	
	/**
	 * Constructor for DataDeleteException
	 * @param msg
	 * @param ex
	 */
	public DataDeleteException(String msg, Throwable ex){
		super( msg,ex);
	}
}
