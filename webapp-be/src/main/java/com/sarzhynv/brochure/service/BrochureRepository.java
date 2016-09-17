package com.sarzhynv.brochure.service;

import javax.transaction.Transactional;

import com.sarzhynv.brochure.model.Brochure;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Vasiliy on 17.09.2016.
 */
@Transactional
public interface BrochureRepository extends PagingAndSortingRepository<Brochure, Long> {

    List<Brochure> findAll();

    List<Brochure> findAllByOrderByPublicationDateDesc();


}