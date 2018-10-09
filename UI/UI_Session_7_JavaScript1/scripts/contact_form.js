window.addEventListener('load', init);

function init() {
	debugger;
	first_name_element = document.getElementsByName("firstName")[0];
	last_name_element = document.getElementsByName("lastName")[0];
	email_element = document.getElementsByName("email")[0];
	phone_number_element = document.getElementsByName("phone")[0];
	state_element = document.getElementsByName("state")[0];
	/*
	first_name_element.addEventListener('change', restoreDefaults);*/
/*	first_name_element.addEventListener('focusout', validateName(this));
	last_name_element.addEventListener('focusout', validateName(this));
	email_element.addEventListener('focusout', validateEmail(this));
	phone_number_element.addEventListener('focusout', validatePhone(this));
	state_element.addEventListener('focusout', validateState(this));*/

	first_name_element.addEventListener('change', restoreDefaults);
	last_name_element.addEventListener('change', restoreDefaults);
	email_element.addEventListener('change', restoreDefaults);
	phone_number_element.addEventListener('change', restoreDefaults);
	state_element.addEventListener('change', restoreDefaults);

	/*zipcode_element.addEventListener('focus', restoreDefaults);
	website_element.addEventListener('focus', restoreDefaults);
	hosting_available_element.addEventListener('focus', restoreDefaults);
	project_desc_element.addEventListener('focus', restoreDefaults);*/
} 

function restoreDefaults(event) {
	event.target.setCustomValidity("");
}

function validate() {
	debugger;
	errorList = [];
	isFormValid = true;

	zipcode_element = document.getElementsByName("zipCode")[0];
	website_element = document.getElementsByName("websiteName")[0];
	hosting_available_element = document.getElementsByName("host")[0];
	project_desc_element = document.getElementsByName("projectDesc")[0];

	if (typeof(zipcode_element) != 'undefined') {
		alert("zip val")
		zipcode_element.addEventListener('change', restoreDefaults);
	}
	if (typeof(website_element) != 'undefined') {
		website_element.addEventListener('focus', restoreDefaults);
	}
	if (typeof(hosting_available_element) != 'undefined') {
		hosting_available_element.addEventListener('focus', restoreDefaults);
	}
	if (typeof(project_desc_element) != 'undefined') {
		project_desc_element.addEventListener('focus', restoreDefaults);
	}
/*
	checkEmpty();*/
	validateName(first_name_element);
	validateName(last_name_element);
	validateEmail(email_element);
	validatePhone(phone_number_element);
	validateState(state_element);
	validateZipCode(zipcode_element);
	validateDomainName(website_element);
	validateProjectDesc(project_desc_element);

	if(!isFormValid) {
		var alertMessage = "";
		for(index = 0; index < errorList.length; index++) {
			alertMessage += errorList[index]["label"] + " : " + errorList[index]["errorMessage"] + "\n";
		}
		alert(alertMessage);
	} else {
		getFeedbackDetail();
	}

	return isFormValid;
/*
	if(checkEmpty() && validateFirstName() && validateLastName() && 
		validateEmail() && validatePhone() && validateState() && 
		validateZipCode() && validateDomainName()) {
		return true;
	}
	
	return false;*/
}
/*
function checkEmpty() {
	if(document.getElementById("firstName").value.length == 0) {
		document.getElementById("firstName").setCustomValidity(
				"Please fill out this field");
		firstName.focus();
		return false;
	}

	else if(document.getElementById("lastName").value.length == 0) {
		document.getElementById("lastName").setCustomValidity(
				"Please fill out this field");
		lastName.focus();
		return false;
	}

	else if(document.getElementById("email").value.length == 0) {
		document.getElementById("email").setCustomValidity(
				"Please fill out this field");
		email.focus();
		return false;
	}
	
	else if(document.getElementById("state").value.length == 0) {
		document.getElementById("state").setCustomValidity(
				"Please fill out this field");
		state.focus();
		return false;
	}

	else if(document.getElementById("zipCode").value.length == 0) {
		document.getElementById("zipCode").setCustomValidity(
				"Please fill out this field");
		zipCode.focus();
		return false;
	}

	else if (!document.getElementById("projectDesc").value.length == 0) {

		document.getElementById("projectDesc").setCustomValidity(
				"Please fill out this field");
		projectDesc.focus();
		return false;
	}
	return true;
}

*/
function validateName(element) {
	if (!element.value.match("[a-zA-Z]{2,}")) {
		var name = "";
		if (element == first_name_element) {
			name = "First name"
		} else {
			name = "Last name";
		}
		errorList.push({ 
			label : name,
			errorMessage : name + " is invalid."
		});
		element.setCustomValidity("Name should be at least 2 character long with only alphabets!");
		// element.style.border="1px solid red";
		isFormValid = false;
	} else {
		// element.style.border="1px solid green";
	}
}

function validateEmail(element) {
	if (!/^\w+([\.-]?\w+)*@[a-zA-Z]+(\.[a-zA-Z]{2,3})+$/.test(element.value)) {
		errorList.push({ 
			label : "Email",
			errorMessage : "Please enter a valid email."
		});
		element.setCustomValidity("Please enter a valid email!");
		// element.style.border="1px solid red";
		isFormValid = false;
	} else {
		// element.style.border="1px solid green";
	}
}

function validatePhone(element) {
	if (!element.value.match("[0-9]{10}")) {
		errorList.push({ 
			label : "Phone Number",
			errorMessage : "Phone number is invalid."
		});
		element.setCustomValidity("Please enter a valid phone number!");
		// element.style.border="1px solid red";
		isFormValid = false;
	} else {
		// element.style.border="1px solid green";
	}
}

function validateState(element) {
	if (!element.value.match("[a-zA-Z]{2,}")) {
		errorList.push({ 
			label : "State",
			errorMessage : "Please select state."
		});
		element.setCustomValidity("Please select state!");
		// element.style.border="1px solid red";
		isFormValid = false;
	} else {
		// element.style.border="1px solid green";
	}
}

function validateZipCode(element) {
	if (typeof(element) != 'undefined') {
		if (!/^[0-9]{6}$/.test(element.value)) {
			errorList.push({ 
				label : "Zipcode",
				errorMessage : "Please enter zipcode."
			});
			element.setCustomValidity("Please enter a valid zipcode!");
			// element.style.border="1px solid red";
			isFormValid = false;
		} else {
			// element.style.border="1px solid green";
		}
	}
}

function validateDomainName(element) {
	if (typeof(element) != 'undefined') {
		if ( !/(http(s)?:\/\/.)?\w+([\.-]?\w+(\/.)*)*/.test(element.value)) {
			errorList.push({ 
				label : "Website",
				errorMessage : "Please enter your website or domain."
			});
			element.setCustomValidity("Please enter your website or domain!");
			// element.style.border="1px solid red";
			isFormValid = false;
		} else {
			// element.style.border="1px solid green";
		}
	}
}

function validateProjectDesc(element) {
	if (typeof(element) != 'undefined') {
		if(element.value == "")	{
			errorList.push({ 
				label : "Project Description",
				errorMessage : "Please enter project description."
			});
			element.setCustomValidity("Please enter project description!");
			// element.style.border="1px solid red";
			isFormValid = false;
		} else {
			// element.style.border="1px solid green";
		}
	}
}

function getFeedbackDetail() {
	var formData = [];
	var form = document.getElementById("contactForm");
	for (var i = 0; i < form.elements.length; i++) {
		if((form.elements[i].type == 'radio' && form.elements[i].checked == false) || form.elements[i].value == "") {
			continue;
		}
		formData.push({
			label : getLabelName(form.elements[i].name),
			value : form.elements[i].value
		});
	}
	localStorage.setItem("form_data", JSON.stringify(formData));
}

function getLabelName(elementName) {
	switch(elementName) {
		case 'firstName' : return 'First Name';
		case 'lastName' : return 'Last Name';
		case 'email' : return 'Email';
		case 'phone' : return 'Phone Number #';
		case 'address' : return 'Address';
		case 'city' : return 'City';
		case 'state' : return 'State';
		case 'zipCode' : return 'Zip Code';
		case 'address' : return 'Address';
		case 'websiteName' : return 'Website or Domain name';
		case 'host' : return 'Hosting Availability';
		case 'projectDesc' : return 'Project Description';
		default : return 'Other';
	}
}

	
/*	else if(document.getElementById("phone").value.length == 0) {
		document.getElementById("phone").setCustomValidity(
				"Please fill out this field");
		phone.focus();
		return false;
	}
	
	else if(document.getElementById("address").value.length == 0) {
		document.getElementById("address").setCustomValidity(
				"Please fill out this field");
		address.focus();
		return false;
	}
	
	else if(document.getElementById("city").value.length == 0) {
		document.getElementById("city").setCustomValidity(
				"Please fill out this field");
		city.focus();
		return false;
	}

	else if (document.getElementById("websiteName").value.length == 0) {
		document.getElementById("websiteName").setCustomValidity(
				"Please fill out this field");
		websiteName.focus();
		return false;
	}

	else if (!document.getElementById("host").value.length == 0) {

		document.getElementById("host").setCustomValidity(
				"Please fill out this field");
		host.focus();
		return false;
	}
*/