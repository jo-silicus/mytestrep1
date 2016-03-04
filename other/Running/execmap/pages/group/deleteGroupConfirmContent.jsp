<%-- 
  - Author(s): 
  - Date: 17th Aug 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This page gives a confirmation message when a group 
  -is deleted.
 --%>
<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<html:xhtml />
<bean:define id="accountId" name="DeleteDisableGroupForm" property="accountId"/>
<p align="left">&nbsp;</p>

<table width="978" border="0" align="left" bordercolor="#FFFFFF" bgcolor="#023F70">
  <tr>
    <td width="797" ><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
    </a>
    
    ><a href='/execmap/CompanySearchAction.do' class='style1' >
   <bean:message bundle="execmap" key="adminoptions.account_management" />
   </a>
   
   ><a href="/execmap/SearchGroup.do?companyAccountID=<%=accountId%>" class='style1' >
  <bean:message bundle="execmap" key="adminoptions.groupmanagement" />
   </a>
   ><bean:message bundle="execmap" key="adminoptions.delete.disabledgroups.confirm" />
   </td>
   <td >
   <div align="right" class="style1">
    <a href="javascript:callHelp();" class='style1'><bean:message bundle="execmap" key="generic.help"/> </a>
    </div>
   </td>
   </tr>
   </table>
<form>
<p align="left">&nbsp;</p>
<p align="center"><bean:message bundle="execmap" key="group.deleted" /></p>
<p align="center">
<logic:iterate name="DeleteDisableGroupForm" property="selectedCheckboxes" id="grpId">
<TR>

<TD><br><bean:write name="grpId"/> (<%=(String)accountId%>) </TD>
<td><br></td>
</TR>
</logic:iterate>
<form>