import request from 'superagent';
import AppDispatcher from "../dispatcher/AppDispatcher.jsx";
import Constants from '../constants/Constants.jsx';


export default class AbstractApi {
    constructor() {
        this._pendingRequests = {};
    }

    dispatch(key, response) {
        AppDispatcher.handleRequestAction({actionType: key, response: response});
    }

    doDigest(key) {
        var that = this;
        return function (error, res) {
            if (!error && res && res.ok) {
                that.dispatch(key, res);
            } else {
                that.dispatch(key, null);
            }
        };
    }

    get(url, timeout) {
        return request
            .get(url)
            .timeout(timeout || 10000);
    }

    abortPendingRequests(key) {
        if (this._pendingRequests[key]) {
            this._pendingRequests[key]._callback = () => {};
            this._pendingRequests[key].abort();
            this._pendingRequests[key] = null;
        }
    }
}