package com.onetomany.hibernate;

import com.onetomany.hibernate.entity.Course;
import com.onetomany.hibernate.entity.Instructor;
import com.onetomany.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {


    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate3.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();


        try {

            session.beginTransaction();

            int id = 10;

            Course course = session.get(Course.class, id);

            System.out.println("Deleting Course: " + course);

            session.delete(course);

            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }


    }
}
