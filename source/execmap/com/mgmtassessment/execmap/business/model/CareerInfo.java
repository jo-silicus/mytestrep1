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

import java.util.Vector;
import java.util.Hashtable;

import com.mgmtassessment.execmap.common.framework.business.AbstractModel;
/**
 * TODO Write java docs comments for this type
 * 
 */

public class CareerInfo extends AbstractModel {
	
	public Hashtable getCareerTemplate() {
        return careerTemplate;
    }

    public void setCareerTemplate(Hashtable careerTemplate) {
        this.careerTemplate = careerTemplate;
    }

    public Hashtable getCareers() {
        return careers;
    }

    public void setCareers(Hashtable careers) {
        this.careers = careers;
    }

    public Vector getGeneralAbility() {
        return generalAbility;
    }

    public void setGeneralAbility(Vector generalAbility) {
        this.generalAbility = generalAbility;
    }

    public Vector getEducationalAbility() {
        return educationalAbility;
    }

    public void setEducationalAbility(Vector educationalAbility) {
        this.educationalAbility = educationalAbility;
    }

    public Vector getManagerialAbility() {
        return managerialAbility;
    }

    public void setManagerialAbility(Vector managerialAbility) {
        this.managerialAbility = managerialAbility;
    }

    private Hashtable careers;
    private Hashtable careerTemplate;
    private Vector generalAbility;
    private Vector educationalAbility;
    private Vector managerialAbility;
}
