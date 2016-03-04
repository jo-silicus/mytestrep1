<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<p align="left">&nbsp;</p>

<script type="text/javascript">
function enableJavaScript()
{
document.forms[0].enableScript.value="Enabled";
}
function finishassessment(){
document.forms[0].enableScript.value="Enabled";
window.close();
}
</script>

<html:form action="/finishtest">
<html:hidden property="enableScript" value=""/>

 <FONT COLOR="#FF0000"><html:errors/></font>
 <table border="0" cellpadding="0" cellspacing="0" align="center">
  <tr>
    <td><div align="center">
    <span class="style4">
    <bean:message bundle="execmap" key="assessment.thankyoumessage" />
        </span>
    </div></td>
  </tr>
  </table>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
  <table border="0" align="center">
  <tr>
    <td>     
        <div align="center">
    	<html:submit onclick="javascript:finishassessment();enableJavaScript();"><bean:message bundle="execmap" key="generic.finish" /></html:submit>
	         </div>
   </td>
  </tr>
</table>

  </html:form>