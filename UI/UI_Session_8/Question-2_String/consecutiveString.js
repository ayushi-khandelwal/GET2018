function removeConsecutiveRepeatedCharacters(inputString) {
   var counter = 0, flag = 0;
      
   for (counter = 0; counter < inputString.length - 1; counter++) {
       var repeatedElements = inputString[counter];
       while (inputString[counter] == inputString[counter + 1] ) {
           flag = 1;
           repeatedElements = repeatedElements + inputString[counter + 1];
           counter++;
       }
       if (flag == 1) {
           inputString = inputString.replace(repeatedElements, "");
           flag = 0;
           counter = -1;
       }
   }
   return inputString;
}
function takeInput() {
    inputString = prompt("Enter String:\n(Press Cancel to exit !)", "");
    if (inputString == null || inputString == "") alert("Program terminated !");
    else {
       alert("String after removal of repeated elements:\n\n"+removeConsecutiveRepeatedCharacters(inputString));
    }
}
