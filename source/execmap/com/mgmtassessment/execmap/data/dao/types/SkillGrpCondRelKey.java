package com.mgmtassessment.execmap.data.dao.types;
// Generated Aug 3, 2006 6:56:57 PM by Hibernate Tools 3.1.0 beta3



/**
 * SkillGrpCondRelKey generated by hbm2java
 */

public class SkillGrpCondRelKey  implements java.io.Serializable {


    // Fields    

     private Short skillGrpId;
     private Short condId;
     private Short rptId;


    // Constructors

    /** default constructor */
    public SkillGrpCondRelKey() {
    }

    
    /** full constructor */
    public SkillGrpCondRelKey(Short skillGrpId, Short condId, Short rptId) {
        this.skillGrpId = skillGrpId;
        this.condId = condId;
        this.rptId = rptId;
    }
    

   
    // Property accessors

    public Short getSkillGrpId() {
        return this.skillGrpId;
    }
    
    public void setSkillGrpId(Short skillGrpId) {
        this.skillGrpId = skillGrpId;
    }

    public Short getCondId() {
        return this.condId;
    }
    
    public void setCondId(Short condId) {
        this.condId = condId;
    }

    public Short getRptId() {
        return this.rptId;
    }
    
    public void setRptId(Short rptId) {
        this.rptId = rptId;
    }
   








}
