<%-- 
  - Author(s): Singhra
  - Date: 13th Aug 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This jsp is used to select user whose report has to be displayed
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
   ><bean:message bundle="execmap" key="report.selection.execmap.leadershipA" />
   </td>
   <td>
   <div align="right" class="style1">
    <a href="javascript:callHelp();" class='style1'><bean:message bundle="execmap" key="generic.help"/> </a>
    </div>
   </td>
  </tr>
</table>
<p align="left">&nbsp;</p>

<html:form  action="/LeadershipAMenu.do?rptId=2">
<html:hidden property="enableScript" value=""/>
<tiles:insert ignore="false" flush="true" page="/pages/reports/CompanyGroupUserContent.jsp" />
<bean:define id="accountId" name="SelectUserForm" property="acctId"/>
 <script type="text/javascript">
     function a()
     {
        var usrId = document.forms[0].usrId.value;
        document.forms[0].enableScript.value="Enabled";
     	var acctId = document.forms[0].acctId.value;
        document.forms[0].action="/execmap/GeneralReports.do?acctId="+acctId+"&usrId="+usrId+"&rptId=2";
     }
     function aa()
     {
     	var usrId = document.forms[0].usrId.value;
        document.forms[0].enableScript.value="Enabled";
     	var acctId = <%=accountId%>;
     	document.forms[0].action="/execmap/GeneralReports.do?acctId="+acctId+"&usrId="+usrId+"&rptId=2";
     }
     
   </script>
<logic:equal name="SelectUserForm" property="usrListFlag" value="true" >
<table width="978" border="0" bgcolor="#023F70">
  <tr>
    <td width="972"><div align="center">
<logic:equal name="SelectUserForm" property="compDropDown" value="true" >    
<html:submit onclick="javascript:a()">
  <bean:message bundle="execmap" key="general.submit.viewreport" />
 </html:submit>  
</logic:equal>  
<logic:equal name="SelectUserForm" property="compDropDown" value="false" >    
<html:submit onclick="javascript:aa()">
  <bean:message bundle="execmap" key="general.submit.viewreport" />
 </html:submit>  
</logic:equal>    
    </div></td>
  </tr>
</table>
</logic:equal>   

<p>&nbsp;</p>
<p>&nbsp;</p> 
</html:form>