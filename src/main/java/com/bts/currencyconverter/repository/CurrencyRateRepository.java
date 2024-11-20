package com.bts.currencyconverter.repository;

import com.bts.currencyconverter.model.CurrencyRate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRateRepository extends PagingAndSortingRepository<CurrencyRate, Long>, JpaSpecificationExecutor<CurrencyRate> {

    Optional<CurrencyRate> findByFromTitleAndToTitle(String fromTitle, String toTitle);

    Page<CurrencyRate> findAll(Pageable pageable);

}