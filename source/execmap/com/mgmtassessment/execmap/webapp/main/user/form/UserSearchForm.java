/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : sharmrahu
 * @date : Aug 18, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.webapp.main.user.form;

import java.io.Serializable;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.common.framework.webapp.ExecmapForm;

/**
 * This class is a placeholder for form values.GroupSearchForm represents getter
 * and setter method for all the values that are going to present on JSP.
 */

public class UserSearchForm extends ExecmapForm implements Serializable {
    /**
     * group List to be displayed.
     */
    private Collection userList;

    /**
     * page Count used for counting pages of search.
     */
    private String     userPageCount;

    /**
     * max pages that can be there.
     */

    private String     maxUserPageCount;

    /**
     * UserID that can be used for searching.
     */
    private String     seachUserID;

    /**
     * Selected userID.
     */
    private String     selectedUser;

    /**
     * AccountId of all the users.
     */
    private String     companyAccountID;

    /**
     * GroupId of all the users.
     */
    private String     usersGroupID;

    /**
     * count From on group search page.
     */
    private String     userCountFrom;

    /**
     * count To on group search page.
     */
    private String     userCountTo;

    /**
     * collection conataining all the groups of a particular company
     */

    private Collection groupdetails;

    /**
     * goup seleted in the move user to dropdown box
     */

    private String     groupIdSelected;

    /**
     * @return Returns the userCountTo.
     */
    public String getUserCountTo() {
        return userCountTo;
    }

    /**
     * @param userCountTo
     *            The userCountTo to set.
     */
    public void setUserCountTo(String groupCountTo) {
        this.userCountTo = groupCountTo;
    }

    /**
     * @return Returns the selectedUser.
     */
    public String getSelectedUser() {
        return selectedUser;
    }

    /**
     * @param selectedUser
     *            The selectedUser to set.
     */
    public void setSelectedUser(String selectedCompany) {
        this.selectedUser = selectedCompany;
    }

    /**
     * @return Returns the userList.
     */
    public Collection getUserList() {
        return userList;
    }

    /**
     * @param userList
     *            The userList to set.
     */
    public void setUserList(Collection userList) {
        this.userList = userList;
    }

    /**
     * @return Returns the userPageCount.
     */
    public String getUserPageCount() {
        return userPageCount;
    }

    /**
     * @param userPageCount
     *            The userPageCount to set.
     */
    public void setUserPageCount(String pageCount) {
        this.userPageCount = pageCount;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        userPageCount = null;
        userList = null;
        seachUserID = null;
        selectedUser = null;
        companyAccountID = null;
        groupdetails = null;
        maxUserPageCount = null;
    }

    /**
     * @return Returns the seachUserID.
     */
    public String getSeachUserID() {
        return seachUserID;
    }

    /**
     * @param seachUserID
     *            The seachUserID to set.
     */
    public void setSeachUserID(String seachUserID) {
        this.seachUserID = seachUserID;
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
     * @return Returns the userCountFrom.
     */
    public String getUserCountFrom() {
        return userCountFrom;
    }

    /**
     * @param userCountFrom
     *            The userCountFrom to set.
     */
    public void setUserCountFrom(String userCountFrom) {
        this.userCountFrom = userCountFrom;
    }

    /**
     * @return Returns the usersGroupID.
     */
    public String getUsersGroupID() {
        return usersGroupID;
    }

    /**
     * @param usersGroupID
     *            The usersGroupID to set.
     */
    public void setUsersGroupID(String usersGroupID) {
        this.usersGroupID = usersGroupID;
    }

    /**
     * @return Returns the groupdetails.
     */
    public Collection getGroupdetails() {
        return groupdetails;
    }

    /**
     * @param groupdetails
     *            The groupdetails to set.
     */
    public void setGroupdetails(Collection groupdetails) {
        this.groupdetails = groupdetails;
    }

    /**
     * @return Returns the groupIdSelected.
     */
    public String getGroupIdSelected() {
        return groupIdSelected;
    }

    /**
     * @param groupIdSelected
     *            The groupIdSelected to set.
     */
    public void setGroupIdSelected(String groupIdSelected) {
        this.groupIdSelected = groupIdSelected;
    }

    /**
     * @return Returns the maxUserPageCount.
     */
    public String getMaxUserPageCount() {
        return maxUserPageCount;
    }

    /**
     * @param maxUserPageCount
     *            The maxUserPageCount to set.
     */
    public void setMaxUserPageCount(String maxUserPageCount) {
        this.maxUserPageCount = maxUserPageCount;
    }
}
