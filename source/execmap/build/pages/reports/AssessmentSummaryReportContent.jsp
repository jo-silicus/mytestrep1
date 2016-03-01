<%-- 
  - Author(s): Singhra
  - Date: 23rd Aug 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This jsp contains AssessmentSummaryReportContent.jsp which is used to display assessment summary report of 
  - all the users to the global manager
 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

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
   ><a href='/execmap/AssessmentSummaryMenu.do' class='style1' >
   <bean:message bundle="execmap" key="report.selection.assessment.summary" />
   </a>
   ><bean:message bundle="execmap" key="adminoptions.assessment_summary_report" />
   </td>
  </tr>
</table>
<p align="left">&nbsp;</p>

<html:form action="/AssessmentSummaryReport">
<bean:define id="acctid" name="AssessmentSummaryForm" property="acctId"/>
<bean:define id="grpid" name="AssessmentSummaryForm" property="grpId"/>

<script>
var path = '/execmap/html/reports/'+'<%=acctid%>'+'<%=grpid%>';
function excel() {

	open(path+"AssessmentSummary.xls",null,'height=800,width=1024,target="_self",toolbar=no,directories=no,status=yes, menubar=yes,scrollbars=yes,resizable=yes,left=0,top=0');
	}
</script>
<table width="978"><tr><td align="right"><html:link href="javascript:excel();"> <img src="/execmap/images/main/excel.GIF"><bean:message bundle="execmap" key="view.in.msexcel" /></html:link></td></tr></table>
<body>

<table width="978" cellpadding="0" bgcolor="#023F70">
  <tr>
    <td width="100%"><p align="center" class="style1"><bean:message bundle="execmap" key="userreportcordinator.acreportwithspaces.title" /></p></td>
  </tr>
</table>

 <logic:equal name="AssessmentSummaryForm" property="check" value="false">
   <p align="center"><FONT COLOR="#FF0000"><bean:message bundle="execmap" key="userreportcordinator.emcreport.nouser" /></font></p>	
 </logic:equal>
<logic:notEqual name="AssessmentSummaryForm" property="check" value="false">
<table width="978" border="1" cellpadding="0" bordercolor="#003366">
  <tr bgcolor="#023F70" >
    <td width="15%"><p align="center" class="style1"> <bean:message bundle="execmap" key="generic.account" /> </p></td>
    <td width="10%"><p align="center" class="style1"> <bean:message bundle="execmap" key="reportframe.adminreportpanel.jlabel.group" /> </p></td>
    <td width="7%"><p align="center" class="style1"> <bean:message bundle="execmap" key="userreportcordinator.username.title" /></p></td>
    <td width="12%"><p align="center" class="style1"> <bean:message bundle="execmap" key="generic.email" /> </p></td>
    <td width="9%"><p align="center" class="style1"> <bean:message bundle="execmap" key="userreportcordinator.session.title" /> </p></td>
    <td width="10%"><p align="center" class="style1"> <bean:message bundle="execmap" key="userreportcordinator.startdate.title" /> </p></td>
    <td width="12%"><p align="center" class="style1"> <bean:message bundle="execmap" key="userreportcordinator.asscompleted.title" /> </p></td>
    <td width="29%"><p align="center" class="style1"> <bean:message bundle="execmap" key="userreportcoordinator.activitiescompleted" /> </p></td>
 </tr>
  
  <logic:iterate id="AssessmentSummaryDetails" name="AssessmentSummaryForm" property="assessmentSummaryDetails" type="com.mgmtassessment.execmap.business.model.AssessmentSummaryModel">
  <tr>
    <td width="15%"><p align="center"> <bean:write name="AssessmentSummaryForm" property="acctId"/></p></td>
    <td width="10%"><p align="center"> <bean:write name="AssessmentSummaryForm" property="grpId"/></p></td>
    <td width="7%"><p align="center"> <bean:write name="AssessmentSummaryDetails" property="usrName"/></p></td>
    <td width="12%"><p align="center"><a href="mailto:<bean:write name="AssessmentSummaryDetails" property="usrEmail"/>"><bean:write name="AssessmentSummaryDetails" property="usrEmail"/></a></p></td>
    <td width="9%"><p align="center"> <bean:write name="AssessmentSummaryDetails" property="sesId"/></p></td>
    <td width="10%"><p align="center"> <bean:write name="AssessmentSummaryDetails" property="startDate"/></p></td>
    <td width="12%"><p align="center"> <bean:write name="AssessmentSummaryDetails" property="compFlg"/> </p></td>
    <td width="29%"><p align="center"> <bean:write name="AssessmentSummaryDetails" property="testIdCompleted"/></p></td>
  </tr>
  </logic:iterate>
  </table>
  </logic:notEqual> 
</body>
</html:form>