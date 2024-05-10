
//1. Use constructor function to implement a Singly LinkedList.

// Node constructor 
function Node(data) {
    this.data = data;
    this.next = null;
}
//constructor function
function LinkedList() {
    this.head = null;

    // Add a new node to the end of the list
    this.add = function(data) {
        const newNode = new Node(data);
        if (!this.head) {
            this.head = newNode;
        } else {
            let current = this.head;
            while (current.next) {
                current = current.next;
            }
            current.next = newNode;
        }
    };

    // Remove a node 
    this.remove = function(data) {
        if (!this.head) {
            return;
        }
        if (this.head.data === data) {
            this.head = this.head.next;
            return;
        }
        let current = this.head;
        while (current.next) {
            if (current.next.data === data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    };

    // Print 
    this.print = function() {
        let current = this.head;
        let result = 'LinkedList{';
        while (current) {
            result += current.data;
            if (current.next) {
                result += ',';
            }
            current = current.next;
        }
        result += '}';
        console.log(result);
    };
}

//test
let linkedlist = new LinkedList();

linkedlist.add(1);
linkedlist.add(2);
linkedlist.add(3);

linkedlist.print(); // Expected Result: LinkedList{1,2,3};

linkedlist.remove(2);

linkedlist.print(); // Expected Result: LinkedList{1,3};



// 2.

//Constructor function
function Student(firstName, lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.grades = [];


    //input new grade
    this.inputNewGrade = function(newGrade) {
        this.grades.push(newGrade);
    };

    //compute average grade
    this.computeAverage = function() {
        if (this.grades.length === 0) {
            return 0; // Return 0 if no grades are available
        }
        const sum = this.grades.reduce((acc, cur) => acc + cur, 0);
        return sum / this.grades.length;
    };
}

let student1 = new Student("John", "Smith");
let student2 = new Student("Edward", "Smithon");

//test
student1.inputNewGrade(90);
student1.inputNewGrade(80);
student2.inputNewGrade(88);
student2.inputNewGrade(92);

console.log(student1.computeAverage()); 
console.log(student2.computeAverage()); 
