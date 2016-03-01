<%-- 
  - Author(s): 
  - Date: 11th July 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This is the assessment subheader for assessment pages.
  - This page is invoked from all assessment related jsp's for the
  - subheader section.
  --%>


<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<html:xhtml />


<table width="980" border="0" cellspacing="0">
      <tr>
        <td width="978" bgcolor="#FFFFFF"><div align="left"><span class=style5>
          <table cellSpacing=0 width=981 bgColor=#d4d0c8 background="/execmap/images/main/blue_label.jpg" border=0>
            <tbody>
              <tr>
                <td width="100%" bgColor=#023f70><div class=style6 align=left>
                    <div class=style8 align=center>
                      <div align=center class=style5>
                       <bean:write name="AssessmentMultiForm" property="subHeader" />
                      
                     </div>
                    </div>
                </div></td>
              </tr>
            </tbody>
          </table>
        </span></div></td>
      </tr>
    </table>

