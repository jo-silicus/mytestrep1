/**
 *  @Copyright Management Assessment Partners (MAP) A
 *  All Rights Reserved.
 *
 *  @author : singhrau
 *  @date   : Aug 23, 2006
 *  @version:
 *
 *  @history
 *  this class is used to update the global manager data
 *  Description         Reference       Name        Date
 *
 */

package com.mgmtassessment.execmap.webapp.main.globalsettings.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.business.model.GlobalSettingsModel;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.globalsettings.form.GlobalSettingsForm;



/**.
 *this class is used to update the global manager data
 *
 */

public class EditGlobalSettingsAction extends ExecmapAction {

    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy servPrxy) throws Exception {

        GlobalSettingsModel globalSettingsModelObject =
            new GlobalSettingsModel();

        GlobalSettingsForm globalSettingsForm =
            (GlobalSettingsForm)form;

        String actionForward;

        globalSettingsModelObject = getServiceProxy()
        .getGlobalSettingManager().getGlobalSetting();

        String oldPassword = globalSettingsModelObject.
        getGlobalMngrPwd().trim();

        String newPassword = globalSettingsForm.getIntlcPasswd().trim();

        if (oldPassword.equals(newPassword)) {
            actionForward = "admin";
            }
        else {
            actionForward = "login";
            }

        GlobalSettingsModel globalSettingsModel =
            populateModel(globalSettingsForm);

        getServiceProxy().getGlobalSettingManager().saveGlobalSettings(
                globalSettingsModel);

        if (actionForward.equals("login")) {
            request.getSession().invalidate();
        }
        return mapping.findForward(actionForward);

    }

    /**.
     * this method is used to populate the model with the form values
     * @param globalSettingsForm
     *        form containig the data filled by the user
     * @return GlobalSettingsModel
     *         returns the model with the form values
     */
    private GlobalSettingsModel populateModel(
            GlobalSettingsForm globalSettingsForm) {
        GlobalSettingsModel globalSettingsModel = new GlobalSettingsModel();
        globalSettingsModel.setGlobalMngrUserId(globalSettingsForm
                .getIntlcUsrId().trim());
        globalSettingsModel.setGlobalMngrPwd(globalSettingsForm
                .getIntlcPasswd().trim());
        globalSettingsModel.setExchServerName(globalSettingsForm
                .getEmailServerName().trim());
        globalSettingsModel.setExchServerPortNo(globalSettingsForm
                .getEmailServerPort().trim());
        globalSettingsModel.setExchServerPwd(globalSettingsForm
                .getEmailServerPassword().trim());
        globalSettingsModel.setExchServerUserId(globalSettingsForm
                .getEmailServerUserid().trim());
        globalSettingsModel.setIntlcAcctId(globalSettingsForm.getIntlcAcctId()
                .trim());
        globalSettingsModel.setLstAcctNo(Integer.parseInt(globalSettingsForm
                .getLstAcctNo().trim()));
        globalSettingsModel.setSysMasId(Short.parseShort(globalSettingsForm
                .getSysMasId().trim()));
        globalSettingsModel.setTestDur(Short.parseShort(globalSettingsForm
                .getTestDur().trim()));
        return globalSettingsModel;
    }
}
