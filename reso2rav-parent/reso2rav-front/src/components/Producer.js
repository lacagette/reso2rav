import React, { Component } from 'react';

class Producer extends Component {
    constructor(props){
        super(props);
        this.producer = props.producer;
    }
    render() {
        return <li style={{ textDecoration : this.producer.isDisabled ?'line-through':'none'}}>
            Exploitation : {this.producer.nomExploitation} Nom: {this.producer.identite.prenom} {this.producer.identite.nom} Adresse: {this.producer.adresse.numero}, {this.producer.adresse.nomVoie}. {this.producer.adresse.lieuDit} {this.producer.adresse.commune} {this.producer.adresse.codePostal}
        </li>
    }
}

export default Producer;