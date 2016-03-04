<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript">
function enableJavaScript()
{
document.forms[0].enableScript.value="Enabled";

}

   var numericalValue=0;
 function makeNumber(valuePassed)
 {
  numericalValue=numericalValue%5;
	
	for (var i = 0; i<document.forms[0].elements.length; i++) {
        if ((document.forms[0].elements[i].name.indexOf('textbox') > -1)) {
                     if ((document.forms[0].elements[i].name.indexOf(numericalValue) > -1))
					  {
					  		document.forms[0].elements[i].value=valuePassed;
						    
					  }
					}
				}
	numericalValue++;
 	if(numericalValue > 4)
		numericalValue=4;
 }
 function setNumericalValue(valueToSet)
 {
 	numericalValue=valueToSet;
 }
 
function appendNumber(value)
	{
		var currValue=document.forms[0].numberAnswer.value;
		document.forms[0].numberAnswer.value=currValue+value
	}

	function deleteLast()
	{
		var currValue=document.forms[0].numberAnswer.value;
		if(currValue!='')
		{
			var newValue=parseInt(currValue/10);
			if(newValue!=0)
				document.forms[0].numberAnswer.value=newValue;
			else
				document.forms[0].numberAnswer.value='';
		}
}

var paramval;

function incrementpageno()
{
clearTimeout(ticker);
document.forms[0].enableScript.value="Enabled";
var pageno=document.AssessmentMultiForm.pageNo.value;
document.AssessmentMultiForm.pageNo.value=parseInt(pageno)+ 1;
var countno=document.AssessmentMultiForm.nextcount.value;
document.AssessmentMultiForm.nextcount.value=parseInt(countno)+ 1;
document.forms[0].action="/execmap/InitMEMWSX.do";
}
function incrementquestionno()
{
clearTimeout(ticker);
document.forms[0].enableScript.value="Enabled";
var pageno=document.AssessmentMultiForm.pageNo.value;
document.AssessmentMultiForm.pageNo.value=parseInt(pageno)+ 3;
var countno=document.AssessmentMultiForm.nextcount.value;
document.AssessmentMultiForm.nextcount.value=parseInt(countno)+ 1;
document.forms[0].action="/execmap/InitMEMWSX.do";
}

function showinstt()
{
clearTimeout(ticker);
document.forms[0].enableScript.value="Enabled";
document.AssessmentMultiForm.pageNo.value=parseInt("0");
document.forms[0].action="/execmap/InitMEMWSX.do";
}

function resumefrominstruction()
{
clearTimeout(ticker);
document.forms[0].enableScript.value="Enabled";
var pageno=document.AssessmentMultiForm.nextcount.value;
document.AssessmentMultiForm.pageNo.value=parseInt(pageno);
document.forms[0].action="/execmap/InitMEMWSX.do";
}

function finish()
{
clearTimeout(ticker);
document.forms[0].enableScript.value="Enabled";
var boolValue=new Boolean(true);
document.forms[0].nextFinish.value=boolValue.valueOf();
var pageno=document.AssessmentMultiForm.pageNo.value;
document.AssessmentMultiForm.pageNo.value=parseInt(pageno)+ 1;
document.forms[0].action="/execmap/InitMEMWSX.do";
}

function setnavigateQuestion()
{clearTimeout(ticker);
	paramval=obj.value;
	document.forms[0].action="/execmap/InitMEMWSX.do?"+paramval;
}
function countDown1() {
  time--;
  if (time > 0) {
    ticker=setTimeout('countDown1()', 1000);
	document.forms[0].memtimer.value=time;
  } else {
  incrementpageno();
  document.forms[0].submit();
  }                                                               
}

function cannotgoback()
{
document.forms[0].enableScript.value="Enabled";
msg=document.forms[0].msg1.value;
alert(msg);
}	

function CheckNumeric()
{
   // Get ASCII value of key that user pressed
   var key = window.event.keyCode;
 
   // Was key that was pressed a  numeric character
   if (key > 47 && key < 58)
      return; // if so, do nothing
   else
      window.event.returnValue = null; // otherwise, 
                                // discard character
}

</script>                                     
                                      



<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<html:form action="/InitMEMWSX.do">
<bean:define id="AssessmentMultiForm" name="AssessmentMultiForm"/>
<bean:define id="pageNo" name="AssessmentMultiForm" property="pageNo"/>
<bean:define id="nextcount" name="AssessmentMultiForm" property="nextcount"/>
<bean:define id="questionNo" name="AssessmentMultiForm" property="questionNo"/>

<html:hidden name="AssessmentMultiForm" property="pageNo" value="<%=pageNo.toString()%>"/>
<html:hidden name="AssessmentMultiForm" property="nextcount" value="<%=nextcount.toString()%>"/>
<html:hidden name="AssessmentMultiForm" property="questionNo" value="<%=questionNo.toString()%>"/>
<html:hidden name="AssessmentMultiForm" property="nextFinish" value=""/>
<html:hidden name="AssessmentMultiForm" property="timerSet" value=""/>
<html:hidden property="enableScript" value=""/>

<bean:define id="msg">
     <bean:message bundle="execmap" key="generic.Assessment.Cancel" />
     </bean:define>
     <input type="hidden" name="msg" value="<%=(String)msg%>">
<bean:define id="msg1">
<bean:message bundle="execmap" key="generic.Assessment.Dmsx.msg" />
</bean:define>
<input type="hidden" name="msg1" value="<%=(String)msg1%>">

<div align="right">
	<b>
	<html:hidden name="AssessmentMultiForm" property="startCounting"/>
	<html:text name="AssessmentMultiForm" property="timer" size="3" onfocus = "blur();" />&nbsp&nbsp</b>
    <logic:equal name="AssessmentMultiForm" property="startCounting" value="1">
    <logic:notEmpty name="AssessmentMultiForm" property="memtimer">
    <logic:notEqual name="pageNo" value="0">
	<html:text name="AssessmentMultiForm" property="memtimer" size="3" onfocus = "blur();" />&nbsp&nbsp</b>
	<script>
	time = document.forms[0].memtimer.value;	
    countDown1();
	</script>
	</logic:notEqual>
	</logic:notEmpty>
	<script>
		initialize();
	    countDown();
	</script>
	</logic:equal>
 </div>

<logic:notEqual name="pageNo" value="0">
<div align="left">
<b><bean:message bundle="execmap" key="generic.questnolabel" />
   <bean:write name="AssessmentMultiForm" property="questionNo"/></b>
</div>
</logic:notEqual>

<logic:equal name="pageNo" value="0">
<logic:iterate id="choiceinstruction" name="AssessmentMultiForm" property="instruction" length="1">
<b><bean:write name="choiceinstruction"/></b>
</logic:iterate>
<logic:iterate id="choiceinstruction" name="AssessmentMultiForm" property="instruction" offset="1">
<bean:write name="choiceinstruction"/>
</logic:iterate>
</logic:equal>	

<p>&nbsp;</p>

<logic:notEqual name="pageNo" value="0">
<table width="800" >
<tr><td width="50">

<logic:notEqual name="pageNo" value="2">
<logic:notEqual name="pageNo" value="5">
<logic:notEqual name="pageNo" value="8">
	 <table width ="50" border="1">
        <logic:iterate id="choiceinstruction1" name="AssessmentMultiForm" property="navigationlist">
                   <%String val=(String)(""+choiceinstruction1);%>
                   <tr><td align="center">
			                 <logic:lessEqual name="AssessmentMultiForm" property="questionNo" value="<%=val%>">
			                 <BIG><b>
			                 <bean:write name="choiceinstruction1"/>
			                 </b></BIG>
							</logic:lessEqual >
							
							<logic:greaterThan name="AssessmentMultiForm" property="questionNo" value="<%=val%>">
							
							<html:link  href="javascript:cannotgoback();">
                            <b><bean:write name="choiceinstruction1"/></b>
							</html:link>
							</logic:greaterThan>
	                 </td></tr>
	     </logic:iterate>
	</table>
</logic:notEqual>
</logic:notEqual>
</logic:notEqual>



</td>
<td>
<logic:notEqual name="pageNo" value="1">
<logic:notEqual name="pageNo" value="3">
<logic:notEqual name="pageNo" value="4">
<logic:notEqual name="pageNo" value="6">
<logic:notEqual name="pageNo" value="7">
<logic:notEqual name="pageNo" value="9">
<logic:notEqual name="pageNo" value="10">
<div align="center">
		 <span class="style2">
         <bean:write name="AssessmentMultiForm" property="answerInstruction"/>
         </span>
</logic:notEqual>
</logic:notEqual>
</logic:notEqual>
</logic:notEqual>
</logic:notEqual>
</logic:notEqual>
</logic:notEqual>


<logic:notEqual name="pageNo" value="2">
<logic:notEqual name="pageNo" value="5">
<logic:notEqual name="pageNo" value="8">
<div align="center">
         <span class="style6">
         <bean:write name="AssessmentMultiForm" property="answerInstruction"/>
         </span>
</div>
</logic:notEqual>
</logic:notEqual>
</logic:notEqual>

<p>&nbsp;</p>

<logic:notEmpty name="AssessmentMultiForm" property="textOrUrl">
<logic:notEqual name="pageNo" value="4">
<logic:notEqual name="pageNo" value="1">
<logic:iterate id="choiceinstruction" name="AssessmentMultiForm" property="textOrUrl">
<bean:define id="choiceinstruction1" name="AssessmentMultiForm" property="textOrUrl"/>
<bean:define id="choice" name="choiceinstruction"/>

</div>
</logic:iterate>
</logic:notEqual>
</logic:notEqual>
</logic:notEmpty>



<logic:equal name="pageNo" value="1">
<logic:notEmpty name="AssessmentMultiForm" property="textOrUrl">
<logic:iterate id="number" name="AssessmentMultiForm" property="textOrUrl">
<b><div align="center">
<span class="style2"><bean:write name="number"/></span>
<div/>
</b>
</logic:iterate>
</logic:notEmpty>
</logic:equal>

<logic:equal name="pageNo" value="4">
<logic:notEmpty name="AssessmentMultiForm" property="textOrUrl">
<logic:iterate id="number" name="AssessmentMultiForm" property="textOrUrl">
<b><div align="center">
<span class="style2"><bean:write name="number"/></span>
<div/>
</b>
</logic:iterate>
</logic:notEmpty>
</logic:equal>



<logic:notEqual name="pageNo" value="0">
<logic:notEqual name="pageNo" value="1">
<logic:notEqual name="pageNo" value="2">
<logic:notEqual name="pageNo" value="4">
<logic:notEqual name="pageNo" value="5">
<logic:notEqual name="pageNo" value="7">
<logic:notEqual name="pageNo" value="8">
<logic:notEqual name="pageNo" value="9">
<logic:notEqual name="pageNo" value="10">

<div align="center">
<P>
<html:text name="AssessmentMultiForm" property="textbox0" maxlength="1" onkeypress="CheckNumeric();" onclick="javascript:setNumericalValue(0);" size="1"/>
<html:text name="AssessmentMultiForm" property="textbox1" maxlength="1" onkeypress="CheckNumeric();" onclick="javascript:setNumericalValue(1);" size="1"/>
<html:text name="AssessmentMultiForm" property="textbox2" maxlength="1" onkeypress="CheckNumeric();" onclick="javascript:setNumericalValue(2);" size="1"/>
<html:text name="AssessmentMultiForm" property="textbox3" maxlength="1" onkeypress="CheckNumeric();" onclick="javascript:setNumericalValue(3);" size="1"/>
<logic:equal name="pageNo" value="6">
<html:text name="AssessmentMultiForm" property="textbox4" maxlength="1" onkeypress="CheckNumeric();" onclick="javascript:setNumericalValue(4);" size="1"/>
</logic:equal>


</P><P>
<html:button onclick="javascript:makeNumber(0);" value="0" property="0"/>
<html:button onclick="javascript:makeNumber(1);" value="1" property="1"/>
<html:button onclick="javascript:makeNumber(2);" value="2" property="2"/>
<html:button onclick="javascript:makeNumber(3);" value="3" property="3"/>
<html:button onclick="javascript:makeNumber(4);" value="4" property="4"/>
<html:button onclick="javascript:makeNumber(5);" value="5" property="5"/>
<html:button onclick="javascript:makeNumber(6);" value="6" property="6"/>
<html:button onclick="javascript:makeNumber(7);" value="7" property="7"/>
<html:button onclick="javascript:makeNumber(8);" value="8" property="8"/>
<html:button onclick="javascript:makeNumber(9);" value="9" property="9"/>
 </P>
<div align="center">

</logic:notEqual>
</logic:notEqual>
</logic:notEqual>
</logic:notEqual>
</logic:notEqual>
</logic:notEqual>
</logic:notEqual>
</logic:notEqual>
</logic:notEqual>




<logic:greaterThan name="pageNo" value="6">
<logic:notEmpty name="AssessmentMultiForm" property="questionOptions">
<% int choiceCount=1;%>
<table width="400" align="center">
<logic:iterate id="choice" name="AssessmentMultiForm" property="questionOptions">
<tr><td>
<logic:notEqual name="pageNo" value="7">
 <html:radio name="AssessmentMultiForm" property="answerNo" value="<%=(""+choiceCount++)%>"/>
 </logic:notEqual>
<b><bean:write name="choice"/></b>
</td></tr>
</logic:iterate>
</table>
</logic:notEmpty>
</logic:greaterThan>


<p>&nbsp;</p>

</td></tr>
</table>
</logic:notEqual>

<logic:equal name="pageNo" value="0">
<b><bean:write name="AssessmentMultiForm" property="answerInstruction"/></b>
</logic:equal>

<p>&nbsp;</p>
<div align="center">

<logic:notEqual name="AssessmentMultiForm" property="nextcount" value="0">
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
<logic:notEqual name="pageNo" value="2">
<logic:notEqual name="pageNo" value="5">
<logic:notEqual name="pageNo" value="8">
<html:submit onclick="javascript:showinstt();enableJavaScript();"><bean:message bundle="execmap" key="subtest.subtest.instructionbutton.instruction" /></html:submit>
</logic:notEqual>
</logic:notEqual>
</logic:notEqual>
</logic:notEqual>

<logic:notEqual name="pageNo" value="2">
<logic:notEqual name="pageNo" value="5">
<logic:notEqual name="pageNo" value="8">
<html:button property="button" onclick="javascript:cancelassessment();enableJavaScript();"><bean:message bundle="execmap" key="generic.cancel" /></html:button>
</logic:notEqual>
</logic:notEqual>
</logic:notEqual>

<logic:notEqual name="pageNo" value="0">
<logic:notEqual name="pageNo" value="2">
<logic:notEqual name="pageNo" value="5">
<logic:notEqual name="pageNo" value="7">
<logic:notEqual name="pageNo" value="8">
<logic:notEqual name="pageNo" value="10">


<logic:notEqual name="pageNo" value="3">
<logic:notEqual name="pageNo" value="6">
<logic:notEqual name="pageNo" value="9">
<logic:equal name="AssessmentMultiForm" property="urlsetflag" value="false">
<html:submit onclick="javascript:incrementquestionno();enableJavaScript();"><bean:message bundle="execmap" key="generic.next" /></html:submit>
</logic:equal>
</logic:notEqual>
</logic:notEqual>
</logic:notEqual>


<logic:notEqual name="pageNo" value="1">
<logic:notEqual name="pageNo" value="4">
<logic:notEqual name="pageNo" value="7">
<logic:equal name="AssessmentMultiForm" property="urlsetflag" value="false">
<html:submit onclick="javascript:incrementpageno();enableJavaScript();"><bean:message bundle="execmap" key="generic.next" /></html:submit>
</logic:equal>
</logic:notEqual>
</logic:notEqual>
</logic:notEqual>

</logic:notEqual>
</logic:notEqual>
</logic:notEqual>
</logic:notEqual>
</logic:notEqual>
</logic:notEqual>

<logic:equal name="AssessmentMultiForm" property="urlsetflag" value="true">
<html:submit onclick="javascript:resumefrominstruction();enableJavaScript();"><bean:message bundle="execmap" key="generic.resume" /></html:submit>
</logic:equal>

<logic:notEqual name="pageNo" value="0">
<logic:notEqual name="pageNo" value="2">
<logic:notEqual name="pageNo" value="5">
<logic:notEqual name="pageNo" value="8">
<html:submit onclick="javascript:finish();enableJavaScript();"><bean:message bundle="execmap" key="generic.finish" /></html:submit>
</logic:notEqual>
</logic:notEqual>
</logic:notEqual>
</logic:notEqual>

</div>
</html:form>