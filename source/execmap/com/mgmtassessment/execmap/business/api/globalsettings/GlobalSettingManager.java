/**
 *  @Copyright Management Assessment Partners (MAP) AG 
 *  All Rights Reserved.
 *  
 *  @Author : kumarra
 *  @Date   : Jul 7, 2006
 *
 */
package com.mgmtassessment.execmap.business.api.globalsettings;

import org.springframework.context.ApplicationContext;

import com.mgmtassessment.execmap.common.framework.business.AbstractFacade;

import com.mgmtassessment.execmap.business.model.GlobalSettingsModel;
/**
 * TODO add description for this class
 *
 */
public interface GlobalSettingManager extends AbstractFacade{
	
	public abstract GlobalSettingsModel getGlobalSetting(ApplicationContext appContext);
	
	public abstract void saveGlobalSettings(GlobalSettingsModel globalSettingsModel ,ApplicationContext appContext);

}
