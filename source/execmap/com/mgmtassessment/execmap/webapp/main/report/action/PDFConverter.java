/**
 *  @Copyright Management Assessment Partners (MAP) AG
 *  All Rights Reserved.
 *
 *  @author : singhrau
 *  @date   : Aug 30, 2006
 *  @version:
 *
 *  @history
 *  Description         Reference       Name        Date
 *
 */

package com.mgmtassessment.execmap.webapp.main.report.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mgmtassessment.execmap.common.core.type.constants.IConstants;
import com.mgmtassessment.execmap.common.framework.webapp.ExecmapAction;
import com.mgmtassessment.execmap.common.framework.webapp.ServiceProxy;
import com.mgmtassessment.execmap.common.util.webapp.UserContext;
import com.mgmtassessment.execmap.webapp.main.report.form.PDFConverterForm;

/**
 * Action class to convert html into
 * PDF.
 *
 */

public class PDFConverter extends ExecmapAction {

    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            UserContext usrContext, ServiceProxy servPrxy)
            throws Exception {

        PDFConverterForm converterForm = (PDFConverterForm)
                                                       form;
        String repName = request.getParameter("repName");
        String rptId = request.getParameter("rptId");
        String repPath = request.getSession().getServletContext()
        .getRealPath("\\html\\reports");
        String imgPath = request.getSession().getServletContext()
        .getRealPath(IConstants.IMAGES_PATH);
        servPrxy.getReportManager().convertIntoPDF(repPath,
                                          repName, imgPath, rptId);
        converterForm.setRepName(repName + ".pdf");
        return mapping.findForward(IConstants.SUCCESS_KEY);
    }
}