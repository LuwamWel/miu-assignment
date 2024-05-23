
const express=require('express');
const router=express.Router();

const songController=require('../controllers/songController');

router.get('/all',songController.getAllSongs)


module.exports = router;