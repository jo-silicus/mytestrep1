/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @author : DasAshim 
 *  @date   : Sep 2, 2006
 *  @version: 
 * 
 *  @history
 *  Description         Reference       Name        Date
 *               
 */

package com.mgmtassessment.execmap.common.exceptions;

import java.lang.RuntimeException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This  is the base application RuntimeException Class from which
 * application RuntimeException will extend.
 * NOTE: All the RuntimeException will be unchecked Exception.
 *  
 * TODO Write java docs comments for this type
 * 
 */
 
public class ExecMapRuntimeException extends RuntimeException{
	
	
	/** Whether this Exception has been Logged **/
	private boolean logged = false;
	
	/** List of multiple exceptions **/
	private List exceptions = new ArrayList();
	
	/** Message args for the properties file **/
	private Object[] messageKeyArgs = null;
	
	/** Constructor for this clazz **/
	public ExecMapRuntimeException(){
		super();
	}	
	/** Constructor for this clazz **/
	public ExecMapRuntimeException(String msgKey){
		super(msgKey);
	}
	/** Constructor for this clazz **/
	public ExecMapRuntimeException(Throwable cause){
		super(cause);
	}
	
	/** Constructor for this clazz **/
	public ExecMapRuntimeException(String msgKey, Throwable cause){
		super(msgKey, cause);
	}
	
    /**
	 * @param logged The logged to set.
	 */
	public void setLogged(boolean logged) {
		this.logged = logged;
	}

	/**
	 * @return Returns if this exception is logged.
	 */
	public boolean isLogged() {
		return logged;
	}
	/**
	 * @return Returns the exceptions.
	 */
	public List getExceptions() {
		return exceptions;
	}
	/**
	 * @param exceptions The exceptions to set.
	 */
	public void setExceptions(List exceptions) {
		this.exceptions = exceptions;
	}
	
	/**
	 * @return Returns the messageKeyArgs.
	 */
	public Object[] getMessageKeyArgs() {
		return messageKeyArgs;
	}
	/**
	 * @param messageKeyArgs The messageKeyArgs to set.
	 */
	public void setMessageKeyArgs(Object[] messageKeyArgs) {
		this.messageKeyArgs = messageKeyArgs;
	}
}