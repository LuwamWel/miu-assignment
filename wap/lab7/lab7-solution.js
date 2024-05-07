// 1.====================

let group = {

    title: "Our Group",

    students: ["John", "Pete", "Alice"],

    showList: function () {

        this.students.forEach(function (student) {

            console.log(group.title + ": " + student

            );

        });

    }

};

group.showList();


// 2.=====================
let i = 0;

setTimeout(() => console.log(i), 100); // ?

// assume that the time to execute this function is >100ms

for(let j = 0; j < 100000000; j++) {

  i++;

}
// The scheduled function will run after the for loop.
// In the console it will print: 100000000


