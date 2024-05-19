const express = require('express');
const path = require('path');
const router = express.Router();

router.get('/add', (req, res, next)=>{
    res.sendFile(path.join(__dirname, '..', 'views', 'index.html'));
});

router.post('/save', (req, res, next)=>{
    console.log(req.body);
    res.status(201).send('product added!');
});

module.exports = router;


