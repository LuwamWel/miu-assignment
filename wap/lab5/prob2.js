let strArray = [ "javascript","at", "maharishi", "university"];

function getNewArray(arr){
    let newArray = 
      arr.filter(ele=> ele.length >= 5 &&  ele.includes('a'));
      console.log(newArray);
}

getNewArray(strArray);