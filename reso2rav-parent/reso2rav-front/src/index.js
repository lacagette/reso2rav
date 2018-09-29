import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux'
import { Router } from 'react-router-dom'
import store, { history } from './store/index'
//import './global.css';
import App from './components/App';

ReactDOM.render(
	    <Provider store={store}>
	        <Router history={history}>
	            <App />
	        </Router>
	    </Provider>,
	    document.getElementById('root')
);
