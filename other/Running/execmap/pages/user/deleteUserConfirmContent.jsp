<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ page import="com.perot.intellicue.common.util.webapp.*" %>
<html:xhtml />
<% 
	UserContext userContext= (UserContext)request.getSession(false).getAttribute("userContext");
	String roleId= userContext.getUserInfo().getActivityRoleID().toString().trim();
	request.setAttribute("roleId",roleId); 
	
%>
<bean:define id="accountId" name="ShowDisabledUsersForm" property="accountId"/>
<bean:define id="grpId" name="ShowDisabledUsersForm" property="groupId"/>
<p align="left">&nbsp;</p>
<table width="978" border="0" align="left" bordercolor="#FFFFFF" bgcolor="#023F70">
  <tr>
    <td width="797" ><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
   </a>
    <logic:lessThan name="roleId" value="3">
   ><a href='/execmap/CompanySearchAction.do' class='style1' >
   <bean:message bundle="execmap" key="adminoptions.account_management" />
   </a>
   
   ><a href="/execmap/SearchGroup.do?companyAccountID=<%=accountId%>" class='style1' >
  <bean:message bundle="execmap" key="adminoptions.groupmanagement" />
   </a>
   </logic:lessThan>
   <logic:equal name="roleId" value="3">
   ><a href='/execmap/GroupManagement.do' class='style1' >
   <bean:message bundle="execmap" key="adminoptions.groupmanagement" />
   </a>
   ><a href="/execmap/UserSearchAction.do?companyAccountID=<%=accountId%>&groupID=<%=grpId%>" class='style1' >
     <bean:message bundle="execmap" key="adminoptions.usermanagement" />
   </a>
   </logic:equal>
   > <bean:message bundle="execmap" key="adminoptions.delete.disabledusers.confirm" />
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
<p align="center"><bean:message bundle="execmap" key="user.deleted" /></p>
<p align="center">
<logic:iterate name="ShowDisabledUsersForm" property="selectedCheckboxes" id="userId">
<TR>


<TD><br><bean:write name="userId"/> (<%=(String)accountId%>) </TD>
<td><br></td>
</TR>
</logic:iterate>
<form>