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

public class Activity extends AbstractModel{
	
	String activityDesc;
    int activityID;
    boolean enabled;
    boolean paid;

    public Activity(String activityDesc, int activityID, boolean enabled) {
        this.activityDesc = activityDesc;
        this.activityID = activityID;
        this.enabled = enabled;
    }

    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
    }

    public String getActivityDesc() {
        return activityDesc;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public int getActivityID() {
        return activityID;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public boolean getPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}