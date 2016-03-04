<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<p align="left">&nbsp;</p>


<html:form action="/EnableCompaniesReport.do">

<table width="100%" border="1" bordercolor="#003366">			
 <tr bgcolor="#006699">
  <td width="15%" height="21" bgcolor="#023F70" align="center"><span class="style1">
    <bean:message bundle="execmap" key="generic.account" /></span>
  </td>
  <td width="15%" height="21" bgcolor="#023F70" align="center"><span class="style1">
    <bean:message bundle="execmap" key="generic.company" /></span>
  </td>
  <td width="15%" height="21" bgcolor="#023F70" align="center"><span class="style1">
    <bean:message bundle="execmap" key="generic.supname" /></span>
  </td>
  <td width="20%" height="21" bgcolor="#023F70" align="center"><span class="style1">
   <bean:message bundle="execmap" key="generic.email" /></span>
  </td>
  <td width="10%" height="21" bgcolor="#023F70" align="center"><span class="style1">
   Total User Accounts</span>
  </td>
 </tr>
			
 <logic:iterate id="companyinfo" name="EnableCompaniesListForm" property="enableCompanies">
  <tr>
   <td align=center height=21 width="15%">
    <font size=2>
     <bean:write name="companyinfo" property="acct_id"/>
    </font>
   </td>
   <td align=center height=21 width="15%">
    <font size=3>
     <bean:write name="companyinfo" property="co_name"/>
    </font>
   </td>
   <td align=center height=21 width="20%">
    <font size=2>
     <bean:write name="companyinfo" property="company_manager_id"/>
    </font>
   </td>
   <td align=center height=21 width="20%">
    <font size=2>
     <bean:write name="companyinfo" property="usr_email"/>
    </font>
   </td>
   <td align=center height=21 width="20%">
    <font size=2>
     <bean:write name="companyinfo" property="User Accounts"/>
    </font>
   </td>
  </tr>
 </logic:iterate>
</table>
</html:form>
