import React from 'react';
import tpl from './BrochureDetails.jsx';
import BrochureApi from '../../api/BrochureApi.jsx';
import GlobalStore from '../../store/GlobalStore.jsx';


export default class BrochureDetails extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            activeIndex: 0,
            activeBrochure: GlobalStore.activeBrochure
        };
    }

    componentDidMount() {
        this.onBrochureDetailsListener = this.onBrochureDetails.bind(this);
        GlobalStore.addBrochureDetailsLoadListener(this.onBrochureDetailsListener);
    }

    componentWillUnmount() {
        GlobalStore.removeBrochureDetailsLoadListener(this.onBrochureDetailsListener);
    }

    onBrochureDetails() {
        this.setState({
            activeBrochure: GlobalStore.activeBrochure,
            activeIndex: this.state.activeIndex
        });
    }

    handleSelect(selectedIndex) {
        this.setState({
            activeIndex: selectedIndex,
            activeBrochure: this.state.activeBrochure
        });
    }

    render() {
        return tpl(this, this.state.activeBrochure.pages);
    }
}

BrochureDetails.contextTypes = {
    router: React.PropTypes.object
};