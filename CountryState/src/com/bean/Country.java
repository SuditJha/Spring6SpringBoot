package com.bean;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Country")
public class Country {

    @Id
    @Column(name = "countryName")
    private String countryName;

    @Column(name = "currency")
    private String currency;

    @Column(name = "capital")
    private String capital;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<State> statelist;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public List<State> getStatelist() {
        return statelist;
    }

    public void setStatelist(List<State> statelist) {
        this.statelist = statelist;
    }
}