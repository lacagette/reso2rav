import { combineReducers } from 'redux';
import { routerReducer } from 'react-router-redux';
import producersReducer from './producersReducer';

const rootReducer = combineReducers({
    // Todo: Ajouter ici les reducers pour chaque composant
	// routerReducer,
    producersReducer
});
export default rootReducer;