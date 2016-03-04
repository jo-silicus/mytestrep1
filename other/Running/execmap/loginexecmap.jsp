<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%
response.setHeader( "Cache-Control", "no-store, no-cache, must-revalidate" );
response.addHeader( "Cache-Control", "post-check=0, pre-check=0" );
response.setHeader( "Pragma", "no-cache" );
%>
<tiles:insert page="/pages/layout/loginlayout.jsp" flush="true">
   <tiles:put name="header" value="/pages/common/execmapheader.jsp" />
   <tiles:put name="content" value="/pages/common/Logincontent.jsp" />
   <tiles:put name="loginfooter" value="/pages/common/Loginfooter.jsp" /> 
</tiles:insert>