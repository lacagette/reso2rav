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
        producers: json._embedded.producteurs
    }
}

export function fetchProducers() {
    return dispatch => {
        dispatch(requestProducers())
        console.log("Request procucteurs");
        return fetch(`${URL}/producteurs`)
            .then(response => response.json())
            .then(json => dispatch(receiveProducers(json)))
    }
}
