
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
if(yr < 0)
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

function isRequired(frmIndUsrPay)
{      	var Empty=false;


	if(Empty==false && isEmpty(document.frmIndUsrPay.txt_card_no.value)==true)
	{
	 alert("Card No. is a required field. Please fill it in.");
	Empty=true;
	document.frmIndUsrPay.txt_card_no.focus();
	return	;
	}


	if(Empty==false && isEmpty(document.frmIndUsrPay.txt_mm.value) == true || isEmpty(document.frmIndUsrPay.txt_yyyy.value) == true)
	{
	 alert("Expiry date is a required field. Please fill it in.");
	Empty=true;
        document.frmIndUsrPay.txt_mm.value="";
	document.frmIndUsrPay.txt_yyyy.value="";
	document.frmIndUsrPay.txt_mm.focus();
	return	;
        }


	if (Empty==false && monvalid(document.frmIndUsrPay.txt_mm.value)==true)
         {
          alert("Please enter a valid month(between 1 and 12).");
          Empty=true;
          document.frmIndUsrPay.txt_mm.focus();
          return;
         }
	if (Empty==false && yrvalid(document.frmIndUsrPay.txt_yyyy.value)==true)
         {
          alert("I am sorry your card is already expired.");
          Empty=true;
          document.frmIndUsrPay.txt_yyyy.focus();
          return;
         }

	if (Empty==false && charvalid(document.frmIndUsrPay.txt_mm.value)==true)
         {
          alert("Please enter a valid month(between 1 and 12).");
          Empty=true;
          document.frmIndUsrPay.txt_mm.focus();
          return;
         }
	if (Empty==false && charvalid(document.frmIndUsrPay.txt_yyyy.value)==true)
         {
          alert("Please enter a valid year.");
          Empty=true;
          document.frmIndUsrPay.txt_yyyy.focus();
          return;
         }

//v3.1 changes by Harvinder Kumar on 16/01/2003 ..start
	//Check if the user hasn't selected even a single option
	if ( document.frmIndUsrPay.chk_testAmt.checked == false && document.frmIndUsrPay.chk_sm[0].checked == false && document.frmIndUsrPay.chk_sm[1].checked == false) 
		{
		 alert("Please make a selection");
		 return;
		}
//v3.1 changes by Harvinder Kumar on 16/01/2003 ..end

    document.frmIndUsrPay.submit();
}