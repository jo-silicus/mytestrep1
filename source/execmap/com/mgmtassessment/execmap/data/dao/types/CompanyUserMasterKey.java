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

public class CompanyUserMasterKey implements Serializable{
	
    /** identifier field */
    private String acctId;


    /** identifier field */
    private String usrId;

    /** full constructor */
    public CompanyUserMasterKey(String acctId, String usrId) {
        this.acctId = acctId;
        this.usrId = usrId;

    }

    /** default constructor */
    public CompanyUserMasterKey() {
    }

    public String getAcctId() {
        return this.acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    public String getUsrId() {
        return this.usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }


    public String toString() {
        return new ToStringBuilder(this)
            .append("acctId", getAcctId())
            .append("usrId", getUsrId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof CompanyUserMasterKey) ) return false;
        CompanyUserMasterKey castOther = (CompanyUserMasterKey) other;
        return new EqualsBuilder()
            .append(this.getAcctId(), castOther.getAcctId())
            .append(this.getUsrId(), castOther.getUsrId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAcctId())
            .append(getUsrId())
            .toHashCode();
    }

}