package com.pnv.test;

import com.pnv.dao.ShoppingOrderDao;
import com.pnv.domain.Billing;
import com.pnv.domain.ShoppingOrder;

public class CreateShoppingOrder {
    
	public static void main(String[] args)
    {
    	ShoppingOrderDao dao = new ShoppingOrderDao();
    	ShoppingOrder order = new ShoppingOrder();
    	order.setName("order2");
    	
    	Billing billing = new Billing();
    	billing.setDescription("billing2");
		order.setBilling(billing );
        
		dao.save(order);
    }
}
