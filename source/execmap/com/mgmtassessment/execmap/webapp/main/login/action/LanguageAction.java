/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : DasAshim
 * @date : Jul 11, 2006
 * @version:
 * @history Description Reference Name Date
 */

package com.mgmtassessment.execmap.webapp.main.login.action;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.login.form.LoginForm;

/**
 * Implementation of <strong>Action</strong> that changes the user's
 * {@link java.util.Locale} and forwards to a page, based on request level
 * parameters that are set (language).
 */

public class LanguageAction
        extends ExecmapAction {

    /**
     * <p>
     * Change the user's {@link java.util.Locale} based on {@link ActionForm}
     * properties.
     * </p>
     * <p>
     * This <code>Action</code> looks for <code>language</code> and
     * properties on the given form, constructs an appropriate Locale object,
     * and sets it as the Struts Locale for this user's session. If it doesn't
     * find the language in the form then the request is being made from the
     * index page where the default language, as hiddden attribute, is being set
     * as english. Any
     * <code>ActionForm, including a {@link DynaActionForm}, may be used.
     * </p>
     * <p>
     * If a <code>page</code> property is also provided, then after
     * setting the Locale, control is forwarded to that URI path.
     * Otherwise, control is forwarded to "success".
     * </p>
     *
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @return Action to forward to
     * @exception java.lang.Exception if an input/output error or servlet exception occurs
     */

    /** logger for this class. */
    private static Log log = LogFactory
                                   .getLog(LanguageAction.class);

    public ActionForward executeAction(
            ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response, UserContext usrContext,
            ServiceProxy serviceProxy)
            throws Exception {

        // Extract attributes we will need
        HttpSession session = request
                .getSession();
        Locale locale = getLocale(request);

        LoginForm langForm = (LoginForm) form;
        String language = langForm
                .getSelectedLanguage();

        /**
         * Set the default language to English, in case the user has not
         * selected any
         */

        if (null == language)
            language = "en";

        if ((language != null && language
                .length() > 0))
            locale = new java.util.Locale(
                    language, "");

        log
                .info("Got the locale from request and set in the user session.");
       langForm.setSelectedLanguage(language);
        session
                .setAttribute(
                        Globals.LOCALE_KEY, locale);
        return mapping
                .findForward(IConstants.SUCCESS_KEY);

    }
}
