/**
 *  @Copyright Management Assessment Partners (MAP) AG
 *  All Rights Reserved.
 *
 *  @author : sharmrahu
 *  @date   : Sep 14, 2006
 *  @version:
 *
 *  @history
 *  Description         Reference       Name        Date
 *
 */

package com.mgmtassessment.execmap.common.exceptions;

/**
 * TODO Write java docs comments for this type
 * 
 */

public class ExecMapScriptException
        extends ExecMapException {
    /**
     * default constructor.
     */
    public ExecMapScriptException(){
        super();
    }
    /**
     * Constructor for ExecMapScriptException.
     * @param msg
     */
    public ExecMapScriptException(String msg){
        super(msg);
    }

    /**
     * Constructor for ExecMapScriptException.
     * @param msg which is to be displayed
     * @param ex
     */
    public ExecMapScriptException(String msg, Throwable ex){
        super(msg,ex);
    }

}
