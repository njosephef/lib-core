package com.pnv.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


/**
 * @author ngvtien
 * @version $Revision:  $
 */
public class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();


    /**
     * Method description
     *
     * @return SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    private static SessionFactory buildSessionFactory() {
        // TODO Auto-generated method stub
        return new AnnotationConfiguration().configure().buildSessionFactory();
    }
}
