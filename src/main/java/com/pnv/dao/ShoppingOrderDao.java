/*
 * DepartmentDao.java
 *
 * Copyright by Orell Füssli Wirtschaftsinformationen AG
 * Zürich
 * All rights reserved.
 */
package com.pnv.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.classic.Session;

import com.pnv.domain.ShoppingOrder;
import com.pnv.util.HibernateUtil;

/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class ShoppingOrderDao
{
    /**
     * Method description
     *
     * @param department
     */
    public void save(ShoppingOrder shoppingOrder)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(shoppingOrder);
        session.getTransaction().commit();
        session.close();
    }


    /**
     * Method description
     *
     * @param department
     */
    /*public void update(Department department)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(department);
        session.getTransaction().commit();
        session.close();
    }*/


    /**
     * Method description
     *
     * @param department
     */
    public void delete(ShoppingOrder shoppingOrder)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(shoppingOrder);
        session.getTransaction().commit();
        session.close();
    }


    /**
     * Method description
     *
     */
    public void deleteChild()
    {
//        Department department = new Department();
//        Employee employee1 = new Employee();
//        Employee employee2 = new Employee();
//
//        department.setEmployeeList(new ArrayList<Employee>());
//        department.getEmployeeList().add(employee1);
//        department.getEmployeeList().add(employee2);
//        save(department);
//
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//
//        employee1 = (Employee)session.get(Employee.class, Long.valueOf(1));
//        department = (Department)session.get(Department.class, Long.valueOf(1));
//        department.getEmployeeList().remove(employee1);
//
//        session.getTransaction().commit();
//        session.close();
//
//        save(department);
    }


    /**
     * Method description
     *
     * @param id
     * @return Department
     */
    public ShoppingOrder findById(Long id)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ShoppingOrder shoppingOrder = (ShoppingOrder)session.get(ShoppingOrder.class, id);
        session.getTransaction().commit();
        session.close();
        return shoppingOrder;
    }


    /**
     * Method description
     *
     * @return List<Department>
     */
    @SuppressWarnings("unchecked")
    public List<ShoppingOrder> findAll()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        @SuppressWarnings("cast")
        List<ShoppingOrder> list = (List<ShoppingOrder>)session.createCriteria(ShoppingOrder.class).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    
    @SuppressWarnings("unchecked")
	public List<ShoppingOrder> findAllWithFetchMode(FetchMode fetchMode)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        @SuppressWarnings("cast")
        Criteria criteria = session.createCriteria(ShoppingOrder.class);
        criteria.setFetchMode("billing", fetchMode);
        List<ShoppingOrder> list = (List<ShoppingOrder>)criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}


/*
 * Changes:
 * $Log: $
 */