let myArray = [30,12,40,11,19];

function sum(arr){
    let result  = 
    arr.filter(element=> element > 20)
    .reduce((accumulator, currentVal) => accumulator + currentVal);
    console.log(result);
}
sum(myArray);

