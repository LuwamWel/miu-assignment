let books = [{bookId: 1, title: "Node.js",
             author: {authorId: 303, firstname : "Edward", lastname : "Jack"} },
            { bookId: 2, title: "Angular",
            author: { authorId: 308, firstname: "John", lastname: "Smith" } }
            ];


let idCounter = 3;

module.exports = class Book {
    constructor(bookId, title, author){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
     }
                
    static getAll(){
        return books;
    }

    static getBookById(id){
        const bk = books.find(b => b.bookId === id);
        if(bk){
            return bk;
        }else{
            throw new Error(`No book found with Id: ${bookId}`);
        }
    }
                
    save(){
        this.bookId = idCounter++;
        books.push(this);
        return this;
    }
                
    static deleteById(id){
        const index = books.findIndex(b => b.bookId === id);
        if(index > -1){
            // books = books.filter(b => b.bookId !== id );
            const temp = books[index];
            books.splice(index, 1);
            idCounter--;
                return temp;
            }else{
                throw new Error(`No book found with Id: ${id}`);
            }
    }
                
    update(id){
        const index = books.findIndex(b => b.bookId === id);
        if(index > -1){
            this.bookId = id;
            books[index] = this;
        }else{
            throw new Error(`No product found with Id: ${id}`);
        }
    }
                
                
}             