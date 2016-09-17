import "../styles/main.scss";

import React from "react";
import {Router, Route, IndexRoute, createMemoryHistory} from 'react-router';
import ReactDOM from 'react-dom';

import BrochuresGrid from './components/grid/BrochuresGrid.react.jsx';
import BrochureDetails from './components/brochure/BrochureDetails.react.jsx';


class Index extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className="app-container clearFix">
                {this.props.children}
            </div>
        );
    }
}

ReactDOM.render(
    <Router history={createMemoryHistory()}>
        <Route component={Index}>
            <IndexRoute component={BrochuresGrid}/>
            <Route path="/" component={BrochuresGrid}/>
            <Route path="/brochure" component={BrochureDetails}/>
        </Route>
    </Router>,
    document.getElementById("app"));
