exports.config = {
  tests: './e2e/*_test.js',
  output: './output',
  helpers: {
    Puppeteer: {
      url: 'http://localhost:3000',
      show: true
    }
  },
  include: {},
  bootstrap: null,
  mocha: {},
  name: 'tax-thiefs'
}
