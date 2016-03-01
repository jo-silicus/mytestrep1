function parulerr(sameas)
{
	alert("Value of same as is" + sameas);
	return true;
}

function is_greater_date(yy2,mm2,dd2,yy,mm,dd)
{
if (yy2 > yy)
   {
   alert("The To-From fields  are entered incorrectly. The FROM year entered exceeds the TO year.");
   return true;
   }
if (yy2 == yy)
   {
   if (mm2 > mm)
      {
      alert("The to-month field is entered incorrectly.");
      return true;
      }
   if (mm2 == mm)
      {
      if (dd2 > dd)
         {
         alert("The to-day field is entered incorrectly.");
         return true;
         }
      }
   }
return false;
}

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

function isRequired(frmCoAccCr)
{      	var Empty=false;
        var billcheck=false;

	if( isEmpty(document.frmCoAccCr.txt_co_name.value) == true)
	{
	 alert("Company Name is a required field. Please fill it in.");
	Empty=true;
	document.frmCoAccCr.txt_co_name.focus();
	return	;
	}

       	if(Empty==false && isEmpty(document.frmCoAccCr.txt_addr1.value)==true)
	{
	 alert("Address is a required field. Please fill it in.");
	Empty=true;
	document.frmCoAccCr.txt_addr1.focus();
	return	;
	}
	if(Empty==false && isEmpty(document.frmCoAccCr.txt_city.value)==true)
	{
	 alert("City is a required field. Please fill it in.");
	Empty=true;
	document.frmCoAccCr.txt_city.focus();
	return	;
	}
      if(Empty==false && isEmpty(document.frmCoAccCr.txt_state.value)==true)
	{
	 alert("State is a required field. Please fill it in.");
	Empty=true;
	document.frmCoAccCr.txt_state.focus();
	return	;
	}
	 if(Empty==false && isEmpty(document.frmCoAccCr.txt_zip.value)==true)
	{
	 alert("ZIP is a required field. Please fill it in.");
	Empty=true;
	document.frmCoAccCr.txt_zip.focus();
	return	;
	}
	if(Empty==false && isEmpty(document.frmCoAccCr.txt_ctry.value)==true)
	{
	 alert("Country is a required field. Please fill it in.");
	Empty=true;
	document.frmCoAccCr.txt_ctry.focus();
	return	;
	}
	if(Empty==false && isEmpty(document.frmCoAccCr.txt_email.value)==true)
	{
	 alert("Email is a required field. Please fill it in.");
	Empty=true;
	document.frmCoAccCr.txt_email.focus();
	return	;
	}

       if(Empty==false && isEmpty(document.frmCoAccCr.txt_frm_dd.value) == true || isEmpty(document.frmCoAccCr.txt_frm_mm.value) == true||isEmpty(document.frmCoAccCr.txt_frm_yyyy.value) == true)
	{
	 alert("From date is a required field. Please fill it in.");
	Empty=true;
        document.frmCoAccCr.txt_frm_dd.value="";
        document.frmCoAccCr.txt_frm_mm.value="";
	document.frmCoAccCr.txt_frm_yyyy.value="";
	document.frmCoAccCr.txt_frm_dd.focus();
	return	;
        }
	
	//SmartMods added by Anil Garg 11/01/2001 Start
	//validate for valid from date
	if( !isValidDay(document.frmCoAccCr.txt_frm_dd.value) || !isValidMonth(document.frmCoAccCr.txt_frm_mm.value) || !isValidYear(document.frmCoAccCr.txt_frm_yyyy.value) ) {
		alert("Invalid date provided for From Date fields. Please fill valid date.");

		document.frmCoAccCr.txt_frm_dd.value="";
		document.frmCoAccCr.txt_frm_mm.value="";
		document.frmCoAccCr.txt_frm_yyyy.value="";
		document.frmCoAccCr.txt_frm_dd.focus();
		return	;
	}
//SmartMods added by Anil Garg 11/01/2001 End

       if(Empty==false && isEmpty(document.frmCoAccCr.txt_to_dd.value) == true || isEmpty(document.frmCoAccCr.txt_to_mm.value) == true||isEmpty(document.frmCoAccCr.txt_to_yyyy.value) == true)
	{
	 alert("To date is a required field. Please fill it in.");
	Empty=true;
        document.frmCoAccCr.txt_to_dd.value="";
        document.frmCoAccCr.txt_to_mm.value="";
	document.frmCoAccCr.txt_to_yyyy.value="";
	document.frmCoAccCr.txt_to_dd.focus();
	return	;
        }
	//SmartMods added by Anil Garg 11/01/2001 Start
    //validate for valid To date
	if( !isValidDay(document.frmCoAccCr.txt_to_dd.value) || !isValidMonth(document.frmCoAccCr.txt_to_mm.value) || !isValidYear(document.frmCoAccCr.txt_to_yyyy.value) ) {
		alert("Invalid date provided for To Date fields. Please fill valid date.");

		document.frmCoAccCr.txt_to_dd.value="";
		document.frmCoAccCr.txt_to_mm.value="";
		document.frmCoAccCr.txt_to_yyyy.value="";
		document.frmCoAccCr.txt_to_dd.focus();
		return	;
	}
	//SmartMods added by Anil Garg 11/01/2001 End  
	  
	  if(Empty==false && isEmpty(document.frmCoAccCr.txt_sup_name.value)==true)
	{
	 alert("Supervisor Name is a required field. Please fill it in.");
	Empty=true;
	document.frmCoAccCr.txt_sup_name.focus();
	return	;
	}
	if(Empty==false && isEmpty(document.frmCoAccCr.txt_sup_id.value)==true)
	{
	 alert("Supervisor Login ID is a required field. Please fill it in.");
	Empty=true;
	document.frmCoAccCr.txt_sup_id.focus();
	return	;
	}
	if(Empty==false && isEmpty(document.frmCoAccCr.txt_sup_pwd.value)==true)
	{
	 alert("Supervisor Password is a required field. Please fill it in.");
	Empty=true;
	document.frmCoAccCr.txt_sup_pwd.focus();
	return	;
	}

	if(Empty==false && chkpassword(document.frmCoAccCr.txt_sup_pwd.value,document.frmCoAccCr.txt_sup_pwd2.value) == true)
        {
         alert("You entered the wrong password.");
         Empty=true;
         document.frmCoAccCr.txt_sup_pwd.focus();
	 document.frmCoAccCr.txt_sup_pwd.value="";
	 document.frmCoAccCr.txt_sup_pwd2.value="";
         return;
         }

 if(document.frmCoAccCr.Same_As.checked==false)
   {
    if(Empty==false && isEmpty(document.frmCoAccCr.txt_bill_addr.value)==true)
	{
	 alert("Billing Address is a required field. Please fill it in.");
	Empty=true;
	document.frmCoAccCr.txt_bill_addr.focus();
	return	;
	}
	if(Empty==false && isEmpty(document.frmCoAccCr.txt_bill_city.value)==true)
	{
	 alert("Billing City is a required field. Please fill it in.");
	Empty=true;
	document.frmCoAccCr.txt_bill_city.focus();
	return	;
	}
      if(Empty==false && isEmpty(document.frmCoAccCr.txt_bill_state.value)==true )
	{
	 alert("Billing State is a required field. Please fill it in.");
	Empty=true;
	document.frmCoAccCr.txt_bill_state.focus();
	return	;
	}
	if(Empty==false && isEmpty(document.frmCoAccCr.txt_bill_ctry.value)==true )
	{
	 alert("Billing Country is a required field. Please fill it in.");
	Empty=true;
	document.frmCoAccCr.txt_bill_ctry.focus();
	return	;
	}
   } // end of if checkbox is not checked

    if(document.frmCoAccCr.rad_cobrand[0].checked==true)
         {
           if(Empty==false && isEmpty(document.frmCoAccCr.txt_cobrand_info.value)==true )
		  {
	 	alert("Cobrand information is required. Please fill it in.");
		Empty=true;
		document.frmCoAccCr.txt_cobrand_info.focus();
		return	;
		}

       }

      yy = document.frmCoAccCr.txt_frm_yyyy.value ;
      mm = document.frmCoAccCr.txt_frm_mm.value ;
      dd = document.frmCoAccCr.txt_frm_dd.value ;

      yy2 = document.frmCoAccCr.txt_to_yyyy.value ;
      mm2 = document.frmCoAccCr.txt_to_mm.value ;
      dd2 = document.frmCoAccCr.txt_to_dd.value ;

      if(is_greater_date(yy,mm,dd,yy2,mm2,dd2))
       {
         return;
       }

	 document.frmCoAccCr.submit();
}
//SmartMods added by Anil Garg 11/01/2001 Start
	//checks for valid day
	function isValidDay(temp) {
		//checking for charater
		if (isNaN(temp) || isblank(temp) || parseInt(temp) < 1 || parseInt(temp) > 31 ) {
			return false;
		} else 
			return true;	
	}
	
	//checks for valid month
	function isValidMonth(temp) {
		//checking for charater
		if (isNaN(temp) || isblank(temp) || parseInt(temp) < 1 || parseInt(temp) > 12 ) {
			return false;
		} else 
			return true;	
	}
	
	//checks for valid month
	function isValidYear(temp) {
		//checking for charater
		if (isNaN(temp) || isblank(temp) || parseInt(temp) < 1980 || parseInt(temp) > 2099 ) {
			return false;
		} else 
			return true;	
	}
	
	
	// Function for checking whether the PropertyId is contains blank spaces
	function isblank(lstr) {
		for (k=0 ; k<lstr.length ; k++) {
			var c = lstr.charAt(k);
			if(c ==' ' || c=='\n' || c == '\t' ) 
				return true ;
		}
		return false;
	}

	//This function enable Or disable fields depending on the value of Billing Information checkbox.
	function CheckClearAll() {
	
		if(document.frmCoAccCr.Same_As.checked == true) {
			//set Readonly all
			document.frmCoAccCr.txt_bill_addr.disabled = true;
			document.frmCoAccCr.txt_bill_city.disabled = true;
			document.frmCoAccCr.txt_bill_addr2.disabled = true;
			document.frmCoAccCr.txt_bill_state.disabled = true;
			document.frmCoAccCr.txt_bill_pin.disabled = true;
			document.frmCoAccCr.txt_bill_ctry.disabled = true;
			document.frmCoAccCr.txt_bill_email.disabled = true;
			document.frmCoAccCr.txt_bill_phone.disabled = true;
			document.frmCoAccCr.txt_bill_fax.disabled = true;
			//clear all fields values
			document.frmCoAccCr.txt_bill_addr.value = "";
			document.frmCoAccCr.txt_bill_city.value = "";
			document.frmCoAccCr.txt_bill_addr2.value = "";
			document.frmCoAccCr.txt_bill_state.value = "";
			document.frmCoAccCr.txt_bill_pin.value = "";
			document.frmCoAccCr.txt_bill_ctry.value = "";
			document.frmCoAccCr.txt_bill_email.value = "";
			document.frmCoAccCr.txt_bill_phone.value = "";
			document.frmCoAccCr.txt_bill_fax.value = "";
		} else {
			//set editable all
			document.frmCoAccCr.txt_bill_addr.disabled = false;
			document.frmCoAccCr.txt_bill_city.disabled = false;
			document.frmCoAccCr.txt_bill_addr2.disabled = false;
			document.frmCoAccCr.txt_bill_state.disabled = false;
			document.frmCoAccCr.txt_bill_pin.disabled = false;
			document.frmCoAccCr.txt_bill_ctry.disabled = false;
			document.frmCoAccCr.txt_bill_email.disabled = false;
			document.frmCoAccCr.txt_bill_phone.disabled = false;
			document.frmCoAccCr.txt_bill_fax.disabled = false;
		}
		
	}

	//this function is called at reset button
	function resetAll() {
		document.frmCoAccCr.txt_bill_addr.disabled = false;
		document.frmCoAccCr.txt_bill_city.disabled = false;
		document.frmCoAccCr.txt_bill_addr2.disabled = false;
		document.frmCoAccCr.txt_bill_state.disabled = false;
		document.frmCoAccCr.txt_bill_pin.disabled = false;
		document.frmCoAccCr.txt_bill_ctry.disabled = false;
		document.frmCoAccCr.txt_bill_email.disabled = false;
		document.frmCoAccCr.txt_bill_phone.disabled = false;
		document.frmCoAccCr.txt_bill_fax.disabled = false;
	}
//SmartMods added by Anil Garg 11/01/2001 End