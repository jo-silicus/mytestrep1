function  CheckAll()
{
   
   var i;
   //alert(document.frmlist.chkAcct.value);
   if (document.frmlist.chkAcct.length>1) 
   {
   
	  for (i=0;i<document.frmlist.chkAcct.length;i++)
	  {
		   document.frmlist.chkAcct[i].checked=true;  
	  }
	  //selected=true;
   }
   else
   {
	   document.frmlist.chkAcct.checked=true;  
	   //selected=false;
   }
}

function confirmDeletion()
{
   var i;
   var selectedvalue;
   var answer;

   selectedvalue=false;

	if (document.frmlist.chkAcct.length>1) 
   {


	  for (i=0;i<document.frmlist.chkAcct.length;i++)
	  {
			 if (document.frmlist.chkAcct[i].checked==true)
			 {
				  selectedvalue=true;
			 }
	
	  }
	}
	else if (document.frmlist.chkAcct.checked==true)
	{
	  selectedvalue=true; 
	  //selected=false;
   }
	  
   //alert(selectedvalue);
   if (selectedvalue==true)
   {
      answer=confirm("Are you sure you want to delete the selected company(s)?");
	  if (answer==true) 
	  {
		 document.frmlist.submit();
	  }
	  else
		 return false;
   }
   else
   {
      alert("Please select company(s) to delete?");
      return false;
   }

}

