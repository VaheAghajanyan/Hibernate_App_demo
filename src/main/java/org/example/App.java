package org.example;

import org.example.modell.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        savePerson();
    }

    private static void getPerson() {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Person person = session.get(Person.class, 1);
            System.out.println(person.getName());
            System.out.println(person.getAge());
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }

    private static void savePerson() {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Person person1 = new Person("Vahe", 23);
            Person person2 = new Person("Gohar", 17);
            session.save(person1);
            session.save(person2);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }

    private static void updatePerson() {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Person Vahe = session.get(Person.class, 1);
            Vahe.setAge(24);
            session.update("age", Vahe);
            session.getTransaction().commit();

            int updatedPersonId = Vahe.getId();
            System.out.println(updatedPersonId);
        } finally {
            sessionFactory.close();
        }
    }

    private static void deletePerson() {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Person Vahe = session.get(Person.class, 1);
            session.delete(Vahe);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
