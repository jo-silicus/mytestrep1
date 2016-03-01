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

import com.mgmtassessment.execmap.common.framework.business.AbstractModel;

/**
 * TODO Write java docs comments for this type
 * 
 */




public class FeedBackInfo extends AbstractModel {
	
   private String trigramDescription;
   private String motivationalText;
   private int leftDay;
   private String image;
   private int noOfTestLeft;
   private float timeRequired;
   
   
   /**
    * @return Returns the image.
    */
    public String getImage() {
	  return image;
    }
    /**
     *  @param image The image to set.
     */
    public void setImage(String image) {
	 this.image = image;
    }
   /**
    * @return Returns the leftDay.
    */
    public int getLeftDay() {
	  return leftDay;
    }
   /**
    * @param leftDay The leftDay to set.
    */
    public void setLeftDay(int leftDay) {
	 this.leftDay = leftDay;
    }
   /**
    * @return Returns the motivationalText.
    */
    public String getMotivationalText() {
	  return motivationalText;
    }
   /**
    * @param motivationalText The motivationalText to set.
    */
    public void setMotivationalText(String motivationalText) {
	 this.motivationalText = motivationalText;
    }
   /**
    * @return Returns the noOfTestLeft.
    */
    public int getNoOfTestLeft() {
	 return noOfTestLeft;
    }

	/**
	 * @param noOfTestLeft
	 *            The noOfTestLeft to set.
	 */
	public void setNoOfTestLeft(int noOfTestLeft) {
		this.noOfTestLeft = noOfTestLeft;
	}

	/**
	 * @return Returns the timeRequired.
	 */
	public float getTimeRequired() {
		return timeRequired;
	}

	/**
	 * @param timeRequired
	 *            The timeRequired to set.
	 */
	public void setTimeRequired(float timeRequired) {
		this.timeRequired = timeRequired;
	}

	/**
	 * @return Returns the trigramDescription.
	 */
	public String getTrigramDescription() {
		return trigramDescription;
	}

	/**
	 * @param trigramDescription
	 *            The trigramDescription to set.
	 */
	public void setTrigramDescription(String trigramDescription) {
		this.trigramDescription = trigramDescription;
	}
}