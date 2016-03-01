function isRequired()
		{
			/* 
			    This function checks if reminder phrase field is blank in which case 
			    a message is displayed and focus is passed to
			    reminder phrase field. If not blank then the form is submitted.
			*/
			if (document.frmSetReminderPhrase.txt_rem_phrase.value == "")
			{
				alert ("Reminder Phrase cannot be left blank. Please fill it in.");
				document.frmSetReminderPhrase.txt_rem_phrase.focus();
			}
			else
				document.frmSetReminderPhrase.submit();
		}