<%-- 
  - Author(s): Singhra
  - Date: 13th Aug 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This jsp is used as a tile in different jsps' to select user for which report has to be displayed
 --%>
<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<%
response.setHeader( "Expires", "-1" );
response.setHeader( "Cache-Control", "no-store, no-cache, must-revalidate" );
response.addHeader( "Cache-Control", "post-check=0, pre-check=0" );
response.setHeader( "Pragma", "no-cache" );
%>

<bean:define id="compList" name="SelectUserForm" property="compList"/>
<bean:define id="grpList" name="SelectUserForm" property="grpList"/>
<bean:define id="usrList" name="SelectUserForm" property="usrList"/>
<script type="text/javascript">
   function c()
   {
    document.forms[0].enableScript.value="Enabled";
   	document.forms[0].grpId.value="";
    document.forms[0].submit();
   }
   function cc()
   {
    document.forms[0].enableScript.value="Enabled";
    document.forms[0].submit();
   }
   
   </script>
   <p>&nbsp;</p>
  
<table>
	<logic:equal name="SelectUserForm" property="usrListFlag" value="false" >
   		<tr>
			<td width="900" align="center">
				<FONT COLOR="#FF0000"><bean:message bundle="execmap" key="userreportcordinator.emcreport.nouser" /></font>
			</td>
		</tr>
	</logic:equal>
</table>

<table width="750" border="0">
<logic:equal name="SelectUserForm" property="compDropDown" value="true">
  <tr>
    <td width="265"><div align="right"><bean:message bundle="execmap" key="general.reports.select.company" /></div></td>
    <td width="475"><html:select name="SelectUserForm" property="acctId" onchange="javascript:c()">
    				
			<html:options collection="compList" property="key" labelProperty="value" /> 
	</html:select>
    </td>
  </tr>
</logic:equal>
<logic:equal name="SelectUserForm" property="grpDropDown" value="true">
  <tr>
    <td width="267"><div align="right"><bean:message bundle="execmap" key="general.reports.select.group" /></div></td>
    <td width="473" valign="top"><html:select name="SelectUserForm" property="grpId" onchange="javascript:cc()">
    
			<html:options name="grpList" /> 
	</html:select>
  </tr>
</logic:equal>
  <logic:equal name="SelectUserForm" property="usrListFlag" value="true" >
   		<tr>
		    <td width="267"><div align="right"><bean:message bundle="execmap" key="general.reports.select.user" /></div></td>
		    <td width="473" valign="top">
		    	<html:select name="SelectUserForm" property="usrId" onchange="javascript:cc()">
    				<html:options collection="usrList" property="key" labelProperty="value" /> 
				</html:select>
			</td>
		</tr>
  </logic:equal>
 
</table>
<p>&nbsp;</p>