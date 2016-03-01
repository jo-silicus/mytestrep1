<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<html:form action="/AssessSummRepSelectGrp">

<bean:define id="compList" name="SelectGroupForm" property="compList"/>
<bean:define id="grpList" name="SelectGroupForm" property="grpList"/>
<script type="text/javascript">
   function cc()
   {
    document.forms[0].submit();
   }
   </script>
<p>&nbsp;</p>
<table width="750" border="0">
  <tr>
    <td width="265"><div align="right">Please select the company of the user:</div></td>
    <td width="475"><html:select name="SelectGroupForm" property="acctId" onchange="javascript:cc()">
			<html:options collection="compList" property="value" labelProperty="key" /> 
	</html:select>
    </td>
  </tr>
</table>
<table width="750" border="0">
  <tr>
    <td width="267"><div align="right">Please select the group of the user:</div></td>
    <td width="473" valign="top"><html:select name="SelectGroupForm" property="grpId" onchange="javascript:cc()">
			<html:options collection="grpList" property="grp_id"/> 
	</html:select>
  </tr>
</table>
<p>&nbsp;</p>
<table width="978" border="0" bgcolor="#023F70">
  <tr>
    <td width="972"><div align="center">
        <form name="form3" method="link" action="AssessmentSummaryReport.do?acctId=<bean:write name="SelectGroupForm" property="acctId" />&grpId=<bean:write name="SelectGroupForm" property="grpId" />">
          <input name="Button" type="submit" id="Button" value="View Report">
        </form>
    </div></td>
  </tr>
</table>
<p>&nbsp;</p>
<p>&nbsp;</p>
</html:form>
