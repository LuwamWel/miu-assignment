let concat = (str, ...arrays) => {
    let result = str.split('');
    arrays.forEach(array => {
        result = result.concat(array);
    });
    return result;
};

console.log(concat('hi', [1, 2, 3], ['Hello', 'world'])); 