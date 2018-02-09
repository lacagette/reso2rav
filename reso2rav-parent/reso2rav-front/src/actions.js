import fetch from 'cross-fetch';

const URL = 'http://localhost:8080';

export const REQUEST_PRODUCERS = 'REQUEST_PRODUCERS';
function requestProducers() {
    return {
        type: REQUEST_PRODUCERS,
        producers: []
    }
}

export const RECEIVE_PRODUCERS = 'RECEIVE_PRODUCERS';
function receiveProducers(json) {
    return {
        type: RECEIVE_PRODUCERS,
        producers: json.data.producers
    }
}

export function fetchProducers() {
    return dispatch => {
        dispatch(requestProducers())
        return fetch(`${URL}/producteurs`)
            .then(response => response.json())
            .then(json => dispatch(receiveProducers(json)))
    }
}
