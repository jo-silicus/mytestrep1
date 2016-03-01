/**
 *  @Copyright Management Assessment Partners (MAP) AG
 *  All Rights Reserved.
 *
 *  @author : barthwpr
 *  @date   : Aug 16, 2006
 *  @version:
 *
 *  @history class responsible for retrieving 
 *  disabled groups of a particular company
 *  Description         Reference       Name        Date
 *
 */

package com.mgmtassessment.execmap.webapp.main.group.action;

import java.util.ArrayList;
import java.util.List;

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


/**.
 *  this class is used for getting the list of
 *  disabled groups to show on the  jsp
 *
 */

public class ShowDisableGroups extends ExecmapAction {


    /**
     * Implementation of inherited method from ExecmapAction, reposible for
     * executing the action to forward the user to add Group page.
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
     * @return Action to forward to delete disabled group page
     * @throws Exception
     */

    private static Log log = LogFactory.getLog(ShowDisableGroups.class);

    public ActionForward executeAction(
                            ActionMapping mapping,
                            ActionForm form,
                            HttpServletRequest request,
                            HttpServletResponse response,
                            UserContext usrContext,
                            ServiceProxy serviceProxy)
                            throws Exception {

        DeleteDisableGroupForm deleteDisableGroupForm =
            (DeleteDisableGroupForm)
             form;
    List listOfDisabledGroups = new ArrayList();
    String accountId = request.getParameter("companyAccountID");
       /**
         * get the ServiceProxy to get the groupmanager and call the
         * deleteDisableGroup method
         */
    listOfDisabledGroups =  (List)
    serviceProxy.
    getGroupManager().deleteDisableGroup(accountId);

    deleteDisableGroupForm.setListOfDisabledGroups(listOfDisabledGroups);

     return mapping.findForward(IConstants.SUCCESS_KEY);

    }
  }

