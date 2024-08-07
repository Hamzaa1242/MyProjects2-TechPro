package com.tpe.hb06.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch06 {
    public static void main(String[] args) {

        Configuration config=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student06.class).addAnnotatedClass(Book.class);

        SessionFactory sessionFactory =config.buildSessionFactory();

        Session session =sessionFactory.openSession();

        Transaction tx =session.beginTransaction();

        //id:101 olan kitabı getirelim
        Book book=session.get(Book.class,101);
        System.out.println(book);

        //bu kitap kime ait-->metod yok ama HQL/SQL ile ulaşabiliriz.

        String s="SELECT s.id,s.student_name,s.grade FROM t_student06 s INNER JOIN book b ON b.student_id=s.id"+
                " WHERE b.id=101";
        Object[] resultList= (Object[]) session.createSQLQuery(s).uniqueResult();
        System.out.println("------------------------------------------------------");
        System.out.println(Arrays.toString(resultList));
        //hql
        String h="SELECT s FROM Student06 s INNER JOIN s.bookList b WHERE b.id=101 ";
        Student06 resultList2=session.createQuery(h, Student06.class).uniqueResult();
        System.out.println(resultList2);

        System.out.println("------------------------------------------------------");
        //id:1001 olan öğrenciyi ve kitaplarını getirelim
        Student06 student=session.get(Student06.class,1001);
        System.out.println(student);
        System.out.println(student.getBookList());

        //name:'Jack' olan öğrencinin kitaplarını getirelim
        //hem student name hem book bilgilerine ulaşabilmem lazım

        String sql="SELECT b.id,b.name FROM book b INNER JOIN t_student06 s ON b.student_id=s.id " +
                "WHERE s.student_name='Jack'";

        String hql="SELECT b.id, b.name FROM Student06 s INNER JOIN s.bookList b " +
                "WHERE s.name='Jack'";
        List<Object[]> bookList=session.createQuery(hql).getResultList();
        for (Object[] b:bookList){
            System.out.println(Arrays.toString(b));
        }

        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
