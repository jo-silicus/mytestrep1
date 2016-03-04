<%-- 
  - Author(s): Ashim Das
  - Date: 11th July 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This is the main page of execmap software.
  - This page is the layout for login page
  -
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
<title><bean:message bundle="execmap" key="generic.execmap"/></title>
<style type="text/css">
<!--
.style1 {color: #FFFFFF}
-->
.style4 {color: #FF0000; font-weight: bold; font-size: 24px; }
</style>

<link rel="stylesheet" type="text/css"
	href=<%="css/execmap.css"%>> </link>
<html:base target="_self"/>

<script type="text/javascript">
 function callHelp()
     {
    
     var url_add="<%=request.getContextPath()%>/help.do";
     window.open(url_add);
     }
</script>     

</head>
<body bgcolor="#ffffff">


<tiles:insert attribute="header"/>
<p>&nbsp;</p>
<tiles:insert attribute="subheader"/>
<tiles:insert attribute="whereami">
</tiles:insert> 
<tiles:insert attribute="content"/>
<tiles:insert attribute="loginfooter"/>

</body>
</html>