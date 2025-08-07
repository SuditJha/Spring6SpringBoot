package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.bean.Customer;

public class CustomerDAO {

	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public int addCustomer(Customer customer) {
		Transaction tx = session.beginTransaction();
		Integer id = (Integer) session.save(customer);
		tx.commit();
		return id;
	}
}