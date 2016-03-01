//	This script detects the JRE in Netscape.
//	@author Kuldeep Singh 
//	@version 1.0

var agt = navigator.userAgent.toLowerCase();
var ie  = (agt.indexOf("msie") != -1);
var ns  = (navigator.appName.indexOf("Netscape") != -1);
var win = ((agt.indexOf("win")!=-1) || (agt.indexOf("32bit")!=-1));
var mac = (agt.indexOf("mac")!=-1);
if (ns || !win) {
		nse = ""; for (var i=0;i<navigator.mimeTypes.length;i++) nse += navigator.mimeTypes[i].type.toLowerCase();
		    pluginlist = detectNS("application/x-java-applet;version=1.1","1.1") +
			detectNS("application/x-java-applet;version=1.2","1.2") +
			detectNS("application/x-java-applet;version=1.3","1.3") +
			detectNS("application/x-java-applet;version=1.4","1.4") ;
}
function detectNS(ClassID,name) { n = ""; if (nse.indexOf(ClassID) != -1) if (navigator.mimeTypes[ClassID].enabledPlugin != null) n = name+","; return n; }