package com.poultry.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the customer_transactions database table.
 * 
 */
@Entity
@Table(name="customer_transactions")
@NamedQuery(name="CustomerTransaction.findAll", query="SELECT c FROM CustomerTransaction c")
public class CustomerTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cust_trans_id")
	private int custTransId;

	@Column(name="amount_paid")
	private double amountPaid;

	private double quantity;

	@Column(name="total_amount")
	private double totalAmount;

	@Temporal(TemporalType.DATE)
	@Column(name="transaction_date")
	private Date transactionDate;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="cust_id")
	private Customer customer;

	public CustomerTransaction() {
	}

	public int getCustTransId() {
		return this.custTransId;
	}

	public void setCustTransId(int custTransId) {
		this.custTransId = custTransId;
	}

	public double getAmountPaid() {
		return this.amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}