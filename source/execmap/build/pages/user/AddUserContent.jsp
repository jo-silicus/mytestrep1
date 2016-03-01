<%-- 
  - Author(s): Rahul 
  - Date: 11th July 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: 
  - This page is the content part of addUser.jsp which
  - shows the interface to create a user.
  -
  --%>
<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<p align="left">&nbsp;</p>
<bean:define id="uriAccountID" name="UserAccountForm" property="userCompanyAccountID"/>
<bean:define id="uriGroupID" name="UserAccountForm" property="userGroupID"/>

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
   ><a href="/execmap/UserSearchAction.do?companyAccountID=<%=uriAccountID%>&groupID=<%=uriGroupID%>" class='style1' >
     <bean:message bundle="execmap" key="adminoptions.usermanagement" />
   </a>
   > <bean:message bundle="execmap" key="generic.Create_User" />
   </td>
  </tr>
</table>
<p align="left">&nbsp;</p>

<html:form action="/userAccountAction">
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
     <html:text name="UserAccountForm" property="userGroupID" maxlength="8" readonly="true" style="background-color: #CCCCCC;"/>
    </div></td>
     <td width="438"><div align="right"><bean:message bundle="execmap" key="generic.userid" />:
         <html:text name="UserAccountForm" property="userID" maxlength="8" style="background-color: #FFFF66;"/>
    </div></td>
  </tr>
</table>
<table width="700" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="302"><div align="right"><span class="style10"><bean:message bundle="execmap" key="generic.pwd" />:</span>      
     <html:password name="UserAccountForm" property="userPassword" maxlength="15" style="background-color: #FFFF66;"/>
    </div></td>
     <td width="438"><div align="right"><bean:message bundle="execmap" key="generic.retype_pwd" />:
         <html:password name="UserAccountForm" property="userRetypePassword" maxlength="15" style="background-color: #FFFF66;"/>
    </div></td>
  </tr>
</table>
<table width="700" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="302"><p align="right"><bean:message bundle="execmap" key="adminaddcompany.remindphrase.label" />: 
        <html:text name="UserAccountForm" property="userReminderPhrase" maxlength="50" style="background-color: #FFFF66;"/>
    </p></td>
    <td width="438">&nbsp;</td>
  </tr>
</table>
<table width="700" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><bean:message bundle="execmap" key="adminaddcompany.remindphraseexpl.label" /></td>
  </tr>
</table>
<p>&nbsp;</p>
<table width="978" border="0">
  <tr>
    <td width="231" bgcolor="#023F70"><span class="style1"><bean:message bundle="execmap" key="editprofile.frmindusrcr.personal_information"/></span></td>
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
    <td width="408">
    <div align="left">
    <table width="408" border="0" cellpadding="0" cellspacing="0">
	<tr>  
    <td width="260">
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
  <td width="145"><div align="right"><bean:message bundle="execmap" key="adminedituser.frmcomusrcr.notes1.value" />:&nbsp;
  </div></td> 
    <td width="558"><div align="left"><html:textarea  name="UserAccountForm" property="userNotes"/></div></td>
    </tr>
</table>
<p>&nbsp;</p>
<table width="978" border="0" align="left" cellpadding="0" cellspacing="0" bgcolor="#009966">
  <tr>
    <td width="409" bgcolor="#023F70"><div align="left">
          <div align="center">
          <html:submit onclick="enableJavaScript();"><bean:message bundle="execmap" key="generic.submit" /></html:submit>
             
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