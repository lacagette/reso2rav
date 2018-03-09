import React, { Component } from 'react';
import PropTypes from 'prop-types';
import {BootstrapTable, TableHeaderColumn} from 'react-bootstrap-table';
import Producer from './Producer';

class ProducersList extends Component{

    componentDidMount(){
      this.props.fetchData()
    }

    render(){
      return(
      <BootstrapTable data={this.props.producers} version='4'>
            <TableHeaderColumn isKey dataField='identite.nom'>Product ID</TableHeaderColumn>
            <TableHeaderColumn dataField='identite.prenom'>Product Name</TableHeaderColumn>
            <TableHeaderColumn dataField='nomExploitation'>Product Price</TableHeaderColumn>
      </BootstrapTable>
)
          // debugger
          // // console.log(producers);
          // if(typeof this.props.producers !== 'undefined'){
          //   debugger
          //   return(
          //     <ul>
          //     {
          //       this.props.producers.map((producer, index) => (
          //         <Producer key={index} producer={producer}/>
          //         ))
          //     }
          //     </ul>
          //   )
          // }
          // else {
          //   return "Coucou"
          // }

    }
}

ProducersList.propTypes={
  producers: PropTypes.array
}

export default ProducersList;
