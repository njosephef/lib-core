package com.pnv.hibernate;

import org.hibernate.Session;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Student student = new Student();
		student.setAddress("Le Duan 80B");
		student.setName("tran van ABC");
		session.save(student);
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("=======================================");
	}

}
