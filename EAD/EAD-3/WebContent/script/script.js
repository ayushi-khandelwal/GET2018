function validate() {
	return (validateName() && validateEmail() && validateAge() );
}

function validateName() {
	var isValid = true;
	var letterNumber = /^[a-zA-Z]+$/;
	if(document.getElementById("firstname").value.length < 2) {
		isValid = false;
		document.getElementById("firstname").setCustomValidity ("Enter name with more than 1 Character");
	}	

	else if(!document.getElementById("firstname").value.match(letterNumber) ) {
		
		isValid = false;
		document.getElementById("firstname").setCustomValidity ("Enter correct first name");
	}

	else if(document.getElementById("lastname").value.length < 2) {
		isValid = false;
		document.getElementById("lastname").setCustomValidity ("Enter name with more than 1 Character");
	}	
	
	else if(!document.getElementById("lastname").value.match(letterNumber)) {
		isValid = false;
		document.getElementById("lastname").setCustomValidity ("Enter correct last name");
	}

	return isValid;
}


function validateEmail() {
	if ( /^\w+([\.-]?\w+)*@[a-zA-Z]+(\.[a-zA-Z]{2,3})+$/.test(document.getElementById("email").value)) {
		return true;
	}
	document.getElementById("email").setCustomValidity ("You have entered an invalid email address!");
	return false;
}



function validateAge() {
	var isValid = true;
	var rajex = /^[0-9]+$/;
	var age = document.getElementById("age");
	if(!rajex.test(age.value)){
		age.setCustomValidity ("Age should contain only numberic value");
		isValid= false;
	}

	else if(age.value.length >3 || age.value.length<1){
		age.setCustomValidity ("Enter correct age");
		isValid= false;
	}
	return isValid;
}








