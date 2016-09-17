import AbstractApi from "./AbstractApi.jsx";
import Constants from '../constants/Constants.jsx';

class BrochureApi extends AbstractApi {
    constructor(props) {
        super(props);
    }

    getStores() {
        let url = Constants.getApiHost() + "store",
            key = Constants.GET_STORES_ACTION;

        this.abortPendingRequests(key);
        this._pendingRequests[key] = this.get(url)
            .end(this.doDigest(key));
    }

    getBrochuresByStore(storeId) {
        let url = Constants.getApiHost() + "store/" + storeId,
            key = Constants.GET_BROCHURES_ACTION;

        this.abortPendingRequests(key);
        this._pendingRequests[key] = this.get(url)
            .end(this.doDigest(key));
    }

    getBrochureDetails(brochureId) {
        let url = Constants.getApiHost() + "brochure/" + brochureId,
            key = Constants.GET_BROCHURE_DETAILS_ACTION;

        this.abortPendingRequests(key);
        this._pendingRequests[key] = this.get(url)
            .end(this.doDigest(key));
    }

}
export default new BrochureApi();