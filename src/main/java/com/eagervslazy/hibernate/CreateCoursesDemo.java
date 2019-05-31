package com.eagervslazy.hibernate;

import com.eagervslazy.hibernate.entity.Course;
import com.eagervslazy.hibernate.entity.Instructor;
import com.eagervslazy.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {


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

            // create courses

            Course course1 = new Course("Air Guitar - The Ultimate Guide");
            Course course2 = new Course("Pinball Guide");

            instructor.add(course1);
            instructor.add(course2);

            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }


    }
}
