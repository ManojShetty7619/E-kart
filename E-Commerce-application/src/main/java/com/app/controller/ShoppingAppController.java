package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.CustomerRepository;
import com.app.dao.ProductListRepository;
import com.app.dao.ShoppingAppRepository;
import com.app.model.Customer;
import com.app.model.ProdusctList;
import com.app.model.ShoppingApp;
import com.app.service.ShoppingAppService;

@RestController
public class ShoppingAppController {

	@Autowired
	private ShoppingAppService shoppingAppService;

	@Autowired
	private ShoppingAppRepository shoppingAppRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductListRepository productListRepository;

	@RequestMapping("/addCustomerDetails")
	public Customer addCustomerDetails(@RequestBody Customer customer) {
		return shoppingAppService.addCustomerDetails(customer);

	}

	@RequestMapping("/addProductList")
	public ProdusctList addProductList(@RequestBody ProdusctList produsctList) {
		return shoppingAppService.addProductList(produsctList);

	}

	@RequestMapping("/addAppDetails")
	public ShoppingApp addAppDetails(@RequestBody ShoppingApp shoppingApp) {
		return shoppingAppService.addAppDetails(shoppingApp);

	}

	@RequestMapping("/validateCustomer")
	public String validateCustomer(HttpServletRequest httpServletRequest) {
		String message = "";
		String customerName = httpServletRequest.getHeader("customerName");
		String password = httpServletRequest.getHeader("password");
		String productName = httpServletRequest.getHeader("productName");
		String appName = httpServletRequest.getHeader("appName");
		String requiredAmountProduct = httpServletRequest.getHeader("requiredAmountProduct");

		int customerRequiredAmountproduct = Integer.valueOf(requiredAmountProduct);

		Customer customerDetails = customerRepository.findByCustomerName(customerName);
		ProdusctList productDetails = productListRepository.findByProductName(productName);

		ShoppingApp appDetails = shoppingAppRepository.findByAppName(appName);

		if (password.equals(customerDetails.getPassword())) {
			message = "Valid Customer";
			System.out.println(message);
			if (appName.equals(appDetails.getAppName())) {
				message = "Welcome to " + appName + ".\n" + "Start shopping";
				System.out.println(message);
				System.out.println("Please slect the product");
				if (productName.equals(productDetails.getProductName())) {

					message = "Selected product " + productName;
					System.out.println(message);
					int beforeShoppingProdusctStock = productDetails.getProductcounts();
					int afterShoppingProdusctStock = beforeShoppingProdusctStock - customerRequiredAmountproduct;
					if (customerRequiredAmountproduct <= beforeShoppingProdusctStock) {
						message = "Select Quantity";

						System.out.println(message);
						System.out.println("Selected quantity :" + customerRequiredAmountproduct);
						System.out.println(
								"Remaining Quantity of " + productName + " " + "is :" + afterShoppingProdusctStock);

						String customerBalance = customerDetails.getCustomerBalance();
						String productPrice = productDetails.getProductPrice();

						int customerBalanceAmount = Integer.valueOf(customerBalance);
						int productPriceAmount = Integer.valueOf(productPrice);
						System.out.println("Start payment");

						if (customerBalanceAmount >= productPriceAmount) {
							message = "Payment in progress";
							System.out.println(message);
							int customerpaidAmount = productPriceAmount;
							int customerRemainingBalance = customerBalanceAmount - customerpaidAmount;

							System.out.println("Customer Remaining Balance :" + customerRemainingBalance);
							System.out.println(
									"Customer paid amount :" + (customerBalanceAmount - customerRemainingBalance));
							String appBalance = appDetails.getAppBalance();
							int appBalanceBeforeShopping = Integer.valueOf(appBalance);
							int appBalanceAfterShopping = appBalanceBeforeShopping + customerpaidAmount;
							if (appBalanceAfterShopping > appBalanceBeforeShopping) {
								message = "Amount paid";
								System.out.println(message);
								if (appDetails.getAppDeliveryManager() != null
										&& appDetails.getAppDeliveryTeam() != null) {
									message = "Start delivery";
									System.out.println(message);
									int customerProductCountBeforeshopping = customerDetails.getProductCount();
									int customerProductCountAftershopping = customerProductCountBeforeshopping
											+ customerRequiredAmountproduct;
									if (customerProductCountAftershopping > customerProductCountBeforeshopping) {
										message = "product delivered";
										System.out.println(message);
									} else {
										message = "Product not delivered ";
									}

								} else {
									message = "Delivery team is not available";
								}

							} else {
								message = "Transaction failed";
							}

						} else {
							message = "Insufficient";
						}

					} else {
						message = "Sorry.. " + customerName + "\n" + "Slected quantity is  not available.";
					}

				} else {
					message = "Sorry.. " + customerName + "\n" + "Product is not available";
				}
			} else {
				message = appName + " " + "not exists";
			}
		} else {
			message = "Invalid Customer";
			System.out.println(message);
		}

		return message;

	}
}
