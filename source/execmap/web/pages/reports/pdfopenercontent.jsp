<%-- 
  - Author(s): Singhra
  - Date: 17th Aug 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This jsp is used to open a report in pdf format.
 --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<% 	String acctId = request.getParameter("acctId");
	String usrId = request.getParameter("usrId");
	String rptId = request.getParameter("rptId");
%>

<p>&nbsp;</p>
<%if (rptId.equals("1")) {%>
 <table width="978" border="0" align="left" bordercolor="CECE9C">
  <tr>
    <td width="797" bordercolor="#FFFFFF" bgcolor="#023F70"><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
   </a>
   ><a href='/execmap/GeneralIndividualMenu.do?rptId=1' class='style1'>
   <bean:message bundle="execmap" key="report.selection.general.individual" />
   </a>
   ><a href='/execmap/GeneralReports.do?acctId=<%=acctId%>&usrId=<%=usrId%>&rptId=1' class='style1'>
   <bean:message bundle="execmap" key="adminoptions.general.individual.report" />
   </a>
   ><bean:message bundle="execmap" key="report.pdf.format" />
   </td>
  </tr>
 </table>
<p align="left">&nbsp;</p>
<%}%>

<%if (rptId.equals("2")) {%>
 <table width="978" border="0" align="left" bordercolor="CECE9C">
  <tr>
    <td width="797" bordercolor="#FFFFFF" bgcolor="#023F70"><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
   </a>
   ><a href='/execmap/LeadershipAMenu.do?rptId=2' class='style1'>
   <bean:message bundle="execmap" key="report.selection.execmap.leadershipA" />
   </a>
   ><a href='/execmap/GeneralReports.do?acctId=<%=acctId%>&usrId=<%=usrId%>&rptId=2' class='style1'>
   <bean:message bundle="execmap" key="table.actv_mas.67" />
   </a>
   ><bean:message bundle="execmap" key="report.pdf.format" />
   </td>
  </tr>
 </table>
<p align="left">&nbsp;</p>
<%}%>

<%if (rptId.equals("3")) {%>
 <table width="978" border="0" align="left" bordercolor="CECE9C">
  <tr>
    <td width="797" bordercolor="#FFFFFF" bgcolor="#023F70"><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
   </a>
   ><a href='/execmap/LeadershipEMenu.do?rptId=3' class='style1'>
   <bean:message bundle="execmap" key="report.selection.execmap.leadershipE" />
   </a>
   ><a href='/execmap/GeneralReports.do?acctId=<%=acctId%>&usrId=<%=usrId%>&rptId=3' class='style1'>
   <bean:message bundle="execmap" key="table.actv_mas.69" />
   </a>
   ><bean:message bundle="execmap" key="report.pdf.format" />

   </td>
  </tr>
 </table>
<p align="left">&nbsp;</p>
<%}%>

<%if (rptId.equals("4")) {%>
 <table width="978" border="0" align="left" bordercolor="CECE9C">
  <tr>
    <td width="797" bordercolor="#FFFFFF" bgcolor="#023F70"><div align="left" class="style1" class='style1'>
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
   </a>
   ><a href='/execmap/LeadershipManagementMenu.do?rptId=4' class='style1'>
   <bean:message bundle="execmap" key="report.selection.execmap.leadership.management" />
   </a>
   ><a href='/execmap/GeneralReports.do?acctId=<%=acctId%>&usrId=<%=usrId%>&rptId=4'>
   <bean:message bundle="execmap" key="report.leadership.management" />
   </a>
   ><bean:message bundle="execmap" key="report.pdf.format" />
   </td>
  </tr>
 </table>
<p align="left">&nbsp;</p>
<%}%>


<html>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
<bean:define id="repName" name="PDFConverterForm" property="repName"/>
<script>
var name='<%=repName%>';
open("/execmap/html/reports/"+name,null,'height=800,width=1024,target="_self",toolbar=yes,directories=no,status=yes, menubar=yes,scrollbars=yes,resizable=yes,left=0,top=0');
</script>
<bean:message bundle="execmap" key="open.pdf.message" />
</html>