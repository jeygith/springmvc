package com.onetoone.hibernate;

import com.onetoone.hibernate.entity.Instructor;
import com.onetoone.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {


    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate2.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();


        try {

            // create objects
            Instructor instructor = new Instructor("Jeff", "Githire", "githireh@gmail.com");


            InstructorDetail instructorDetail = new InstructorDetail("githireh", "Love to code!!");

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
