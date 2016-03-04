<%-- 
  - Author(s): Rahul 
  - Date: 11th July 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: 
  - This page is  the  content page related to error 
  - message if a  user disables JavaScript.
  --%>
<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<html> 
<head>
</head>
<body>
<div align="center">
 <FONT COLOR="#FF0000"><html:errors bundle="execmap"/></font>
<logic:messagesPresent message="true">

<html:messages message="true" id="msg" bundle="execmap">
<FONT COLOR="#FF0000"><bean:write name="msg" ignore="true"/><br></font>
</html:messages>
</logic:messagesPresent>
</div>
<p>&nbsp;</p>
<div align="center">
  <a href="/execmap"><bean:message bundle="execmap" key="generic.clk_continue"/></a>
</div>
</body>
</html>
