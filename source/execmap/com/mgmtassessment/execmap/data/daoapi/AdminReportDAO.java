/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @author : sharmrahu 
 *  @date   : Jul 21, 2006
 *  @version: 
 * 
 *  @history
 *  Description         Reference       Name        Date
 *               
 */

package com.mgmtassessment.execmap.data.daoapi;

import com.mgmtassessment.execmap.data.dao.types.CompanyAcctMaster;

/**
 * TODO Write java docs comments for this type
 * 
 */

public interface AdminReportDAO {

	/**
	 * TODO add comments for this method
	 * @param id
	 * @return
	 */
	public abstract CompanyAcctMaster getCompanyDetails(String id);
	
}
