function setUpTips()
{

   maketheBalloon("disab",300,"Denotes the disabled user(s).Contact Intellicue-Administrator for help.");
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
		 	if(document.frmmove.curgroupid.value==document.frmmove.drop_to.value)
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

function deleteu()
{
  if(document.userlist.acctid !=null)
     {
	 if(document.userlist.acctid.length > 1)
         {
	  for (var i = 0; i < document.userlist.acctid.length; i++ )
	  {
		 if ( document.userlist.acctid[i].checked )
		 {
		 	document.frmdelete.curacctid.value = document.userlist.acctid[i].value;
                        var conf = confirm("This will delete following informations ."+
                        " \n 1.User's personal information ."+
                        " \n 2.User's scores ."+
                        " \n 2.User's billing information ."+
                        " \n Do you want to delete "+document.frmdelete.curacctid.value+"?");
		 	if(conf)
		 	{
		 	document.frmdelete.submit();
		 	}
		 }
	   }
	}
	 else if(document.userlist.acctid != null)
	 {
	   	document.frmdelete.curacctid.value = document.userlist.acctid.value;
		 var conf = confirm("This will delete following informations ."+
                        " \n 1.User's personal information ."+
                        " \n 2.User's scores ."+
                        " \n 2.User's billing information ."+
                        " \n Do you want to delete "+document.frmdelete.curacctid.value+"?");
		 	if(conf)
		 	{
		 	document.frmdelete.submit();
		 	}

	 }
     }

}
