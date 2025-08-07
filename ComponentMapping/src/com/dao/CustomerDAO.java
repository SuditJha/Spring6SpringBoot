package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.bean.Address;
import com.bean.Customer;

public class CustomerDAO {
    
    private Session session;
    
    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public int addCustomer(Customer customer, Address address) {
        customer.setAddress(address);
        Transaction tx = session.beginTransaction();
        int customerId = (Integer) session.save(customer);
        tx.commit();
        return customerId;
    }
}