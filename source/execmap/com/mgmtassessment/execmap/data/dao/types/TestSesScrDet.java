package com.mgmtassessment.execmap.data.dao.types;
// Generated Aug 3, 2006 6:56:56 PM by Hibernate Tools 3.1.0 beta3

import java.math.BigDecimal;


/**
 * TestSesScrDet generated by hbm2java
 */

public class TestSesScrDet  implements java.io.Serializable {


    // Fields    

     private TestSesScrDetKey comp_id;
     private BigDecimal rawScr;
     private BigDecimal stanScore;
     private String exclFlg;
     private String audioFlg;
     private Integer version;
     private TestSessionMaster testSesMa;
     private SubTestMaster subTestMa;
     private Integer deviation;

    // Constructors

    /** default constructor */
    public TestSesScrDet() {
    }

	/** minimal constructor */
    public TestSesScrDet(TestSesScrDetKey comp_id, BigDecimal rawScr, BigDecimal stanScore) {
        this.comp_id = comp_id;
        this.rawScr = rawScr;
        this.stanScore = stanScore;
    }
    
    /** full constructor */
    public TestSesScrDet(TestSesScrDetKey comp_id, BigDecimal rawScr, BigDecimal stanScore,Integer deviation, String exclFlg, String audioFlg, Integer version, TestSessionMaster testSesMa, SubTestMaster subTestMa) {
        this.comp_id = comp_id;
        this.rawScr = rawScr;
        this.stanScore = stanScore;
        this.exclFlg = exclFlg;
        this.audioFlg = audioFlg;
        this.version = version;
        this.testSesMa = testSesMa;
        this.subTestMa = subTestMa;
        this.deviation = deviation;
    }
    

   
    // Property accessors

    public TestSesScrDetKey getComp_id() {
        return this.comp_id;
    }
    
    public void setComp_id(TestSesScrDetKey comp_id) {
        this.comp_id = comp_id;
    }

    public BigDecimal getRawScr() {
        return this.rawScr;
    }
    
    public void setRawScr(BigDecimal rawScr) {
        this.rawScr = rawScr;
    }

    public BigDecimal getStanScore() {
        return this.stanScore;
    }
    
    public void setStanScore(BigDecimal stanScore) {
        this.stanScore = stanScore;
    }

    public String getExclFlg() {
        return this.exclFlg;
    }
    
    public void setExclFlg(String exclFlg) {
        this.exclFlg = exclFlg;
    }

    public String getAudioFlg() {
        return this.audioFlg;
    }
    
    public void setAudioFlg(String audioFlg) {
        this.audioFlg = audioFlg;
    }

    public Integer getVersion() {
        return this.version;
    }
    
    public void setVersion(Integer version) {
        this.version = version;
    }

    public TestSessionMaster getTestSesMa() {
        return this.testSesMa;
    }
    
    public void setTestSesMa(TestSessionMaster testSesMa) {
        this.testSesMa = testSesMa;
    }

    public SubTestMaster getSubTestMa() {
        return this.subTestMa;
    }
    
    public void setSubTestMa(SubTestMaster subTestMa) {
        this.subTestMa = subTestMa;
    }

    public Integer getDeviation() {
        return deviation;
    }

    public void setDeviation(Integer deviation) {
        this.deviation = deviation;
    }
   








}
