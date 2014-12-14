package com.pnv.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="ADDRESS")
public class Address {
	
	@Id
	@GeneratedValue(generator="gen")
	@GenericGenerator(
			name="gen",
			strategy="foreign",
			parameters=@Parameter(name="property", value="account"))
	@Column(name="ADDRESS_ID")
	private Long addressId;

	@OneToOne()
	@PrimaryKeyJoinColumn // ADDRESS_ID --> ACCOUNT_ID
	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
