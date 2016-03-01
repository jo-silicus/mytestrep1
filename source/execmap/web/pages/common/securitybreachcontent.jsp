<%-- 
  - Author(s): Singhra
  - Date: 10th sep 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This is used to display security breach message to the user of execmap software.
  - This page is invoked from login.jsp.
  - 
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
 <FONT COLOR="#FF0000"><bean:message bundle="execmap" key="security.breach.message"/></font>
</div>
<p>&nbsp;</p>
<div align="center">
 <bean:message bundle="execmap" key="security.breach.invalidated"/>
 <a href="/execmap"><bean:message bundle="execmap" key="generic.clk_continue"/></a>
</div>
</body>
</html>
