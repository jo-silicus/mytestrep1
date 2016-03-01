/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @author : TODO 
 *  @date   : Jul 20, 2006
 *  @version: 
 * 
 *  @history
 *  Description         Reference       Name        Date
 *               
 */

package com.mgmtassessment.execmap.data.dao.types;


import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;



/**
 * TODO Write java docs comments for this type
 * 
 */

public class CompanyGroupMasterKey implements Serializable {
	
    /** identifier field */
    private String acctId;

    /** identifier field */
    private String grpId;

    /** full constructor */
    public CompanyGroupMasterKey(String acctId, String grpId) {
        this.acctId = acctId;
        this.grpId = grpId;
    }

    /** default constructor */
    public CompanyGroupMasterKey() {
    }

    public String getAcctId() {
        return this.acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    public String getGrpId() {
        return this.grpId.trim();
    }

    public void setGrpId(String grpId) {
        this.grpId = grpId.trim();
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("acctId", getAcctId())
            .append("grpId", getGrpId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof CompanyGroupMasterKey) ) return false;
        CompanyGroupMasterKey castOther = (CompanyGroupMasterKey) other;
        return new EqualsBuilder()
            .append(this.getAcctId(), castOther.getAcctId())
            .append(this.getGrpId(), castOther.getGrpId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAcctId())
            .append(getGrpId())
            .toHashCode();
    }
}