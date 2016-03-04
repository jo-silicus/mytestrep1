<%-- 
  - Author(s): 
  - Date: 17th Aug 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This jsp serves as  a tile to show general reports to a company manager or group manager 
--%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>


<table width=85% border=0 cellpadding=0 cellspacing=0>
  <tr><td width=18%>&nbsp;</td>
    <td  width="78%">
    <table width="78%"border=1><tr><td><img src="<%=request.getContextPath()%>/images/main//gen_rep.jpg">
      <!--General Reports-->
      <bean:message bundle="execmap" key="adminoptions.general_reports"/></td></tr></table></td>
  </TR>
  
  
  <TR>
    <td width=18%>&nbsp;</td>
    <td align=left width="78%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="/execmap/SkillSummaryMenu.do">
      <bean:message bundle="execmap" key="adminoptions.skill_summary_report"/> </a></td>
  </TR>
   
</table>



