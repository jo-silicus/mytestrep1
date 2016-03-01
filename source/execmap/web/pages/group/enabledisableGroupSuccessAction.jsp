<%-- 
  - Author(s): 
  - Date: 17th Aug 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This page helps to move to group search page after enable disable group action 
 --%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<bean:define id="userCompanyAccountID" name="GroupSearchForm" property="companyAccountID"/>
<script>
function showGroups(accountID)
{   
    location.href="/execmap/SearchGroup.do?companyAccountID="+accountID;
}

</script>
<head>
</head>
<BODY onLoad="showGroups(<%=(String)userCompanyAccountID%>)">
</BODY>