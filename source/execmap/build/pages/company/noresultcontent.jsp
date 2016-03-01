<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<html:xhtml />

<html:form action="/deletecompany.do">

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

<p align="centre"><b><FONT COLOR="#FF0000"><bean:message bundle="execmap" key="generic.nocompanyfound" /></font><b></p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<html:hidden property="enableScript" value=""/>
<table width="978" border="0" align="left" bgcolor="#023F70">
  <tr>
    <td>    
        <div align="center">
    	<html:submit disabled="true" ><bean:message bundle="execmap" key="generic.deleteAll" /></html:submit>	    
	         </div>
   </td>
    <td>
        <div align="center">
        <html:submit disabled="true"><bean:message bundle="execmap" key="generic.delete" /></html:submit>
         </div>
    </td>
  </tr>
</table>
<p>&nbsp;</p>


</html:form>