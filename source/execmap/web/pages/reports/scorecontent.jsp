<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<p align="left">&nbsp;</p>

<html:form action="/IndividualUserReport">
 <logic:equal name="IndividualSummaryReportForm" property="check" value="false">
   <bean:message bundle="execmap" key="adminuserreport.notassessedmessage.value" />	
 </logic:equal>
<logic:notEqual name="IndividualSummaryReportForm" property="check" value="false">
<table border=0 height=20 width="80%" cellspacing=0 cellpadding=0 >
 <tr>
  <td align=center height=21 width="100%">
   <font color=#008000>
	<bean:message bundle="execmap" key="adminuserreport.usrreport.title" />		
   </font>
  </td>
 </tr>			 
</table>
<br>
		
<table width="978" border="1" cellpadding="0" cellspacing="0" >
 <tr>
  <td align=left>
   <bean:message bundle="execmap" key="admininduserreport.acctid" /> :
  </td>
  <td align=left>
   <bean:write name="IndividualSummaryReportForm" property="acctid"/>
  </td>
  <td align=left>
	<bean:message bundle="execmap" key="admininduserreport.userid" /> :
  </td>
  <td align=left>
   <bean:write name="IndividualSummaryReportForm" property="userid"/>
  </td>
 </tr>
 <tr>
  <td align=left>
   <bean:message bundle="execmap" key="adminuserreport.sessionid.title" /> :
  </td>		
  <td align=left>
   <bean:write name="IndividualSummaryReportForm" property="sessId"/>
  </td>
  <td align=left>
   <bean:message bundle="execmap" key="adminuserreport.compflag.title" /> :
  </td>	
  <td align=left>
   <bean:write name="IndividualSummaryReportForm" property="compFlag"/>
  </td>
 </tr>
</table>
<br>
<table border=1 width="80%">
 <tr>
  <td align=center bgColor=#386898 height=21 width="15%">
   <font color=#eeeecc size=3>
	<strong>
	 <bean:message bundle="execmap" key="adminuserreport.activity.title" />
    </strong>
   </font>
  </td>
  <td align=center bgColor=#386898 height=21 width="15%">
   <font color=#eeeecc size=3>
	<strong>
	 
    </strong>
   </font>
  </td>
  <td align=center bgColor=#386898 height=21 width="30%">
   <font color=#eeeecc size=3>
	<strong>
	 <bean:message bundle="execmap" key="admininduserreport.stanscore" />
    </strong>
   </font>
  </td>
 </tr>
 <logic:iterate id="userscoreinfo" name="IndividualSummaryReportForm" property="userScoreDetails">
  <tr>
   <td align=center height=21 width="15%">
    <font size=2>
     <bean:write name="userscoreinfo" property="test_id"/>
    </font>
   </td>
   <td align=center height=21 width="15%">
    <font size=3>
     <bean:write name="userscoreinfo" property="raw_scr"/>
    </font>
   </td>
   <td align=center height=21 width="20%">
    <font size=2>
     <bean:write name="userscoreinfo" property="stan_score"/>
    </font>
   </td>
  </tr>
 </logic:iterate>
</table>
</logic:notEqual>
</html:form>