function  isEmpty(theField)
{
		if (theField == "")
		    {
			return true;
			}
			else
			{
			  return false;
			}
}
function chkpassword(pwd1,pwd2)
{
  if (pwd1 != pwd2)
      return true;
  else
      return false;
}
function dayvalid(dt)
{ var Empty=false;
   if( dt<=0 || dt>31)
     return true;
   else
     return false;
}
function monvalid(mo)
{
  var Empty=false;
  if(mo<=0 || mo>12)
    return true;
  else
    return false;
}
function yrvalid(yr)
{
var Empty=false;
if(yr<1900 || yr>2050)
   return true;
else
   return false;
}
function charvalid(aInput)
{
  for( var i=0;i<aInput.length;i++){
    if(aInput.substring(i,i+1)<"0"||aInput.substring(i,i+1)>"9")
      return true;
    }
 return false;
}

function isRequired(frmCoUsrEd)
{      	var Empty=false;


	if(Empty==false && isEmpty(document.frmCoUsrEd.pwd.value)==true)
	{
	 alert("Password is a required field. Please fill it in.");
	Empty=true;
	document.frmCoUsrEd.pwd.focus();
	return	;
	}
	if(Empty==false && isEmpty(document.frmCoUsrEd.txt_name.value)==true)
	{
	 alert("Name is a required field. Please fill it in.");
	Empty=true;
	document.frmCoUsrEd.txt_name.focus();
	return	;
	}
	if (Empty==false && isEmpty(document.frmCoUsrEd.txt_email.value)==true)
	{
	 alert("Email is a required field. Please fill it in.");
	Empty=true;
	document.frmCoUsrEd.txt_email.focus();
	return	;
	}
        if(Empty==false && chkpassword(document.frmCoUsrEd.pwd.value,document.frmCoUsrEd.pwd1.value) == true)
        {
         alert("You entered the wrong password. Please check: Caps Lock might be on.");
         Empty=true;
         document.frmCoUsrEd.pwd.focus();
         document.frmCoUsrEd.pwd.value="";
	 document.frmCoUsrEd.pwd1.value="";
         return;
         }


    document.frmCoUsrEd.submit();
}
