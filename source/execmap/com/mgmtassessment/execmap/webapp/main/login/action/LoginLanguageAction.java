/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : sharmrahu
 * @date : Sep 8, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.webapp.main.login.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.login.form.LoginLanguagesForm;

/**
 * TODO Write java docs comments for this type
 */

public class LoginLanguageAction
        extends ExecmapAction {

    public ActionForward executeAction(
            ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response, UserContext usrContext,
            ServiceProxy servPrxy)
            throws Exception {
        LoginLanguagesForm languagesForm = (LoginLanguagesForm) form;
        Map languages = servPrxy
                .getLoginManager().getLanguages();
        languagesForm
                .setLanguages(languages);
        return mapping.findForward(IConstants.SUCCESS);
    }

}
