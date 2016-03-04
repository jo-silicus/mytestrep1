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
var pageno=document.AssessmentMultiForm.pageNo.value;
document.AssessmentMultiForm.pageNo.value=parseInt(pageno)+ 1;

var countno=document.AssessmentMultiForm.nextcount.value;
document.AssessmentMultiForm.nextcount.value=parseInt(countno)+ 1;

var boolValue=new Boolean(true);
document.forms[0].nextButtonCheck.value=boolValue.valueOf();

var boolValue1=new Boolean(true);
document.AssessmentMultiForm.dmsFlag.value=boolValue1.valueOf();

var boolValue=new Boolean(true);
document.AssessmentMultiForm.dmsResumeFlag.value=boolValue.valueOf();

document.forms[0].action="/execmap/InitDMSX.do";

}

function showinstt()
{
clearTimeout(ticker);
var boolValue1=new Boolean(false);
document.AssessmentMultiForm.dmsFlag.value=boolValue1.valueOf();
document.AssessmentMultiForm.pageNo.value=parseInt("0");
var boolValue1=new Boolean(true);
document.AssessmentMultiForm.dmsResumeFlag.value=boolValue1.valueOf();
document.forms[0].enableScript.value="Enabled";

document.forms[0].action="/execmap/InitDMSX.do";
}

function showinstt1()
{
clearTimeout(ticker);
var boolValue1=new Boolean(true);
document.AssessmentMultiForm.dmsFlag.value=boolValue1.valueOf();
var boolValue1=new Boolean(false);
document.AssessmentMultiForm.dmsResumeFlag.value=boolValue1.valueOf();
document.forms[0].enableScript.value="Enabled";
document.AssessmentMultiForm.pageNo.value=parseInt("0");
document.forms[0].action="/execmap/InitDMSX.do";
}

function resumefrominstruction()
{
clearTimeout(ticker);
document.forms[0].enableScript.value="Enabled";
var boolValue1=new Boolean(true);
document.AssessmentMultiForm.dmsResumeFlag.value=boolValue1.valueOf();
var pageno=document.AssessmentMultiForm.nextcount.value;
document.AssessmentMultiForm.pageNo.value=parseInt(pageno);
document.forms[0].action="/execmap/InitDMSX.do";
}

function resumeinstruction1()
{
document.forms[0].enableScript.value="Enabled";
clearTimeout(ticker);
var boolValue1=new Boolean(false);
document.AssessmentMultiForm.dmsResumeFlag.value=boolValue1.valueOf();

var boolValue=new Boolean(true);
document.AssessmentMultiForm.dmsInstructionFlag.value=boolValue.valueOf();

var pageno=document.AssessmentMultiForm.nextcount.value;
document.AssessmentMultiForm.pageNo.value=parseInt(pageno);

document.forms[0].action="/execmap/InitDMSX.do";
}

function finish()
{
clearTimeout(ticker);
document.forms[0].enableScript.value="Enabled";

var pageno=document.AssessmentMultiForm.pageNo.value;
document.AssessmentMultiForm.pageNo.value=parseInt(pageno)+ 1;

var boolValue=new Boolean(true);
document.forms[0].nextFinish.value=boolValue.valueOf();

var boolValue1=new Boolean(true);
document.AssessmentMultiForm.dmsFlag.value=boolValue1.valueOf();
document.forms[0].action="/execmap/InitDMSX.do";
}

function setnavigateQuestion()
{
    clearTimeout(ticker);
    document.forms[0].enableScript.value="Enabled";
	paramval=obj.value;
	document.forms[0].action="/execmap/InitDMSX.do?"+paramval;
}


function radioaction()
{
clearTimeout(ticker);
document.forms[0].enableScript.value="Enabled";
var boolValue=new Boolean(false);
document.forms[0].dmsFlag.value=boolValue.valueOf();

document.forms[0].action="/execmap/InitDMSX.do";
document.forms[0].submit();
}

function cannotgoback()
{
document.forms[0].enableScript.value="Enabled";
msg=document.forms[0].msg1.value;
alert(msg);
}
</script>                                     
                                      


<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<html:form action="/InitDMSX.do">
<bean:define id="AssessmentMultiForm" name="AssessmentMultiForm"/>
<bean:define id="pageNo" name="AssessmentMultiForm" property="pageNo"/>
<bean:define id="nextcount" name="AssessmentMultiForm" property="nextcount"/>
<bean:define id="questionNo" name="AssessmentMultiForm" property="questionNo"/>
<html:hidden name="AssessmentMultiForm" property="pageNo" value="<%=pageNo.toString()%>"/>
<html:hidden name="AssessmentMultiForm" property="nextcount" value="<%=nextcount.toString()%>"/>
<html:hidden name="AssessmentMultiForm" property="questionNo" value="<%=questionNo.toString()%>"/>
<html:hidden name="AssessmentMultiForm" property="dmsFlag" value=""/>

<html:hidden name="AssessmentMultiForm" property="dmsInstructionFlag" value=""/>
<html:hidden name="AssessmentMultiForm" property="dmsResumeFlag" value=""/>
<html:hidden name="AssessmentMultiForm" property="nextFinish" value=""/>
<html:hidden name="AssessmentMultiForm" property="timerSet" value=""/>
<html:hidden property="enableScript" value=""/>
<html:hidden name="AssessmentMultiForm" property="nextButtonCheck" value=""/>



<bean:define id="msg1">
<bean:message bundle="execmap" key="generic.Assessment.Dmsx.msg" />
</bean:define>
<input type="hidden" name="msg1" value="<%=(String)msg1%>">

<div align="right">
	<b>
	<html:hidden name="AssessmentMultiForm" property="startCounting"/>
	<html:text name="AssessmentMultiForm" property="timer" size="3" onfocus = "blur();" />
	<bean:message bundle="execmap" key="Assessment.label.secRemaining" />&nbsp&nbsp</b>
    <logic:equal name="AssessmentMultiForm" property="startCounting" value="1">
	
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
<logic:iterate id="instruction" name="AssessmentMultiForm" property="instruction" length="1">
<big>
<b><bean:write name="instruction"/></b>
</big>
</logic:iterate>
<logic:iterate id="instruction" name="AssessmentMultiForm" property="instruction" length="3" offset="1">
<big>
<bean:write name="instruction"/>
</big>
</logic:iterate>
</logic:equal>	




<table width="935">
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;
    <logic:notEqual name="pageNo" value="0">
    
	 <table width ="50" border="1">
        <logic:iterate id="choiceinstruction1" name="AssessmentMultiForm" property="navigationlist">
                   <%String val=(String)(""+choiceinstruction1);%>
                   <tr><td align="center">
			                 <logic:lessEqual name="AssessmentMultiForm" property="nextcount" value="<%=val%>">
			                 <BIG><b>
			                 <bean:write name="choiceinstruction1"/>
			                 </b></BIG>
							</logic:lessEqual >
							
							<logic:greaterThan name="AssessmentMultiForm" property="nextcount" value="<%=val%>">
							
							<html:link  href="javascript:cannotgoback();">
                            <b><bean:write name="choiceinstruction1"/></b>
							</html:link>
							</logic:greaterThan>
	                 </td></tr>
	     </logic:iterate>
	</table>
    </logic:notEqual>

</td>
<td>
<logic:notEqual name="pageNo" value="0">
<table width="600" height="96" border="1" align="center">
            <tr>         
            
              <td align="center">
         				<logic:iterate id="choicetextorurl" name="AssessmentMultiForm" property="textOrUrl">
         				<b><BIG>
                        <bean:write name="choicetextorurl"/>
                        </BIG>
                        <br>
                        </span>
                        </logic:iterate>
               </td>
            </tr>
 </table>
</logic:notEqual>
</td></tr>
</table>

<logic:notEqual name="pageNo" value="0">
<logic:iterate id="choiceinstruction" name="AssessmentMultiForm" property="instruction">
<div align="center">
<BIG>
<bean:write name="choiceinstruction"/>
</BIG>
</div>
</logic:iterate>
</logic:notEqual>

<logic:equal name="pageNo" value="0">
<br><br><br><br><br><br>
<big><b>
<bean:write name="AssessmentMultiForm" property="answerInstruction"/>
</b></big>

</logic:equal>


<table align = "center">
  <logic:notEqual name="pageNo" value="0">
   <% int choiceCount1=1;%>
   <% int choiceCount2=1;%>
  <bean:define id="questionOptions" name="AssessmentMultiForm" property="questionOptions"/>
    <tr><div align ="center">
    <logic:iterate id="choice" name="questionOptions">
       <tr><td>
       <logic:equal name="AssessmentMultiForm" property="dmsResumeFlag"  value="true">
           <html:radio name="AssessmentMultiForm" property="dmsStartPosition"  value="<%=(""+choiceCount1++)%>" onclick="javascript:radioaction();"/>
           <BIG>
           <bean:write name="choice"/>
           </BIG>
          </logic:equal>
           <logic:equal name="AssessmentMultiForm" property="dmsResumeFlag"  value="false">
           <html:hidden name="AssessmentMultiForm" property="dmsStartPosition"/>
           <html:radio name="AssessmentMultiForm" property="dmsEndPosition"  value="<%=(""+choiceCount2++)%>"/>
           <BIG>
           <bean:write name="choice"/>
           </BIG>
           </logic:equal>
           <br>
         </td></tr>
    </logic:iterate>
    </div></tr>
  </logic:notEqual>&nbsp;</td>
</table>
<p>&nbsp;</p>

<div align="center">

<logic:notEqual name="AssessmentMultiForm" property="nextcount" value="0">
<logic:equal name="pageNo" value="0">
<logic:equal name="AssessmentMultiForm" property="dmsResumeFlag"  value="true">
<html:submit onclick="javascript:resumefrominstruction();enableJavaScript();"><bean:message bundle="execmap" key="generic.resume" /></html:submit>
</logic:equal>
</logic:equal>
</logic:notEqual>


<logic:notEqual name="AssessmentMultiForm" property="nextcount" value="0">
<logic:equal name="pageNo" value="0">
<logic:equal name="AssessmentMultiForm" property="dmsResumeFlag"  value="false">
<html:submit onclick="javascript:resumeinstruction1();enableJavaScript();"><bean:message bundle="execmap" key="generic.resume" /></html:submit>
</logic:equal>
</logic:equal>
</logic:notEqual>

<logic:equal name="pageNo" value="0">
<logic:equal name="nextcount" value="0">
<html:submit onclick="javascript:incrementpageno();enableJavaScript();"><bean:message bundle="execmap" key="generic.start_now" /></html:submit>
</logic:equal>
</logic:equal>

<logic:notEqual name="pageNo" value="0">
<logic:equal name="AssessmentMultiForm" property="dmsResumeFlag"  value="true">
<html:submit onclick="javascript:showinstt();enableJavaScript();"><bean:message bundle="execmap" key="subtest.subtest.instructionbutton.instruction" /></html:submit>
</logic:equal>
</logic:notEqual>

<logic:notEqual name="pageNo" value="0">
<logic:equal name="AssessmentMultiForm" property="dmsResumeFlag"  value="false">
<html:submit onclick="javascript:showinstt1();enableJavaScript();"><bean:message bundle="execmap" key="subtest.subtest.instructionbutton.instruction" /></html:submit>
</logic:equal>
</logic:notEqual>

<bean:define id="msg">
     <bean:message bundle="execmap" key="generic.Assessment.Cancel" />
     </bean:define>
     <input type="hidden" name="msg" value="<%=(String)msg%>">
<html:button property="button" onclick="javascript:cancelassessment();enableJavaScript();"><bean:message bundle="execmap" key="generic.cancel" /></html:button>



<logic:notEqual name="pageNo" value="0">
<logic:notEqual name="pageNo" value="3">
<logic:equal name="AssessmentMultiForm" property="urlsetflag" value="false">
<html:submit onclick="javascript:incrementpageno();enableJavaScript();"><bean:message bundle="execmap" key="generic.next" /></html:submit>
</logic:equal>
</logic:notEqual>
</logic:notEqual>

<logic:equal name="AssessmentMultiForm" property="urlsetflag" value="true">
<logic:equal name="AssessmentMultiForm" property="dmsResumeFlag"  value="true">
<html:submit onclick="javascript:resumefrominstruction();enableJavaScript();"><bean:message bundle="execmap" key="generic.resume" /></html:submit>
</logic:equal>
</logic:equal>

<logic:equal name="AssessmentMultiForm" property="urlsetflag" value="true">
<logic:equal name="AssessmentMultiForm" property="dmsResumeFlag"  value="false">
<html:submit onclick="javascript:resumeinstruction1();enableJavaScript();"><bean:message bundle="execmap" key="generic.resume" /></html:submit>
</logic:equal>
</logic:equal>

<logic:notEqual name="pageNo" value="0">
<html:submit onclick="javascript:finish();enableJavaScript();"><bean:message bundle="execmap" key="generic.finish" /></html:submit>
</logic:notEqual>
</div>
</html:form>