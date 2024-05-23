let songs = [
  { id: 1, title: 'Bad Romans', releaseDate: '2009/10/1', url: '../audio/bad_romance.mp3' },
  { id: 2, title: 'comfortably numb', releaseDate: '2004/1/2', url: '../audio/comfortably_numb.mp3' },
  { id: 3, title: 'gagnum style', releaseDate: '2012/10/12', url: '../audio/gagnum_style.mp3' },
  { id: 4, title: 'in the end', releaseDate: '2013/10/12', url: '../audio/in_the_end.mp3' },
  { id: 5, title: 'last resort', releaseDate: '2013/10/12', url: '../audio/last_resort.mp3' },

  { id: 6, title: 'last ride with me', releaseDate: '2013/10/12', url: '../audio/last_ride_with_me.mp3' },
  { id: 7, title: 'mission impossible', releaseDate: '2013/10/12', url: '../audio/mission_impossible.mp3' },
  { id: 8, title: 'mocking bird', releaseDate: '2013/10/12', url: '../audio/mocking_bird.mp3' },
  { id: 9, title: 'single lady', releaseDate: '2013/10/12', url: '../audio/single_lady.mp3' },
  { id: 10, title: 'smooth criminal', releaseDate:'2013/10/12', url: '../audio/smooth_criminal.mp3' },
];


module.exports = class Song {
  constructor(id, title, artist, url) {
    this.id = id;
    this.title = title;
    this.artist = artist;
    this.url = url;
  }

  static getAllSongs() {
    return songs;
  };
}