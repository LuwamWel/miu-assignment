console.log("1---Using self---")

let group1 = {

    title: "Our Group",

    students: ["John", "Pete", "Alice"],

    showList: function () {
        const self = this;
        this.students.forEach(function (student) {
            console.log(self.title + ": " + student);
        });
    }
};
group1.showList();


console.log("2---Using arrow function---")

let group2 = {

    title: "Our Group",

    students: ["John", "Pete", "Alice"],

    showList: function () {
        this.students.forEach((student) => {
            console.log(this.title + ": " + student);
        });
    }
};
group2.showList();


console.log("3---Using call---")

let group3 = {

    title: "Our Group",

    students: ["John", "Pete", "Alice"],

    showList: function () {
        this.students.forEach(s=> function(student){
            console.log(this.title + ": " + student);
        }.call(this, s));
    }
};
group3.showList();


console.log("4---Using bind---")

let group4 = {

    title: "Our Group",

    students: ["John", "Pete", "Alice"],

    showList: function () {
        this.students.forEach(function(student){
            console.log(this.title + ": " + student);
        }.bind(group4));
    }
};
group4.showList();


console.log("5---Using group5.---")

let group5 = {

    title: "Our Group",

    students: ["John", "Pete", "Alice"],

    showList: function () {
        this.students.forEach(function (student) {
            console.log(group5.title + ": " + student
            );
        });
    }
};
group5.showList();


// Question 2
let i = 0;

setTimeout(() => console.log(i), 100); // ?

// assume that the time to execute this function is >100ms

for(let j = 0; j < 100000000; j++) {

  i++;

}
// The scheduled function will run after the for loop.
// In the console it will print: 100000000


