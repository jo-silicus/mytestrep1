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

package com.mgmtassessment.execmap.common.framework.webapp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import org.apache.struts.config.ExceptionConfig;

import com.mgmtassessment.execmap.common.exceptions.ExecMapException;
import com.mgmtassessment.execmap.common.exceptions.ExecMapRuntimeException;


/**
 * TODO Write java docs comments for this type
 * 
 */

public class ExecmapExceptionHandler extends ExceptionHandler{
	
	public ActionForward execute(Exception ex,
			                        ExceptionConfig config,
			                        ActionMapping mapping,
			                        ActionForm form,
			                        HttpServletRequest request,
			                        HttpServletResponse response)
	          throws ServletException{
		
		ActionForward forward = null;
		ActionMessage message = null;
		String property = null;
		
		/** 
		 * Get the path from input or Exception Element in the action 
		 * of struts-config.xml file.
		 */
		String path = null;
		if ( config.getPath() != null){
			path = config.getPath();
		}else{
			path = mapping.getInput();
		}
		
		forward = new ActionForward(path);
		
		/**
		 * Determine the type of exception thrown.
		 * The message key will have the key values
		 * matching in the properties file.
		 */
		
		if (ex instanceof ExecMapException ){
			ExecMapException execmapException = (ExecMapException)ex;
			String messageKey = execmapException.getMessage();
			Object[] messageArgs = execmapException.getMessageKeyArgs();
			/**
			 * If the properties file have args and 
			 * Exception thrown have set args then set it. 
			 */
			if (messageArgs != null && messageArgs.length > 0){
				message = new ActionMessage(messageKey,messageArgs);
			}else{
				message = new ActionMessage(messageKey);
			}
			
		}else if( ex instanceof ExecMapRuntimeException){
			ExecMapRuntimeException execmapRuntimeEx = (ExecMapRuntimeException)ex;
			String messageRkey = execmapRuntimeEx.getMessage();
			Object[] messageRargs = execmapRuntimeEx.getMessageKeyArgs();
			/**
			 * If the properties file have args and 
			 * Exception thrown have set args then set it. 
			 */
			if (messageRargs != null && messageRargs.length > 0){
				message = new ActionMessage(messageRkey, messageRargs);
			}else{
				message = new ActionMessage(messageRkey);
			}

		}else {
			/**
			 * Get the message Key in the under action
			 * exception element in the struts-config.xml
			 */
			message = new ActionMessage(config.getKey());
			property = message.getKey();
		}
		
		/**
		 * Store the error message in scope.
		 */
		storeException(request,property, message,forward, config.getScope());
		return forward;
	}

}
