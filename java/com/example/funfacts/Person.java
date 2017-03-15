package com.example.funfacts;

import android.database.Cursor;

public class Person {
    private String firstName;
    private String lastName;

    Person(){
        this.firstName="";
        this.lastName="";
    }
    Person(String lname){
        this.firstName="";
        this.lastName=lname;
    }
    Person(String fname, String lname){
        this.firstName=fname;
        this.lastName=lname;
    }

    public Cursor Print() {
        System.out.println(firstName + " " + lastName);
        return null;
    }

    public void Print(String pout) {
        System.out.println(pout + " " + firstName + " " + lastName);
    }
}
