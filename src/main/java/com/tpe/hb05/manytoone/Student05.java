package com.tpe.hb05.manytoone;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_student05")
public class Student05 {

    @Id//PK
    private int id;//11

    private String name;

    private int grade;

    private LocalDateTime createOn;

    @ManyToOne//Student05 ile University arasında M-1 ilişkiyi kurar.
    //t_student05 e FK ekleyerek ilişkiyi kurar:university_id
    private Univercity university;//ONE

    @PrePersist//db ye kaydetmeden hemen önce bu metodu çağırır
    public void prePersist(){
        this.createOn=LocalDateTime.now();
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

    public LocalDateTime getCreateOn() {
        return createOn;
    }

    /*  public void setCreateOn(LocalDateTime createOn) {
        this.createOn = createOn;
    }*/

    public boolean getUniversity() {
        return getUniversity();
    }

    public void setUniversity(Univercity university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", createOn=" + createOn +
                ", university=" + university +
                '}';
    }
}
