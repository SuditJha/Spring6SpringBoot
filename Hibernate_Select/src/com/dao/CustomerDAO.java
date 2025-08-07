package com.dao;

import com.bean.Customer;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class CustomerDAO {
    
    private Session session;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public List<Customer> viewCustomers(){
        String hql = "FROM Customer";
        Query<Customer> query = session.createQuery(hql, Customer.class);
        return query.list();
    }
}