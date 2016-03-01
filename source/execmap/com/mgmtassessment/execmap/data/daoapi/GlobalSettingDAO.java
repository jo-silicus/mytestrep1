/**
 *  @Copyright Management Assessment Partners (MAP) AG
 *  All Rights Reserved.
 *
 *  @Author : Kumarra
 *  @Date   : Jul 7, 2006
 *
 */
package com.mgmtassessment.execmap.data.daoapi;

/**
 * TODO add description for this class
 * 
 */
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DataRetrievalFailureException;

import com.mgmtassessment.execmap.business.model.GlobalSettingsModel;
import com.mgmtassessment.execmap.data.dao.types.ExecmapSysMaster;

public interface GlobalSettingDAO {

    /**
     * retrieve the data global settings data from the ExecmapSysMaster class
     * the data returned is a single row in database
     * 
     * @return ExecmapSysMaster returns the ExecmapSysMaster object having all
     *         the data from the database *
     * @throws DataRetrievalFailureException
     */
    ExecmapSysMaster getGlobalSetting() throws DataRetrievalFailureException;

    /**
     * this method saves the changes made for the global manager in the
     * ExecmapSysMaster
     * 
     * @param execmapSysMasterObject
     *            it is the ExecmapSysMaster object having all the changes done
     * by the user @ throws DataIntegrityViolationException exception thrown if
     *            data couldn't be saved
     */
    void saveGlobalSettings(ExecmapSysMaster execmapSysMasterObject)
            throws DataIntegrityViolationException;

}
