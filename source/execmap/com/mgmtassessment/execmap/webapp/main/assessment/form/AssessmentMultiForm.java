/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * 
 * @author : AhmedZia
 * @date : Aug 29, 2006
 * @version:
 * 
 * @history Description Reference Name Date
 * 
 */

package com.mgmtassessment.execmap.webapp.main.assessment.form;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.business.model.ImageTextAssessmentModel;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapForm;

/**
 * TODO Write java docs comments for this type
 * 
 */

public class AssessmentMultiForm extends ExecmapForm implements Serializable {

    public String   subHeader          = null;

    public List     instruction        = null;

    public List     textOrUrl          = null;

    public String   answerInstruction  = null;

    public String   pageNo             = null;

    public String   answerNo           = null;

    // public String instResumePgno = null ;
    public List     questionOptions    = null;

    public String   timer              = null;

    public String   startCounting      = null;

    /** nextFinish 'true' if the finish button was clicked * */
    public boolean  nextFinish         = false;

    /** timerSet checks if the timer was triggered during assessment * */
    public boolean  timerSet           = false;

    public String   questionlistsize   = null;

    public List     navigationlist     = null;

    // public String greatestpageno ="0";
    public boolean  urlsetflag         = false;

    public String   nextcount          = null;

    public String[] selectedCheckboxes = null;

    /** The Sub Test id of the Trigram Assessment * */
    public String   questionNo         = null;

    public boolean  dmsFlag            = false;

    public String   dmsStartPosition;

    public String   dmsEndPosition;

    /*
     * The textboxes store the answer in case of MEM Assessment.
     */
    public String   textbox0;

    public String   textbox1;

    public String   textbox2;

    public String   textbox3;

    public String   textbox4;

    public String   sliderpos;
    
    public String linkImageUrl;

    /*
     * This corresponds to the timer for the individual pages in case of MEM
     * Assessment
     */
    public String   memtimer           = null;

    /**
     * @return Returns the questionNo.
     */
    public String getQuestionNo() {
        return questionNo;
    }

    /**
     * @param questionNo
     *            The questionNo to set.
     */
    public void setQuestionNo(String questionNo) {
        this.questionNo = questionNo;
    }

    /**
     * @return Returns the selectedCheckboxes.
     */
    public String[] getSelectedCheckboxes() {
        return selectedCheckboxes;
    }

    /**
     * @param selectedCheckboxes
     *            The selectedCheckboxes to set.
     */
    public void setSelectedCheckboxes(String[] selectedCheckboxes) {
        this.selectedCheckboxes = selectedCheckboxes;
    }

    /**
     * @return Returns the answerInstruction.
     */
    public String getAnswerInstruction() {
        return answerInstruction;
    }

    /**
     * @param answerInstruction
     *            The answerInstruction to set.
     */
    public void setAnswerInstruction(String answerInstruction) {
        this.answerInstruction = answerInstruction;
    }

    /**
     * @return Returns the answerNo.
     */
    public String getAnswerNo() {
        return answerNo;
    }

    /**
     * @param answerNo
     *            The answerNo to set.
     */
    public void setAnswerNo(String answerNo) {
        this.answerNo = answerNo;
    }

    /**
     * @return Returns the instruction.
     */
    public List getInstruction() {
        return instruction;
    }

    /**
     * @param instruction
     *            The instruction to set.
     */
    public void setInstruction(List instruction) {
        this.instruction = instruction;
    }

    /**
     * @return Returns the navigationlist.
     */
    public List getNavigationlist() {
        return navigationlist;
    }

    /**
     * @param navigationlist
     *            The navigationlist to set.
     */
    public void setNavigationlist(List navigationlist) {
        this.navigationlist = navigationlist;
    }

    /**
     * @return Returns the nextcount.
     */
    public String getNextcount() {
        return nextcount;
    }

    /**
     * @param nextcount
     *            The nextcount to set.
     */
    public void setNextcount(String nextcount) {
        this.nextcount = nextcount;
    }

    /**
     * @return Returns the nextFinish.
     */
    public boolean isNextFinish() {
        return nextFinish;
    }

    /**
     * @param nextFinish
     *            The nextFinish to set.
     */
    public void setNextFinish(boolean nextFinish) {
        this.nextFinish = nextFinish;
    }

    /**
     * @return Returns the pageNo.
     */
    public String getPageNo() {
        return pageNo;
    }

    /**
     * @param pageNo
     *            The pageNo to set.
     */
    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * @return Returns the questionlistsize.
     */
    public String getQuestionlistsize() {
        return questionlistsize;
    }

    /**
     * @param questionlistsize
     *            The questionlistsize to set.
     */
    public void setQuestionlistsize(String questionlistsize) {
        this.questionlistsize = questionlistsize;
    }

    /**
     * @return Returns the questionOptions.
     */
    public List getQuestionOptions() {
        return questionOptions;
    }

    /**
     * @param questionOptions
     *            The questionOptions to set.
     */
    public void setQuestionOptions(List questionOptions) {
        this.questionOptions = questionOptions;
    }

    /**
     * @return Returns the startCounting.
     */
    public String getStartCounting() {
        return startCounting;
    }

    /**
     * @param startCounting
     *            The startCounting to set.
     */
    public void setStartCounting(String startCounting) {
        this.startCounting = startCounting;
    }

    /**
     * @return Returns the subHeader.
     */
    public String getSubHeader() {
        return subHeader;
    }

    /**
     * @param subHeader
     *            The subHeader to set.
     */
    public void setSubHeader(String subHeader) {
        this.subHeader = subHeader;
    }

    /**
     * @return Returns the textOrUrl.
     */
    public List getTextOrUrl() {
        return textOrUrl;
    }

    /**
     * @param textOrUrl
     *            The textOrUrl to set.
     */
    public void setTextOrUrl(List textOrUrl) {
        this.textOrUrl = textOrUrl;
    }

    /**
     * @return Returns the timer.
     */
    public String getTimer() {
        return timer;
    }

    /**
     * @param timer
     *            The timer to set.
     */
    public void setTimer(String timer) {
        this.timer = timer;
    }

    /**
     * @return Returns the timerSet.
     */
    public boolean isTimerSet() {
        return timerSet;
    }

    /**
     * @param timerSet
     *            The timerSet to set.
     */
    public void setTimerSet(boolean timerSet) {
        this.timerSet = timerSet;
    }

    /**
     * @return Returns the urlsetflag.
     */
    public boolean isUrlsetflag() {
        return urlsetflag;
    }

    /**
     * @param urlsetflag
     *            The urlsetflag to set.
     */
    public void setUrlsetflag(boolean urlsetflag) {
        this.urlsetflag = urlsetflag;
    }

    /**
     * @return Returns the textbox0.
     */
    public String getTextbox0() {
        return textbox0;
    }

    /**
     * @param textbox0
     *            The textbox0 to set.
     */
    public void setTextbox0(String textbox0) {
        this.textbox0 = textbox0;
    }

    /**
     * @return Returns the textbox1.
     */
    public String getTextbox1() {
        return textbox1;
    }

    /**
     * @param textbox1
     *            The textbox1 to set.
     */
    public void setTextbox1(String textbox1) {
        this.textbox1 = textbox1;
    }

    /**
     * @return Returns the textbox2.
     */
    public String getTextbox2() {
        return textbox2;
    }

    /**
     * @param textbox2
     *            The textbox2 to set.
     */
    public void setTextbox2(String textbox2) {
        this.textbox2 = textbox2;
    }

    /**
     * @return Returns the textbox3.
     */
    public String getTextbox3() {
        return textbox3;
    }

    /**
     * @param textbox3
     *            The textbox3 to set.
     */
    public void setTextbox3(String textbox3) {
        this.textbox3 = textbox3;
    }

    /**
     * @return Returns the memtimer.
     */
    public String getMemtimer() {
        return memtimer;
    }

    /**
     * @param memtimer
     *            The memtimer to set.
     */
    public void setMemtimer(String memtimer) {
        this.memtimer = memtimer;
    }

    /**
     * @return Returns the dmsFlag.
     */
    public boolean isDmsFlag() {
        return dmsFlag;
    }

    /**
     * @param dmsFlag
     *            The dmsFlag to set.
     */
    public void setDmsFlag(boolean dmsFlag) {
        this.dmsFlag = dmsFlag;
    }

    /**
     * @return Returns the dmsEndPosition.
     */
    public String getDmsEndPosition() {
        return dmsEndPosition;
    }

    /**
     * @param dmsEndPosition
     *            The dmsEndPosition to set.
     */
    public void setDmsEndPosition(String dmsEndPosition) {
        this.dmsEndPosition = dmsEndPosition;
    }

    /**
     * @return Returns the dmsStartPosition.
     */
    public String getDmsStartPosition() {
        return dmsStartPosition;
    }

    /**
     * @param dmsStartPosition
     *            The dmsStartPosition to set.
     */
    public void setDmsStartPosition(String dmsStartPosition) {
        this.dmsStartPosition = dmsStartPosition;
    }

    /**
     * @return Returns the textbox4.
     */
    public String getTextbox4() {
        return textbox4;
    }

    /**
     * @param textbox4
     *            The textbox4 to set.
     */
    public void setTextbox4(String textbox4) {
        this.textbox4 = textbox4;
    }

    public String getSliderpos() {
        return sliderpos;
    }

    public void setSliderpos(String sliderpos) {
        this.sliderpos = sliderpos;
    }

    /**
     * This method resets the form values
     * 
     * @param ActionMapping
     * @param HttpServletRequest
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {

        subHeader = null;
        instruction = null;
        textOrUrl = null;
        answerInstruction = null;
        pageNo = "0";
        // instResumePgno = "0";
        questionOptions = null;
        answerNo = null;
        timer = null;
        startCounting = "0";
        questionlistsize = "0";
        // greatestpageno ="0";
        nextcount = "0";
        selectedCheckboxes = null;
        questionNo = null;
        memtimer = null;
        dmsStartPosition = null;
        dmsEndPosition = null;
        sliderpos =null;
        linkImageUrl = null;
        super.reset(mapping, request);
    }

    /**
     * This method populates the form from the model.
     * 
     * @param pageModel
     */

    public void populateForm(ImageTextAssessmentModel pageModel) {

        subHeader = pageModel.getSubHeader();
        instruction = pageModel.getInstruction();
        textOrUrl = pageModel.getTextOrUrl();
        answerInstruction = pageModel.getAnswerInstruction();
        pageNo = pageModel.getPageNo();
        questionOptions = pageModel.getQuestionOptions();
        timer = pageModel.getTime();
        questionlistsize = pageModel.getQuestionlistsize();
        questionNo = pageModel.getQuestionNo().toString();
        linkImageUrl = pageModel.getLinkImageUrl();

    }

    public String getLinkImageUrl() {
        return linkImageUrl;
    }

    public void setLinkImageUrl(String linkImageUrl) {
        this.linkImageUrl = linkImageUrl;
    }

}
