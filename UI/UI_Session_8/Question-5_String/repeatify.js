"use strict";

String.prototype.repeatifyString = function(countForRepeatation = 0) {
    let returnString = "";
    for(let i=0;i<countForRepeatation;i++) {
        returnString += this;
    }
    return returnString;
}

function takeString() {
    let string = prompt("Enter the String:");
    if(string !=null && string != "") {
        let countForRepeatation = prompt("Enter the repeatation count:");
        if(countForRepeatation !=null && countForRepeatation != "") {
            alert(string.repeatifyString(countForRepeatation));
        } else {
            alert("You have cancelled the operation !");
        }
    } else {
        alert("You have cancelled the operation !");
    }
}