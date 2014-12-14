/*
 * DepartmentDao.java
 *
 * Copyright by Orell Füssli Wirtschaftsinformationen AG
 * Zürich
 * All rights reserved.
 */
package com.pnv.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.FetchType;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.pnv.domain.Department;
import com.pnv.domain.Employee;
import com.pnv.util.HibernateUtil;

/**
 * 
 *
 * @author ngvtien
 * @version $Revision:  $
 */
public class DepartmentDao
{
    /**
     * Method description
     *
     * @param department
     */
    public void save(Department department)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(department);
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
    public void delete(Department department)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(department);
        session.getTransaction().commit();
        session.close();
    }


    /**
     * Method description
     *
     */
    public void deleteChild()
    {
        Department department = new Department();
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();

        department.setEmployeeList(new ArrayList<Employee>());
        department.getEmployeeList().add(employee1);
        department.getEmployeeList().add(employee2);
        save(department);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        employee1 = (Employee)session.get(Employee.class, Long.valueOf(1));
        department = (Department)session.get(Department.class, Long.valueOf(1));
        department.getEmployeeList().remove(employee1);

        session.getTransaction().commit();
        session.close();

        save(department);
    }


    /**
     * Method description
     *
     * @param id
     * @return Department
     */
    public Department findById(Long id)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Department department = (Department)session.get(Department.class, id);
        session.getTransaction().commit();
        session.close();
        return department;
    }


    /**
     * Method description
     *
     * @return List<Department>
     */
    @SuppressWarnings("unchecked")
    public List<Department> findAll()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        @SuppressWarnings("cast")
        List<Department> list = (List<Department>)session.createCriteria(Department.class).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    
    @SuppressWarnings("unchecked")
	public List<Department> findAll(FetchMode mode)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        @SuppressWarnings("cast")
        List<Department> list = (List<Department>)session.createCriteria(Department.class)
        	.setFetchMode("employeeList", mode)
        	.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
        	.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }


	public Department findById(Long id, FetchMode mode) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Department department = (Department)session.createCriteria(Department.class)
        		.setFetchMode("employeeList", mode)
        		.add(Restrictions.eq("departmentId", id)).uniqueResult();
        session.getTransaction().commit();
        session.close();
        return department;
	}
}


/*
 * Changes:
 * $Log: $
 */