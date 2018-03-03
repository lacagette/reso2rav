/**
 * Created by yoda on 03/03/18.
 */
import { connect } from 'react-redux';

class ProducersContainer {
    // componentWillMount(){
//     // Todo: Appel du service pour recup des datas
//     this.producers = initialState.producers;
// }
    componentDidMount(){

    }

}
const mapStateToProps = (state) => {
    return {
        producers: state.producers,
        hasErrored: state.producersHasErrored,
        isLoading: state.producersIsLoading
    };
};

export default connect(mapStateToProps)(ProducersContainer);