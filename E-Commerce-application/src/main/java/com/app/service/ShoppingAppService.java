package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CustomerRepository;
import com.app.dao.ProductListRepository;
import com.app.dao.ShoppingAppRepository;
import com.app.model.Customer;
import com.app.model.ProdusctList;
import com.app.model.ShoppingApp;

@Service
public class ShoppingAppService {

	@Autowired
	private ShoppingAppRepository shoppingAppRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductListRepository productListRepository;

	public Customer addCustomerDetails(Customer customer) {
		return customerRepository.save(customer);
	}

	public ProdusctList addProductList(ProdusctList produsctList) {
		return productListRepository.save(produsctList);
	}

	public ShoppingApp addAppDetails(ShoppingApp shoppingApp) {
		return shoppingAppRepository.save(shoppingApp);
	}

}
