package com.example.wshop2_explicitintent;

import java.io.Serializable;

public class Candidate implements Serializable {
    //对象必须继承 serializable 来通过 intent 传递
    public int id;
    public String name;
    public String color;

    public Candidate(int id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }
}
