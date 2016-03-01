/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : sharmrahu
 * @date : Aug 22, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.business.impl.user;

import java.util.Comparator;

import com.mgmtassessment.execmap.data.dao.types.CompanyUserMaster;

/**
 * Implementation of Comparator to compare two user objects and Sort Them
 * accordingly.
 */

public class CompareUserName implements Comparator {
    /**
     * Implementation of Compare function.
     *
     * @param object1
     *            first object to be compared.
     * @param object2
     *            second object against which fiest is compared.
     * @return integer, the value depends on which user has user name that
     *         arrives lexographically before the other one, if the two are the
     *         same the user ID's are compared lexographically.
     */
    public int compare(Object object1, Object object2) {
        CompanyUserMaster firstUser = (CompanyUserMaster)object1;
        CompanyUserMaster secondUser = (CompanyUserMaster)object2;
        // comparing user's first name
        String first = firstUser.getFirstName().trim();

        String second = secondUser.getFirstName().trim();
        if ("".equals(first)) {
            first = firstUser.getFirstName();
        }
        if ("".equals(second)) {
            second = secondUser.getFirstName();
        }
        int result = first.compareToIgnoreCase(second);
        if (result == 0) {
            // comparing user's last name
            first = firstUser.getLastName().trim();
            second = secondUser.getLastName().trim();
            if ("".equals(first)) {
                first = firstUser.getLastName();
            }
            if ("".equals(second)) {
                second = secondUser.getLastName();
            }
            result = first.compareToIgnoreCase(second);
        }
        if (result == 0) {
            // comparing user's userId
            first = firstUser.getComp_id().getUsrId().trim();
            second = secondUser.getComp_id().getUsrId().trim();
            if ("".equals(first)) {
                first = firstUser.getComp_id().getUsrId();
            }
            if ("".equals(second)) {
                second = secondUser.getComp_id().getUsrId();
            }
            result = first.compareToIgnoreCase(second);
        }
        return result;
    }

}
