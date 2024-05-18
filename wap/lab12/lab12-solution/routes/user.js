const express = require('express');
const path = require('path');

const router = express.Router();

router.get('/add', (req, res, next)=>{
    throw new Error('Error!!!');
});

module.exports = router;