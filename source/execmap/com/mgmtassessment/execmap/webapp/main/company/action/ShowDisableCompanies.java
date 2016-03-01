/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : AhmedZia
 * @date : Aug 12, 2006
 * @version:
 *
 * @history Description Reference Name Date
 *
 */

package com.mgmtassessment.execmap.webapp.main.company.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.company.form.CompanyAccountForm;

/**
 * Implementation of <strong>Action</strong> that show all the
 * disable companies from the database.
 *
 */

public class ShowDisableCompanies extends ExecmapAction {

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
     * @param serviceProxy
     *            The ServiceProxy which creates bean to call business layer
     *            methods.
     *
     * @return Action to forward to message.jsp
     * @exception java.lang.Exception
     *                if an input/output error or servlet exception occurs
     */

    private static Log log = LogFactory.getLog(ShowDisableCompanies.class);

    public ActionForward executeAction(ActionMapping mapping,
       ActionForm form,HttpServletRequest request, 
       HttpServletResponse response,UserContext usrContext,
       ServiceProxy serviceProxy) throws Exception {


        CompanyAccountForm coAcctForm = (CompanyAccountForm)form;

        /**
         * TODO connect to the persistence layer to extract the uid , pwd and
         * acct id and make a hash of both to verify pwd and return principal to
         * the session. For now let the control go to the admin screen.
         */

        Collection companyList = serviceProxy.getCompanyManager()
                .showDisableCompanies();

        log.info("Size of Disable Companies List"
                +companyList.size());

        if (companyList.size() == 0) {
            return mapping.findForward(IConstants.FAILURE);
                                     }

        else {
            coAcctForm.setDisableCompanies(companyList);

            return mapping.findForward(IConstants.SUCCESS_KEY);
        }

    }

}
