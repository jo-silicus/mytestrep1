/**
 * @Copyright Management Assessment Partners (MAP) AG All Rights Reserved.
 *
 * @author : AhmedZia
 * @date : Aug 11, 2006
 * @version:
 *
 * @history Description Reference Name Date
 *
 */

package com.mgmtassessment.execmap.webapp.main.company.action;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.company.form.CompanyAccountForm;

/**
 *Implementation of <strong>Action</strong> that parse the
 *Cobrand_metadata.xml which contains list of all the cobrand
 *images.
 *
 */

public class ShowImageList extends ExecmapAction {

    /**
     * <p>
     * The user's based on {@link CompanyAccountForm} properties.
     * </p>
     * <p>
     * This <code>Action</code> looks for <code>CompanyAccountForm</code>
     * and properties on the given form, and populates the details on the form
     * to be filled up by user.
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
     * @param servPrxy
     *            The ServiceProxy which creates bean to call business layer
     *            methods.
     *
     * @return Action to forward to addcompany.jsp
     * @exception java.lang.Exception
     *                if an input/output error or servlet exception occurs
     *
     */

    private static Log log = LogFactory.getLog(ShowImageList.class);

    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy servPrxy) throws Exception {

        CompanyAccountForm coAcctForm = (CompanyAccountForm)form;

        List images = new ArrayList();

        String cobrandPath = request.getSession().getServletContext()
                .getRealPath(IConstants.COBRAND_PATH);

        log.info("Path of Cobrand Image"+cobrandPath);

        XMLStreamReader reader = XMLInputFactory.newInstance()
                .createXMLStreamReader(new FileInputStream(cobrandPath));
        while (reader.hasNext()) {
            int eventType = reader.next();
            if (eventType == XMLEvent.START_ELEMENT
                    && reader.getLocalName().equals(IConstants.IMAGE_FILE)) {
                reader.next();
                images.add(reader.getText());
            }
        }

        coAcctForm.setImagesList(images);

        return mapping.findForward(IConstants.SUCCESS);

    }

}
