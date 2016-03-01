/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @author : goenkani 
 *  @date   : Aug 16, 2006
 *  @version: 
 * 
 *  @history
 *  Description         Reference       Name        Date
 *               
 */

package com.mgmtassessment.execmap.webapp.main.login.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapForm;


/**
 * TODO Write java docs comments for this type
 * 
 */

public class LoginStubForm extends ExecmapForm{

    private String acctid = null;

    private String userid = null;

    /**
     * @return Returns the acctid.
     */
    public String getAcctid() {
        return acctid;
    }
    /**
     * @param acctid The acctid to set.
     */
    public void setAcctid(String acctid) {
        this.acctid = acctid;
    }
    /**
     * @return Returns the userid.
     */
    public String getUserid() {
        return userid;
    }
    /**
     * @param userid The userid to set.
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }
}