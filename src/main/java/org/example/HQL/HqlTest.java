package org.example.HQL;

import org.example.DataSource.DataSource;
import org.example.modell.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HqlTest {
    public static void main(String[] args) {
        getPersonList();
    }

    private static void getPersonList() {
        SessionFactory sessionFactory = DataSource.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            List<Person> personList = session.createQuery("FROM Person").getResultList();
            session.createQuery("UPDATE Person set name='Test' WHERE age < 30");
            personList.forEach(System.out::println);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }

}
