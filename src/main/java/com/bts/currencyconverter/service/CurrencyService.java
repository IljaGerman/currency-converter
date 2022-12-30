package com.bts.currencyconverter.service;

import com.bts.currencyconverter.model.CurrencyRate;
import com.bts.currencyconverter.repository.CurrencyRateRepository;
import com.bts.currencyconverter.repository.specification.CurrencyRateSpecification;
import com.bts.currencyconverter.repository.specification.SearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {
    private final CurrencyRateRepository currencyRateRepository;

    public CurrencyService(CurrencyRateRepository currencyRateRepository) {
        this.currencyRateRepository = currencyRateRepository;
    }

    public double convert(Double value, String from, String to) {
        var currencyRate = currencyRateRepository.findByFromTitleAndToTitle(from, to)
                .orElseThrow(() -> new RuntimeException("No such currency rate"));
        return value * currencyRate.getRate();
    }

    public Page<CurrencyRate> findAll(Pageable pageable, SearchCriteria searchCriteria) {
        return currencyRateRepository.findAll(Specification.where(new CurrencyRateSpecification(searchCriteria)),
                pageable);
    }


    public CurrencyRate save(CurrencyRate rate) {
        return currencyRateRepository.save(rate);
    }

}
