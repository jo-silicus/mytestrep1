/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : sharmrahu
 * @date : Aug 22, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.business.impl.group;

import java.util.Comparator;

import com.mgmtassessment.execmap.data.dao.types.CompanyGroupMaster;

/**
 * Implementation of Comparator to compare two group Abjects and Sort Them
 * accordingly.
 */

public class CompareGroupID implements Comparator {
    /**
     * Implementation of Compare function.
     *
     * @param object1
     *            first object to be compared.
     * @param object2
     *            second object against which fiest is compared.
     * @return integer, the value depends on which group has group ID that
     *         arrives lexographically before the other one.
     */
    public int compare(Object object1, Object object2) {
        CompanyGroupMaster firstGroup = (CompanyGroupMaster)object1;
        CompanyGroupMaster secondGroup = (CompanyGroupMaster)object2;
        // comparing group ID's
        String first = firstGroup.getComp_id().getGrpId().trim();

        String second = secondGroup.getComp_id().getGrpId().trim();
        if ("".equals(first)) {
            first = firstGroup.getComp_id().getGrpId();

        }
        if ("".equals(second)) {
            second = secondGroup.getComp_id().getGrpId();

        }
        int result = first.compareToIgnoreCase(second);
        return result;
    }

}
