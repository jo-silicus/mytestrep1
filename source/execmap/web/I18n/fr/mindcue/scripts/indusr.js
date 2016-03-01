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

function passvalid(pwdfield,tocheck)
{ for( var i=0;i<pwdfield.length;i++){
    if(pwdfield.substring(i,i+1)==tocheck ||pwdfield.substring(i,i+1)==tocheck)
         return true;
  }
  return false;
}

function isRequired(frmIndUsrCr)
{      	var Empty=false;

	if(Empty == false && isEmpty(document.frmIndUsrCr.txt_logid.value) == true)
	{
	 alert("User ID is a required field. Please fill it in.");
	Empty=true;
	document.frmIndUsrCr.txt_logid.focus();
	return	;
	}

	if(Empty==false && passvalid(document.frmIndUsrCr.txt_logid.value,"\'") == true)
        {
         alert("Quotes and Double Quotes are not allowed in user-id.");
         Empty=true;
         document.frmIndUsrCr.txt_logid.focus();
         return;
        }
	if(Empty==false && passvalid(document.frmIndUsrCr.txt_logid.value,"\"") == true)
        {
         alert("Quotes and Double Quotes are not allowed in user-id.");
         Empty=true;
         document.frmIndUsrCr.txt_logid.focus();
         return;
        }

	if(Empty==false && isEmpty(document.frmIndUsrCr.pwd.value)==true)
	{
	 alert("Password is a required field. Please fill it in.");
	Empty=true;
	document.frmIndUsrCr.pwd.focus();
	return	;
	}

	if(Empty==false && passvalid(document.frmIndUsrCr.pwd.value,"\'") == true)
        {
         alert("Quotes and Double Quotes are not allowed in password.");
         Empty=true;
         document.frmIndUsrCr.pwd.focus();
          document.frmIndUsrCr.pwd.value="";
	  document.frmIndUsrCr.pwd1.value="";
         return;
        }
        if(Empty==false && passvalid(document.frmIndUsrCr.pwd.value,"\"") == true)
        {
         alert("Quotes and Double Quotes are not allowed in password.");
         Empty=true;
         document.frmIndUsrCr.pwd.focus();
          document.frmIndUsrCr.pwd.value="";
	  document.frmIndUsrCr.pwd1.value="";
         return;
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

	if(Empty==false && passvalid(document.frmIndUsrCr.txt_name.value,"\'") == true)
        {
         alert("Quotes and Double Quotes are not allowed in name.");
         Empty=true;
         document.frmIndUsrCr.txt_name.focus();
         document.frmIndUsrCr.txt_name.value="";
	 return;
        }

        if(Empty==false && passvalid(document.frmIndUsrCr.txt_name.value,"\"") == true)
        {
         alert("Quotes and Double Quotes are not allowed in name.");
         Empty=true;
         document.frmIndUsrCr.txt_name.focus();
         document.frmIndUsrCr.txt_name.value="";
	 return;
        }

	if(Empty==false && isEmpty(document.frmIndUsrCr.txt_email.value)==true)
	{
	 alert("Email is a required field. Please fill it in.");
	Empty=true;
	document.frmIndUsrCr.txt_email.focus();
	return	;
	}

	if(Empty==false && passvalid(document.frmIndUsrCr.txt_email.value,"\'") == true)
        {
         alert("Quotes and Double Quotes are not allowed in email.");
         Empty=true;
         document.frmIndUsrCr.txt_email.focus();
         document.frmIndUsrCr.txt_email.value="";
	 return;
        }

	if(Empty==false && passvalid(document.frmIndUsrCr.txt_email.value,"\"") == true)
        {
         alert("Quotes and Double Quotes are not allowed in email.");
         Empty=true;
         document.frmIndUsrCr.txt_email.focus();
         document.frmIndUsrCr.txt_email.value="";
	 return;
        }


	if(Empty==false && isEmpty(document.frmIndUsrCr.txt_addr1.value)==true)
	{
	 alert("Address is a required field. Please fill it in.");
	Empty=true;
	document.frmIndUsrCr.txt_addr1.focus();
	return	;
	}

	if(Empty==false && passvalid(document.frmIndUsrCr.txt_addr1.value,"\'") == true)
        {
         alert("Quotes and Double Quotes are not allowed in address.");
         Empty=true;
         document.frmIndUsrCr.txt_addr1.focus();
         document.frmIndUsrCr.txt_addr1.value="";
	 return;
        }

        if(Empty==false && passvalid(document.frmIndUsrCr.txt_addr1.value,"\"") == true)
        {
         alert("Quotes and Double Quotes are not allowed in address.");
         Empty=true;
         document.frmIndUsrCr.txt_addr1.focus();
         document.frmIndUsrCr.txt_addr1.value="";
	 return;
        }

	if(Empty==false && isEmpty(document.frmIndUsrCr.txt_city.value)==true)
	{
	 alert("City is a required field. Please fill it in.");
	Empty=true;
	document.frmIndUsrCr.txt_city.focus();
	return	;
	}

	if(Empty==false && passvalid(document.frmIndUsrCr.txt_city.value,"\'") == true)
        {
         alert("Quotes and Double Quotes are not allowed in city.");
         Empty=true;
         document.frmIndUsrCr.txt_city.focus();
         document.frmIndUsrCr.txt_city.value="";
	 return;
        }

        if(Empty==false && passvalid(document.frmIndUsrCr.txt_city.value,"\"") == true)
        {
         alert("Quotes and Double Quotes are not allowed in city.");
         Empty=true;
         document.frmIndUsrCr.txt_city.focus();
         document.frmIndUsrCr.txt_city.value="";
	 return;
        }



      if(Empty==false && isEmpty(document.frmIndUsrCr.txt_state.value)==true)
	{
	 alert("State is a required field. Please fill it in.");
	Empty=true;
	document.frmIndUsrCr.txt_state.focus();
	return	;
	}

	if(Empty==false && passvalid(document.frmIndUsrCr.txt_state.value,"\'") == true)
        {
         alert("Quotes and Double Quotes are not allowed in state.");
         Empty=true;
         document.frmIndUsrCr.txt_state.focus();
         document.frmIndUsrCr.txt_state.value="";
	 return;
        }

        if(Empty==false && passvalid(document.frmIndUsrCr.txt_state.value,"\"") == true)
        {
         alert("Quotes and Double Quotes are not allowed in state.");
         Empty=true;
         document.frmIndUsrCr.txt_state.focus();
         document.frmIndUsrCr.txt_state.value="";
	 return;
        }

	 if(Empty==false && isEmpty(document.frmIndUsrCr.txt_zip.value)==true)
	{
	 alert("ZIP is a required field. Please fill it in.");
	Empty=true;
	document.frmIndUsrCr.txt_zip.focus();
	return	;
	}

	if(Empty==false && passvalid(document.frmIndUsrCr.txt_zip.value,"\'") == true)
        {
         alert("Quotes and Double Quotes are not allowed in zip.");
         Empty=true;
         document.frmIndUsrCr.txt_zip.focus();
         document.frmIndUsrCr.txt_zip.value="";
	 return;
        }

        if(Empty==false && passvalid(document.frmIndUsrCr.txt_zip.value,"\"") == true)
        {
         alert("Quotes and Double Quotes are not allowed in zip.");
         Empty=true;
         document.frmIndUsrCr.txt_zip.focus();
         document.frmIndUsrCr.txt_zip.value="";
	 return;
        }


	if(Empty==false && isEmpty(document.frmIndUsrCr.txt_ctry.value)==true)
	{
	 alert("Country is a required field. Please fill it in.");
	Empty=true;
	document.frmIndUsrCr.txt_ctry.focus();
	return	;
	}

	if(Empty==false && passvalid(document.frmIndUsrCr.txt_ctry.value,"\'") == true)
        {
         alert("Quotes and Double Quotes are not allowed in country.");
         Empty=true;
         document.frmIndUsrCr.txt_ctry.focus();
         document.frmIndUsrCr.txt_ctry.value="";
	 return;
        }

        if(Empty==false && passvalid(document.frmIndUsrCr.txt_ctry.value,"\"") == true)
        {
         alert("Quotes and Double Quotes are not allowed in country.");
         Empty=true;
         document.frmIndUsrCr.txt_ctry.focus();
         document.frmIndUsrCr.txt_ctry.value="";
	 return;
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

       if(Empty==false && passvalid(document.frmIndUsrCr.txt_educ_qual.value,"\'") == true)
        {
         alert("Quotes and Double Quotes are not allowed in edu qualification.");
         Empty=true;
         document.frmIndUsrCr.txt_educ_qual.focus();
         document.frmIndUsrCr.txt_educ_qual.value="";
	 return;
        }

        if(Empty==false && passvalid(document.frmIndUsrCr.txt_educ_qual.value,"\"") == true)
        {
         alert("Quotes and Double Quotes are not allowed in edu qualification.");
         Empty=true;
         document.frmIndUsrCr.txt_educ_qual.focus();
         document.frmIndUsrCr.txt_educ_qual.value="";
	 return;
        }

	if(Empty==false && passvalid(document.frmIndUsrCr.txt_job.value,"\'") == true)
        {
         alert("Quotes and Double Quotes are not allowed in job.");
         Empty=true;
         document.frmIndUsrCr.txt_job.focus();
         document.frmIndUsrCr.txt_job.value="";
	 return;
        }

        if(Empty==false && passvalid(document.frmIndUsrCr.txt_job.value,"\"") == true)
        {
         alert("Quotes and Double Quotes are not allowed in job.");
         Empty=true;
         document.frmIndUsrCr.txt_job.focus();
         document.frmIndUsrCr.txt_job.value="";
	 return;
        }



	if(Empty==false && passvalid(document.frmIndUsrCr.txt_prof_qual.value,"\'") == true)
        {
         alert("Quotes and Double Quotes are not allowed in prof qualification.");
         Empty=true;
         document.frmIndUsrCr.txt_prof_qual.focus();
         document.frmIndUsrCr.txt_prof_qual.value="";
	 return;
        }

        if(Empty==false && passvalid(document.frmIndUsrCr.txt_prof_qual.value,"\"") == true)
        {
         alert("Quotes and Double Quotes are not allowed in prof qualification.");
         Empty=true;
         document.frmIndUsrCr.txt_prof_qual.focus();
         document.frmIndUsrCr.txt_prof_qual.value="";
	 return;
        }

    if(document.frmIndUsrCr.chk_age.checked==false)
    {
       alert("Consent check box required.");
       return;
    }
   
/* Intellicue_ver_1.5	 Gaurav Narang
   Validates the Gift Code Entered by the user*/ 

     if(!(isEmpty(document.frmIndUsrCr.txt_gift_code.value)))
	{
	   if((isNaN(document.frmIndUsrCr.txt_gift_code.value)))
	   {
	     alert("Please enter a 5 digit integer in the Gift Code options.");
	     return;	
	   }
	}
// End Intellicue_ver_1.5

 //v3.1 changes by Harvinder Kumar on 04/02/2003 ..start
	//Validates whether the user has checked for high speed connection or not */

	if(document.frmIndUsrCr.chk_conn.checked==false)
    {
       alert("S'il vous pla�t cliqueter la case de pointage pour la connexion rapide.");
	   return;
    }
//v3.1 changes by Harvinder Kumar on 04/02/2003 ..end

   document.frmIndUsrCr.submit();
}