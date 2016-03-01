<%-- 
  - Author(s): 
  - Date: 17th Aug 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This jsp is used to move to user search page					
 --%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<bean:define id="userCompanyAccountID" name="UserSearchForm" property="companyAccountID"/>

<bean:define id="userGroupID" name="UserSearchForm" property="usersGroupID"/>
<script>
function showUsers(groupID,accountID)
{
	location.href="/execmap/UserSearchAction.do?companyAccountID="+accountID+"&groupID="+groupID;
}

</script>
<head>
</head>
<BODY onLoad="showUsers('<%=(String)userGroupID%>','<%=(String)userCompanyAccountID%>')">
</BODY>