package com.itshaala.dao;

import com.itshaala.model.Course;
import com.itshaala.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CourseDao {
    public void addCourse(Course course){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction  = session.beginTransaction();
        session.save(course);
        transaction.commit();
        session.close();
        System.out.println("Course object saved successfully");


    }

    public void updateCourse(Course course){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        session.update(course);
        transaction.commit();
        session.close();
        System.out.println("Course updated successfully");




    }

    public void deleteCourse(int courseId){
        SessionFactory sessionFactory =HibernateUtil.getSessionFactory();
        Session session= sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Course course =session.get(Course.class,courseId);
        session.delete(course);
        transaction.commit();
        session.close();



    }




        public static List<Course> getCourses(){
            Session session = HibernateUtil.getSessionFactory().openSession();
            return session.createQuery("from Course",Course.class).list();
        }

    }

