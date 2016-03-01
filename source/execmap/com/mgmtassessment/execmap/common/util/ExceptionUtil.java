/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @author : DasAshim 
 *  @date   : Sep 3, 2006
 *  @version: 
 * 
 *  @history
 *  Description         Reference       Name        Date
 *               
 */

package com.mgmtassessment.execmap.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.StackTraceElement;

import com.mgmtassessment.execmap.common.exceptions.ExecMapException;
import com.mgmtassessment.execmap.common.exceptions.ExecMapRuntimeException;


/**
 * A helper Singleton class to convert Exception stack trace
 * into string format. Primarily used for logging
 * purpose.
 * TODO Write java docs comments for this type
 * 
 */

public final class ExceptionUtil {
	
	private static ExceptionUtil instance;
	
	/**
	 * private Constructor;
	 */
	private ExceptionUtil(){
		
	}
	
	/**
	 * 
	 * @return
	 */
	public static ExceptionUtil getInstance(){
		if (instance == null)
			instance = new ExceptionUtil();
		return instance;
	}
	
	/** Buffer size set for displaing the log mesages **/
	private static final int INIT_BUFFER_SIZE = 1024;
	
	/**
	 * This method returns the stack trace of the exception.
	 * @param emapEx
	 * @return
	 */	
	public String getDetailedMessage(ExecMapException emapEx){
		
		StringBuffer msg = new StringBuffer(INIT_BUFFER_SIZE);
		
		msg.append("Exception Stack Trace\n");
        try {
            StringWriter sw = new StringWriter(INIT_BUFFER_SIZE);
            PrintWriter pw = new PrintWriter(sw);
            emapEx.printStackTrace(pw);
            msg.append(sw.toString());
            sw.close();
        } catch (Exception e) {
            msg.append(emapEx.toString());
        }
        Throwable rootCause = emapEx.getCause();
        if (rootCause != null) {
            msg.append("\n Root Exception Stack Trace : ");
            msg.append(rootCause.toString());
            msg.append("\n");
            try {
                StringWriter sw = new StringWriter(INIT_BUFFER_SIZE);
                PrintWriter pw = new PrintWriter(sw);
                rootCause.printStackTrace(pw);
                msg.append(sw.toString());
                sw.close();
            } catch (Exception e) {
                msg.append(rootCause.toString());
            }
        }
        return msg.toString();
	}
    
	/**
	 * This method returns a string of exact class name,
	 * method name and line number where the exception
	 * occured. Use this method if you need exact location
	 * where the exception occured rather than the entire
	 * stack trace.
	 * 
	 * @param ex
	 * @return
	 */
	
	public String getPreciseExceptionMessage(ExecMapException ex){
		
		StringBuffer msg = new StringBuffer(INIT_BUFFER_SIZE);
		msg.append("Exception Precise Trace\n");
		StackTraceElement elements[] = ex.getStackTrace();
		for(int i = 0, n = elements.length; i < n; i++ ){
			msg.append("Class Name :");
			msg.append(elements[i].getClassName());
			msg.append("Method :");
			msg.append(elements[i].getMethodName());
			msg.append("Line Number :");
			msg.append(elements[i].getLineNumber());
		}
		return msg.toString();
	}
	
	
	/**
	 * This method returns the stack trace of the exception.
	 * @param emapEx
	 * @return
	 */	
	public String getRuntimeExceptionDetailMessage(ExecMapRuntimeException emapEx){
		
		StringBuffer msg = new StringBuffer(INIT_BUFFER_SIZE);
		
		msg.append("RuntimeException Stack Trace\n");
        try {
            StringWriter sw = new StringWriter(INIT_BUFFER_SIZE);
            PrintWriter pw = new PrintWriter(sw);
            emapEx.printStackTrace(pw);
            msg.append(sw.toString());
            sw.close();
        } catch (Exception e) {
            msg.append(emapEx.toString());
        }
        Throwable rootCause = emapEx.getCause();
        if (rootCause != null) {
            msg.append("\n Root Runtime Exception Stack Trace : ");
            msg.append(rootCause.toString());
            msg.append("\n");
            try {
                StringWriter sw = new StringWriter(INIT_BUFFER_SIZE);
                PrintWriter pw = new PrintWriter(sw);
                rootCause.printStackTrace(pw);
                msg.append(sw.toString());
                sw.close();
            } catch (Exception e) {
                msg.append(rootCause.toString());
            }
        }
        return msg.toString();
	}
}