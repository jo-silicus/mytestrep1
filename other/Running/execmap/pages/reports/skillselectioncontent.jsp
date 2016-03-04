<%-- 
  - Author(s): Singhra
  - Date: 17th Aug 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This jsp is used to display all the skills from which a 
  - user can choose skills to view skill summary report 
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
   ><a href='/execmap/SkillSummaryMenu.do' class='style1'>
    <bean:message bundle="execmap" key="report.selection.skill.summary" />
   </a>
   ><bean:message bundle="execmap" key="admingroupreport.form.tabletitle" />
   </td>
   <td>
   <div align="right" class="style1">
    <a href="javascript:callHelp();" class='style1'><bean:message bundle="execmap" key="generic.help"/> </a>
    </div>
   </td>
  </tr>
</table>
<p align="left">&nbsp;</p>

<html:form action="/SkillSummaryReport">
 <font color="#FF0000"><html:errors bundle="execmap"/></font>
 <logic:messagesPresent message="true">
  <html:messages message="true" id="msg" bundle="execmap">
   <font color="#FF0000"><bean:write name="msg" ignore="true"/></font>
  </html:messages>
 </logic:messagesPresent>
 
<html:hidden property="enableScript" value=""/>
<html:hidden name="SkillSummaryForm" property="acctId"/>
<html:hidden name="SkillSummaryForm" property="grpId"/>
<bean:define id="skillSummaryForm" name="SkillSummaryForm" type="com.mgmtassessment.execmap.webapp.main.report.form.SkillSummaryForm"/>
<bean:define id="completeStringMap" name="SkillSummaryForm" property="completeStringMap" />

<script type="text/javascript">
 function a() {
   document.forms[0].enableScript.value="Enabled";
   document.forms[0].action="/execmap/SkillSummaryReport.do?acctId=<%=skillSummaryForm.getAcctId()%>&grpId=<%=skillSummaryForm.getGrpId()%>";
 }
</script>
  <table width=978 border="0" cellpadding=0 cellspacing=0>
   <tr>
    <td align=left colspan=4>&nbsp;</td>
   </tr>
   <tr>
    <td width="429" bgcolor="#023F70"><span class="style2"><font color="#FFFFFF">
     <bean:message bundle="execmap" key="summary.title" /></font></span>
    </td>
    <td width="540" colspan=3 align=left bgcolor=#023F70>&nbsp;</td>
   </tr>
   <tr>
    <td align=left colspan=4>&nbsp;</td>
   </tr>
   <tr>
    <td align=center>
     <p class="style3"><bean:message bundle="execmap" key="admingroupreport.form.tabletitle" />:*</p>
	</td>
    <td align=left colspan=3>
     <html:select size="15" multiple="true" property="skills">
      <html:options collection="completeStringMap" property="key" labelProperty="value" />
    </html:select>
   </td>
  </tr>
 </table>
 <p>&nbsp;</p>
 <table width="969" border="0" cellpadding="0" cellspacing="0">
  <tr>
   <td width="455" align="center" bgcolor="#023F70">
    <html:submit onclick="javascript:a();">
     <bean:message bundle="execmap" key="admingroupreport.form.ssrbutton.value" />
    </html:submit>
   </td>
   <td width="504" align="center" bgcolor="#023F70">
    <html:reset>
     <bean:message bundle="execmap" key="generic.reset" />
    </html:reset>
   </td>
  </tr>
 </table>	
</html:form>