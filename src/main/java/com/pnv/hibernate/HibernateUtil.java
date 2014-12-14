package com.pnv.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	
	public static SessionFactory getSessionFactory() {
		
		return new AnnotationConfiguration().configure().buildSessionFactory();
	}

}
