let a = 1;
let b = 2;

function foo(){
    let a = 3;
    let b = 4;
    Bar(a);
    console.log(a,b);

    function baz(arg1, arg2, arg3){
        console.log(arg1, arg2, arg3);
        
    }
}