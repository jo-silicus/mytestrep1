/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * @author : DasAshim
 * @date : Jul 6, 2006
 */
package com.mgmtassessment.execmap.common.framework.webapp;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/**
 * TODO Describe the purpose of this class
 */

public class ExecmapForm
        extends ValidatorForm {

    String enableScript = "Disabled";

    /**
     * @return Returns the enableScript.
     */
    public String getEnableScript() {
        return enableScript;
    }

    /**
     * @param enableScript
     *            The enableScript to set.
     */
    public void setEnableScript(
            String enableScript) {
        this.enableScript = enableScript;
    }

    /**
     * Validate the properties that have been set from this HTTP request, and
     * return an <code>ActionErrors</code> object that encapsulates any
     * validation errors that have been found. If no errors are found, return
     * <code>null</code> or an <code>ActionErrors</code> object with no
     * recorded error messages.
     *
     * @param mapping
     *            The mapping used to select this instance
     * @param request
     *            The servlet request we are processing
     * @return ActionErrors containing the validation errors found
     */

    public ActionErrors validate(
            ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = super
                .validate(
                        mapping, request);

        return errors;
    }

}
