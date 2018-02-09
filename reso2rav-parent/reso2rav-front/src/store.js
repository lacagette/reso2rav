import { createStore, applyMiddleware, compose } from 'redux';
import thunkMiddleware from 'redux-thunk';
import rootReducer from  './reducers';
import initialState  from './initialState';
import producersReducer from './reducers/producersReducer';

const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

export default() => {
    return createStore(
        //rootReducer,
        producersReducer,
        initialState,
        composeEnhancers(
            applyMiddleware(thunkMiddleware)
        )
    );
}