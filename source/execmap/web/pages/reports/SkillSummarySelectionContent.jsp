<%-- 
  - Author(s): Singhra
  - Date: 17th Aug 2006
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
<table width="978" border="0" align="left" bordercolor="CECE9C">
  <tr>
    <td width="797" bordercolor="#FFFFFF" bgcolor="#023F70"><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
   </a>
   ><bean:message bundle="execmap" key="report.selection.skill.summary" />
   </td>
  </tr>
</table>
<p>&nbsp;</p><br/>

<html:form  action="/SkillSummaryMenu">
<html:hidden property="enableScript" value=""/>
<tiles:insert ignore="false" flush="true" page="/pages/reports/CompanyGroupContent.jsp" /> 
<bean:define id="accountId" name="SelectGroupForm" property="acctId"/>
<p>&nbsp;</p>  
 
   <script type="text/javascript">
    
     function a()
     {
	   	var grpId = document.forms[0].grpId.value;
        document.forms[0].enableScript.value="Enabled";
     	var acctId = document.forms[0].acctId.value;
        document.forms[0].action="/execmap/SkillSelection.do?acctId="+acctId+"&grpId="+grpId;
     }
     function aa()
     {
     	var grpId = document.forms[0].grpId.value;
        document.forms[0].enableScript.value="Enabled";
     	var acctId = <%=accountId%>;
     	document.forms[0].action="/execmap/SkillSelection.do?acctId="+acctId+"&grpId="+grpId;
     }
     
   </script>
<table width="978" border="0" bgcolor="#023F70">
  <tr>
    <td width="972"><div align="center">
 
 <logic:equal name="SelectGroupForm" property="compDropDown" value="true" >    
<html:submit onclick="javascript:a()">
  <bean:message bundle="execmap" key="general.submit.viewreport" />
 </html:submit>  
</logic:equal>  

<logic:equal name="SelectGroupForm" property="compDropDown" value="false" >    
<html:submit onclick="javascript:aa()">
  <bean:message bundle="execmap" key="general.submit.viewreport" />
 </html:submit>  
</logic:equal>        

       
    </div></td>
  </tr>
</table>
<p>&nbsp;</p>
<p>&nbsp;</p> 
</html:form>