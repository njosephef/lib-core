package com.pnv.test;

import java.util.List;

import org.hibernate.FetchMode;

import com.pnv.dao.ShoppingOrderDao;
import com.pnv.domain.ShoppingOrder;

public class ReadShoppingOrder {

	public static void main(String[] args) {
		
		ShoppingOrderDao dao = new ShoppingOrderDao();
		List<ShoppingOrder> list;
		
//		list = dao.findAll();
		list = dao.findAllWithFetchMode(FetchMode.LAZY);
		System.out.println(list.size());
		for (ShoppingOrder shoppingOrder : list) {
			if (shoppingOrder.getBilling() != null) {
				System.out.println(shoppingOrder.getName());
				System.out.println(shoppingOrder.getBilling().getDescription());
			}
		}
	}
}
