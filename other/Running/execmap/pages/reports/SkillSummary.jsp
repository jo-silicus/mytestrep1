<%-- 
  - Author(s): Singhra
  - Date: 17th Aug 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This jsp contains skillsummarycontent.jsp which is used to display skill summary report.
 --%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<tiles:insert page="/pages/layout/reportlayout.jsp" flush="true">
   <tiles:put name="header" value="/pages/common/execmapheader.jsp" />
   <tiles:put name="subheader" value="/pages/common/subheader.jsp" />
   <tiles:put name="whereami" value="" />
   <tiles:put name="content" value="/pages/reports/skillsummarycontent.jsp" />
   <tiles:put name="loginfooter" value="/pages/common/Loginfooter.jsp" /> 
</tiles:insert>