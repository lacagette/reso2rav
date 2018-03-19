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
                <table class="pure-table pure-table-bordered">
                <thead>
                    <tr>
                      <th>Exploitation</th>
                      <th>Nom</th>
                      <th>Adresse</th>
                    </tr>
                  </thead>
                  <tbody>
                    {
                    	this.props.producers.map((producer, index) => (
                        <Producer key={index} producer={producer}/>
                        ))
                    }
                  </tbody>
                </table>
            </div>
        )
    }
}




export default ProducersList;
