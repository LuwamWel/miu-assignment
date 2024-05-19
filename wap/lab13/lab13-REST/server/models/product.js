
let products =[ {id: 1, title: 'Node.js', price: 199, description: 'Good'},
                {id: 2, title: 'Angular.js', price: 299, description: 'Good 2'},
                {id: 3, title: 'React.js', price: 399, description: 'Good 3'}

              ];
              let idCounter = 4;

module.exports = class Product {
    constructor(id, title, price, description){
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
    }

    static getAll(){
        return products;
    }
    static getProductById(id){
        const prod = products.find(p => p.id === id);
        if(prod){
            return prod;
        }else{
            throw new Error(`No product found with Id: ${id}`);
        }
    }

    save(){
        this.id = idCounter++;
        products.push(this);
        return this;
    }

    static deleteById(id){
        const index = products.findIndex(p => p.id === id);
        if(index > -1){
            // products = products.filter(p => p.id !== id );
            const temp = products[index];
            products.splice(index, 1);
            idCounter--;
            return temp;
        }else{
            throw new Error(`No product found with Id: ${id}`);
        }
    }

    update(id){
        const index = products.findIndex(p => p.id === id);
        if(index > -1){
            this.id = id;
            products[index] = this;
        }else{
            throw new Error(`No product found with Id: ${id}`);
        }
    }


}