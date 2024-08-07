package com.tpe.hb08.manytomany;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch08 {
    public static void main(String[] args) {
        Configuration config=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student08.class).addAnnotatedClass(Course.class);

        SessionFactory sessionFactory =config.buildSessionFactory();

        Session session =sessionFactory.openSession();

        Transaction tx =session.beginTransaction();

        //student getirelim id:1001
        Student08 student=session.get(Student08.class,1001);
        System.out.println(student);

        System.out.println("--------------------------------------------------");

        //course getirelim id:11
        Course course=session.get(Course.class,11);
        System.out.println(course);

        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
