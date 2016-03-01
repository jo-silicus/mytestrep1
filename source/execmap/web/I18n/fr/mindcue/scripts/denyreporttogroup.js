function  verifySelection()
{
   
   var i;
   var bFlag;
   bFlag=false;
      
   
  for (i=0;i<document.ReportList.checkbox.length;i++)
  {
     if(document.ReportList.checkbox[i].checked)  
      {
         bFlag=true;
      }
  }
  
  //selected=true;
   if(bFlag==false)
   {
      alert("Please select report(s) to be denied!!");
      return false;
   }
   else
   {
      return true;
   }
}

