package com.sarzhynv.brochure.rest;

import com.sarzhynv.brochure.model.Brochure;
import com.sarzhynv.brochure.model.Store;
import com.sarzhynv.brochure.service.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vasiliy on 17.09.2016.
 */
@Controller
@ResponseBody
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreRepository storeRepository;

    /**
     * get all stores
     * @return List with stores
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Store> getStores() {
        List<Store> stores = storeRepository.findAll();
        return stores;
    }

    /**
     * get store by storeId
     * @param storeId - store id for search
     * @return List of stores with HTTP status OK in case store has been found, in other cases - NOT_FOUND status
     */
    @RequestMapping(value = "/{storeId}", method = RequestMethod.GET)
    public ResponseEntity<Store> getStore(@PathVariable Long storeId) {
        Store store = storeRepository.findOne(storeId);
        ResponseEntity<Store> responseEntity;
        if (store != null) {
            responseEntity = new ResponseEntity<>(store, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    /**
     * get brochures related to store
     * @param storeId - store id for search in store_brochure table
     * @return List of brochures related to specified store
     */
    @RequestMapping(value = "/{storeId}/brochure", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Brochure> getBrochuresByStoreId(@PathVariable Long storeId) {
        List<Brochure> brochures = storeRepository.findBrochuresByStoreId(storeId);
        return brochures;
    }
}
