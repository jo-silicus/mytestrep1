function checkList() {
	var j=0;
	if(document.compositeForm.users.options.length == 1) {
		alert("Cannot generate composite report for one user");
		return false;
	}
	for(var i=0;i<document.compositeForm.users.options.length;i++) {
		
		if(document.compositeForm.users.options[i].selected) {
			j++;
		}
	
	}
	if(j<2 || j>7) {
		alert("The numbers of users selected must be between 2 and 7");
		return false;
	}

	return true;
}