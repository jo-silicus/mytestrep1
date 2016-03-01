<%-- 
  - Author(s): Ashim Das
  - Date: 11th July 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This is the main page of execmap software.
  - This page is the layout for login page
  -
  --%>

<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<html:xhtml />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><bean:message bundle="execmap" key="generic.execmap"/></title>
<style type="text/css">
<!--
.style1 {color: #FFFFFF}
-->
.style4 {color: #FF0000; font-weight: bold; font-size: 24px; }
</style>

<link rel="stylesheet" type="text/css"
	href=<%="css/execmap.css"%>> </link>
<html:base target="_self"/>

<script type="text/javascript">

function addingcompany()
{
	document.forms[0].enableScript.value="Enabled";
	document.forms[0].action="/execmap/companyaccount.do";
	document.forms[0].submit;
}

function editingcompany()
{
	document.forms[0].enableScript.value="Enabled";
	document.forms[0].action="/execmap/updatecompany.do";
	document.forms[0].submit;

}

function addcompany()
{	
	document.forms[0].enableScript.value="Enabled";
	document.forms[0].action="/execmap/AddCompanyAction.do";
	document.forms[0].submit;
}
function enableJavaScript()
{

	document.forms[0].enableScript.value="Enabled";
}

function editcompany()
{	
	var accountID;
	if(document.forms[0].selectedCompany.checked)
	{
	    accountID=document.forms[0].selectedCompany.value
	 }
	var radioLength=document.forms[0].selectedCompany.length;
	for(var i = 0; i < radioLength; i++) {
		if(document.forms[0].selectedCompany[i].checked)
		{
			accountID=document.forms[0].selectedCompany[i].value;
		}
	}
	
	document.forms[0].enableScript.value="Enabled";
	document.forms[0].pageCount.value="";
	
	if(accountID==null)
	{
		return;	
	}
	else{
	
	document.forms[0].action="/execmap/EditCompanyAction.do?acctId="+accountID;
	document.forms[0].submit;
	}
	
}

function deleteCompany(field)
{
if(document.forms[0].selectedCheckboxes.checked)
{
	  document.forms[0].enableScript.value="Enabled";
      document.forms[0].action="/execmap/deletecompany.do";
	  document.forms[0].submit;
}
}

function deleteAllCompany(field){
document.forms[0].enableScript.value="Enabled";
if(!(document.forms[0].selectedCheckboxes.checked))
{
document.forms[0].selectedCheckboxes.checked=true;
}


for (i = 0; i < field.length; i++) {
    field[i].checked = true;
  }
	document.forms[0].enableScript.value="Enabled";
	document.forms[0].action="/execmap/deletecompany.do";
}



function openImageListWin()
{
	document.forms[0].enableScript.value="Enabled";
	window.open('ShowImageList.do','imagelist',"height=400,width=600,toolbar=no,directories=no,status=yes,menubar=no,						scrollbars=yes,resizable=no,left=200,top=25");
	
}

function enabledisablecompany()
{
	var accountID;
	if(document.forms[0].selectedCompany.checked)
	{
	    accountID=document.forms[0].selectedCompany.value
	 }
	var radioLength=document.forms[0].selectedCompany.length;
	for(var i = 0; i < radioLength; i++) {
		if(document.forms[0].selectedCompany[i].checked)
		{
			accountID=document.forms[0].selectedCompany[i].value;
		}
	}
	document.forms[0].enableScript.value="Enabled";
	document.forms[0].pageCount.value="";
	
	if(accountID==null)
	{
		alert('Please select a company');
		
		document.forms[0].action="/execmap/CompanySearchAction.do";
		document.forms[0].submit;
	}
	else{
	document.forms[0].action="/execmap/EnableDisableCompany.do?acctId="+accountID;
	document.forms[0].submit;
	}
}
function searchdisable()
{
	document.forms[0].action="/execmap/SearchBasedDisableCompany.do";
	document.forms[0].submit;

}

function showdisablecompanies()
{
	document.forms[0].enableScript.value="Enabled";
	document.forms[0].action="/execmap/ShowDisableCompanies.do";
	document.forms[0].submit;
}

function deleteGroup(field)
{
if(document.forms[0].selectedCheckboxes.checked)
{
      document.forms[0].action="/execmap/DeleteSelectedGroup.do";
	  document.forms[0].submit;
	  return;
}
var checked=0;
for (i = 0; i < field.length; i++) {
if (field[i].checked)
{
      checked=1;
}}

if (checked==1)
{document.forms[0].action="/execmap/DeleteSelectedGroup.do";
	   document.forms[0].submit;
       
      
	  }


	  else
	  {
	   alert("select the groups to delete");
	    return false;
	  }
	  
  

}
function check(){

var counter = 0;
var  error;
var i;
if(document.forms[0].selectedCheckboxes.checked)
{
     counter++;
}
for(i=0;i<DeleteDisableGroupForm.selectedCheckboxes.length;i++){
if(DeleteDisableGroupForm.selectedCheckboxes[i].checked){
counter++;
}
}

if(counter == 0){
error=document.forms[0].error.value
alert(error);
return (false);
}
else{
return (true);
}
}


function valid ()
{

var counter = 0;
var i;
if(document.forms[0].selectedCheckboxes.checked)
{
     counter++;
}
for(i=0;i<ShowDisabledUsersForm.selectedCheckboxes.length;i++){
if(ShowDisabledUsersForm.selectedCheckboxes[i].checked){
counter++;
}
}

if(counter == 0){
error=document.forms[0].error.value
alert(error);
return (false);
}
else{
return (true);
}
}

function deleteAllGroup(field){
document.forms[0].enableScript.value="Enabled";
if(!(document.forms[0].selectedCheckboxes.checked))
{
document.forms[0].selectedCheckboxes.checked=true;
}


for (i = 0; i < field.length; i++) {
    field[i].checked = true;
  }

	document.forms[0].action="/execmap/DeleteSelectedGroup.do";
}


function deleteAllUser(field){
document.forms[0].enableScript.value="Enabled";
if(!(document.forms[0].selectedCheckboxes.checked))
{
document.forms[0].selectedCheckboxes.checked=true;
}


for (i = 0; i < field.length; i++) {
    field[i].checked = true;
  }

	document.forms[0].action="/execmap/DeleteSelectedUser.do";
}

function addGroup()
{
	var accountId=document.forms[0].companyAccountID.value;
	document.forms[0].enableScript.value="Enabled";
	document.forms[0].action="/execmap/AddGroupAction.do?companyAccountID="+accountId;
	document.forms[0].submit;
}

function editGroup()
{
	var accountID=document.forms[0].companyAccountID.value;
	var radioLength=document.forms[0].selectedGroup.length;
	var groupID;
	
	if(document.forms[0].selectedGroup.checked)
	{
	    groupID=document.forms[0].selectedGroup.value
	 }
	for(var i = 0; i < radioLength; i++) {
		if(document.forms[0].selectedGroup[i].checked)
		{
			groupID=document.forms[0].selectedGroup[i].value;
		}
	}
	document.forms[0].enableScript.value="Enabled";
	if(groupID==null)
	{
	document.forms[0].groupPageCount.value='';
	alert(document.forms[0].editGroupErrorMsg.value);
	document.forms[0].action="/execmap/SearchGroup.do?companyAccountID="+accountID;
	}
	else
	{
	
	document.forms[0].action="/execmap/editGroupAction.do?companyAccountID="+accountID+"&groupID="+groupID;
	}
	document.forms[0].submit;
}
function editGroupManagement()
{
	var accountID=document.forms[0].companyAccountID.value;
	var radioLength=document.forms[0].selectedGroup.length;
	document.forms[0].enableScript.value="Enabled";
	var groupID;
	if(document.forms[0].selectedGroup.checked)
	{
	    groupID=document.forms[0].selectedGroup.value
	 }
	for(var i = 0; i < radioLength; i++) {
		if(document.forms[0].selectedGroup[i].checked)
		{
			groupID=document.forms[0].selectedGroup[i].value;
		}
	}
	if(groupID==null)
	{
	document.forms[0].groupPageCount.value='';
	alert(document.forms[0].editGroupErrorMsg.value);
	document.forms[0].action="/execmap/GroupManagement.do";
	}
	else
	{
	document.forms[0].action="/execmap/editGroupManagementAction.do?companyAccountID="+accountID+"&groupID="+groupID;
	}
	document.forms[0].submit;
}

function viewGroups()
{
    
	var accountID;
	if(document.forms[0].selectedCompany.checked)
	{
	    accountID=document.forms[0].selectedCompany.value
	 }
	var radioLength=document.forms[0].selectedCompany.length;
	for(var i = 0; i < radioLength; i++) {
		if(document.forms[0].selectedCompany[i].checked)
		{
			accountID=document.forms[0].selectedCompany[i].value;
		}
	}
		document.forms[0].enableScript.value="Enabled";
	document.forms[0].pageCount.value='';
	if((accountID==null))
	{
	alert(document.forms[0].viewGroupsErrorMsg.value);
    document.forms[0].action="/execmap/CompanySearchAction.do";
	}
	else
	{

	document.forms[0].action="/execmap/SearchGroup.do?companyAccountID="+accountID;
	}
	document.forms[0].submit;
}
function enableDisableGroup()
{
    
    var groupID;
    var error;
    var accountID=document.forms[0].companyAccountID.value;
    document.forms[0].enableScript.value="Enabled";
    document.forms[0].groupPageCount.value='';
	if(document.forms[0].selectedGroup.checked)
	 {
	    
	    groupID=document.forms[0].selectedGroup.value
	 }
	var radioLength=document.forms[0].selectedGroup.length;
	for(var i = 0; i < radioLength; i++) {
		if(document.forms[0].selectedGroup[i].checked)
		{
		    
			groupID=document.forms[0].selectedGroup[i].value
			
		}
	}
	
	if(groupID==null)
	{
	    error=document.forms[0].editGroupErrorMsg.value;
	    alert(error);
	    document.forms[0].action="/execmap/SearchGroup.do?companyAccountID="+accountID;
		document.forms[0].submit;
	
	}
	else{
	location.href="/execmap/EnableDisableGroup.do?companyAccountID="+accountID+"&groupID="+groupID;
	}
	
}
function deleteDisableGroup()
{   
    document.forms[0].enableScript.value="Enabled";
    var accountID=document.forms[0].companyAccountID.value;
	document.forms[0].action="/execmap/ShowDisableGroups.do?companyAccountID="+accountID;
	document.forms[0].submit;
}
function deleteDisableUser()
{
    document.forms[0].enableScript.value="Enabled";
    var accountID=document.forms[0].companyAccountID.value;
    var groupID=document.forms[0].usersGroupID.value; 
	document.forms[0].action="/execmap/ShowDisableUsers.do?companyAccountID="+accountID+"&groupID="+groupID;;
	document.forms[0].submit;
}

function addUser()
{
	var accountId=document.forms[0].companyAccountID.value;
	var groupId=document.forms[0].usersGroupID.value;
	document.forms[0].enableScript.value="Enabled";
	document.forms[0].action="/execmap/AddUserAction.do?companyAccountID="+accountId+"&groupId="+groupId;
	document.forms[0].submit;
}
function editUser()
{
	var accountID=document.forms[0].companyAccountID.value;
	var radioLength=document.forms[0].selectedUser.length;
	var groupID=document.forms[0].usersGroupID.value;
	var userID;
		document.forms[0].enableScript.value="Enabled";
	if(document.forms[0].selectedUser.checked)
	{
	    userID=document.forms[0].selectedUser.value
	 }
	for(var i = 0; i < radioLength; i++) {
		if(document.forms[0].selectedUser[i].checked)
		{
			userID=document.forms[0].selectedUser[i].value;
		}
	}
	if(userID==null)
	{
	document.forms[0].userPageCount.value='';
	alert(document.forms[0].editErrorMsg.value);
	document.forms[0].action="/execmap/UserSearchAction.do?companyAccountID="+accountID+"&groupID="+groupID;
	}
	else
	{

	document.forms[0].action="/execmap/editUserAction.do?companyAccountID="+accountID+"&groupID="+groupID+"&userID="+userID;
	}
	document.forms[0].submit;
}
function viewUsers()
{
	var accountID=document.forms[0].companyAccountID.value;
	var groupID;
	
	if(document.forms[0].selectedGroup.checked)
	{
	    groupID=document.forms[0].selectedGroup.value
	 }
	var radioLength=document.forms[0].selectedGroup.length;
	for(var i = 0; i < radioLength; i++) {
		if(document.forms[0].selectedGroup[i].checked)
		{
			groupID=document.forms[0].selectedGroup[i].value;
		}
	}
	document.forms[0].groupPageCount.value='';
	document.forms[0].enableScript.value="Enabled";
	if(groupID==null)
	{
	alert(document.forms[0].viewUsersErrorMsg.value);
	document.forms[0].action="/execmap/SearchGroup.do?companyAccountID="+accountID;
	}
	else
	{
	
	document.forms[0].action="/execmap/UserSearchAction.do?companyAccountID="+accountID+"&groupID="+groupID;
	}
	document.forms[0].submit;
}
function viewUsersManagement()
{
	var accountID=document.forms[0].companyAccountID.value;
	var groupID;
	document.forms[0].enableScript.value="Enabled";
	if(document.forms[0].selectedGroup.checked)
	{
	    groupID=document.forms[0].selectedGroup.value
	 }
	var radioLength=document.forms[0].selectedGroup.length;
	for(var i = 0; i < radioLength; i++) {
		if(document.forms[0].selectedGroup[i].checked)
		{
			groupID=document.forms[0].selectedGroup[i].value;
		}
	}
	document.forms[0].groupPageCount.value='';
	if(groupID==null)
	{
	alert(document.forms[0].viewUsersErrorMsg.value);
	document.forms[0].action="/execmap/GroupManagement.do";
	}
	else
	{
	document.forms[0].action="/execmap/UserSearchAction.do?companyAccountID="+accountID+"&groupID="+groupID;
	}
	document.forms[0].submit;
}
function moveSelectedUser()

{  
    var userId;
    var MoveUserError;
    var SelectGroupError;
    document.forms[0].enableScript.value="Enabled";
    
    if(document.forms[0].selectedUser.checked)
	{
	    
	    userId=document.forms[0].selectedUser.value
	    
	 }
	var radioLength=document.forms[0].selectedUser.length;
	 
	for(var i = 0; i < radioLength; i++) {
	
		if(document.forms[0].selectedUser[i].checked)
		{
		    
			userId=document.forms[0].selectedUser[i].value;
			
		}
	}
     
    document.forms[0].userPageCount.value='';
    
    var accountID=document.forms[0].companyAccountID.value;
    
     var selecteditem=document.forms[0].groupIdSelected.selectedIndex;
     
    var selected=document.forms[0].groupIdSelected.options[selecteditem].value ;
    
    var previous=document.forms[0].usersGroupID.value;
    
   if (userId==null)
    {
      MoveUserError=document.forms[0].usererror.value;
      alert(MoveUserError);
      document.forms[0].action="/execmap/UserSearchAction.do?companyAccountID="+accountID+"&groupID="+previous;
	
    }
    else  if (selected==previous)
    {
      
      SelectGroupError=document.forms[0].grouperror.value;
      alert(SelectGroupError);
      document.forms[0].action="/execmap/UserSearchAction.do?companyAccountID="+accountID+"&groupID="+previous;
	
    }
    else
    {
     
     document.forms[0].action="/execmap/MoveSelectedUser.do?companyAccountID="+accountID+"&groupID="+previous+"&userID="+userId+"&groupIDSelected="+selected;
    
    }
      document.forms[0].submit;
}
function viewMatchingCompanies()
{
	var CompanyName=document.forms[0].findCompanyName.value;
	document.forms[0].enableScript.value="Enabled";
	if(CompanyName=='')
	{
		alert(document.forms[0].matchCompanyCriteriaMsg.value);
	}
	else
	{
	    document.forms[0].seachCompanyName.value=CompanyName;
	}
	document.forms[0].pageCount.value='';
}
function viewMatchingUsers()
{
	var accountID=document.forms[0].companyAccountID.value;
	var userName=document.forms[0].findUserName.value;
	if(userName=='')
	{
		alert(document.forms[0].matchUserCriteriaMsg.value);
	}
	else
	{
		document.forms[0].seachUserID.value=userName;
	}
	var groupID=document.forms[0].usersGroupID.value;
	document.forms[0].userPageCount.value='';
	document.forms[0].enableScript.value="Enabled";
	document.forms[0].action="/execmap/UserSearchAction.do?companyAccountID="+accountID+"&groupID="+groupID;
	document.forms[0].submit;
}

function viewMatchingGroups()
{
    document.forms[0].enableScript.value="Enabled";
	var accountID=document.forms[0].companyAccountID.value;
	var groupID=document.forms[0].findGroupID.value;
	if(groupID=='')
	{
		alert(document.forms[0].matchGroupCriteriaMsg.value);
	}
	else
	{
		document.forms[0].seachGroupID.value=groupID;
	}
	document.forms[0].groupPageCount.value='';
	document.forms[0].action="/execmap/SearchGroup.do?companyAccountID="+accountID;
	document.forms[0].submit;
}
function viewMatchingGroupsManagement()
{
	var accountID=document.forms[0].companyAccountID.value;
	var groupID=document.forms[0].findGroupID.value;
	document.forms[0].seachGroupID.value=groupID;
	document.forms[0].groupPageCount.value='';
	document.forms[0].action="/execmap/GroupManagement.do";
	document.forms[0].submit;
}

function viewPreviousUsers()
{
	var accountID=document.forms[0].companyAccountID.value;
	var groupID=document.forms[0].usersGroupID.value;
	var currentValue=document.forms[0].userPageCount.value;
	document.forms[0].userPageCount.value='';
	if(parseInt(currentValue) > 1)
	{
		document.forms[0].userPageCount.value=parseInt(currentValue)- 2;
	}
	document.forms[0].enableScript.value="Enabled";
	document.forms[0].action="/execmap/UserSearchAction.do?companyAccountID="+accountID+"&groupID="+groupID;
	document.forms[0].submit;
}
function viewNextUsers()
{
	var accountID=document.forms[0].companyAccountID.value;
	var groupID=document.forms[0].usersGroupID.value;
	document.forms[0].enableScript.value="Enabled";
	document.forms[0].action="/execmap/UserSearchAction.do?companyAccountID="+accountID+"&groupID="+groupID;
	document.forms[0].submit;
}
function viewPreviousGroups()
{
	var accountID=document.forms[0].companyAccountID.value;
	var currentValue=document.forms[0].groupPageCount.value;
	document.forms[0].groupPageCount.value='';
	if(parseInt(currentValue) > 1)
	{
		document.forms[0].groupPageCount.value=parseInt(currentValue)- 2;
	}
	document.forms[0].enableScript.value="Enabled";
	document.forms[0].action="/execmap/SearchGroup.do?companyAccountID="+accountID;
	document.forms[0].submit;
}
function viewNextGroups()
{
	var accountID=document.forms[0].companyAccountID.value;
	document.forms[0].enableScript.value="Enabled";
	document.forms[0].action="/execmap/SearchGroup.do?companyAccountID="+accountID;
	document.forms[0].submit;
}
function viewPreviousCompanies()
{
	var currentValue=document.forms[0].pageCount.value;
	document.forms[0].pageCount.value='';
	if(parseInt(currentValue) > 1)
	{
		document.forms[0].pageCount.value=parseInt(currentValue)- 2;
	}
	document.forms[0].action="/execmap/CompanySearchAction.do";
	document.forms[0].enableScript.value="Enabled";
	document.forms[0].submit;
}
function viewNextCompanies()
{
	document.forms[0].action="/execmap/CompanySearchAction.do";
	document.forms[0].enableScript.value="Enabled";
	document.forms[0].submit;
}
function moveUsersToGroup()
{
	var accountID=document.forms[0].companyAccountID.value;
	var radioLength=document.forms[0].selectedGroup.length;
	var fromGroupID;
	if(document.forms[0].selectedGroup.checked)
	{
	    fromGroupID=document.forms[0].selectedGroup.value
	 }
	for(var i = 0; i < radioLength; i++) {
		if(document.forms[0].selectedGroup[i].checked)
		{
			fromGroupID=document.forms[0].selectedGroup[i].value;
		}
	}

	var selecteditem=document.forms[0].moveToGroupID.selectedIndex;
	var toGroupID=document.forms[0].moveToGroupID.options[selecteditem].value;
     document.forms[0].groupPageCount.value='';
	document.forms[0].enableScript.value="Enabled";
	if((fromGroupID==null)||(toGroupID==null))
	{
	alert(document.forms[0].editGroupErrorMsg.value);
	document.forms[0].action="/execmap/SearchGroup.do?companyAccountID="+accountID;
	}
	else
	{
	if(fromGroupID==toGroupID)
	{
	alert(document.forms[0].moveUsersErrorMsg.value);
	document.forms[0].action="/execmap/SearchGroup.do?companyAccountID="+accountID;
	}
	else
	{
	document.forms[0].action="/execmap/moveUsers.do?companyAccountID="+accountID+"&fromGroupID="+fromGroupID+"&toGroupID="+toGroupID;
	}
	}
	document.forms[0].submit;
	
}
function enableDisableUser()
{
    
    var groupID=document.forms[0].usersGroupID.value;
    var accountID=document.forms[0].companyAccountID.value;
    var userID;
	if(document.forms[0].selectedUser.checked)
	 {
	    userID=document.forms[0].selectedUser.value
	 }
	var radioLength=document.forms[0].selectedUser.length;
	for(var i = 0; i < radioLength; i++) {
		if(document.forms[0].selectedUser[i].checked)
		{
			userID=document.forms[0].selectedUser[i].value
		}
	}
	document.forms[0].userPageCount.value='';
	document.forms[0].enableScript.value="Enabled";
	if(userID==null)
	{
    	alert(document.forms[0].editErrorMsg.value);
    	document.forms[0].action="/execmap/UserSearchAction.do?companyAccountID="+accountID+"&groupID="+groupID;
	}
	else{
    	document.forms[0].action="/execmap/EnableDisableUserAction.do?companyAccountID="+accountID+"&groupID="+groupID+"&userID="+userID;
	}
	document.forms[0].submit;
}
</script>
</head>
<body bgcolor="#ffffff">


<tiles:insert attribute="header"/>
<p>&nbsp;</p>
<tiles:insert attribute="subheader"/>
<tiles:insert attribute="whereami">
</tiles:insert> 
<tiles:insert attribute="content"/>
<tiles:insert attribute="loginfooter"/>

</body>
</html>