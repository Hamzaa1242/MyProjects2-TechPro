package com.tpe.hb05.manytoone;

import com.tpe.hb03.uni_onetoone.Diary;
import com.tpe.hb03.uni_onetoone.Student03;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {
    public static void main(String[] args) {

        Univercity university = new Univercity(11,"TPE University");

        Student05 student1=new Student05();
        student1.setId(1001);
        student1.setName("Jack");
        student1.setGrade(99);

        Student05 student2=new Student05();
        student2.setId(1002);
        student2.setName("Harry");
        student2.setGrade(97);

        Student05 student3=new Student05();
        student3.setId(1003);
        student3.setName("Fred");
        student3.setGrade(98);

        student1.setUniversity(university);
        student2.setUniversity(university);

        Configuration config=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student05.class).addAnnotatedClass(Univercity.class);

        SessionFactory sessionFactory =config.buildSessionFactory();

        Session session =sessionFactory.openSession();

        Transaction tx =session.beginTransaction();

        session.save(university);
        session.save(student1);
        session.save(student2);
        session.save(student3);

        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
