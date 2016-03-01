/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : sharmrahu
 * @date : Aug 18, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.webapp.main.group.form;

import java.io.Serializable;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.common.framework.webapp.ExecmapForm;

/**
 * This class is a placeholder for form values.GroupSearchForm represents getter
 * and setter method for all the values that are going to present on JSP.
 */

public class GroupSearchForm extends ExecmapForm implements Serializable {
    /**
     * group List to be displayed.
     */
    private Collection groupList;

    /**
     * page Count used for counting pages of search.
     */
    private String     groupPageCount;

    /**
     * GroupID that can be used for searching.
     */
    private String     seachGroupID;

    /**
     * Selected GroupID.
     */
    private String     selectedGroup;

    /**
     * AccountId of all the groups.
     */
    private String     companyAccountID;

    /**
     * count From on group search page.
     */
    private String     groupCountFrom;

    /**
     * count To on group search page.
     */
    private String     groupCountTo;
    /**
     * groupId to which users will to be moved.
     */
    private String moveToGroupID;
    /**
     * hold all groups of the company.
     */
    private Collection totalGroupList;
    /**
     * max pages that can be there.
     */
    private String maxGroupPageCount;

    /**
     * @return Returns the groupCountTo.
     */
    public String getGroupCountTo() {
        return groupCountTo;
    }

    /**
     * @param groupCountTo
     *            The groupCountTo to set.
     */
    public void setGroupCountTo(String groupCountTo) {
        this.groupCountTo = groupCountTo;
    }

    /**
     * @return Returns the selectedGroup.
     */
    public String getSelectedGroup() {
        return selectedGroup;
    }

    /**
     * @param selectedGroup
     *            The selectedGroup to set.
     */
    public void setSelectedGroup(String selectedCompany) {
        this.selectedGroup = selectedCompany;
    }

    /**
     * @return Returns the groupList.
     */
    public Collection getGroupList() {
        return groupList;
    }

    /**
     * @param groupList
     *            The groupList to set.
     */
    public void setGroupList(Collection groupList) {
        this.groupList = groupList;
    }

    /**
     * @return Returns the groupPageCount.
     */
    public String getGroupPageCount() {
        return groupPageCount;
    }

    /**
     * @param groupPageCount
     *            The groupPageCount to set.
     */
    public void setGroupPageCount(String pageCount) {
        this.groupPageCount = pageCount;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        groupPageCount = null;
        groupList = null;
        seachGroupID = null;
        selectedGroup = null;
        companyAccountID = null;
        moveToGroupID=null;
    }

    /**
     * @return Returns the seachGroupID.
     */
    public String getSeachGroupID() {
        return seachGroupID;
    }

    /**
     * @param seachGroupID
     *            The seachGroupID to set.
     */
    public void setSeachGroupID(String seachGroupID) {
        this.seachGroupID = seachGroupID;
    }

    /**
     * @return Returns the companyAccountID.
     */
    public String getCompanyAccountID() {
        return companyAccountID;
    }

    /**
     * @param companyAccountID
     *            The companyAccountID to set.
     */
    public void setCompanyAccountID(String companyAccountID) {
        this.companyAccountID = companyAccountID;
    }

    /**
     * @return Returns the groupCountFrom.
     */
    public String getGroupCountFrom() {
        return groupCountFrom;
    }

    /**
     * @param groupCountFrom
     *            The groupCountFrom to set.
     */
    public void setGroupCountFrom(String groupCountFrom) {
        this.groupCountFrom = groupCountFrom;
    }

    /**
     * @return Returns the moveToGroupID.
     */
    public String getMoveToGroupID() {
        return moveToGroupID;
    }

    /**
     * @param moveToGroupID The moveToGroupID to set.
     */
    public void setMoveToGroupID(String moveToGroupID) {
        this.moveToGroupID = moveToGroupID;
    }

    /**
     * @return Returns the totalGroupList.
     */
    public Collection getTotalGroupList() {
        return totalGroupList;
    }

    /**
     * @param totalGroupList The totalGroupList to set.
     */
    public void setTotalGroupList(Collection totalGroupList) {
        this.totalGroupList = totalGroupList;
    }

    /**
     * @return Returns the maxGroupPageCount.
     */
    public String getMaxGroupPageCount() {
        return maxGroupPageCount;
    }

    /**
     * @param maxGroupPageCount The maxGroupPageCount to set.
     */
    public void setMaxGroupPageCount(String maxGroupPageCount) {
        this.maxGroupPageCount = maxGroupPageCount;
    }
}
