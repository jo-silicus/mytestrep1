<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<html:xhtml />

<table>
 <tr>
	<td align=left>&nbsp;</td>
      <td align=left>&nbsp;</td>
 </tr>
</table>
<table>
 <tr>
	<td align=left>&nbsp;</td>
      <td align=left>&nbsp;</td>
 </tr>
</table>
<table width="978" border="0">
  <tr>
    <td width="165" bgcolor="#023F70"><span class="style1">Options</span></td>
    <td width="626" bgcolor="#023F70">&nbsp;</td>
  </tr>
</table>
<p>&nbsp;</p>
<blockquote>
  <blockquote>
    <table width="600" border="1">
      <tr>
        <td><p><img src="/execmap/images/main/gen_rep.jpg" width="41" height="32"><bean:message bundle="execmap" key="adminoptions.general_reports" /></p></td>
      </tr>
    </table>
    <ol>
      <ol>
        <li><a href="EnableCompaniesReport.do?status=E"><bean:message bundle="execmap" key="adminoptions.enabledcomplist" /></a></li>
        <li><a href="EnableCompaniesReport.do?status=D"><bean:message bundle="execmap" key="adminoptions.disabledcomplist" /></a></li>
        <li><a href="SkillSummaryMenu.do">Skill Summary Report </a>(Global Manager,Company Mnager,Group Manager) </li>
        <li><a href="AssessmentSummaryMenu.do">Assessment Summary Report</a> (Global Manager) <br>
      </ol> 
    </ol>
    <table width="600" border="1">
      <tr>
        <td><p><img src="/execmap/images/main/career_rep.jpg" width="41" height="32"> Reports . </p></td>
      </tr>
    </table>
    <ol>
      <li><a href="IndividualSummaryMenu.do?rptId=Ind">Individual Summary</a></li>
      <li> <a href="GeneralIndividualMenu.do?rptId=1">General Individual Report</a></li>
      <li><a href="LeadershipEMenu.do?rptId=3">ExecMap Leadership E Report</a></li>
      <li><a href="LeadershipAMenu.do?rptId=2">ExecMap Leadership A Report</a></li>
      <li><a href="LeadershipManagementMenu.do?rptId=4">Leadership/Management Analysis</a><br>
      </li>
    </ol>
  </blockquote>
</blockquote>
