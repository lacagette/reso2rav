const URL = 'http://localhost:8080';

export const REQUEST_PRODUCERS = 'REQUEST_PRODUCERS';
export const RECEIVE_PRODUCERS = 'RECEIVE_PRODUCERS';

export function requestProducers() {
    return {
        type: REQUEST_PRODUCERS,
        producers: []
    }
}

export function receiveProducers(json) {
    return {
        type: RECEIVE_PRODUCERS,
        producers: json.data.producers
    }
}

