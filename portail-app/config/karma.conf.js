module.exports = function (config) {
  const testWebpackConfig = require('./webpack.test.js');
  const configuration = {
    basePath: '',
    frameworks: ['jasmine'],
    exclude: [],
    files: [
      {pattern: './config/spec-bundle.js', watched: false},
    ],
    preprocessors: {
      './config/spec-bundle.js': ['coverage', 'webpack', 'sourcemap'],
    },
    webpack: testWebpackConfig,
    coverageReporter: {
      type: 'in-memory'
    },
    remapCoverageReporter: {
      'text-summary': null,
      html: './coverage/html',
      lcovonly: './coverage/lcov.info',
    },
    webpackMiddleware: {stats: 'errors-only'},
    reporters: ['mocha', 'coverage', 'remap-coverage'],
    port: 9876,
    colors: true,
    logLevel: config.LOG_INFO,
    autoWatch: true,
    browsers: ['Chrome'],
    customLaunchers: {
      ChromeTravisCi: {
        base: 'Chrome',
        flags: ['--no-sandbox'],
      },
    },
    singleRun: true,
  };

  if (process.env.TRAVIS) {
    configuration.browsers = [
      'ChromeTravisCi'
    ];
  }

  config.set(configuration);
};
