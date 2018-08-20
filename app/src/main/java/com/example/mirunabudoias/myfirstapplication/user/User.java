package com.example.mirunabudoias.myfirstapplication.user;

import java.io.Serializable;

public class User implements Serializable {
    public String name;
    public int age;
    public String address;

    public User(){

    }

    public User(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}