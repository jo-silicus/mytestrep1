/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : DasAshim
 * @date : Aug 13, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.webapp.main.assessment.form;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.common.framework.webapp.ExecmapForm;
import com.mgmtassessment.execmap.business.model.ImageTextAssessmentModel;

/**
 * Form used for assessment activities which have a single answer.
 */

public class AssessmentForm extends ExecmapForm implements Serializable {

    /**
     * Stores the subheader for an assessment.
     */
    public String  subHeader         = null;

    /**
     * Stores the instruction for an assessment.
     */
    public List    instruction       = null;

    /**
     * store the questions for an assessment.
     */
    public List    textOrUrl         = null;

    /**
     * stores the answering instructions for a question.
     */
    public String  answerInstruction = null;

    /**
     * stores the page no.
     */

    public String  pageNo            = null;

    /**
     * stors the answer no for a question.
     */

    public String  answerNo          = null;

    /**
     * store the options to the questions for an assessment.
     */

    public List    questionOptions   = null;

    /**
     *  Stores the Timer value of the trigram.
     */
    public String  timer             = null;

    /**
     * Indicates the timer has started the values are 0 or 1.
     */
    public String  startCounting     = null;

    /**
     * Indicates if finish button was clicked.
     */
    public boolean nextFinish        = false;

    /**
     * timerSet checks if the timer was triggered during assessment if the
     * assessment could not be completed within the time as set in the timer for
     * a trigram the timer will trigger the timerSet to true otherwise will
     * remain false.
     */
    public boolean timerSet          = false;

    /**
     * Stores the total number of questions in a trigram.
     */
    public String  questionlistsize  = null;

    /**
     * Stores the list of page options for which the user can go back and
     * re-answer questions. This list is shown on the left side panel of the
     * assessment Page.
     */
    public List    navigationlist    = null;

    /**
     * This flag is checked in the jsp to determine if resume button needs to be
     * shown.
     */
    public boolean urlsetflag        = false;

    /**
     * Counts the number of times the next button is clicked: Used to store the
     * page number to which the page should go when the user clicks on the
     * resume button.
     */

    public String  nextcount         = null;

    /**
     * The Sub Test id of the Trigram Assessment.
     */
    public String  questionNo        = null;

    /**
     * flag used for displaying the buttons in jsp
     * for the DMS assessment activity.
     */

    public boolean dmsFlag           = false;

    /**
     * stores the base path of the images used in
     * the navigational part of the jsp.
     */

    public String  linkImageUrl      = null;

    /**
     * @return Returns the dmsFlag.
     */
    public boolean isDmsFlag() {
        return dmsFlag;
    }

    /**
     * @param dmsFlag The dmsFlag to set.
     */
    public void setDmsFlag(boolean dmsFlag) {
        this.dmsFlag = dmsFlag;
    }

    /**
     * @return Returns the navigationlist.
     */
    public List getNavigationlist() {
        return navigationlist;
    }

    /**
     * @param navigationlist The navigationlist to set.
     */
    public void setNavigationlist(List navigationlist) {
        this.navigationlist = navigationlist;
    }

    /**
     * @return Returns the nextFinish.
     */
    public boolean isNextFinish() {
        return nextFinish;
    }

    /**
     * @param nextFinish The nextFinish to set.
     */
    public void setNextFinish(boolean nextFinish) {
        this.nextFinish = nextFinish;
    }

    /**
     * @return Returns the timerSet.
     */
    public boolean isTimerSet() {
        return timerSet;
    }

    /**
     * @param timerSet The timerSet to set.
     */
    public void setTimerSet(boolean timerSet) {
        this.timerSet = timerSet;
    }

    /**
     * @return Returns the answerNo.
     */
    public String getAnswerNo() {
        return answerNo;
    }

    /**
     * @param answerNo The answerNo to set.
     */
    public void setAnswerNo(String answerNo) {
        this.answerNo = answerNo;
    }

    /**
     * @return Returns the answerInstruction.
     */
    public String getAnswerInstruction() {
        return answerInstruction;
    }

    /**
     * @param answerInstruction The answerInstruction to set.
     */
    public void setAnswerInstruction(String answerInstruction) {
        this.answerInstruction = answerInstruction;
    }

    /**
     * @return Returns the instruction.
     */
    public List getInstruction() {
        return instruction;
    }

    /**
     * @param instruction The instruction to set.
     */
    public void setInstruction(List instruction) {
        this.instruction = instruction;
    }

    /**
     * @return Returns the pageNo.
     */
    public String getPageNo() {
        return pageNo;
    }

    /**
     * @param pageNo The pageNo to set.
     */
    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * @return Returns the questionOptions.
     */
    public List getQuestionOptions() {
        return questionOptions;
    }

    /**
     * @param questionOptions The questionOptions to set.
     */
    public void setQuestionOptions(List questionOptions) {
        this.questionOptions = questionOptions;
    }

    /**
     * @return Returns the subHeader.
     */
    public String getSubHeader() {
        return subHeader;
    }

    /**
     * @param subHeader The subHeader to set.
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
     * @param textOrUrl The textOrUrl to set.
     */
    public void setTextOrUrl(List textOrUrl) {
        this.textOrUrl = textOrUrl;
    }

    /**
     * @param ActionMapping
     * @param HttpServletRequest
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {

        subHeader = null;
        instruction = null;
        textOrUrl = null;
        answerInstruction = null;
        pageNo = "0";
        questionOptions = null;
        answerNo = null;
        timer = null;
        startCounting = "0";
        questionlistsize = "0";
        nextcount = "0";
        questionNo = null;
        linkImageUrl = null;
        super.reset(mapping, request);
    }

    /**
     * This method populates the form from the model.
     * @param pageModel has the fields corresponding to an
     * assessment activity
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

    /**
     * @return Returns the timer.
     */
    public String getTimer() {
        return timer;
    }

    /**
     * @param timer The timer to set.
     */
    public void setTimer(String timer) {
        this.timer = timer;
    }

    /**
     * @return Returns the startCounting.
     */
    public String getStartCounting() {
        return startCounting;
    }

    /**
     * @param startCounting The startCounting to set.
     */
    public void setStartCounting(String startCounting) {
        this.startCounting = startCounting;
    }

    /**
     * @return Returns the questionlistsize.
     */
    public String getQuestionlistsize() {
        return questionlistsize;
    }

    /**
     * @param questionlistsize The questionlistsize to set.
     */
    public void setQuestionlistsize(String questionlistsize) {
        this.questionlistsize = questionlistsize;
    }

    /**
     * @return Returns the urlsetflag.
     */
    public Boolean getUrlsetflag() {
        return urlsetflag;
    }

    /**
     * @param urlsetflag The urlsetflag to set.
     */
    public void setUrlsetflag(Boolean urlsetflag) {
        this.urlsetflag = urlsetflag;
    }

    /**
     * @return Returns the nextcount.
     */
    public String getNextcount() {
        return nextcount;
    }

    /**
     * @param nextcount The nextcount to set.
     */
    public void setNextcount(String nextcount) {
        this.nextcount = nextcount;
    }

    /**
     * @param urlsetflag The urlsetflag to set.
     */
    public void setUrlsetflag(boolean urlsetflag) {
        this.urlsetflag = urlsetflag;
    }

    /**
     * @return Returns the questionNo.
     */
    public String getQuestionNo() {
        return questionNo;
    }

    /**
     * @param questionNo The questionNo to set.
     */
    public void setQuestionNo(String questionNo) {
        this.questionNo = questionNo;
    }

    /**
     * @return Returns the linkImageUrl.
     */
    public String getLinkImageUrl() {
        return linkImageUrl;
    }

    /**
     * @param linkImageUrl The linkImageUrl to set.
     */
    public void setLinkImageUrl(String linkImageUrl) {
        this.linkImageUrl = linkImageUrl;
    }

}
