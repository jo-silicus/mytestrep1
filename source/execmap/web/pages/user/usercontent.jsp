<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<html:form action="/usercreation" method="post" enctype="multipart/form-data">
<p align="left">&nbsp;</p>
<table width="978" border="0" align="left" bordercolor="CECE9C">
  <tr>
    <td width="797" bordercolor="#FFFFFF" bgcolor="#023F70"><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
   </a>
   ><bean:message bundle="execmap" key="user.file.upload" />
   </td>
  </tr>
</table>
<p align="left">&nbsp;</p>
<logic:messagesPresent message="true">
 <html:messages message="true" id="msg" bundle="execmap">
 <FONT COLOR="#FF0000"><bean:write name="msg" ignore="true"/></font>
 </html:messages>
 </logic:messagesPresent>
 
<table width="801" border="0">
  <tr>
    <td width="400">Select the file containing the users you wish to upload. </td>
        <td width="584"><html:file property="file" /></td>
  </tr>
</table>
<table width="750" border="0">
  <tr>
    <td width="750">
      
        <div align="right">
          <html:submit>Upload</html:submit>
        </div>
   </td>
    <td width="317">&nbsp;</td>
  </tr>
</table>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
</html:form>
