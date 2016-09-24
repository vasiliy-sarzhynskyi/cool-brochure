package com.sarzhynv.brochure.rest;

import com.sarzhynv.brochure.model.Brochure;
import com.sarzhynv.brochure.service.BrochureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vasiliy on 17.09.2016.
 */
@RestController
@RequestMapping("/brochure")
public class BrochureController {

    @Autowired
    private BrochureRepository brochureRepository;

    /**
     * get all brochures sorted by publication date
     * @return List with brochures
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Brochure> getBrochures() {
        List<Brochure> brochures = brochureRepository.findAllByOrderByPublicationDateDesc();
        return brochures;
    }

    /**
     * get brochure by brochureId
     * @param brochureId - brochure id for search
     * @return List of brochures with HTTP status OK in case brochure has been found, in other cases - NOT_FOUND status
     */
    @RequestMapping(value = "/{brochureId}", method = RequestMethod.GET)
    public ResponseEntity<Brochure> getBrochureDetail(@PathVariable Long brochureId) {
        Brochure brochure = brochureRepository.findOne(brochureId);
        ResponseEntity<Brochure> responseEntity;
        if (brochure != null) {
            responseEntity = new ResponseEntity<>(brochure, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }


}
