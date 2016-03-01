<%-- 
  - Author(s): Zia Ahmed
  - Date: 23rd July 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This is the main page of execmap software.
  - This page is invoked from index.jsp as request
  - is made to the execmap domain.
  - TODO implement encoding, xhtml compliance
  --%>

<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<html:xhtml />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title><bean:message bundle="execmap" key="generic.execmap"/></title>
<meta name="robots" content="noindex">
<style type="text/css">
<!--
.style1 {color: #FFFFFF}
-->
</style>

<link rel="stylesheet" type="text/css"
	href=<%="css/execmap.css"%>> </link>
<html:base target="_self"/>

</head>
<script>
function resetValues() {
	document.forms[0].acctid.value="";
	document.forms[0].userid.value="";
	document.forms[0].password.value="";
	document.forms[0].newPassword.value="";
	document.forms[0].retypePassword.value="";
	}
function changePassword()
   {
    document.forms[0].enableScript.value="Enabled";
   }

</script>
<body bgcolor="#ffffff">


<html:form action="/UpdatePassword">


<tiles:insert ignore="false" flush="true" page="/pages/common/execmapheader.jsp" />
<table>
 <tr>
	<td align=left>&nbsp;</td>
      <td align=left>&nbsp;</td>
 </tr>
</table>
<table>
 <tr>
	<td align=left>&nbsp;</td>
      <td align=left>&nbsp;</td>
 </tr>
</table>
<tiles:insert ignore="false" flush="true" page="/pages/common/logoutoption.jsp" />
<table>
 <tr>
	<td align=left>&nbsp;</td>
      <td align=left>&nbsp;</td>
 </tr>
</table>
<table width="978" border="0">
  <tr>
    <td width="152" bordercolor="#FFFFFF"  bgcolor="#023F70"><span class="style1"><a href="/execmap" class="style1"><bean:message bundle="execmap" key="home.title" /></a>><bean:message bundle="execmap" key="changepassword.title" /></span></td>
    <td width="588" bgcolor="#023F70">&nbsp;</td>
  </tr>
</table>
<table>
 <tr>
	<td align=left>&nbsp;</td>
      <td align=left>&nbsp;</td>
 </tr>
</table>
 <FONT COLOR="#FF0000"><html:errors  bundle="execmap"/></font>
 <logic:messagesPresent message="true">
 <html:messages message="true" id="msg" bundle="execmap">
 <FONT COLOR="#FF0000"><bean:write name="msg" ignore="true"/></font>
 </html:messages>
 </logic:messagesPresent>
<table width="979" border="0">
  <tr>
    <td width="973"><DIV align=justify class="style8">
      <p><bean:message bundle="execmap" key="changepassword.msg" /></p>
        </DIV></td>
  </tr>
</table>
<p>&nbsp;</p>
<html:hidden name="LoginForm" property="enableScript"/>
<table width="750" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="262"> <div align="right" class="style16"><span class="style17"><bean:message bundle="execmap" key="label.login.accountid" /></span>:</div></td>
    <td width="488"><p>
        <html:text property="acctid" size="15" style="background-color: #FFFF66;"/> 
      </p></td>
  </tr>
</table>
<table width="750" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="263"> <div align="right" class="style17"><span class="style19"><bean:message bundle="execmap" key="generic.userid" /></span>:</div></td>
    <td width="487"><p>
        <html:text property="userid" size="15" style="background-color: #FFFF66;"/> 
      </p></td>
  </tr>
</table>
<table width="750" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="263"> <div align="right" class="style17"><bean:message bundle="execmap" key="label.login.oldpassword" />:</div></td><td width="487"><p>
        <html:password property="password" size="17"  style="background-color: #FFFF66;" />
      </p></td>
  </tr>
</table>
<table width="750" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="263"> <div align="right" class="style17"><bean:message bundle="execmap" key="label.login.newpassword" />:</div></td><td width="487"><p>
        <html:password property="newPassword" size="17"  style="background-color: #FFFF66;" />
      </p></td>
  </tr>
</table>
<table width="750" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="263"> <div align="right" class="style17"><bean:message bundle="execmap" key="label.login.retypenewpassword" />:</div></td><td width="487"><p>
        <html:password property="retypePassword" size="17"  style="background-color: #FFFF66;" />
      </p></td>
  </tr>
</table>
<p>&nbsp;</p>
<table width="978" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td bgcolor="#023F70">
      <div align="center">
        <html:submit onclick="changePassword();"><bean:message bundle="execmap" key="generic.submit" /></html:submit>
      </div>
	</td>
    <td bgcolor="#023F70">
      <div align="center">
        <html:submit onclick="javascript:resetValues();"  ><bean:message bundle="execmap" key="generic.reset" /></html:submit>
      </div>
    </td>
  </tr>
</table>
</html:form>


<tiles:insert ignore="false" flush="true" page="/pages/common/Loginfooter.jsp" />


</body>
</html>