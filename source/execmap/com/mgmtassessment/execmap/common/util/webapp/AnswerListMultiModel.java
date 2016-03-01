/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @author : DasAshim 
 *  @date   : Aug 17, 2006
 *  @version: 
 * 
 *  @history
 *  Description         Reference       Name        Date
 *               
 */

package com.mgmtassessment.execmap.common.util.webapp;

import java.io.Serializable;

/**
 * TODO Write java docs comments for this type
 * 
 */

public class AnswerListMultiModel implements Serializable{
	
	/** 
	 * Stores the Answer for start position for a sub-test 
	 * for a trigram. This attribute would remian null
	 * for assessments that doesn't require to store 
	 * Start position.
	 *  
	 */
	public Byte answerNoStartPos = null;
	
	
	
	/** 
	 * Stores the Answer for end position for a sub-test 
	 * for a trigram. This attribute would remian null
	 * for assessments that doesn't require to store 
	 * End position.
	 *  
	 */
	public Byte answerNoEndPos = null;



	/**
	 * @return Returns the answerNoEndPos.
	 */
	public Byte getAnswerNoEndPos() {
		return answerNoEndPos;
	}



	/**
	 * @param answerNoEndPos The answerNoEndPos to set.
	 */
	public void setAnswerNoEndPos(Byte answerNoEndPos) {
		this.answerNoEndPos = answerNoEndPos;
	}



	/**
	 * @return Returns the answerNoStartPos.
	 */
	public Byte getAnswerNoStartPos() {
		return answerNoStartPos;
	}



	/**
	 * @param answerNoStartPos The answerNoStartPos to set.
	 */
	public void setAnswerNoStartPos(Byte answerNoStartPos) {
		this.answerNoStartPos = answerNoStartPos;
	}
	
	

}
