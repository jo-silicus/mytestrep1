<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<p align="left">&nbsp;</p>

<html:form action="/SearchCompany">

 <FONT COLOR="#FF0000"><html:errors/></font>
 
<table width="978" border="0">
  <tr>
     <td width="571" bgcolor="#023F70"><span class="style1">Company</span>
     <html:text name="CompanySearchForm" property="seachCompanyName"/>
       <html:submit onclick="document.forms[0].pageCount.value=''"><bean:message bundle="execmap" key="generic.search" /></html:submit>
    </td>
  </tr>
</table>

 
<html:hidden name="CompanySearchForm" property="pageCount"/>

<table width="708" border="0" cellpadding="0" cellspacing="0">
 <script>
   var countRows=0;
 </script>
 <logic:iterate id="resultList" name="CompanySearchForm" property="companyList" type="com.mgmtassessment.execmap.data.dao.types.CompanyAcctMaster">
  <script>
    if(countRows%4 == 0)
   {
	document.write("<tr>");
   }
  </script>
  
	<td>
	<bean:define id="companyAccount" name="resultList"/>
	<bean:define id="companyAccountID" name="companyAccount" property="acctId"/>
	<bean:define id="EnableDisableAcctStat" name="companyAccount" property="acctStat"/>
	
	<html:radio name="CompanySearchForm" property="selectedCompany" value='<%=(String)companyAccountID%>'/>
	<logic:equal name="EnableDisableAcctStat" value="D">
     <IMG SRC="<%=request.getContextPath()%>/images/main/red_dot.gif"/>
    </logic:equal>
    <bean:write name="companyAccount" property="coName"/>(<bean:write name="companyAccount" property="acctId"/>)
	</td>
  
  <script>
   if(countRows%4 == 3)
   {
	document.write("</tr>");
   }
   countRows++;
   </script>
 
  </logic:iterate>
</table>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="978" border="0" align="left" cellpadding="0" cellspacing="0" bgcolor="#009966">
  <tr>
    <td width="409" bgcolor="#023F70"><div align="left">
          <div align="center">
          <html:submit><bean:message bundle="execmap" key="generic.submit" /></html:submit>
             
          </div>
    </div></td>
    <td width="409" bgcolor="#023F70"><div align="left">
          <div align="center">
          <html:submit onclick="viewGroups()">view Groups</html:submit>             
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
