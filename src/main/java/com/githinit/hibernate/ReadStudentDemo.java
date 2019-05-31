package com.githinit.hibernate;

import com.githinit.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {


    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();


        try {

            Student student = new Student("Duffy", "Duck", "duffy@gmail.com");
            session.beginTransaction();

            session.save(student);

            session.getTransaction().commit();


            //students pk
            System.out.println("Student id: " + student.getId());

            // retrieve the student
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("\nGetting student with id: " + student.getId());

            Student myStudent = session.get(Student.class, student.getId());

            System.out.println("Get complete:" + myStudent);

            session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }


    }
}
