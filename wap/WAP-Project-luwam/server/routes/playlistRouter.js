const express = require('express');
const router = express.Router();

const playListController=require('../controllers/playlistController');

router.post('/',playListController.addToPlayList);
router.get('/:username',playListController.getUserPlayList);
router.delete('/:username/:songId',playListController.removeFromPlaylist);

module.exports = router;