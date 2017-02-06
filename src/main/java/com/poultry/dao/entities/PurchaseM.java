package com.poultry.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the purchase_m database table.
 * 
 */
@Entity
@Table(name="purchase_m")
@NamedQuery(name="PurchaseM.findAll", query="SELECT p FROM PurchaseM p")
public class PurchaseM implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int purch_M_id;

	@Temporal(TemporalType.DATE)
	@Column(name="creation_date")
	private Date creationDate;

	@Column(name="margin_amount")
	private double marginAmount;

	//bi-directional many-to-one association to PurchaseType
	@ManyToOne
	@JoinColumn(name="purchase_id")
	private PurchaseType purchaseType;

	public PurchaseM() {
	}

	public int getPurch_M_id() {
		return this.purch_M_id;
	}

	public void setPurch_M_id(int purch_M_id) {
		this.purch_M_id = purch_M_id;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public double getMarginAmount() {
		return this.marginAmount;
	}

	public void setMarginAmount(double marginAmount) {
		this.marginAmount = marginAmount;
	}

	public PurchaseType getPurchaseType() {
		return this.purchaseType;
	}

	public void setPurchaseType(PurchaseType purchaseType) {
		this.purchaseType = purchaseType;
	}

}