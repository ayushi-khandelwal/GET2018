"use strict";

let head = null;

class Node {
    constructor(element) {
        this.previous = null;
        this.element = element;
        this.next = null;
    }
}

function insertNewElement(element) {
    let newNode = new Node(element);
    if(head == null) {
        head = newNode;
    } else {
        let tempNode = head;
        while(tempNode.next != null) {
            tempNode = tempNode.next;
        }
        tempNode.next = newNode;
        newNode.previous = tempNode;
    }
}

function displayLinkedList() {
    let listElements = "";
    if(head != null) {
        let tempNode = head;
        while(tempNode.next != null) {
            listElements += tempNode.element+"<--->";
            tempNode = tempNode.next;
        }
        listElements += tempNode.element;
        alert("Entered List:\n"+listElements);
    } else {
        alert("No data in list !");
    }
}

function takeInput() {
    let elementsCount = prompt("Enter the no. of elements in list:","");
    if(elementsCount != null || elementsCount !="") {
        for(let i=0; i<elementsCount; i++) {
            let element = prompt("Enter element "+(i+1),"");
            (element != null || element != "") ? insertNewElement(element) : alert("You have cancelled the operation!");
        }
        displayLinkedList();
    } else {
        alert("Ok! Thank You");
    }
}

