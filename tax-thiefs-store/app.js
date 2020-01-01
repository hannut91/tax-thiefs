const axios = require('axios');
const geocode = require('./geocoder/geocode');

require('dotenv').config()

// {
//   num: '1', // identifier
//   year: '2019',
//   name: '홍영철',
//   age: '46',
//   shop: '',
//   job: '예술, 스포츠 및 여가관련 서비스업',
//   addr: '서울특별시 강서구 까치산로4길 75-37_화곡동',
//   total: '163,299',
//   taxItem: '부가가치세 등 2',
//   date: '2017-04-30',
//   behiList: '2013년 부가가치세 등 총 9건 163,299 체납'
// },

const URL = 'https://endpoint.ainize.ai/hannut91/tax-thiefs-api/thiefs?page=1';

(async () => {
  
  const { data } = await axios.get(URL);

  data.forEach(async ({addr}) => {
    const coords = await geocode(addr);
    console.log(coords);
  })
})();
