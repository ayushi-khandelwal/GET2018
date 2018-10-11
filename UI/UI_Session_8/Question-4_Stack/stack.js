"use strict";

function Stack() {
    this.top = -1;
    this.stackSize = 0;
    this.stackElements = [];
}

Stack.prototype.push = function(element) {
    if (this.top == this.stackSize -1) {
        alert("Stack Overflowed !");
    } else {
        this.stackElements[++(this.top)] = element;
    }
}

Stack.prototype.pop = function() {
    if (this.top == -1) {
        alert("Stack underflowed !");
    } else {
        this.stackElements[this.top] = null;
        this.top--;
    }
}

Stack.prototype.display = function() {
    let elementsString = "";
    for (let i = (this.top); i > 0; i--) {
        elementsString += this.stackElements[i] + "\n";
    }
    elementsString += this.stackElements[i];
    alert("Stack formed:\n" + elementsString);
}

function takeInput() {
    let stack = new Stack();
    let stackSize = prompt("Enter the stack size:", "");
    let choice;
    if (stackSize != null && stackSize != "") {
        stack.stackSize = stackSize;
        do {
            choice = prompt("Enter Your Choice:\n1. Push\n2. Pop\n\n(Press Cancel to exit !)", "");
            if (choice == null || choice == "") alert("Program terminated !");
            else {
                switch (choice) {
                    case "1":
                        let element = prompt("Enter the element:", "");
                        stack.push(element);
                        stack.display();
                        break;

                    case "2":
                        stack.pop();
                        stack.display();
                        break;

                    default:
                        alert("Invalid choice given !");
                }
            }
        } while (choice != null && choice != "");
    } else {
        alert("Operation has been cancelled !");
    }
}
