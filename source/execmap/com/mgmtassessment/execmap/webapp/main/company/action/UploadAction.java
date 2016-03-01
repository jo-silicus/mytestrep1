/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 * 
 * @author : AhmedZia
 * @date : Aug 8, 2006
 * @version:
 * 
 * @history Description Reference Name Date.
 * 
 */

package com.mgmtassessment.execmap.webapp.main.company.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.upload.FormFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.company.form.UploadForm;

/**
 * This class takes the UploadForm and retrieves the text value and file
 * attributes and puts them in the request for the display.jsp page to display
 * them.
 * 
 * @author Ahmed Zia
 * 
 */

public class UploadAction extends ExecmapAction {

    /**
     * <p>
     * The user's based on {@link UploadForm} properties.
     * </p>
     * <p>
     * This <code>Action</code> looks for <code>UploadForm</code> and
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
     * 
     * @return Action to forward to accountmanagement.jsp
     * @exception java.lang.Exception
     *                if an input/output error or servlet exception occurs
     */

    private static Log log = LogFactory.getLog(UploadAction.class);

    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy serviceProxy) throws Exception {

        if (form instanceof UploadForm) {

            UploadForm fileForm = (UploadForm) form;
            ActionMessages messages = validateFormValues(fileForm);

            if (!messages.isEmpty()) {
                saveMessages(request, messages);
                return mapping.findForward(IConstants.FAILURE);
            }

            FormFile file = fileForm.getFile();
            // retrieve the file name
            String fileName = file.getFileName();

            log.info("Name of the CSV File uploaded:" + fileName);

            String imagePath = request.getSession().getServletContext()
                    .getRealPath(IConstants.IMAGES_PATH);

            String cobrandPath = request.getSession().getServletContext()
                    .getRealPath(IConstants.COBRAND_PATH);

            loadData(fileName, cobrandPath);

            try {
                InputStream stream = file.getInputStream();
                OutputStream bos = new FileOutputStream(imagePath + "\\"
                        + fileName);
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
        return mapping.findForward(IConstants.SUCCESS_KEY);

    }

    /**
     * 
     * This Method loads the image file to a particular location.
     * 
     * @param fileName
     * @param cobrandPath
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    private void loadData(String fileName, String cobrandPath)
            throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(cobrandPath);

        Element root = doc.getDocumentElement();

        Element updateElement = doc.createElement(IConstants.IMAGE_FILE);
        Node updateText = doc.createTextNode(fileName);

        updateElement.appendChild(updateText);
        root.appendChild(updateElement);

        try {

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new FileOutputStream(
                    cobrandPath));

            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transformer = transFactory.newTransformer();

            transformer.transform(source, result);

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Validates the form values.
     * 
     * @param fileForm
     * @return messages
     */
    private ActionMessages validateFormValues(UploadForm fileForm) {

        ActionMessages messages = new ActionMessages();

        FormFile file = fileForm.getFile();
        // retrieve the file name
        String fileName = file.getFileName().toLowerCase();

        if (!fileName.equals("")) {
            if (!fileName.endsWith("jpg") && !fileName.endsWith("jpeg")
                    && !fileName.endsWith("gif")) {

                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                        "label.upload.image", true));
            }
        }

        if (!fileName.equals("")) {

            if (file.getFileSize() > 50000) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                        "upload.image.size", true));

            }
        }

        if (fileName.equals("")) {

            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
                    "label.upload.emplty"));
        }

        return messages;
    }

}
