<%-- 
  - Author(s): Singhra
  - Date: 23rd Aug 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This jsp is used to select group for which assessment summary report
  - has to be displayed
 --%>
<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<p align="left">&nbsp;</p>
<table width="978" border="0" align="left" bordercolor="#FFFFFF" bgcolor="#023F70">
  <tr>
    <td width="797"><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
   </a>
   ><bean:message bundle="execmap" key="report.selection.assessment.summary" />
   </td>
   	<td>
   <div align="right" class="style1">
    <a href="javascript:callHelp();" class='style1'><bean:message bundle="execmap" key="generic.help"/> </a>
    </div>
   </td>
  </tr>
</table>
<p align="left">&nbsp;</p>

<html:form  action="/AssessmentSummaryMenu">
<html:hidden property="enableScript" value=""/>
<tiles:insert ignore="false" flush="true" page="/pages/reports/CompanyGroupContent.jsp" />

<script type="text/javascript">
     
   
     function aa()
     {
        document.forms[0].enableScript.value="Enabled";
        var grpId = document.forms[0].grpId.value;
     	var acctId = document.forms[0].acctId.value;
     	document.forms[0].action="/execmap/AssessmentSummaryReport.do?acctId="+acctId+"&grpId="+grpId;
     }
     
   </script>
 
<table width="978" border="0" bgcolor="#023F70">
  <tr>
    <td width="972"><div align="center">
        
       
<html:submit onclick="javascript:aa()">
  <bean:message bundle="execmap" key="general.submit.viewreport" />
 </html:submit>  
    
       
    </div></td>
  </tr>
</table>
<p>&nbsp;</p>
<p>&nbsp;</p> 
</html:form>
