package com.tpe.hb06.onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_student06")
public class Student06 {

    @Id
    private int id;

    @Column(name="student_name", nullable = false)
    private String name;

    private int grade;

    @OneToMany//tablolar arasında ilişkinin kurulmasını sağlar:ilişki tablosu oluşturur.
    @JoinColumn(name = "student_id")//JOIN TABLE iptal, book tablosuna FK ekler:ZORUNLU
    //join column kullanılmazsa JOIN TABLE oluşturulur.
    private List<Book> bookList=new ArrayList<>();//MANY

    //const
    public Student06() {
    }

    public Student06(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    //getter-setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Student06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", bookList=" + bookList +
                '}';
    }
}
