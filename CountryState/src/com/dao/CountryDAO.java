package com.dao;

import com.bean.Country;
import com.bean.State;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CountryDAO {

    private Session session;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void addCountry(Country country) {
        Transaction tx = session.beginTransaction();
        session.save(country);
        tx.commit();
    }

    public void addStatetoCountry(String countryName, State state) {
        Transaction tx = session.beginTransaction();
        Country country = session.get(Country.class, countryName);
        if (country != null) {
            state.setCountry(country);
            session.save(state);
        }
        tx.commit();
    }

    public List<State> stateWithMaxPopulation(String countryName) {
        String hql = "FROM State s WHERE s.country.countryName = :countryName AND s.population = (SELECT MAX(s2.population) FROM State s2 WHERE s2.country.countryName = :countryName)";
        Query<State> query = session.createQuery(hql, State.class);
        query.setParameter("countryName", countryName);
        return query.list();
    }

    public void removeCountry(String countryName) {
        Transaction tx = session.beginTransaction();
        Country country = session.get(Country.class, countryName);
        if (country != null) {
            session.remove(country);
        }
        tx.commit();
    }
}