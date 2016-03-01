/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : DasAshim
 * @date : Jul 25, 2006
 * @version:
 *
 * @history Description Reference Name Date
 *
 */

package com.mgmtassessment.execmap.webapp.main.company.action;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.mgmtassessment.execmap.business.model.CompanyAccountModel;
import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.company.form.CompanyAccountForm;


/**
 * Implementation of <strong>Action</strong> that add the company to the
 * database based on the details provided by the userand also sends the email to
 * administrator to inform about the creation of new company.
 *
 */

public class CompanyAccountAction extends ExecmapAction {

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

    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy serviceProxy)
            throws Exception {

        CompanyAccountForm coAcctForm = (CompanyAccountForm)form;

        ActionMessages messages = validateFormValues(coAcctForm);

        if (!messages.isEmpty()) {
            saveMessages(request, messages);
            return mapping.findForward("failure");
        }

        /** Get the Model Data from CompanyAccountForm * */

        CompanyAccountModel coAcctModel = populateModel(coAcctForm);

        /**
         * get the ServiceProxy, get the Login Service Facade from it and invoke
         * the save methods.
         *
         * TODO implement this.
         */

        serviceProxy.getCompanyManager().saveCompany(coAcctModel);

        /**
         * TODO connect to the persistence layer to extract the uid , pwd and
         * acct id and make a hash of both to verify pwd and return principal to
         * the session. For now let the control go to the admin screen.
         */

        return mapping.findForward(IConstants.SUCCESS_KEY);

    }

    /**
     * This is a helper method to extract company related data from the
     * CompanyAccountForm.
     *
     * @param CompanyAccounttForm
     * @return CompanyAccountModel
     */
    private CompanyAccountModel populateModel(CompanyAccountForm coActForm){

        CompanyAccountModel coActModel = new CompanyAccountModel();

        coActModel.companyName = coActForm.getCompanyName();
        coActModel.companyInfo = coActForm.getCompanyInfo();
        coActModel.companyAddr1 = coActForm.getCompanyAddr1();
        coActModel.companyAddr2 = coActForm.getCompanyAddr2();
        coActModel.companyCity = coActForm.getCompanyCity();
        coActModel.companyState = coActForm.getCompanyState();
        coActModel.companyZip = coActForm.getCompanyZip();
        coActModel.companyCtry = coActForm.getCompanyCtry();
        coActModel.companyEmail = coActForm.getCompanyEmail();
        coActModel.companyManagerFirstName = coActForm
                .getCompanyManagerFirstName();
        coActModel.companyManagerLastName = coActForm
                .getCompanyManagerLastName();
        coActModel.companyMgrUserId = coActForm.getCompanyMgrUserId();
        coActModel.companyMgrPasswd = coActForm.getCompanyMgrPasswd();
        coActModel.companyPwdReminderPhrase = coActForm
                .getCompanyPwdReminderPhrase();

        if(coActForm.getCompanyCoBrandFlag().equals("N"))
               {
           coActModel.companyCoBrandInfo = "Execmap_logo.gif";
               }

           else
           {
               coActModel.companyCoBrandInfo =
                   coActForm.getCompanyCoBrandInfo();
           }
       
        coActModel.companyTechContactName = coActForm
                .getCompanyTechContactName();
        coActModel.companyTechContactEmail = coActForm
                .getCompanyTechContactEmail();
        coActModel.companyReportFormat = coActForm.getCompanyReportFormat();
        coActModel.setUserAccountLockedStatus("0");
        
        return coActModel;

    }

    /**
     * Validate Form Values.
     *
     * @param coAcctForm
     * @return messages
     */
    private ActionMessages validateFormValues(CompanyAccountForm coAcctForm){

        ActionMessages messages = new ActionMessages();

        if (!INT_REGEX.matcher(coAcctForm.getCompanyTechContactEmail())
                .matches()) {
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                    "label.technical.email",true));
        }

        if (!INT_REGEX.matcher(coAcctForm.getCompanyEmail()).matches()) {
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                    "label.company.email",true));
        }

        if (!coAcctForm.getCompanyMgrPasswd().equals(
                coAcctForm.getReminderPhrase())) {

            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                    "label.password.equal",true));
        }
        
        if(coAcctForm.getCompanyCoBrandFlag().equals("Y")&&
                coAcctForm.getCompanyCoBrandInfo().equals("")){

            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                    "label.cobrandinfo.provide",true));
        }
        
        return messages;
    }

    /**
     * Regular expression for checking EMAIL.
     */
    private final static Pattern INT_REGEX = Pattern
                                                   .compile(
                      "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)"
                      + "*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)"
                      + "*(\\.[_A-Za-z0-9-]+)", //$NON-NLS-1$
                      Pattern.CASE_INSENSITIVE);

}
