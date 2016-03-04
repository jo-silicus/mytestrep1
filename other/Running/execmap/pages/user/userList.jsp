<%-- 
  - Author(s): Rahul 
  - Date: 11th July 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: 
  - This page is the content part of user Searh which
  - shows the list of all the users matching the given
  - criteria.
  -
  --%>
<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ page import="com.perot.intellicue.common.util.webapp.*" %>
<p align="left">&nbsp;</p>

<% 
	UserContext userContext= (UserContext)request.getSession(false).getAttribute("userContext");
	String roleId= userContext.getUserInfo().getActivityRoleID().toString().trim();
	request.setAttribute("roleId",roleId); 
%>

<bean:define id="uriAccountID" name="UserSearchForm" property="companyAccountID"/>

<table width="978" border="0" align="left"  bordercolor="#FFFFFF" bgcolor="#023F70">
  <tr>
    <td width="797"><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
    </a>
   <logic:lessThan name="roleId" value="3">
   ><a href='/execmap/CompanySearchAction.do' class='style1' >
   <bean:message bundle="execmap" key="adminoptions.account_management" />
   </a>
   
   ><a href="/execmap/SearchGroup.do?companyAccountID=<%=uriAccountID%>" class='style1' >
  <bean:message bundle="execmap" key="adminoptions.groupmanagement" />
   </a>
   </logic:lessThan>
   <logic:equal name="roleId" value="3">
   ><a href='/execmap/GroupManagement.do' class='style1' >
   <bean:message bundle="execmap" key="adminoptions.groupmanagement" />
   </a>
   </logic:equal>
   ><bean:message bundle="execmap" key="adminoptions.usermanagement" />
   </td>
   <td >
   <div align="right" class="style1">
    <a href="javascript:callHelp();" class='style1'><bean:message bundle="execmap" key="generic.help"/> </a>
    </div>
   </td>
  </tr>
</table>
<p align="left">&nbsp;</p>
<html:form action="/UserSearchAction">
 <FONT COLOR="#FF0000"><html:errors/></font>
 <logic:messagesPresent message="true">

<html:messages message="true" id="msg" bundle="execmap">

<FONT COLOR="#FF0000"><bean:write name="msg" ignore="true"/><br></font>

</html:messages>

</logic:messagesPresent>

 
<bean:define id="editErrorMsg">
<bean:message bundle="execmap" key="error.editUser" />
</bean:define>
<html:hidden property="enableScript" value=""/>
 <bean:define id="matchUserCriteria">
<bean:message bundle="execmap" key="errors.enterCriteria" />
</bean:define>
<input type="hidden" name="matchUserCriteriaMsg" value='<%=(String)matchUserCriteria%>'/>

<input type="hidden" name="editErrorMsg" value='<%=(String)editErrorMsg%>'/>

 <table width="978" border="0" cellpadding="0" cellspacing="0" bgcolor="#023F70">
  <tr>
    <td width="409" bgcolor="#023F70"><div align="left">
     
      <span class="style1">&nbsp;
     <bean:write name="UserSearchForm" property="userCountFrom"/>&nbsp;
     -&nbsp;
     <bean:write name="UserSearchForm" property="userCountTo"/>&nbsp;
     <bean:message bundle="execmap" key="generic.User" />
     </span>
    
    </div></td>
    
    <td width="409" bgcolor="#023F70"><div align="left">
        <logic:notEmpty name="UserSearchForm" property="seachUserID">
        <bean:define id="searchByUserName" name="UserSearchForm" property="seachUserID"/>
        <INPUT TYPE="Text" name="findUserName" value='<%=(String)searchByUserName%>'/>
        </logic:notEmpty>
        <logic:empty name="UserSearchForm" property="seachUserID">
        <INPUT TYPE="Text" name="findUserName" value=''/>
        </logic:empty>
        
       <html:submit onclick="viewMatchingUsers();"><bean:message bundle="execmap" key="generic.search" /></html:submit>
     
    </div></td>
     <td width="309" bgcolor="#023F70"><div align="left">
          <div align="center">
           <bean:define id="PreButton">
          <bean:message bundle="execmap" key="generic.previous" />
          </bean:define>
           <logic:greaterThan name="UserSearchForm" property="userPageCount" value='1'>
          <INPUT TYPE="image" SRC="<%=request.getContextPath()%>/images/main/pre.jpg" VALUE="<%=(String)PreButton%>"
                          ALT="<%=(String)PreButton%>" NAME="Submit now" onClick="viewPreviousUsers();"/> 
          </logic:greaterThan>
      </div>
    </div></td>
     <td width="200" bgcolor="#023F70"><div align="left">
          <div align="center">
             <span class="style1">&nbsp;
       <bean:write name="UserSearchForm" property="userPageCount"/>&nbsp;
       <bean:message bundle="execmap" key="generic.of" />&nbsp;
        <bean:write name="UserSearchForm" property="maxUserPageCount"/>&nbsp;
     </span>
   
      </div>
    </div></td>
     
     <td width="309" bgcolor="#023F70"><div align="left">
          <div align="center">
          <bean:define id="maxPages" name="UserSearchForm" property="maxUserPageCount"/>
           <bean:define id="nextButton">
          <bean:message bundle="execmap" key="generic.next" />
          </bean:define>
          <logic:lessThan name="UserSearchForm" property="userPageCount" value='<%=(String)maxPages%>'>
          <INPUT TYPE="image" SRC="<%=request.getContextPath()%>/images/main/next.jpg" VALUE="<%=(String)nextButton%>"
               ALT="<%=(String)nextButton%>" NAME="Submit now" onClick="viewNextUsers();"/>  
          </logic:lessThan>
           </div>
        
    </div></td>
    </tr>
    </table>
    

<html:hidden name="UserSearchForm" property="seachUserID"/>
<html:hidden name="UserSearchForm" property="userPageCount"/>
<html:hidden name="UserSearchForm" property="companyAccountID"/>
<html:hidden name="UserSearchForm" property="usersGroupID"/>

<bean:define id="companyAccountID" name="UserSearchForm" property="companyAccountID"/>
<bean:define id="usersGroupID" name="UserSearchForm" property="usersGroupID"/>

<table width="708" border="0" cellpadding="0" cellspacing="0">
 <script>
   var countRows=0;
 </script>
 <logic:notEmpty name="UserSearchForm" property="userList">
 <logic:iterate id="resultList" name="UserSearchForm" property="userList" type="com.perot.intellicue.data.dao.types.CompanyUserMaster">
  <script>
    if(countRows%4 == 0)
   {
	document.write("<tr>");
   }
  </script>
  
	<td width="170">
	<table width="170" border="0" cellpadding="0" cellspacing="0">
	<tr>
	<td width="20">
	<div align="left">
	<bean:define id="userAccount" name="resultList"/>
	<bean:define id="userAccountKey" name="userAccount" property="comp_id" type="com.perot.intellicue.data.dao.types.CompanyUserMasterKey"/>
	<bean:define id="userAccountID" name="userAccountKey" property="usrId"/>
	<bean:define id="EnableDisableUsrStat" name="userAccount" property="usrStat"/>
	
	<html:radio name="UserSearchForm" property="selectedUser" value='<%=(String)userAccountID%>'/>
	</div>
	</td>
	<td width="140">
	<div align="left">
     <logic:equal name="EnableDisableUsrStat" value="D">
     <span class="style4">*</span>
    </logic:equal>
	 <%
       java.util.HashMap params = new java.util.HashMap();
       params.put("companyAccountID", companyAccountID);
       params.put("groupID", usersGroupID);
       params.put("userID", userAccountID);
       pageContext.setAttribute("UserParameters", params);
     %>

	
	<html:link action="viewUserAction.do" name="UserParameters">
	<bean:write name="userAccount" property="firstName"/>&nbsp;
	<bean:write name="userAccount" property="lastName"/>
	</html:link>
	</td>
	</div>
	</tr>
	</table>
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
<table width="978" border="0" align="left" cellpadding="0" cellspacing="0" bgcolor="#023F70">
  <tr>
    <td width="409" bgcolor="#023F70"><div align="left">
          <div align="center">
          <html:submit onclick="addUser()"><bean:message bundle="execmap" key="generic.Create_User" /></html:submit>             
          </div>
    </div></td>
    <td width="409" bgcolor="#023F70"><div align="left">
          <div align="center">
           <logic:notEmpty name="UserSearchForm" property="userList">
          <html:submit onclick="editUser()"><bean:message bundle="execmap" key="generic.editUser" /></html:submit>             
          </logic:notEmpty>
          <logic:empty name="UserSearchForm" property="userList">
          <html:submit onclick="editUser()" disabled="true"><bean:message bundle="execmap" key="generic.editUser" /></html:submit>             
          </logic:empty>
          </div>
    </div></td>
     <td width="409" bgcolor="#023F70"><div align="left">
          <div align="center">
           <logic:notEmpty name="UserSearchForm" property="userList">
          <html:submit onclick="enableDisableUser()"><bean:message bundle="execmap" key="generic.enable_disable_user" /></html:submit>             
          </logic:notEmpty>
          <logic:empty name="UserSearchForm" property="userList">
          <html:submit onclick="enableDisableUser()" disabled="true"><bean:message bundle="execmap" key="generic.enable_disable_user" /></html:submit>             
          </logic:empty>
          </div>
    </div></td>
     <td width="409" bgcolor="#023F70"><div align="left">
          <div align="center">
          <logic:notEmpty name="UserSearchForm" property="userList">
          <html:submit onclick="deleteDisableUser()"><bean:message bundle="execmap" key="adminuser.deletedisabledusers" /></html:submit>             
          </logic:notEmpty>
          <logic:empty name="UserSearchForm" property="userList">
          <html:submit onclick="deleteDisableUser()" disabled="true"><bean:message bundle="execmap" key="adminuser.deletedisabledusers" /></html:submit>             
          </logic:empty>
          </div>
    </div></td>
</td>
  </tr>

    <bean:define id="MoveUserError">
     <bean:message bundle="execmap" key="generic.User.Error.Move" />
     </bean:define>
     <input type="hidden" name="usererror" value="<%=(String)MoveUserError%>">
     
      <bean:define id="SelectGroupError">
     <bean:message bundle="execmap" key="generic.User.Error.Same.Group" />
     </bean:define>
     <input type="hidden" name="grouperror" value="<%=(String)SelectGroupError%>">
    <tr>
    <td width="409" bgcolor="#023F70"><div align="left">
          <div align="center">
           <logic:notEmpty name="UserSearchForm" property="userList">
             <bean:define id="groupDetails"  name="UserSearchForm" property="groupdetails"/>
          <html:submit onclick="moveSelectedUser()"><bean:message bundle="execmap" key="generic.move_user_to" /></html:submit>             
          </logic:notEmpty>
          <logic:empty name="UserSearchForm" property="userList">
          <html:submit onclick="moveSelectedUser()" disabled="true"><bean:message bundle="execmap" key="generic.move_user_to" /></html:submit>             
          </logic:empty>
            </div>
    </div></td>
    <td width="409" bgcolor="#023F70"><div align="left">
          <div align="center">
          <logic:notEmpty name="UserSearchForm" property="userList">
          <html:select property="groupIdSelected">
		<html:options collection="groupDetails" property="comp_id.grpId" labelProperty="comp_id.grpId"/>  
		</html:select>
          </logic:notEmpty>
          <logic:empty name="UserSearchForm" property="userList">
       <html:select property="groupIdSelected" disabled="true">
	
		</html:select>
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
