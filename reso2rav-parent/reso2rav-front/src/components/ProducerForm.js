/**
 * Created by yoda on 09/03/18.
 */
import React, { Component } from 'react';
import { LocalForm, Control } from 'react-redux-form';

class ProducerForm extends Component {
    handleSubmit(producer) {
        console.log(producer)
    }
    render() {
        return(
            <LocalForm
                model="producer"
                onSubmit={(producer) => this.handleSubmit(producer)}
            >
                <label htmlFor="producer.identite.prenom">Prénom:</label>
                <Control.text model="producer.identite.prenom" id="producer.identite.prenom" />

                <label htmlFor="producer.identite.nom">Nom de famille:</label>
                <Control.text model="producer.identite.nom" id="producer.identite.nom" />

                <button type="submit">
                    Enregistrer le producteur
                </button>
            </LocalForm>
        )

    }
}

export default ProducerForm;