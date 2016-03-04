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
if(yr<1900 || yr>2075)
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

function isRequired(frmglb)
{      	var Empty=false;


	if(Empty==false && isEmpty(document.frmglb.txt_prd_co_acct.value)==true)
	{
	 alert("Company Period is a required field. Please fill it in.");
	Empty=true;
	document.frmglb.txt_prd_co_acct.focus();
	return	;
	}

	if(Empty==false && isEmpty(document.frmglb.txt_prd_iu_acct.value)==true)
	{
	 alert("Individual Period is a required field. Please fill it in.");
	Empty=true;
	document.frmglb.txt_prd_iu_acct.focus();
	return	;
	}
       	if(Empty==false && isEmpty(document.frmglb.txt_test_tm_prd.value)==true)
	{
	 alert("Assessment time-period is a required field. Please fill it in.");
	Empty=true;
	document.frmglb.txt_test_tm_prd.focus();
	return	;
	}

	if(Empty==false && isEmpty(document.frmglb.txt_intm_tm_prd.value)==true)
	{
	 alert("Intimation Period is a required field. Please fill it in.");
	Empty=true;
	document.txt_intm_tm_prd.focus();
	return	;
	}

	if(Empty==false && isEmpty(document.frmglb.Sail_thru_low_val.value)==true)
	{
	 alert("Sail thru low value is a required field. Please fill it in.");
	Empty=true;
	document.Sail_thru_low_val.focus();
	return	;
	}

	if(Empty==false && isEmpty(document.frmglb.txt_Sail_thru_high_val.value)==true)
	{
	 alert("Sail thru high value is a required field. Please fill it in.");
	Empty=true;
	document.txt_Sail_thru_high_val.focus();
	return	;
	}

	if(Empty==false && isEmpty(document.frmglb.txt_Sail_thru_prd.value)==true)
	{
	 alert("Sail thru period is a required field. Please fill it in.");
	Empty=true;
	document.txt_Sail_thru_prd.focus();
	return	;
	}

	if(Empty==false && isEmpty(document.frmglb.txt_Sail_thru_test.value)==true)
	{
	 alert("Sail thru test is a required field. Please fill it in.");
	Empty=true;
	document.txt_Sail_thru_test.focus();
	return	;
	}

	if(Empty==false && isEmpty(document.frmglb.txt_intlc_usr_id.value)==true)
	{
	 alert("User-Id is a required field. Please fill it in.");
	Empty=true;
	document.txt_intlc_usr_id.focus();
	return	;
	}

	if(Empty==false && isEmpty(document.frmglb.txt_intlc_passwd.value)==true)
	{
	 alert("Password is a required field. Please fill it in.");
	Empty=true;
	document.txt_intlc_passwd.focus();
	return	;
	}

	if(Empty==false && isEmpty(document.frmglb.txt_bill_test_amt.value)==true)
	{
	 alert("Test amount is a required field. Please fill it in.");
	Empty=true;
	document.txt_bill_test_amt.focus();
	return	;
	}


	if(Empty==false && isEmpty(document.frmglb.txt_bill_soi_amt.value)==true)
	{
	 alert("SOI amount is a required field. Please fill it in.");
	Empty=true;
	document.txt_bill_soi_amt.focus();
	return	;
	}

	if(Empty==false && isEmpty(document.frmglb.txt_bill_car_amt.value)==true)
	{
	 alert("career-Cue amount is a required field. Please fill it in.");
	Empty=true;
	document.txt_bill_car_amt.focus();
	return	;
	}

    document.frmglb.submit();
}

//SmartMods added by Anil Garg 11/01/2001 Start

//validates the SmartMods part
function validateSM(frmglb) {
	
	//validation for Billing SmartMods amount
	if(isEmpty(document.frmglb.txt_sm_sale_price.value) ) {
		alert("Billing SmartMods amount is a required field. Please fill it in.");
		document.frmglb.txt_sm_sale_price.focus();
		return	;
	}
	if(isNaN(document.frmglb.txt_sm_sale_price.value) || isblank(document.frmglb.txt_sm_sale_price.value)) { 
		alert("Billing SmartMods amount cannot be character");
		document.frmglb.txt_sm_sale_price.value = "";
		document.frmglb.txt_sm_sale_price.focus();
		return;
	}
	if(isNegative(document.frmglb.txt_sm_sale_price.value) ) {
		alert("Billing SmartMods amount can't be a negative value.");
		document.frmglb.txt_sm_sale_price.value = "";
		document.frmglb.txt_sm_sale_price.focus();
		return	;
	}
		
	//validation for SmartMods subscription billing rate
	if(isEmpty(document.frmglb.txt_sm_sub_rate.value)) {
		alert("SmartMods subscription billing rate is a required field. Please fill it in.");
		document.frmglb.txt_sm_sub_rate.focus();
		return	;
	}
	if(isNaN(document.frmglb.txt_sm_sub_rate.value) || isblank(document.frmglb.txt_sm_sub_rate.value)) { 
		alert("SmartMods subscription billing rate cannot be character");
		document.frmglb.txt_sm_sub_rate.value = "";
		document.frmglb.txt_sm_sub_rate.focus();
		return;
	}
	if(isNegative(document.frmglb.txt_sm_sub_rate.value) ) {
		alert("SmartMods subscription billing rate can't be a negative value.");
		document.frmglb.txt_sm_sub_rate.value = "";
		document.frmglb.txt_sm_sub_rate.focus();
		return	;
	}


	//validation for SmartMods period without subscription
	if(isEmpty(document.frmglb.txt_sm_ext.value)==true) {
		alert("SmartMods period without subscription is a required field. Please fill it in.");
		document.frmglb.txt_sm_ext.focus();
		return	;
	}
	if(isNaN(document.frmglb.txt_sm_ext.value) || isblank(document.frmglb.txt_sm_ext.value)) { 
		alert("SmartMods period without subscription cannot be character");
		document.frmglb.txt_sm_ext.value = "";
		document.frmglb.txt_sm_ext.focus();
		return;
	}
	if(isNegative(document.frmglb.txt_sm_ext.value) ) {
		alert("SmartMods period without subscription can't be a negative value.");
		document.frmglb.txt_sm_ext.value = "";
		document.frmglb.txt_sm_ext.focus();
		return	;
	}


	//validation for SmartMods extension period
	if(isEmpty(document.frmglb.txt_sm_subs_ext_period.value)) {
		alert("SmartMods extension period for subscription is a required field. Please fill it in.");
		document.frmglb.txt_sm_subs_ext_period.focus();
		return	;
	}
	if(isNaN(document.frmglb.txt_sm_subs_ext_period.value) || isblank(document.frmglb.txt_sm_subs_ext_period.value)) { 
		alert("SmartMods extension period cannot be character");
		document.frmglb.txt_sm_subs_ext_period.value = "";
		document.frmglb.txt_sm_subs_ext_period.focus();
		return;
	}
	if(isNegative(document.frmglb.txt_sm_subs_ext_period.value) ) {
		alert("SmartMods extension period can't be a negative value.");
		document.frmglb.txt_sm_subs_ext_period.value = "";
		document.frmglb.txt_sm_subs_ext_period.focus();
		return	;
	}

	//validation for Minimum questions for fail criteria
	if(isEmpty(document.frmglb.txt_fail_crieteria.value)) {
		alert("Minimum questions for fail criteria in SmartMods is a required field. Please fill it in.");
		document.frmglb.txt_fail_crieteria.focus();
		return	;
	}
	if(isNaN(document.frmglb.txt_fail_crieteria.value) || isblank(document.frmglb.txt_fail_crieteria.value)) { 
		alert("Minimum questions for fail criteria cannot be character");
		document.frmglb.txt_fail_crieteria.value = "";
		document.frmglb.txt_fail_crieteria.focus();
		return;
	}
	if(isNegative(document.frmglb.txt_fail_crieteria.value) ) {
		alert("Minimum questions for fail criteria can't be a negative value.");
		document.frmglb.txt_fail_crieteria.value = "";
		document.frmglb.txt_fail_crieteria.focus();
		return	;
	}

	//validation for Maximum questions for fail criteria in SmartMods
	if(isEmpty(document.frmglb.txt_max_attempt.value)) {
		alert("Maximum questions for fail criteria in SmartMods is a required field. Please fill it in.");
		document.frmglb.txt_max_attempt.focus();
		return	;
	}
	if(isNaN(document.frmglb.txt_max_attempt.value) || isblank(document.frmglb.txt_max_attempt.value)) { 
		alert("Maximum questions for fail criteria in SmartMods cannot be character");
		document.frmglb.txt_max_attempt.value = "";
		document.frmglb.txt_max_attempt.focus();
		return;
	} else {
		
		if(isNegative(document.frmglb.txt_max_attempt.value) ) {
			alert("Maximum questions for fail criteria in SmartMods can't be a negative value.");
			document.frmglb.txt_max_attempt.value = "";
			document.frmglb.txt_max_attempt.focus();
			return	;
		} 		
		
		//check if this value is greater than minimum no of questions
		minQues  = parseInt(document.frmglb.txt_fail_crieteria.value);
		maxQues  = parseInt(document.frmglb.txt_max_attempt.value);
		if (maxQues < minQues) {
			//show message
			alert("Maximum questions for fail criteria in SmartMods cannot be less than Minimum questions for fail criteria.");
			document.frmglb.txt_max_attempt.value = "";
			document.frmglb.txt_max_attempt.focus();
			return;
		}
	}

	//validation for Intimation time period for SmartMods	
	if(isEmpty(document.frmglb.txt_notification_period.value)) {
		alert("Intimation time period for SmartMods is a required field. Please fill it in.");
		document.frmglb.txt_notification_period.focus();
		return	;
	}
	if(isNaN(document.frmglb.txt_notification_period.value) || isblank(document.frmglb.txt_notification_period.value)) { 
		alert("Intimation time period for SmartMods cannot be character");
		document.frmglb.txt_notification_period.value = "";
		document.frmglb.txt_notification_period.focus();
		return;
	} else {
		
		if(isNegative(document.frmglb.txt_notification_period.value) ) {
			alert("Intimation time period for SmartMods can't be a negative value.");
			document.frmglb.txt_notification_period.value = "";
			document.frmglb.txt_notification_period.focus();
			return	;
		} 

		intimationDays = parseInt(document.frmglb.txt_notification_period.value);
		smDays  = parseInt(document.frmglb.txt_sm_ext.value);
		smSubDays  = parseInt(document.frmglb.txt_sm_subs_ext_period.value);
		if (intimationDays >= smDays) {
			//show message
			alert("Intimation time period cannot be greater than or equal to SmartMods period without subscription.");
			document.frmglb.txt_notification_period.value = "";
			document.frmglb.txt_notification_period.focus();
			return;
		}
		if (intimationDays >= smSubDays) {
			//show message
			alert("Intimation time period cannot be greater than or equal to SmartMods extension period for subscription.");
			document.frmglb.txt_notification_period.value = "";
			document.frmglb.txt_notification_period.focus();
			return;
		}
	}

	//validation for Qualifying score for SmartMods
	if(isEmpty(document.frmglb.txt_qualifying_score.value)) {
		alert("Qualifying score for SmartMods is a required field. Please fill it in.");
		document.frmglb.txt_qualifying_score.focus();
		return	;
	}
	if(isNaN(document.frmglb.txt_qualifying_score.value) || isblank(document.frmglb.txt_qualifying_score.value)) { 
		alert("Qualifying score for SmartMods amount cannot be character");
		document.frmglb.txt_qualifying_score.value = "";
		document.frmglb.txt_qualifying_score.focus();
		return;
	}
	if(isNegative(document.frmglb.txt_qualifying_score.value) ) {
		alert("Qualifying score for SmartMods can't be a negative value.");
		document.frmglb.txt_qualifying_score.value = "";
		document.frmglb.txt_qualifying_score.focus();
		return	;
	} 

	document.frmglb.submit();
	
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

//checks whether this value is a negative value or not
function isNegative (str) {

	if (parseInt(str) < 0) {
		return true;
	} else 
		return false;
}

//SmartMods added by Anil Garg 11/01/2001 End
// v3.1 changes by Kuldeep Singh on 09/01/2003.. Start 
function trim( instr ) {
	var reFirst = /\S/;		// regular expression for first non-white char
	var reLast = /\s+$/;	// regular expression for first white char after last non-white char
	var firstChar = instr.search(reFirst);
	var lastChar = instr.search(reLast);
   	if( lastChar == -1 ) 
		lastChar = instr.length;    	
    	outstr = instr.substring( firstChar, lastChar );
    	return outstr;
}

function listExipryComp() {
	
	if (document.forms[0].expriyComp[0].checked) {	
		
		if ( trim(document.forms[0].noDays.value) == "") { 
			alert("Le numéro de jours est un champs exigé, s'il vous plaît entrer.");
			document.forms[0].noDays.focus();
			return ;
		}
		
		if (isNaN(document.forms[0].noDays.value)) {
		    alert("Le numéro de jours doit être numérique.");
		    document.forms[0].noDays.focus();
			return ;
		}
		if (isNegative(document.forms[0].noDays.value)) {
			alert("Le numéro de jours ne peut pas être négatif.");
		    document.forms[0].noDays.focus();
			return ;
		}
		document.forms[0].submit();
	} else if (document.forms[0].expriyComp[1].checked){
		flag = true;
		if (!( trim(document.forms[0].noDays.value) == "")) { 
			alert("Puisque vous avez choisi 'Enumère tout a rendu capable des sociétés, 'le Numéro de jours pour expirer' doit être vide.");
			flag = false;
			document.forms[0].noDays.focus();
			return ;
		}
		if(flag == true) {
			var act = "enablereport.jsp";
			document.forms[0].action = act;
			document.forms[0].submit();
		}
	}
}
// v3.1 changes by Kuldeep Singh on 09/01/2003.. End 