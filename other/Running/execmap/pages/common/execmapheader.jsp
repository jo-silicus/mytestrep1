<%-- 
  - Author(s): Ashim Das
  - Date: 19th July 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This is the main header part of the new execmap
  - application. This header tile will be used across the site.
  - 
  --%>
  <%@ page language="java" %>
<%@ page import="com.perot.intellicue.common.util.webapp.*" %>
<% 
	UserContext userContext= (UserContext)request.getSession().getAttribute("userContext");
	String ImagePath = "Execmap_logo.gif";
	if(userContext!=null)
	{
	    UserLoginInfo userInfo= userContext.getUserInfo();
        if(userInfo!=null)
	    {
	       ImagePath = userInfo.getImagePath().trim();
	    }
	}
	request.setAttribute("imagePath",ImagePath);
	
%>
<table width=978 border=0 cellpadding=0 cellspacing=0>
  <tr>
    <td width=268 valign=top nowrap><img src="<%=request.getContextPath()%>/images/cobrand/<%=request.getAttribute("imagePath")%>" width="262" height="102"></td>
    <td width="546" bgcolor="#FFFFFF"><img src="/execmap/images/main/blue_label.jpg" width="707" height="102"></td>
  </tr>
</table>