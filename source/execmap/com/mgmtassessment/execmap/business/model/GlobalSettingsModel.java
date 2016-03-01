/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @Author : DasAshim
 *  @Date   : Jul 7, 2006
 *
 */
package com.mgmtassessment.execmap.business.model;

import com.mgmtassessment.execmap.common.framework.business.AbstractModel;



public class GlobalSettingsModel extends AbstractModel {

    String globalMngrUserId ;
    
    String globalMngrPwd ;
    
    String exchServerName ;
    
    String exchServerPortNo ;
    
    String exchServerUserId ;
    
    String exchServerPwd ;
    
    short sysMasId ;
    
    int  lstAcctNo ;
    
    short testDur ;
    
    String  intlcAcctId = null;

    /**
     * @return Returns the intlcAcctId.
     */
    public String getIntlcAcctId() {
        return intlcAcctId;
    }

    /**
     * @param intlcAcctId The intlcAcctId to set.
     */
    public void setIntlcAcctId(String intlcAcctId) {
        this.intlcAcctId = intlcAcctId;
    }

    

    

    

    /**
     * @return Returns the sysMasId.
     */
    public short getSysMasId() {
        return sysMasId;
    }

    /**
     * @param sysMasId The sysMasId to set.
     */
    public void setSysMasId(short sysMasId) {
        this.sysMasId = sysMasId;
    }

    /**
     * @return Returns the lstAcctNo.
     */
    public int getLstAcctNo() {
        return lstAcctNo;
    }

    /**
     * @param lstAcctNo The lstAcctNo to set.
     */
    public void setLstAcctNo(int lstAcctNo) {
        this.lstAcctNo = lstAcctNo;
    }

    /**
     * @return Returns the testDur.
     */
    public short getTestDur() {
        return testDur;
    }

    /**
     * @param testDur The testDur to set.
     */
    public void setTestDur(short testDur) {
        this.testDur = testDur;
    }

    /**
     * @return Returns the exchServerName.
     */
    public String getExchServerName() {
        return exchServerName;
    }

    /**
     * @param exchServerName The exchServerName to set.
     */
    public void setExchServerName(String exchServerName) {
        this.exchServerName = exchServerName;
    }

    /**
     * @return Returns the exchServerPortNo.
     */
    public String getExchServerPortNo() {
        return exchServerPortNo;
    }

    /**
     * @param exchServerPortNo The exchServerPortNo to set.
     */
    public void setExchServerPortNo(String exchServerPortNo) {
        this.exchServerPortNo = exchServerPortNo;
    }

    /**
     * @return Returns the exchServerPwd.
     */
    public String getExchServerPwd() {
        return exchServerPwd;
    }

    /**
     * @param exchServerPwd The exchServerPwd to set.
     */
    public void setExchServerPwd(String exchServerPwd) {
        this.exchServerPwd = exchServerPwd;
    }

    /**
     * @return Returns the exchServerUserId.
     */
    public String getExchServerUserId() {
        return exchServerUserId;
    }

    /**
     * @param exchServerUserId The exchServerUserId to set.
     */
    public void setExchServerUserId(String exchServerUserId) {
        this.exchServerUserId = exchServerUserId;
    }

    /**
     * @return Returns the globalMngrPwd.
     */
    public String getGlobalMngrPwd() {
        return globalMngrPwd;
    }

    /**
     * @param globalMngrPwd The globalMngrPwd to set.
     */
    public void setGlobalMngrPwd(String globalMngrPwd) {
        this.globalMngrPwd = globalMngrPwd;
    }

    /**
     * @return Returns the globalMngrUserId.
     */
    public String getGlobalMngrUserId() {
        return globalMngrUserId;
    }

    /**
     * @param globalMngrUserId The globalMngrUserId to set.
     */
    public void setGlobalMngrUserId(String globalMngrUserId) {
        this.globalMngrUserId = globalMngrUserId;
    }
	
}
