<%-- 
  - Author(s): 
  - Date: 17th Aug 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This jsp is for change profile action					
 --%>
<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<html:form action="/updateChangeProfile">
<p align="left">&nbsp;</p>
<table width="978" border="0" align="left" bordercolor="#FFFFFF" bgcolor="#023F70">
  <tr>
    <td width="797" ><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
    </a>
    ><bean:message bundle="execmap" key="adminoptions.change_profile" />
    </td>
    <td >
   <div align="right" class="style1">
    <a href="javascript:callHelp();" class='style1'><bean:message bundle="execmap" key="generic.help"/> </a>
    </div>
   </td>
  </tr>
</table>
 <FONT COLOR="#FF0000"><html:errors bundle="execmap"/></font>
 <p align="left">&nbsp;</p>
<logic:messagesPresent message="true">

<html:messages message="true" id="msg" bundle="execmap">

<FONT COLOR="#FF0000"><bean:write name="msg" ignore="true"/><br></font>

</html:messages>

</logic:messagesPresent>

<table width="978" border="0">
  <tr>
    <td width="227" bgcolor="#023F70"><span class="style1">User's Information </span></td>
    <td width="571" bgcolor="#023F70">&nbsp;</td>
  </tr>
</table>
 <html:hidden name="UserAccountForm" property="userCompanyAccountID"/>
<table width="700" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="302"><div align="right"><span class="style10"><bean:message bundle="execmap" key="editprofile.frmindusrcr.user_information" />:</span>      
    &nbsp; <html:text name="UserAccountForm" property="userGroupID" readonly="true" style="background-color: #CCCCCC;"/>
    </div></td>
     <td width="438"><div align="right"><bean:message bundle="execmap" key="generic.userid" />:
         <html:text name="UserAccountForm" property="userID" readonly="true" style="background-color: #CCCCCC;"/>
    </div></td>
  </tr>
</table>
<table width="700" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="302"><div align="right"><span class="style10"><bean:message bundle="execmap" key="generic.pwd" />:</span>      
     &nbsp;<html:password name="UserAccountForm" property="userPassword" style="background-color: #FFFF66;"/>
    </div></td>
     <td width="438"><div align="right"><bean:message bundle="execmap" key="generic.retype_pwd" />:
          <html:password name="UserAccountForm" property="userRetypePassword" style="background-color: #FFFF66;"/>
    </div></td>
  </tr>
</table>
<table width="700" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="302"><p align="right"> 
       <html:hidden name="UserAccountForm" property="userReminderPhrase"  style="background-color: #FFFF66;"/>
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
    <td width="231" bgcolor="#023F70"><span class="style1">Personal Information </span></td>
    <td width="567" bgcolor="#023F70">&nbsp;</td>
  </tr>
</table>
<table width="708" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="290"><div align="right"><bean:message bundle="execmap" key="generic.firstname" />:
         <html:text name="UserAccountForm" property="userFirstName" style="background-color: #FFFF66;"/>
    </div></td>
    <td width="408"><div align="right"><bean:message bundle="execmap" key="generic.lastname" />:
         <html:text name="UserAccountForm" property="userLastName" style="background-color: #FFFF66;"/>
    
    </div></td>
  </tr>
</table>
<table width="708" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="290"><div align="right"><bean:message bundle="execmap" key="generic.email" />:
         <html:text name="UserAccountForm" property="userEmail" style="background-color: #FFFF66;"/>
    </div></td>
    <td width="408"><p align="left">
     <html:hidden  name="UserAccountForm" property="userStatus"/>
   
</p></td>
  </tr>
</table>

<table width="708" border="0" cellpadding="0" cellspacing="0">
  <tr>
  <td width="322"><p align="right">
  <html:hidden  name="UserAccountForm" property="userNotes"/>
  </p></td> 
    </tr>
    <tr>
    <td width="473">&nbsp;</td>
    </tr>
</table>

<p>&nbsp;</p>
<table width="978" border="0" align="left" cellpadding="0" cellspacing="0" bgcolor="#009966">
  <tr>
    <td width="409" bgcolor="#023F70"><div align="left">
          <div align="center">
          <html:submit><bean:message bundle="execmap" key="generic.submit" /></html:submit>
             
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