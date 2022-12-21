package com.bts.currencyconverter.model;

import javax.persistence.*;

@Table
@Entity
public class CurrencyRate {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String fromTitle;
    @Column
    private String toTitle;
    @Column
    private Double rate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromTitle() {
        return fromTitle;
    }

    public void setFromTitle(String from) {
        this.fromTitle = from;
    }

    public String getToTitle() {
        return toTitle;
    }

    public void setToTitle(String to) {
        this.toTitle = to;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}