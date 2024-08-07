package com.tpe.hb03.uni_onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Diary { // ONE

    @Id
    private Integer id; // 11

    private String name; // x

    @OneToOne // diary ile t_student03 arasında 1e1 ilişki kurulmasını sağlar
              // bunun için diary e FK ekler: default ismi: student_id
    @JoinColumn(name = "std_id", unique = true) // opsiyonel
    private Student03 student; // günlük hangi öğrenciye ait // ONE

    // getter-setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student03 getStudent() {
        return student;
    }

    public void setStudent(Student03 student) {
        this.student = student;
    }

    // toString

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
