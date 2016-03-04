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
   ><a href='/execmap/AddCompanyAction.do' class='style1' >
   <bean:message bundle="execmap" key="company.addcompany" />
   </a>
   ><bean:message bundle="execmap" key="generic.conformation" />
   </td>
  </tr>
</table>
<html:hidden property="enableScript" value=""/>
<p align="left">&nbsp;</p>
<p align="center"><bean:message bundle="execmap" key="company.creation.confirmation.msg" /></p>
<p>&nbsp;</p>

