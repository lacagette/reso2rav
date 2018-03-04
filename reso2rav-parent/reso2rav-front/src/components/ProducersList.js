import React, { Component } from 'react';
import Producer from './Producer';

class ProducersList extends Component{
    constructor(props){
        super(props);
        this.producers=[
	        // { id: 1, firstName: "Bob", lastName: "Léponge", address: "Au fond a droite", products: "Légumes", isDisabled: false},
	        // { id: 2, firstName: "Robert", lastName: "Dacier", address: "Au fond a gauche", products: "Fruits", isDisabled: true}
	    ];
    }

    render(){
        if (!this.props.producers) {
            return(
                <div>
                    Vide!!
                </div>
            )
        }
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




export default ProducersList;