const Song = require('./song');

let playlists = [
    { "songId": 1, "username": "Asmina" } ,
    { "songId": 2, "username": "Asmina" } ,
    { "songId": 3, "username": "Bitsuan" } ,
    { "songId": 4, "username": "Bitsuan" } ,
    { "songId": 5, "username": "Luwam" } ,
    { "songId": 6, "username": "Luwam" } ,
    
];

module.exports = class Playlist {

    constructor(username, songId) {
      this.username = username;
      this.songId = songId;
    }

    static getUserPlayLists(username){
        let userPlaylist = playlists.filter(p => p.username === username);
        const songs = Song.getAllSongs();

        return userPlaylist.map(p => {
            const song = songs.find(song => song.id === p.songId);
            return {
                username: p.username,
                songId: p.songId,
                title: song.title,
                url: song.url
            }
        });
    }

    static addToPlaylist(username, songId){
        const song = Song.getAllSongs().filter(s => s.id == songId);
        if (song == null) {
            throw new Error("Song not available");
        }
        const userPlaylist = playlists.filter(s => s.username === username);
        let indx = userPlaylist.findIndex(a => a.songId == songId);
        if (indx < 0) {
            playlists.push({ songId: songId, username: username });
            return this.getPlayListDetails(username);
        }
        else {
            throw new Error("Song already exists");
        }
  }

    static removeFromPlaylist(username, songId){
        const index = playlists.findIndex(p=> p.username==username && p.songId==songId);
        if (index >= 0) {
          const temp = playlists[index];
          playlists.splice(index, 1);
          return temp;
        }
        else{
          throw new Error("No available song with the given id...");
        }
      }

  }