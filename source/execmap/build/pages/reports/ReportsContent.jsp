<%-- 
  - Author(s): Singhra
  - Date: 17th Aug 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This jsp contains links to open General Individual Report, Leadership A Report, Leadership E Report, Leadership Management Report
 --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<% 	String acctId = request.getParameter("acctId");
   	String usrId = request.getParameter("usrId");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

<title>Untitled Document</title>
</head>

<body>
<html:form action="/GeneralReports">
<p>&nbsp;</p>
  <logic:messagesPresent message="true">

<html:messages message="true" id="msg" bundle="execmap">

<FONT COLOR="#FF0000"><p align=center><bean:write name="msg" ignore="true"/></p></font>

</html:messages>

</logic:messagesPresent>
  
<logic:notEmpty name="GeneralReportsForm" property="fileName">
<bean:define id="url" name="GeneralReportsForm"	property="fileName" />	
<bean:define id="reportId" name="GeneralReportsForm" property="rptId" />	

<logic:equal name="GeneralReportsForm" property="rptId" value="1">
 <table width="978" border="0" align="left" bordercolor="CECE9C">
  <tr>
    <td width="797" bordercolor="#FFFFFF" bgcolor="#023F70"><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
   </a>
   ><a href='/execmap/GeneralIndividualMenu.do?rptId=1' class='style1'>
   <bean:message bundle="execmap" key="report.selection.general.individual" />
   </a>
   ><bean:message bundle="execmap" key="adminoptions.general.individual.report" />
   </td>
  </tr>
 </table>
<p align="left">&nbsp;</p>
</logic:equal>
<logic:equal name="GeneralReportsForm" property="rptId" value="2">
 <table width="978" border="0" align="left" bordercolor="CECE9C">
  <tr>
    <td width="797" bordercolor="#FFFFFF" bgcolor="#023F70"><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
   </a>
   ><a href='/execmap/LeadershipAMenu.do?rptId=2' class='style1'>
   <bean:message bundle="execmap" key="report.selection.execmap.leadershipA" />
   </a>
   ><bean:message bundle="execmap" key="table.actv_mas.67" />
   </td>
  </tr>
 </table>
<p align="left">&nbsp;</p>
</logic:equal>
<logic:equal name="GeneralReportsForm" property="rptId" value="3">
 <table width="978" border="0" align="left" bordercolor="CECE9C">
  <tr>
    <td width="797" bordercolor="#FFFFFF" bgcolor="#023F70"><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
   </a>
   ><a href='/execmap/LeadershipEMenu.do?rptId=3' class='style1'>
   <bean:message bundle="execmap" key="report.selection.execmap.leadershipE" />
   </a>
   ><bean:message bundle="execmap" key="table.actv_mas.69" />
   </td>
  </tr>
 </table>
<p align="left">&nbsp;</p>
</logic:equal>
<logic:equal name="GeneralReportsForm" property="rptId" value="4">
 <table width="978" border="0" align="left" bordercolor="CECE9C">
  <tr>
    <td width="797" bordercolor="#FFFFFF" bgcolor="#023F70"><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
   </a>
   ><a href='/execmap/LeadershipManagementMenu.do?rptId=4' class='style1'>
   <bean:message bundle="execmap" key="report.selection.execmap.leadership.management" />
   </a>
   ><bean:message bundle="execmap" key="report.leadership.management" />
   </td>
  </tr>
 </table>
<p align="left">&nbsp;</p>
</logic:equal>


	<script type="text/javascript">
	var name='/execmap/html/reports/'+'<%=url%>';
	function html() {
	 open(name+".html",null,'height=800,width=1024,target="_self",toolbar=no,directories=no,status=yes, menubar=yes,scrollbars=yes,resizable=yes,left=0,top=0');
	 }
	 
	function word() {
	 open(name+".doc",null,'height=800,width=1024,target="_self",toolbar=no,directories=no,status=yes, menubar=yes,scrollbars=yes,resizable=yes,left=0,top=0');
	 }
	
	function pdf() {
	document.forms[0].action="/execmap/PDFConverter.do?repName=<%=url%>&rptId=<%=reportId%>&acctId=<%=acctId%>&usrId=<%=usrId%>";
	document.forms[0].submit();
	}
	</script>
	
	<p>&nbsp;</p>
	<table>
		<tr><td width="900" align="center">	<a href="javascript:html();" align="center"><img src="/execmap/images/main/ie.GIF"><bean:message bundle="execmap" key="click.here.view" /> html</a></td><br><br></tr>
		<tr><td width="900" align="center">	<a href="javascript:word();" align="center"><img src="/execmap/images/main/word.GIF"><bean:message bundle="execmap" key="click.here.view" /> word</a></td><br><br></tr>
		<tr><td width="900" align="center"><html:link href="javascript:pdf();" ><img src="/execmap/images/main/adobe.gif"><bean:message bundle="execmap" key="click.here.view" /> pdf </html:link></td></tr>
	</table>
</logic:notEmpty>
</html:form> 
<p>&nbsp;</p>
</body>
</html>
