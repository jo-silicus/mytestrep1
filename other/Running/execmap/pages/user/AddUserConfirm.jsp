<%-- 
  - Author(s): Rahul 
  - Date: 11th July 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: 
  - This page shows the message of user
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
<%@ page import="com.perot.intellicue.common.util.webapp.*" %>
<p align="left">&nbsp;</p>
<bean:define id="uriAccountID" name="UserAccountForm" property="userCompanyAccountID"/>
<bean:define id="uriGroupID" name="UserAccountForm" property="userGroupID"/>

<% 
	UserContext userContext= (UserContext)request.getSession(false).getAttribute("userContext");
	String roleId= userContext.getUserInfo().getActivityRoleID().toString().trim();
	request.setAttribute("roleId",roleId); 
%>
<table width="978" border="0" align="left" bordercolor="CECE9C">
  <tr>
    <td width="797" bordercolor="#FFFFFF" bgcolor="#023F70"><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
   </a>
    <logic:lessThan name="roleId" value="3">
   ><a href='/execmap/CompanySearchAction.do' class='style1' >
   <bean:message bundle="execmap" key="adminoptions.account_management" />
   </a>
   </logic:lessThan>
   ><a href="/execmap/SearchGroup.do?companyAccountID=<%=uriAccountID%>" class='style1' >
  <bean:message bundle="execmap" key="adminoptions.groupmanagement" />
   </a>
   ><a href="/execmap/UserSearchAction.do?companyAccountID=<%=uriAccountID%>&groupID=<%=uriGroupID%>" class='style1' >
     <bean:message bundle="execmap" key="adminoptions.usermanagement" />
   </a>
   > <bean:message bundle="execmap" key="generic.UserCreateConfirm" />
   </td>
  </tr>
</table>
<p align="left">&nbsp;</p>
<table width="978" border="0">
  <tr>
    <td width="227" bgcolor="#023F70"><span class="style1"><bean:message bundle="execmap" key="generic.UserCreateConfirm" /></span></td>
    <td width="571" bgcolor="#023F70">&nbsp;</td>
  </tr>
</table>

<table width="708" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="center"><span class="style10"><bean:message bundle="execmap" key="adminadduserconfirm.user_record_update_mail" /></span>      
      </div></td>
     </tr>
</table>
