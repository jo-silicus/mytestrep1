/**
 *  @Copyright Management Assessment Partners (MAP) AG
 *  All Rights Reserved.
 *
 *  @author : barthwpr
 *  @date   : Aug 18, 2006
 *  @version:
 *
 *  @history
 *  Description         Reference       Name        Date
 *
 */

package com.mgmtassessment.execmap.webapp.main.group.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.group.form.DeleteDisableGroupForm;

/**
 * this class is used for displaying the deleted groups that were selected
 *
 */

public class DeleteGroupConfirmAction extends ExecmapAction {
    private static Log log = LogFactory.getLog(DeleteGroupConfirmAction.class);

    /**
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @param usrContext
     * @param servPrxy
     * 
     * Implementation of inherited method from ExecmapAction, reposible for
     * executing the action to toggle the group status.
     * @return ActionForward
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy servPrxy) throws Exception {

        DeleteDisableGroupForm deleteDisableGroupForm =
            (DeleteDisableGroupForm) form;

        String accountId = deleteDisableGroupForm.getAccountId();

        String[] grpIds = deleteDisableGroupForm.getSelectedCheckboxes();

        /**
         * get the ServiceProxy to get the groupmanager and call the
         * deleteSelectedGroup method
         */

        servPrxy.getGroupManager().deleteSelectedGroup(accountId, grpIds);
        return mapping.findForward(IConstants.SUCCESS);

    }

}
