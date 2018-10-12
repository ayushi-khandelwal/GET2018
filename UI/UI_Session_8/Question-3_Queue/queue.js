"use strict";

function Queue() {
    this.front = -1;
    this.rear = -1;
    this.QueueElements = [];
}

Queue.prototype.enqueue = function (element) {
    if (this.front == -1) {
        this.front++;
        this.QueueElements[++(this.rear)] = element;
    } else {
        this.QueueElements[++(this.rear)] = element;
    }
}

Queue.prototype.dequeue = function () {
    if (this.front > this.rear) {
        alert("No item in queue to dequeue !");
    } else {
        this.QueueElements[this.front] = null;
        this.front++;
    }
}

Queue.prototype.display = function () {
    let elementsString = "";
    for (let i = (this.front); i < this.rear; i++) {
        elementsString += this.QueueElements[i] + ", ";
    }
    elementsString += this.QueueElements[i];
    alert("Queue formed:\n" + elementsString);
}

function takeInput() {
    let queue = new Queue();
    let choice;
    do {
        choice = prompt("Enter Your Choice:\n1. Enqueue\n2. Dequeue\n\n(Press Cancel to exit !)", "");
        if (choice == null || choice == "") alert("Program terminated !");
        else {
            switch (choice) {
                case "1":
                    let element = prompt("Enter the element:", "");
                    queue.enqueue(element);
                    queue.display();
                    break;

                case "2":
                    queue.dequeue();
                    queue.display();
                    break;

                default:
                    alert("Invalid choice given !");
            }
        }
    } while (choice != null && choice != "");
}
