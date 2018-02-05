import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import Store from './store';
import * as Provider from 'react-redux';

const StoreInstance = Store();

ReactDOM.render(
    <Provider store={StoreInstance}>
    <App />
    </Provider>
    , document.getElementById('root'));
registerServiceWorker();
