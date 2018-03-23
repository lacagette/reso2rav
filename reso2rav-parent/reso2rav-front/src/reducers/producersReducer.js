const producersReducer = (state = {}, action) => {
    switch (action.type) {
        case 'FETCHING_PRODUCERS':
            return Object.assign({},state, {
                isFetching: true
            });
        case 'RECEIVED_PRODUCERS':
            return Object.assign({}, state, {
                isFetching: false,
                producers: action.producers
            })
        case 'ERRORED_PRODUCERS':
            return Object.assign({}, state, {
                isFetching: false,
                hasErrored: true,
                error: action.error
            })
        default:
            return state;
    }
}
export default producersReducer;