package com.cts.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.bean.Product;
import com.cts.dao.ProductDao;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;

	public Product getProductDetails(int product_code) {
	    return productDao.getProductDetails(product_code);
	}

	public double calculatePrice(int quantity, double product_price) {
	    return quantity * product_price;
	}

	public boolean validateProductCode(int product_code) {
	    return product_code > 0 && String.valueOf(product_code).length() == 4;
	}

	public boolean validateQuantity(int quantity) {
	    return quantity > 0;
	}

}
