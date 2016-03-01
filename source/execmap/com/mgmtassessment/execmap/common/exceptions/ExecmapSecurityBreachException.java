/**
 *  @Copyright Management Assessment Partners (MAP) AG
 *  All Rights Reserved.
 *  @author : singhrau
 *  @date   : Sep 13, 2006
 *  @version:
 *
 *  @history
 *  Description         Reference       Name        Date
 *
 */

package com.mgmtassessment.execmap.common.exceptions;

/**
 * This exception is thrown when there is a security breach.
 *
 */

public class ExecmapSecurityBreachException extends ExecMapException {
    
    /**
     * default constructor.
     */
    public ExecmapSecurityBreachException(){
        super();
    }
    /**
     * Constructor for ExecmapSecurityBreachException.
     * @param msg
     */
    public ExecmapSecurityBreachException(String msg){
        super(msg);
    }

    /**
     * Constructor for ExecmapSecurityBreachException.
     * @param msg which is to be displayed
     * @param ex
     */
    public ExecmapSecurityBreachException(String msg, Throwable ex){
        super(msg,ex);
    }

}
