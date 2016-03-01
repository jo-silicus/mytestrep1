<%-- 
  - Author(s): Singhra
  - Date: 23rd Aug 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This jsp is used to display scores of a user.
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
   ><a href='/execmap/IndividualSummaryMenu.do?rptId=Ind' class='style1'>
   <bean:message bundle="execmap" key="report.selection.individual.summary" />
   </a>
   ><bean:message bundle="execmap" key="report.individual.summary" />
   </td>
  </tr>
</table>
<p align="left">&nbsp;</p>

<html:form action="/IndividualUserReport">
<bean:define id="acctid" name="IndividualSummaryReportForm" property="acctid"/>
<bean:define id="userid" name="IndividualSummaryReportForm" property="userid"/>
<script>
var path = '/execmap/html/reports/'+'<%=acctid%>'+'<%=userid%>';
function excel() {

	open(path+"IndividualReport.xls",null,'height=800,width=1024,target="_self",toolbar=no,directories=no,status=yes, menubar=yes,scrollbars=yes,resizable=yes,left=0,top=0');
	}
</script>
 <logic:equal name="IndividualSummaryReportForm" property="check" value="false">
   <bean:define id="username" name="IndividualSummaryReportForm" property="userid" />
   <bean:message bundle="execmap" key="adminuserreport.notassessedmessage.value" arg0="<%=(String)username%>" />	
 </logic:equal>
<logic:notEqual name="IndividualSummaryReportForm" property="check" value="false">
<table border=0 height=20 width="978" cellspacing=0 cellpadding=0 >
 <tr bgcolor="#006699">
  <td bgcolor="#023F70" align=center height=21 width="100%">
   <span class="style1">
	<bean:message bundle="execmap" key="adminuserreport.usrreport.title" />		
   </span>
  </td>
 </tr>			 
</table>
<br>
		
<table width="978" border="1" cellpadding="0" cellspacing="0" >
 <html:link href="javascript:excel();"><img src="/execmap/images/main/excel.GIF"><bean:message bundle="execmap" key="view.in.msexcel" /></html:link>
 <tr bgcolor="#006699">
  <td bgcolor="#023F70" align="left"><span class="style1">
   <bean:message bundle="execmap" key="admininduserreport.acctid" /> :</span>
  </td>
  <td bgcolor="#023F70" align="left"><span class="style1">
   <bean:write name="IndividualSummaryReportForm" property="acctid"/></span>
  </td>
  <td bgcolor="#023F70" align="left"><span class="style1">
	<bean:message bundle="execmap" key="admininduserreport.userid" /> :</span>
  </td>
  <td bgcolor="#023F70" align="left"><span class="style1">
   <bean:write name="IndividualSummaryReportForm" property="userid"/></span>
  </td>
 </tr>
 <tr bgcolor="#006699">
  <td bgcolor="#023F70" align="left"><span class="style1">
   <bean:message bundle="execmap" key="adminuserreport.sessionid.title" /> :</span>
  </td>		
  <td bgcolor="#023F70" align="left"><span class="style1">
   <bean:write name="IndividualSummaryReportForm" property="sessId"/></span>
  </td>
  <td bgcolor="#023F70" align="left"><span class="style1">
   <bean:message bundle="execmap" key="adminuserreport.compflag.title" /> :</span>
  </td>	
  <td bgcolor="#023F70" align="left"><span class="style1">
   <bean:write name="IndividualSummaryReportForm" property="compFlag"/></span>
  </td>
 </tr>
</table>
<br>
<table width="978" border="1" bordercolor="#003366">			
 <tr bgcolor="#006699">
  <td width="15%" height="21" bgcolor="#023F70" align="center"><span class="style1">
	 <bean:message bundle="execmap" key="adminuserreport.activity.title" /></span>
  </td>
  <td width="15%" height="21" bgcolor="#023F70" align="center"><span class="style1">
	 <bean:message bundle="execmap" key="adminuserreport.rawscore.title" /></span>
  </td>
  <td width="30%" height="21" bgcolor="#023F70" align="center"><span class="style1">
	 <bean:message bundle="execmap" key="admininduserreport.stanscore" /></span>
  </td>
 </tr>
 <logic:iterate id="userscoreinfo" name="IndividualSummaryReportForm" property="userScoreDetails">
  <tr>
   <td align=center height=21 width="15%">   
     <bean:write name="userscoreinfo" property="tri_id"/>
     <bean:write name="userscoreinfo" property="sub_test_id"/>  
   </td>
   <td align=center height=21 width="15%">  
     <bean:write name="userscoreinfo" property="raw_scr"/>  
   </td>
   <td align=center height=21 width="20%">  
     <bean:write name="userscoreinfo" property="stan_score"/>
   </td>
  </tr>
 </logic:iterate>
</table>
</logic:notEqual>
</html:form>