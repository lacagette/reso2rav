import React from 'react';
import Producer from './Producer';
import { connect } from 'react-redux';

class ProducersList extends React.Component{
    constructor(props){
        super(props);
        this.producers=[
	        { id: 1, firstName: "Bob", lastName: "Léponge", address: "Au fond a droite", products: "Légumes", isDisabled: false},
	        { id: 2, firstName: "Robert", lastName: "Dacier", address: "Au fond a gauche", products: "Fruits", isDisabled: true}
	    ];
    }
    // componentWillMount(){
    //     // Todo: Appel du service pour recup des datas
    //     this.producers = initialState.producers;
    // }
    componentDidMount(){

    }
    render(){
        return(
            <div>
                <h2>Liste des producteurs:</h2>
                <ul>
                    {
                    	this.producers.map((producer, index) => (
                        <Producer key={index} producer={producer}/>
                        ))
                    }
                </ul>
            </div>
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


export default connect(mapStateToProps)(ProducersList);