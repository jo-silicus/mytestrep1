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

function isRequired(frmIndUsrCr)
{      	var Empty=false;


	if(Empty==false && isEmpty(document.frmIndUsrCr.pwd.value)==true)
	{
	 alert("Password is a required field. Please fill it in.");
	Empty=true;
	document.frmIndUsrCr.pwd.focus();
	return	;
	}
	if(Empty==false && chkpassword(document.frmIndUsrCr.pwd.value,document.frmIndUsrCr.pwd1.value) == true)
        {
         alert("You entered the wrong password. Please check: Caps Lock might be on.");
         Empty=true;
         document.frmIndUsrCr.pwd.focus();
         document.frmIndUsrCr.pwd.value="";
	 document.frmIndUsrCr.pwd1.value="";
         return;
         }

	if(Empty==false && isEmpty(document.frmIndUsrCr.txt_name.value)==true)
	{
	 alert("Name is a required field. Please fill it in.");
	Empty=true;
	document.frmIndUsrCr.txt_name.focus();
	return	;
	}

	if (Empty==false && isEmpty(document.frmIndUsrCr.txt_email.value)==true)
	{
	 alert("Email is a required field. Please fill it in.");
	Empty=true;
	document.frmIndUsrCr.txt_email.focus();
	return	;
	}

	if(Empty==false && isEmpty(document.frmIndUsrCr.txt_addr1.value)==true)
	{
	 alert("Address is a required field. Please fill it in.");
	Empty=true;
	document.frmIndUsrCr.txt_addr1.focus();
	return	;
	}
	if(Empty==false && isEmpty(document.frmIndUsrCr.txt_city.value)==true)
	{
	 alert("City is a required field. Please fill it in.");
	Empty=true;
	document.frmIndUsrCr.txt_city.focus();
	return	;
	}
      if(Empty==false && isEmpty(document.frmIndUsrCr.txt_state.value)==true)
	{
	 alert("State is a required field. Please fill it in.");
	Empty=true;
	document.frmIndUsrCr.txt_state.focus();
	return	;
	}
	 if(Empty==false && isEmpty(document.frmIndUsrCr.txt_zip.value)==true)
	{
	 alert("ZIP is a required field. Please fill it in.");
	Empty=true;
	document.frmIndUsrCr.txt_zip.focus();
	return	;
	}
	if(Empty==false && isEmpty(document.frmIndUsrCr.txt_ctry.value)==true)
	{
	 alert("Country is a required field. Please fill it in.");
	Empty=true;
	document.frmIndUsrCr.txt_ctry.focus();
	return	;
	}
	if(Empty==false && isEmpty(document.frmIndUsrCr.txt_dd.value) == true || isEmpty(document.frmIndUsrCr.txt_mm.value) == true||isEmpty(document.frmIndUsrCr.txt_yyyy.value) == true)
	{
	 alert("Date of Birth is a required field. Please fill it in.");
	Empty=true;
        document.frmIndUsrCr.txt_dd.value="";
        document.frmIndUsrCr.txt_mm.value="";
	document.frmIndUsrCr.txt_yyyy.value="";
	document.frmIndUsrCr.txt_dd.focus();
	return	;
        }


       if (Empty==false && dayvalid(document.frmIndUsrCr.txt_dd.value)==true)
         {
          alert("Please enter a valid day(between 1 and 31).");
          Empty=true;
          document.frmIndUsrCr.txt_dd.focus();
          return;
         }
	if (Empty==false && monvalid(document.frmIndUsrCr.txt_mm.value)==true)
         {
          alert("Please enter a valid month(between 1 and 12).");
          Empty=true;
          document.frmIndUsrCr.txt_mm.focus();
          return;
         }
	if (Empty==false && yrvalid(document.frmIndUsrCr.txt_yyyy.value)==true)
         {
          alert("I am sorry either the computers haven't been invented yet or you are not born yet.");
          Empty=true;
          document.frmIndUsrCr.txt_yyyy.focus();
          return;
         }
 	if (Empty==false && charvalid(document.frmIndUsrCr.txt_dd.value)==true)
         {
          alert("Please enter a valid day(between 1 and 31).");
          Empty=true;
          document.frmIndUsrCr.txt_dd.focus();
          return;
         }
	if (Empty==false && charvalid(document.frmIndUsrCr.txt_mm.value)==true)
         {
          alert("Please enter a valid month(between 1 and 12).");
          Empty=true;
          document.frmIndUsrCr.txt_mm.focus();
          return;
         }
	if (Empty==false && charvalid(document.frmIndUsrCr.txt_yyyy.value)==true)
         {
          alert("Please enter a valid year.");
          Empty=true;
          document.frmIndUsrCr.txt_yyyy.focus();
          return;
         }




    document.frmIndUsrCr.submit();
}