/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : TODO
 * @date : Jul 21, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.business.model;

import java.util.Vector;
import java.io.Serializable;

import com.mgmtassessment.execmap.business.model.CareerInfo;
import com.mgmtassessment.execmap.business.model.TestInfo;
import com.mgmtassessment.execmap.business.model.FeedBackInfo;
import com.mgmtassessment.execmap.common.framework.business.AbstractModel;

/**
 * TODO Write java docs comments for this type
 */

public class UserInfo extends AbstractModel {

    /**
     * @return Returns the soundData.
     */
    public Character getSoundData() {
        return soundData;
    }

    /**
     * @param soundData The soundData to set.
     */
    public void setSoundData(Character soundData) {
        this.soundData = soundData;
    }

    public Vector getData() {
        return data;
    }

    public void setData(Vector data) {
        this.data = data;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public int getSessionID() {
        return sessionID;
    }

    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }

    public TestInfo getTestInfo() {
        return testInfo;
    }

    public void setTestInfo(TestInfo testInfo) {
        this.testInfo = testInfo;
    }

    public ReportInfo getReportInfo() {
        return reportInfo;
    }

    public void setReportInfo(ReportInfo reportInfo) {
        this.reportInfo = reportInfo;
    }

    public FeedBackInfo getFeedBackInfo() {
        return feedBackInfo;
    }

    public void setFeedBackInfo(FeedBackInfo feedBackInfo) {
        this.feedBackInfo = feedBackInfo;
    }

    public CareerInfo getCareerInfo() {
        return careerInfo;
    }

    public void setCareerInfo(CareerInfo careerInfo) {
        this.careerInfo = careerInfo;
    }

    public String getCobrandImage() {
        return cobrandImage;
    }

    public void setCobrandImage(String cobrandImage) {
        this.cobrandImage = cobrandImage;
    }

    public int getRollID() {
        return rollID;
    }

    public void setRollID(int rollID) {
        this.rollID = rollID;
    }

    public void setWelfareFlag(boolean welfareFlag) {
        this.welfareFlag = welfareFlag;
    }

    public boolean getWelfareFlag() {
        return welfareFlag;
    }

    public void setExecMapFlag(boolean execmapFlag) {
        this.execmapFlag = execmapFlag;
    }

    public boolean getExecMapFlag() {
        return execmapFlag;
    }

    public void setPaymentFlag(boolean paymentFlag) {
        this.paymentFlag = paymentFlag;
    }

    public boolean getPaymentFlag() {
        return paymentFlag;
    }

    // Intellicue_ver_1.5 Shailendra and Milan
    public void setLang(String strLanguage) {
        this.strLang = strLanguage;
    }

    public String getLang() {
        return strLang;
    }

    public void setPath(String sTempPath) {
        this.sFilePath = sTempPath;
    }

    public String getPath() {
        return sFilePath;
    }

    // End Shailendra and Milan

    // Intellicue_ver_1.5 Sunil
    // Method setCatId() and getCatId() added by Sunil for Intellicue_ver_1.5

    /**
     * Description - This method will set the Category Id
     * @param String catid - This will take the CategoryId of the user and set
     *        the same in the Info object.
     * @return - void
     * @since version 1.5
     */
    public void setCatId(String catid) {
        this.catid = catid;
    }

    /**
     * Description:This method will return the Category Id of the user.
     * @param-
     * @return String
     * @since version 1.5
     */
    public String getCatId() {
        return catid;
    }

    /*
     * End Intellicue_ver_1.5
     */

    private Vector       data         = null;

    private Character    soundData    = null;

    private String       accountID    = null;

    private String       userID       = null;

    private int          sessionID    = 0;

    private int          rollID       = 0;

    private String       groupID      = null;

    private String       cobrandImage = null;

    private TestInfo     testInfo     = new TestInfo();

    private FeedBackInfo feedBackInfo = new FeedBackInfo();

    private ReportInfo   reportInfo   = new ReportInfo();

    // private SkillInfo skillInfo;
    private CareerInfo   careerInfo   = new CareerInfo();

    private boolean      welfareFlag;

    private boolean      paymentFlag;

    private String       catid;                            

    private String       strLang      = null;

    private String       sFilePath    = null;

    private boolean      execmapFlag;

}
