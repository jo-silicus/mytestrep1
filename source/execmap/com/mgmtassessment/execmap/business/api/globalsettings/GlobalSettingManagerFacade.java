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

import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;
import com.mgmtassessment.execmap.common.exceptions.DataSaveException;
import com.mgmtassessment.execmap.common.framework.business.AbstractFacade;
import com.mgmtassessment.execmap.business.model.GlobalSettingsModel;

/**
 * TODO add description for this class
 * 
 */
public interface GlobalSettingManagerFacade extends AbstractFacade {
    /**
     * this method returns the global manager data from the intellicue_sys_mas
     * table and returns the globalsettingsmodel object containing the data
     * @return GlobalSettingsModel
     *          the model object that contains all the data from the table for global manager
     * @throws DataNotFoundException
     *         exception thrown if data for the global manager can't be retrieved
     */

    public abstract GlobalSettingsModel getGlobalSetting()
            throws DataNotFoundException;

    /**
     * this method updates the global manager data retrieved from the
     * globalSettingsModel
     * 
     * @param globalSettingsModel
     *        model object that contains all the changes to be saved for global manager
     * @return void
     * @throws DataSaveException
     *         exception thrown if data couldn't be saved
     */
    public abstract void saveGlobalSettings(
            GlobalSettingsModel globalSettingsModel) throws DataSaveException;

}
