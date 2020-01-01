const axios = require('axios');

const geocode = async (address) => {
  const URL = `https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=${encodeURIComponent(address)}`;

  const config = {
    headers: {
      'X-NCP-APIGW-API-KEY-ID': process.env.API_KEY_ID,
      'X-NCP-APIGW-API-KEY': process.env.API_KEY,
    },
  };
  const { data } = await axios.get(URL, config);
  const { addresses } = data;
  return {
    lat: addresses[0].y,
    long: addresses[0].x,
  };
};

module.exports = geocode;
