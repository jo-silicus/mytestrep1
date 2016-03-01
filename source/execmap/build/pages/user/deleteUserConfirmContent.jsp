<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<html:xhtml />
<form>
<p align="left">&nbsp;</p>
<p align="center"><bean:message bundle="execmap" key="user.deleted" /></p>
<p align="center">
<logic:iterate name="ShowDisabledUsersForm" property="selectedCheckboxes" id="userId">
<TR>
<bean:define id="accountId" name="ShowDisabledUsersForm" property="accountId"/>
<TD><br><bean:write name="userId"/> (<%=(String)accountId%>) </TD>
<td><br></td>
</TR>
</logic:iterate>
<form>