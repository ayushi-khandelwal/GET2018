function checkSignupValidation() {
	return (validateFirstName() && validateLastName() && 
	validateEmail() && validatePassword() && validateConfirmPassword() &&
	validateContactNumber() && validateCompany());
}

function validateFirstName() {
	if(document.getElementById("firstName").value.length < 2 ) {
		alert("Name should be of at least 2 characters");
		document.getElementById("firstName").focus();
		return false;
	}
	
	else if(!(/^[A-z ]+$/.test(document.getElementById("firstName").value))) {
		alert("There should be alphabets only");
		document.getElementById("firstName").focus();
		return false;
	}
	
	return true;
}

function validateLastName() {
	if(document.getElementById("lastName").value.length < 2 ) {
		alert("Name should be of at least 2 characters");
		document.getElementById("lastName").focus();
		return false;
	}
	
	else if(!(/^[A-z ]+$/.test(document.getElementById("firstName").value))) {
		alert("There should be alphabets only");
		document.getElementById("lastName").focus();
		return false;
	}
	
	return true;
}

function validateEmail() {
	if(!(/^\w+([\.-]?\w+)*@[a-zA-Z]+(\.[a-zA-Z]{2,3})+$/.test(document.getElementById("email").value))) {
		alert("Email should contains '@', '.'");
		document.getElementById("email").focus();
		return false;
	}
	return true;
}

function validatePassword() {
	if(document.getElementById("password").value.length < 8) {
		alert("Password should be of atleast 8 characters!!");
		document.getElementById("password").focus();
		return false;
	}
	
	else if(!(/^[A-Z]+[a-z]+[0-9]+$/.test(document.getElementById("password").value))) {
		alert("Password should contain Uppercase, Lowercase, Numeric, Alphanumeric characters!!");
		document.getElementById("password").focus();
		return false;
	}

	return true;
}

function validateConfirmPassword() {
	if(document.getElementById("password").value != document.getElementById("confirmPassword").value) {
		alert("Password does not match!!");
		document.getElementById("confirmPassword").focus();
		return false;
	}
	return true;
}

function validateContactNumber() {
	if(document.getElementById("contactNumber").value.length < 8) {
		alert("Number should be of atleast 8 characters!!");
		document.getElementById("contactNumber").focus();
		return false;
	}
	
	else if(!(/^[0-9]+$/.test(document.getElementById("contactNumber").value))) {
		alert("Number should be atleast of 8 characters!!");
		document.getElementById("contactNumber").focus();
		return false;
	}
	
	return true;
}

function validateCompany() {
	if(document.getElementById("Company").value == "null") {
		document.getElementById("Company").focus();
		alert("Choose your company");
		return false;
	}
	return true;
}
