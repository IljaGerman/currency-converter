package com.bts.currencyconverter.service;

import com.bts.currencyconverter.model.CurrencyRate;
import com.bts.currencyconverter.repository.CurrencyRateRepository;
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


    public CurrencyRate save(CurrencyRate rate) {
        return currencyRateRepository.save(rate);
    }

}
