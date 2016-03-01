<%-- 
  - Author(s): Rahul 
  - Date: 11th July 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: 
  - This page is the content part of company Searh which
  - shows the list of all the companies matching the given
  - criteria.
  -
  --%>
<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.mgmtassessment.execmap.common.util.webapp.*" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<html:xhtml />

<% 
	UserContext userContext= (UserContext)request.getSession(false).getAttribute("userContext");
	String roleId= userContext.getUserInfo().getActivityRoleID().toString().trim();
	String rptId = userContext.getUserInfo().getReportId().toString().trim();
	request.setAttribute("rptId", rptId);
	request.setAttribute("roleId",roleId); 
%>
<p align="left">&nbsp;</p>
<table width="978" border="0" align="left" bordercolor="CECE9C">
  <tr>
    <td width="797" bordercolor="#FFFFFF" bgcolor="#023F70"><div align="left" class="style1">
   <a href='/execmap/admin.jsp' class='style1' >
   <bean:message bundle="execmap" key="home.title" />
   </a>
   ><bean:message bundle="execmap" key="adminoptions.account_management" />
   </td>
  </tr>
</table>
<p align="left">&nbsp;</p>
<html:form action="/CompanySearchAction">
 <FONT COLOR="#FF0000"><html:errors/></font>
 <logic:messagesPresent message="true">
 <html:messages message="true" id="msg" bundle="execmap">
<FONT COLOR="#FF0000"><bean:write name="msg" ignore="true"/><br></font>
</html:messages>
   </logic:messagesPresent>
 <bean:define id="viewGroupsErrorMsg">
<bean:message bundle="execmap" key="error.seachGroups" />
</bean:define>
<input type="hidden" name="viewGroupsErrorMsg" value='<%=(String)viewGroupsErrorMsg%>'/>

 <bean:define id="matchCompanyCriteria">
<bean:message bundle="execmap" key="errors.enterCriteria" />
</bean:define>
<input type="hidden" name="matchCompanyCriteriaMsg" value='<%=(String)matchCompanyCriteria%>'/>

<html:hidden property="enableScript" value=""/>

<table width="978" border="0" cellpadding="0" cellspacing="0" bgcolor="#023F70">
  <tr>
    <td width="409" bgcolor="#023F70"><div align="left">
     
      <span class="style1">&nbsp;
        <bean:write name="CompanySearchForm" property="companyCountFrom"/>&nbsp;
     -&nbsp;
     <bean:write name="CompanySearchForm" property="companyCountTo"/>&nbsp;
    <bean:message bundle="execmap" key="generic.company" />
     </span>
    
    </div></td>
    <td width="409" bgcolor="#023F70"><div align="left">
           <logic:notEmpty name="CompanySearchForm" property="seachCompanyName">
        <bean:define id="searchByCompanyName" name="CompanySearchForm" property="seachCompanyName" />
        <INPUT TYPE="Text" name="findCompanyName" value='<%=(String)searchByCompanyName%>'/>
        </logic:notEmpty>
        <logic:empty name="CompanySearchForm" property="seachCompanyName">
        <INPUT TYPE="Text" name="findCompanyName" value=''/>
        </logic:empty>
       <html:submit onclick="viewMatchingCompanies()"><bean:message bundle="execmap" key="generic.search" /></html:submit>

    </div></td>
     <td width="309" bgcolor="#023F70"><div align="left">
          <div align="center">
              <bean:define id="PreButton">
          <bean:message bundle="execmap" key="generic.previous" />
          </bean:define>
          <logic:greaterThan name="CompanySearchForm" property="pageCount" value='1'>
          <INPUT TYPE="image" SRC="<%=request.getContextPath()%>/images/main/pre.jpg" VALUE="<%=(String)PreButton%>"
                          ALT="<%=(String)PreButton%>" NAME="Submit now" onClick="viewPreviousCompanies();"/> 
          </logic:greaterThan>
      </div>
    </div></td>
     <td width="200" bgcolor="#023F70"><div align="left">
          <div align="center">
           <span class="style1">&nbsp;
       <bean:write name="CompanySearchForm" property="pageCount"/>&nbsp;
       <bean:message bundle="execmap" key="generic.of" />&nbsp;
        <bean:write name="CompanySearchForm" property="maxCompanyPageCount"/>&nbsp;
     </span>
      </div>
    </div></td>
     
     <td width="309" bgcolor="#023F70"><div align="left">
          <div align="center">
           <bean:define id="maxPages" name="CompanySearchForm" property="maxCompanyPageCount"/>
             <bean:define id="nextButton">
          <bean:message bundle="execmap" key="generic.next" />
          </bean:define>
          <logic:lessThan name="CompanySearchForm" property="pageCount" value='<%=(String)maxPages%>'>
          <INPUT TYPE="image" SRC="<%=request.getContextPath()%>/images/main/next.jpg" VALUE="<%=(String)nextButton%>"
               ALT="<%=(String)nextButton%>" NAME="Submit now" onClick="viewNextCompanies();"/>  
          </logic:lessThan>
           </div>
    </div></td>
    </tr>
    </table>


<html:hidden name="CompanySearchForm" property="seachCompanyName" />
<html:hidden name="CompanySearchForm" property="pageCount"/>

<table width="708" border="0" cellpadding="0" cellspacing="0">
 <script>
   var countRows=0;
 </script>
 <logic:notEmpty name="CompanySearchForm" property="companyList">
 <logic:iterate id="resultList" name="CompanySearchForm" property="companyList" type="com.mgmtassessment.execmap.data.dao.types.CompanyAcctMaster">
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
	<bean:define id="companyAccount" name="resultList"/>
	<bean:define id="companyAccountID" name="companyAccount" property="acctId"/>
	<html:radio name="CompanySearchForm" property="selectedCompany" value='<%=(String)companyAccountID%>'/>
	</div>
	</td>
	<td width="140">
	<div align="left">
	<logic:equal name="companyAccount" property="acctStat" value="D">
	<span class="style4">*</span>
	</logic:equal>
	<html:link page="/ViewCompanyAction.do"  paramId="acctId" paramName="companyAccount" paramProperty="acctId">
	<bean:write name="companyAccount" property="coName"/>(<bean:write name="companyAccount" property="acctId"/>)</html:link>
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
<p align="left">&nbsp;</p>
<p align="left">&nbsp;</p>

<table width="978" border="0" align="left" bgcolor="#023F70">
  <tr>
    
    	<logic:equal name="roleId"  value="1">  
    	<td>  
        <div align="center">
    	<html:submit onclick="javascript:addcompany();"><bean:message bundle="execmap" key="generic.add" /></html:submit>	    
	         </div>
   </td>
    <td>
        <div align="center">
        <logic:notEmpty name="CompanySearchForm" property="companyList">
        <html:submit onclick="javascript:editcompany();"><bean:message bundle="execmap" key="generic.edit" /></html:submit>
           </logic:notEmpty>
           <logic:empty name="CompanySearchForm" property="companyList">
           <html:submit onclick="javascript:editcompany();" disabled="true"><bean:message bundle="execmap" key="generic.edit" /></html:submit>
           </logic:empty>
         </div>
    </td>
    <td>
        <div align="center">
         <logic:notEmpty name="CompanySearchForm" property="companyList">
        <html:submit onclick="javascript:enabledisablecompany();"><bean:message bundle="execmap" key="generic.enable_disable" /></html:submit>
          </logic:notEmpty>
          <logic:empty name="CompanySearchForm" property="companyList">
        <html:submit onclick="javascript:enabledisablecompany();" disabled="true"><bean:message bundle="execmap" key="generic.enable_disable" /></html:submit>
          </logic:empty>
         </div>
    </td>
    <td>
        <div align="center">
         <logic:notEmpty name="CompanySearchForm" property="companyList">
        <html:submit onclick="javascript:showdisablecompanies();" ><bean:message bundle="execmap" key="generic.delete_disabled_companies" /></html:submit>
         </logic:notEmpty>
           <logic:empty name="CompanySearchForm" property="companyList">
        <html:submit onclick="javascript:showdisablecompanies();" disabled="true" ><bean:message bundle="execmap" key="generic.delete_disabled_companies" /></html:submit>
         </logic:empty>
        </div>
    </td>
    </logic:equal>
    <td>
        <div align="center">
         <logic:notEmpty name="CompanySearchForm" property="companyList">
		<html:submit onclick="javascript:viewGroups();"><bean:message bundle="execmap" key="generic.viewGroups" /></html:submit>
           </logic:notEmpty>
             <logic:empty name="CompanySearchForm" property="companyList">
		<html:submit onclick="javascript:viewGroups();" disabled="true"><bean:message bundle="execmap" key="generic.view" /></html:submit>
           </logic:empty>
            </div>
   </td>
  </tr>
</table>
<p>&nbsp;</p>

<div align="left">
   <p><span class="style4">*</span><bean:message bundle="execmap" key="admininduder.userlist.disabled" /></p>
  <p>&nbsp; </p>
  <p>&nbsp;</p>	
</div>
</html:form>