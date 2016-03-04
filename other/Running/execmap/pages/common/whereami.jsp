
<p align="right">&nbsp;</p>
<table width="978" border="0" align="left" bordercolor="CECE9C">
  <tr>
    <td width="797" bordercolor="#FFFFFF" bgcolor="#023F70"><div align="left" class="style1">
 	<tiles:useAttribute id="test" name="test" />
 	<%String test = request.getParameter("test");%>
 	<tiles:put name="test" value="<%=test%>" />
	<%=test%>
 	</td>
  </tr>
</table>