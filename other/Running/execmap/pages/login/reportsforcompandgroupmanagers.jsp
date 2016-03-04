<%-- 
  - Author(s): 
  - Date: 17th Aug 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This jsp serves as  a tile for reports for the
  - optionContent jsp	for company managers and group managers				
 --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>


	
<table width=85%  cellpadding=2 cellspacing=0>

	<TR>
    	<td width=18%>&nbsp;</td>
		<td  width="78%">
    	<table width="78%"border=1><tr><td><img src="<%=request.getContextPath()%>/images/main/career_rep.jpg" width="41" height="32">  &nbsp;&nbsp;  
	    <bean:message bundle="execmap" key="generic.Reports"/> </td></tr></table>
	    </a></td>
	</TR>
   
    <tr>  
   	    <td width=18%>&nbsp;</td>
	    <td align=left width="78%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
    	<a href="IndividualSummaryMenu.do?rptId=Ind"><bean:message bundle="execmap" key="adminoptions.individual.summary"/>
    	</a></td>
    </tr>
    <logic:equal name="rptId"  value="1">
    <tr>  
   	    <td width=18%>&nbsp;</td>
	    <td align=left width="78%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
    	<a href="GeneralIndividualMenu.do?rptId=1"><bean:message bundle="execmap" key="adminoptions.general.individual.report"/>
    	</a></td>
    </tr>
    </logic:equal>
    <logic:equal name="rptId"  value="2">
   	<tr>  
   	    <td width=18%>&nbsp;</td>
	    <td align=left width="78%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
    	<a href="LeadershipAMenu.do?rptId=2"><bean:message bundle="execmap" key="table.actv_mas.67"/></a></td>
    </tr>
    </logic:equal>
    <logic:equal name="rptId"  value="3">
    <tr>
		<td width=18%>&nbsp;</td>
		<td align=left width="78%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		<a href="LeadershipEMenu.do?rptId=3"><bean:message bundle="execmap" key="table.actv_mas.69"/></a></td>
	</tr>
	</logic:equal>
</table>


 

