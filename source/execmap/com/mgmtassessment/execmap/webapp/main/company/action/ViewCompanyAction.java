/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : AhmedZia
 * @date : Aug 7, 2006
 * @version:
 *
 * @history Description Reference Name Date
 *
 */

package com.mgmtassessment.execmap.webapp.main.company.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.business.model.CompanyAccountModel;
import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.company.form.CompanyAccountForm;

/**
 * Implementation of <strong>Action</strong> that fethces the details of
 * particular company by accountid.
 *
 */

public class ViewCompanyAction extends ExecmapAction {

    private static Log log = LogFactory.getLog(ViewCompanyAction.class);

    /**
     * <p>
     * The user's based on {@link CompanyAccountForm} properties.
     * </p>
     * <p>
     * This <code>Action</code> looks for <code>CompanyAccountForm</code>
     * and properties on the given form,
     * <p>
     *
     * @param mapping
     *            The ActionMapping used to select this instance
     * @param form
     *            The optional ActionForm bean for this request (if any)
     * @param request
     *            The HTTP request we are processing
     * @param response
     *            The HTTP response we are creating
     *
     * @return Action to forward to
     * @exception java.lang.Exception
     *                if an input/output error or servlet exception occurs
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
             UserContext usrContext, ServiceProxy serviceProxy) 
           throws Exception {

        /**
         * Extract attributes we will need. TODO move this up to ExecmapAction
         */
        HttpSession session = request.getSession();

        CompanyAccountForm coAcctForm = (CompanyAccountForm) form;

        String accountId = request.getParameter(IConstants.ACCT_ID);

        log.info("Account Id of Company to view the detail:"+accountId);

        /**
         * get the ServiceProxy, get the Login Service Facade from it and invoke
         * the view methods.
         *
         */

        CompanyAccountModel coAcctModel = serviceProxy.getCompanyManager()
                .viewCompanyDetails(accountId);

        coAcctForm.populateForm(coAcctModel);

        return mapping.findForward(IConstants.SUCCESS_KEY);

    }

}
