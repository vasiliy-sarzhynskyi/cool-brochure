import React from 'react';
import BrochureApi from '../../api/BrochureApi.jsx';
import GlobalStore from '../../store/GlobalStore.jsx';


export default class Header extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            stores : [],
            selectedStore : null
        };
    }

    componentDidMount() {
        this.onStoresListener = this.onStores.bind(this);
        GlobalStore.addStoresLoadListener(this.onStoresListener);
        if (this.props.grid)  BrochureApi.getStores();
    }

    componentWillUnmount() {
        GlobalStore.removeStoresLoadListener(this.onStoresListener);
    }

    onStores() {
        let defaultStore = GlobalStore.stores[0].id;
        this.setState({
            stores: GlobalStore.stores,
            selectedStore: defaultStore
        });
        BrochureApi.getBrochuresByStore(defaultStore);
        GlobalStore.selectedStore = defaultStore;
    }

    selectStore(event) {
        let storeId = event.target.value;
        this.setState({
            stores: this.state.stores,
            selectedStore: storeId
        });
        BrochureApi.getBrochuresByStore(storeId);
        GlobalStore.selectedStore = storeId;
    }

    back() {
        this.context.router.push('/');
    }

    getGeoLabel() {
        var geoData = "Select Store",
            self = this;
        GlobalStore.stores.map(function(store, i) {
            if (store.id == GlobalStore.selectedStore) {
                geoData = `Selected store location: ${store.geoLocation.latitude}, ${store.geoLocation.longitude}`;
            }
        });
        return geoData;
    }

    render() {

        return (
            <div className="page-header">
                <h2>
                    {this.props.grid ? "" : <span onClick={this.back.bind(this)}
                                                className="back-btn col-sm-4 col-xs-12">&lt; Back</span>
                    }

                    <span className="col-sm-4 hidden-xs">Brand</span>
                    <small className="col-sm-4 hidden-xs">{this.getGeoLabel()}</small>


                    {this.props.grid ?
                        <select className="col-sm-4 col-xs-12" onChange={this.selectStore.bind(this)}>
                            <optgroup label="Stores">

                                {this.state.stores.map(function(store, i){
                                    return <option key={store.id} value={store.id}>{store.name}</option>;
                                })}

                            </optgroup>
                        </select> : ""
                    }
                </h2>
            </div>);
    }
}

Header.propTypes = {
    grid: React.PropTypes.bool
};

Header.contextTypes = {
    router: React.PropTypes.object
};