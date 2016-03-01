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
function isRequired(frmCoGrpUp){
     var Empty=false;

     if(Empty==false && isEmpty(document.frmCoGrpUp.txt_coord_name.value)==true)
	{
	 alert("Co-ordinator Name is a required field. Please fill it in.");
	Empty=true;
	document.frmCoGrpUp.txt_coord_name.focus();
	return	;
	}

	if(Empty==false && isEmpty(document.frmCoGrpUp.txt_coord_pwd.value)==true)
	{
	 alert("Co-ordinator Password is a required field. Please fill it in.");
	Empty=true;
	document.frmCoGrpUp.txt_coord_pwd.focus();
	return	;
	}
	if(Empty==false && chkpassword(document.frmCoGrpUp.txt_coord_pwd.value,document.frmCoGrpUp.txt_coord_pwd2.value) == true)
        {
         alert("You entered the wrong password. Please check: Caps Lock might be on.");
         Empty=true;
         document.frmCoGrpUp.txt_coord_pwd.focus();
	 document.frmCoGrpUp.txt_coord_pwd.value="";
	 document.frmCoGrpUp.txt_coord_pwd2.value="";
         return;
         }
         if(Empty==false && isEmpty(document.frmCoGrpUp.txt_coord_email.value)==true)
	{
	 alert("Co-ordinator email is a required field. Please fill it in.");
	Empty=true;
	document.frmCoGrpUp.txt_coord_email.focus();
	return	;
	}
      document.frmCoGrpUp.submit();

   }
