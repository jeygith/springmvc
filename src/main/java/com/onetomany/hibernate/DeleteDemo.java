package com.onetomany.hibernate;

import com.onetomany.hibernate.entity.Instructor;
import com.onetomany.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {


    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate2.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();


        try {

            session.beginTransaction();

            int id = 1;
            Instructor instructor = session.get(Instructor.class, id);

            System.out.println("Found instructor: " + instructor);

            if (instructor != null) {
                System.out.println("Deleting Instructor: " + instructor);
                session.delete(instructor);
            }


            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }


    }
}
