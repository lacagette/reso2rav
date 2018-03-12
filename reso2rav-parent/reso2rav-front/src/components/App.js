import React from 'react';
import { Link, Switch, Route } from 'react-router-dom';
import logo from '../img/logo.svg';
import Accueil from './Accueil';
import ProducersContainer from './ProducersContainer';
import ProducerForm from './ProducerForm';

const App = () => (
  <div className="App">
	  <header className="App-header">
	  <img src={logo} className="App-logo" alt="logo" />
		  <h1 className="App-title">Reseau de ravitaillement</h1>
		  <nav>
	      <ul>
	        <li><Link to='/'>Accueil</Link></li>
	        <li><Link to='/producteurs'>Producteurs</Link></li>
		    <li><Link to='/testForm'>Test du LocalForm</Link></li>
	      </ul>
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

