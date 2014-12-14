package com.pnv.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table
public class ProductOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ORDER_ID")
	@Cascade(CascadeType.SAVE_UPDATE)
	private Long productOrderId;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@OneToOne
	@JoinColumn(name="BILLING_ID")
	private Billing billing;

	public Long getProductOrderId() {
		return productOrderId;
	}

	public void setProductOrderId(Long productOrderId) {
		this.productOrderId = productOrderId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Billing getBilling() {
		return billing;
	}

	public void setBilling(Billing billing) {
		this.billing = billing;
	}
}
