<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<script type="text/javascript">

function enableJavaScript()
{
document.forms[0].enableScript.value="Enabled";

}

function notAllowed()
{
msg1=document.forms[0].msg1.value;
alert(msg1);
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

<html:form action="/showinstruction">

<bean:define id="soundCheck" name="AssessmentInstForm" property="soundCheck"/>
<html:hidden name="AssessmentInstForm" property="soundCheck" value=""/>
<html:hidden name="AssessmentInstForm" property="checkFlagsoundset" value=""/>
<html:hidden property="enableScript" value=""/>
<SCRIPT>
var OpSys = checkOS();
</SCRIPT>
 <FONT COLOR="#FF0000"><html:errors/></font><%@ page language="java" %>
<table align="center">
  <tr>
    <td><div align="center">
    <span class="style4">
    <bean:message bundle="execmap" key="testframe.testframe.lblhead.mcuewelcome" />
        <bean:message bundle="execmap" key="generic.execmap" />
        </span>
    </div>
    </td>
  </tr>
<p>&nbsp;</p>
  <tr><td>
          <bean:message bundle="execmap" key="testframe.testframe.instr2.mcuebtnexp" />
  </td></tr>
</table>

<bean:define id="msg1">
     <bean:message bundle="execmap" key="testmanager.testmanager.startflagnottrue.mcuenopermission" />
     </bean:define>
     <input type="hidden" name="msg1" value="<%=(String)msg1%>">


<logic:equal name="AssessmentInstForm" property="failFlag" value="1">
<script>
 notAllowed();
 </script>
</logic:equal>


<table width="705" height="356" border="0" align="center" cellspacing="15" bordercolor="#000000">
<tr>
 <td width="150">
<html:button property="button"><bean:message bundle="execmap" key="subtest.subtest.instructionbutton.instruction" /></html:button>
 </td>
 <td width="500"><bean:message bundle="execmap" key="testframe.testframe.instructionlabel.mcueinstrwin" />
 </td>
 </tr>
 <tr>
 <td width="150">
<html:button property="button"><bean:message bundle="execmap" key="generic.resume" /></html:button>
 </td>
  <td width ="500"><bean:message bundle="execmap" key="testframe.testframe.backlabel.mcueresumequest" />
 </td>
 
 </tr>
 
 <tr>
 <td width="150">
<html:button property="button"><bean:message bundle="execmap" key="generic.next" /></html:button>
 </td>
  <td width="500"><bean:message bundle="execmap" key="testframe.testframe.nextlabel.mcuenextquest" />
 </td>
 
 </tr>
 <tr>
 <td width="150">
<html:button property="button"><bean:message bundle="execmap" key="generic.play_sound" /></html:button>
 </td>
 <td width="500"><bean:message bundle="execmap" key="testframe.testframe.soundlabel.mcuestartsound" />
 </td>
 </tr>
 <tr>
 <td width="150">
<html:button property="button"><bean:message bundle="execmap" key="generic.start_now" /></html:button>
 </td>
 <td width="500"><bean:message bundle="execmap" key="testframe.testframe.startlabel.mcuestartactivity" />
 </td>
 </tr>
 <tr>
 <td width="150">
<html:button property="button"><bean:message bundle="execmap" key="generic.submit" /></html:button>
 </td>
 <td width="500"><bean:message bundle="execmap" key="testframe.testframe.submitlabel.mcuesubmit" />
 </td>
 </tr>
 <tr>
 <td width="150">

<html:button property="button"><bean:message bundle="execmap" key="generic.cancel" /></html:button>
 </td>
 <td width="500"><bean:message bundle="execmap" key="testframe.testframe.cancellabel.mcuecancel" />
 </td>
  </tr>
</table>

<table width="705" align="center">
<tr><td>
<bean:message bundle="assessment" key="testframe.button.instr" />
</tr></td>
</table>

  <table border="0" align="center">
  <tr>
    <td>     
        <div align="center">
    	<html:submit onclick="javascript:beginassessment();enableJavaScript();"><bean:message bundle="execmap" key="generic.previous" /></html:submit>	    
	         </div>
   </td>
    <bean:define id="msg">
     <bean:message bundle="execmap" key="generic.Assessment.Cancel" />
     </bean:define>
     <input type="hidden" name="msg" value="<%=(String)msg%>">
    <td>
        <div align="center">
        <html:button property="button" onclick="javascript:cancelassessment();enableJavaScript();"><bean:message bundle="execmap" key="generic.cancel" /></html:button>
         </div>
    </td>
    <td>
        <div align="center">
        <html:submit onclick="javascript:startassessment();enableJavaScript();"><bean:message bundle="execmap" key="generic.start" /></html:submit>
         </div>
    </td>
    
  </tr>
</table>

</html:form>