<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<p align="left">&nbsp;</p>


 <FONT COLOR="#FF0000"><html:errors/></font>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Untitled Document</title>
<link href="template_css1.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
.style2 {
	font-size: 24px;
	font-weight: bold;
	font-style: italic;
}
.style3 {font-size: 24px}
.style4 {font-weight: bold}
.style5 {font-size: larger}
.style6 {font-size: x-large}
.style7 {font-size: large}
.style8 {color: #FF0000}
.style9 {font-size: large; color: #FF0000; }
.style1 {	font-size: 24px;
	font-style: italic;
}
-->
</style>

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
         document.forms[0].submit;
        
      }
       else if(navigator.userAgent.indexOf("Opera")!=-1)
       {
       var boolVal=new Boolean(true);
        document.forms[0].soundCheck.value=boolVal.valueOf();
        document.forms[0].submit;
       
       }
  }
  else{
        var boolValue=new Boolean(false);
        document.forms[0].soundCheck.value=boolValue.valueOf();
  
      }

}


function setFlag(){
var boolValue=new Boolean(true);
document.forms[0].checkFlagsoundset.value=boolValue.valueOf();
}
</script>

</head>

<html:form action="/soundinstruction" >

<html:hidden name="AssessmentInstForm" property="checkFlagsoundset" value=""/>
<bean:define id="soundCheck"  name="AssessmentInstForm" property="soundCheck"/>
<html:hidden name="AssessmentInstForm" property="soundCheck" value=""/>
<html:hidden property="enableScript" value=""/>
<SCRIPT>
var OpSys = checkOS();
</SCRIPT>
<table align="center">
  <tr>
    <td><span class="style2"> <bean:message bundle="execmap" key="testframe.testframe.lblhead.mcuewelcome" /></span><b></b></td>
    <td><b><em><span class="style3"> <bean:message bundle="execmap" key="generic.execmap" /></span></em></b></td>
  </tr>
</table>
<p>&nbsp;</p>
<table width="700" align="center">
  <tr>
    <td><bean:message bundle="assessment" key="testframeExecMap.mcueintro" /> 
      
      <br></td>
  </tr>
  <tr>
    <td height="20"><div align="center"><strong><font color="#000000"><bean:message bundle="assessment" key="testframeExecMap.mcueintro1" /> </td>
  </tr>
  <tr>
    <td><font color="#000000"> <bean:message bundle="assessment" key="testframe.mcuesoundinstr" /> 
  <tr>
    <td height="44">
    <logic:notEqual name="AssessmentInstForm" property="soundCheck" value="true">
      <input type="checkbox" name="AssessmentInstForm" property ="checkboxValue" disabled="true"/>
      <span class="style4"><span class="style5"><span class="style6"><span class="style7"><span class="style8">
      <bean:message bundle="execmap" key="testframe.testframe.soundcheckbox.mcuesoundchk" />
    </logic:notEqual>
    
    
    <bean:define id="checkbox" name="AssessmentInstForm" property ="checkboxValue"/>
    <logic:equal name="AssessmentInstForm" property="soundCheck" value="true">
      <!--<input type="checkbox" name="checkbox" value="true" checked/>-->
      <html:checkbox name="AssessmentInstForm" property ="checkboxValue" value="false"/>
      <span class="style4"><span class="style5"><span class="style6"><span class="style7"><span class="style8">
      <bean:message bundle="execmap" key="testframe.testframe.soundcheckbox.mcuesoundchk" />
      <SCRIPT>
      setFlag();
      </SCRIPT>
      </logic:equal>
      </td>
  </tr>
</table>
<table  border="0" align="center">
  <tr>
    <td align="center" bgcolor="#FFFFFF">
  <html:submit onclick="javascript:showbutton();enableJavaScript();"><bean:message bundle="execmap" key="generic.next" /></html:submit>
        <c>
</td>
    <td align="center" bgcolor="#FFFFFF">
    <bean:define id="msg">
     <bean:message bundle="execmap" key="generic.Assessment.Cancel" />
     </bean:define>
     <input type="hidden" name="msg" value="<%=(String)msg%>">
          <html:button property="button" onclick="javascript:cancelassessment();enableJavaScript();"><bean:message bundle="execmap" key="generic.cancel" /></html:button>
</td>
  </tr>
</table>
<p>&nbsp;</p>

</html:form>