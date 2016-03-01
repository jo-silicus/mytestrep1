<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<script type="text/javascript">
function openViewImage()
{
	document.forms[0].enableScript.value="Enabled";
	window.open('ViewImageAction.do?image=<bean:write name="CompanyAccountForm" property="companyCoBrandInfo" />','images',"height=400,width=600,toolbar=no,directories=no,status=yes,menubar=no,scrollbars=yes,resizable=no,left=200,top=25");
	
}
</script>
<p align="left">&nbsp;</p> 
 <table width="978" border="0" align="left" bordercolor="CECE9C">
  <tr>
    <td width="797" bordercolor="#FFFFFF" bgcolor="#023F70"><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
   </a>
   ><a href='/execmap/CompanySearchAction.do' class='style1' >
   <bean:message bundle="execmap" key="adminoptions.account_management" />
   </a>
   ><bean:message bundle="execmap" key="company.viewcompany" />
   </td>
  </tr>
</table>



<p>&nbsp;</p>
<table width="978" border="0">
  <tr>
    <td width="203" bgcolor="#023F70"><span class="style1"><bean:message bundle="execmap" key="admineditcompany.frmcoacced.title.value" /></span></td>
    <td width="595" bgcolor="#023F70">&nbsp;</td>
  </tr>
</table>
<table width="750" border="0">
  <tr>
    <td width="146"> <div align="right"><bean:message bundle="execmap" key="admineditcompany.frmcoacced.coname.value" />:</div></td>
    <td width="129"><bean:write name="CompanyAccountForm" property="companyName" /></td>
    <td width="461">&nbsp;</td>
  </tr>
  <tr>
    <td><div align="right"><span class="style6"><bean:message bundle="execmap" key="adminaddcompany.frmcoacccr.txt_co_info" />:</span></div></td>
    <td><span class="style6"><bean:write name="CompanyAccountForm" property="companyInfo" /></span></td>
    <td>&nbsp;</td>
  </tr>
</table>
<table width="750" border="0">
  <tr>
    <td width="146"><div align="right"><span class="style6"><bean:message bundle="execmap" key="admininduseredit.address" />:</span></div></td>
    <td width="126"><bean:write name="CompanyAccountForm" property="companyAddr1" /></td>
    <td width="100">&nbsp;</td>
    <td width="360">&nbsp;</td>
  </tr>
    <tr>
    <td width="146"><div align="right"><span class="style6">:</span></div></td>
    <td width="126"><bean:write name="CompanyAccountForm" property="companyAddr2" /></td>
    <td width="100">&nbsp;</td>
    <td width="360">&nbsp;</td>
  </tr>
  <tr>
    <td><div align="right"><span class="style6"><bean:message bundle="execmap" key="generic.city" />:</span></div></td>
    <td><span class="style6"><bean:write name="CompanyAccountForm" property="companyCity" /></span></td>
    <td><div align="right"><span class="style6"><bean:message bundle="execmap" key="generic.state" />:</span></div></td>
    <td><span class="style6"><bean:write name="CompanyAccountForm" property="companyState" /></span></td>
  </tr>
  <tr>
    <td><div align="right"><span class="style6"><bean:message bundle="execmap" key="generic.country"  />:</span></div></td>
    <td><span class="style6"><bean:write name="CompanyAccountForm" property="companyCtry" /></span></td>
    <td><div align="right"><span class="style6"><bean:message bundle="execmap" key="generic.zip"  />:</span></div></td>
    <td><span class="style6"> <bean:write name="CompanyAccountForm" property="companyZip" /></span></td>
  </tr>
  <tr>
    <td><div align="right"><span class="style6"><bean:message bundle="execmap" key="generic.email" />:</span></div></td>
    <td><span class="style6"><bean:write name="CompanyAccountForm" property="companyEmail" /></span></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
<p>&nbsp;</p>
<table width="978" border="0">
  <tr>
    <td width="211" bgcolor="#023F70"><span class="style1"><bean:message bundle="execmap" key="admineditcompany.frmcoacced.manager.title.value" /></span></td>
    <td width="587" bgcolor="#023F70">&nbsp;      </td>
  </tr>
</table>
<table width="750" border="0">
  <tr>
    <td width="144"><div align="right"><bean:message bundle="execmap" key="generic.firstname" />:</div></td>
    <td width="125"><span class="style6"><bean:write name="CompanyAccountForm" property="companyManagerFirstName" /></span>  </td>
    <td width="104"><div align="right"><bean:message bundle="execmap" key="generic.lastname" />:</div></td>
    <td width="359"><span class="style6"><bean:write name="CompanyAccountForm" property="companyManagerLastName" /></span></td>
  </tr>
  <tr>
 	<td><div align="right"><bean:message bundle="execmap" key="generic.userid" />:</div></td>
    <td><span class="style6"><bean:write name="CompanyAccountForm" property="companyMgrUserId" /></span></td>
    <td><div align="right"><bean:message bundle="execmap" key="generic.pwd" />:</div></td>
    <td><span class="style6"><bean:write name="CompanyAccountForm" property="companyMgrPasswd" /></span></td>
  </tr>
</table>
<p>&nbsp;</p>
<table width="978" border="0">
  <tr>
    <td width="158" bgcolor="#023F70"><span class="style1"><bean:message bundle="execmap" key="admineditcompany.frmcoacced.customize.value" /></span></td>
    <td width="430" bgcolor="#023F70">&nbsp;</td>
  </tr>
</table>
<table width="750" border="0">
  <tr>
    <td width="144"><div align="right"><span class="style6"><bean:message bundle="execmap" key="adminaddcompany.frmcoacccr.cobrand_info" />:</span></div></td>
    <td width="86"><p class="style6"> <bean:write name="CompanyAccountForm" property="companyCoBrandInfo" /></p></td>
    <td width="506"><span class="style6"><a href="javascript:openViewImage();"><bean:message bundle="execmap" key="admineditcompany.frmcoacced.viewcobrand.value" /></a></span></td>
  </tr>

	<tr>
    <td><div align="right"><bean:message bundle="execmap" key="admineditcompany.frmcoacced.technical.name" />:</div></td>
    <td><bean:write name="CompanyAccountForm" property="companyTechContactName" /></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><div align="right"><bean:message bundle="execmap" key="admineditcompany.frmcoacced.technical.email" />:</div></td>
    <td><bean:write name="CompanyAccountForm" property="companyTechContactEmail" /></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><div align="right"><bean:message bundle="execmap" key="adminviewcompany.frmcoacced.report.value" />: </div></td>
    <td><bean:write name="CompanyAccountForm" property="companyReportFormat" /></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
<p>&nbsp; </p>
