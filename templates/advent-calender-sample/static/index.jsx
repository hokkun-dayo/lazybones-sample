import 'babel-polyfill';
import React from 'react';
import { render } from 'react-dom';
import { addLocaleData, IntlProvider } from 'react-intl';
import { Provider } from 'react-redux';
import App from './containers/App';
import configureStore from './store/configureStore';

const locale = window.LOCALE;

if (!global.Intl) {
  require('intl');
  require.ensure([], () => {
    require('intl/locale-data/jsonp/en.js');
    require('intl/locale-data/jsonp/ja.js');
  });
}

addLocaleData(require('react-intl/locale-data/' + locale));

const store = configureStore()
const messages = require('json!./i18n/' + locale + '.json')

render(
  <Provider store={store}>
    <IntlProvider locale={locale} messages={messages}>
      <App />
    </IntlProvider>
  </Provider>,
  document.getElementById('root')
)
