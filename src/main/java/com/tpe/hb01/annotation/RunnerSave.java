package com.tpe.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave {
    public static void main(String[] args) {

        Student student1 = new Student();
        student1.setId(1001);
        student1.setName("Hamza Bey");
        student1.setGrade(90);

        Student student2 = new Student();
        student1.setId(1002);
        student1.setName("Feyza Hanım");
        student1.setGrade(95);

        Student student3 = new Student();
        student1.setId(1003);
        student1.setName("Berkan Bey");
        student1.setGrade(98);

        // configure methoduna parametre girilmezse defaultta 'hibernate.cfg.xml' dosyasına göre konfig. yapar
        Configuration config = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class);
        // hibernate annote ettiğimiz sınıfı gösterdik

        SessionFactory sessionFactory = config.buildSessionFactory();
        // session oluşturmamızı sağlar, genellikle tüm uygulamada 1 kere oluşturulur ve tekrar tekrar kullanılır

        Session session = sessionFactory.openSession();
        // DB de bir oturum başlatmamızı sağlar. Bu session DB ile iletişime geçip bazı işlemleri(CRUD) yapmamızı
        // sağlayan methodları içerir
        // uygulamada 1 den fazla session oluşturulabilir

        // transaction: veritabanı işlemlerinin atomik olmasını sağlar
        Transaction tx = session.beginTransaction();

        // student1 obj tabloya ekleyelim
        // INSERT INTO t_student VALUES(1001, Hamza, 90)

        // session.save(student1);
        session.save(student2);
        session.save(student3);


        // DB deki değişiklilerin kalıcı hale gelmesi için transactionın onaylanması gerekir
        tx.commit(); // transactionı onaylar ve sonlandırır

        session.close();
        sessionFactory.close();
    }
}
