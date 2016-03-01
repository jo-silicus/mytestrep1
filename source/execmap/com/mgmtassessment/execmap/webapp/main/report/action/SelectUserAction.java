/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : singhrau
 * @date : Aug 17, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.webapp.main.report.action;

import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.report.form.SelectUserForm;

/**
 * This class retrieves all the users from the database corresponding to the
 * rptId.
 */

public class SelectUserAction extends ExecmapAction {

   /**
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request (if any).
     * @param request The HTTP request we are processing.
     * @param response The HTTP response we are creating.
     * @param usrContext The UserContext which provide details of User
     * @param servPrxy The ServiceProxy which creates bean to call business
     *        layer methods.
     * @return Action to forward to IndividualScoreReport.jsp
     * @exception java.lang.Exception if an input/output error or servlet
     *            exception occurs.
     */
    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy servPrxy) throws Exception {
        SelectUserForm selUserForm = (SelectUserForm) form;
        String rptId = request.getParameter("rptId");
        SortedSet grpList = null;
        SortedMap compList = new TreeMap();
        Map usrList = null;
        Byte actvRollId = usrContext.getUserInfo().getActivityRoleID();
        String acctId = usrContext.getUserInfo().getAccountId();
        String grpId = null;
        String acctIdForm = selUserForm.getAcctId();
        String grpIdForm = selUserForm.getGrpId();
        switch (actvRollId) {
            case IConstants.EXECMAP_ADMIN_ROLE_ID:
                selUserForm.setCompDropDown(true);
                compList = servPrxy.getReportManager().getAllCompanies(rptId);
                if (compList != null) {
                    selUserForm.setCompList(compList);
                    if (acctIdForm != null) {
                        acctId = acctIdForm;
                    } else {
                        acctId = (String)
                                        compList.firstKey();
                    }
                }
            case IConstants.EXECMAP_SUPERVISOR_ROLE_ID:
                selUserForm.setGrpDropDown(true);
                grpList = servPrxy.getReportManager().getAllGroups(acctId);
                if (grpList != null) {
                    selUserForm.setGrpList(grpList);
                    if (grpIdForm != null) {
                        grpId = grpIdForm;
                    } else {
                        grpId = (String)
                                        grpList.first();
                    }
                }
                break;
            case IConstants.EXECMAP_GROUP_COORDINATOR_ROLE_ID:
                grpId = servPrxy.getReportManager().getGrpId(acctId,
                        usrContext.getUserInfo().getLogonUserId());
            default:
                break;
        }
        selUserForm.setAcctId(acctId);
        usrList = servPrxy.getReportManager().getAllUsers(acctId, grpId, rptId);
        if (usrList.size() == 0) {
            selUserForm.setUsrListFlag("false");
        } else {
            selUserForm.setUsrListFlag("true");
        }
        selUserForm.setUsrList(usrList);
        return mapping.findForward(IConstants.SUCCESS_KEY);
    }
}
