
function selectRadio(rButton,rButtonIndex){
	if(rButtonIndex == '-1')
		rButton.checked=true;
	else
		rButton[rButtonIndex].checked=true;
}

function lTrim( value ) {
	var re = /\s*((\S+\s*)*)/;
	return value.replace(re, "$1");
}

function rTrim( value ) {
	var re = /((\s*\S+)*)\s*/;
	return value.replace(re, "$1");
}

function trim( value ) {
	return lTrim(rTrim(value));
}

function isElementRequired(elementId,elementName)
{
	if(isElementValueNull(elementId))
	{
		return elementName + " is required.\n";
	}
	
	if(getElementType(elementId)=="select-one" || getElementType(elementId)=="select-multiple")
	{
		if(isComboValueNull(elementId))
		{
			return "Please Select " + elementName + ".\n";
		}
		else{
			return "";
		}
	}
	else{
		return "";
	}	
	
}

function isElementValueNull(elementId)
{
	if(trim(getElementValue(elementId))=="")
	{
		return true;
	}
	else
		return false;
		
}
function isComboValueNull(elementId)
{
	if(trim(getElementValue(elementId))== "-1")
	{
		return true;
	}
	else
	{	
		return false;
	}
}

function getElementValue(elementId)
{
	return document.getElementById(elementId).value;
}

function submitForm(actionType)
{
	document.form.actionType.value = actionType;
	document.forms[0].submit();
}

function cancelForm()
{
	addElementToDocument('_cancel');
	submitForm('_cancel');
}

function finishForm()
{
	addElementToDocument('_finish');
	submitForm('_finish');
}

function addElementToDocument(elementName)
{
	var _target1 = document.createElement("input");
	_target1.setAttribute("type","hidden");
	_target1.setAttribute("value",elementName);
	_target1.setAttribute("name",elementName);
	document.form.appendChild(_target1);
}
function switchForm(pageNo)
{
	addElementToDocument('_target'+pageNo);
	submitForm('_target'+pageNo);
}
function isElementExist(elementId)
{
	if(document.getElementById(elementId))
	{
		return true;
	}
	else
	{
		return false;
	}	
}
function getElementType(elementId)
{
	return document.getElementById(elementId).type;
}

//Leena : 27th March 2010
//Check From date and To date
function validateDate(fromDate,toDate)
{	
	
	if(document.getElementById(fromDate).value!="" && document.getElementById(fromDate).value!=null && document.getElementById(toDate).value!="" && document.getElementById(toDate).value!=null)
	{		  
		var strFromDate= document.getElementById(fromDate).value;
		var strToDate= document.getElementById(toDate).value;
		var fromDate=new Date(strFromDate);
		var toDate=new Date(strToDate);
		
	     if(fromDate > toDate)
	     {
	    	 return "From Date should be less than To Date.\n";	         
	     }	      
	}
	return "";
}

//Check checkboxes are checked or not




