/**
 * Created by yoda on 09/03/18.
 */
import { Component} from 'react';
import { LocalForm, Control } from 'react-redux-form';

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
                <label htmlFor="producer.identite.prenom">Prénom:</label>
                <Control.text model="producer.identite.prenom" id="producer.identite.prenom" />

                <label htmlFor="producer.identite.nom">Nom de famille:</label>
                <Control.text model="producer.identite.nom" id="producer.identite.nom" />

                <button type="submit">
                    Enregistrer le producteur
                </button>
            </Form>
        )

    }
}