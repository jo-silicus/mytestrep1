/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @author : TODO
 *  @date   : Jul 21, 2006
 *  @version: 
 * 
 *  @history
 *  Description         Reference       Name        Date
 *               
 */

package com.mgmtassessment.execmap.business.model;

import java.util.Hashtable;
import com.mgmtassessment.execmap.common.framework.business.AbstractModel;;

/**
 * TODO Write java docs comments for this type
 * 
 */

public class TestInfo extends AbstractModel{
	
	private String subTestID = null;
    private String trigramID = null;
    private Hashtable userAnswer = null;
    
	/**
	 * @return Returns the subTestID.
	 */
	public String getSubTestID() {
		return subTestID;
	}
	/**
	 * @param subTestID The subTestID to set.
	 */
	public void setSubTestID(String subTestID) {
		this.subTestID = subTestID;
	}
	/**
	 * @return Returns the trigramID.
	 */
	public String getTrigramID() {
		return trigramID;
	}
	/**
	 * @param trigramID The trigramID to set.
	 */
	public void setTrigramID(String trigramID) {
		this.trigramID = trigramID;
	}
	/**
	 * @return Returns the userAnswer.
	 */
	public Hashtable getUserAnswer() {
		return userAnswer;
	}
	/**
	 * @param userAnswer The userAnswer to set.
	 */
	public void setUserAnswer(Hashtable userAnswer) {
		this.userAnswer = userAnswer;
	}
}