<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

                                        

<script type="text/javascript">
function enableJavaScript()
{
document.forms[0].enableScript.value="Enabled";

}
var paramval;

function incrementpageno()
{
clearTimeout(ticker);
document.forms[0].enableScript.value="Enabled";
var pageno=document.AssessmentForm.pageNo.value;
document.AssessmentForm.pageNo.value=parseInt(pageno)+ 1;
var countno=document.AssessmentForm.nextcount.value;
document.AssessmentForm.nextcount.value=parseInt(countno)+ 1;
document.forms[0].action="/execmap/InitESCX.do";
}

function showinstt()
{
clearTimeout(ticker);
document.forms[0].enableScript.value="Enabled";
document.AssessmentForm.pageNo.value=parseInt("0");
document.forms[0].action="/execmap/InitESCX.do";
}

function resumefrominstruction()
{
clearTimeout(ticker);
document.forms[0].enableScript.value="Enabled";
var pageno=document.AssessmentForm.nextcount.value;
document.AssessmentForm.pageNo.value=parseInt(pageno);
document.forms[0].action="/execmap/InitESCX.do";
}

function finish()
{
clearTimeout(ticker);
document.forms[0].enableScript.value="Enabled";
var boolValue=new Boolean(true);
document.forms[0].nextFinish.value=boolValue.valueOf();
var pageno=document.AssessmentForm.pageNo.value;
document.AssessmentForm.pageNo.value=parseInt(pageno)+ 1;
document.forms[0].action="/execmap/InitESCX.do";
}

function setnavigateQuestion()
{clearTimeout(ticker);
	document.forms[0].enableScript.value="Enabled";
	paramval=obj.value;
	document.forms[0].action="/execmap/InitESCX.do?"+paramval;
}

function linkfunction(val){
clearTimeout(ticker);
document.forms[0].enableScript.value="Enabled";
var boolValue=new Boolean(true);
document.forms[0].urlsetflag.value=boolValue.valueOf();
document.AssessmentForm.pageNo.value=val;
document.forms[0].action="/execmap/InitESCX.do";
document.forms[0].submit();
}
</script>                                     
                                        


<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<html:form action="/InitESCX.do">
<bean:define id="AssessmentForm" name="AssessmentForm"/>
<bean:define id="pageNo" name="AssessmentForm" property="pageNo"/>
<bean:define id="nextcount" name="AssessmentForm" property="nextcount"/>
<bean:define id="questionNo" name="AssessmentForm" property="questionNo"/>

<html:hidden name="AssessmentForm" property="questionNo" value="<%=questionNo.toString()%>"/>
<html:hidden name="AssessmentForm" property="pageNo" value="<%=pageNo.toString()%>"/>
<html:hidden name="AssessmentForm" property="nextcount" value="<%=nextcount.toString()%>"/>
<html:hidden name="AssessmentForm" property="nextFinish" value=""/>
<html:hidden name="AssessmentForm" property="timerSet" value=""/>
<html:hidden name="AssessmentForm" property="urlsetflag" value=""/>
<html:hidden property="enableScript" value=""/>

<div align="right">
	<b>
	<html:hidden name="AssessmentForm" property="startCounting"/>
	<html:text name="AssessmentForm" property="timer" size="3" onfocus = "blur();" />&nbsp&nbsp</b>
    <logic:equal name="AssessmentForm" property="startCounting" value="1">
	
	<script>
	initialize();
	countDown();
	</script>
	</logic:equal>
</div>

<logic:notEqual name="pageNo" value="0">
<div align="left">
<b><bean:message bundle="execmap" key="generic.questnolabel" />
   <bean:write name="AssessmentForm" property="questionNo"/></b>
</div>
</logic:notEqual>

<logic:equal name="pageNo" value="0">
<logic:iterate id="instruction" name="AssessmentForm" property="instruction" length="1">
<b><bean:write name="instruction"/></b>
</logic:iterate>
<logic:iterate id="instruction" name="AssessmentForm" property="instruction" length="1" offset="1">
<bean:write name="instruction"/>
</logic:iterate>

</logic:equal>	
<p>&nbsp;</p>

<logic:iterate id="questImgPath" name="AssessmentForm" property="textOrUrl">
<table width="935" border="0">
  <tr>
    <td width="100">
    
     <logic:notEqual name="pageNo" value="0">
     <table width ="50" border="1">
        <logic:iterate id="choiceinstruction1" name="AssessmentForm" property="navigationlist">
                   <%String val=(String)(""+choiceinstruction1);%>
                   <tr><td align="center">
			                 <logic:lessEqual name="AssessmentForm" property="nextcount" value="<%=val%>">
			                 <b>
			                 <bean:write name="choiceinstruction1"/>
			                 </b>
							</logic:lessEqual >
							
							<logic:greaterThan name="AssessmentForm" property="nextcount" value="<%=val%>">
							<bean:define id="linkImageUrl" name="AssessmentForm" property="linkImageUrl"/>
                            <img src="<%=linkImageUrl%><%=val%>.jpg "  onclick="javascript:linkfunction('<%=val%>');">
							</logic:greaterThan>
	                 </td></tr>
	     </logic:iterate>
	</table>
    </logic:notEqual>
    
<table width ="350">   

<logic:equal name="pageNo" value="0">
<logic:iterate id="instruction" name="AssessmentForm" property="instruction" offset="2">
<tr><td>
<bean:write name="instruction"/>
</td></tr>
</logic:iterate>
</logic:equal>	

</table>    
    
    
    </td>
    <td width="300">
    <div align="left">
    <img src="<%=questImgPath%>">
    </div>
    </td><td align="left">
    <logic:notEqual name="pageNo" value="0">
    <span class="style4" align="center">
    <bean:write name="AssessmentForm" property="answerInstruction"/>
    </span>
    </logic:notEqual>
    </td>
    
  </tr>
</table>
</logic:iterate >

<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td align="center">
  <logic:notEqual name="pageNo" value="0">
  <% int choiceCount=1;%>
  <bean:define id="questionOptions" name="AssessmentForm" property="questionOptions"/>
  <div align="center">
      <logic:iterate id="choice" name="questionOptions">
     	       <html:radio name="AssessmentForm" property="answerNo" value="<%=(""+choiceCount++)%>"/>
           <bean:write name="choice"/>
    </logic:iterate>
  </div>
  </logic:notEqual></td>
<tr>
</table>
<p>&nbsp;</p>

<logic:equal name="pageNo" value="0">
<b><bean:write name="AssessmentForm" property="answerInstruction"/></b>
</logic:equal>
<p>&nbsp;</p>



<div align="center">
<logic:notEqual name="AssessmentForm" property="nextcount" value="0">
<logic:equal name="pageNo" value="0">
<html:submit onclick="javascript:resumefrominstruction();enableJavaScript();"><bean:message bundle="execmap" key="generic.resume" /></html:submit>
</logic:equal>
</logic:notEqual>

<logic:equal name="pageNo" value="0">
<logic:equal name="nextcount" value="0">
<html:submit onclick="javascript:incrementpageno();enableJavaScript();"><bean:message bundle="execmap" key="generic.start_now" /></html:submit>
</logic:equal>
</logic:equal>

<logic:notEqual name="pageNo" value="0">
<html:submit onclick="javascript:showinstt();enableJavaScript();"><bean:message bundle="execmap" key="subtest.subtest.instructionbutton.instruction" /></html:submit>
</logic:notEqual>

<bean:define id="msg">
     <bean:message bundle="execmap" key="generic.Assessment.Cancel" />
     </bean:define>
     <input type="hidden" name="msg" value="<%=(String)msg%>">
<html:button property="button" property="button" onclick="javascript:cancelassessment();enableJavaScript();"><bean:message bundle="execmap" key="generic.cancel" /></html:button>



<logic:notEqual name="pageNo" value="0">
<logic:notEqual name="pageNo" value="6">
<logic:equal name="AssessmentForm" property="urlsetflag" value="false">
<html:submit onclick="javascript:incrementpageno();enableJavaScript();"><bean:message bundle="execmap" key="generic.next" /></html:submit>
</logic:equal>
</logic:notEqual>
</logic:notEqual>

<logic:equal name="AssessmentForm" property="urlsetflag" value="true">
<html:submit onclick="javascript:resumefrominstruction();enableJavaScript();"><bean:message bundle="execmap" key="generic.resume" /></html:submit>
</logic:equal>

<logic:notEqual name="pageNo" value="0">
<html:submit onclick="javascript:finish();enableJavaScript();"><bean:message bundle="execmap" key="generic.finish" /></html:submit>
</logic:notEqual>

</div>
</html:form>