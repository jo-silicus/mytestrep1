/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @author : DasAshim 
 *  @date   : Aug 21, 2006
 *  @version: 
 * 
 *  @history
 *  Description         Reference       Name        Date
 *               
 */

package com.mgmtassessment.execmap.common.util.webapp;

import java.io.Serializable;
import java.util.Locale;

import com.mgmtassessment.execmap.common.util.webapp.AnswerModel;

/**
 * This model will have all the data related to save
 * answer for a session.
 * TODO Write java docs comments for this type
 * 
 */

public class AnswerSaveModel implements Serializable {
	
	/** Answer Model stored in the session **/
	public AnswerModel ansModel;
	
	/** Account Id of the Company user **/
	public String accountId;
	
	/** User ID of assessment taker **/
	public String userId;
	
	/** Session ID **/
	public String sessionId;
		
	/**
	 * @return Returns the accountId.
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId The accountId to set.
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return Returns the ansModel.
	 */
	public AnswerModel getAnsModel() {
		return ansModel;
	}

	/**
	 * @param ansModel The ansModel to set.
	 */
	public void setAnsModel(AnswerModel ansModel) {
		this.ansModel = ansModel;
	}

	
	

	/**
	 * @return Returns the sessionId.
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId The sessionId to set.
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return Returns the userId.
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId The userId to set.
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	

}
