package com.mgmtassessment.execmap.business.model;

import java.util.Date;

/**
 * this is the summary model for the assessment activity.
 * @author singhrau
 */

public class AssessmentSummaryModel {
    /**
     * the user name.
     */
    String usrName         = null;

    /**
     * the user email.
     */

    String usrEmail        = null;

    /**
     * the session id.
     */

    String sesId           = null;

    /**
     * the date on which the user starts the test.
     */

    Date   startDate       = null;

    /**
     * the flag to denote wheteher the user
     * has completed all the tests.
     */

    String compFlg         = null;

    /**
     * the testid for the completed tests.
     */

    String testIdCompleted = null;

    /**
     * @return Returns the compFlg.
     */
    public String getCompFlg() {
        return compFlg;
    }

    /**
     * @param compFlg The compFlg to set.
     */
    public void setCompFlg(String compFlg) {
        this.compFlg = compFlg;
    }

    /**
     * @return Returns the sesId.
     */
    public String getSesId() {
        return sesId;
    }

    /**
     * @param sesId The sesId to set.
     */
    public void setSesId(String sesId) {
        this.sesId = sesId;
    }

    /**
     * @return Returns the startDate.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate The startDate to set.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return Returns the usrEmail.
     */
    public String getUsrEmail() {
        return usrEmail;
    }

    /**
     * @param usrEmail The usrEmail to set.
     */
    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    /**
     * @return Returns the usrName.
     */
    public String getUsrName() {
        return usrName;
    }

    /**
     * @param usrName The usrName to set.
     */
    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    /**
     * @return Returns the testIdCompleted.
     */
    public String getTestIdCompleted() {
        return testIdCompleted;
    }

    /**
     * @param testIdCompleted The testIdCompleted to set.
     */
    public void setTestIdCompleted(String testIdCompleted) {
        this.testIdCompleted = testIdCompleted;
    }
}
