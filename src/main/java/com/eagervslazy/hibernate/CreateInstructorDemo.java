package com.eagervslazy.hibernate;

import com.eagervslazy.hibernate.entity.Course;
import com.eagervslazy.hibernate.entity.Instructor;
import com.eagervslazy.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {


    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate3.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();


        try {

            // create objects
            Instructor instructor = new Instructor("Susan", "Public", "susan@gmail.com");


            InstructorDetail instructorDetail = new InstructorDetail("susan", "Gamer!!");

            // associate objects

            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            System.out.println("saving instructor: " + instructor);

            session.save(instructor);

            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }


    }
}
