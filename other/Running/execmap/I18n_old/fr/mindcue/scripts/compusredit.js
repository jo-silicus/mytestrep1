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
   var y = today.getYear()+ 1900;
	
	//alert("today is: "+today);
									
	//alert(y );
	//alert("int or not before parseint: "+ isNaN(y));
   //alert("value entered is "+document.frmComUsrCr.txt_yyyy.value);
   //alert("subtracted value="+ y - parseInt(document.frmComUsrCr.txt_yyyy.value));
   if(y-parseInt(document.frmComUsrCr.txt_yyyy.value)  < 15)
     {
      alert("ESS users must be at least 15 years old.");
      return false;
     }
    return true;
 }

function isRequired(frmComUsrCr)
{      	var Empty=false;


	if(Empty==false && isEmpty(document.frmComUsrCr.pwd.value)==true)
	{
	 alert("Password is a required field. Please fill it in.");
	Empty=true;
	document.frmComUsrCr.pwd.focus();
	return	;
	}
	if(Empty==false && isEmpty(document.frmComUsrCr.txt_name.value)==true)
	{
	 alert("Name is a required field. Please fill it in.");
	Empty=true;
	document.frmComUsrCr.txt_name.focus();
	return	;
	}
	if(Empty==false && isEmpty(document.frmComUsrCr.txt_dd.value) == true || isEmpty(document.frmComUsrCr.txt_mm.value) == true||isEmpty(document.frmComUsrCr.txt_yyyy.value) == true)
	{
	 alert("Date of Birth is a required field. Please fill it in.");
	Empty=true;
        document.frmComUsrCr.txt_dd.value="";
        document.frmComUsrCr.txt_mm.value="";
	document.frmComUsrCr.txt_yyyy.value="";
	document.frmComUsrCr.txt_dd.focus();
	return	;
        }
	if (Empty==false && isEmpty(document.frmComUsrCr.txt_email.value)==true)
	{
	 alert("Email is a required field. Please fill it in.");
	Empty=true;
	document.frmComUsrCr.txt_email.focus();
	return	;
	}



        if(Empty==false && chkpassword(document.frmComUsrCr.pwd.value,document.frmComUsrCr.pwd1.value) == true)
        {
         alert("You entered the wrong password. Please check: Caps Lock might be on.");
         Empty=true;
         document.frmComUsrCr.pwd.focus();
         document.frmComUsrCr.pwd.value="";
	 document.frmComUsrCr.pwd1.value="";
         return;
         }
       if (Empty==false && dayvalid(document.frmComUsrCr.txt_dd.value)==true)
         {
          alert("Please enter a valid day(between 1 and 31).");
          Empty=true;
          document.frmComUsrCr.txt_dd.focus();
          return;
         }
	if (Empty==false && monvalid(document.frmComUsrCr.txt_mm.value)==true)
         {
          alert("Please enter a valid month(between 1 and 12).");
          Empty=true;
          document.frmComUsrCr.txt_mm.focus();
          return;
         }
	if (Empty==false && yrvalid(document.frmComUsrCr.txt_yyyy.value)==true)
         {
          alert("I am sorry either the computers haven't been invented yet or you are not born yet.");
          Empty=true;
          document.frmComUsrCr.txt_yyyy.focus();
          return;
         }
 	if (Empty==false && charvalid(document.frmComUsrCr.txt_dd.value)==true)
         {
          alert("Please enter a valid day(between 1 and 31).");
          Empty=true;
          document.frmComUsrCr.txt_dd.focus();
          return;
         }
	if (Empty==false && charvalid(document.frmComUsrCr.txt_mm.value)==true)
         {
          alert("Please enter a valid month(between 1 and 12).");
          Empty=true;
          document.frmComUsrCr.txt_mm.focus();
          return;
         }
	if (Empty==false && charvalid(document.frmComUsrCr.txt_yyyy.value)==true)
         {
          alert("Please enter a valid year.");
          Empty=true;
          document.frmComUsrCr.txt_yyyy.focus();
          return;
         }
         if(iswelfare)
         {

         if(!isvalidage())
            {
            return;
            }
         }

    document.frmComUsrCr.submit();
}