<%@ page language="java" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<html:form action="/StubAction">
<table width="978" border="0">
  <tr>
    <td width="152" bgcolor="#023F70"><span class="style1"><bean:message bundle="execmap" key="index.logininfo" /></span></td>
    <td width="588" bgcolor="#023F70">&nbsp;</td>
  </tr>
</table>
<p>&nbsp;</p>
<table width="750" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="262"> <div align="right" class="style16"><span class="style17"><bean:message bundle="execmap" key="reportframe.adminreportpanel.jlabel.acctid" /></span>:</div></td>
    <td width="488"><p>
        <html:text property="acctid" size="10" style="background-color: #FFFF66;"/> 
      </p></td>
  </tr>
</table>
<table width="750" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="263"> <div align="right" class="style17"><span class="style19"><bean:message bundle="execmap" key="generic.userid" /></span>:</div></td>
    <td width="487"><p>
        <html:text property="userid" size="10" style="background-color: #FFFF66;"/> 
      </p></td>
  </tr>
</table>

<p>&nbsp;</p>
<table width="978" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td bgcolor="#023F70">
      <div align="center">
        <html:submit>
          <bean:message bundle="execmap" key="generic.submit" />
        </html:submit>
      </div>
    </form></td>
    <td bgcolor="#023F70">
      <div align="center">
        <html:reset><bean:message bundle="execmap" key="generic.reset" /></html:reset>
      </div>
    </form></td>
  </tr>
</table>
</html:form>