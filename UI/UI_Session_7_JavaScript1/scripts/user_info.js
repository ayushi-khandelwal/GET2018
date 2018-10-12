window.addEventListener('load', displayDetails);

function displayDetails(event) {
	formDataDiv = document.getElementById("form_data_div");
	var formData = JSON.parse(localStorage.getItem("form_data"));
	for (var index = 0; index < formData.length; index++) {
		createRow(formData[index]);
	}
}

function createRow(rowObject) {
	var newRow = document.createElement("div");
	var label = document.createElement("label");
	var detail = document.createElement("label");
	label.setAttribute( "class","info_label");
	detail.setAttribute( "class","info_value");

	var labelText = document.createTextNode(rowObject["label"]);
	var detailText = document.createTextNode(rowObject["value"]);

	label.appendChild(labelText);
	detail.appendChild(detailText);
	newRow.appendChild(label);
	newRow.appendChild(detail);
	formDataDiv.appendChild(newRow);
}