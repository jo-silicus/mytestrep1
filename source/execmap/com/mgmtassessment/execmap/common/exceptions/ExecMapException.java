/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @author : DasAshim 
 *  @date   : Sep 1, 2006
 *  @version: 
 * 
 *  @history
 *  Description         Reference       Name        Date
 *               
 */

package com.mgmtassessment.execmap.common.exceptions;

import java.lang.Exception;
import java.util.ArrayList;
import java.util.List;


/**
 * This  is the base application Exception Class from which
 * all the Execmap application Exception will extend.
 * NOTE: All the business application Exception will be checked Exception.
 *  
 * TODO Write java docs comments for this type
 * 
 */

public abstract class ExecMapException extends Exception {
      
	/** Whether this Exception has been Logged **/
	private boolean logged = false;
	
	/** List of multiple exceptions **/
	private List exceptions = new ArrayList();
	
	/** Message args for the properties file **/
	private Object[] messageKeyArgs = null;
	
	/** Constructor for this clazz **/
	public ExecMapException(){
		super();
	}	
	/** Constructor for this clazz **/
	public ExecMapException(String msgKey){
		super(msgKey);
	}
	/** Constructor for this clazz **/
	public ExecMapException(Throwable cause){
		super(cause);
	}
	
	/** Constructor for this clazz **/
	public ExecMapException(String msgKey, Throwable cause){
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