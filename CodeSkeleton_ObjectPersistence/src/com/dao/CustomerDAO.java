package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.Customer;

public class CustomerDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return session;
    }

    public int createCustomer(Customer customer) {
        Transaction tx = session.beginTransaction();
        session.save(customer);
        tx.commit();
        return customer.getCustomerId();
    }
}