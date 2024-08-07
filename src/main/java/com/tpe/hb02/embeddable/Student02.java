package com.tpe.hb02.embeddable;

import javax.persistence.*;

@Entity
@Table(name = "t_student02")
public class Student02 {

    @Id // id sütununa PK kısıtlamasını ekler
    // @Column(name = "std_id")
    private Integer id; // null

    @Column(name = "student_name", length = 50, nullable = false,unique = false) // opsiyonel
    private String name; // varchar(50) // default size: 255

    private Integer grade; // null

    // private String street;
    // private String city;
    // private String country;
    // private String zipcode;

    @Embedded // opsiyonel
    private Address address;

    // default

    public Student02() {
    }

    // param const

    public Student02(Integer id, String name, Integer grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // getter-setter

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

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

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
