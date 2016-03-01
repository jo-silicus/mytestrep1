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
import java.util.ArrayList;
import java.util.List;

import com.mgmtassessment.execmap.common.util.webapp.AnswerListMultiModel;

/**
 * This class primarily contains three attributes and an
 * additional attribute of the type List for collecting
 * those answers which has multiple from and to positions.
 * As this class is designed to be stored in the session,
 * do not initialize the list unless it is required.
 * Since most of the assessment would not require to 
 * store the assessment from and to answers.
 * As of now only NST assessment would require the initialization
 * of the <code> AnswerListMultiModel </code>  
 * 
 * 
 * TODO Write java docs comments for this type
 * 
 */

public class AnswerListModel implements Serializable {

		
	
	/** 
	 * Stores the collection of answer types which require
	 * from and to positions.
	 */
	
	public List<AnswerListMultiModel> multiAnsModel = null;

	
	/** Question for a sub-test for a trigram **/
	public Byte testQuestionId = null;
  	
	/**
	 * Stores the Answer No for a sub-test for a trigram.
	 *  
	 */  
	
	public Byte answerNo = null;
	
		
	/**
	 * @return Returns the answerNo.
	 */
	public Byte getAnswerNo() {
		return answerNo;
	}


	/**
	 * @param answerNo The answerNo to set.
	 */
	public void setAnswerNo(Byte answerNo) {
		this.answerNo = answerNo;
	}

	/**
	 * @return Returns the multiAnsModel.
	 */
	public List<AnswerListMultiModel> getMultiAnsModel() {
		return multiAnsModel;
	}

	/**
	 * @param multiAnsModel The multiAnsModel to set.
	 */
	public void setMultiAnsModel(List<AnswerListMultiModel> multiAnsModel) {
		this.multiAnsModel = multiAnsModel;
	}


	/**
	 * @return Returns the testQuestionId.
	 */
	public Byte getTestQuestionId() {
		return testQuestionId;
	}


	/**
	 * @param testQuestionId The testQuestionId to set.
	 */
	public void setTestQuestionId(Byte testQuestionId) {
		this.testQuestionId = testQuestionId;
	}
	
}
