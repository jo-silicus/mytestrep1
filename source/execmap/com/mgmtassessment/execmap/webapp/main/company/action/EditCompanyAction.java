/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : barthwpr
 * @date : Aug 2, 2006
 * @version:
 *
 * @history Description Reference Name Date
 *
 */

package com.mgmtassessment.execmap.webapp.main.company.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
 * Implementation of <strong>Action</strong> that fetch details of particular
 * company by accountid for editing by the user.
 *
 */

public class EditCompanyAction extends ExecmapAction {

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
     * @param usrContext
     *            The UserContext which provide details of User
     * @param servPrxy
     *            The ServiceProxy which creates bean to call business layer
     *            methods.
     *
     * @return Action to forward to editcompany.jsp
     * @exception java.lang.Exception
     *                if an input/output error or servlet exception occurs
     */

    private static Log log = LogFactory.getLog(EditCompanyAction.class);

    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy servPrxy) throws Exception {

        CompanyAccountForm coAcctForm = (CompanyAccountForm)form;

        CompanyAccountModel coAcctModel = new CompanyAccountModel();

        String acctid = request.getParameter(IConstants.ACCT_ID);

        log.info("Account ID of Company to View:"+acctid);

       /**
         * through the service proxy call the companymanagerfacade view company
         * method
         *
         */
        coAcctModel = servPrxy.getCompanyManager().viewCompanyDetails(acctid);

        /** Populate Company Account Form */
        coAcctForm.populateForm(coAcctModel);

        /** Sets Password retype same as Company Manager */
        coAcctForm.setReminderPhrase(coAcctModel.getCompanyMgrPasswd());

        return mapping.findForward(IConstants.SUCCESS);
    }
}
