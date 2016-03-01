<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<script>
function showLogin()
{
	location.href="/execmap/changelanguage.do";
}

</script>
<head>
</head>
  <tiles:insert page="/pages/common/execmapheader.jsp" />

<BODY onLoad="showLogin()">
<table width="978" border="0" cellpadding="0" cellspacing="0">
  <tr>
  &nbsp;
  </tr>
  <tr>
  <td><div align="center">
 <FONT COLOR="#FF0000"><bean:message bundle="execmap" key="verify.enableJavaScript" /><br></font>
 </div>
 </td>
 </tr>
 </table>

</BODY>
 <tiles:insert page="/pages/common/Loginfooter.jsp" /> 

