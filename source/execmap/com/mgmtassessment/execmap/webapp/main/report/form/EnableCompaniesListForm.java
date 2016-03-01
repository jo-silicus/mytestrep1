/**
 *  @Copyright Management Assessment Partners (MAP) AG
 *  All Rights Reserved.
 *
 *  @author : goenkani
 *  @date   : Aug 11, 2006
 *  @version:
 *
 *  @history
 *  This class is used to populate the jsp with enable companies information.
 */

package com.mgmtassessment.execmap.webapp.main.report.form;

import java.util.List;

import com.mgmtassessment.execmap.common.framework.webapp.ExecmapForm;

/**
 * Action Form used to populate jsp for List of Enable Companies.
 */

public class EnableCompaniesListForm extends ExecmapForm {

   /**
    * List contains the information of enabled companies.
    */
   private List enableCompanies = null;

   /**
    * Status Field determines whether process for
    * enabled companies or disabled companies.
    */
   private String status = null;
   /**
    * @return Returns the status.
    */
   public String getStatus() {
       return status;
   }

   /**
    * @param status The status to set.
    */
   public void setStatus(String status) {
       this.status = status;
   }

   /**
    * @return Returns the enableCompanies.
    */
   public List getEnableCompanies() {
       return enableCompanies;
   }

   /**
    * @param enableCompanies The enableCompanies to set.
    */
   public void setEnableCompanies(List enableCompanies) {
       this.enableCompanies = enableCompanies;
   }
}