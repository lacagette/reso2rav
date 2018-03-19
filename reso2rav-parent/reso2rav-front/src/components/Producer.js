import React, { Component } from 'react';

class Producer extends Component {
    constructor(props){
        super(props);
        this.producer = props.producer;
    }
    render() {
        return  <tr>
                  <td>{this.producer.nomExploitation}</td>
                  <td>{this.producer.identite.prenom} {this.producer.identite.nom}</td>
                  <td>{this.producer.adresse.numero}, {this.producer.adresse.nomVoie}. {this.producer.adresse.lieuDit} {this.producer.adresse.commune} {this.producer.adresse.codePostal}</td>
                </tr>
    }
}

export default Producer;
