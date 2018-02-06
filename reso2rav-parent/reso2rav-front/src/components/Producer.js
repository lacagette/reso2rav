import React from 'react';
import PropTypes from 'prop-types';

class Producer extends React.component {
    constructor(props){
        super(props);
        this.state = {
            id,
            firstName: "Bob",
            lastName: "Léponge",
            address: "Au fond a droite",
            products: "Légumes",
            isDisabled: true

        }
    }
    render() {
        return <li
        style={{ textDecoration : this.state.isDisabled ?'line-through':'none'}}
        >
            Prénom: {this.state.firstName}
            Nom: {this.state.lastName}
            Adresse: {this.state.address}
            Produits: {this.state.products}
        </li>
    }
}