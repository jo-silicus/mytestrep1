<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<p align="left">&nbsp;</p>
<html:hidden property="enableScript" value=""/>

<table width="978" border="0" align="left" bordercolor="CECE9C">
  <tr>
    <td width="797" bordercolor="#FFFFFF" bgcolor="#023F70"><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
   </a>
   ><a href='/execmap/CompanySearchAction.do' class='style1' >
   <bean:message bundle="execmap" key="adminoptions.account_management" />
   </a>
   ><a href="/execmap/ShowDisableCompanies.do" class='style1' >
  <bean:message bundle="execmap" key="company.delete.disable" />
   </a>
   ><bean:message bundle="execmap" key="deletecompany.title" />
   </td>
  </tr>
</table>
<p align="left">&nbsp;</p>
<p align="center"><bean:message bundle="execmap" key="deletecompany.msg" /></p>
<p align="center">
<logic:iterate name="CompanyAccountForm" property="selectedCheckboxes" id="userId">
<TR align="centre">
<td><TD align="centre" ><br><bean:write name="userId" /></TD></td>
</TR>
</logic:iterate>
</p>
<p>&nbsp;</p>
