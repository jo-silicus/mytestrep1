<%-- 
  - Author(s): Ashim Das
  - Date: 11th July 2006
  - Copyright Notice: Management Assessment Partners (MAP) AG 
  - All Rights Reserved.
  - @(#)
  - Description: This is the layout for assessment pages.
  - All assessessment layouts have header, subheader, content and footer
  -
  --%>

<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<html:xhtml />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><bean:message bundle="execmap" key="generic.execmap"/></title>
<style type="text/css">
<!--
.style1 {color: #FFFFFF}
-->
.style2 { font-weight: bold; font-size: 36px; }
.style3 {color: #FFFFFF; font-weight: bold; font-size: 20px; }
.style4 {color: #FF0000; font-weight: bold; font-size: 20px; }
.style5 {color: #FFFFFF; font-weight: bold; font-size: 18px; }
.style6 {font-weight: bold; font-size: 20px; }
#FFFFFF
</style>

<link rel="stylesheet" type="text/css"
	href=<%="css/execmap.css"%>> </link>
<html:base target="_self"/>

<script type="text/javascript">
  var t;     
  var ticker; 
  
  
document.onkeydown = keydown;

function keydown(evt){

document.forms[0].enableScript.value="Enabled";
if (!evt) evt = event;
if (evt.altKey && evt.keyCode==115){ 
document.forms[0].action="/execmap/invalidate.do";
document.forms[0].nextcount.value="0";  
window.event.keyCode=86;  
window.cancelEvent=true;
event.cancelBubble=true;
event.returnValue=false;
event.cancel=true;
}
else if (evt.altKey && evt.keyCode==37){
window.cancelEvent=true;
event.cancelBubble=true;
event.returnValue=false;
event.cancel=true;
}
else if (evt.keyCode==116){
evt.returnValue = false;
evt.keyCode = 0;
window.cancelEvent=true;
event.cancelBubble=true;
event.cancel=true;
}
else if (evt.keyCode==117){
evt.returnValue = false;
evt.keyCode = 0;
window.cancelEvent=true;
event.cancelBubble=true;
event.cancel=true;
}
else if (evt.keyCode==112){
evt.returnValue = false;
evt.keyCode = 0;
window.cancelEvent=true;
event.cancelBubble=true;
event.cancel=true;
}
else if (evt.keyCode==112){
evt.returnValue = false;
evt.keyCode = 0;
window.cancelEvent=true;
event.cancelBubble=true;
event.cancel=true;
}
else if (evt.keyCode==122){
evt.returnValue = false;
evt.keyCode = 0;
window.cancelEvent=true;
event.cancelBubble=true;
event.cancel=true;
}
}  


function checkShortcut()
{
                  if(event.keyCode==8 || event.keyCode==13)
         {
               return false;
         }
}


  
function initialize() {
document.forms[0].enableScript.value="Enabled";
 t = document.forms[0].timer.value;            //Set starting value for timer countdown

}


function countDown() {
document.forms[0].enableScript.value="Enabled";
  --t;
  if (t > 0) {
    ticker=setTimeout('countDown()', 1000);
	document.forms[0].timer.value=t;
  } else {
  var pageno=document.forms[0].pageNo.value;
  document.forms[0].pageNo.value=parseInt(pageno)+ 1;
  var boolValue=new Boolean(true);
  document.forms[0].timerSet.value=boolValue.valueOf();
  document.forms[0].submit();
  }                                                               
}
	

function cancelassessment()
{
document.forms[0].enableScript.value="Enabled";    
msg=document.forms[0].msg.value;
var reply=confirm(msg);
	if (reply == true)
	{
	document.forms[0].nextcount.value="0";
	document.forms[0].action="/execmap/invalidate.do";
	window.close();
	}
	
}				


<!-- 
var message="Function Disabled";   //edit this message to say what you want

function clickIE() {if (document.all) {alert(message); return false;}}
function clickNS(e) {if 
(document.layers||(document.getElementById&&!document.all)) {
if (e.which==2||e.which==3) {alert(message);return false;}}}
if (document.layers) 
{document.captureEvents(Event.MOUSEDOWN);document.onmousedown=clickNS;}
else{document.onmouseup=clickNS;document.oncontextmenu=clickIE;}

document.oncontextmenu=new Function("return false")
// -->


 </script>
</head>
<body bgcolor="#ffffff" onkeydown="return checkShortcut();">

<tiles:insert attribute="header"/>
<p>&nbsp;</p>
<tiles:insert attribute="assessmentsubheader"/>
<tiles:insert attribute="content"/>
<tiles:insert attribute="loginfooter"/>


</body>
</html>