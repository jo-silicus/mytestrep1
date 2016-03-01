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

function isRequired(frmCoAccEd)
{      	var Empty=false;
        var billcheck=false;
	if( isEmpty(document.frmCoAccEd.txt_co_name.value) == true)
	{
	 alert("Company Name is a required field. Please fill it in.");
	Empty=true;
	document.frmCoAccEd.txt_co_name.focus();
	return	;
	}

       	if(Empty==false && isEmpty(document.frmCoAccEd.txt_addr1.value)==true)
	{
	 alert("Address is a required field. Please fill it in.");
	Empty=true;
	document.frmCoAccEd.txt_addr1.focus();
	return	;
	}
	if(Empty==false && isEmpty(document.frmCoAccEd.txt_city.value)==true)
	{
	 alert("City is a required field. Please fill it in.");
	Empty=true;
	document.frmCoAccEd.txt_city.focus();
	return	;
	}
      if(Empty==false && isEmpty(document.frmCoAccEd.txt_state.value)==true)
	{
	 alert("State is a required field. Please fill it in.");
	Empty=true;
	document.frmCoAccEd.txt_state.focus();
	return	;
	}
	 if(Empty==false && isEmpty(document.frmCoAccEd.txt_zip.value)==true)
	{
	 alert("ZIP is a required field. Please fill it in.");
	Empty=true;
	document.frmCoAccEd.txt_zip.focus();
	return	;
	}
	if(Empty==false && isEmpty(document.frmCoAccEd.txt_ctry.value)==true)
	{
	 alert("Country is a required field. Please fill it in.");
	Empty=true;
	document.frmCoAccEd.txt_ctry.focus();
	return	;
	}
	if(Empty==false && isEmpty(document.frmCoAccEd.txt_email.value)==true)
	{
	 alert("Email is a required field. Please fill it in.");
	Empty=true;
	document.frmCoAccEd.txt_email.focus();
	return	;
	}


      if(Empty==false && isEmpty(document.frmCoAccEd.txt_sup_name.value)==true)
	{
	 alert("Supervisor Name is a required field. Please fill it in.");
	Empty=true;
	document.frmCoAccEd.txt_sup_name.focus();
	return	;
	}

	if(Empty==false && isEmpty(document.frmCoAccEd.txt_sup_pwd.value)==true)
	{
	 alert("Supervisor Password is a required field. Please fill it in.");
	Empty=true;
	document.frmCoAccEd.txt_sup_pwd.focus();
	return	;
	}

	if(Empty==false && chkpassword(document.frmCoAccEd.txt_sup_pwd.value,document.frmCoAccEd.txt_sup_pwd2.value) == true)
        {
         alert("You entered the wrong password.");
         Empty=true;
         document.frmCoAccEd.txt_sup_pwd.focus();
	 document.frmCoAccEd.txt_sup_pwd.value="";
	 document.frmCoAccEd.txt_sup_pwd2.value="";
         return;
         }
 if(document.frmCoAccEd.Same_As.checked==false)
   {

    if(Empty==false && isEmpty(document.frmCoAccEd.txt_bill_addr.value)==true)
	{
	 alert("Billing Address is a required field. Please fill it in.");
	Empty=true;
	document.frmCoAccEd.txt_bill_addr.focus();
	return	;
	}
	if(Empty==false && isEmpty(document.frmCoAccEd.txt_bill_city.value)==true)
	{
	 alert("Billing City is a required field. Please fill it in.");
	Empty=true;
	document.frmCoAccEd.txt_bill_city.focus();
	return	;
	}
      if(Empty==false && isEmpty(document.frmCoAccEd.txt_bill_state.value)==true )
	{
	 alert("Billing State is a required field. Please fill it in.");
	Empty=true;
	document.frmCoAccEd.txt_bill_state.focus();
	return	;
	}
	if(Empty==false && isEmpty(document.frmCoAccEd.txt_bill_ctry.value)==true )
	{
	 alert("Billing Country is a required field. Please fill it in.");
	Empty=true;
	document.frmCoAccEd.txt_bill_ctry.focus();
	return	;
	}


   }


     document.frmCoAccEd.submit();
}
