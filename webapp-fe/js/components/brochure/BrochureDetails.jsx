import Header from '../header/Header.react.jsx';
import {Carousel} from 'react-bootstrap';

export default (context, pagesDto) => {
    var pages = "";
    if (pagesDto && pagesDto.length) {
        pages = $.map(pagesDto, function (item, index) {
            return (
                <Carousel.Item key={index}>
                    <img src={item.url} className="img-responsive"/>
                </Carousel.Item>
            );
        });
    }

    return (
        <div>
            <Header grid={false}/>
            <Carousel activeIndex={context.state.activeIndex}
                      onSelect={context.handleSelect.bind(context)}
                      direction='next' indicators={true}
                      controls={true}>
                {pages}
            </Carousel>
        </div>
    );
}