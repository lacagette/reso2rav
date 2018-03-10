import React, { Component } from 'react';
import Producer from './Producer';

class ProducersList extends Component{

    render(){
    if (!this.props.producers) {
            return(
                <div>
                    <h2>Liste des producteurs: Vide!</h2>
                </div>
            )
        }
        return(
            <div>
                <h2>Liste des producteurs:</h2>
                <ul>
                    {
                    	this.props.producers.map((producer, index) => (
                        <Producer key={index} producer={producer}/>
                        ))
                    }
                </ul>
            </div>
        )
    }
}




export default ProducersList;