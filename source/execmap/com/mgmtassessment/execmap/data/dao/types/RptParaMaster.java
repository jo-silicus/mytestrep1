package com.mgmtassessment.execmap.data.dao.types;
// Generated Aug 3, 2006 6:56:56 PM by Hibernate Tools 3.1.0 beta3

import java.sql.Clob;


/**
 * RptParaMaster generated by hbm2java
 */

public class RptParaMaster  implements java.io.Serializable {


    // Fields    

     private String paraId;
     private Clob paraDesc;
     private String langId;
     private Integer version;


    // Constructors

    /** default constructor */
    public RptParaMaster() {
    }

    
    /** full constructor */
    public RptParaMaster(String paraId, Clob paraDesc, String langId, Integer version) {
        this.paraId = paraId;
        this.paraDesc = paraDesc;
        this.langId = langId;
        this.version = version;
    }
    

   
    // Property accessors

    public String getParaId() {
        return this.paraId;
    }
    
    public void setParaId(String paraId) {
        this.paraId = paraId;
    }

    public Clob getParaDesc() {
        return this.paraDesc;
    }
    
    public void setParaDesc(Clob paraDesc) {
        this.paraDesc = paraDesc;
    }

    public String getLangId() {
        return this.langId;
    }
    
    public void setLangId(String langId) {
        this.langId = langId;
    }

    public Integer getVersion() {
        return this.version;
    }
    
    public void setVersion(Integer version) {
        this.version = version;
    }
   








}
