<%-- 
  - Author(s): 
  - Date: 17th Aug 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This jsp serves as  a tile for group management for the
  - optionContent jsp
 --%>
<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<table width=85% border=0 cellpadding=2 cellspacing=0>
  <TR>
	    <td width=18%>&nbsp;</td>
    	<td  width="78%">
    		<table width="78%"border=1>
    			<tr>
    				<td><img src="<%=request.getContextPath()%>/images/main/career_rep.jpg" width="41" height="32">  &nbsp;  
    					<a href="GroupManagement.do">
					    <bean:message bundle="execmap" key="adminoptions.groupmanagement"/></a>
					</td>
				</tr>
			</table>
     	</td>
  </TR>
 
</table>
