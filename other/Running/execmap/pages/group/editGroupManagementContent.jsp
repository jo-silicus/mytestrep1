<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<script>
<!-- chnage made here  25/09/06  -->
function SendGroupManagementEmail()
{
	enableJavaScript();
	document.forms[0].action="/execmap/SendGroupManagementEmailAction.do";
}
<Change end here -->
</script>

<p align="left">&nbsp;</p>
<table width="978" border="0" align="left" bordercolor="#FFFFFF" bgcolor="#023F70">
  <tr>
    <td width="797" ><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
    </a>
   ><a href='/execmap/GroupManagement.do' class='style1' >
   <bean:message bundle="execmap" key="adminoptions.groupmanagement" />
   </a>
   ><a href='/execmap/editGroupManagementAction.do' class='style1' >
   <bean:message bundle="execmap" key="adminoptions.editgroup" />
   </a>
   </td>
   <td >
   <div align="right" class="style1">
    <a href="javascript:callHelp();" class='style1'><bean:message bundle="execmap" key="generic.help"/> </a>
    </div>
   </td>
  </tr>
</table>
<html:form  action="/updateGroupManagementAction">
<p align="left">&nbsp;</p>
 <FONT COLOR="#FF0000"><html:errors bundle="execmap"/></font>
 <p align="left">&nbsp;</p>
 <logic:messagesPresent message="true">
<html:messages message="true" id="msg" bundle="execmap">
<FONT COLOR="#FF0000"><bean:write name="msg" ignore="true"/><br></font>
</html:messages>

</logic:messagesPresent>
<table width="978" border="0">
  <tr>
    <td width="227" bgcolor="#023F70"><span class="style1"><bean:message bundle="execmap" key="admineditgroup.frmcogrpup.grpinfo.value" /> </span></td>
    <td width="571" bgcolor="#023F70">&nbsp;</td>
  </tr>
</table>

<html:hidden name="GroupAccountForm" property="companyAccountID"/>
<table width="708" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="302"><div align="right"><span class="style10"><bean:message bundle="execmap" key="admineditgroup.frmcogrpup.grpid.value" />:</span>      
     <html:text name="GroupAccountForm" property="groupID" maxlength="15" readonly="true" style="background-color: #CCCCCC;"/>
    </div></td>
    <td width="438"><div align="right"><bean:message bundle="execmap" key="adminaddgroup.frmcogrpcr.txt_grp_info" />:
      <html:text name="GroupAccountForm" property="groupInformation" maxlength="40"/>
    </div></td>
  </tr>
</table>
<table width="708" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="225"><p align="right"><bean:message bundle="execmap" key="generic.status" />:
    <html:select  name="GroupAccountForm" property="groupStatus" style="background-color: #FFFF66;">
                  <html:option value="E"><bean:message bundle="execmap" key="adminedituser.frmcomusrcr.status.enabled" /></html:option>
              <html:option value="D"><bean:message bundle="execmap" key="adminedituser.frmcomusrcr.status.disabled" /></html:option>
        </html:select>
   </p></td>
    </tr>
    <tr>
    <td width="473">&nbsp;</td>
    </tr>
</table>
<p>&nbsp;</p>
<table width="978" border="0">
  <tr>
    <td width="231" bgcolor="#023F70"><span class="style1"><bean:message bundle="execmap" key="admineditgroup.frmcogrpup.grpmanagerinfo.value" /> </span></td>
    <td width="567" bgcolor="#023F70">&nbsp;</td>
  </tr>
</table>
<table width="708" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="290"><div align="right"><bean:message bundle="execmap" key="generic.firstname" />:
         <html:text name="GroupAccountForm" property="groupManagerFirstName" maxlength="50" style="background-color: #FFFF66;"/>
    </div></td>
    <td width="408"><div align="right"><bean:message bundle="execmap" key="generic.lastname" />:
         <html:text name="GroupAccountForm" property="groupManagerLastName" maxlength="50" style="background-color: #FFFF66;"/>
    
    </div></td>
  </tr>
</table>
<table width="708" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="290"> <div align="right"><bean:message bundle="execmap" key="generic.pwd" />:
         <html:password name="GroupAccountForm" property="groupManagerPassword" maxlength="15" style="background-color: #FFFF66;"/>
    </div></td>
    <td width="408"><div align="right"><bean:message bundle="execmap" key="generic.retype_pwd" />:
          <html:password name="GroupAccountForm" property="groupManagerRetypePassword" maxlength="15" style="background-color: #FFFF66;"/>
    </div></td>
  </tr>
</table>
<table width="708" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><bean:message bundle="execmap" key="admineditcompany.frmcoacced.pwd.message" /></td>
  </tr>
</table>
<table width="708" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="289"><div align="right"><bean:message bundle="execmap" key="generic.email" />:
         <html:text name="GroupAccountForm" property="groupManagerEmail" maxlength="40" style="background-color: #FFFF66;"/>
    </div></td>
    <!-- chnage made here  25/09/06  -->

   <td width="100">
    <div align="left">
     <html:submit onclick="SendGroupManagementEmail();"><bean:message bundle="execmap" key="generic.sendEmail" /></html:submit>
    </div>
    </td>
<!-- chnage end here  25/09/06  -->
   <td width="309"><div align="right"><bean:message bundle="execmap" key="generic.userid" />:
         <html:text name="GroupAccountForm" property="groupManagerUserID" maxlength="15" readonly="true" style="background-color: #CCCCCC;"/>
    </div></td>
  </tr>
</table>
<table width="708" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="289"><p align="right"><bean:message bundle="execmap" key="adminaddcompany.remindphrase.label" />: 
        <html:text name="GroupAccountForm" property="groupManagerReminderPhrase" maxlength="50"/>
    </p></td>
    <td width="409">&nbsp;</td>
  </tr>
</table>
<table width="708" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><bean:message bundle="execmap" key="adminaddcompany.remindphraseexpl.label" /></td>
  </tr>
</table>
<table width="978" border="0" align="left" cellpadding="0" cellspacing="0" bgcolor="#009966">
  <tr>
    <td width="409" bgcolor="#023F70"><div align="left">
          <div align="center">
          <html:hidden property="enableScript" value=""/>
          <html:submit onclick= "enableJavaScript()"><bean:message bundle="execmap" key="generic.submit" /></html:submit>
             
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
<p>&nbsp;</p>

</html:form>