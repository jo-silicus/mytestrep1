/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @Author : DasAshim
 *  @Date   : Jul 7, 2006
 *
 */
package com.mgmtassessment.execmap.common.framework.business;

import java.io.Serializable;
import java.util.Locale;

/**
 * TODO add description for this class
 *
 */
public abstract class AbstractModel implements Serializable{
	
	/** 
     * Possible modes 
     * 
     */
    public static final int REGISTER = 0;
    /** 
     * Possible modes 
     * 
     */
    public static final int MAINTAIN = 1;
    /** 
     * Possible modes 
     * 
     */
    public static final int ENQUIRY = 2;
    /** 
     * Possible modes 
     * 
     */
    public static final int NOMODE = 3;

    private int mode;
    
    /** The locale language for the user **/
    public Locale locale ;
        
    /**
	 * @return Returns the locale.
	 */
	public Locale getLocale() {
		return locale;
	}
	/**
	 * @param locale The locale to set.
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	/**
     * TODO add description
     * @return
     */
	public int getMode() {
		return mode;
	}
    /**
     * TODO add description
     * @param mode
     */
	public void setMode(int mode) {
		this.mode = mode;
	}
    
    
}
