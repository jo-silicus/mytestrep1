<%-- 
  - author(s): Ashim Das
  - date: 11th July 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This is the content tile of loginlayout for login page
  - @see loginlayout.jsp, WEB-INF\tiles-defs.xml
  -
  --%>

<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<script>

function  changeLanguage()
{
 document.forms[0].action="/execmap/changelanguage.do";
 document.forms[0].submit();
}
</script>

 <bean:define id="languagesFound" name="LoginForm" property="languages"/>
 <bean:define id="Selectedlanguage" name="LoginForm" property="selectedLanguage"/>
  
<html:form action="/login">
<FONT COLOR="#FF0000"><html:errors bundle="execmap"/></font>
<logic:messagesPresent message="true">

<html:messages message="true" id="msg" bundle="execmap">

<FONT COLOR="#FF0000"><bean:write name="msg" ignore="true"/><br></font>

</html:messages>
</logic:messagesPresent>

<html:hidden name="LoginForm" property="enableScript"/>

 <table width="750" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="268"><span class="style16"><bean:message bundle="execmap" key="index.selectlang.text" />
    </span></td>
    <td width="482"><span class="style16">
    <html:select name="LoginForm" property="selectedLanguage" onchange="changeLanguage()" value='<%=(String)Selectedlanguage%>'>
     <html:options collection="languagesFound" property="value" labelProperty="key"/>
	</html:select>
    </span></td>
  </tr>
</table>
<table>
<table width="978" border="0">
  <tr>
    <td width="152" bgcolor="#023F70"><span class="style1"><bean:message bundle="execmap" key="index.logininfo" /></span></td>
    <td width="588" bgcolor="#023F70">&nbsp;</td>
  </tr>
</table>
<p>&nbsp;</p>
<table width="750" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="262"> <div align="right" class="style16"><span class="style17"><bean:message bundle="execmap" key="reportframe.adminreportpanel.jlabel.acctid" /></span>:</div></td>
    <td width="488"><p>
        <html:text property="acctid" maxlength="10" size="10" style="background-color: #FFFF66;"/> 
      </p></td>
  </tr>
</table>
<table width="750" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="263"> <div align="right" class="style17"><span class="style19"><bean:message bundle="execmap" key="generic.userid" /></span>:</div></td>
    <td width="487"><p>
        <html:text property="userid" size="10" style="background-color: #FFFF66;"/> 
      </p></td>
  </tr>
</table>
<table width="750" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="263"> <div align="right" class="style17"><bean:message bundle="execmap" key="generic.pwd" />:</div></td><td width="487"><p>
        <html:password property="password" size="10"  style="background-color: #FFFF66;" />
      </p></td>
  </tr>
</table>
<p>&nbsp;</p>
<table width="978" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td bgcolor="#023F70">
      <div align="center">
        <html:submit onclick="javascript:admin();"><bean:message bundle="execmap" key="generic.submit" /></html:submit>
      </div>
   </td>
    <td bgcolor="#023F70">
      <div align="center">
        <html:reset><bean:message bundle="execmap" key="generic.reset" /></html:reset>
      </div>
    </td>
  </tr>
</table>

<table width="750" border="0" cellpadding="0" cellspacing="0">
   <td width="800" align="right"> <a href="ChangePassword.do" >Change Password</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
   &nbsp;&nbsp;&nbsp;
				<a href="ForgetPassword.do"><bean:message bundle="execmap" key="index.forgotpwd" />?</a>	
   </td>

</table>

</html:form>