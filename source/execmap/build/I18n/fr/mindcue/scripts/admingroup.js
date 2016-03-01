function setUpTips()
{

   maketheBalloon("disab",300,"Denotes the disabled company/group.Contact Intellicue-Administrator for help.");
}

function move()
{
  if(document.grouplist.groupid !=null)
  {
		 if(document.grouplist.groupid.length > 1)
		 {
			  for (var i = 0; i < document.grouplist.groupid.length; i++ )
			  {  
				  
					 if ( document.grouplist.groupid[i].checked )
					 {
						document.frmmove.curgroupid.value = document.grouplist.groupid[i].value;
						// by Gaurav Narang
						//replacing code 
						// if(document.frmmove.curgroupid.value==document.frmmove.drop_to.value)
						// by 
						//  if(document.frmmove.curgroupid.value==document.frmmove.drop_to.options[document.frmmove.drop_to.selectedIndex].value))
						// as value property on combo box works on IE and not on netscape.
						//alert(document.frmmove.curgroupid.value);
						//alert(document.frmmove.drop_to.options[document.frmmove.drop_to.selectedIndex].value);
							if(document.frmmove.curgroupid.value==document.frmmove.drop_to.options[document.frmmove.drop_to.selectedIndex].value)
							  {
								alert("Source and destination groups are same !");
							  }
							else
							{
							 document.frmmove.submit();
							}
					 }
				}
		}
		 else if(document.grouplist.groupid != null)
		 {
				document.frmmove.curgroupid.value = document.grouplist.groupid.value;
			 document.frmmove.submit();
		 }
    }
      
}
function transferControl()
{
    //alert(document.frmdisbaled.generalflag.value);
    var sFlag=true;
    if(document.grouplist.groupid.length > 1)
     {
          for (var i = 0; i < document.grouplist.groupid.length; i++ )
          {
             if (document.grouplist.groupid[i].value=="GENERAL" && document.frmdisbaled.generalflag.value=="yes")
             {  
              alert("General is a system defined group and it can't be deleted!"); 
              sFlag=false;
             }
          }
      }    
	 else if( document.grouplist.groupid.value=="GENERAL" && document.frmdisbaled.generalflag.value=="yes")
	 {
        alert("General is a system defined group and it can't be deleted!");
        sFlag=false; 
        
	 }

     if(sFlag==false)
     {
        
        return false;
     }
     else
     {   
        document.frmdisbaled.submit();
        return true;
     }   
}
	