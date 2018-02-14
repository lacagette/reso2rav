import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux'
import { BrowserRouter } from 'react-router-dom'
import store, { history } from './store'
import './global.css';
import App from './components/App';

ReactDOM.render(
	    <Provider store={store}>
	        <BrowserRouter history={history}>
	            <App />
	        </BrowserRouter>
	    </Provider>,
	    document.getElementById('root')
);