<%-- 
  - Author(s): 
  - Date: 17th Aug 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This page gives a confirmation message when a group 
  -is deleted.
 --%>
<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<html:xhtml />
<form>
<p align="left">&nbsp;</p>
<p align="center"><bean:message bundle="execmap" key="group.deleted" /></p>
<p align="center">
<logic:iterate name="DeleteDisableGroupForm" property="selectedCheckboxes" id="grpId">
<TR>
<bean:define id="accountId" name="DeleteDisableGroupForm" property="accountId"/>
<TD><br><bean:write name="grpId"/> (<%=(String)accountId%>) </TD>
<td><br></td>
</TR>
</logic:iterate>
<form>