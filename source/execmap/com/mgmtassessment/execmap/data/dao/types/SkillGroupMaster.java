package com.mgmtassessment.execmap.data.dao.types;
// Generated Aug 3, 2006 6:56:57 PM by Hibernate Tools 3.1.0 beta3

import java.util.HashSet;
import java.util.Set;


/**
 * SkillGroupMaster generated by hbm2java
 */

public class SkillGroupMaster  implements java.io.Serializable {


    // Fields    

     private Short skillGrpId;
     private String skillGrpDesc;
     private Integer version;
     private Set skillGrpCondRels = new HashSet(0);
     private Set skillGrpSkillRels = new HashSet(0);


    // Constructors

    /** default constructor */
    public SkillGroupMaster() {
    }

	/** minimal constructor */
    public SkillGroupMaster(Short skillGrpId, String skillGrpDesc) {
        this.skillGrpId = skillGrpId;
        this.skillGrpDesc = skillGrpDesc;
    }
    
    /** full constructor */
    public SkillGroupMaster(Short skillGrpId, String skillGrpDesc, Integer version, Set skillGrpCondRels, Set skillGrpSkillRels) {
        this.skillGrpId = skillGrpId;
        this.skillGrpDesc = skillGrpDesc;
        this.version = version;
        this.skillGrpCondRels = skillGrpCondRels;
        this.skillGrpSkillRels = skillGrpSkillRels;
    }
    

   
    // Property accessors

    public Short getSkillGrpId() {
        return this.skillGrpId;
    }
    
    public void setSkillGrpId(Short skillGrpId) {
        this.skillGrpId = skillGrpId;
    }

    public String getSkillGrpDesc() {
        return this.skillGrpDesc;
    }
    
    public void setSkillGrpDesc(String skillGrpDesc) {
        this.skillGrpDesc = skillGrpDesc;
    }

    public Integer getVersion() {
        return this.version;
    }
    
    public void setVersion(Integer version) {
        this.version = version;
    }

    public Set getSkillGrpCondRels() {
        return this.skillGrpCondRels;
    }
    
    public void setSkillGrpCondRels(Set skillGrpCondRels) {
        this.skillGrpCondRels = skillGrpCondRels;
    }

    public Set getSkillGrpSkillRels() {
        return this.skillGrpSkillRels;
    }
    
    public void setSkillGrpSkillRels(Set skillGrpSkillRels) {
        this.skillGrpSkillRels = skillGrpSkillRels;
    }
   








}
