/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : AhmedZia
 * @date : Aug 14, 2006
 * @version:
 *
 * @history Description Reference Name Date
 *
 */

package com.mgmtassessment.execmap.webapp.main.user.action;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
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
import org.apache.struts.upload.FormFile;

import com.mgmtassessment.execmap.business.impl.user.UserManagerFacadeImpl;
import com.mgmtassessment.execmap.business.model.UserAccountModel;
import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.user.form.UserAccountForm;
import com.mgmtassessment.execmap.webapp.main.user.form.UserCreationForm;

/**
 * Implementation of <strong>Action</strong> that creates the user using CSV
 * files.
 *
 */

public class UserCreationAction extends ExecmapAction {

    private static Log log = LogFactory.getLog(UserCreationAction.class);

    /**
     * <p>
     * The user's based on {@link UserAccountForm} properties.
     * </p>
     * <p>
     * This <code>Action</code> looks for <code>UserAccountForm</code> and
     * properties on the given form,
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
            UserContext usrContext, ServiceProxy serviceProxy) throws Exception {

        UserCreationForm userCreationForm = (UserCreationForm) form;

        List userDetail = new ArrayList();

        final String delimiter = ",";

        FormFile file = userCreationForm.getFile();

        ActionMessages messages = validateFile(userCreationForm);

        if (!messages.isEmpty()) {
            saveMessages(request, messages);
            return mapping.findForward(IConstants.FAILURE);
        }

        String fileName = file.getFileName();
        loadFile(file);
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:/"
                + fileName));
        String line = null;

        while ((line = bufferedReader.readLine()) != null) {
            String[] result = line.split(delimiter);

            userCreationForm.setUserCompanyAccountID(result[0]);
            userCreationForm.setUserGroupID(result[1]);
            userCreationForm.setUserID(result[2]);
            userCreationForm.setUserPassword(result[3]);
            userCreationForm.setUserFirstName(result[4]);
            userCreationForm.setUserLastName(result[5]);
            userCreationForm.setUserEmail(result[6]);
            userCreationForm.setUserNotes(result[7]);
            userCreationForm.setUserReminderPhrase(result[8]);

            messages = validateFormValues(userCreationForm);
            if (messages.isEmpty()) {
                UserAccountModel userAccountModel = 
                    populateModel(userCreationForm);
                userDetail.add(userAccountModel);
            }
        }

        bufferedReader.close();

        messages = serviceProxy.getUserManager().createUser(userDetail);
        if (messages.isEmpty()) {
            return mapping.findForward(IConstants.SUCCESS);
        } else {
            return mapping.findForward(IConstants.ERROR_RECORDS);
        }
    }

    /**
     * Loads the CSV to speciic location.
     *
     * @param file
     */
    private void loadFile(FormFile file) {

        String fileName = file.getFileName();

        try {
            InputStream stream = file.getInputStream();
            OutputStream bos = new FileOutputStream("C:/" + fileName);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            bos.close();
            // data = "The file has been written to c: " + fileName + "/";
            stream.close();
        }
        catch (FileNotFoundException fnfe) {
        }
        catch (IOException ioe) {
        }
        file.destroy();

    }

    /**
     * Populates the UserAccountModel.
     *
     * @param userCreationForm
     * @return userAccountModel
     */
    private UserAccountModel populateModel(UserCreationForm userCreationForm) {

        UserAccountModel userAccountModel = new UserAccountModel();

        userAccountModel.setUserCompanyAccountID(userCreationForm
                .getUserCompanyAccountID());
        userAccountModel.setUserGroupID(userCreationForm.getUserGroupID());
        userAccountModel.setUserID(userCreationForm.getUserID());
        userAccountModel.setUserPassword(userCreationForm.getUserPassword());
        userAccountModel.setUserReminderPhrase(userCreationForm
                .getUserReminderPhrase());
        userAccountModel.setUserFirstName(userCreationForm.getUserFirstName());
        userAccountModel.setUserLastName(userCreationForm.getUserLastName());
        userAccountModel.setUserEmail(userCreationForm.getUserEmail());
        userAccountModel.setUserStatus(userCreationForm.getUserStatus());
        userAccountModel.setUserNotes(userCreationForm.getUserNotes());
        userAccountModel.setUserRoleID("5");
        userAccountModel.setUserStartFlag("T");
        userAccountModel.setUserStatus("E");
        userAccountModel.setUserAccountLockedStatus("0");

        return userAccountModel;
    }

    /**
     * Validates File values as loaded by the user.
     * 
     * @param userCreationForm
     * @return messages
     */
    private ActionMessages validateFile(UserCreationForm userCreationForm) {

        ActionMessages messages = new ActionMessages();

        FormFile file = userCreationForm.getFile();
        // retrieve the file name
        String fileName = file.getFileName().toLowerCase();

        if (!fileName.equals("")) {
            if (!fileName.endsWith("csv")) {

                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                        "label.upload.userfile",true));
            }
        }

        if (!fileName.equals("")) {

            if (file.getFileSize() > 50000) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                        "upload.file.size", true));

            }
        }

        
       
        if (fileName.equals("")) {

            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                    "label.upload.empty",true));
        }

        return messages;
    }

    /**
     * Validate Form Values
     * @param userCreationForm
     * @return
     */
    public ActionMessages validateFormValues(UserCreationForm userCreationForm) {

        ActionMessages messages = new ActionMessages();

        if (userCreationForm.getUserCompanyAccountID().equals("")) {

            log.info("User cannot be created for NULL ACCOUNT ID");
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(""));
        }

        if (userCreationForm.getUserGroupID().equals("")) {

            log.info("User cannot be created for ACCOUNT ID:"
                    + userCreationForm.getUserCompanyAccountID()
                    + "and USERID:" + userCreationForm.getUserID()
                    + "as GROUPID is NULL");
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(""));
        }

        if (userCreationForm.getUserID().equals("")) {

            log.info("User cannot be created for ACCOUNT ID:"
                    + userCreationForm.getUserCompanyAccountID()
                    + "as USERID is NULL");
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(""));
        }

        if (userCreationForm.getUserPassword().equals("")) {

            log.info("User cannot be created for ACCOUNT ID:"
                    + userCreationForm.getUserCompanyAccountID()
                    + "and USERID:" + userCreationForm.getUserID()
                    + "as PASSWORD is NULL");
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(""));
        }

        if (userCreationForm.getUserFirstName().equals("")) {

            log.info("User cannot be created for ACCOUNT ID:"
                    + userCreationForm.getUserCompanyAccountID()
                    + "and USERID:" + userCreationForm.getUserID()
                    + "as USER'S FIRST NAME is NULL");
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(""));
        }

        if (userCreationForm.getUserLastName().equals("")) {

            log.info("User cannot be created for ACCOUNT ID:"
                    + userCreationForm.getUserCompanyAccountID()
                    + "and USERID:" + userCreationForm.getUserID()
                    + "as USER'S LAST NAME is NULL");
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(""));
        }

        if (userCreationForm.getUserEmail().equals("")) {

            log.info("User cannot be created for ACCOUNT ID:"
                    + userCreationForm.getUserCompanyAccountID()
                    + "and USERID:" + userCreationForm.getUserID()
                    + "as EMAIL is NULL");
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(""));
        }

        if (!INT_REGEX.matcher(userCreationForm.getUserEmail()).matches()) {

            log.info("User cannot be created for ACCOUNT ID:"
                    + userCreationForm.getUserCompanyAccountID()
                    + "and USERID:" + userCreationForm.getUserID()
                    + "as EMAIL is not valid");
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(""));
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
