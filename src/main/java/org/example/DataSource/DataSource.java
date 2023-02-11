package org.example.DataSource;

import org.example.modell.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DataSource {
    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        return configuration.buildSessionFactory();
    }
}
