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