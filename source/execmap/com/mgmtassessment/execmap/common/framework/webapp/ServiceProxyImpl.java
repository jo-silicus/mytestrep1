/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : DasAshim
 * @date : Jul 24, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.common.framework.webapp;

import org.springframework.context.ApplicationContext;

import com.mgmtassessment.execmap.business.api.login.LoginManagerFacade;
import com.mgmtassessment.execmap.business.api.loginmanagement.LoginManagementFacade;
import com.mgmtassessment.execmap.business.api.mail.MailWriterFacade;
import com.mgmtassessment.execmap.business.api.assessment.AssessmentManagerFacade;
import com.mgmtassessment.execmap.business.api.company.CompanyManagerFacade;
import com.mgmtassessment.execmap.business.api.globalsettings.GlobalSettingManagerFacade;
import com.mgmtassessment.execmap.business.api.group.GroupManagerFacade;
import com.mgmtassessment.execmap.business.api.report.ReportManagerFacade;
import com.mgmtassessment.execmap.business.api.user.UserManagerFacade;
import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.business.AbstractFacade;

/**
 * TODO Write java docs comments for this type
 */

public class ServiceProxyImpl implements ServiceProxy {

    /** The Spring Application Context * */
    private ApplicationContext appContext;

    /**
     * This Method returns the CompanyManagerFacade
     * 
     * @return CompanyManagerFacade
     * @author :DasAshim
     */
    public CompanyManagerFacade getCompanyManager() {

        CompanyManagerFacade coManagerFacade = (CompanyManagerFacade) appContext
                .getBean(IConstants.COMPANY_MANAGER);
        coManagerFacade.setApplicationContext(getAppContext());
        return coManagerFacade;
    }

    /**
     * This Method returns the CompanyManagerFacade
     * 
     * @return CompanyManagerFacade
     * @author :DasAshim
     */
    public ReportManagerFacade getReportManager() {

        ReportManagerFacade reportManagerFacade = (ReportManagerFacade) appContext
                .getBean(IConstants.REPORT_MANAGER);
        reportManagerFacade.setApplicationContext(getAppContext());
        return reportManagerFacade;
    }

    /**
     * This Method returns the GlobalSettingManagerFacade
     * 
     * @return GlobalSettingManagerFacade
     * @author : DasAshim
     */

    public GlobalSettingManagerFacade getGlobalSettingManager() {

        GlobalSettingManagerFacade globalSettingManagerFacade = (GlobalSettingManagerFacade) appContext
                .getBean(IConstants.GLOBAL_SETTING_MANAGER);
        globalSettingManagerFacade.setApplicationContext(getAppContext());
        return globalSettingManagerFacade;

    }
    
    /**
     * This Method returns the LoginManagementFacade
     * 
     * @return LoginManagementFacade
     * @author : DasAshim
     */

    public LoginManagementFacade getLoginManagementFacade() {

        LoginManagementFacade loginManagementManagerFacade = (LoginManagementFacade) appContext
                .getBean(IConstants.LOGIN_MANAGEMENT_MANAGER);
        loginManagementManagerFacade.setApplicationContext(getAppContext());
        return loginManagementManagerFacade;

    }

    /**
     * Helper method to get the ApplocationContext
     * 
     * @return Returns the appContext.
     * @author DasAshim
     */
    public ApplicationContext getAppContext() {
        return appContext;
    }

    /**
     * Helper method to set the ApplicationContext
     * 
     * @param appContext
     *            The appContext to set.
     * @author DasAshim
     */
    public void setAppContext(ApplicationContext appCtxt) {
        // if (null == appCtxt )
        appContext = appCtxt;
    }

    /**
     * This method returns the interface of the GroupManagerFacade.
     *
     * @return GroupManagerFacade
     * @author sharmrahu
     */
    public GroupManagerFacade getGroupManager() {
        GroupManagerFacade groupManagerFacade = (GroupManagerFacade) appContext
                .getBean(IConstants.GROUP_MANAGER);
        groupManagerFacade.setApplicationContext(getAppContext());
        return groupManagerFacade;
    }

    /**
     * This method returns the interface of the UserManagerFacade.
     *
     * @return UserManagerFacade
     * @author sharmrahu
     */
    public UserManagerFacade getUserManager() {
        UserManagerFacade userManagerFacade = (UserManagerFacade) appContext
                .getBean(IConstants.USER_MANAGER);
        userManagerFacade.setApplicationContext(getAppContext());
        return userManagerFacade;
    }
    
    
    /**
	 * This method returns the interface of the AssessmentManagerFacade 
	 * @return AssessmentManagerFacade
	 * @author DasAshim
	 */
 
  public AssessmentManagerFacade getAssessmentManager(){
	  AbstractFacade abstractFacade=(AbstractFacade)appContext
		.getBean(IConstants.ASSESSMENT_MANAGER);
	  abstractFacade.setApplicationContext(appContext);
	   return (AssessmentManagerFacade)abstractFacade;
	   
  }
  
  /**
     * This method returns the interface of the LoginManagerFacade 
     * @return LoginManagerFacade
     * @author AhmedZia
     */

   public LoginManagerFacade getLoginManager() {
      AbstractFacade abstractFacade=(AbstractFacade)appContext
        .getBean(IConstants.LOGIN_MANAGER);
      abstractFacade.setApplicationContext(appContext);
       return (LoginManagerFacade)abstractFacade;
   }

    /**
     * This method returns the interface of the MailWriterFacade.
     * @return MailWriterFacade
     */
   public MailWriterFacade getMailWriterFacade() {
         AbstractFacade abstractFacade=(AbstractFacade)appContext
           .getBean(IConstants.MAILWRITER_MANAGER);
         abstractFacade.setApplicationContext(appContext);
          return (MailWriterFacade)abstractFacade;
   }
}