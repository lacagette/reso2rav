import React from 'react';
import { Link, Switch, Route } from 'react-router-dom';
import {Navbar, Nav, NavItem} from 'react-bootstrap'
import {LinkContainer} from 'react-router-bootstrap'
import Accueil from './Accueil';
import ProducersContainer from './ProducersContainer';
import ProducerForm from './ProducerForm';

const App = () => (
  <div className="App">
	  <header className="App-header">
		  <h1 className="App-title">Reseau de ravitaillement</h1>
		  <Navbar>
        <Navbar.Header>
          <Navbar.Brand>
            <Link to='/'>Accueil</Link>
          </Navbar.Brand>
        </Navbar.Header>
      </Navbar>
        <Link to='/producteurs'>Producteurs</Link>
        <Link to='/testForm'>Test du LocalForm</Link>
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
