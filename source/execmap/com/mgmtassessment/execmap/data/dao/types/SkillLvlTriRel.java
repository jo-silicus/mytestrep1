package com.mgmtassessment.execmap.data.dao.types;
// Generated Aug 3, 2006 6:56:56 PM by Hibernate Tools 3.1.0 beta3



/**
 * SkillLvlTriRel generated by hbm2java
 */

public class SkillLvlTriRel  implements java.io.Serializable {


    // Fields    

     private SkillLvlTriRelKey comp_id;
     private short stanScr;
     private Integer version;
     private SkillMaster skillMa;
     private TrigramMaster triMa;


    // Constructors

    /** default constructor */
    public SkillLvlTriRel() {
    }

	/** minimal constructor */
    public SkillLvlTriRel(SkillLvlTriRelKey comp_id, short stanScr) {
        this.comp_id = comp_id;
        this.stanScr = stanScr;
    }
    
    /** full constructor */
    public SkillLvlTriRel(SkillLvlTriRelKey comp_id, short stanScr, Integer version, SkillMaster skillMa, TrigramMaster triMa) {
        this.comp_id = comp_id;
        this.stanScr = stanScr;
        this.version = version;
        this.skillMa = skillMa;
        this.triMa = triMa;
    }
    

   
    // Property accessors

    public SkillLvlTriRelKey getComp_id() {
        return this.comp_id;
    }
    
    public void setComp_id(SkillLvlTriRelKey comp_id) {
        this.comp_id = comp_id;
    }

    public short getStanScr() {
        return this.stanScr;
    }
    
    public void setStanScr(short stanScr) {
        this.stanScr = stanScr;
    }

    public Integer getVersion() {
        return this.version;
    }
    
    public void setVersion(Integer version) {
        this.version = version;
    }

    public SkillMaster getSkillMa() {
        return this.skillMa;
    }
    
    public void setSkillMa(SkillMaster skillMa) {
        this.skillMa = skillMa;
    }

    public TrigramMaster getTriMa() {
        return this.triMa;
    }
    
    public void setTriMa(TrigramMaster triMa) {
        this.triMa = triMa;
    }
   








}
