const bodyParser = require('body-parser');
const express = require('express');
const morgan = require('morgan');
const session = require('express-session');

// internal app deps
const datastore = require('./datastore');
const authProvider = require('./auth-provider');

const app = express();
app.use(morgan('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));
app.set('trust proxy', 1); // trust first proxy
app.use(session({
  genid: function (req) {
    return authProvider.genRandomString()
  },
  secret: 'xyzsecret',
  resave: false,
  saveUninitialized: true,
  cookie: {secure: false}
}));
const deviceConnections = {};

const appPort = process.env.PORT || "3000";

const server = app.listen(appPort, function () {
  const host = server.address().address;
  const port = server.address().port;
  console.log('Smart Home Cloud and App listening at %s:%s', host, port);

  authProvider.registerAuth(app);
});
