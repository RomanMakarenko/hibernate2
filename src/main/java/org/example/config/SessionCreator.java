package org.example.config;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public enum SessionCreator implements AutoCloseable {
    INSTANCE;
    private final SessionFactory sessionFactory;

    SessionCreator() {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addPackage("org/example/entity");
        sessionFactory = configuration.buildSessionFactory();
    }

    @Override
    public void close() throws Exception {
        sessionFactory.close();
    }

    public static SessionCreator getInstance() {
        return INSTANCE;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
