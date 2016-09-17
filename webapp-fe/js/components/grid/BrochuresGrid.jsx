import Header from '../header/Header.react.jsx';
import BrochurePreview from './BrochurePreview.react.jsx';

export default (context) => {
    var previews = "";
    if (context.state.brochures && context.state.brochures.length) {
        previews = $.map(context.state.brochures, function(item, index) {
            return (<BrochurePreview src={item.previewUrl}
                                     key={index}
                                     title={item.title}
                                     openBrochure={context.openBrochure.bind(context, item.id)} />);
        });
    }

    return (
        <section className="grid-wrapper">
            <div className="container">
                <Header grid={true}/>

                <div className="jumbotron">
                    {previews}
                </div>
            </div>
        </section>
    );
}