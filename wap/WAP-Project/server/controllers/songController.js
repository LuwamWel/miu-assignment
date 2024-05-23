const Song = require('../models/song');

exports.getAllSongs = (req,res)=>{
    res.json(Song.getAllSongs());
}