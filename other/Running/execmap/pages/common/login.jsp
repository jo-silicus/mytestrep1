<%-- 
  - Author(s): 
  - Date: 11th July 2006
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
<tiles:insert  page="/pages/common/execmapheader.jsp" />
<script>
function changeLanguage()
{
	
	location.href="/execmap/changelanguage.do?";

}
</script>

<html:html>
<head>
<title><bean:message bundle="execmap" key="generic.execmap"/></title>
<link rel="stylesheet" type="text/css"
	href=<%="css/execmap.css"%>></link>
<html:base target="_self"/>
</head>
<body bgcolor="white">

<html:form action="/changelanguage">

<font color="#FF0000"><html:errors/></font>  
<table>
 <tr>
	<td align=left>&nbsp;</td>
      <td align=left>&nbsp;</td>
 </tr>
</table>



<table width="750" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="268"><span class="style16"><bean:message bundle="execmap" key="index.selectlang.text" />
    </span></td>
    <td width="482"><span class="style16">
      <html:select property="language" onchange="javascript:changeLanguage()">
      <bean:define id="languages" name="LanguagesForm" property="languages"/>
		        <html:options collection="languages" property="value" labelProperty="key"/>
	</html:select>
    </span></td>
  </tr>
</table>
<table>
 <tr>
	<td align=left>&nbsp;</td>
      <td align=left>&nbsp;</td>
 </tr>
</table>
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
        <html:text property="acctid" size="10" style="background-color: #FFFF66;"/> 
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
    </form></td>
    <td bgcolor="#023F70">
      <div align="center">
        <html:reset><bean:message bundle="execmap" key="generic.reset" /></html:reset>
      </div>
    </form></td>
  </tr>
</table>
<blockquote>
  <blockquote>
    <blockquote>
      <blockquote>
        <blockquote>
          <blockquote>
            <blockquote>
              <blockquote>
                <pre>                                                      <a href="ChangePassword.do" >Change Password?</a>  
				<a href="ForgetPassword.do"><bean:message bundle="execmap" key="index.forgotpwd" /></a> 

                                                                                                                            </pre>
              </blockquote>
            </blockquote>
          </blockquote>
        </blockquote>
      </blockquote>
    </blockquote>
  </blockquote>
</blockquote>

</html:form>
</body>
</html:html>
 <tiles:insert page="/pages/common/Loginfooter.jsp" /> 