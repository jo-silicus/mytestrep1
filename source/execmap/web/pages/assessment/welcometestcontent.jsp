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

function checkOS() {
     
 if(navigator.userAgent.indexOf('Win') != -1)
 { 
    var OpSys = "Windows3.1 or NT";
      if (navigator.appVersion.indexOf("MSIE")!=-1)
      {
        var boolValue=new Boolean(true);
        document.forms[0].soundCheck.value=boolValue.valueOf();
        
      }
       else if(navigator.userAgent.indexOf("Opera")!=-1)
       {
       var boolVal=new Boolean(true);
        document.forms[0].soundCheck.value=boolVal.valueOf();
       
       }
  }
  else{
        var boolValue=new Boolean(false);
        document.forms[0].soundCheck.value=boolValue.valueOf();
  
      }

}
 </script>
<html:form action="/welcometest">

<bean:define id="soundCheck" name="AssessmentInstForm" property="soundCheck"/>
<html:hidden name="AssessmentInstForm" property="soundCheck" value=""/>
<html:hidden name="AssessmentInstForm" property="checkFlagsoundset" value=""/>
<html:hidden property="enableScript" value=""/>
<SCRIPT>
var OpSys = checkOS();
</SCRIPT>
 <FONT COLOR="#FF0000"><html:errors/></font>
 <table border="0" cellpadding="0" cellspacing="0" align="center">
  <tr>
    <td><div align="center">
    <span class="style4">
    <bean:message bundle="execmap" key="testframe.testframe.lblhead.mcuewelcome" />
        <bean:message bundle="execmap" key="generic.Test" />
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
    	<html:submit onclick="javascript:beginassessment();enableJavaScript();"><bean:message bundle="execmap" key="testccreport.testccreport.testbtn.beginassessment" /></html:submit>	    
	         </div>
   </td>
    <td>
        <div align="center">
        <bean:define id="msg">
     <bean:message bundle="execmap" key="generic.Assessment.Cancel" />
     </bean:define>
     <input type="hidden" name="msg" value="<%=(String)msg%>">
        <html:submit onclick="javascript:cancelassessment();enableJavaScript();"><bean:message bundle="execmap" key="generic.cancel" /></html:submit>
         </div>
    </td>
    
  </tr>
</table>

  </html:form>