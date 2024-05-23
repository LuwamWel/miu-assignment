
let users = [
    {
      username: 'Luwam',
      password: 'luwam111'
    },
    {
      username: 'Asmina',
      password: 'asmina222'
    },
    {
      username: 'Bitsuan',
      password: 'bitsuan'
    }
  ]
  const sessions = {};
  
  module.exports = class User {
  
    constructor(username, password) {
      this.username = username;
      this.password = password;
    }
  
    static findUser = (username, password) => {
      return users.find(user => user.username === username && user.password === password);
    };
  
    static addSession = (token, username) => {
      sessions[token] = username;
    }
  
    static getSession = (token) => {
      return sessions[token];
    }
  
    static removeSession = (token) => {
      delete sessions[token];
    }
  
  };