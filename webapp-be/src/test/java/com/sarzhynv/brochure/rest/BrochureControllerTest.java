package com.sarzhynv.brochure.rest;

import com.sarzhynv.brochure.model.Brochure;
import com.sarzhynv.brochure.service.BrochureRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

/**
 * Created by Vasiliy on 17.09.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class BrochureControllerTest {

    private BrochureController brochureController;

    @Mock
    private BrochureRepository brochureRepository;

    private Brochure testBrochure;

    private static final Long NON_EXISTING_BROCHURE_ID = -1L;
    private static final Long TEST_BROCHURE_ID = 1L;

    @Before
    public void setUp() {
        brochureController = new BrochureController();
        testBrochure = new Brochure("Test Brochure", "testUrl", new Date());

        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(brochureController, "brochureRepository", brochureRepository);
    }

    @Test
    public void testGetAllBrochures() {
        when(brochureRepository.findAllByOrderByPublicationDateDesc()).thenReturn(new ArrayList<Brochure>(){
            {
                add(testBrochure);
            }
        });

        List<Brochure> foundBrochures = brochureController.getBrochures();
        assertEquals(1, foundBrochures.size());
        assertEquals(testBrochure, foundBrochures.get(0));
    }

    @Test
    public void testBrochureNotFound() {
        when(brochureRepository.findOne(NON_EXISTING_BROCHURE_ID)).thenReturn(null);

        ResponseEntity<Brochure> responseEntity = brochureController.getBrochureDetail(NON_EXISTING_BROCHURE_ID);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }

    @Test
    public void testBrochureFound() {
        when(brochureRepository.findOne(TEST_BROCHURE_ID)).thenReturn(testBrochure);

        ResponseEntity<Brochure> responseEntity = brochureController.getBrochureDetail(TEST_BROCHURE_ID);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(testBrochure, responseEntity.getBody());
    }


}
