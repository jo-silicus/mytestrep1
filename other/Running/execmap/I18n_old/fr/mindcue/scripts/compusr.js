var iswelfare=false;
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



 function isvalidage()
 {
	
   var today = new Date();
   var y = today.getYear();
   var y1 = 0;
	
   if (y < 1000)
{
	y1 = y+1900;
}
   else
{
	y1 = y;
}

   if(y1-document.frmcomusrcr.txt_yyyy.value  < 15)
     {
      alert("ESS users must be at least 15 years old.");
      return false;
     }
    return true;
 }

function passvalid(pwdfield,tocheck)
{ for( var i=0;i<pwdfield.length;i++){
    if(pwdfield.substring(i,i+1)==tocheck ||pwdfield.substring(i,i+1)==tocheck)
         return true;
  }
  return false;
}

function isRequired(frmcomusrcr)
{      	var Empty=false;


	if(Empty == false && isEmpty(document.frmcomusrcr.txt_logid.value) == true)
	{
	 alert("User ID is a required field. Please fill it in.");
	Empty=true;
	document.frmcomusrcr.txt_logid.focus();
	return	;
	}

        if(Empty==false && passvalid(document.frmcomusrcr.txt_logid.value,"\'") == true)
        {
         alert("Quotes and Double Quotes are not allowed .");
         Empty=true;
         document.frmcomusrcr.txt_logid.focus();
         document.frmcomusrcr.txt_logid.value="";
	 return;
        }
        if(Empty==false && passvalid(document.frmcomusrcr.txt_logid.value,"\"") == true)
        {
         alert("Quotes and Double Quotes are not allowed .");
         Empty=true;
         document.frmcomusrcr.txt_logid.focus();
         document.frmcomusrcr.txt_logid.value="";
	 return;
        }
        if(Empty==false && passvalid(document.frmcomusrcr.txt_logid.value,"&") == true)
        {
         alert("Special characters are not allowed .");
         Empty=true;
         document.frmcomusrcr.txt_logid.focus();
         document.frmcomusrcr.txt_logid.value="";
	 return;
        }

        if(Empty==false && passvalid(document.frmcomusrcr.txt_logid.value," ") == true)
        {
         alert("Spaces are not allowed .");
         Empty=true;
         document.frmcomusrcr.txt_logid.focus();
         document.frmcomusrcr.txt_logid.value="";
	 return;
        }



	if(Empty==false && isEmpty(document.frmcomusrcr.pwd.value)==true)
	{
	 alert("Password is a required field. Please fill it in.");
	Empty=true;
	document.frmcomusrcr.pwd.focus();
	return	;
	}
	if(Empty==false && isEmpty(document.frmcomusrcr.txt_name.value)==true)
	{
	 alert("Name is a required field. Please fill it in.");
	Empty=true;
	document.frmcomusrcr.txt_name.focus();
	return	;
	}
	if(Empty==false && isEmpty(document.frmcomusrcr.txt_dd.value) == true || isEmpty(document.frmcomusrcr.txt_mm.value) == true||isEmpty(document.frmcomusrcr.txt_yyyy.value) == true)
	{
	 alert("Date of Birth is a required field. Please fill it in.");
	Empty=true;
        document.frmcomusrcr.txt_dd.value="";
        document.frmcomusrcr.txt_mm.value="";
	document.frmcomusrcr.txt_yyyy.value="";
	document.frmcomusrcr.txt_dd.focus();
	return	;
        }
	if (Empty==false && isEmpty(document.frmcomusrcr.txt_email.value)==true)
	{
	 alert("Email is a required field. Please fill it in.");
	Empty=true;
	document.frmcomusrcr.txt_email.focus();
	return	;
	}


        if(Empty==false && chkpassword(document.frmcomusrcr.pwd.value,document.frmcomusrcr.pwd1.value) == true)
        {
         alert("You entered the wrong password. Please check: Caps Lock might be on.");
         Empty=true;
         document.frmcomusrcr.pwd.focus();
         document.frmcomusrcr.pwd.value="";
	 document.frmcomusrcr.pwd1.value="";
         return;
         }
       if (Empty==false && dayvalid(document.frmcomusrcr.txt_dd.value)==true)
         {
          alert("Please enter a valid day(between 1 and 31).");
          Empty=true;
          document.frmcomusrcr.txt_dd.focus();
          return;
         }
	if (Empty==false && monvalid(document.frmcomusrcr.txt_mm.value)==true)
         {
          alert("Please enter a valid month(between 1 and 12).");
          Empty=true;
          document.frmcomusrcr.txt_mm.focus();
          return;
         }
	if (Empty==false && yrvalid(document.frmcomusrcr.txt_yyyy.value)==true)
         {
          alert("Please enter the valid year(between 1900 and 2050).");
          Empty=true;
          document.frmcomusrcr.txt_yyyy.focus();
          return;
         }

 	if (Empty==false && charvalid(document.frmcomusrcr.txt_dd.value)==true)
         {
          alert("Please enter a valid day(between 1 and 31).");
          Empty=true;
          document.frmcomusrcr.txt_dd.focus();
          return;
         }
	if (Empty==false && charvalid(document.frmcomusrcr.txt_mm.value)==true)
         {
          alert("Please enter a valid month(between 1 and 12).");
          Empty=true;
          document.frmcomusrcr.txt_mm.focus();
          return;
         }
	if (Empty==false && charvalid(document.frmcomusrcr.txt_yyyy.value)==true)
         {
          alert("Please enter a valid year.");
          Empty=true;
          document.frmcomusrcr.txt_yyyy.focus();
          return;
         }
         if(iswelfare)
         {

         if(! isvalidage())
            {
            return;
            }
         }

    document.frmcomusrcr.submit();
}

//SmartMods added by Anil Garg 18/01/2001 Start

//This function checks the length of data in text area
function CheckLength(CtrlName) {
	if (Number(CtrlName.value.length)>125) {
		CtrlName.focus();
		alert("Please ensure data length should not exceed 125 characters");
	}
}

//SmartMods added by Anil Garg 18/01/2001 End