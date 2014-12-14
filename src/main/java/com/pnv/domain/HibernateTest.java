package com.pnv.domain;

import java.util.ArrayList;
import java.util.List;

import com.pnv.dao.ShipmentDao;

public class HibernateTest {

	public static void main(String[] args) {
			// TODO Auto-generated method stub
	        ShipmentDao dao = new ShipmentDao();
	        Shipment shipment = new Shipment();
	        Item item1 = new Item();
	//        item1.setShipment(shipment);
	        Item item2 = new Item();
	//        item2.setShipment(shipment);
	
	        shipment.setItems(new ArrayList<Item>());
	        shipment.getItems().add(item1);
	        shipment.getItems().add(item2);
	        dao.create(shipment);
	        System.out.println("======AFTER SAVE_UPDATE ==================");
	        List<Shipment> list = dao.findAll();
	        System.out.println(list.size());
	        Shipment obj = list.get(0);
	        if (list.size() > 0)
	        {
	            System.out.println("********** " + obj.getItems().size());
	        }
	
	        System.out.println("======AFTER DELETE CASCADE ==================");
	        dao.delete(list.get(0));
	        list = dao.findAll();
	        System.out.println("after delete **************** " + list.size());
	        if (list.size() > 0)
	        {
	            System.out.println(list.get(0).getItems().size());
	        }
	
	        shipment = new Shipment();
	        item1 = new Item();
	        item2 = new Item();
	
	        shipment.setItems(new ArrayList<Item>());
	        shipment.getItems().add(item1);
	        item1.setShipment(shipment);
	        shipment.getItems().add(item2);
	        item2.setShipment(shipment);
	        dao.create(shipment);
	
	        System.out.println("======AFTER DELETE CHILD ==================");
	                list = dao.findAll();
	                System.out.println(list.size());
	                System.out.println(list.get(0).getItems().size());
	                shipment = list.get(0);
	                List<Item> list2 = shipment.getItems();
	                item1 = list2.get(0);
	                list.get(0).getItems().remove(item1);
	                
	                dao.update(shipment);
	//        dao.deleteChild();
	
	        System.out.println("===========================");
			
		}

}
