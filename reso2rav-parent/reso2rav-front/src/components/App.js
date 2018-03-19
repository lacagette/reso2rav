import React from 'react';
import { Link, Switch, Route } from 'react-router-dom';
import Accueil from './Accueil';
import ProducersContainer from './ProducersContainer';
import ProducerForm from './ProducerForm';

const App = () => (
  <div className="App">
	  <header className="App-header">
		  <h1 className="App-title">Reseau de ravitaillement</h1>
		  <nav>
        <Link to='/'>Accueil</Link>
        <Link to='/producteurs'>Producteurs</Link>
        <Link to='/testForm'>Test du LocalForm</Link>
	    </nav>
	  </header>
	  <main>
	  <Switch>
	    <Route exact path='/' component={Accueil}/>
	    <Route exact path='/producteurs' component={ProducersContainer}/>
		<Route exact path='/testform' component={ProducerForm}/>
	  </Switch>
	</main>
  </div>
)

export default App
