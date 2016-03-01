/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : singhrau
 * @date : Sep 14, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.business.impl.loginmanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.mgmtassessment.execmap.business.api.loginmanagement.
                                                        LoginManagementFacade;
import com.mgmtassessment.execmap.business.model.LoginManagementModel;
import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;
import com.mgmtassessment.execmap.common.framework.business.AbstractFacadeImpl;
import com.mgmtassessment.execmap.common.util.search.HQLSearch;
import com.mgmtassessment.execmap.data.dao.types.CompanyUserMaster;
import com.mgmtassessment.execmap.data.daoapi.UserAccountDAO;

/**
 * Class is responsible for all implementations of unlocking users operations.
 * @author singhrau
 */

public class LoginManagementFacadeImpl extends AbstractFacadeImpl implements
        LoginManagementFacade {

    /**
     * To save a user info in database.
     */
    private UserAccountDAO userAccountDAO;
    /**
     * For searching locked users.
     */
    private HQLSearch      hqlSearch;

    /**
     * @return Returns the hqlSearch.
     */
    public HQLSearch getHqlSearch() {
        return hqlSearch;
    }

    /**
     * @param hqlSearch The hqlSearch to set.
     */
    public void setHqlSearch(HQLSearch hqlSearch) {
        this.hqlSearch = hqlSearch;
    }

    /**
     * @param actvrollId of the user who has logged in
     * @param acctId of the user who has logged in
     * @param grpId of the user who has logged in
     * @param usrId of the user who has logged in
     * @return list of locked users
     * @throws DataNotFoundException if no locked user is retrieved.
     */
    public List getLockedUsers(String actvrollId, String acctId, String grpId,
            String usrId) throws DataNotFoundException {

        List resultList = new ArrayList();
        List usrList = new ArrayList();

        try {

            HashMap placeHolders = new HashMap();
            if (actvrollId.equals("" + IConstants.EXECMAP_ADMIN_ROLE_ID)) {
                resultList = hqlSearch.search("AllLockedUsersKey");
            } else if (actvrollId.equals(""
                    + IConstants.EXECMAP_SUPERVISOR_ROLE_ID)) {
                placeHolders.put("ACCTID", acctId);
                resultList = hqlSearch.search("CompanyLockedUsersKey",
                        placeHolders);
            } else if (actvrollId.equals(""
                    + IConstants.EXECMAP_GROUP_COORDINATOR_ROLE_ID)) {
                placeHolders.put("ACCTID", acctId);
                placeHolders.put("GRPID", grpId);
                resultList = hqlSearch.search("GroupLockedUsersKey",
                        placeHolders);
            }
            if (resultList.size() > 0) {
                Iterator resultIterator = resultList.iterator();
                while (resultIterator.hasNext()) {

                    CompanyUserMaster companyUserMaster = (CompanyUserMaster)
                                                          resultIterator.next();
                    LoginManagementModel loginManagementModel = new
                                                         LoginManagementModel();
                    loginManagementModel.setAcctId(companyUserMaster
                            .getComp_id().getAcctId());
                    loginManagementModel.setGrpId(companyUserMaster.getGrpId());
                    loginManagementModel.setUsrId(companyUserMaster
                            .getComp_id().getUsrId());
                    loginManagementModel.setUserName(companyUserMaster
                            .getFirstName()
                            + companyUserMaster.getLastName());
                    usrList.add(loginManagementModel);

                }
            }

        }

        catch (DataNotFoundException ex) {
            throw new DataNotFoundException("error.locked.users.list", ex);
        } catch (Exception ex) {
            throw new DataNotFoundException("error.locked.users.list", ex);
        }
        return usrList;

    }

    /**
     * @param accountId of the user whose account has has been unlocked
     * @param userId of the user whose account has has been unlocked
     * @throws DataNotFoundException if no locked user is retrieved.
     */
    public void UnlockUser(String accountId, String userId)
            throws DataNotFoundException {

        List resultList = new ArrayList();
        try {
            HashMap placeHolders = new HashMap();
            placeHolders.put("ACCTID", accountId);
            placeHolders.put("USRID", userId);
            resultList = hqlSearch.search("SelectUser", placeHolders);
        } catch (DataNotFoundException e) {
            throw new DataNotFoundException("error.locked.users.list", e);
        }

        if (resultList.size() > 0) {
            Iterator resultIterator = resultList.iterator();
            while (resultIterator.hasNext()) {

                CompanyUserMaster companyUserMaster = (CompanyUserMaster)
                                                          resultIterator.next();
                companyUserMaster.setAcctLocked(0);
                userAccountDAO.updateUser(companyUserMaster);
            }
        }
    }

    /**
     * @return Returns the userAccountDAO.
     */
    public UserAccountDAO getUserAccountDAO() {
        return userAccountDAO;
    }

    /**
     * @param userAccountDAO The userAccountDAO to set.
     */
    public void setUserAccountDAO(UserAccountDAO userAccountDAO) {
        this.userAccountDAO = userAccountDAO;
    }
}
