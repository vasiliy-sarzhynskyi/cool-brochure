import {Dispatcher} from "flux";
var assign = require('object-assign');

var AppDispatcher = assign(new Dispatcher(), {
    handleLocationAction: function (locationData) {
        this.dispatch({
            payload: locationData
        });
    },
    handleRequestAction: function (payload) {
        if (!this.isDispatching()) {
            this.dispatch({
                payload: payload
            });
        }
    }
});

export default AppDispatcher;