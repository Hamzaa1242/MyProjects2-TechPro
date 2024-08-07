package com.tpe.hb06.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class RunnerSave06 {
    public static void main(String[] args) {

        Student06 student1=new Student06();
        student1.setId(1001);
        student1.setName("Jack");
        student1.setGrade(99);

        Student06 student2=new Student06();
        student2.setId(1002);
        student2.setName("Harry");
        student2.setGrade(97);

        Student06 student3=new Student06();
        student3.setId(1003);
        student3.setName("Fred");
        student3.setGrade(98);

        Book book1=new Book(101,"Sefiller");
        Book book2=new Book(102,"Suç ve Ceza");
        Book book3=new Book(103,"Beyaz Diş");
        Book book4=new Book(104,"Aşk ve Gurur");

        student1.getBookList().add(book1);
        student1.getBookList().add(book2);
        student2.getBookList().add(book3);
        student3.getBookList().add(book4);

        Configuration config=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student06.class).addAnnotatedClass(Book.class);

        SessionFactory sessionFactory =config.buildSessionFactory();

        Session session =sessionFactory.openSession();

        Transaction tx =session.beginTransaction();

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);

        session.save(student1);
        session.save(student2);
        session.save(student3);

        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
