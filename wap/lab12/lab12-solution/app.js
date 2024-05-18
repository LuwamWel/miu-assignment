const express = require('express');
const path = require('path');
const productRouter = require('./routes/product');
const userRouter = require('./routes/user');

const app = express();

//middleware
app.use('/abc', express.static(path.join(__dirname, 'resources')));
app.use(express.urlencoded());
app.use('/products', productRouter);
app.use('/users', userRouter);

//404 handler
app.use((req, res, next)=>{
    res.sendFile(path.join(__dirname, 'views', '404.html'))
});

//Error handler
app.use((err, req, res, next)=>{
    res.status(500).send('Error occured ....');
});

app.listen(3000, () => console.log('listening on port 3000...'));