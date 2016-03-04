<%-- 
  - Author(s): 
  - Date: 17th Aug 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This page shows group for a group manager 
 --%>
<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<p align="left">&nbsp;</p>
<table width="978" border="0" align="left" bordercolor="#FFFFFF" bgcolor="#023F70">
  <tr>
    <td width="797" ><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
    </a>
   ><a href='/execmap/GroupManagement.do' class='style1' >
   <bean:message bundle="execmap" key="adminoptions.groupmanagement" />
   </a>
   </td>
   <td >
   <div align="right" class="style1">
    <a href="javascript:callHelp();" class='style1'><bean:message bundle="execmap" key="generic.help"/> </a>
    </div>
   </td>
  </tr>
</table>
<p align="left">&nbsp;</p>
<html:form action="/GroupManagement">

 <FONT COLOR="#FF0000"><html:errors/></font>
 <logic:messagesPresent message="true">
 <html:messages message="true" id="msg" bundle="execmap">
<FONT COLOR="#FF0000"><bean:write name="msg" ignore="true"/><br></font>
</html:messages>

</logic:messagesPresent>
 <bean:define id="editGroupErrorMsg">
<bean:message bundle="execmap" key="error.editGroup" />
</bean:define>
<input type="hidden" name="editGroupErrorMsg" value='<%=(String)editGroupErrorMsg%>'/>

<bean:define id="moveUsersErrorMsg">
<bean:message bundle="execmap" key="error.moveGroupUsers" />
</bean:define>
<input type="hidden" name="moveUsersErrorMsg" value='<%=(String)moveUsersErrorMsg%>'/>

 <bean:define id="viewUsersErrorMsg">
<bean:message bundle="execmap" key="error.seachUsers" />
</bean:define>
<input type="hidden" name="viewUsersErrorMsg" value='<%=(String)viewUsersErrorMsg%>'/>
 
 <table width="978" border="0" cellpadding="0" cellspacing="0" bgcolor="#023F70">
  <tr>
    <td width="409" bgcolor="#023F70"><div align="left">
     
      <span class="style1">&nbsp;
         <bean:write name="GroupSearchForm" property="groupCountFrom"/>&nbsp;
     -&nbsp;
     <bean:write name="GroupSearchForm" property="groupCountTo"/>&nbsp;
     <bean:message bundle="execmap" key="generic.Group" />
     </span>
    
    </div></td>
    <td width="409" bgcolor="#023F70"><div align="left">
         <logic:notEmpty name="GroupSearchForm" property="seachGroupID">
        <bean:define id="searchByGroupID" name="GroupSearchForm" property="seachGroupID"/>
        <INPUT TYPE="Text" name="findGroupID" value='<%=(String)searchByGroupID%>'/>
        </logic:notEmpty>
        <logic:empty name="GroupSearchForm" property="seachGroupID">
        <INPUT TYPE="Text" name="findGroupID" value=''/>
        </logic:empty>
       <html:submit onclick="viewMatchingGroupsManagement()"><bean:message bundle="execmap" key="generic.search" /></html:submit>

    </div></td>
     <td width="309" bgcolor="#023F70"><div align="left">
          <div align="center">
            <bean:define id="PreButton">
          <bean:message bundle="execmap" key="generic.previous" />
          </bean:define>
           <logic:greaterThan name="GroupSearchForm" property="groupPageCount" value='1'>
          <INPUT TYPE="image" SRC="<%=request.getContextPath()%>/images/main/pre.jpg" VALUE="<%=(String)PreButton%>"
                          ALT="<%=(String)PreButton%>" NAME="Submit now" onClick="viewPreviousGroups();"/> 
          </logic:greaterThan>
      </div>
    </div></td>
     <td width="200" bgcolor="#023F70"><div align="left">
          <div align="center">
                 <span class="style1">&nbsp;
       <bean:write name="GroupSearchForm" property="groupPageCount"/>&nbsp;
       <bean:message bundle="execmap" key="generic.of" />&nbsp;
        <bean:write name="GroupSearchForm" property="maxGroupPageCount"/>&nbsp;
     </span>
      </div>
    </div></td>
     
     <td width="309" bgcolor="#023F70"><div align="left">
          <div align="center">
           <bean:define id="maxPages" name="GroupSearchForm" property="maxGroupPageCount"/>
           <bean:define id="nextButton">
          <bean:message bundle="execmap" key="generic.next" />
          </bean:define>
          <logic:lessThan name="GroupSearchForm" property="groupPageCount" value='<%=(String)maxPages%>'>
          <INPUT TYPE="image" SRC="<%=request.getContextPath()%>/images/main/next.jpg" VALUE="<%=(String)nextButton%>"
               ALT="<%=(String)nextButton%>" NAME="Submit now" onClick="viewNextGroups();"/>  
          </logic:lessThan>
           </div>
    </div></td>
    </tr>
    </table>
    
<html:hidden name="GroupSearchForm" property="seachGroupID"/>
<html:hidden name="GroupSearchForm" property="groupPageCount"/>
<html:hidden name="GroupSearchForm" property="companyAccountID"/>
<bean:define id="companyAccountID" name="GroupSearchForm" property="companyAccountID"/>


<table width="708" border="0" cellpadding="0" cellspacing="0">
 <script>
   var countRows=0;
 </script>
  <logic:notEmpty name="GroupSearchForm" property="groupList">
 <logic:iterate id="resultList" name="GroupSearchForm" property="groupList" type="com.perot.intellicue.data.dao.types.CompanyGroupMaster">
  <script>
    if(countRows%4 == 0)
   {
	document.write("<tr>");
   }
  </script>
  
	<td>
	<bean:define id="groupAccount" name="resultList"/>
	<bean:define id="groupAccountKey" name="groupAccount" property="comp_id" type="com.perot.intellicue.data.dao.types.CompanyGroupMasterKey"/>
	<bean:define id="groupAccountID" name="groupAccountKey" property="grpId"/>
	<bean:define id="EnableDisableGrpStat" name="groupAccount" property="grpStat"/>
	<html:radio name="GroupSearchForm" property="selectedGroup" value='<%=(String)groupAccountID%>'/>
    <logic:equal name="EnableDisableGrpStat" value="D">
     <span class="style4">*</span>
    </logic:equal>
	 <%
       java.util.HashMap params = new java.util.HashMap();
       params.put("companyAccountID", companyAccountID);
       params.put("groupID", groupAccountID);
       pageContext.setAttribute("GroupParameters", params);
     %>

	
	<html:link action="viewGroupAction.do" name="GroupParameters">
	<bean:write name="groupAccountID"/>
	</html:link>
	</td>
  
  <script>
   if(countRows%4 == 3)
   {
	document.write("</tr>");
   }
   countRows++;
   </script>
 
  </logic:iterate>
   </logic:notEmpty>
</table>
<p>&nbsp;</p>
<p>&nbsp;</p>
<table width="978" border="0" align="left" cellpadding="0" cellspacing="0" bgcolor="#009966">
  <tr>
    <td width="409" bgcolor="#023F70"><div align="left">
          <div align="center">
                       
          </div>
    </div></td>
    <td width="409" bgcolor="#023F70"><div align="left">
          <div align="center">
          <html:hidden property="enableScript" value=""/>
          <logic:notEmpty name="GroupSearchForm" property="groupList">
          <html:submit onclick="editGroupManagement()"><bean:message bundle="execmap" key="generic.editGroup" /></html:submit>             
          </logic:notEmpty>
          <logic:empty name="GroupSearchForm" property="groupList">
          <html:submit onclick="editGroupManagement()" disabled="true"><bean:message bundle="execmap" key="generic.editGroup" /></html:submit>             
          </logic:empty>
          </div>
    </div></td>
     <td width="409" bgcolor="#023F70"><div align="left">
          <div align="center">
                       
          </div>
          
    </div></td>
     <td width="409" bgcolor="#023F70"><div align="left">
          <div align="center">
            
          </div>
    </div></td>
    
    <td width="399" bgcolor="#023F70">
      <div align="center">
      <logic:notEmpty name="GroupSearchForm" property="groupList">
        <html:submit onclick="viewUsersManagement()"><bean:message bundle="execmap" key="generic.View_User" /></html:submit>    
      </logic:notEmpty> 
      <logic:empty name="GroupSearchForm" property="groupList">
        <html:submit onclick="viewUsersManagement()" disabled="true"><bean:message bundle="execmap" key="generic.View_User" /></html:submit>    
      </logic:empty> 
      </div>
</td>
  </tr>
  <tr>
    <td width="409" bgcolor="#023F70"><div align="left">
          <div align="center">
         
          </div>
    </div></td>
    <td width="409" bgcolor="#023F70"><div align="left">
          <div align="center">
           
            
          </div>
    </div></td>
     <td width="409" bgcolor="#023F70"><div align="left">
          </div>
    </div></td>
     <td width="409" bgcolor="#023F70"><div align="left">
    </div></td>
    
    <td width="399" bgcolor="#023F70">
    </td>
  </tr>
</table>
<p>&nbsp;</p>
<p>&nbsp;</p>

<div align="left">
   <p><span class="style4">*</span><bean:message bundle="execmap" key="admininduder.userlist.disabled" /></p>
  <p>&nbsp; </p>
  <p>&nbsp;</p>	
</div>
</html:form>
