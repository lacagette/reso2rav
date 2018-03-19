import { createStore, applyMiddleware, compose } from 'redux'
import { routerMiddleware } from 'react-router-redux'
import thunk from 'redux-thunk'
import createHistory from 'history/createBrowserHistory';
import {routerReducer} from 'react-router-redux';
import producersReducer from '../reducers/producersReducer';

export const history = createHistory()

const initialState = {}
const middleware = [
  thunk,
  routerMiddleware(history)
]

const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

const store = createStore(
    producersReducer,
    initialState,
    composeEnhancers(
      applyMiddleware(...middleware)
  )
)

export default store;







