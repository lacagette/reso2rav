import React, { Component } from 'react';

class Producer extends Component {
    constructor(props){
        super(props);
        this.producer = props.producer;
    }
    render() {
        return <li style={{ textDecoration : this.producer.isDisabled ?'line-through':'none'}}>
            Prénom: {this.producer.identite.prenom} Nom: {this.producer.identite.nom} Adresse: {this.producer.adresse.nomVoie}
        </li>
    }
}

export default Producer;