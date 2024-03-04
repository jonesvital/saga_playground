package org.example.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static Session session = null;

    public static Session getSession(){

        if((session == null) || !session.isOpen()) {
            Configuration config = new Configuration();
            config.configure();
            config.addAnnotatedClass(org.example.entity.Cliente.class);

            SessionFactory sessionFactory = config.buildSessionFactory();
            session = sessionFactory.getCurrentSession();
        }

        return session;
    }

    public static void closeSession(){
        session.close();
    }

}
