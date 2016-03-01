<%-- 
  - Author(s): Singhra
  - Date: 17th Aug 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This jsp is used to display all the locked users of a group, account or complete application
 --%>
<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<p>&nbsp;</p>
<table width="978" border="0" align="left" bordercolor="CECE9C">
  <tr>
    <td width="797" bordercolor="#FFFFFF" bgcolor="#023F70"><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
   </a>
   ><bean:message bundle="execmap" key="general.login.management" />
   </td>
  </tr>
</table>
<p>&nbsp;</p>
<html:form action="/lockedUsers.do">

 <FONT COLOR="#FF0000"><html:errors  bundle="execmap"/></font>
 <logic:messagesPresent message="true">
 <p align="center"><html:messages message="true" id="msg" bundle="execmap"></p>
 <FONT COLOR="#FF0000"><bean:write name="msg" ignore="true"/></font>
 </html:messages>
 </logic:messagesPresent>

<logic:notEmpty name="LoginManagementForm" property="lockedUsers">
<table width="978" border="1" cellpadding="0" bordercolor="#003366">
	<tr bgcolor="#023F70">
		<td width="5%"></td>
		<td width="20%"><p align="center" class="style1"><bean:message bundle="execmap" key="label.AcctId" /></td>
		<td width="25%"><p align="center" class="style1"><bean:message bundle="execmap" key="admineditgroup.frmcogrpup.grpid.value" /></td>
		<td width="25%"><p align="center" class="style1"><bean:message bundle="execmap" key="admineditgroup.frmcogrpup.login.value" /></td>
		<td width="25%"><p align="center" class="style1"><bean:message bundle="execmap" key="userreportcordinator.username.title" /></td>
	</tr>
</table>		
<table width="978" border="1" cellpadding="0">			
<logic:iterate id="user" name="LoginManagementForm" property="lockedUsers" >

	<tr>
		<td width="5%"><p align="center">
			<html:multibox name="LoginManagementForm" property="selectedCheckboxes" >
			<bean:write name="user" property="acctId"/><bean:write name="user" property="usrId"/>
			</html:multibox ></p>
		</td>
		<td width="20%"><p align="center"><bean:write name="user" property="acctId"/></p></td>
		<td width="25%"><p align="center"><bean:write name="user" property="grpId"/></p></td>
		<td width="25%"><p align="center"><bean:write name="user" property="usrId"/></p></td>		
		<td width="25%"><p align="center"><bean:write name="user" property="userName"/></p></td>					
	<tr>
</logic:iterate>
</table>
<p>&nbsp;</p>
<table width="978" border="0" bgcolor="#023F70">
  <tr>
    <td width="978"><div align="center">
<html:submit>
<bean:message bundle="execmap" key="generic.unlock.users" />
</html:submit>
</div></td></tr></table>
</logic:notEmpty>

</html:form>
