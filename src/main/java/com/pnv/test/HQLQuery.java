package com.pnv.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.classic.Session;

import com.pnv.dao.DepartmentDao;
import com.pnv.domain.Department;
import com.pnv.domain.Employee;
import com.pnv.util.HibernateUtil;

public class HQLQuery {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("FROM Department WHERE departmentId = :departmentId");
        query.setParameter("departmentId", Long.valueOf(1));
        List<Department> list = (List<Department>)query.list();
        System.out.println(list.size());
        System.out.println(list.get(0).getEmployeeList().get(1).getFirstName());
        
        System.out.println("===================================================================");
        query = session.createQuery("FROM Department");
        list = (List<Department>)query.list();
        for (Department department : list) {
			System.out.println("Department: " + department.getName());
			for (Employee employee : department.getEmployeeList()) {
				System.out.println(employee.getLastName() + " " + employee.getFirstName());
			}
		}
        session.getTransaction().commit();
        session.close();
	}
}
