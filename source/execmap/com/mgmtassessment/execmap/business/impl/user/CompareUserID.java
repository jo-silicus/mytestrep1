/**
 *  @Copyright Management Assessment Partners (MAP) AG
 *  All Rights Reserved.
 *
 *  @author : sharmrahu
 *  @date   : Aug 22, 2006
 *  @version:
 *
 *  @history
 *  Description         Reference       Name        Date
 *
 */

package com.mgmtassessment.execmap.business.impl.user;

import java.util.Comparator;

import com.mgmtassessment.execmap.data.dao.types.CompanyUserMaster;

/**
 * Implementation of Comparator to compare two user objects and Sort Them
 * accordingly.
 */


public class CompareUserID implements Comparator {
    /**
     * Implementation of Compare function.
     * 
     * @param o1
     * @param o2
     * @return
     */
    public int compare(Object o1, Object o2) {
        CompanyUserMaster firstUser= (CompanyUserMaster) o1;
        CompanyUserMaster secondUser = (CompanyUserMaster) o2;
        int result = firstUser.getComp_id().getUsrId().compareTo(
                secondUser.getComp_id().getUsrId());
        return result;
    }

}
