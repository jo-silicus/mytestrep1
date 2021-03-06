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
<html:xhtml />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title><bean:message bundle="execmap" key="generic.execmap"/></title>
<meta name="robots" content="noindex">
<style type="text/css">
</style>

<link rel="stylesheet" type="text/css"
	href=<%="css/execmap.css"%>> </link>
<html:base target="_self"/>
</head>
<body bgcolor="#ffffff">

<tiles:insert ignore="false" flush="true" page="/pages/common/Loginheader.jsp" />
<table>
 <tr>
	<td align=left>&nbsp;</td>
      <td align=left>&nbsp;</td>
 </tr>
</table>

<tiles:insert ignore="false" flush="true" page="/pages/common/Loginstubcontent.jsp" />

<tiles:insert ignore="false" flush="true" page="/pages/common/Loginfooter.jsp" />


</body>
</html>
