package com.githinit.hibernate;

import com.githinit.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {


    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();


        try {

            session.beginTransaction();

            // query students


            List<Student> students = session.createQuery("from Student").list();

            // display students

            displayStudents(students);


            // student: lastName-'Doe';

            students = session.createQuery("from Student s where s.lastName='Doe'").list();

            // display students
            displayStudents(students);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }


    }

    private static void displayStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
