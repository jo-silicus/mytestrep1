/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @Author : Kumarra
 * @Date : Jul 7, 2006
 */
package com.mgmtassessment.execmap.data.daoimpl;

/**
 * TODO add description for this class
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mgmtassessment.execmap.data.dao.types.ExecmapSysMaster;
import com.mgmtassessment.execmap.data.daoapi.GlobalSettingDAO;

/**
 * @author kumarra
 */
public class GlobalSettingDaoImpl extends HibernateDaoSupport implements
        GlobalSettingDAO {
    /**
     * template that is used throughout to perform all inset,update retrive etc.
     */
    private HibernateTemplate hibernateTemplate = null;

    /**
     * retrieve the data global settings data from the ExecmapSysMaster class
     * the data returned is a single row in database
     * 
     * @return ExecmapSysMaster returns the ExecmapSysMaster object having all
     *         the data from the database *
     * @throws DataRetrievalFailureException
     */
    public ExecmapSysMaster getGlobalSetting()
            throws DataRetrievalFailureException {
        List queryResult = new ArrayList();
        ExecmapSysMaster object = null;
        hibernateTemplate = getHibernateTemplate();
        queryResult = hibernateTemplate.loadAll(ExecmapSysMaster.class);
        object = (ExecmapSysMaster) queryResult.get(0);
        return object;

    }

    /**
     * this method saves the changes made for the global manager in the
     * ExecmapSysMaster
     * 
     * @param execmapSysMasterObject
     *            it is the ExecmapSysMaster object having all the changes done
     * by the user @ throws DataIntegrityViolationException exception thrown if
     *            data couldn't be saved
     */
    public void saveGlobalSettings(ExecmapSysMaster execmapSysMasterObject)
            throws DataIntegrityViolationException {

        hibernateTemplate = getHibernateTemplate();
        hibernateTemplate.update(execmapSysMasterObject);
        hibernateTemplate.flush();
    }

}
