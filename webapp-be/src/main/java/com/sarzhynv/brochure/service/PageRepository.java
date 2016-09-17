package com.sarzhynv.brochure.service;

import com.sarzhynv.brochure.model.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;

/**
 * Created by Vasiliy on 17.09.2016.
 */
@Transactional
public interface PageRepository extends PagingAndSortingRepository<Page, Long> {

}
