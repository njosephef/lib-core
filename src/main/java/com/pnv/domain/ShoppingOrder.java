package com.pnv.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class ShoppingOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long orderId;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY) 
	@JoinColumn(name="BILLING_ID", unique=true, nullable=false)
	private Billing billing;

	@Column
	private String name;
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Billing getBilling() {
		return billing;
	}

	public void setBilling(Billing billing) {
		this.billing = billing;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
