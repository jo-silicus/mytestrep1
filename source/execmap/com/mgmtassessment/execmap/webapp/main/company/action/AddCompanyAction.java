/**
 *@Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 *@author : AhmedZia
 * @date : Jul 26, 2006
 *@version:
 *
 * @history Description Reference Name Date.
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

import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.company.form.CompanyAccountForm;

/**
 * Implementation of <strong>Action</strong> that populates the add company
 * page and forwards to a page, based on request level parameters that are set.
 *
 */

public class AddCompanyAction extends ExecmapAction {

    /**
     * <p>
     * The user's based on {@link CompanyAccountForm} properties.
     * </p>
     * <p>
     * This <code>Action</code> looks for <code>CompanyAccountForm</code>
     * and properties on the given form, and populates the details on the form
     * to be filled up by user.
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
     * @return Action to forward to addcompany.jsp
     * @exception java.lang.Exception
     *                if an input/output error or servlet exception occurs
     *
     */



    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy servPrxy) throws Exception {

        HttpSession session = request.getSession();
        
        CompanyAccountForm coAcctForm = (CompanyAccountForm)form;

        /** Default value for Company CoBrand is set */
        coAcctForm.setCompanyCoBrandFlag("N");

        if(usrContext.getUserInfo().getActivityRoleID().equals("1"));
        {
        return mapping.findForward(IConstants.SUCCESS);
        }
       
     
               
      

    }
}
