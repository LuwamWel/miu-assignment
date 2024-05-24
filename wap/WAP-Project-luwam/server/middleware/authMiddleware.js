
const User = require('../models/user');

const authenticate = (req, res, next) => {
  const username = req.headers['authorization'];

  if (username && User.getSession(username)) {
    next(); 
  } else {
    res.status(401).json({ error: 'Unauthorized' });
  }
};

module.exports = authenticate;