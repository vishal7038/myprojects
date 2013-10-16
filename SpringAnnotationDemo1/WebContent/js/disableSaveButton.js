//disable save button to prevent double click
function disableSaveButton() {
	var submitButton=arguments[0];
	submitButton.value="Please Wait...";
	submitButton.disabled=true;
	document.forms[0].submit();
}