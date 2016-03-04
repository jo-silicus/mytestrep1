<%-- 
  - Author(s): Rahul 
  - Date: 11th July 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: 
  - This page shows the message of group
  - creation confermation.The page is content part of 
  - AddConfirm.jsp. 
  -
  --%>
<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<p align="left">&nbsp;</p>

<bean:define id="uriAccountID" name="GroupAccountForm" property="companyAccountID"/>

<table width="978" border="0" align="left" bordercolor="CECE9C">
  <tr>
    <td width="797" bordercolor="#FFFFFF" bgcolor="#023F70"><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
    </a>
  
   ><a href='/execmap/CompanySearchAction.do' class='style1' >
   <bean:message bundle="execmap" key="adminoptions.account_management" />
   </a>

   ><a href="/execmap/SearchGroup.do?companyAccountID=<%=uriAccountID%>" class='style1' >
  <bean:message bundle="execmap" key="adminoptions.groupmanagement" />
   </a>
   ><bean:message bundle="execmap" key="generic.GroupCreateConfirm" />
   </td>
  </tr>
</table>
<p align="left">&nbsp;</p>


<p align="left">&nbsp;</p>
<table width="978" border="0">
  <tr>
    <td width="227" bgcolor="#023F70"><span class="style1"><bean:message bundle="execmap" key="generic.GroupCreateConfirm" /></span></td>
    <td width="571" bgcolor="#023F70">&nbsp;</td>
  </tr>
</table>

<table width="708" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="center"><span class="style10"><bean:message bundle="execmap" key="adminaddgrpconfirm.gp_record_update_mail" /></span>      
      </div></td>
     </tr>
</table>
