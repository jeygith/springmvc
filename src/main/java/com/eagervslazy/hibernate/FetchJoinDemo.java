package com.eagervslazy.hibernate;

import com.eagervslazy.hibernate.entity.Course;
import com.eagervslazy.hibernate.entity.Instructor;
import com.eagervslazy.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {


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

            Query<Instructor> query = session.createQuery("select i from Instructor i "
                            + "JOIN FETCH i.courses "
                            + "where i.id =: instructorId",
                    Instructor.class);

            query.setParameter("instructorId", id);


            Instructor instructor = query.getSingleResult();

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
