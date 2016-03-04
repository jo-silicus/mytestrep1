<%-- 
  - Author(s): Rahul 
  - Date: 11th July 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: 
  - This page shows the error message if a 
  - user disables JavaScript.
  --%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<tiles:insert page="/pages/layout/preassessmentlayout.jsp" flush="true">
   <tiles:put name="header" value="/pages/common/execmapheader.jsp" />
   <tiles:put name="content" value="/pages/common/SessionErrorcontent.jsp" />
   <tiles:put name="loginfooter" value="/pages/common/Loginfooter.jsp" /> 
</tiles:insert>