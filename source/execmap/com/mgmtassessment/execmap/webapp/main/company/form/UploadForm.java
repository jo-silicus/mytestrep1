/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : AhmedZia
 * @date : Aug 24, 2006
 * @version:
 *
 * @history Description Reference Name Date
 *
 */
package com.mgmtassessment.execmap.webapp.main.company.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.upload.FormFile;
import org.apache.struts.upload.MultipartRequestHandler;

import com.mgmtassessment.execmap.common.framework.webapp.ExecmapForm;

/**
 * This class is a placeholder for form values.In a multipart request,files are
 * represented by set and get methods that use the class org.apache.struts.
 * upload.FormFile, an interface with basic methods to retrieve file
 * information. The actual structure of the FormFile is dependant on the
 * underlying impelementation of multipart request handling. The default
 * implementation that struts uses is
 * org.apache.struts.upload.CommonsMultipartRequestHandler.
 *
 *
 */
public class UploadForm extends ExecmapForm {

    /**
     * The file that the user has uploaded.
     */
    private FormFile file;

    /**
     * Check to make sure the client hasn't exceeded the maximum allowed upload
     * size inside of this validate method.
     */
    public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {

        ActionErrors errors = null;
        // has the maximum length been exceeded?
        Boolean maxLengthExceeded = (Boolean)request
                .getAttribute(MultipartRequestHandler.
                        ATTRIBUTE_MAX_LENGTH_EXCEEDED);

        if ((maxLengthExceeded != null) && (maxLengthExceeded.booleanValue())) {
            errors = new ActionErrors();
            errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                    "maxLengthExceeded"));
            errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                    "maxLengthExplanation"));
        }
        return errors;

    }

    /**
     * @return Returns the file.
     */
    public FormFile getFile() {
        return file;
    }

    /**
     * @param file
     *            The file to set.
     */
    public void setFile(FormFile file) {
        this.file = file;
    }

    /**
     * Reset the form attributes
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        super.reset(mapping, request);
    }

}
