<%-- 
  - Author(s): 
  - Date: 14th Aug 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This page is shows the list of disabled groups for
  - a particular company
 --%>
<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ page import="com.mgmtassessment.execmap.data.dao.types.*"%>
<html:xhtml />
<% 
	
	String accountId = request.getParameter("companyAccountID"); 
%>
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
   
   ><a href="/execmap/SearchGroup.do?companyAccountID=<%=accountId%>" class='style1' >
  <bean:message bundle="execmap" key="adminoptions.groupmanagement" />
   </a>
   ><bean:message bundle="execmap" key="adminoptions.delete.disabledgroups" />
   </td>
   </tr>
   </table>
<form name="DeleteDisableGroupForm" onSubmit="return check()"
method="post" action="/execmap/DeleteSelectedGroup.do">
<logic:messagesPresent message="true">

<html:messages message="true" id="msg" bundle="execmap">

<FONT COLOR="#FF0000"><bean:write name="msg" ignore="true"/><br></font>

</html:messages>

</logic:messagesPresent>

<p align="left">&nbsp;</p>
<table width="978" border="1" cellpadding="0" bordercolor="#003366">
  <tr bgcolor="#006699" height="40">
    <td width="2%" bgcolor="#023F70"><p align="center" class="style1">&nbsp; </p></td>
    <td width="13%" bgcolor="#023F70"><p align="center" class="style1"><bean:message bundle="execmap" key="generic.account" /></p></td>

    <td width="13%" bgcolor="#023F70"><p align="center" class="style1"><bean:message bundle="execmap" key="generic.company" /></p></td>
    <td width="11%" bgcolor="#023F70"><p align="center" class="style1"><bean:message bundle="execmap" key="generic.Group" /></p></td>
    <td width="13%" bgcolor="#023F70"><p align="center" class="style1"><bean:message bundle="execmap" key="generic.Group_Manager" /></p></td>
    <td width="22%" bgcolor="#023F70"><p align="center" class="style1"><bean:message bundle="execmap" key="generic.email" /></p></td>
    
    <td width="14%" bgcolor="#023F70"><p align="center" class="style1"> Total User Accounts </p></td>
  </tr>
 
  <logic:notEmpty  name="DeleteDisableGroupForm" property="listOfDisabledGroups">
  <logic:iterate id="DisplayDetails"  name="DeleteDisableGroupForm" property="listOfDisabledGroups" type="com.mgmtassessment.execmap.data.dao.types.CompanyAcctMaster">
  <bean:define id="companyAccountID" name="DisplayDetails" property="acctId"/>
  <html:hidden name="DeleteDisableGroupForm" property="accountId" value='<%=(String)companyAccountID%>'/>
  
  <logic:iterate id="Displaygroups"  name="DisplayDetails" property="coGrpMas" type="com.mgmtassessment.execmap.data.dao.types.CompanyGroupMaster">
  <%int count=0;%>
  
  <bean:define id="GroupMasterKey" name="Displaygroups" property="comp_id" type="com.mgmtassessment.execmap.data.dao.types.CompanyGroupMasterKey"/>
  <logic:notEqual name="GroupMasterKey" property="grpId" value="GENERAL">
  
  <tr>
   <td width="2%">
    <html:multibox name="DeleteDisableGroupForm" property="selectedCheckboxes">
  <bean:write name="GroupMasterKey" property="grpId"/>
 </html:multibox>
    </td>
   <td width="13%" ><p align="center"> <bean:write name="DisplayDetails" property="acctId"/> </p></td>
    <td width="13%" ><p align="center"> <bean:write name="DisplayDetails" property="coName"/> </p></td>
       <td width="11%" ><p align="center"> <bean:write name="Displaygroups" property="grpInfo"/> </p></td>
    <logic:iterate id="Displayusers"  name="Displaygroups" property="coUsrMas" type="com.mgmtassessment.execmap.data.dao.types.CompanyUserMaster">
 <%count++;%>
 <bean:define  id="compositeKey" name="Displayusers" property="comp_id" type="com.mgmtassessment.execmap.data.dao.types.CompanyUserMasterKey"/>
 <bean:define id="actv_rol_id" name="Displayusers" property="actvRolMa" type="com.mgmtassessment.execmap.data.dao.types.ActvRolMaster"/>
  <logic:equal name="actv_rol_id" property="actvRolId" value="3">
 <td width="13%"><p align="center"> <bean:write name="Displayusers" property="firstName"/> <bean:write name="Displayusers" property="lastName"/>  </p></td>
 <td width="22%"><p align="center"> <bean:write name="Displayusers" property="usrEmail"/> </p></td>
 </logic:equal>
    </logic:iterate>
  <td width="14%"><p align="center">   <%=count%><br>
</tr>
</logic:notEqual>
  </logic:iterate>
   </logic:iterate>
  </logic:notEmpty>
 </table>
<table width="808" border="0" align="left" bgcolor="#023F70">
  <tr>
  <bean:define id="msg">
     <bean:message bundle="execmap" key="generic.Group.Error.Delete" />
     </bean:define>
     <input type="hidden" name="error" value="<%=(String)msg%>">
     <html:hidden property="enableScript" value=""/>
    <td>    
        <div align="center">
    	<html:submit onclick="javascript:deleteAllGroup(this.form.selectedCheckboxes);"><bean:message bundle="execmap" key="generic.deleteAll" /></html:submit>	    
	         </div>
   </td>
    <td>
        <div align="center">
        <html:submit onclick="enableJavaScript();"><bean:message bundle="execmap" key="generic.delete" /></html:submit>
        
                 </div>
    </td>
  </tr>
</table>
<p>&nbsp;</p>


</form>