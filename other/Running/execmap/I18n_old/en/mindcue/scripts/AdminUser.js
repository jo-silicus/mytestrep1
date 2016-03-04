function setUpTips()
{
	   maketheBalloon("disab",300,"Denotes the disabled user(s).Contact Intellicue-Administrator for help.");
}

function maketheBalloon(id, width, message)
{
   var theString = '<STYLE TYPE="text/css">#'+id+'{width:'+width+';}</STYLE>';
   theString+='<DIV CLASS="balloon" id="'+id+'">'+message+'</DIV>';
   document.write(theString);
}

function move()
{
  if(document.userlist.userid !=null)
     {
	if(document.userlist.userid.length > 1)
         {
	for (var i = 0; i < document.userlist.userid.length; i++ )
	  {
		//  By Parul
		//	changed code as following statement is IE specific and does not work on Netscape
		// this is selected property on radio button which work only on IE
		// instead using checked property
		//if (document.userlist.userid[i].selected )

		 if ( document.userlist.userid[i].checked )
		 {
			// by parul
			//replacing code 
			// if(document.frmmove.groupid.value==document.frmmove.drop_to.value)
			// by 
			//  if(document.frmmove.groupid.value==document.frmmove.drop_to.options[document.frmmove.drop_to.selectedIndex].value)
			// as value property on combo box works on IE and not on netscape.
			 //alert(document.frmmove.groupid.value);
			 //alert(document.frmmove.drop_to.options[document.frmmove.drop_to.selectedIndex].value);
		 	 if(document.frmmove.groupid.value==document.frmmove.drop_to.options[document.frmmove.drop_to.selectedIndex].value)
		 	  {
		 	   alert("Source and destination groups are same !");
		 	  }
		 	else
		 	{
		 	 document.frmmove.curuserid.value = document.userlist.userid[i].value;
		         document.frmmove.submit();
		 	}

		 }
	   }
	}
	 else if(document.userlist.userid != null)
	 {

                 document.frmmove.curuserid.value = document.userlist.userid.value;
		 document.frmmove.submit();
	 }
     }


}
