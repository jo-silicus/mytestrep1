/**
 *  @Copyright Management Assessment Partners (MAP) AG
 *  All Rights Reserved.
 *
 *  @author : goenkani
 *  @date   : Jul 11, 2006
 *  @version:
 *  @history
 *  This class is used to populate the jsp with scores in
 *  all tests attended by a user.
 */
package com.mgmtassessment.execmap.webapp.main.report.form;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMapping;
import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapForm;


/**
 * Action Form for Individual User Score details.
 *
 */
public class IndividualSummaryReportForm extends ExecmapForm {

    /**
     * account id of user.
     */
    private String acctid = null;
    /**
     * user id of user.
     */
    private String userid = null;
    /**
     * session id of user.
     */
    private String sessId = null;
    /**
     * Completion flag of user.
     */
    private String compFlag = null;
    /**
     * Contains score of all tests of a user.
     */
    private List userScoreDetails = null;
    /**
     * check whether user has given any one test or not.
     */
    private String check = null;
    /**
     * @return Returns the compFlag.
     */
    public String getCompFlag() {
        return compFlag;
    }
    /**
     * @param compFlag The compFlag to set.
     */
    public void setCompFlag(String compFlag) {
        this.compFlag = compFlag;
    }
    /**
     * @return Returns the sessId.
     */
    public String getSessId() {
        return sessId;
    }
    /**
     * @param sessId The sessId to set.
     */
    public void setSessId(String sessId) {
        this.sessId = sessId;
    }
   /**
    * @return Returns the acctid.
    */
    public String getAcctid() {
        return acctid;
    }
   /**
    * @param acctid The acctid to set.
    */
    public void setAcctid(String acctid) {
        this.acctid = acctid;
    }
   /**
    * @return Returns the userid.
    */
    public String getUserid() {
        return userid;
    }
    /**
     * @param userid The userid to set.
     */
     public void setUserid(String userid) {
        this.userid = userid;
     }
    /**
     * Reset the attributes for this form.
     *
     */
     public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.acctid = IConstants.BLANK;
        this.userid = IConstants.BLANK;
        this.sessId = IConstants.BLANK;
        this.compFlag = IConstants.BLANK;
    }
    /**
     * @return Returns the userScoreDetails.
     */
    public List getUserScoreDetails() {
        return userScoreDetails;
    }
    /**
     * @param userScoreDetails The userScoreDetails to set.
     */
    public void setUserScoreDetails(List userScoreDetails) {
       this.userScoreDetails = userScoreDetails;
    }
    /**
     * @return Returns the check.
     */
    public String getCheck() {
       return check;
    }
    /**
     * @param check The check to set.
     */
    public void setCheck(String check) {
       this.check = check;
    }
}