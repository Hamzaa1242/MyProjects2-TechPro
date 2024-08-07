package com.tpe.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch {
    public static void main(String[] args) {

        Configuration config = new Configuration().
                configure().
                addAnnotatedClass(Student.class);

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // transaction fetch işlemlerinde gerekli değildir

        /* DB den data çekmek için
        Task: id = 1001 olan öğrenciyi tüm fieldlarıyla getirmek(fetch) istiyoruz
        1) get() - session methodu (hibernate): en pratik ama kullanım alanı kısıtlı
        2) SQL: DB
        3) HQL(Hibernate Query Language): Java
        */

        // get
        Student student1 = session.get(Student.class,1001);
        System.out.println(student1);

        // SQL
        String sql = "SELECT * FROM t_student WHERE id = 1001";
        Object[] student2 = (Object[]) session.createSQLQuery(sql).uniqueResult();
        // uniqueResult(): Sorgunun tek satır getireceğini biliyorsak kullanılır

        System.out.println(Arrays.toString(student2));

        // HQL
        String hql = "FROM Student WHERE id = 1001";
        Student student3 = session.createQuery(hql, Student.class).uniqueResult();
        System.out.println(student3);

        // tüm kayıtları çekelim
        // hql ile
        String hql2 = "FROM Student";
        List<Student> studentList = session.createQuery(hql2, Student.class).getResultList();

        for (Student s : studentList){
            System.out.println(s);
        }

        // sql ile
        String sql2 = "SELECT * FROM t_Student";
        List<Object[]> resultList = session.createSQLQuery(sql2).getResultList();

        for (Object[] objects : resultList){
            System.out.println(Arrays.toString(objects));
        }

        // HQL ile grade değeri 90 olan öğrencilerin id ve name bilgilerini getirelim
        String hql3 = "SELECT s.id, s.name FROM Student s WHERE s.grade = 90";
        List<Object[]> resultList2 = session.createQuery(hql3).getResultList();

        for (Object[] objects : resultList2){
            System.out.println(Arrays.toString(objects));
        }

        // HQL ile

        // 1- İsmi Feyza Hanım olan öğrencileri getirelim
        String hql4 = "SELECT * FROM Student WHERE name = Feyza Hanım";
        List<Object[]> resultList3 = session.createQuery(hql4).getResultList();

        for (Object[] objects : resultList3){
            System.out.println(Arrays.toString(objects));
        }

        // 2- Tüm öğrencilerin sadece isimlerini getirelim

        String hql5 = "SELECT name FROM Student";
        List<Object[]> resultList4 = session.createQuery(hql5).getResultList();

        for (Object[] objects : resultList4){
            System.out.println(Arrays.toString(objects));
        }

        // SQL ile

        // 1- Tüm öğrencilerin sadece isimlerini getirelim

        String sql3 = "SELECT name FROM Student";
        List<Object[]> resultList5 = session.createSQLQuery(sql3).getResultList();

        for (Object[] objects : resultList5){
            System.out.println(Arrays.toString(objects));
        }

        session.close();
        sessionFactory.close();
    }
}
