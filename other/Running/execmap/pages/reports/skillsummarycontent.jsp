<%-- 
  - Author(s): Singhra
  - Date: 17th Aug 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This jsp is used to display skill summary report.
 --%>
<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<html:form action="/SkillSummaryReport.do">
  <bean:define id="skillSummaryReportModel" name="SkillSummaryForm" property="skillSummaryReportModel" type="com.perot.intellicue.business.model.SkillSummaryReportModel"/>
  <p align="left">&nbsp;</p>
  <table width="978" border="0" align="left" bordercolor="#FFFFFF" bgcolor="#023F70">
  <tr>
    <td width="797"><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
   </a>
   ><a href='/execmap/SkillSummaryMenu.do' class='style1'>
    <bean:message bundle="execmap" key="report.selection.skill.summary" />
   </a>
   ><a href='/execmap/SkillSelection.do?acctId=<%=skillSummaryReportModel.getAcctID()%>&grpId=<%=skillSummaryReportModel.getGroupID()%>' class='style1'>
    <bean:message bundle="execmap" key="admingroupreport.form.tabletitle" />
   </a>
   ><bean:message bundle="execmap" key="adminoptions.skill_summary_report" />
   </td>
   <td>
   <div align="right" class="style1">
    <a href="javascript:callHelp();" class='style1'><bean:message bundle="execmap" key="generic.help"/> </a>
    </div>
   </td>
  </tr>
</table>
<p align="left">&nbsp;</p>

<script>
var path = '/execmap/html/reports/'+'<%=skillSummaryReportModel.getAcctID()%>'+'<%=skillSummaryReportModel.getGroupID()%>';
function excel() {

	open(path+"SkillSummaryReport.xls",null,'height=800,width=1024,target="_self",toolbar=no,directories=no,status=yes, menubar=yes,scrollbars=yes,resizable=yes,left=0,top=0');
	}
</script>

<table width="978" border="0">	<tr><td  align="right">    <html:link href="javascript:excel();"><img src="/execmap/images/main/excel.GIF">
<bean:message bundle="execmap" key="view.in.msexcel" /></html:link></td></tr></table>
    <table width="978" border="0" height="43" cellspacing="1" cellpadding="0">
  <tr>
   <td width="50%" height="19" bgcolor="#023F70"><span class="style2"><font color="#FFFFFF">
     <bean:message bundle="execmap" key="generic.supervisor" /></font></span>	
   </td>
   <td width="50%" height="19" bgcolor="#023F70"><span class="style2"><font color="#FFFFFF">
     <bean:write name="skillSummaryReportModel" property="companymanager" /></font></span>
   </td>
  </tr>
  <tr>
   <td width="50%" height="19" bgcolor="#023F70"><span class="style2"><font color="#FFFFFF">
	 <bean:message bundle="execmap" key="generic.coordinator" /></font></span>
   </td>
   <td width="50%" height="19" bgcolor="#023F70"><span class="style2"><font color="#FFFFFF">
    <bean:write name="skillSummaryReportModel" property="groupID" /></font></span>
   </td>
  </tr>
  <tr>
   <td width="50%" height="1" bgcolor="#023F70"><span class="style2"><font color="#FFFFFF">
	<bean:message bundle="execmap" key="userreportcordinator.group.title" /></font></span>
   </td>
   <td width="50%" height="1" bgcolor="#023F70"><span class="style2"><font color="#FFFFFF">
     <bean:write name="skillSummaryReportModel" property="groupmanager" /></font></span>
   </td>
   </tr>
  </table>
  <p>
   <br>
  </p>
  
  <table border="1" width="352" height="<%=(skillSummaryReportModel.getRows()+1)*21 %>">
  
  <%
     int colsCnt = skillSummaryReportModel.getCols();
     int skillId=0;
  %>
   <tr>
    <td width="100%" align="center" colspan="<%=colsCnt+2%>" bgcolor="#023F70" height="21">
	 <span class="style2"><font color="#FFFFFF">
	  <bean:message bundle="execmap" key="summary.skill" /> &nbsp;
	  <bean:message bundle="execmap" key="summary.score" /> &nbsp;
	  <bean:message bundle="execmap" key="summary.sum" />
	 </span></font>
	</td>
   </tr>
   <tr>
    <td width="10%" height="21" bgcolor="#023F70">
	 <span class="style2"><font color="#FFFFFF"><strong>
	   <bean:message bundle="execmap" key="generic.id" />
	 </strong></span></font>
	</td>
	<td width="30%" height="21" bgcolor="#023F70">
	 <a href ="/execmap/SkillSummaryReport.do?sort=name&skills=<bean:write name="SkillSummaryForm" property="url"/>&acctId=<bean:write name="SkillSummaryForm" property="acctId"/>&grpId=<bean:write name="SkillSummaryForm" property="grpId"/>">
	  <span class="style2"><font color="#FFFFFF">
		<bean:message bundle="execmap" key="summary.testee" />
	  </span></font>
	 </a>
	</td>	
    <logic:iterate id="skillShort" name="SkillSummaryForm" property="skillSummaryReportModel.skillShort">
		<td height="21" align="center" bgcolor="#023F70">
     <a href="/execmap/SkillSummaryReport.do?sort=<%=skillId++%>&skills=<bean:write name="SkillSummaryForm" property="url"/>&acctId=<bean:write name="SkillSummaryForm" property="acctId"/>&grpId=<bean:write name="SkillSummaryForm" property="grpId"/>">
       <span class="style2"><font color="#FFFFFF">
		  <bean:write name="skillShort"/>
		  </span></font>
	 </a>
	   </td>
	</logic:iterate>
	
	</tr>
   <logic:iterate id="result" name="SkillSummaryForm" property="skillSummaryReportModel.result">
	<tr>
	  <td height="21" bgcolor="#023F70">
		<span class="style2"><font color="#FFFFFF"><strong>
		  <bean:write name="result" property="testeeId"/></font></strong>
		</span>
	  </td>
      <td height="21" bgcolor="#023F70">
	   <span class="style2"><font color="#FFFFFF">
	     <bean:write name="result" property="userName"/></font>
	   </span>
	  </td>
	 <logic:iterate id="userScore" name="result" property="userScore">
	     <td height="21" align="center">				
				  <bean:write name="userScore" />				
	     </td>
	   </logic:iterate>   
	 </tr>
 </logic:iterate>
 
   </table>

</html:form>