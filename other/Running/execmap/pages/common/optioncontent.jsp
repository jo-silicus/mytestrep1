<%-- 
  - Author(s): Prasun 
  - Date: 10th sep 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This is the option page of execmap software.
  - This page is invoked from login.jsp.
  - 
  --%>
<%@ page language="java" %>
<%@ page import="com.perot.intellicue.common.util.webapp.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<html:xhtml />
<form>

<% 
	UserContext userContext= (UserContext)request.getSession(false).getAttribute("userContext");
	String roleId= userContext.getUserInfo().getActivityRoleID().toString().trim();
	String rptId = userContext.getUserInfo().getReportId().toString().trim();
	request.setAttribute("rptId", rptId);
	request.setAttribute("roleId",roleId); 
%>

<logic:equal name="roleId" value="1">
	<p>&nbsp;</p>
	<table width="978" border="0" align="left" bordercolor="CECE9C">
	
  <tr><td width="797" bordercolor="#FFFFFF" bgcolor="#023F70"><div align="left" class="style1"><bean:message bundle="execmap" key="generic.execmap.administrator"/></td></tr></table>
	<p>&nbsp;</p>
	<table width="978" border="0" align="left" bordercolor="CECE9C">
	
  <tr><td width="797" bordercolor="#FFFFFF" bgcolor="#023F70"><div align="left" class="style1"><bean:message bundle="execmap" key="adminoptions.options"/></td></tr></table>
  <p>&nbsp;</p>
	<tiles:insert ignore="false" flush="true" definition="tile.intellicue.GlobalSettings"></tiles:insert>
    <tiles:insert ignore="false" flush="true" definition="tile.execmap.AddCobrand"></tiles:insert>  
    <tiles:insert ignore="false" flush="true" definition="tile.intellicue.AccountManagement"></tiles:insert> 
    <tiles:insert ignore="false" flush="true" definition="tile.intellicue.loginmanagement"></tiles:insert> 
	<tiles:insert ignore="false" flush="true" definition="tile.intellicue.UploadFile"></tiles:insert>
	<tiles:insert ignore="false" flush="true" definition="tile.intellicue.GeneralReports"></tiles:insert>
	<tiles:insert ignore="false" flush="true" definition="tile.intellicue.Reports"></tiles:insert>
	<tiles:insert ignore="false" flush="true" definition="tile.intellicue.Help" ></tiles:insert>
</logic:equal>

<logic:equal name="roleId"  value="2">
	<p>&nbsp;</p>
	<table width="978" border="0" align="left" bordercolor="CECE9C">
  <tr><td width="797" bordercolor="#FFFFFF" bgcolor="#023F70"><div align="left" class="style1"><bean:message bundle="execmap" key="generic.company.manager"/></td></tr></table>
	<p>&nbsp;</p>
	<table width="978" border="0" align="left" bordercolor="CECE9C">
	
  <tr><td width="797" bordercolor="#FFFFFF" bgcolor="#023F70"><div align="left" class="style1"><bean:message bundle="execmap" key="adminoptions.options"/></td></tr></table>
  <p>&nbsp;</p>
	<tiles:insert ignore="false" flush="true" definition="tile.intellicue.AccountManagement"></tiles:insert>
	<tiles:insert ignore="false" flush="true" definition="tile.intellicue.loginmanagement"></tiles:insert>
	<tiles:insert ignore="false" flush="true" definition="tile.intellicue.UploadFile" ></tiles:insert>
	<tiles:insert ignore="false" flush="true" definition="tile.intellicue.GeneralReports.Company.Group.Manager" ></tiles:insert>
	<tiles:insert ignore="false" flush="true" definition="tile.intellicue.Reports.Company.Group.Manager" ></tiles:insert>
	<tiles:insert ignore="false" flush="true" definition="tile.intellicue.Help" ></tiles:insert>
</logic:equal>

<logic:equal name="roleId"  value="3">
	<p>&nbsp;</p>
	<table width="978" border="0" align="left" bordercolor="CECE9C">
  <tr><td width="797" bordercolor="#FFFFFF" bgcolor="#023F70"><div align="left" class="style1"><bean:message bundle="execmap" key="generic.Group_Manager"/></td></tr></table>
	<p>&nbsp;</p>
	<table width="978" border="0" align="left" bordercolor="CECE9C">
	
  <tr><td width="797" bordercolor="#FFFFFF" bgcolor="#023F70"><div align="left" class="style1"><bean:message bundle="execmap" key="adminoptions.options"/></td></tr></table>
  <p>&nbsp;</p>
	<tiles:insert ignore="false" flush="true" definition="tile.intellicue.GroupManagement" ></tiles:insert>
	<tiles:insert ignore="false" flush="true" definition="tile.intellicue.loginmanagement"></tiles:insert>
	<tiles:insert ignore="false" flush="true" definition="tile.intellicue.GeneralReports.Company.Group.Manager" ></tiles:insert>
	<tiles:insert ignore="false" flush="true" definition="tile.intellicue.Reports.Company.Group.Manager" ></tiles:insert>
	<tiles:insert ignore="false" flush="true" definition="tile.intellicue.Help" ></tiles:insert>
</logic:equal>
<logic:equal name="roleId"  value="5">
<p>&nbsp;</p>
<table width="978" border="0" align="left" bordercolor="CECE9C">
  <tr><td width="797" bordercolor="#FFFFFF" bgcolor="#023F70"><div align="left" class="style1"><bean:message bundle="execmap" key="generic.company.user"/></td></tr></table>
<p>&nbsp;</p>
<table width="978" border="0" align="left" bordercolor="CECE9C">
	
  <tr><td width="797" bordercolor="#FFFFFF" bgcolor="#023F70"><div align="left" class="style1"><bean:message bundle="execmap" key="adminoptions.options"/></td></tr></table>
  <p>&nbsp;</p>
<tiles:insert ignore="false" flush="true" definition="tile.intellicue.ChangeProfile" ></tiles:insert>
<tiles:insert ignore="false" flush="true" definition="tile.intellicue.StartAssessment" ></tiles:insert>
<tiles:insert ignore="false" flush="true" definition="tile.intellicue.Help" ></tiles:insert>


</logic:equal>
</form>
