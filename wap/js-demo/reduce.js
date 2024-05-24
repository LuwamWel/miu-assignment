


let numbers = [1,2,3,4,5, 6,7];

let sum = numbers.reduce((accumulator, currentValue)=>accumulator + currentValue);

console.log(sum)

let doubled = numbers.map((value)=> value *2);
console.log(doubled);

let filtered = numbers.filter((value)=> value > 4);
console.log(filtered);
console.log("===========");

function f(){
    console.log("no argument");
}
function f(x){
    console.log("1 argument " + x );
}

function f(z, y){
    console.log("two arguments "+ z + y);
}

f();
f(3);
f(6,7)
// ====================
function exampleFunction(a, b, c) {
    console.log(arguments);
  }
exampleFunction(1, 'two', true);
  
/*Both the above and below functions output the same result
  However, note that in modern JavaScript, it's often recommended
  to use the rest parameter syntax (...) 
  to gather up an indefinite number of arguments into an actual array
*/
function exampleFunction2(a, b, c) {
    console.log(arguments);
  }
exampleFunction2(1, 'two', true);

console.log("=============~~~~~=============");
async function foo(){
  return;
}


console.log(foo());






