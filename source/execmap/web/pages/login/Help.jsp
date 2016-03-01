<%-- 
  - Author(s): 
  - Date: 17th Aug 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This jsp is used to call help html files in new window					
 --%>
<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

 <script type="text/javascript">
     function call()
     {
    
     var url_add="<%=request.getContextPath()%>/help.do";
     window.open(url_add);
     }
   </script>
<table width=85% border=0 cellpadding=2 cellspacing=0>
  <TR>
     <td width=18%>&nbsp;</td>
    <td  width="78%">
    <table width="78%"border=1><tr><td><img src="<%=request.getContextPath()%>/images/main/question-icon.gif" width="41" height="32">  &nbsp;&nbsp;  <a href="javascript:call();">
    <bean:message bundle="execmap" key="generic.help"/></td></tr></table>  </a></td>
  </TR>
  
</table>
