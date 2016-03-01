<%-- 
  - Author(s): Singhra
  - Date: 10th sep 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This contains securitybreachcontent.jsp which is used to display security breach message to the user of execmap software.
  - This page is invoked from login.jsp.
  - 
  --%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<tiles:insert page="/pages/layout/preassessmentlayout.jsp" flush="true">
   <tiles:put name="header" value="/pages/common/execmapheader.jsp" />
   <tiles:put name="content" value="/pages/common/securitybreachcontent.jsp" />
   <tiles:put name="loginfooter" value="/pages/common/Loginfooter.jsp" /> 
</tiles:insert>