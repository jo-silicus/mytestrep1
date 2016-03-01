<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<p align="left">&nbsp;</p>

<html:form action="/companyaccount">

<table width="978" border="0" align="left" bordercolor="CECE9C">
  <tr>
    <td width="797" bordercolor="#FFFFFF" bgcolor="#023F70"><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
   </a>
   ><a href='/execmap/CompanySearchAction.do' class='style1' >
   <bean:message bundle="execmap" key="adminoptions.account_management" />
   </a>
   ><bean:message bundle="execmap" key="company.addcompany" />
   </td>
  </tr>
</table>
<p align="left">&nbsp;</p>


 <FONT COLOR="#FF0000"><html:errors bundle="execmap"/></font>
 <logic:messagesPresent message="true">
 <html:messages message="true" id="msg" bundle="execmap">
 <FONT COLOR="#FF0000"><bean:write name="msg" ignore="true"/><br></font>
 </html:messages>
 </logic:messagesPresent>
<html:hidden property="enableScript" value=""/>
 
<table width="978" border="0">
  <tr>
    <td width="227" bgcolor="#023F70"><span class="style1"><bean:message bundle="execmap" key="admineditcompany.frmcoacced.title.value" /></span></td>
    <td width="571" bgcolor="#023F70">&nbsp;</td>
  </tr>
</table>
<table width="708" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="321"><div align="right"><span class="style10"><bean:message bundle="execmap" key="admineditcompany.frmcoacced.coname.value" />:</span>      
      <html:text name="CompanyAccountForm" property="companyName" maxlength="50" style="background-color: #FFFF66;" />
    </div></td>
    <td width="387"><div align="right"><bean:message bundle="execmap" key="adminaddcompany.frmcoacccr.txt_co_info" />:
     <html:text name="CompanyAccountForm" property="companyInfo" maxlength="50" style="background-color: #FFFF66;"/>
    </div></td>
  </tr>
</table>
<table width="708" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="321"><p align="right"><bean:message bundle="execmap" key="admininduseredit.address" />:
         <html:text name="CompanyAccountForm" property="companyAddr1" maxlength="40" style="background-color: #FFFF66;"/>
</p></td>
    <td width="387"><div align="right"><bean:message bundle="execmap" key="generic.city" />:
         <html:text name="CompanyAccountForm" property="companyCity" maxlength="25" style="background-color: #FFFF66;"/>
    </div></td>
  </tr>
</table>
<table width="708" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="320"><div align="right">
      <html:text name="CompanyAccountForm" property="companyAddr2" maxlength="40" />
</div></td>
    <td width="388"><div align="right"><bean:message bundle="execmap" key="generic.state" />:
         <html:text name="CompanyAccountForm" property="companyState" maxlength="25" style="background-color: #FFFF66;" />
    </div></td>
  </tr>
</table>
<table width="708" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="320"> <div align="right"><bean:message bundle="execmap" key="generic.zip"  />:
         <html:text name="CompanyAccountForm" property="companyZip" maxlength="15" style="background-color: #FFFF66;"/>
    </div></td>
    <td width="388"> <div align="right"><bean:message bundle="execmap" key="generic.country"  />:
         <html:text name="CompanyAccountForm" property="companyCtry" maxlength="25" style="background-color: #FFFF66;"/>
    </div></td>
  </tr>
</table>
<table width="708" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="320"> <div align="right"><bean:message bundle="execmap" key="generic.email" />:
         <html:text name="CompanyAccountForm" property="companyEmail" maxlength="50" style="background-color: #FFFF66;" />
    </div></td>
    <td width="388">&nbsp;</td>
  </tr>
</table>
<p>&nbsp;</p>
<table width="978" border="0">
  <tr>
    <td width="231" bgcolor="#023F70"><span class="style1"><bean:message bundle="execmap" key="admineditcompany.frmcoacced.manager.title.value" /></span></td>
    <td width="567" bgcolor="#023F70">&nbsp;</td>
  </tr>
</table>
<table width="708" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="324"><div align="right"><bean:message bundle="execmap" key="generic.firstname" />:
         <html:text name="CompanyAccountForm" property="companyManagerFirstName" maxlength="50" style="background-color: #FFFF66;" />
    </div></td>
    <td width="388"><div align="right"><bean:message bundle="execmap" key="generic.lastname" />:
         <html:text name="CompanyAccountForm" property="companyManagerLastName" maxlength="50" style="background-color: #FFFF66;" />
    </div></td>
  </tr>
</table>
<table width="708" border="0" cellpadding="0" cellspacing="0">
  <tr>
  	<td width="324"><div align="right"><bean:message bundle="execmap" key="generic.userid" />:
         <html:text name="CompanyAccountForm" property="companyMgrUserId" maxlength="15" style="background-color: #FFFF66;" />
    </div></td>
    <td width="388"> <div align="right"><bean:message bundle="execmap" key="generic.pwd" />:
         <html:password name="CompanyAccountForm" property="companyMgrPasswd" maxlength="8" style="background-color: #FFFF66;" />
    </div></td>
    </tr>
</table>
<table width="708" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><bean:message bundle="execmap" key="admineditcompany.frmcoacced.pwd.message" /></td>
  </tr>
</table>
<table width="708" border="0" cellpadding="0" cellspacing="0">
  <tr>
  	 <td width="320"><div align="right"><bean:message bundle="execmap" key="generic.retype_pwd" />:
  	 	 <html:password name="CompanyAccountForm" property="reminderPhrase" maxlength="8" style="background-color: #FFFF66;" />
    </div></td>
    </tr>
</table>
<p>&nbsp;</p>
<table width="978" border="0">
  <tr>
    <td width="158" bgcolor="#023F70"><span class="style1"><bean:message bundle="execmap" key="admineditcompany.frmcoacced.customize.value" /></span></td>
    <td width="430" bgcolor="#023F70">&nbsp;</td>
  </tr>
</table>
<table width="780" border="0">
  <tr>
    <td width="320"><div align="right"><bean:message bundle="execmap" key="adminaddcompany.frmcoacccr.cobrand_info" />
     <html:radio name="CompanyAccountForm" property="companyCoBrandFlag" value="Y" />
        <bean:message bundle="execmap" key="generic.yes" />
     <html:radio name="CompanyAccountForm" property="companyCoBrandFlag" value="N"  />
        <label><bean:message bundle="execmap" key="generic.no" /></label>
    </div></td>
    <td width="438"><div align="right"><bean:message bundle="execmap" key="adminaddcompany.frmcoacccr.cobrand_info" />:
            <html:text name="CompanyAccountForm" property="companyCoBrandInfo" maxlength="50" />
    </div></td>
    <td><input type=button name="Browse" value="Browse" onclick="javascript:openImageListWin();" /></td>
  </tr>
</table>
<table width="708" border="0">
  <tr>
    <td width="320"><div align="right"><span class="style10"><bean:message bundle="execmap" key="admineditcompany.frmcoacced.technical.name" />:</span>
             <html:text name="CompanyAccountForm" property="companyTechContactName" maxlength="50" style="background-color: #FFFF66;" />
    </div></td>
    <td width="378"><div align="right"><bean:message bundle="execmap" key="admineditcompany.frmcoacced.technical.email" />:
             <html:text name="CompanyAccountForm" property="companyTechContactEmail" maxlength="40" style="background-color: #FFFF66;" />
    </div></td>
  </tr>
</table>
<table width="780" border="0">
  <tr>
    <td width="320"><div align="right"><span class="style10"><bean:message bundle="execmap" key="admineditcompany.frmcoacced.report.value" />:</span>
    <html:select  name="CompanyAccountForm" property="companyReportFormat" > 
       <html:option value="1"><bean:message bundle="execmap" key="admineditcompany.frmcoacced.typeofexecmapreportindividual.value" /></html:option>
       <html:option value="2"><bean:message bundle="execmap" key="admineditcompany.frmcoacced.typeofexecmapreportleadera.value" /></html:option>
       <html:option value="3"><bean:message bundle="execmap" key="admineditcompany.frmcoacced.typeofexecmapreportleaderb.value" /></html:option>
       <html:option value="4"><bean:message bundle="execmap" key="admineditcompany.frmcoacced.typeofexecmapreportsummary.value" /></html:option>
    </html:select>
     </div></td>
    <td width="413">&nbsp;</td>
  </tr>
</table>
<p>&nbsp;</p>
<table width="978" border="0" align="left" cellpadding="0" cellspacing="0" bgcolor="#009966">
  <tr>
    <td width="409" bgcolor="#023F70"><div align="left">
          <div align="center">
          <html:submit onclick="javascript:addingcompany();" ><bean:message bundle="execmap" key="generic.submit" /></html:submit>
             
          </div>
    </div></td>
    <td width="399" bgcolor="#023F70">
      <div align="center">
         <html:reset><bean:message bundle="execmap" key="generic.reset" /></html:reset>
      </div>
</td>
  </tr>
</table>
<p>&nbsp;</p>
<p>&nbsp;</p>

</html:form>
