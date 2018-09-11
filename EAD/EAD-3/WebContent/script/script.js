function validate() {
	return (validateName() && validateCompany() && validateEmail()
			&& validatePassword() && validateAge() && matchConfirmPassword() && validateContact());
}

function validateAge() {
	if (document.getElementById("age").value < 0) {
		document.getElementById("age").setCustomValidity("Enter correct age");
		age.focus();
	}
}

function validateName() {
	var isValid = true;
	var letterNumber = /^[a-zA-Z]+$/;
	if (document.getElementById("firstname").value.length < 2) {
		isValid = false;
		document.getElementById("firstname").setCustomValidity(
				"Enter name with more than 1 Character");
		firstname.focus();
	}

	else if (!document.getElementById("firstname").value.match(letterNumber)) {

		isValid = false;
		document.getElementById("firstname").setCustomValidity(
				"Enter correct first name");
		firstname.focus();
	}

	else if (document.getElementById("lastname").value.length < 2) {
		isValid = false;
		document.getElementById("lastname").setCustomValidity(
				"Enter name with more than 1 Character");
		lastname.focus();
	}

	else if (!document.getElementById("lastname").value.match(letterNumber)) {
		isValid = false;
		document.getElementById("lastname").setCustomValidity(
				"Enter correct last name");
		lastname.focus();
	}

	return isValid;
}

function validateCompany() {
	if (document.getElementById("Company").value == "null") {
		document.getElementById("Company").setCustomValidity(
				"Please select college");
		Company.focus();
		return false;
	}
	return true;
}

function validateEmail() {
	if (/^\w+([\.-]?\w+)*@[a-zA-Z]+(\.[a-zA-Z]{2,3})+$/.test(document
			.getElementById("email").value)) {
		return true;
	}
	document.getElementById("email").setCustomValidity(
			"You have entered an invalid email address!");
	email.focus();
	return false;
}

function validatePassword() {
	var isValid = true;
	var myPassword = document.getElementById("password");
	if (!/[a-z]/.test(myPassword.value)) {
		document.getElementById("password").setCustomValidity(
				"Password should contain atleast one LowerCase Alphabet");
		myPassword.focus();
		isValid = false;
	} else if (!/[A-Z]/.test(myPassword.value)) {
		document.getElementById("password").setCustomValidity(
				"Password should contain atleast one UpperCase Alphabet");
		myPassword.focus();
		isValid = false;
	}
}