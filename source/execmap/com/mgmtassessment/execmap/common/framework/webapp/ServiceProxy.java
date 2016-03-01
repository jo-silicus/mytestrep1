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

/**
 * This Interface provides methods for accessing the business services in the
 * domain layer. This provides clean seperation between the presentaion layer
 * and domain service layer. The methods will be invoked by
 * 
 * @see ExecmapAction class. Note: This Interface is simple Interface.
 */

public interface ServiceProxy {

    /**
     * This method returns the interface of the CompanyManagerFacade
     *
     * @return CompanyManagerFacade
     * @author DasAshim
     */

    public CompanyManagerFacade getCompanyManager();

    /**
     * This method returns the interface of the GroupManagerFacade.
     *
     * @return GroupManagerFacade
     * @author sharmrahu
     */

    public GroupManagerFacade getGroupManager();

    /**
     * This method returns the interface of the UserManagerFacade.
     *
     * @return UserManagerFacade
     * @author sharmrahu
     */
    public UserManagerFacade getUserManager();

    /**
     * This method returns the interface of the GlobalSettingManagerFacade.
     * @return GlobalSettingManagerFacade
     */
    public GlobalSettingManagerFacade getGlobalSettingManager();

    /**
     * This method returns the interface of the ReportManagerFacade.
     * @return ReportManagerFacade
     */
    public ReportManagerFacade getReportManager();
    
    /**
     * This method returns the interface of the LoginManagementFacade.
     * @return LoginManagementFacade
     */
    public LoginManagementFacade getLoginManagementFacade();

    /**
     * This method sets the ApplicationContext. This method must be invoked
     * before any calls are made to get the Facade's from the Spring Container's
     * context. Failure to do so will result in Exception Condition as the
     * Facade's will not be able get references from the Spring Container.
     * 
     * @see <code> ExecMapAction class</code>. This method will be invoked
     *      from <code> ExecMapAction class</code> before any calls are made to
     *      access the domain facade's. Since all the Action's will extend
     *      <code> ExecMapAction 
     * </code> it is ensured that the this method is
     *      invoked first and then other calls are made.
     * @param ApplicationContext
     * @author DasAshim
     */
    public void setAppContext(ApplicationContext appCtxt);
    
    /**
	 * This method returns the interface of the AssessmentManagerFacade 
	 * @return AssessmentManagerFacade
	 * @author DasAshim
	 */
	
	public AssessmentManagerFacade getAssessmentManager();
    
    
    /**
     * This method returns the interface of the LoginManagerFacade 
     * @return LoginManagerFacade
     * @author AhmedZia
     */
    
    public LoginManagerFacade getLoginManager();
    /**
     * This method returns the interface of the MailWriterFacade 
     * @return MailWriterFacade
     */
    public MailWriterFacade getMailWriterFacade();

}
