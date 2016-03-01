/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @author : sharmrahu 
 *  @date   : Jul 21, 2006
 *  @version: 
 * 
 *  @history
 *  Description         Reference       Name        Date
 *               
 */

package com.mgmtassessment.execmap.data.daoimpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mgmtassessment.execmap.data.daoapi.AdminReportDAO;

//import intellicue.report.manager.impl.ReportManager;
import com.mgmtassessment.execmap.data.dao.types.CompanyAcctMaster;
import com.mgmtassessment.execmap.data.dao.types.CompanyGroupMaster;
import com.mgmtassessment.execmap.data.dao.types.CompanyUserMaster;
import com.mgmtassessment.execmap.webapp.main.login.action.LanguageAction;

import java.util.Collection;
import java.util.Iterator;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/**
 * TODO Write java docs comments for this type
 * TODO Remove the log statements from while loop
 */

public class AdminReportDAOImpl extends HibernateDaoSupport 
                                implements AdminReportDAO {
	
	/** logger for this class. */
    private static Log log = LogFactory.getLog(AdminReportDAOImpl.class);
	
    public CompanyAcctMaster getCompanyDetails(String id) {
    	CompanyAcctMaster user = (CompanyAcctMaster) getHibernateTemplate().get(CompanyAcctMaster.class,
                id);
    log.info("in initailizeObject");
    if (user != null) {
       log.info("in if of initailizeObject new :"+user.getAcctId());
    try 
       {
       log.info("if initialized  : "+ Hibernate.isInitialized(user.getCoGrpMas()));
               
       Hibernate.initialize(user.getCoGrpMas());
       Collection companyGroups=user.getCoGrpMas();
       Iterator iterCompanyGroups=companyGroups.iterator();
       while(iterCompanyGroups.hasNext())
          {
           CompanyGroupMaster newCompanyGroup=(CompanyGroupMaster)iterCompanyGroups.next();
           log.info("new Group : "+newCompanyGroup.getGrpInfo());
           Hibernate.initialize(newCompanyGroup.getCoUsrMas());
           Collection companyusers=newCompanyGroup.getCoUsrMas();
           Iterator iterCompanyusers=companyusers.iterator();
           while(iterCompanyusers.hasNext())
            {
              CompanyUserMaster newCompanyuser=(CompanyUserMaster)iterCompanyusers.next();
              log.info("new user : "+newCompanyuser.getFirstName()+" actv id:"+newCompanyuser.getActvRolMa().getActvRolId());
            }
       }
                
               
       } catch (HibernateException e) {
                e.printStackTrace();
       } finally {
                //session.close();
     }
    }
     return user;
    }
}