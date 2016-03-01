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
   ><a href='/execmap/CobrandAction.do' class='style1' >
   <bean:message bundle="execmap" key="cobrand.image.upload" />
   </a>
   ><bean:message bundle="execmap" key="cobrand.image.comformation" />
   </td>
  </tr>
</table>
<p align="left">&nbsp;</p>
<html:hidden property="enableScript" value=""/>
<p align="center"><bean:message bundle="execmap" key="cobrand.image.confirmation.msg" /></p>
<p>&nbsp;</p>
