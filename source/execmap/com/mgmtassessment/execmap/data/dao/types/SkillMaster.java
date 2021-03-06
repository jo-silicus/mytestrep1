package com.mgmtassessment.execmap.data.dao.types;
// Generated Aug 3, 2006 6:56:56 PM by Hibernate Tools 3.1.0 beta3

import java.util.HashSet;
import java.util.Set;


/**
 * SkillMaster generated by hbm2java
 */

public class SkillMaster  implements java.io.Serializable {


    // Fields    

     private Short skillId;
     private Short parSkill;
     private String skillName;
     private String skillDesc;
     private Integer version;
     private Set abilSkillRels = new HashSet(0);
     private Set skillTriRels = new HashSet(0);
     private Set testSesSkillScrDets = new HashSet(0);
     private Set skillLvlTriRels = new HashSet(0);
     private Set skillGrpSkillRels = new HashSet(0);


    // Constructors

    /** default constructor */
    public SkillMaster() {
    }

	/** minimal constructor */
    public SkillMaster(Short skillId, String skillName) {
        this.skillId = skillId;
        this.skillName = skillName;
    }
    
    /** full constructor */
    public SkillMaster(Short skillId, Short parSkill, String skillName, String skillDesc, Integer version, Set abilSkillRels, Set skillTriRels, Set testSesSkillScrDets, Set skillLvlTriRels, Set skillGrpSkillRels) {
        this.skillId = skillId;
        this.parSkill = parSkill;
        this.skillName = skillName;
        this.skillDesc = skillDesc;
        this.version = version;
        this.abilSkillRels = abilSkillRels;
        this.skillTriRels = skillTriRels;
        this.testSesSkillScrDets = testSesSkillScrDets;
        this.skillLvlTriRels = skillLvlTriRels;
        this.skillGrpSkillRels = skillGrpSkillRels;
    }
    

   
    // Property accessors

    public Short getSkillId() {
        return this.skillId;
    }
    
    public void setSkillId(Short skillId) {
        this.skillId = skillId;
    }

    public Short getParSkill() {
        return this.parSkill;
    }
    
    public void setParSkill(Short parSkill) {
        this.parSkill = parSkill;
    }

    public String getSkillName() {
        return this.skillName;
    }
    
    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillDesc() {
        return this.skillDesc;
    }
    
    public void setSkillDesc(String skillDesc) {
        this.skillDesc = skillDesc;
    }

    public Integer getVersion() {
        return this.version;
    }
    
    public void setVersion(Integer version) {
        this.version = version;
    }

    public Set getAbilSkillRels() {
        return this.abilSkillRels;
    }
    
    public void setAbilSkillRels(Set abilSkillRels) {
        this.abilSkillRels = abilSkillRels;
    }

    public Set getSkillTriRels() {
        return this.skillTriRels;
    }
    
    public void setSkillTriRels(Set skillTriRels) {
        this.skillTriRels = skillTriRels;
    }

    public Set getTestSesSkillScrDets() {
        return this.testSesSkillScrDets;
    }
    
    public void setTestSesSkillScrDets(Set testSesSkillScrDets) {
        this.testSesSkillScrDets = testSesSkillScrDets;
    }

    public Set getSkillLvlTriRels() {
        return this.skillLvlTriRels;
    }
    
    public void setSkillLvlTriRels(Set skillLvlTriRels) {
        this.skillLvlTriRels = skillLvlTriRels;
    }

    public Set getSkillGrpSkillRels() {
        return this.skillGrpSkillRels;
    }
    
    public void setSkillGrpSkillRels(Set skillGrpSkillRels) {
        this.skillGrpSkillRels = skillGrpSkillRels;
    }
   








}
