<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<bean:define id="userCompanyAccountID" name="GroupManagementForm" property="accountId"/>
<script type="text/javascript">
function showGroups(accountID)
{   
    location.href="/execmap/SearchGroup.do?companyAccountID="+accountID;
}

</script>
<head>
</head>

<BODY onLoad="showGroups(<%=(String)userCompanyAccountID%>)">
</BODY