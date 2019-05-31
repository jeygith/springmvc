package com.githinit.hibernate;

import com.githinit.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();


        try {

            Student student = new Student("John", "doe", "john@gmail.com");

            Student student2 = new Student("Mary", "Public", "mary@gmail.com");
            Student student3 = new Student("Jane", "doe", "jane@gmail.com");

            session.beginTransaction();

            session.save(student);
            session.save(student2);
            session.save(student3);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
