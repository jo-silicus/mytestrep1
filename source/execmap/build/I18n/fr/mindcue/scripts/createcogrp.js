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

function passvalid(pwdfield,tocheck)
{ for( var i=0;i<pwdfield.length;i++){
    if(pwdfield.substring(i,i+1)==tocheck ||pwdfield.substring(i,i+1)==tocheck)
         return true;
  }
  return false;
}


function isRequired(frmCoGrpCr){
     var Empty=false;
     if( isEmpty(document.frmCoGrpCr.txt_grp_id.value)==true)
	{
	 alert("Group ID is a required field. Please fill it in.");
	Empty=true;
	document.frmCoGrpCr.txt_grp_id.focus();
	return	;
	}

    	if(Empty==false && passvalid(document.frmCoGrpCr.txt_grp_id.value,"\'") == true)
        {
         alert("Quotes and Double Quotes are not allowed .");
         Empty=true;
         document.frmCoGrpCr.txt_grp_id.focus();
         document.frmCoGrpCr.txt_grp_id.value="";
	 return;
        }
        if(Empty==false && passvalid(document.frmCoGrpCr.txt_grp_id.value,"\"") == true)
        {
         alert("Quotes and Double Quotes are not allowed .");
         Empty=true;
         document.frmCoGrpCr.txt_grp_id.focus();
         document.frmCoGrpCr.txt_grp_id.value="";
	 return;
        }
        if(Empty==false && passvalid(document.frmCoGrpCr.txt_grp_id.value,"&") == true)
        {
         alert("Special characters are not allowed .");
         Empty=true;
         document.frmCoGrpCr.txt_grp_id.focus();
         document.frmCoGrpCr.txt_grp_id.value="";
	 return;
        }

        if(Empty==false && passvalid(document.frmCoGrpCr.txt_grp_id.value," ") == true)
        {
         alert("Spaces are not allowed .");
         Empty=true;
         document.frmCoGrpCr.txt_grp_id.focus();
         document.frmCoGrpCr.txt_grp_id.value="";
	 return;
        }


     if(Empty==false && isEmpty(document.frmCoGrpCr.txt_coord_name.value)==true)
	{
	 alert("Co-ordinator Name is a required field. Please fill it in.");
	Empty=true;
	document.frmCoGrpCr.txt_coord_name.focus();
	return	;
	}
	if(Empty==false && isEmpty(document.frmCoGrpCr.txt_coord_id.value)==true)
	{
	 alert("Co-ordinator Login ID is a required field. Please fill it in.");
	Empty=true;
	document.frmCoGrpCr.txt_coord_id.focus();
	return	;
	}
	if(Empty==false && passvalid(document.frmCoGrpCr.txt_coord_id.value,"\'") == true)
        {
         alert("Quotes and Double Quotes are not allowed .");
         Empty=true;
         document.frmCoGrpCr.txt_coord_id.focus();
         document.frmCoGrpCr.txt_coord_id.value="";
	 return;
        }
        if(Empty==false && passvalid(document.frmCoGrpCr.txt_coord_id.value,"\"") == true)
        {
         alert("Quotes and Double Quotes are not allowed .");
         Empty=true;
         document.frmCoGrpCr.txt_coord_id.focus();
         document.frmCoGrpCr.txt_coord_id.value="";
	 return;
        }
        if(Empty==false && passvalid(document.frmCoGrpCr.txt_coord_id.value,"&") == true)
        {
         alert("Special characters are not allowed .");
         Empty=true;
         document.frmCoGrpCr.txt_coord_id.focus();
         document.frmCoGrpCr.txt_coord_id.value="";
	 return;
        }




	if(Empty==false && isEmpty(document.frmCoGrpCr.txt_coord_pwd.value)==true)
	{
	 alert("Co-ordinator Password is a required field. Please fill it in.");
	Empty=true;
	document.frmCoGrpCr.txt_coord_pwd.focus();
	return	;
	}
	if(Empty==false && chkpassword(document.frmCoGrpCr.txt_coord_pwd.value,document.frmCoGrpCr.txt_coord_pwd2.value) == true)
        {
         alert("You entered the wrong password. Please check: Caps Lock might be on.");
         Empty=true;
         document.frmCoGrpCr.txt_coord_pwd.focus();
	 document.frmCoGrpCr.txt_coord_pwd.value="";
	 document.frmCoGrpCr.txt_coord_pwd2.value="";
         return;
         }
         if(Empty==false && isEmpty(document.frmCoGrpCr.txt_coord_email.value)==true)
	{
	 alert("Co-ordinator email is a required field. Please fill it in.");
	Empty=true;
	document.frmCoGrpCr.txt_coord_email.focus();
	return	;
	}

      document.frmCoGrpCr.submit();

   }
