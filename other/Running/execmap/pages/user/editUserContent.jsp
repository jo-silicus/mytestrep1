<%-- 
  - Author(s): Rahul 
  - Date: 11th July 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: 
  - This page is the content part of editUser.jsp which
  - shows the interface to edit a user record.
  -
  --%>
<%@ page language="java" %>
<%@ page import="com.perot.intellicue.common.util.webapp.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>


<script>
<!-- change made here  25/09/06 -->
function SendUserEmail()
{
	enableJavaScript();
	document.forms[0].action="/execmap/SendUserEmailAction.do";
}
<!-- change end here  25/09/06 -->
</script>

<p align="left">&nbsp;</p>

<% 
	UserContext userContext= (UserContext)request.getSession(false).getAttribute("userContext");
	String roleId= userContext.getUserInfo().getActivityRoleID().toString().trim();
	request.setAttribute("roleId",roleId); 
%>

<bean:define id="uriAccountID" name="UserAccountForm" property="userCompanyAccountID"/>
<bean:define id="uriGroupID" name="UserAccountForm" property="userGroupID"/>

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
   </logic:lessThan>
   ><a href="/execmap/SearchGroup.do?companyAccountID=<%=uriAccountID%>" class='style1' >
  <bean:message bundle="execmap" key="adminoptions.groupmanagement" />
   </a>
   ><a href="/execmap/UserSearchAction.do?companyAccountID=<%=uriAccountID%>&groupID=<%=uriGroupID%>" class='style1' >
     <bean:message bundle="execmap" key="adminoptions.usermanagement" />
   </a>
   > <bean:message bundle="execmap" key="generic.Update_User" />
   </td>
      <td >
   <div align="right" class="style1">
    <a href="javascript:callHelp();" class='style1'><bean:message bundle="execmap" key="generic.help"/> </a>
    </div>
   </td>
  </tr>
</table>
<p align="left">&nbsp;</p>

<html:form action="/updateUserAction">
 <FONT COLOR="#FF0000"><html:errors bundle="execmap"/></font>
<logic:messagesPresent message="true">

<html:messages message="true" id="msg" bundle="execmap">

<FONT COLOR="#FF0000"><bean:write name="msg" ignore="true"/><br></font>

</html:messages>

</logic:messagesPresent>
<html:hidden property="enableScript" value=""/>
<table width="978" border="0">
  <tr>
    <td width="227" bgcolor="#023F70"><span class="style1"><bean:message bundle="execmap" key="editprofile.frmindusrcr.user_information"/> </span></td>
    <td width="571" bgcolor="#023F70">&nbsp;</td>
  </tr>
</table>
 <html:hidden name="UserAccountForm" property="userCompanyAccountID"/>
<table width="700" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="302"><div align="right"><span class="style10"><bean:message bundle="execmap" key="admineditgroup.frmcogrpup.grpid.value" />:</span>      
     <html:text name="UserAccountForm" property="userGroupID" maxlength="15" readonly="true" style="background-color: #CCCCCC;"/>
    </div></td>
     <td width="438"><div align="right"><bean:message bundle="execmap" key="generic.userid" />:
         <html:text name="UserAccountForm" property="userID" maxlength="15" readonly="true" style="background-color: #CCCCCC;"/>
    </div></td>
  </tr>
</table>
<table width="700" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="302"><div align="right"><span class="style10"><bean:message bundle="execmap" key="generic.pwd" />:</span>      
     <html:password name="UserAccountForm" property="userPassword" maxlength="8" style="background-color: #FFFF66;"/>
    </div></td>
     <td width="438"><div align="right"><bean:message bundle="execmap" key="generic.retype_pwd" />:
          <html:password name="UserAccountForm" property="userRetypePassword" maxlength="8" style="background-color: #FFFF66;"/>
    </div></td>
  </tr>
</table>
<table width="700" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="302"><p align="right"> 
        <html:hidden name="UserAccountForm" property="userReminderPhrase"  style="background-color: #CCCCCC;"/>
    </p></td>
    <td width="438">&nbsp;</td>
  </tr>
</table>
<table width="700" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td></td>
  </tr>
</table>
<p>&nbsp;</p>
<table width="978" border="0">
  <tr>
    <td width="231" bgcolor="#023F70"><span class="style1"><bean:message bundle="execmap" key="editprofile.frmindusrcr.personal_information"/> </span></td>
    <td width="567" bgcolor="#023F70">&nbsp;</td>
  </tr>
</table>
<table width="708" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="290"><div align="right"><bean:message bundle="execmap" key="generic.firstname" />:
         <html:text name="UserAccountForm" property="userFirstName" maxlength="50" style="background-color: #FFFF66;"/>
    </div></td>
    <td width="408"><div align="right"><bean:message bundle="execmap" key="generic.lastname" />:
         <html:text name="UserAccountForm" property="userLastName" maxlength="50" style="background-color: #FFFF66;"/>
    
    </div></td>
  </tr>
</table>
<table width="708" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="289"><div align="right"><bean:message bundle="execmap" key="generic.email" />:
         <html:text name="UserAccountForm" property="userEmail" maxlength="40" style="background-color: #FFFF66;"/>
    </div></td>
        <td width="100">
<!-- change made here  25/09/06 -->

    <div align="left">
     <html:submit onclick="enableJavaScript();SendUserEmail();"><bean:message bundle="execmap" key="generic.sendEmail" /></html:submit>
    </div>
<!-- change end here  25/09/06 -->
    </td>
    <td width="308">
    <div align="left">
    <table width="308" border="0" cellpadding="0" cellspacing="0">
	<tr>  
    <td width="155">
    <div align="right"> 
    <bean:message bundle="execmap" key="generic.status" />:
    </div>
    </td>
    <td width="140">
    <div align="left">
    <html:select  name="UserAccountForm" property="userStatus"  style="background-color: #FFFF66;">
               <html:option value="E"><bean:message bundle="execmap" key="adminedituser.frmcomusrcr.status.enabled" /></html:option>
              <html:option value="D"><bean:message bundle="execmap" key="adminedituser.frmcomusrcr.status.disabled" /></html:option>
        </html:select>
    </div>
    </td>
    
    </tr>
   </table>
</div>
</td>
  </tr>
 </table>

<table width="708" border="0" cellpadding="0" cellspacing="0">
  <tr>
  <td width="140"><div align="right"><bean:message bundle="execmap" key="adminedituser.frmcomusrcr.notes1.value" />:&nbsp;
  </div></td> 
    <td width="550"><div align="left"><html:textarea  name="UserAccountForm" property="userNotes"/></div></td>
    </tr>
</table>

<p>&nbsp;</p>
<table width="978" border="0" align="left" cellpadding="0" cellspacing="0" bgcolor="#009966">
  <tr>
    <td width="409" bgcolor="#023F70"><div align="left">
          <div align="center">
          <html:submit onclick="enableJavaScript()"><bean:message bundle="execmap" key="generic.submit" /></html:submit>
             
          </div>
    </div></td>
    <td width="399" bgcolor="#023F70">
      <div align="center">
         <html:reset><bean:message bundle="execmap" key="generic.reset" /></html:reset>
      </div>
</td>
  </tr>
</table>
<p>&nbsp;</p>


</html:form>