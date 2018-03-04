/**
 * Created by yoda on 03/03/18.
 */
import React, { Component } from 'react';
import { connect } from 'react-redux';
import {fetchProducers} from '../actions';
import ProducersList from './ProducersList';

class ProducersContainer extends Component {
    // componentWillMount(){
//     // Todo: Appel du service pour recup des datas
//     this.producers = initialState.producers;
// }
    componentDidMount(){
        this.props.fetchData();
    }
    render() {
        return (
            <ProducersList producers={this.props.producers}/>
        )
    }

}
const mapStateToProps = (state) => {
    return {
        producers: state.producers,
        hasErrored: state.producersHasErrored,
        isLoading: state.producersIsLoading
    };
};

const mapDispatchToProps = (dispatch) => {
    return {
        fetchData: () => dispatch(fetchProducers())
    };
};

export default connect(mapStateToProps, mapDispatchToProps)(ProducersContainer);