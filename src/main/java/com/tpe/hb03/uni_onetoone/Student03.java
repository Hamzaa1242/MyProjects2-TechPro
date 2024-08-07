package com.tpe.hb03.uni_onetoone;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_student03")
public class Student03 {

    @Id
    private int id;

    @Column(name="std_name")
    private String name;

    private int grade;

    // const

    public Student03() {} // hibernate fetch işlemlerinde objeyi oluşturmak için ihtiyaç duyar

    // param const

    public Student03(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student03{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
