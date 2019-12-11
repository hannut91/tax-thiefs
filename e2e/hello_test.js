
Feature('Hello');

Scenario('hello', (I) => {
  I.amOnPage('/');
  I.see('Hello world!');
});
