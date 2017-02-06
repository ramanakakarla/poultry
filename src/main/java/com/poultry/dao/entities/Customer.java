package com.poultry.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the customers database table.
 * 
 */
@Entity
@Table(name="customers")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cust_id")
	private int custId;

	private String address;

	@Column(name="mobile_number")
	private String mobileNumber;

	private String name;

	//bi-directional many-to-one association to CustomerTransaction
	@OneToMany(mappedBy="customer")
	private List<CustomerTransaction> customerTransactions;

	public Customer() {
	}

	public int getCustId() {
		return this.custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	public void setCustomerTransactions(List<CustomerTransaction> customerTransactions) {
		this.customerTransactions = customerTransactions;
	}

	public CustomerTransaction addCustomerTransaction(CustomerTransaction customerTransaction) {
		getCustomerTransactions().add(customerTransaction);
		customerTransaction.setCustomer(this);

		return customerTransaction;
	}

	public CustomerTransaction removeCustomerTransaction(CustomerTransaction customerTransaction) {
		getCustomerTransactions().remove(customerTransaction);
		customerTransaction.setCustomer(null);

		return customerTransaction;
	}

}