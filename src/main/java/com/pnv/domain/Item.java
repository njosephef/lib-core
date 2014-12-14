package com.pnv.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long itemId;
	
    @ManyToOne()
	@JoinColumn(name="SHIPMENT_ID", nullable=false) 
	private Shipment shipment;


    /**
     * Method description
     *
     * @return
     */
	public Long getItemId() {
		return itemId;
	}


    /**
     * Method description
     *
     * @param itemId
     */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}


    /**
     * Method description
     *
     * @return
     */
	public Shipment getShipment() {
		return shipment;
	}


    /**
     * Method description
     *
     * @param shipment
     */
	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}
}
