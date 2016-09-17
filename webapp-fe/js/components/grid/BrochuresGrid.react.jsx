import React from 'react';
import tpl from './BrochuresGrid.jsx';
import BrochureApi from '../../api/BrochureApi.jsx';
import GlobalStore from '../../store/GlobalStore.jsx';

export default class BrochuresGrid extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            brochures : GlobalStore.brochures
        };
    }

    componentDidMount() {
        this.onBrochuresListener = this.onBrochures.bind(this);
        GlobalStore.addBrochureDetailsLoadListener(this.onBrochuresListener);
    }

    componentWillUnmount() {
        GlobalStore.removeBrochureDetailsLoadListener(this.onBrochuresListener);
    }

    onBrochures() {
        this.setState({
            brochures: GlobalStore.brochures
        });
    }

    openBrochure(id) {
        BrochureApi.getBrochureDetails(id);
        this.context.router.push('/brochure');
    }

    render() {
        return tpl(this);
    }
}

BrochuresGrid.contextTypes = {
    router: React.PropTypes.object
};