import { combineReducers } from 'redux';
import producersReducer from './producersReducer';
const rootReducer = combineReducers({
    // Todo: Ajouter ici les reducers pour chaque composant
    producersReducer
});
export default rootReducer;