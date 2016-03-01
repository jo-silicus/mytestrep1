/**
 * 
 */
package com.mgmtassessment.execmap.business.impl.globalsettings;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DataRetrievalFailureException;
import com.mgmtassessment.execmap.business.api.globalsettings.GlobalSettingManagerFacade;
import com.mgmtassessment.execmap.business.model.GlobalSettingsModel;
import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;
import com.mgmtassessment.execmap.common.exceptions.DataSaveException;
import com.mgmtassessment.execmap.common.framework.business.AbstractFacadeImpl;
import com.mgmtassessment.execmap.common.util.search.HQLSearch;
import com.mgmtassessment.execmap.data.dao.types.ExecmapSysMaster;
import com.mgmtassessment.execmap.data.daoapi.GlobalSettingDAO;

/**
 * @author kumarra
 * 
 */
public class GlobalSettingManagerFacadeImpl extends AbstractFacadeImpl
        implements GlobalSettingManagerFacade {

    private GlobalSettingDAO globalSettingDAO = null;

    /**
     * Initialize the hqlsearch object in order to initialize the hqlsearch
     * bean.
     */
    HQLSearch hqlsearch;
    
    List query = new ArrayList();

    /**
     * this method returns the global manager data from the intellicue_sys_mas
     * table and returns the globalsettingsmodel object containing the data
     * @return GlobalSettingsModel
     *          the model object that contains all the data from the table for global manager
     * @throws DataNotFoundException
     *         exception thrown if data for the global manager can't be retrieved
     */
    public GlobalSettingsModel getGlobalSetting() throws DataNotFoundException {
        GlobalSettingsModel globalSettingsModel = null;
        HQLSearch hqlsearch = (HQLSearch) appCtxt.getBean("hqlSearch");
        try {
            query = hqlsearch.search("GlobalSettingDetailKey");
        } catch (DataRetrievalFailureException ex) {
            throw new DataNotFoundException(
                    "error.global.manager", ex);
        } catch (Exception ex) {
            throw new DataNotFoundException(
                    "error.global.manager", ex);
        }

        ExecmapSysMaster execmapSysMasterObject = (ExecmapSysMaster) query
                .get(0);

        if (execmapSysMasterObject != null) {
            globalSettingsModel = new GlobalSettingsModel();

            globalSettingsModel.setGlobalMngrUserId(execmapSysMasterObject
                    .getIntlcUsrId().trim());
            globalSettingsModel.setGlobalMngrPwd(execmapSysMasterObject
                    .getIntlcPasswd().trim());
            globalSettingsModel.setExchServerName(execmapSysMasterObject
                    .getEmailServerName().trim());
            globalSettingsModel.setExchServerPortNo(execmapSysMasterObject
                    .getEmailServerPort().trim());
            globalSettingsModel.setExchServerPwd(execmapSysMasterObject
                    .getEmailServerPassword().trim());
            globalSettingsModel.setExchServerUserId(execmapSysMasterObject
                    .getEmailServerUserid().trim());
            globalSettingsModel.setIntlcAcctId(execmapSysMasterObject
                    .getIntlcAcctId().trim());
            globalSettingsModel.setLstAcctNo(execmapSysMasterObject
                    .getLstAcctNo());
            globalSettingsModel.setSysMasId(execmapSysMasterObject
                    .getSysMasId());
            globalSettingsModel.setTestDur(execmapSysMasterObject.getTestDur());
        }

        return globalSettingsModel;

    }

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
    public void saveGlobalSettings(GlobalSettingsModel globalSettingsModel)
            throws DataSaveException {

        ExecmapSysMaster execmapSysMasterObject = new ExecmapSysMaster();
        execmapSysMasterObject.setIntlcUsrId(globalSettingsModel
                .getGlobalMngrUserId());
        execmapSysMasterObject.setIntlcPasswd(globalSettingsModel
                .getGlobalMngrPwd());
        execmapSysMasterObject.setEmailServerName(globalSettingsModel
                .getExchServerName().trim());
        execmapSysMasterObject.setEmailServerPort(globalSettingsModel
                .getExchServerPortNo().trim());
        execmapSysMasterObject.setEmailServerPassword(globalSettingsModel
                .getExchServerPwd().trim());
        execmapSysMasterObject.setEmailServerUserid(globalSettingsModel
                .getExchServerUserId().trim());

        execmapSysMasterObject.setLstAcctNo(globalSettingsModel.getLstAcctNo());
        execmapSysMasterObject.setSysMasId(globalSettingsModel.getSysMasId());
        execmapSysMasterObject.setTestDur(globalSettingsModel.getTestDur());
        execmapSysMasterObject.setIntlcAcctId(globalSettingsModel
                .getIntlcAcctId());
        try {
            globalSettingDAO.saveGlobalSettings(execmapSysMasterObject);
        }

        catch (DataIntegrityViolationException ex) {
            throw new DataSaveException("error.global.manager.save",
                    ex);
        }

    }

    /**
     * @return Returns the globalSettingDAO.
     */
    public GlobalSettingDAO getGlobalSettingDAO() {
        return globalSettingDAO;
    }

    /**
     * @param globalSettingDAO
     *            The globalSettingDAO to set.
     */
    public void setGlobalSettingDAO(GlobalSettingDAO globalSettingDAO) {
        this.globalSettingDAO = globalSettingDAO;
    }

    /**
     * @return Returns the hqlsearch.
     */
    public HQLSearch getHqlsearch() {
        return hqlsearch;
    }

    /**
     * @param hqlsearch
     *            The hqlsearch to set.
     */
    public void setHqlsearch(HQLSearch hqlsearch) {
        this.hqlsearch = hqlsearch;
    }

}
