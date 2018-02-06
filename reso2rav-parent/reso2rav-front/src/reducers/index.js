import { combineReducers } from 'redux';
import producerReducer from './producersReducer';
const rootReducer = combineReducers({
    // Todo: Ajouter ici les reducers pour chaque composant
    producerReducer
});
export default rootReducer;