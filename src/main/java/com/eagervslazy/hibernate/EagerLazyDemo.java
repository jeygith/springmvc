package com.eagervslazy.hibernate;

import com.eagervslazy.hibernate.entity.Course;
import com.eagervslazy.hibernate.entity.Instructor;
import com.eagervslazy.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {


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

            int id = 1;

            Instructor instructor = session.get(Instructor.class, id);

            System.out.println("luv2code Instructor: " + instructor);

            System.out.println("luv2code Courses: " + instructor.getCourses());


            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }


    }
}
