<%-- 
  - Author(s): Rahul 
  - Date: 11th July 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: 
  - The page is invoked by editUser.jsp which provides 
  - the inter face to update a user record. The page  
  - invokes  the searchUser action. 
  --%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<bean:define id="userCompanyAccountID" name="UserAccountForm" property="userCompanyAccountID"/>
<bean:define id="userGroupID" name="UserAccountForm" property="userGroupID"/>
<script>
function showUpdatedUsers(groupID,accountID)
{
	location.href="/execmap/UserSearchAction.do?companyAccountID="+accountID+"&groupID="+groupID;
}

</script>
<head>
</head>
<BODY onLoad="showUpdatedUsers('<%=(String)userGroupID%>','<%=(String)userCompanyAccountID%>')">
</BODY>