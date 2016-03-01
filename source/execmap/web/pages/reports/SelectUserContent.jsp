<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<html:form action="/SelectUserAction">

<bean:define id="compList" name="SelectUserForm" property="compList"/>
<bean:define id="grpList" name="SelectUserForm" property="grpList"/>
<bean:define id="usrList" name="SelectUserForm" property="usrList"/>
<script type="text/javascript">
   function cc()
   {
    document.forms[0].submit();
   }
   function a()
   {
   document.forms[0].action="/execmap/GeneralReports.do?acctId=<bean:write name="SelectUserForm" property="acctId" />&usrId=<bean:write name="SelectUserForm" property="usrId" />&rptId=64";
   }
   </script>
<p>&nbsp;</p>
<table width="750" border="0">
  <tr>
    <td width="265"><div align="right">Please select the company of the user:</div></td>
    <td width="475"><html:select name="SelectUserForm" property="acctId" onchange="javascript:cc()">
			<html:options collection="compList" property="value" labelProperty="key" /> 
	</html:select>
    </td>
  </tr>
</table>
<table width="750" border="0">
  <tr>
    <td width="267"><div align="right">Please select the group of the user:</div></td>
    <td width="473" valign="top"><html:select name="SelectUserForm" property="grpId" onchange="javascript:cc()">
			<html:options collection="grpList" property="grp_id"/> 
	</html:select>
  </tr>
</table>
<p>&nbsp;</p>
<table width="750" border="0">
  <tr>
    <td width="267"><div align="right">Please select the group of the user:</div></td>
    <td width="473" valign="top"><html:select name="SelectUserForm" property="usrId" onchange="javascript:cc()">
			<html:options collection="usrList" property="key" labelProperty="value" /> 
	</html:select>
  </tr>
</table>
<p>&nbsp;</p>

<table width="978" border="0" bgcolor="#023F70">
  <tr>
    <td width="972"><div align="center">
        
          <html:submit property="Button"  value="View Report" onclick="javascript:a();"/>
       
    </div></td>
  </tr>
</table>
<p>&nbsp;</p>
<p>&nbsp;</p>
</html:form>
