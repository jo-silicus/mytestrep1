<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<p align="left">&nbsp;</p>

<html:hidden property="enableScript" value=""/>
<table width="978" border="0">
  <tr>
    <td width="233" bgcolor="#023F70"><span class="style1"><span class="style1"><a href="/execmap" class="style1"><bean:message bundle="execmap" key="home.title" /></a>><a href="/execmap/ForgetPassword.do" class="style1">
    <bean:message bundle="execmap" key="forgetpassword.title" />></a><bean:message bundle="execmap" key="forgot.password.conformation" /></span></td>
    <td width="565" bgcolor="#023F70">&nbsp;</td>
  </tr>
</table>
<p align="center"><bean:message bundle="execmap" key="forgot.password.confirmation.msg" /></p>
<p>&nbsp;</p>
