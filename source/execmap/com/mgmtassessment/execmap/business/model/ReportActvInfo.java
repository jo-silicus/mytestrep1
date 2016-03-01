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

import com.mgmtassessment.execmap.common.framework.business.AbstractModel;
import com.mgmtassessment.execmap.business.model.Activity;
/**
 * TODO Write java docs comments for this type
 * 
 */

public class ReportActvInfo extends AbstractModel{
	
	String accountType;
    String cobrandImage;
    boolean customizationFlag;
    boolean welfareFlag;
    int categoryID;
    int subCategoryID;
    int roleID;
    Activity[] activities;
    Vector roleActivities;
    
    

    public void setRoleActivities(Vector roleActivities) {
        this.roleActivities = roleActivities;
    }

    public Vector getRoleActivities() {
        return roleActivities;
    }

    public void setCobrandImage(String cobrandImage) {
        this.cobrandImage = cobrandImage;
    }

    public String getCobrandImage() {
        return cobrandImage;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setCustomizationFlag(boolean customizationFlag) {
        this.customizationFlag = customizationFlag;
    }

    public boolean getCustomizationFlag() {
        return customizationFlag;
    }

    public void setWelfareFlag(boolean welfareFlag) {
        this.welfareFlag = welfareFlag;
    }

    public boolean getWelfareFlag() {
        return welfareFlag;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setActivities(Activity[] activities) {
        this.activities = activities;
    }

    public Activity[] getActivities() {
        return activities;
    }
}