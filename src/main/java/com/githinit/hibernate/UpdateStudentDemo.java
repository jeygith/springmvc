package com.githinit.hibernate;

import com.githinit.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {


    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();


        try {

            int id = 1;

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting student with id: " + id);

            Student myStudent = session.get(Student.class, id);

            System.out.println("updating student ...");

            myStudent.setFirstName("Scooby");

            session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }


    }
}
