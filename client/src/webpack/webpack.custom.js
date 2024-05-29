const MergeJsonWebpackPlugin = require('merge-jsons-webpack-plugin');
const path = require('path');

module.exports = {
  plugins: [
    new MergeJsonWebpackPlugin({
      output: {
        groupBy: [
          { pattern: "./src/assets/i18n/en/*.json", fileName: "./src/assets/i18n/en.json" },
          { pattern: "./src/assets/i18n/vi/*.json", fileName: "./src/assets/i18n/vi.json" },
          { pattern: "./src/assets/i18n/ko/*.json", fileName: "./src/assets/i18n/ko.json" }
        ]
      },
      globOptions: {
        debug: true // Enable debug mode for more detailed logging
      },
      callback: (result) => {
        console.log('Merged JSON files:', result);
      }
    })
  ]
};
