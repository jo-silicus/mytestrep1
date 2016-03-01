<%-- 
  - Author(s): Rahul 
  - Date: 11th July 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: 
  - This page shows the interface to view
  - a user record.The page is invoked by add action on search User Page.
  -
  --%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<tiles:insert page="/pages/layout/mainlayout.jsp" flush="true">
   <tiles:put name="header" value="/pages/common/execmapheader.jsp" />
   <tiles:put name="subheader" value="/pages/common/subheader.jsp" />
   <tiles:put name="whereami" value="" />
   <tiles:put name="content" value="/pages/user/ViewUserContent.jsp" />
   <tiles:put name="loginfooter" value="/pages/common/Loginfooter.jsp" /> 
</tiles:insert>