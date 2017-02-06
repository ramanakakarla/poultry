package com.poultry.dao.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the expenditure database table.
 * 
 */
@Entity
@NamedQuery(name="Expenditure.findAll", query="SELECT e FROM Expenditure e")
public class Expenditure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="exp_id")
	private int expId;

	@Temporal(TemporalType.DATE)
	@Column(name="create_date")
	private Date createDate;

	private String description;

	private String type;

	public Expenditure() {
	}

	public int getExpId() {
		return this.expId;
	}

	public void setExpId(int expId) {
		this.expId = expId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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

}