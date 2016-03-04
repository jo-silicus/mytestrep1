<%-- 
  - Author(s): Singhra
  - Date: 13th Aug 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This jsp is used as a tile in different jsps' to select group for which report has to be displayed
 --%>

<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>



<bean:define id="compList" name="SelectGroupForm" property="compList"/>
<bean:define id="grpList" name="SelectGroupForm" property="grpList"/>
<script type="text/javascript">
   function cc()
   {
    document.forms[0].enableScript.value="Enabled";
    document.forms[0].submit();
   }
  
   </script>
<p>&nbsp;</p>
<table width="750" border="0">
  <tr>
  <logic:notEmpty name="SelectGroupForm" property="compList"> 
    <td width="265"><div align="right"><bean:message bundle="execmap" key="general.reports.select.company" /></div></td>
    <td width="475"><html:select name="SelectGroupForm" property="acctId" onchange="javascript:cc()">
			<html:options collection="compList" property="value" labelProperty="key" /> 
	</html:select>
    </td>
   </logic:notEmpty>
  </tr>
</table>
<table width="750" border="0">
  <tr>
    <td width="267"><div align="right"><bean:message bundle="execmap" key="general.reports.select.group" /></div></td>
    <td width="473" valign="top"><html:select name="SelectGroupForm" property="grpId" onchange="javascript:cc()">
			<html:options name="grpList" /> 
	</html:select>
  </tr>
</table>
<p>&nbsp;</p>

