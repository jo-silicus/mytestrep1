<%-- 
  - Author(s): Singhra
  - Date: 13th Aug 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This jsp is used to display all the enabled or disabled companies to the global manager
 --%>
<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<p align="left">&nbsp;</p>

<logic:equal name="EnableCompaniesListForm" property="status" value="E">
 <table width="978" border="0" align="left" bordercolor="#FFFFFF" bgcolor="#023F70">
  <tr>
    <td width="797"><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
   </a>
   ><bean:message bundle="execmap" key="generic.textMesgForEnComp" /> 
   </td>
   <td>
   <div align="right" class="style1">
    <a href="javascript:callHelp();" class='style1'><bean:message bundle="execmap" key="generic.help"/> </a>
    </div>
   </td>
  </tr>
 </table>
</logic:equal>
<logic:equal name="EnableCompaniesListForm" property="status" value="D">
 <table width="978" border="0" align="left" bordercolor="#FFFFFF" bgcolor="#023F70">
  <tr>
    <td width="797"><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
   </a>
   ><bean:message bundle="execmap" key="adminoptions.disabledcomplist" /> 
   </td>
   <td>
   <div align="right" class="style1">
    <a href="javascript:callHelp();" class='style1'><bean:message bundle="execmap" key="generic.help"/> </a>
    </div>
   </td>
  </tr>
 </table>
</logic:equal>
<p align="left">&nbsp;</p>

<html:form action="/EnableCompaniesReport.do">
<logic:messagesPresent message="true">
<html:messages message="true" id="msg" bundle="execmap">
<FONT COLOR="#FF0000"><bean:write name="msg" ignore="true"/><br></font>
</html:messages>
</logic:messagesPresent>

<script>
var path = '/execmap/html/reports/';
function excel() {

	open(path+"EnabledDisabled.xls",null,'height=800,width=1024,target="_self",toolbar=no,directories=no,status=yes, menubar=yes,scrollbars=yes,resizable=yes,left=0,top=0');
	}
</script>
<table width="978"><tr><td align="right"><html:link href="javascript:excel();"> <img src="/execmap/images/main/excel.GIF"><bean:message bundle="execmap" key="view.in.msexcel" /></html:link></td></tr></table>


<table width="978" border="1" bordercolor="#003366">			
 <tr bgcolor="#006699">
  <td width="15%" height="21" bgcolor="#023F70" align="center"><span class="style1">
    <bean:message bundle="execmap" key="generic.account" /></span>
  </td>
  <td width="15%" height="21" bgcolor="#023F70" align="center"><span class="style1">
    <bean:message bundle="execmap" key="generic.company" /></span>
  </td>
  <td width="15%" height="21" bgcolor="#023F70" align="center"><span class="style1">
    <bean:message bundle="execmap" key="generic.supname" /></span>
  </td>
  <td width="20%" height="21" bgcolor="#023F70" align="center"><span class="style1">
   <bean:message bundle="execmap" key="generic.email" /></span>
  </td>
  <td width="10%" height="21" bgcolor="#023F70" align="center"><span class="style1">
   Total User Accounts</span>
  </td>
 </tr>
			
 <logic:iterate id="companyinfo" name="EnableCompaniesListForm" property="enableCompanies">
  <tr>
   <td align=center height=21 width="15%">
  
     <bean:write name="companyinfo" property="acct_id"/>

   </td>
   <td align=center height=21 width="15%">
   
     <bean:write name="companyinfo" property="co_name"/>
   
   </td>
   <td align=center height=21 width="20%">
   
     <bean:write name="companyinfo" property="usr_id"/>
    
   </td>
   <td align=center height=21 width="20%">
  
    <a href="mailto:<bean:write name="companyinfo" property="co_email"/>">
    <bean:write name="companyinfo" property="co_email"/></a>
    
   </td>
   <td align=center height=21 width="20%">
  
     <bean:write name="companyinfo" property="User Accounts"/>
  
   </td>
  </tr>
 </logic:iterate>
</table>
</html:form>
