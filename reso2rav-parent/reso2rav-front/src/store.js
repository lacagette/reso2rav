import { createStore, applyMiddleware, compose } from 'redux';
import thunkMiddleware from 'redux-thunk';
import rootReducer from  './reducers';
import initialState  from './initialState';
import producersReducer from './reducers/producersReducer';
import {fetchProducers} from './actions';

const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

const store =  createStore(
    //rootReducer,
    producersReducer,
    initialState,
    composeEnhancers(
        applyMiddleware(thunkMiddleware)
    )
);

store.dispatch(fetchProducers()).then(() => console.log(store.getState()));


export default store;