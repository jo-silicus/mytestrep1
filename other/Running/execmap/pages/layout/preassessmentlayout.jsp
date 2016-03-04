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
.style4 {color: #000000; font-weight: bold; font-size: 24px; font-style: italic;}
-->
</style>
<link rel="stylesheet" type="text/css"
	href=<%="css/execmap.css"%>> </link>
<html:base target="_self"/>

<script type="text/javascript">
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
else if (evt.ctrlKey && evt.keyCode==67){
window.cancelEvent=true;
event.cancelBubble=true;
event.returnValue=false;
event.cancel=true;
}
else if (evt.ctrlKey && evt.keyCode==82){
window.cancelEvent=true;
event.cancelBubble=true;
event.returnValue=false;
event.cancel=true;
}
else if (evt.ctrlKey && evt.keyCode==45){
window.cancelEvent=true;
event.cancelBubble=true;
event.returnValue=false;
event.cancel=true;
}
else if (evt.shiftKey && evt.keyCode==45){
window.cancelEvent=true;
event.cancelBubble=true;
event.returnValue=false;
event.cancel=true;
}
else if (evt.ctrlKey && evt.keyCode==86){
window.cancelEvent=true;
event.cancelBubble=true;
event.returnValue=false;
event.cancel=true;
}

else if (evt.keyCode==112||evt.keyCode==113||evt.keyCode==114||evt.keyCode==115||evt.keyCode==116
||evt.keyCode==117||evt.keyCode==118||evt.keyCode==119||evt.keyCode==120||evt.keyCode==121
||evt.keyCode==122||evt.keyCode==123){
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

function clickIE() {if (document.all) {alert(message); return false;}}
function clickNS(e) {
if 
(document.layers||(document.getElementById&&!document.all)) {
if (e.which==2||e.which==3) {
return false;
            }
     }
}
if (document.layers) 
{document.captureEvents(Event.MOUSEDOWN);
document.onmousedown=clickNS;}
else{
document.onmouseup=clickNS;
document.oncontextmenu=clickIE;
}

document.oncontextmenu=new Function("return false")





function beginassessment()
{	
	document.forms[0].enableScript.value="Enabled";
	document.forms[0].action="/execmap/soundinstruction.do";
	document.forms[0].submit;
}

function cancelassessment()
{
document.forms[0].enableScript.value="Enabled";
msg=document.forms[0].msg.value;
var reply=confirm(msg);
	if (reply == true)
	{
		document.forms[0].action="/execmap/admin.jsp";
		window.close();
	}
}				


function startassessment()
{
	document.forms[0].enableScript.value="Enabled";
    document.forms[0].action="/execmap/eligible.do";
    document.forms[0].submit;
}
function showbutton()
{
	document.forms[0].enableScript.value="Enabled";
    document.forms[0].action="/execmap/showinstruction.do";
    document.forms[0].submit;
}

function forwardAssessment(link)
{	
	document.forms[0].enableScript.value="Enabled";
   var new_url=link;
   if (  (new_url != "")  &&  (new_url != null)  )
    window.location=new_url;
}

 </script>

</head>
<body bgcolor="#ffffff">

<tiles:insert attribute="header"/>
<p>&nbsp;</p>
<tiles:insert attribute="content"/>
<tiles:insert attribute="loginfooter"/>


</body>
</html>