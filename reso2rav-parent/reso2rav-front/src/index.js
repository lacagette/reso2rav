import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import Store from './store';
import {Provider} from 'react-redux';
import {fetchProducers} from './actions';

const StoreInstance = Store();

StoreInstance.dispatch(fetchProducers()).then(() => console.log(StoreInstance.getState()));

ReactDOM.render(
    <Provider store={StoreInstance}>
    <App />
    </Provider>
    , document.getElementById('root'));
// registerServiceWorker();
