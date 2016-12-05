/*
 * Copyright (c) 2016 LINE Corporation. All rights reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

const path = require('path');
const webpack = require('webpack');

const DEBUG = !process.argv.includes('--release');

module.exports = {
  devtool: DEBUG ? 'cheap-module-eval-source-map' : false,
  entry: [
    './index',
  ],
  output: {
    path: path.join(__dirname, '../src/main/resources/static'),
    filename: 'bundle.js',
  },
  plugins: [
    new webpack.DefinePlugin({
      'process.env.NODE_ENV': JSON.stringify(DEBUG ? 'development' : 'production'),
    }),
    ...(
      DEBUG ? [] : [
        new webpack.BannerPlugin(
          'Copyright (c) 2016 LINE Corporation. All rights reserved.' +
          'LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.'),
        new webpack.optimize.UglifyJsPlugin({
          output: {
            comments: require('uglify-save-license'),
          },
        }),
      ]
    ),
  ],
  module: {
    loaders: [
      {
        test: /\.js$/,
        loaders: ['babel'],
        exclude: /node_modules/,
        include: __dirname,
      },
      {
        test: /\.jsx?$/,
        exclude: /node_modules/,
        loader: 'babel',
        query: {
          plugins: ['transform-react-jsx'],
        },
      },
    ],
  },
  resolve: {
    extensions: ['', '.js', '.jsx'],
  },
};
