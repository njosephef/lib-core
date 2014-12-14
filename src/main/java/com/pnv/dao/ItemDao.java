/*
 * ItemDao.java
 *
 * Copyright by Orell Füssli Wirtschaftsinformationen AG
 * Zürich
 * All rights reserved.
 */
package com.pnv.dao;

import java.util.List;

import org.hibernate.classic.Session;

import com.pnv.domain.Item;
import com.pnv.util.HibernateUtil;


/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class ItemDao
{
    public List<Item> findAll()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Item> list = (List<Item>)session.createCriteria(Item.class).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}


/*
 * Changes:
 * $Log: $
 */