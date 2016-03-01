/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : AhmedZia
 * @date : Aug 18, 2006
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

import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.company.form.CompanyAccountForm;

/**
 *Implementation of <strong>Action</strong> that fethces the image as
 *set by the user while creating the company.
 *
 */

public class ViewImageAction extends ExecmapAction {

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

    private static Log log = LogFactory.getLog(ViewImageAction.class);

    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy servPrxy) throws Exception {

        CompanyAccountForm coAcctForm = (CompanyAccountForm) form;

        String imageName = request.getParameter("image").toString();

        log.info("Image Name to be view:"+imageName);

        coAcctForm.setImageName(imageName);

        return mapping.findForward(IConstants.SUCCESS);

    }

}
