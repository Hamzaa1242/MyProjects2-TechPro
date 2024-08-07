package com.tpe.hb05.manytoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Univercity {

    @Id
    private int uni_id;

    @Column(nullable = false,unique = true)
    private String name;

    //const

    public Univercity() {
    }

    public Univercity(int uni_id, String name) {
        this.uni_id = uni_id;
        this.name = name;
    }

    //getter-setter


    public int getUni_id() {
        return uni_id;
    }

    public void setUni_id(int uni_id) {
        this.uni_id = uni_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "University{" +
                "uni_id=" + uni_id +
                ", name='" + name + '\'' +
                '}';
    }
}
