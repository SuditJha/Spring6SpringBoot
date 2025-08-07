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

    public Customer updateCustomer(int customerId, long newphoneno) {
        Transaction tx = null;
        Customer customer = null;
        try {
            tx = session.beginTransaction();
            customer = session.get(Customer.class, customerId);
            if (customer != null) {
                customer.setPhoneNo(newphoneno);
                session.update(customer);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return customer;
    }
}