package com.cts.handson.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.cts.handson.model.EBill;

@Service
public class EBillDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    PlatformTransactionManager txManager;

    public void deleteBill(long... billNumbers) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = txManager.getTransaction(def);
        try {
            for (long billNo : billNumbers) {
                if (billNo < 100) {
                    throw new Exception("Invalid bill number: " + billNo);
                }
                jdbcTemplate.update("DELETE FROM ebill WHERE bill_number = ?", billNo);
            }
            txManager.commit(status);
        } catch (Exception ex) {
            txManager.rollback(status);
                        throw new RuntimeException(ex);
        }
    }

    

    public List<EBill> getAllBill() {
        return jdbcTemplate.query(
        	    "SELECT * FROM EBILL",
        	    new BeanPropertyRowMapper<>(EBill.class)
        	);
    }
}