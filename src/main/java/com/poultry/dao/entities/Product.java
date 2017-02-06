package com.poultry.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "product_id")
	private int productId;

	private String description;

	private String name;

	// bi-directional many-to-one association to CustomerTransaction
	@OneToMany(mappedBy = "product")
	private List<CustomerTransaction> customerTransactions;

	// bi-directional many-to-one association to ProductDailyPrice
	@OneToMany(mappedBy = "product")
	private List<ProductDailyPrice> productDailyPrices;

	public Product() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CustomerTransaction> getCustomerTransactions() {
		return this.customerTransactions;
	}

	public void setCustomerTransactions(
			List<CustomerTransaction> customerTransactions) {
		this.customerTransactions = customerTransactions;
	}

	public CustomerTransaction addCustomerTransaction(
			CustomerTransaction customerTransaction) {
		getCustomerTransactions().add(customerTransaction);
		customerTransaction.setProduct(this);

		return customerTransaction;
	}

	public CustomerTransaction removeCustomerTransaction(
			CustomerTransaction customerTransaction) {
		getCustomerTransactions().remove(customerTransaction);
		customerTransaction.setProduct(null);

		return customerTransaction;
	}

	public List<ProductDailyPrice> getProductDailyPrices() {
		return this.productDailyPrices;
	}

	public void setProductDailyPrices(List<ProductDailyPrice> productDailyPrices) {
		this.productDailyPrices = productDailyPrices;
	}

	public ProductDailyPrice addProductDailyPrice(
			ProductDailyPrice productDailyPrice) {
		getProductDailyPrices().add(productDailyPrice);
		productDailyPrice.setProduct(this);

		return productDailyPrice;
	}

	public ProductDailyPrice removeProductDailyPrice(
			ProductDailyPrice productDailyPrice) {
		getProductDailyPrices().remove(productDailyPrice);
		productDailyPrice.setProduct(null);

		return productDailyPrice;
	}

}