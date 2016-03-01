/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : AhmedZia
 * @date : Jul 29, 2006
 * @version:
 *
 * @history Description Reference Name Date
 *
 */

package com.mgmtassessment.execmap.webapp.main.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;

/**
 * Implementation of <strong>Action</strong> that calls the Add Cobrand JSP.
 *
 */

public class CobrandAction extends ExecmapAction {

    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy servPrxy) throws Exception {

        // Extract attributes we will need
        HttpSession session = request.getSession();

        /**
         * TODO connect to the persistence layer to extract the uid , pwd and
         * acct id and make a hash of both to verify pwd and return principal to
         * the session. For now let the control go to the admin screen.
         */

        return mapping.findForward(IConstants.SUCCESS);

    }

}
