package com.mgmtassessment.execmap.data.dao.types;
// Generated Aug 3, 2006 6:56:57 PM by Hibernate Tools 3.1.0 beta3



/**
 * RptParaDetKey generated by hbm2java
 */

public class RptParaDetKey  implements java.io.Serializable {


    // Fields    

     private Short rptId;
     private Short condId;


    // Constructors

    /** default constructor */
    public RptParaDetKey() {
    }

    
    /** full constructor */
    public RptParaDetKey(Short rptId, Short condId) {
        this.rptId = rptId;
        this.condId = condId;
    }
    

   
    // Property accessors

    public Short getRptId() {
        return this.rptId;
    }
    
    public void setRptId(Short rptId) {
        this.rptId = rptId;
    }

    public Short getCondId() {
        return this.condId;
    }
    
    public void setCondId(Short condId) {
        this.condId = condId;
    }
   








}
