function removeRepeatedElements(userString) {
    var startIndexOfRepString = 0;
    var endIndexOfRepString = 0;
    for (var index = 1; index < userString.length; index++) {
        if (userString.slice(index, index + 1) === userString.slice(index - 1, index)) {
            endIndexOfRepString = index;
        }
        else {
            if ((endIndexOfRepString - startIndexOfRepString) <= 0) {
                startIndexOfRepString = index;
                continue;
            }
            else {
                return removeRepeatedElements(userString.slice(0, startIndexOfRepString) +
                userString.slice(endIndexOfRepString + 1, userString.length + 1));
            }
        }
    }
    return userString;
}

function takeInput() {
    userString = prompt("Enter String:\n(Press Cancel to exit !)", "");
    if (userString == null || userString == "") alert("Program terminated !");
    else {
       alert("String after removal of repeated elements:\n\n"+removeRepeatedElements(userString));
    }
}