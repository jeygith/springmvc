package com.onetomany.hibernate;

import com.onetomany.hibernate.entity.Instructor;
import com.onetomany.hibernate.entity.InstructorDetail;
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

            int id = 6;

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);


            System.out.println("Found instructor Detail: " + instructorDetail);

            System.out.println("Found instructor : " + instructorDetail.getInstructor());

            // break bi directional link
            instructorDetail.getInstructor().setInstructorDetail(null);

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
