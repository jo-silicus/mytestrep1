<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<tiles:insert page="/pages/layout/selectionlayout.jsp" flush="true">
   <tiles:put name="header" value="/pages/common/execmapheader.jsp" />
   <tiles:put name="subheader" value="/pages/common/subheader.jsp" />
   <tiles:put name="whereami" value="/pages/common/whereami.jsp" />
   <tiles:put name="content" value="/pages/reports/CompanyGroupUsercontent.jsp" />
</tiles:insert>