<%-- 
  - Author(s): AhmedZia
  - Date: 
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This is the main page of execmap software.
  - This page is invoked from add company as request
  - is made to the execmap domain.
  - TODO implement encoding, xhtml compliance
  --%>

<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>


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
function showValue(obj)
{   
	

  opener.document.forms[0].companyCoBrandInfo.value=obj.value;
  self.close();  
}

 </script>
</head>
<body bgcolor="#ffffff">

<html:form action="/companyaccount">
<html:hidden property="enableScript" value=""/>
<logic:iterate id="DisplayImages"  name="CompanyAccountForm" property="imagesList" >
<bean:define id="images" name="DisplayImages" />
<html:radio  property="radioValue" onclick="showValue(this);" value='<%=(String)images%>'/>
<img height="60"  src="<%=request.getContextPath()%>/images/cobrand/<bean:write name="DisplayImages" />" alt="<bean:write name="DisplayImages" />" width="400" border="0"/>
<bean:write name="DisplayImages" />

<br>
</logic:iterate>
</html:form>
</body>
</html>