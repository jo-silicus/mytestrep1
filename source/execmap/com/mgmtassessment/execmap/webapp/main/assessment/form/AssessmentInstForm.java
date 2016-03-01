/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : KapilPra
 * @date : Aug 16, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.webapp.main.assessment.form;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.common.framework.webapp.ExecmapForm;

/**
 * this is the form used by the preAssessmentAction
 *  and the UserEligibilityAction class.
 */

public class AssessmentInstForm extends ExecmapForm implements Serializable {

    /**
     * gives the welcome message.
     */

    public String  welcomeText;

    /**
     * the flag is set to true
     * if the user has sound card.
     * @author singhrau
     */
    public boolean soundCheck        = false;

    /**
     * this value is set to false if the user
     * has the checkbox on the sound card statement
     * checked.
     */
    public boolean checkboxValue     = true;

    /**
     * this flag is set to true when the
     * sound data has been set in the
     * usercontext.
     */

    public boolean checkFlagsoundset = false;

    /**
     * this flag is set to true if the user is not
     * eligible to appear in the assessment.
     */

    public String  failFlag;

    /**
     * @return Returns the failFlag.
     */
    public String getFailFlag() {
        return failFlag;
    }

    /**
     * @param failFlag The failFlag to set.
     */
    public void setFailFlag(String failFlag) {
        this.failFlag = failFlag;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {

    }

    /**
     * @return Returns the checkFlagsoundset.
     */
    public boolean isCheckFlagsoundset() {
        return checkFlagsoundset;
    }

    /**
     * @param checkFlagsoundset The checkFlagsoundset to set.
     */
    public void setCheckFlagsoundset(boolean checkFlagsoundset) {
        this.checkFlagsoundset = checkFlagsoundset;
    }

    /**
     * @return Returns the checkboxValue.
     */
    public boolean isCheckboxValue() {
        return checkboxValue;
    }

    /**
     * @param checkboxValue The checkboxValue to set.
     */
    public void setCheckboxValue(boolean checkboxValue) {
        this.checkboxValue = checkboxValue;
    }

    /**
     * @return Returns the welcomeText.
     */
    public String getWelcomeText() {
        return welcomeText;
    }

    /**
     * @param welcomeText The welcomeText to set.
     */
    public void setWelcomeText(String welcomeText) {
        this.welcomeText = welcomeText;
    }

    /**
     * @return Returns the soundCheck.
     */
    public boolean isSoundCheck() {
        return soundCheck;
    }

    /**
     * @param soundCheck The soundCheck to set.
     */
    public void setSoundCheck(boolean soundCheck) {
        this.soundCheck = soundCheck;
    }

}
