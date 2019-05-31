package com.onetoone.hibernate;

import com.onetoone.hibernate.entity.Instructor;
import com.onetoone.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {


    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate2.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();


        try {

            session.beginTransaction();

            int id = 4;

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);


            System.out.println("Found instructor Detail: " + instructorDetail);

            System.out.println("Found instructor : " + instructorDetail.getInstructor());

            session.delete(instructorDetail);


            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }


    }
}
