<%-- 
  - Author(s): Rahul 
  - Date: 11th July 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: 
  - This page is the content part of viewUser.jsp which
  - shows the interface to edit a user record.
  -
  --%>
<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ page import="com.mgmtassessment.execmap.common.util.webapp.*" %>
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
   > <bean:message bundle="execmap" key="generic.View_User" />
   </td>
  </tr>
</table>

<html:form action="/viewUserAction">
 <FONT COLOR="#FF0000"><html:errors/></font>
<logic:messagesPresent message="true">
<html:messages message="true" id="msg" bundle="execmap">
<FONT COLOR="#FF0000"><bean:write name="msg" ignore="true"/><br></font>
</html:messages>
</logic:messagesPresent>
<p align="left">&nbsp;</p>
<table width="978" border="0">
  <tr>
    <td width="227" bgcolor="#023F70"><span class="style1"><bean:message bundle="execmap" key="editprofile.frmindusrcr.user_information"/> </span></td>
    <td width="571" bgcolor="#023F70">&nbsp;</td>
  </tr>
</table>

<table width="750" border="0">
  <tr>
    <td><div align="right"><span class="style6"><div align="right"><bean:message bundle="execmap" key="admineditgroup.frmcogrpup.grpid.value" />:</span></div></td>
    <td><span class="style6"><bean:write name="UserAccountForm" property="userGroupID" /></span></td>
    <td><div align="right"><span class="style6"><bean:message bundle="execmap" key="generic.userid"/>:</span></div></td>
    <td><span class="style6"><bean:write name="UserAccountForm" property="userID" /></span></td>
  </tr>
  <tr>
    <td><div align="right"><span class="style6"><div align="right"><bean:message bundle="execmap" key="generic.pwd" />:</span></div></td>
    <td><span class="style6"><bean:write name="UserAccountForm" property="userPassword" /></span></td>
    <td><div align="right"><span class="style6"><bean:message bundle="execmap" key="adminaddcompany.remindphrase.label" />:</span></div></td>
    <td><span class="style6"><bean:write name="UserAccountForm" property="userReminderPhrase" /></span></td>
  </tr>
</table>


<p>&nbsp;</p>


<table width="978" border="0">
  <tr>
    <td width="231" bgcolor="#023F70"><span class="style1"><bean:message bundle="execmap" key="editprofile.frmindusrcr.personal_information"/> </span></td>
    <td width="567" bgcolor="#023F70">&nbsp;</td>
  </tr>
</table>

<table width="750" border="0">
  <tr>
    <td><div align="right"><span class="style6"><div align="right"><bean:message bundle="execmap" key="generic.firstname" />:</span></div></td>
    <td><span class="style6"><bean:write name="UserAccountForm" property="userFirstName" /></span></td>
    <td><div align="right"><span class="style6"><bean:message bundle="execmap" key="generic.lastname"/>:</span></div></td>
    <td><span class="style6"><bean:write name="UserAccountForm" property="userLastName" /></span></td>
  </tr>
  <tr>
    <td><div align="right"><span class="style6"><div align="right"><bean:message bundle="execmap" key="generic.email" />:</span></div></td>
    <td><span class="style6"><bean:write name="UserAccountForm" property="userEmail" /></span></td>
    <td><div align="right"><span class="style6"><bean:message bundle="execmap" key="generic.status" />:</span></div></td>
    <td><span class="style6">
     <logic:equal name="UserAccountForm" property="userStatus"  value="D">
    <bean:message bundle="execmap" key="adminedituser.frmcomusrcr.status.disabled" />
     </logic:equal>
   <logic:equal name="UserAccountForm" property="userStatus"  value="E">
    <bean:message bundle="execmap" key="adminedituser.frmcomusrcr.status.enabled" />
    </logic:equal>
    </span></td>
  </tr>
</table>

</table>
<table width="708" border="0" cellpadding="0" cellspacing="0">
  <tr>
  <td width="120"><div align="right"><bean:message bundle="execmap" key="adminedituser.frmcomusrcr.notes1.value" />:&nbsp;
  </div></td> 
    <td width="580"><div align="left"><html:textarea  name="UserAccountForm" property="userNotes" disabled="true"/></div></td>
    </tr>
</table>
<p>&nbsp;</p>
<p>&nbsp;</p>


</html:form>