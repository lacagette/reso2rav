import React from 'react';
import Producer from './Producer';
import initialState from '../initialState';

class ProducersList extends React.Component{
    constructor(props){
        super(props);
        this.producers= initialState.producers;
    }
    // componentWillMount(){
    //     // Todo: Appel du service pour recup des datas
    //     this.producers = initialState.producers;
    // }
    render(){
        return(
            <div>
                <h2>Liste des producteurs:</h2>
                <ul>
                    {this.producers.map((producer, index) => (
                        <Producer key={index} producer={producer}/>
                    ))}
                </ul>
            </div>
        )
    }
}



export default ProducersList;