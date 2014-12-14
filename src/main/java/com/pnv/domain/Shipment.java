package com.pnv.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
@Entity
@Table
public class Shipment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long shipmentId;
	
    @OneToMany(mappedBy = "shipment", orphanRemoval=true, fetch=FetchType.EAGER)
    @Cascade({CascadeType.SAVE_UPDATE})
	private List<Item> items = new ArrayList<Item>();


    /**
     * Method description
     *
     * @return
     */
	public Long getShipmentId() {
		return shipmentId;
	}


    /**
     * Method description
     *
     * @param shipmentId
     */
	public void setShipmentId(Long shipmentId) {
		this.shipmentId = shipmentId;
	}


    /**
     * Method description
     *
     * @return
     */
	public List<Item> getItems() {
		return items;
	}


    /**
     * Method description
     *
     * @param items
     */
	public void setItems(List<Item> items) {
		this.items = items;
	}
}
