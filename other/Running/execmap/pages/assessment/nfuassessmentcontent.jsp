<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript">
function enableJavaScript()
{
document.forms[0].enableScript.value="Enabled";

}

var paramval;
var stringArray=new Array();
var startArrayCount=0;
var outputStringCount=1;
   
function init()
{
document.forms[0].up.disabled=false;
document.forms[0].down.disabled=false;
initialize();
countDown();
time = document.forms[0].memtimer.value;	
countDown1();
}
	
	function initializeArray(value)
   	{
   		stringArray[startArrayCount]=value;
   		startArrayCount++;
	}

function incrementpageno()
{
clearTimeout(ticker);
document.forms[0].enableScript.value="Enabled";
var pageno=document.AssessmentMultiForm.pageNo.value;
document.AssessmentMultiForm.pageNo.value=parseInt(pageno)+ 1;
var countno=document.AssessmentMultiForm.nextcount.value;
document.AssessmentMultiForm.nextcount.value=parseInt(countno)+ 1;
document.forms[0].action="/execmap/InitNFUX.do";
}

function finish()
{
clearTimeout(ticker);
document.forms[0].enableScript.value="Enabled";
var boolValue=new Boolean(true);
document.forms[0].nextFinish.value=boolValue.valueOf();
var pageno=document.AssessmentMultiForm.pageNo.value;
document.AssessmentMultiForm.pageNo.value=parseInt(pageno)+ 1;
document.forms[0].action="/execmap/InitNFUX.do";
}

function setnavigateQuestion()
{
	paramval=obj.value;
	document.forms[0].action="/execmap/InitNFUX.do?"+paramval;
}
function countDown1() {
  time--;
if(time==0 && (document.forms[0].sliderpos.value!=""))
	{
	document.forms[0].sliderpos.value=document.forms[0].sliderpos.value+" "+s2.getValue();
}
   if (time > 0) {
     ticker=setTimeout('countDown1()', 1000);
	 	  if((time%5)==0){
		  resetno(); }
     document.forms[0].memtimer.value=time;
  } 
  else {
  incrementpageno();
  document.forms[0].submit();
  }                                                               
}


function resetno()
{
	var constantnumba=stringArray[outputStringCount];
	outputStringCount++;
	document.forms[0].text1.value=constantnumba.charAt(0);
	document.forms[0].text2.value=constantnumba.charAt(1);
	document.forms[0].text3.value=constantnumba.charAt(2);
	document.forms[0].text4.value=constantnumba.charAt(3);
	document.forms[0].text5.value=constantnumba.charAt(4);
	document.forms[0].sliderpos.value=document.forms[0].sliderpos.value+" "+s2.getValue();

}
 
</script>                                     
                                      


<script type="text/javascript">
//<![CDATA[
    var inc=1;
    var dec=1;
    var time = 9;            //Set starting value for timer countdown -- LINE 20
    var ticker; 
    var timeClock;           //Variable for setTimeout
    var i=3;
    var cssFile = getQueryString( "css" );
    if ( cssFile == "" )
	    cssFile = "css/bluecurve/bluecurve.css";
        document.write("<link type=\"text/css\" rel=\"StyleSheet\" href=\"" + cssFile + "\" />" );

   
    function getQueryString( sProp ) 
    {
	    var re = new RegExp( sProp + "=([^\\&]*)", "i" );
	    var a = re.exec( document.location.search );
	    if ( a == null )
		return "";
	    return a[1];
    };

    function changeCssFile( sCssFile ) 
    {
	    var loc = String(document.location);
	    var search = document.location.search;
	    if ( search != "" )
		loc = loc.replace( search, "" );
	    loc = loc + "?css=" + sCssFile;
    	document.location.replace( loc );
    }

    function startslider()
    {	
        var width = Math.floor(Math.random()*150);
        var height =width;
        s2.setMaximum(100);
        s2.setValue(50);
        var lowerlimit=10;
        var upperlimit=90;
        var j = Math.floor(Math.random()*10);
        if (j>4)
            increase();
        else{decrease();}
    }

    function increasecheck()
    {
        clearTimeout(dec);
        clearTimeout(inc);
        increase();
    }

    function increase()
    {
        height=s2.getValue()+1;
        inc = setTimeout('increase()',30);
        s2.setValue(height);
        if(height > 98)
            {
                clearTimeout(inc);
                decrease();
            }
    }

    function decreasecheck()
    {
        clearTimeout(inc);
        clearTimeout(dec);
        decrease();
    }

    function decrease()
    {
        height=s2.getValue()-1;
        dec = setTimeout('decrease()',30);
        s2.setValue(height);
        if(height < 1)
            {
                clearTimeout(dec);
        increase();
}
}

var cssFile = getQueryString( "css" );
if ( cssFile == "" )
	cssFile = "/execmap/css/bluecurve/bluecurve.css";
document.write("<link type=\"text/css\" rel=\"StyleSheet\" href=\"" + cssFile + "\" />" );

//]]>
</script>
<!--
<link type="text/css" rel="StyleSheet" href="css/winclassic.css" />
-->
<script type="text/javascript" src="/execmap/javascript/range.js"></script>
<script type="text/javascript" src="/execmap/javascript/timer.js"></script>
<script type="text/javascript" src="/execmap/javascript/slider.js"></script>      





<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<html:form action="/InitNFUX.do">
<bean:define id="AssessmentMultiForm" name="AssessmentMultiForm"/>
<bean:define id="pageNo" name="AssessmentMultiForm" property="pageNo"/>
<bean:define id="nextcount" name="AssessmentMultiForm" property="nextcount"/>
<bean:define id="questionNo" name="AssessmentMultiForm" property="questionNo"/>

<html:hidden name="AssessmentMultiForm" property="pageNo" value="<%=pageNo.toString()%>"/>
<html:hidden name="AssessmentMultiForm" property="nextcount" value="<%=nextcount.toString()%>"/>
<html:hidden name="AssessmentMultiForm" property="questionNo" value="<%=questionNo.toString()%>"/>
<html:hidden name="AssessmentMultiForm" property="nextFinish" value=""/>
<html:hidden name="AssessmentMultiForm" property="timerSet" value=""/>
<html:hidden name="AssessmentMultiForm" property="sliderpos" value=""/>
<html:hidden property="enableScript" value=""/>

<div align="right">
	<b>
	<html:text name="AssessmentMultiForm" property="timer" size="3" onfocus = "blur();" />&nbsp&nbsp</b>

    <logic:notEmpty name="AssessmentMultiForm" property="memtimer">
	<html:text name="AssessmentMultiForm" property="memtimer" size="3" onfocus = "blur();" />&nbsp&nbsp</b>
	</logic:notEmpty>
	
   
	<logic:equal name="AssessmentMultiForm" property="startCounting" value="1">
    <logic:notEmpty name="AssessmentMultiForm" property="memtimer">
	<script>
	time = document.forms[0].memtimer.value;	
    countDown1();
		</script>

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
<% String numberarray[]=new String[5];
	 int count=0;
	 int index=0;
	 String number=new String();%>
<p>&nbsp;</p>
<logic:notEmpty name="AssessmentMultiForm" property="instruction">
<table width="600" align="center" cellpadding="0" cellspacing="0">
  			<tr>
		    <td rowspan="30">

<logic:iterate id="choiceinstruction" name="AssessmentMultiForm" property="instruction">
<b>
<bean:write name="choiceinstruction"/></b>
<br/>
</logic:iterate>


<logic:iterate id="choice" name="AssessmentMultiForm" property="questionOptions">
	 <Script>
	     initializeArray('<%=choice%>');
	</Script>
	      <%numberarray[count]=(String)choice;
          count++;%>
</logic:iterate>

<logic:notEmpty name="AssessmentMultiForm" property="instruction">
<%number=numberarray[index];
   index++;%>
   
		<table border="3">
     		  <td><html:text property="text1" size="5" maxlength="1" readonly ="true" value='<%=""+number.charAt(0)%>'/></td>
	 		  <td><html:text property="text2" size="5" maxlength="1" readonly ="true" value='<%=""+number.charAt(1)%>'/></td>
	 		  <td><html:text property="text3" size="5" maxlength="1" readonly ="true" value='<%=""+number.charAt(2)%>'/></td>
			  <td><html:text property="text4" size="5" maxlength="1" readonly ="true" value='<%=""+number.charAt(3)%>'/></td>
	 		  <td><html:text property="text5" size="5" maxlength="1" readonly ="true" value='<%=""+number.charAt(4)%>'/></td>
	 	</table>

		
		<%number=numberarray[index];%>
</logic:notEmpty>
			 </td>
	<td width="117" rowspan="2">
			<div class="slider" id="slider-2" tabIndex="1">
			    <input class="slider-input" id="slider-input-2"/>
            </div>
	       <script type="text/javascript">
	              var s2 = new Slider(document.getElementById("slider-2"), document.getElementById("slider-input-2"), "vertical");
	              window.onresize = function () {
	                                 s2.recalculate();
									 };
				  s2.setValue(50);
				  s2.setMaximum(100);					 
           </script>
		   <logic:notEqual name="pageNo" value="0">
		    <script type="text/javascript">
             startslider();
			 </script>
		   </logic:notEqual>
   </td>
			 
		 <td width="50" align="center" valign="bottom">
    <img src="/execmap/css/bluecurve/up.jpg" width="53" height="47" align="bottom" name="up" disabled="true" onClick="increasecheck();"/>
    <img src="/execmap/css/bluecurve/down.jpg" width="49" height="47" align="top" name="down" disabled="true" onClick="decreasecheck();"/>
    </td></tr>
	</table>
</logic:notEmpty>


	<logic:equal name="AssessmentMultiForm" property="pageNo" value="3">
	<script>
    document.forms[0].up.disabled=false;
    document.forms[0].down.disabled=false;
	</script>
	</logic:equal>
	<logic:equal name="AssessmentMultiForm" property="pageNo" value="6">
	<script>
    document.forms[0].up.disabled=false;
    document.forms[0].down.disabled=false;
	</script>
	</logic:equal>

<p>&nbsp;</p>

<logic:notEqual name="pageNo" value="0">
<logic:notEmpty name="AssessmentMultiForm" property="answerInstruction">
<div align="center"><b>
<bean:write name="AssessmentMultiForm" property="answerInstruction"/>
</b></div>
</logic:notEmpty>
</logic:notEqual>
<p>&nbsp;</p>

<logic:notEqual name="pageNo" value="0">
<logic:notEmpty name="AssessmentMultiForm" property="textOrUrl">
<logic:iterate id ="question" name="AssessmentMultiForm" property="textOrUrl">
<div align="center"><b>
<bean:write  name="question"/>
</b></div>
</logic:iterate>
</logic:notEmpty>
</logic:notEqual>



<logic:notEqual name="AssessmentMultiForm" property="pageNo" value="0">
<logic:notEqual name="AssessmentMultiForm" property="pageNo" value="3">
<logic:notEqual name="AssessmentMultiForm" property="pageNo" value="6">
<logic:notEmpty name="AssessmentMultiForm" property="questionOptions">
<% int choiceCount=1;%>
<table width="400" align="center">
<logic:iterate id="choice" name="AssessmentMultiForm" property="questionOptions">
<tr><td>
 <html:radio name="AssessmentMultiForm" property="answerNo" value="<%=(""+choiceCount++)%>"/>
<b><bean:write name="choice"/></b>
</td></tr>
</logic:iterate>
</table>
</logic:notEmpty>
</logic:notEqual>
</logic:notEqual>
</logic:notEqual>


<p>&nbsp;</p><p>&nbsp;</p>
<div align="center">







<logic:equal name="pageNo" value="0">
<bean:define id="start">
<bean:message bundle="execmap" key="generic.start_now" />
</bean:define>
<input type="button" name="Button" value="<%=start%>" size="20" onClick="startslider();this.disabled=true;init();enableJavaScript();">
</logic:equal>


<logic:notEmpty name="AssessmentMultiForm" property="instruction">
<logic:notEqual name="nextcount" value="0">
<html:submit onclick="startslider();this.disabled=true;init();enableJavaScript();" disabled="true"><bean:message bundle="execmap" key="generic.start_now" /></html:submit>
</logic:notEqual>
</logic:notEmpty>


<logic:notEqual name="pageNo" value="8">
<logic:empty name="AssessmentMultiForm" property="instruction">
<logic:notEmpty name="AssessmentMultiForm" property="questionOptions">
<html:submit onclick="javascript:incrementpageno();enableJavaScript();"><bean:message bundle="execmap" key="generic.resume" /></html:submit>
</logic:notEmpty>
</logic:empty>
</logic:notEqual>

<logic:equal name="pageNo" value="8">
<html:submit onclick="javascript:finish();enableJavaScript();"><bean:message bundle="execmap" key="generic.finish" /></html:submit>
</logic:equal>
</div>
</html:form>