package com.poultry.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the product__daily_price database table.
 * 
 */
@Entity
@Table(name="product__daily_price")
@NamedQuery(name="ProductDailyPrice.findAll", query="SELECT p FROM ProductDailyPrice p")
public class ProductDailyPrice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="price_id")
	private int priceId;

	private double price;

	@Temporal(TemporalType.DATE)
	@Column(name="record_date")
	private Date recordDate;

	//bi-directional many-to-one association to Stock
	@ManyToOne
	@JoinColumn(name="stock_id")
	private Stock stock;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	public ProductDailyPrice() {
	}

	public int getPriceId() {
		return this.priceId;
	}

	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getRecordDate() {
		return this.recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}