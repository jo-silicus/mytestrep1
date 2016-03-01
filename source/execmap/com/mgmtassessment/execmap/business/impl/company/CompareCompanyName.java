/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : sharmrahu
 * @date : Aug 25, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.business.impl.company;

import java.util.Comparator;

import com.mgmtassessment.execmap.data.dao.types.CompanyAcctMaster;

/**
 * Implementation of Comparator to compare two company objects and Sort Them
 * accordingly.
 */
public class CompareCompanyName implements Comparator {
    /**
     * Implementation of Compare function.
     *
     * @param object1
     *            first object to be compared.
     * @param object2
     *            second object against which fiest is compared.
     * @return integer, the value depends on which company has name that arrives
     *         lexographically before the other one, if the two are the same
     *         then accound ID's are compared lexographically.
     */
    public int compare(Object object1, Object object2) {
        CompanyAcctMaster firstCompany = (CompanyAcctMaster)object1;
        CompanyAcctMaster secondCompany = (CompanyAcctMaster)object2;
        // comparing company Names
        String first = firstCompany.getCoName().trim();

        String second = secondCompany.getCoName().trim();
        if ("".equals(first)) {
            first = firstCompany.getCoName();

        }
        if ("".equals(second)) {
            second = secondCompany.getCoName();

        }

        int result = first.compareToIgnoreCase(second);
        if (result == 0) {
            // if dound same compare accountIDS
            first = firstCompany.getAcctId().trim();
            second = secondCompany.getAcctId().trim();
            if ("".equals(first)) {
                first = firstCompany.getAcctId();

            }
            if ("".equals(second)) {
                second = secondCompany.getAcctId();

            }

            result = first.compareToIgnoreCase(second);
        }
        return result;
    }

}
