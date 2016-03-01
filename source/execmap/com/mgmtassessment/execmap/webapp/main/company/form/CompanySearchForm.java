/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : sharmrahu
 * @date : Aug 17, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.webapp.main.company.form;

import java.io.Serializable;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.common.framework.webapp.ExecmapForm;

/**
 * This class is a placeholder for form values.CompanySearchForm represents
 * getter and setter method for all the values that are going to present on JSP.
 */

public class CompanySearchForm extends ExecmapForm implements Serializable {
    /**
     * company list to be displayed.
     */
    private Collection companyList;

    /**
     * page Count used for counting pages of search.
     */
    private String     pageCount;
    /**
     * maximum page of search result.
     */
    private String     maxCompanyPageCount;

    /**
     * Company name that can be used for searching.
     */
    private String     seachCompanyName;

    /**
     * Selected company's account Id.
     */
    private String     selectedCompany;

    /**
     * count From on company search page.
     */
    private String     companyCountFrom;

    /**
     * count To on company search page.
     */
    private String     companyCountTo;

    /**
     * @return Returns the companyCountFrom.
     */
    public String getCompanyCountFrom() {
        return companyCountFrom;
    }

    /**
     * @param companyCountFrom
     *            The companyCountFrom to set.
     */
    public void setCompanyCountFrom(String companyCountFrom) {
        this.companyCountFrom = companyCountFrom;
    }

    /**
     * @return Returns the companyCountTo.
     */
    public String getCompanyCountTo() {
        return companyCountTo;
    }

    /**
     * @param companyCountTo
     *            The companyCountTo to set.
     */
    public void setCompanyCountTo(String companyCountTo) {
        this.companyCountTo = companyCountTo;
    }

    /**
     * @return Returns the selectedCompany.
     */
    public String getSelectedCompany() {
        return selectedCompany;
    }

    /**
     * @param selectedCompany
     *            The selectedCompany to set.
     */
    public void setSelectedCompany(String selectedCompany) {
        this.selectedCompany = selectedCompany;
    }

    /**
     * @return Returns the companyList.
     */
    public Collection getCompanyList() {
        return companyList;
    }

    /**
     * @param companyList
     *            The companyList to set.
     */
    public void setCompanyList(Collection companyList) {
        this.companyList = companyList;
    }

    /**
     * @return Returns the pageCount.
     */
    public String getPageCount() {
        return pageCount;
    }

    /**
     * @param pageCount
     *            The pageCount to set.
     */
    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        pageCount = null;
        companyList = null;
        seachCompanyName = null;
        selectedCompany = null;
    }

    /**
     * @return Returns the seachCompanyName.
     */
    public String getSeachCompanyName() {
        return seachCompanyName;
    }

    /**
     * @param seachCompanyName
     *            The seachCompanyName to set.
     */
    public void setSeachCompanyName(String seachCompanyName) {
        this.seachCompanyName = seachCompanyName;
    }

    /**
     * @return Returns the maxCompanyPageCount.
     */
    public String getMaxCompanyPageCount() {
        return maxCompanyPageCount;
    }

    /**
     * @param maxCompanyPageCount The maxCompanyPageCount to set.
     */
    public void setMaxCompanyPageCount(String maxCompanyPageCount) {
        this.maxCompanyPageCount = maxCompanyPageCount;
    }
}
