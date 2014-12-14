package com.pnv.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Billing {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BILLING_ID")
	private Long id;
	
	@Column
	private String description;
	
	@OneToOne(mappedBy="billing")
	private ShoppingOrder shoppingOrder;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ShoppingOrder getShoppingOrder() {
		return shoppingOrder;
	}

	public void setShoppingOrder(ShoppingOrder shoppingOrder) {
		this.shoppingOrder = shoppingOrder;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
