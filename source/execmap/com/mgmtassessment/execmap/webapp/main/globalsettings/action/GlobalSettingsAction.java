/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : singhrau
 * @date : Aug 23, 2006
 * @version:
 *
 * @history
 * this class is used to get all the details for the global manager
 *
 *
 */

package com.mgmtassessment.execmap.webapp.main.globalsettings.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.business.model.GlobalSettingsModel;
import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.globalsettings.
form.GlobalSettingsForm;

/**.
 *this class is used to get all the details for the global manager
 *
 */

public class GlobalSettingsAction extends ExecmapAction {

    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy servPrxy) throws Exception {

        GlobalSettingsForm globalsettingForm = (GlobalSettingsForm) form;
        GlobalSettingsModel globalSettingsModel = getServiceProxy()
                .getGlobalSettingManager().getGlobalSetting();
        ((GlobalSettingsForm)form)
        .populateForm(globalSettingsModel);

        return mapping.findForward(IConstants.SUCCESS_KEY);
    }

}
