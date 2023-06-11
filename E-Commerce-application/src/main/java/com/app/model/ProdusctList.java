package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProdusctList {
	@Id

	private String productName;
	private String productPrice;
	private int productCounts;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductcounts() {
		return productCounts;
	}

	public void setProductcounts(int productcount) {
		this.productCounts = productcount;
	}

}
