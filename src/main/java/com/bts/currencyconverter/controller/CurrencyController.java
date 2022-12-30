package com.bts.currencyconverter.controller;

import com.bts.currencyconverter.model.CurrencyRate;
import com.bts.currencyconverter.repository.specification.SearchCriteria;
import com.bts.currencyconverter.service.CurrencyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
public class CurrencyController {
    private static final Logger logger = LoggerFactory.getLogger(CurrencyController.class);
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/api/v1/currency/convert")
    public double convertCurrency(@RequestParam double value,
                                  @RequestParam String from,
                                  @RequestParam String to) {
        logger.info("Request with params: {}, {}, {}", value, from, to);

        return currencyService.convert(value, from, to);
    }

    @PostMapping("/api/v1/currency")
    @Secured("ROLE_USER")
    public CurrencyRate saveCurrencyRate(@RequestBody CurrencyRate currencyRate) {
        return currencyService.save(currencyRate);
    }

    @GetMapping("/api/v1/currencyRates")
    public Page<CurrencyRate> findAll(Pageable pageable, SearchCriteria searchCriteria) {
        return currencyService.findAll(pageable, searchCriteria);
    }
}
