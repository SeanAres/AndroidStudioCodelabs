package com.example.firebaseexercise;

public class Employee {
    private String lastName, firstName;

    Employee(){
        this.lastName = "default";
        this.firstName = "default";
    }

    Employee(String lName, String fName){
        this.lastName = lName;
        this.firstName = fName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

