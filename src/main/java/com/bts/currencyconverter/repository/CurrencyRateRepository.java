package com.bts.currencyconverter.repository;

import com.bts.currencyconverter.model.CurrencyRate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRateRepository extends CrudRepository<CurrencyRate, Long> {

    Optional<CurrencyRate> findByFromTitleAndToTitle(String fromTitle, String toTitle);
}