import React from 'react';
import {Thumbnail, Button} from 'react-bootstrap';


export default class BrochurePreview extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (

            <div className="preview-item">

                <Thumbnail src={this.props.src}
                           onClick={this.props.openBrochure}
                           alt={this.props.title}/>
                <div className="search-item-title">{this.props.title}</div>

                <div rel="tooltip" className="brochure-tooltip-actions">
                    <div className="outer">
                        <div className="middle">
                            <div className="inner btn-group-vertical">
                                <Button onClick={this.props.openBrochure}
                                        bsStyle='primary'
                                        rel="tooltip">Open Brochure</Button>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        )
    };
}

BrochurePreview.propTypes = {
    src: React.PropTypes.string,
    openBrochure: React.PropTypes.func,
    title: React.PropTypes.string
};