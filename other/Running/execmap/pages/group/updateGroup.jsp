<%-- 
  - Author(s): Rahul 
  - Date: 11th July 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: 
  - The page is invoked by editGroup.jsp which provides 
  - the inter face to update a user record. The page  
  - invokes  the searchGroup action. 
  --%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<bean:define id="companyAccountID" name="GroupAccountForm" property="companyAccountID"/>

<script>
function showUpdatedGroups(accountID)
{
	location.href="/execmap/SearchGroup.do?companyAccountID="+accountID;
}

</script>
<head>
</head>
<BODY onLoad="showUpdatedGroups('<%=(String)companyAccountID%>')">
</BODY>