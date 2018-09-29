/**
 * Created by yoda on 03/03/18.
 */
import React, { Component } from 'react';
import { connect } from 'react-redux';
import {fetchProducers} from '../actions';
import ProducersList from './ProducersList';

class ProducersContainer extends Component {
    componentDidMount(){
        this.props.fetchData();
    }
    render() {
            if (this.props.hasErrored) {
                return <p>Désolé un erreur s'est produite: {this.props.error}</p>;
            }

            if (this.props.isFetching) {
                return <p>Chargement…</p>;
            }
        return (
            <ProducersList producers={this.props.producers}/>
        )
    }

}
const mapStateToProps = (state) => {
    return {
        producers: state.producersList.producers,
        hasErrored: state.producersList.hasErrored,
        isFetching: state.producersList.isFetching,
        error: state.error
    };
};

const mapDispatchToProps = (dispatch) => {
    return {
        fetchData: () => dispatch(fetchProducers())
    };
};

export default connect(mapStateToProps, mapDispatchToProps)(ProducersContainer);
