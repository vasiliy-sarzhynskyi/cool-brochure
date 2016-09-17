import AppDispatcher from '../dispatcher/AppDispatcher.jsx';
import Constants from '../constants/Constants.jsx';

import { EventEmitter } from 'events';

class GloabalStore extends EventEmitter {
    constructor(...args) {
        super(...args);
        super.setMaxListeners(10);

        this.stores = [];
        this.brochures = [];
        this.activeBrochure = {
            pages: []
        };
    }

    emitStoresLoadSuccess() {
        this.emit(Constants.GET_STORES_EVENT);
    }
    addStoresLoadListener(callback) {
        this.on(Constants.GET_STORES_EVENT, callback);
    }
    removeStoresLoadListener(callback) {
        this.removeListener(Constants.GET_STORES_EVENT, callback);
    }

    emitBrochureDetailsLoadSuccess() {
        this.emit(Constants.GET_BROCHURE_DETAILS_EVENT);
    }
    addBrochureDetailsLoadListener(callback) {
        this.on(Constants.GET_BROCHURE_DETAILS_EVENT, callback);
    }
    removeBrochureDetailsLoadListener(callback) {
        this.removeListener(Constants.GET_BROCHURE_DETAILS_EVENT, callback);
    }

    emitBrochuresLoadSuccess() {
        this.emit(Constants.GET_BROCHURES_EVENT);
    }
    addBrochuresLoadListener(callback) {
        this.on(Constants.GET_BROCHURES_EVENT, callback);
    }
    removeBrochuresLoadListener(callback) {
        this.removeListener(Constants.GET_BROCHURES_EVENT, callback);
    }

}

var gloabalStore = new GloabalStore();
GloabalStore.dispatcherIndex = AppDispatcher.register(function (data) {
    var payload = data.payload;

    switch (payload.actionType) {
        case Constants.GET_STORES_ACTION:
            if (payload.response) {
                gloabalStore.stores = JSON.parse(payload.response.text);
                gloabalStore.emitStoresLoadSuccess();
            }

        case Constants.GET_BROCHURES_ACTION:
            if (payload.response) {
                gloabalStore.brochures = JSON.parse(payload.response.text).brochures;
                gloabalStore.emitBrochuresLoadSuccess();
            }

        case Constants.GET_BROCHURE_DETAILS_ACTION:
            if (payload.response) {
                gloabalStore.activeBrochure = JSON.parse(payload.response.text);
                gloabalStore.emitBrochureDetailsLoadSuccess();
            }

        default :
            return true;
    }

    return true;
});

export default gloabalStore;