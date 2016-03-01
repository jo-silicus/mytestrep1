/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : DasAshim
 * @date : Aug 11, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.business.model;

import java.util.List;

import com.mgmtassessment.execmap.common.framework.business.AbstractModel;

/**
 * This model represents the image and text options assessment types. TODO Write
 * java docs comments for this type
 */

public class ImageTextAssessmentModel extends AbstractModel {

    /**
     * the subheader for the assessment jsp.
     */
    String  subHeader         = null;

    /**
     * the instruction for the assessment.
     */

    List    instruction       = null;

    /**
     * the field store the question
     * for each assessment activity.
     */

    List    textOrUrl         = null;

    /**
     * gives the answering instruction
     * for the assessment activity.
     */

    String  answerInstruction = null;

    /**
     * the page no it is 0 for the
     * instructions page 1 for the first question
     * and so on.
     */

    String  pageNo            = null;

    /**
     * gives the options to each question
     */

    List    questionOptions   = null;

    /**
     * gives the time for each activity.
     */

    String  time              = null;

    /**
     * gives the total no of questions
     * in each activity.
     */

    String  questionlistsize  = null;

    /**
     * gives the question no.
     */

    Integer questionNo        = null;

    /**
     * gives the base path for the navigational
     * images.
     */

    String  linkImageUrl      = null;

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
     * @return Returns the time.
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time The time to set.
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return Returns the questionNo.
     */
    public Integer getQuestionNo() {
        return questionNo;
    }

    /**
     * @param questionNo The questionNo to set.
     */
    public void setQuestionNo(Integer questionNo) {
        this.questionNo = questionNo;
    }

}
