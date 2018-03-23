import { createStore, applyMiddleware, compose, combineReducers } from 'redux'
import thunk from 'redux-thunk'
import createHistory from 'history/createBrowserHistory';
import { routerMiddleware, routerReducer } from 'react-router-redux';
import producersReducer from '../reducers/producersReducer';
import { createForms, combineForms } from 'react-redux-form';

export const history = createHistory()

const middleware = [
  thunk,
  routerMiddleware(history)
]

const initialState = {}

const initialProducerState = {
  identite: {
    mail: ''
  }
};

const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

const store = createStore(
    combineReducers({
        producersReducer,
        ...createForms({
            producer: initialProducerState
        })
    })
    ,
    initialState,
    composeEnhancers(
        applyMiddleware(...middleware)
    )
)

export default store;







