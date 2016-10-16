package com.sarzhynv.brochure.service;

import com.sarzhynv.brochure.model.Brochure;
import com.sarzhynv.brochure.model.Store;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Vasiliy on 17.09.2016.
 */
@Transactional
public interface StoreRepository extends PagingAndSortingRepository<Store, Long> {

    List<Store> findAll();

    @Query("SELECT s.brochures FROM Store s WHERE s.id = :storeid")
    List<Brochure> findBrochuresByStoreId(@Param("storeid") Long storeId);

    List<Store> findByGeoLocationLatitudeAndGeoLocationLongitude(Double latitude, Double longitude);

}
