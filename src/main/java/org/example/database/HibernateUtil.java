package org.example.database;

import org.example.database.entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * HibernateUtil is a utility class for managing Hibernate SessionFactory.
 */

public class HibernateUtil {

    private static final HibernateUtil INSTANCE;

    private final SessionFactory sessionFactory;

    /**
     * Private constructor to create a HibernateUtil instance and initialize the SessionFactory.
     */
    private HibernateUtil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }

    static {
        INSTANCE = new HibernateUtil();
    }

    /**
     * Get the instance of HibernateUtil.
     *
     * @return The HibernateUtil instance.
     */
    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    /**
     * Close the SessionFactory and release its resources.
     */
    public void close() {
        sessionFactory.close();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}