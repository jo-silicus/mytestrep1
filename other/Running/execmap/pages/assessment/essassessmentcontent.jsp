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
document.forms[0].action="/execmap/InitESSX.do";
}

function showinstt()
{
clearTimeout(ticker);
document.forms[0].enableScript.value="Enabled";
document.AssessmentMultiForm.pageNo.value=parseInt("0");
document.forms[0].action="/execmap/InitESSX.do";
}

function resumefrominstruction()
{
clearTimeout(ticker);
document.forms[0].enableScript.value="Enabled";
var pageno=document.AssessmentMultiForm.nextcount.value;
document.AssessmentMultiForm.pageNo.value=parseInt(pageno);
document.forms[0].action="/execmap/InitESSX.do";
}

function finish()
{
clearTimeout(ticker);
document.forms[0].enableScript.value="Enabled";
var boolValue=new Boolean(true);
document.forms[0].nextFinish.value=boolValue.valueOf();
var pageno=document.AssessmentMultiForm.pageNo.value;
document.AssessmentMultiForm.pageNo.value=parseInt(pageno)+ 1;
document.forms[0].action="/execmap/InitESSX.do";
}

function setnavigateQuestion()
{clearTimeout(ticker);
	paramval=obj.value;
	document.forms[0].action="/execmap/InitESSX.do?"+paramval;
}

function linkfunction(val){
clearTimeout(ticker);
document.forms[0].enableScript.value="Enabled";
var boolValue=new Boolean(true);
document.forms[0].urlsetflag.value=boolValue.valueOf();
document.AssessmentMultiForm.pageNo.value=val;
document.forms[0].action="/execmap/InitESSX.do";
document.forms[0].submit();
}
</script>                                     
                                      


<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<html:form action="/InitESSX.do">
<bean:define id="AssessmentMultiForm" name="AssessmentMultiForm"/>
<bean:define id="pageNo" name="AssessmentMultiForm" property="pageNo"/>
<bean:define id="nextcount" name="AssessmentMultiForm" property="nextcount"/>
<bean:define id="questionNo" name="AssessmentMultiForm" property="questionNo"/>

<html:hidden name="AssessmentMultiForm" property="pageNo" value="<%=pageNo.toString()%>"/>
<html:hidden name="AssessmentMultiForm" property="nextcount" value="<%=nextcount.toString()%>"/>
<html:hidden name="AssessmentMultiForm" property="questionNo" value="<%=questionNo.toString()%>"/>
<html:hidden name="AssessmentMultiForm" property="nextFinish" value=""/>
<html:hidden name="AssessmentMultiForm" property="timerSet" value=""/>
<html:hidden name="AssessmentForm" property="urlsetflag" value=""/>
<html:hidden property="enableScript" value=""/>

<div align="right">
	<b>
	<html:hidden name="AssessmentMultiForm" property="startCounting"/>
	<html:text name="AssessmentMultiForm" property="timer" size="3" onfocus = "blur();" />&nbsp&nbsp</b>
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
<logic:iterate id="choiceinstruction" name="AssessmentMultiForm" property="instruction" length="1">
<b><bean:write name="choiceinstruction"/></b>
</logic:iterate>
<logic:iterate id="choiceinstruction" name="AssessmentMultiForm" property="instruction" offset="1">
<bean:write name="choiceinstruction"/>
</logic:iterate>

</logic:equal>	


<bean:define id="questImgPath" name="AssessmentMultiForm" property="textOrUrl"/>
<logic:equal name="pageNo" value="0">
<table width="935" border="0">
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;

    </td>
<td width="794">
    <div align="center">
    <logic:iterate id="choicetextorurl" name="AssessmentMultiForm" property="textOrUrl">
    <img src="<%=choicetextorurl%>">
    </logic:iterate>
    </div>
    </td>
  </tr>
</table>
</logic:equal>



<table width="935">
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;
    <logic:notEqual name="pageNo" value="0">
    
	 <table width ="50" border="1">
        <logic:iterate id="choiceinstruction1" name="AssessmentMultiForm" property="navigationlist">
                   <%String val=(String)(""+choiceinstruction1);%>
                   <tr><td align="center">
			                 <logic:lessEqual name="AssessmentMultiForm" property="nextcount" value="<%=val%>">
			                 <b>
			                 <bean:write name="choiceinstruction1"/>
			                 </b>
							</logic:lessEqual >
							
							<logic:greaterThan name="AssessmentMultiForm" property="nextcount" value="<%=val%>">
							<bean:define id="linkImageUrl" name="AssessmentMultiForm" property="linkImageUrl"/>
                            <img src="<%=linkImageUrl%><%=val%>.jpg "  onclick="javascript:linkfunction('<%=val%>');">
							</logic:greaterThan>
	                 </td></tr>
	     </logic:iterate>
	</table>
    </logic:notEqual>

</td>
<td>
<logic:notEqual name="pageNo" value="0">
<table width="280" height="96" border="1" align="center">
            <tr>         
            
              <td align="center">
         				<logic:iterate id="choicetextorurl" name="AssessmentMultiForm" property="textOrUrl">
         				<span class="style4" align="center">
                        <bean:write name="choicetextorurl"/>
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
<div align="center"><bean:write name="choiceinstruction"/></div>
</logic:iterate>
</logic:notEqual>


<table align = "center">
  <logic:notEqual name="pageNo" value="0">
   <% int choiceCount=1;%>
  <bean:define id="questionOptions" name="AssessmentMultiForm" property="questionOptions"/>
    <tr><div align ="center">
    <logic:iterate id="choice" name="questionOptions">
        <td>
           <html:multibox name="AssessmentMultiForm" property="selectedCheckboxes" value="<%=(""+choiceCount++)%>"/>
           <bean:write name="choice"/>
   	    </td>
    </logic:iterate>
    </div></tr>
  </logic:notEqual>&nbsp;</td>
</table>
<p>&nbsp;</p>

<logic:equal name="pageNo" value="0">
<b><bean:write name="AssessmentMultiForm" property="answerInstruction"/></b>
</logic:equal>

<div align="center">

<logic:notEqual name="AssessmentMultiForm" property="nextcount" value="0">
<logic:equal name="pageNo" value="0">
<html:submit onclick="javascript:resumefrominstruction();"><bean:message bundle="execmap" key="generic.resume" /></html:submit>
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
<html:button property="button" onclick="javascript:cancelassessment();enableJavaScript();"><bean:message bundle="execmap" key="generic.cancel" /></html:button>



<logic:notEqual name="pageNo" value="0">
<logic:notEqual name="pageNo" value="6">
<logic:equal name="AssessmentMultiForm" property="urlsetflag" value="false">
<html:submit onclick="javascript:incrementpageno();enableJavaScript();"><bean:message bundle="execmap" key="generic.next" /></html:submit>
</logic:equal>
</logic:notEqual>
</logic:notEqual>

<logic:equal name="AssessmentMultiForm" property="urlsetflag" value="true">
<html:submit onclick="javascript:resumefrominstruction();enableJavaScript();"><bean:message bundle="execmap" key="generic.resume" /></html:submit>
</logic:equal>

<logic:notEqual name="pageNo" value="0">
<html:submit onclick="javascript:finish();enableJavaScript();"><bean:message bundle="execmap" key="generic.finish" /></html:submit>
</logic:notEqual>
</div>
</html:form>