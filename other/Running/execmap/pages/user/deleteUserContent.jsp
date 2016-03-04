<%-- 
  - Author(s): 
  - Date: 17th Aug 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This jsp is used to show list of disabled users					
 --%>
<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ page import="com.perot.intellicue.data.dao.types.*"%>
<%@ page import="com.perot.intellicue.common.util.webapp.*" %>
<html:xhtml />
<% 
	UserContext userContext= (UserContext)request.getSession(false).getAttribute("userContext");
	String roleId= userContext.getUserInfo().getActivityRoleID().toString().trim();
	request.setAttribute("roleId",roleId); 
	String accountId = request.getParameter("companyAccountID"); 
	String grpId = request.getParameter("groupID"); 
%>
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
   > <bean:message bundle="execmap" key="adminoptions.delete.disabledusers" />
   </td>
   <td >
   <div align="right" class="style1">
    <a href="javascript:callHelp();" class='style1'><bean:message bundle="execmap" key="generic.help"/> </a>
    </div>
   </td>
  </tr>
</table>
<form name="ShowDisabledUsersForm" onSubmit="return valid()"
method="post" action="/execmap/DeleteSelectedUser.do">
<logic:messagesPresent message="true">

<html:messages message="true" id="msg" bundle="execmap">

<FONT COLOR="#FF0000"><bean:write name="msg" ignore="true"/><br></font>

</html:messages>

</logic:messagesPresent>

<p align="left">&nbsp;</p>
<table width="978" border="1" cellpadding="0" bordercolor="#003366">
  <tr bgcolor="#006699" height="40">
    <td width="2%" bgcolor="#023F70"><p align="center" class="style1">&nbsp; </p></td>
    
    <td width="11%" bgcolor="#023F70"><p align="center" class="style1"><bean:message bundle="execmap" key="generic.Group" /></p></td>
    <td width="13%" bgcolor="#023F70"><p align="center" class="style1"><bean:message bundle="execmap" key="reportframe.adminreportpanel.jlabel.userid" /></p></td>
    <td width="13%" bgcolor="#023F70"><p align="center" class="style1"><bean:message bundle="execmap" key="generic.name" /></p></td>
    
    <td width="22%" bgcolor="#023F70"><p align="center" class="style1"><bean:message bundle="execmap" key="generic.email" /></p></td>
  </tr>
 
  <logic:notEmpty  name="ShowDisabledUsersForm" property="listOfDisabledUsers">
  <logic:iterate id="DisplayDetails"  name="ShowDisabledUsersForm" property="listOfDisabledUsers" type="com.perot.intellicue.data.dao.types.CompanyAcctMaster">
  <bean:define id="companyAccountID" name="DisplayDetails" property="acctId"/>
  <html:hidden name="ShowDisabledUsersForm" property="accountId" value='<%=(String)companyAccountID%>'/>
   <logic:iterate id="Displaygroups"  name="DisplayDetails" property="coGrpMas" type="com.perot.intellicue.data.dao.types.CompanyGroupMaster">
   <bean:define id="GroupMasterKey" name="Displaygroups" property="comp_id" type="com.perot.intellicue.data.dao.types.CompanyGroupMasterKey"/>
   <bean:define id="groupId" name="GroupMasterKey" property="grpId"/>
   <html:hidden name="ShowDisabledUsersForm" property="groupId" value='<%=(String)groupId%>'/>
      <logic:iterate id="Displayusers"  name="Displaygroups" property="coUsrMas" type="com.perot.intellicue.data.dao.types.CompanyUserMaster">
      <bean:define  id="actvRolId" name="Displayusers" property="actvRolMa" type="com.perot.intellicue.data.dao.types.ActvRolMaster"/>
      <bean:define  id="compositeKey" name="Displayusers" property="comp_id" type="com.perot.intellicue.data.dao.types.CompanyUserMasterKey"/>
      <logic:notEqual name="actvRolId" property="actvRolId" value="3">
      <logic:notEqual name="actvRolId" property="actvRolId" value="2">
      <logic:notEqual name="actvRolId" property="actvRolId" value="1">
    <tr>
      <td width="2%">
    <html:multibox name="ShowDisabledUsersForm" property="selectedCheckboxes">
  <bean:write name="compositeKey" property="usrId"/>
 </html:multibox>
    </td>
    
      <td width="11%" ><p align="center"> <bean:write name="Displaygroups" property="grpInfo"/> </p></td>
      <td width="13%" ><p align="center"><bean:write name="compositeKey" property="usrId"/></p></td>
      <td width="13%" ><p align="center"><bean:write name="Displayusers" property="firstName"/> <bean:write name="Displayusers" property="lastName"/>  </p></td>
      <td width="22%"><p align="center"> <bean:write name="Displayusers" property="usrEmail"/> </p></td>
    </tr>
    </logic:notEqual>
    </logic:notEqual>
    </logic:notEqual>
    </logic:iterate>  
   </logic:iterate>
  </logic:iterate>
  </logic:notEmpty>
  </table>
   <logic:empty  name="ShowDisabledUsersForm" property="listOfDisabledUsers">
  <p align="center"><bean:message bundle="execmap" key="msg.user.delete.disabled.user"/></p>
  </logic:empty>
  <logic:notEmpty  name="ShowDisabledUsersForm" property="listOfDisabledUsers">
  
  <table width="980" border="0" align="left" bgcolor="#023F70">
  <tr>
    <td>    
        <div align="center">
    	<html:submit onclick="javascript:deleteAllUser(this.form.selectedCheckboxes);"><bean:message bundle="execmap" key="generic.deleteAll" /></html:submit>	    
	         </div>
   </td>
   <bean:define id="msg">
     <bean:message bundle="execmap" key="generic.User.Error.Delete" />
     </bean:define>
     <input type="hidden" name="error" value="<%=(String)msg%>">
     <html:hidden property="enableScript" value=""/>
    <td>
        <div align="center">
        <html:submit onclick="enableJavaScript();"><bean:message bundle="execmap" key="generic.delete"/></html:submit>
        
                 </div>
    </td>
  </tr>
</table>
</logic:notEmpty>

<p>&nbsp;</p>
  </form>