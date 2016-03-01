<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<html:xhtml />

<html:form action="/deletecompany.do">
<p align="left">&nbsp;</p>
<p align="left">&nbsp;</p>
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
   ><bean:message bundle="execmap" key="company.delete.disable" />
   </td>
  </tr>
</table>
<p align="left">&nbsp;</p>


<table width="978" border="1" cellpadding="0" bordercolor="#003366">
  <tr bgcolor="#006699">
    <td width="2%" bgcolor="#023F70"><p align="center" class="style1">&nbsp; </p></td>
    <td width="10%" bgcolor="#023F70"><p align="center" class="style1"><bean:message bundle="execmap" key="generic.account" /></p></td>
    <td width="20%" bgcolor="#023F70"><p align="center" class="style1"> <bean:message bundle="execmap" key="generic.company" /> </p></td>
    <td width="17%" bgcolor="#023F70"><p align="center" class="style1"><bean:message bundle="execmap" key="generic.company.manager" /></p></td>
    <td width="22%" bgcolor="#023F70"><p align="center" class="style1"> <bean:message bundle="execmap" key="generic.email" /> </p></td>
    <td width="17%" bgcolor="#023F70"><p align="center" class="style1"> <bean:message bundle="execmap" key="total.user.accounts" /></p></td>
  </tr>


<logic:iterate id="DisplayCompanies"  name="CompanyAccountForm" property="disableCompanies" type="com.mgmtassessment.execmap.data.dao.types.CompanyAcctMaster" >
<tr>
<td width="2%"><p align="center" ><html:multibox name="CompanyAccountForm" property="selectedCheckboxes">
				<bean:write name="DisplayCompanies" property="acctId"/></html:multibox></p></td>
<td width="15%"><p align="center"><bean:write name="DisplayCompanies" property="acctId" /></p></td>
<td width="20%"><p align="center"><bean:write name="DisplayCompanies"  property="coName" /></p></td>
<td width="25%"><p align="center"><bean:write name="DisplayCompanies" property="coUsrMa.firstName" />
<bean:write name="DisplayCompanies" property="coUsrMa.lastName" /></p></td>
<td width="25%"><p align="center"><bean:write name="DisplayCompanies" property="coEmail" /></td>
<td width="5%"><p align="center"><bean:write name="DisplayCompanies" property="totalUsers" /></p></td>
</tr>
</logic:iterate>
</table>
<p>&nbsp;</p>
<html:hidden property="enableScript" value=""/>
<table width="978" border="0" align="left" bgcolor="#023F70">
  <tr>
    <td>    
        <div align="center">
    	<html:submit onclick="javascript:deleteAllCompany(this.form.selectedCheckboxes);" ><bean:message bundle="execmap" key="generic.deleteAll" /></html:submit>	    
	         </div>
   </td>
    <td>
        <div align="center">
        <html:submit onclick="javascript:deleteCompany(this.form.selectedCheckboxes);" ><bean:message bundle="execmap" key="generic.delete" /></html:submit>
         </div>
    </td>
  </tr>
</table>
<p>&nbsp;</p>


</html:form>