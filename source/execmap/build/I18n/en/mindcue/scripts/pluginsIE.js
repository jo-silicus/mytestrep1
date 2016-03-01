//This script detects the JRE in IE.
//@author Kuldeep Singh 
//@version 1.0

var agt = navigator.userAgent.toLowerCase();
var is_major = parseInt(navigator.appVersion);
var ie  = (agt.indexOf("msie") != -1);
var ns  = (navigator.appName.indexOf("Netscape") != -1);
var win = ((agt.indexOf("win")!=-1) || (agt.indexOf("32bit")!=-1));
var mac = (agt.indexOf("mac")!=-1);
var pluginlist = "No Java,";
if (ie && win) { 
		pluginlist = detectIE("JavaSoft.JavaBeansBridge","1.3") + 
					 detectIE("JavaPlugin","1.4") ; 
}
function detectIE(ClassID,name) { result = false; document.write('<SCRIPT LANGUAGE=VBScript>\n on error resume next \n result = IsObject(CreateObject("' + ClassID + '"))</SCRIPT>\n'); if (result) return name+','; else return ''; }