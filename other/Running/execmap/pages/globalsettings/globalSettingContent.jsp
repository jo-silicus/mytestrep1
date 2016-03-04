<%-- 
  - Author(s): Singhra
  - Date: 17th Aug 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This jsp is used to display global manager information to the global manager
 --%>
<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<html:xhtml />
<p align="left">&nbsp;</p>
<table width="978" border="0" align="left" bordercolor="#FFFFFF" bgcolor="#023F70">
  <tr>
    <td width="797" ><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
    </a>
   ><bean:message bundle="execmap" key="adminoptions.global_settings" />
   <td>
   <td >
   <div align="right" class="style1">
    <a href="javascript:callHelp();" class='style1'><bean:message bundle="execmap" key="generic.help"/> </a>
    </div>
   </td>
   </tr>
   </table>

<html:form action="/editGlobalSetting" >
<p align="left">&nbsp;</p>
<logic:messagesPresent message="true">

<html:messages message="true" id="msg" bundle="execmap">

<FONT COLOR="#FF0000"><bean:write name="msg" ignore="true"/><br></font>

</html:messages>

</logic:messagesPresent>


 <FONT COLOR="#FF0000"><html:errors bundle="execmap"/></font>
 <script type="text/javascript">
     function save()
     {
     document.forms[0].submit;
     }
    </script>
   <p >&nbsp;</p>

<table>
 
 <tr>
 	<td width="375"> <bean:message bundle="execmap" key="globalsettings.language" /></td>
 	
 	<td width="375">
      <select property="language" >
		        <option >English</option>
		        <option >French</option>
		        <option >Deutsch</option> 
	</select>
    </td>
  
  <tr>
    <td width="375"> <bean:message bundle="execmap" key="globalsettings.global.manager.usrid" /></td>
    <td width="375"><html:text name="GlobalSettingsForm" property="intlcUsrId" maxlength="15" style="background-color: #FFFF66;"/></td>
  </tr>
  <tr>
    <td width="375"> <bean:message bundle="execmap" key="globalsettings.global.manager.password" /></td>
    <td width="375"><html:password name="GlobalSettingsForm" property="intlcPasswd" maxlength="8" style="background-color: #FFFF66;"/></td>
  </tr>

  <tr>
    <td width="375"><bean:message bundle="execmap" key="globalsettings.global.exchange.server.name" /></td>
     <td width="375"><html:text name="GlobalSettingsForm" property="emailServerName" maxlength="50"/></td>
  </tr>
  <tr >
    <td width="375"><bean:message bundle="execmap" key="globalsettings.global.exchange.server.portno" /></td>
     <td width="375"><html:text name="GlobalSettingsForm" property="emailServerPort" maxlength="4" /></td>
  </tr>
  <tr>
    <td width="375"><bean:message bundle="execmap" key="globalsettings.global.exchange.server.usrid" /></td>
     <td width="375"><html:text name="GlobalSettingsForm" property="emailServerUserid" maxlength="20"/></td>
  </tr>
  <tr>
    <td width="375"><bean:message bundle="execmap" key="globalsettings.global.exchange.server.password" /> </td>
     <td width="375"><html:password name="GlobalSettingsForm" property="emailServerPassword" maxlength="20"/></td>
  </tr>
  <html:hidden name="GlobalSettingsForm" property="testDur" />
  <html:hidden name="GlobalSettingsForm" property="lstAcctNo" />
  <html:hidden name="GlobalSettingsForm" property="sysMasId" />
  <html:hidden name="GlobalSettingsForm" property="intlcAcctId" />
  <tr>
  </table>
  <p>&nbsp;</p>
  <table width="978" border="0" bgcolor="#023F70">
    <td align="center">
      <html:submit onclick="javascript:save()">
  <bean:message bundle="execmap" key="generic.submit" />
 </html:submit> 
</td>
<td align="center">
    <html:reset >
  <bean:message bundle="execmap" key="generic.reset" />
 </html:reset> 

</td>
  </tr>
</table>
<p>&nbsp;</p>
</html:form>
