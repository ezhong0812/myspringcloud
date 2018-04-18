package com.example.demo;

import java.io.Serializable;

/**
 * Created by Jason on 18/4/4.
 */

public class Student implements Serializable {

    private static final long serialVersionUID = 2120869894112984147L;

    private int id;
    private String name;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

}