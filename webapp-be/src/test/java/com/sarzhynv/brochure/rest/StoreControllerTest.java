package com.sarzhynv.brochure.rest;

import com.sarzhynv.brochure.model.Brochure;
import com.sarzhynv.brochure.model.Store;
import com.sarzhynv.brochure.service.StoreRepository;
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
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Created by Vasiliy on 17.09.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class StoreControllerTest {

    private static final Long TEST_STORE_ID = 1L;
    private static final Long NON_EXISTING_STORE_ID = -1L;

    private StoreController storeController;

    @Mock
    private StoreRepository storeRepository;

    private Store testStore;

    @Before
    public void setUp() {
        storeController = new StoreController();
        testStore = new Store("Test Store");
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(storeController, "storeRepository", storeRepository);
    }

    @Test
    public void testStoreNotFound() {
        when(storeRepository.findOne(NON_EXISTING_STORE_ID)).thenReturn(null);

        ResponseEntity<Store> responseEntity = storeController.getStore(NON_EXISTING_STORE_ID);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }

    @Test
    public void testStoreFound() {
        when(storeRepository.findOne(TEST_STORE_ID)).thenReturn(testStore);

        ResponseEntity<Store> responseEntity = storeController.getStore(TEST_STORE_ID);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(testStore, responseEntity.getBody());
    }

    @Test
    public void testNoExistStoresInDB(){
        when(storeRepository.findAll()).thenReturn(Collections.emptyList());

        List<Store> stores = storeController.getStores();
        assertTrue(stores.isEmpty());
    }

    @Test
    public void testGetBrochuresForExistingStore() {
        Brochure brochure = new Brochure();
        when(storeRepository.findBrochuresByStoreId(TEST_STORE_ID)).thenReturn(new ArrayList<Brochure>(){
            {
                add(brochure);
            }
        });

        List<Brochure> foundBrochures = storeController.getBrochuresByStoreId(TEST_STORE_ID);
        assertEquals(1, foundBrochures.size());
        assertEquals(brochure, foundBrochures.get(0));

    }

    @Test
    public void testGetBrochuresForNonExistingStore() {
        when(storeRepository.findBrochuresByStoreId(NON_EXISTING_STORE_ID)).thenReturn(Collections.emptyList());

        List<Brochure> foundBrochures = storeController.getBrochuresByStoreId(NON_EXISTING_STORE_ID);
        assertTrue(foundBrochures.isEmpty());
    }


}
