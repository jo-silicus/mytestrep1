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
<table width="978" border="0" align="left" bordercolor="CECE9C">
  <tr>
    <td width="797" bordercolor="#FFFFFF" bgcolor="#023F70"><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
   </a>
   ><a href='/execmap/SkillSummaryMenu.do' class='style1'>
    <bean:message bundle="execmap" key="report.selection.skill.summary" />
   </a>
   ><bean:message bundle="execmap" key="admingroupreport.form.tabletitle" />
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
      <option selected value="1"><bean:message bundle="execmap" key="selectskill.form.skills.figural" />
      </option>
      <option value="2"><bean:message bundle="execmap" key="selectskill.form.skills.symbolic" />
      </option>
      <option value="3"><bean:message bundle="execmap" key="selectskill.form.skills.semantic" />
      </option>
      <option value="4"><bean:message bundle="execmap" key="selectskill.form.skills.cognition" />
      </option>
      <option value="5"><bean:message bundle="execmap" key="selectskill.form.skills.memory" />
      </option>
      <option value="6"><bean:message bundle="execmap" key="selectskill.form.skills.evaluation" />
      </option>
      <option value="7"><bean:message bundle="execmap" key="selectskill.form.skills.convergent_production" />
      </option>
      <option value="8"><bean:message bundle="execmap" key="selectskill.form.skills.divergent_production" />
      </option>
      <option value="9"><bean:message bundle="execmap" key="selectskill.form.skills.reading" />
      </option>
      <option value="10"><bean:message bundle="execmap" key="selectskill.form.skills.reading_readiness" />
      </option>
      <option value="11"><bean:message bundle="execmap" key="selectskill.form.skills.reading_concepts_use" />
      </option>
      <option value="12"><bean:message bundle="execmap" key="selectskill.form.skills.arithmetics" />
      </option>
      <option value="13"><bean:message bundle="execmap" key="selectskill.form.skills.mathematics" />
      </option>
      <option value="14"><bean:message bundle="execmap" key="selectskill.form.skills.units" />
      </option>
      <option value="15"><bean:message bundle="execmap" key="selectskill.form.skills.classes" />
      </option>
      <option value="16"><bean:message bundle="execmap" key="selectskill.form.skills.relations" />
      </option>
      <option value="17"><bean:message bundle="execmap" key="selectskill.form.skills.systems" />
      </option>
      <option value="18"><bean:message bundle="execmap" key="selectskill.form.skills.transformations" />
      </option>
      <option value="19"><bean:message bundle="execmap" key="selectskill.form.skills.implications" />
      </option>
      <option value="29"><bean:message bundle="execmap" key="selectskill.form.skills.clarity_of_purpose" />
      </option>
      <option value="30"><bean:message bundle="execmap" key="selectskill.form.skills.decision_making" />
      </option>
      <option value="31"><bean:message bundle="execmap" key="selectskill.form.skills.directing_ability" />
      </option>
      <option value="32"><bean:message bundle="execmap" key="selectskill.form.skills.planning_ability" />
      </option>
      <option value="33"><bean:message bundle="execmap" key="selectskill.form.skills.counseling" />
      </option>
      <option value="34"><bean:message bundle="execmap" key="admingroupreport.form.skills.readingtext" />
      </option>
      <option value="35"><bean:message bundle="execmap" key="admingroupreport.form.skills.useofdocuments" />
      </option>
      <option value="36"><bean:message bundle="execmap" key="admingroupreport.form.skills.writing" />
      </option>
      <option value="37"><bean:message bundle="execmap" key="admingroupreport.form.skills.numeracy" />
      </option>
      <option value="38"><bean:message bundle="execmap" key="admingroupreport.form.skills.oralcommunication" />
      </option>
      <option value="39"><bean:message bundle="execmap" key="selectskill.form.skills.decision_making" />
      </option>
      <option value="40"><bean:message bundle="execmap" key="paragen.skillsummary.skillname.psvalue" />
      </option>
      <option value="41"><bean:message bundle="execmap" key="admingroupreport.form.skills.jobplanningorganizing" />
      </option>
      <option value="42"><bean:message bundle="execmap" key="admingroupreport.form.skills.significantuseofmemory" />
      </option>
      <option value="43"><bean:message bundle="execmap" key="admingroupreport.form.skills.locatinginformation" />
      </option>
      <option value="44"><bean:message bundle="execmap" key="admingroupreport.form.skills.workingcontext" />
      </option>
      <option value="45"><bean:message bundle="execmap" key="admingroupreport.form.skills.leadershiptraits" />
      </option>
      <option value="46"><bean:message bundle="execmap" key="admingroupreport.form.skills.computeruse" />
      </option>
      <option value="55"><bean:message bundle="execmap" key="selectskill.form.skills.perspective" />
      </option>
      <option value="56"><bean:message bundle="execmap" key="selectskill.form.skills.setting" />
      </option>
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