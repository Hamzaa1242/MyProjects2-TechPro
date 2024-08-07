package com.tpe.hb06.onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    private int id;

    private String name;

    //    @ManyToOne
    //    private Student06 student;

    //const

    public Book() {
    }

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
