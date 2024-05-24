const express = require('express');
const cors = require('cors');

const userRouter = require('./routes/userRouter');
const songRouter = require('./routes/songRouter');
const playlistRouter = require('./routes/playlistRouter');

const app = express();

app.use(cors());
app.use(express.json());

app.use('/user',userRouter);


app.use('/songs', songRouter);

app.use('/playlists', playlistRouter);

app.use((error, req, res, next) => {
    res.status(500).json({isSuccess:false,message:error.message});
})

app.use((req, res, next) => {
    res.status(404).json({isSuccess:false,message:"Page not found"});
})

app.listen(3000,()=>{
 console.log('listening on port 3000');
});