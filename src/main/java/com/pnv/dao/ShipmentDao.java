/*
 * ShipmentDao.java
 *
 * Copyright by Orell Füssli Wirtschaftsinformationen AG
 * Zürich
 * All rights reserved.
 */
package com.pnv.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.classic.Session;

import com.pnv.domain.Item;
import com.pnv.domain.Shipment;
import com.pnv.util.HibernateUtil;


/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class ShipmentDao
{
    /**
     * Method description
     *
     * @param shipment
     */
    public void create(Shipment shipment)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(shipment);
        session.getTransaction().commit();
        session.close();
    }


    /**
     * Method description
     *
     * @param shipment
     */
    public void update(Shipment shipment)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(shipment);
        session.getTransaction().commit();
        session.close();
    }


    /**
     * Method description
     *
     * @param shipment
     */
    public void delete(Shipment shipment)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(shipment);
        session.getTransaction().commit();
        session.close();
    }


    public void deleteChild()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Shipment shipment = new Shipment();
        Item item1 = new Item();
        Item item2 = new Item();

        shipment.setItems(new ArrayList<Item>());
        shipment.getItems().add(item1);
        shipment.getItems().add(item2);
        session.save(shipment);

        item1 = (Item) session.get(Item.class, Long.valueOf(1));
        shipment = (Shipment)session.get(Shipment.class, Long.valueOf(1));
        shipment.getItems().remove(item1);
        
        session.saveOrUpdate(shipment);
        //        List<Shipment> list = (List<Shipment>)session.createCriteria(Shipment.class).list();
//        Hibernate.initialize(shipment);
        System.out.println("$$$$$$$$$$$$$$$ " + shipment.getItems());
        //        session.update(shipment);
        session.getTransaction().commit();
        session.close();
    }


    /**
     * Method description
     *
     * @param id
     * @return
     */
    public Shipment findById(Long id)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Shipment shipment = (Shipment)session.get(Shipment.class, id);
        session.getTransaction().commit();
        session.close();
        return shipment;
    }


    /**
     * Method description
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Shipment> findAll()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        @SuppressWarnings("cast")
        List<Shipment> list = (List<Shipment>)session.createCriteria(Shipment.class).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}


/*
 * Changes:
 * $Log: $
 */