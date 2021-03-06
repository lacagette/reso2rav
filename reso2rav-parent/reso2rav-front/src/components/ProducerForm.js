/**
 * Created by yoda on 09/03/18.
 */
import React, { Component } from 'react';
import { Form, Control } from 'react-redux-form';
import { connect } from 'react-redux';
import { isEmail, isEmpty } from 'validator';
// import "./forms.css";

const required = str => !isEmpty(str);
const maxLength = (len) => (val) => val.length <= len;
const isNumber = (val) => !isNaN(Number(val));

class ProducerForm extends Component {
    handleSubmit(producer) {
        console.log(producer)
    }

    render() {

        return(
            <Form
                model="producer"
                onSubmit={(producer) => this.handleSubmit(producer)}
            >
                {/*Nom exploitation*/}
                <label htmlFor="producer.nomExploitation">Nom de famille:</label>
                <Control.text model="producer.nomExploitation" id="producer.nomExploitation" />
                {/*Prénom*/}
                <label htmlFor="producer.identite.prenom">Prénom:</label>
                <Control.text model="producer.identite.prenom" id="producer.identite.prenom" />
                {/*Nom de famille*/}
                <label htmlFor="producer.identite.nom">Nom de famille:</label>
                <Control.text model="producer.identite.nom" id="producer.identite.nom" />
                {/*Téléphone*/}
                <label htmlFor="producer.identite.telephone">N° de téléphone:</label>
                <Control.text model="producer.identite.telephone" id="producer.identite.telephone" />
                {/*Email*/}
                <label htmlFor="producer.identite.mail">Email:</label>
                <Control.text model="producer.identite.mail"
                                  id="producer.identite.mail"/>
                {/*N° de rue*/}
                <label htmlFor="producer.adresse.numero">N° de rue:</label>
                <Control.text model="producer.adresse.numero" id="producer.adresse.numero" />
                {/*Nom de rue*/}
                <label htmlFor="producer.adresse.nomVoie">Nom de rue:</label>
                <Control.text model="producer.adresse.nomVoie" id="producer.adresse.nomVoie" />
                {/*Lieu dit*/}
                <label htmlFor="producer.adresse.lieuDit">Lieu-dit:</label>
                <Control.text model="producer.adresse.lieuDit" id="producer.adresse.lieuDit" />
                {/*Commune*/}
                <label htmlFor="producer.adresse.commune">Commune:</label>
                <Control.text model="producer.adresse.commune" id="producer.adresse.commune" />
                {/*Code postal*/}
                <label htmlFor="producer.adresse.codePostal">Code postal:</label>
                <Control.text model="producer.adresse.codePostal" id="producer.adresse.codePostal" />
                <button type="submit">
                    Enregistrer le producteur
                </button>
            </Form>
        )
    }
}

export default connect(null)(ProducerForm);
