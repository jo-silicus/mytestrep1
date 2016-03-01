/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : singhrau
 * @date : Sep 14, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.business.api.loginmanagement;

import java.util.List;

import com.mgmtassessment.execmap.common.exceptions.DataNotFoundException;
import com.mgmtassessment.execmap.common.framework.business.AbstractFacade;

/**
 * this interface is used to provide methods for retrieving locked users and
 *                                                       unlocking locked users.
 */
public interface LoginManagementFacade extends AbstractFacade {
    /**
     * @param actvrollId of the user who has logged in
     * @param acctId of the user who has logged in
     * @param grpId of the user who has logged in
     * @param usrId of the user who has logged in
     * @return list of locked users
     * @throws DataNotFoundException if no locked user is retrieved.
     */
    List getLockedUsers(String actvrollId, String acctId, String grpId,
            String usrId) throws DataNotFoundException;
    /**
     * @param accountId of the user whose account has has been unlocked
     * @param userId of the user whose account has has been unlocked
     * @throws DataNotFoundException if no locked user is retrieved.
     */
    void UnlockUser(String accountId, String userId)
            throws DataNotFoundException;

}
