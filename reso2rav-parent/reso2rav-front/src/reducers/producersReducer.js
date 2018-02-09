import REQUEST_PRODUCERS from '../actions';
import RECEIVE_PRODUCERS from '../actions';

const producersReducer = (state = [], action) =>{
    switch (action.type) {
        case 'REQUEST_PRODUCERS':
            return Object.assign({},state, {
                isFetching: true
            });
        case 'RECEIVE_PRODUCERS':
            return Object.assign({}, state, {
                isFetching: false,
                producers: action.producers
            })
        default:
            return state;
    }
}
export default producersReducer;