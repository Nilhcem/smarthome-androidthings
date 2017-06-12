const Data = {};

const Auth = {
  clients: {
    'RKkWfsi0Z9': {
      clientId: 'RKkWfsi0Z9',
      clientSecret: 'eToBzeBT7OwrPQO8mZHsZtLp1qhQbe'
    }
  },
  tokens: {
    'psokmCxKjfhk7qHLeYd1': {
      uid: '1234',
      accessToken: 'psokmCxKjfhk7qHLeYd1',
      refreshToken: 'psokmCxKjfhk7qHLeYd1',
      userId: '1234'
    }
  },
  users: {
    '1234': {
      uid: '1234',
      name: 'rick',
      password: 'oldman',
      tokens: ['psokmCxKjfhk7qHLeYd1']
    }
  },
  usernames: {
    'rick': '1234'
  },
  authcodes: {}
};

Data.version = 0;

Data.getUid = function (uid) {
  return Data[uid];
};

/**
 * checks if user and auth exist and match
 *
 * @param uid
 * @param authToken
 * @returns {boolean}
 */
Data.isValidAuth = function (uid, authToken) {
  return (Data.getUid(uid));
};

exports.getUid = Data.getUid;
exports.isValidAuth = Data.isValidAuth;
exports.Auth = Auth;
