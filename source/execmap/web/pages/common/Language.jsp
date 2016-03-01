<%-- 
  - Author(s): Ashim Das
  - Date: 19th July 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This is the tile for login page of
  - execmap software. This page (Tile) has relevent code
  - for selecting language from the login page.
  -
  --%>

<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>


<html:form action="/changelanguage">
<table width="750" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="268"><span class="style16"><bean:message bundle="execmap" key="index.selectlang.text" />
    </span></td>
    <td width="482"><span class="style16">
      <html:select property="language" onchange="javascript:selectLanguage()">
      <bean:define id="languages" name="LanguagesForm" property="languages"/>
		        <html:options collection="languages" property="value" labelProperty="key"/>
	</html:select>
    </span></td>
  </tr>
</table>
</html:form>