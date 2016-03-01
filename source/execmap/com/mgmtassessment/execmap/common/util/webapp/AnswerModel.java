/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @author : DasAshim 
 *  @date   : Aug 16, 2006
 *  @version: 
 * 
 *  @history
 *  Description         Reference       Name        Date
 *               
 */

package com.mgmtassessment.execmap.common.util.webapp;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;


/**
 * TODO Write java docs comments for this type
 * 
 */

public class AnswerModel implements Serializable{
	
	public String triGram = null;
	
	/**
	 * This attribute stores the number of times the activity
	 * has expired due to time out, before the user was able 
	 * to click finish button. This attribute will not be reset
	 * when a new trigram activity starts, since this value will
	 * be stored for a user session. The value of this attribute
	 * will be persisted when the user completes a set of assessment
	 * or completes fully assessment in a session. 
	 * 
	 */ 
	
	public Byte timesActivityExpired = 0;
	
	/**
	 * This attribute stores the number of times the user
	 * have changed answers for the entire session. 
	 * This attribute will not be reset  when a new trigram 
	 * activity starts, since this value will
	 * be stored for a user session. The value of this attribute
	 * will be persisted when the user completes a set of assessment
	 * or completes fully assessment in a session. 
	 * 
	 */
	
	public Byte timesAnswerChanged = 0;
	
	
	
	public List<AnswerListModel> answerList = null;
	
    /** Public Constructor **/
	public AnswerModel(){
		super();
		answerList = new ArrayList<AnswerListModel>();
		
	}
	
	
	/**
	 * @return Returns the answerList.
	 */
	public List getAnswerList() {
		return answerList;
	}

	/**
	 * @param answerList The answerList to set.
	 */
	public void setAnswerList(List answerList) {
		this.answerList = answerList;
	}

	/**
	 * @return Returns the triGram.
	 */
	public String getTriGram() {
		return triGram;
	}

	/**
	 * @param triGram The triGram to set.
	 */
	public void setTriGram(String triGram) {
		this.triGram = triGram;
	}
	
	/**
	 * This method adds AnswerListModel to the list of answers. 
	 * @param ansModel
	 */
	public void addAnswerModel(AnswerListModel ansModel ){
				
		answerList.add(ansModel);
		
	}
	
	/**
	 * This method removes all objects from the answer list.
	 *
	 */
	public void removeAnswerList(){
		
		answerList.clear();
				
	}


	/**
	 * @return Returns the timesActivityExpired.
	 */
	public Byte getTimesActivityExpired() {
		return timesActivityExpired;
	}


	/**
	 * @param timesActivityExpired The timesActivityExpired to set.
	 */
	public void setTimesActivityExpired(Byte timesActivityExpired) {
		this.timesActivityExpired = timesActivityExpired;
	}


	/**
	 * @return Returns the timesAnswerChanged.
	 */
	public Byte getTimesAnswerChanged() {
		return timesAnswerChanged;
	}


	/**
	 * @param timesAnswerChanged The timesAnswerChanged to set.
	 */
	public void setTimesAnswerChanged(Byte timesAnswerChanged) {
		this.timesAnswerChanged = timesAnswerChanged;
	}


}
