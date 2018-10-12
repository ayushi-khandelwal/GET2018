import {add} from './modules/math-functions';

const result = document.getElementById("submitButton");
result.addEventListener("click", function(){

	const number1 = parseInt(document.getElementById("firstNumber").value, 10);
	const number2 = parseInt(document.getElementById("secondNumber").value, 10);
	const resultAdd = document.getElementById('sum');

	resultAdd.textContent = `The sum of ${number1} and ${number2} is ${add(number1)(number2)}.`;

});
