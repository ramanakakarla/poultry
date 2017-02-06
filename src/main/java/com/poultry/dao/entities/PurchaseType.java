package com.poultry.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the purchase_type database table.
 * 
 */
@Entity
@Table(name="purchase_type")
@NamedQuery(name="PurchaseType.findAll", query="SELECT p FROM PurchaseType p")
public class PurchaseType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="purchase_id")
	private int purchaseId;

	private String description;

	private String type;

	//bi-directional many-to-one association to PurchaseM
	@OneToMany(mappedBy="purchaseType")
	private List<PurchaseM> purchaseMs;

	public PurchaseType() {
	}

	public int getPurchaseId() {
		return this.purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<PurchaseM> getPurchaseMs() {
		return this.purchaseMs;
	}

	public void setPurchaseMs(List<PurchaseM> purchaseMs) {
		this.purchaseMs = purchaseMs;
	}

	public PurchaseM addPurchaseM(PurchaseM purchaseM) {
		getPurchaseMs().add(purchaseM);
		purchaseM.setPurchaseType(this);

		return purchaseM;
	}

	public PurchaseM removePurchaseM(PurchaseM purchaseM) {
		getPurchaseMs().remove(purchaseM);
		purchaseM.setPurchaseType(null);

		return purchaseM;
	}

}