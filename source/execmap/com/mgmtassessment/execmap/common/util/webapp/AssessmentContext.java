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

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import com.mgmtassessment.execmap.common.util.webapp.AnswerModel;

/**
 * TODO Write java docs comments for this type
 * 
 */

public class AssessmentContext implements HttpSessionBindingListener, Serializable  {
        
	    private AnswerModel assessmentAns;
	    

	 
	    /**
	     * public Constructor
	     *
	     */
	    public AssessmentContext(){
		super();
		assessmentAns = new AnswerModel();
			
		}
	    
	    
	    /**
	    * The container calls this method when it is being 
	    * unbound from the Session 
	    */

	    public void valueUnbound(HttpSessionBindingEvent event){
	    	assessmentAns = null;
	    }
	    
	    /**
	    * The container calls this method when it is being 
	    * bound to the Session
	    * 
	    */ 

	    public void valueBound(HttpSessionBindingEvent event){
	    /** Do nothing **/
	    }


		/**
		 * @return Returns the assessmentAns.
		 */
		public AnswerModel getAssessmentAns() {
			return assessmentAns;
		}


		/**
		 * @param assessmentAns The assessmentAns to set.
		 */
		public void setAssessmentAns(AnswerModel assessmentAns) {
			this.assessmentAns = assessmentAns;
		}
}