window.onload = function () {
    const audio = document.getElementById('audio');
    const playIcon = document.querySelector('#play-icon');
    const repeatBtn = document.getElementById('repeat');
    let songs = [];
    let playlist = [];
    let currentTrack = 0;
    let playbackMode = 0; 

    

    if(!sessionStorage.getItem('token')){
        window.location.href = '../views/login.html';
    }
    const username=sessionStorage.getItem('token').split('-')[0];

    function Song(id, title, releaseDate, url) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.url = url;
    }

    function Playlist(id, title, url) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.username = username;
    }

    function initialSetup() {
        playbackMode = 0;
        currentTrack = 0;
        document.getElementById('prev').disabled = true;
        document.getElementById('next').disabled = true;
        repeatBtn.disabled = true;
    }

    function addToPlayList(songId) {
        if (playlist.findIndex(a => a.id == songId) < 0) {
            fetch(`http://localhost:3000/playlists`,{
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({username:username,songId:songId}),
            })
            .then(response=>response.json())
            .then(response=>{
                loadPlaylist();
            }).catch(e=>console.log(e.message));
            
        }
        else {
            console.log('song already in the playlist');
        }
    }

    function removeFromPlayList(songId) {
        alert(songId);
        debugger;
        const indeex =playlist.findIndex(a => a.id == songId);
        if ( indeex>= 0) {
            fetch(`http://localhost:3000/playlists/${username}/${songId}`,{
                method: 'DELETE'
            })
            .then(response => response.json())
            .then(response=>{
                debugger
                if (indeex === currentTrack) {
                    audio.pause();
                    document.getElementById('audio-source').removeAttribute('src');
                    if (playIcon != null && playIcon.classList.contains('bi-pause-fill')) {
                        playIcon.classList.remove('bi-pause-fill');
                        playIcon.classList.add('bi-play-fill');
                    }
                    audio.load();
                }
                loadPlaylist();
            }).catch(e=>console.log(e.message));
        }
        else{
            console.log('No song found');
        }
    }

    function loadAllSongs() {
        fetch('http://localhost:3000/songs/all')
            .then(response => response.json())
            .then(lst => {
                songs = [];
                let html=``;
                lst.forEach((song,index) => {
                    songs.push(new Song(song.id, song.title, song.releaseDate, song.url))
                    html += `
                    <tr>
                    <th scope="row">
                        ${song.id}
                        <label hidden="hidden">${song.id}</label>
                    </th>
                    <td>${song.title}</td>
                    <td>${song.releaseDate}</td>
                    <td> <button title="Add to Playlist" class="btn btn-primary btn-sm"><i class="fas fa-plus"></i></button> </td>
                   </tr>`
                });
                document.getElementById('song-list').innerHTML = html;
                document.getElementById('song-list').addEventListener('click', function (event) {
                    if (event.target.closest('.btn')) {
                        const tr = event.target.closest('tr');
                        const songId = tr.querySelector('th:first-child label').textContent;
                        addToPlayList(parseInt(songId));
                    }
                });
            })
    }

    function loadPlaylist() {
        fetch(`http://localhost:3000/playlists/${username}`)
            .then(response => response.json())
            .then(list => {
                playlist = [];
                let html=``;
                list.forEach((item,index) => {
                    playlist.push(new Playlist(item.songId, item.title, item.url,username))
                     html += `
                        <tr>
                            <td>
                                ${item.songId}
                                <label hidden="hidden">${index}</label>
                                <label hidden="hidden">${item.songId}</label>
                            </td>
                            <td>${item.title}</td>
                            <td> 
                                <button title="Delete" class="btn btn-primary btn-sm btn-delete">
                                    <i class="bi bi-trash fa-round"></i>
                                </button>
                                <button title="Play" class="btn btn-secondary btn-sm btn-play">
                                    <i class="bi bi-caret-right-fill"></i>
                                </button>
                            </td>
                        </tr>`;                    
                });
                document.getElementById('playlist').innerHTML = html;
                document.getElementById('playlist').addEventListener('click', function (event) {
                    if (event.target.closest('.btn-play')) {
                        document.getElementById('prev').disabled = false;
                        document.getElementById('next').disabled = false;
                        repeatBtn.disabled = false;
        
                        const tr = event.target.closest('tr');
                        const index = tr.querySelector('td:first-child label:first-child').textContent;
                        currentTrack = parseInt(index);
                        loadTrack(currentTrack);
                    }
        
                    if (event.target.closest('.btn-delete')) {
                        document.getElementById('prev').disabled = false;
                        document.getElementById('next').disabled = false;
                        repeatBtn.disabled = false;
        
                        const tr = event.target.closest('tr');
                        const songId = tr.querySelector('td:first-child label:nth-child(2)').textContent;
                        removeFromPlayList(parseInt(songId));
                    }
                });
            })
    }

    function loadTrack(index) {
        document.getElementById('audio-source').src = playlist[index].url;
        document.querySelectorAll('.selected-row').forEach(function (element) {
            element.classList.remove('selected-row');
            element.style.backgroundColor='';
        });
      
        let row = document.querySelectorAll('#playlist tr');
        row[index].classList.add('selected-row');
        row[index].style.backgroundColor = '#1db954';

        audio.load();
        if (true) {
            audio.play();
        }
    }

    function getNextPrevSong(mode) {
        if (playbackMode == 0) {
            if (mode === 'prev') {
                return (currentTrack > 0) ? currentTrack - 1 : playlist.length - 1;
            }
            else {
                return (currentTrack < playlist.length - 1) ? currentTrack + 1 : 0;
            }
        }
        if (playbackMode == 1) {
            return currentTrack;
        }
        else if (playbackMode == 2) {
            return Math.floor(Math.random() * playlist.length);
        }
    }

    function updateRepeatButton() {
        repeatBtn.classList.remove('btn-info', 'btn-warning', 'btn-success');

        if (playbackMode === 0) {
            repeatBtn.classList.add('btn-info');
            repeatBtn.innerHTML = '<i class="bi bi-arrow-down-up"></i>'; 
        } else if (playbackMode === 1) {
            repeatBtn.classList.add('btn-success');
            repeatBtn.innerHTML = '<i class="bi bi-arrow-repeat"></i>'; 
        } else if (playbackMode === 2) {
            repeatBtn.classList.add('btn-warning');
            repeatBtn.innerHTML = '<i class="bi bi-shuffle"></i>'; 
        }
    }

    document.getElementById('prev').addEventListener('click', function () {
        currentTrack = getNextPrevSong('prev');
        loadTrack(parseInt(currentTrack));
    });

    document.getElementById('next').addEventListener('click', function () {
        currentTrack = getNextPrevSong('next');
        loadTrack(parseInt(currentTrack));
    });


    repeatBtn.addEventListener('click', function () {
        playbackMode = (playbackMode + 1) % 3;
        updateRepeatButton();
    });

    audio.addEventListener('ended', function() {
        document.getElementById('next').click();
    });

    document.getElementById('logout').addEventListener('click', function (event) {
        event.preventDefault();
        sessionStorage.removeItem('token');
        window.location.href = '../views/login.html';
    });


//==============
    function addToPlaylist(button) {
        const row = button.closest('tr');
        const clone = row.cloneNode(true);
        clone.querySelector('button').textContent = '-';
        clone.querySelector('button').className = 'btn btn-danger';
        clone.querySelector('button').onclick = function() { removeFromPlaylist(this); };
        document.querySelector('#your-playlist tbody').appendChild(clone);
    }
    
    function removeFromPlaylist(button) {
        const row = button.closest('tr');
        row.remove();
    }
//==============


    loadAllSongs();
    loadPlaylist();
    initialSetup();
}