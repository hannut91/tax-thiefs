Feature('Map');

Scenario('See the map', (I) => {
  I.amOnPage('/');
  I.seeElement('#react-naver-map');
});
