package com.cts.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.bean.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Product getProductDetails(int product_code) {
	    String sql = "SELECT * FROM product WHERE product_code = ?";
	    return jdbcTemplate.queryForObject(sql, new Object[]{product_code}, new BeanPropertyRowMapper<>(Product.class));
	}


}
