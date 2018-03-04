import fetch from 'cross-fetch';

const URL = 'http://localhost:8080';

export const FETCHING_PRODUCERS = 'FETCHING_PRODUCERS';
function requestProducers() {
    return {
        type: FETCHING_PRODUCERS,
        producers: []
    }
}

export const RECEIVED_PRODUCERS = 'RECEIVED_PRODUCERS';

function receiveProducers(json) {
    return {
        type: RECEIVED_PRODUCERS,
        producers: json._embedded.producteurs
    }
}

export const ERRORED_PRODUCERS = 'ERRORED_PRODUCERS';

function hasErroredProducers(error) {
    return {
        type: ERRORED_PRODUCERS,
        error: error
    }
}

export function fetchProducers() {
    return dispatch => {
        dispatch(requestProducers())

        return fetch(`${URL}/producteurs`)
            .then(response => {
                if (!response.ok) {
                    throw Error(response.statusText);
                }
                 return response.json()
            })
            .then(json => dispatch(receiveProducers(json)))
            .catch(error => dispatch(hasErroredProducers(error.message)))
    }
}
