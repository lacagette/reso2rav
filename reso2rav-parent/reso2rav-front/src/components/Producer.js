import React, { Component } from 'react';

class Producer extends Component {
    constructor(props){
        super(props);
        this.producer = props.producer;
    }
    render() {
        return <li style={{ textDecoration : this.producer.isDisabled ?'line-through':'none'}}>
            Prénom: {this.producer.firstName} Nom: {this.producer.lastName} Adresse: {this.producer.address} Produits: {this.producer.products}
        </li>
    }
}

export default Producer;