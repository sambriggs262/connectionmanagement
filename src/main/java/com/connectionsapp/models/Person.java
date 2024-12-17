package com.connectionsapp.models;
public class Person {
    public String first;
    public String last;
    public String email;
    public String company;
    public String prefix;
    public String position;

    public Person(String first, String last, String email, String company, String prefix, String position) {
        this.first = first;
        this.last = last;
        this.email = email;
        this.company = company;
        this.prefix = prefix;
        this.position = position;
    }
    public String getName() {
        return first + " " + last;
    }
    public String getFirst(){
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getEmail(){

        return email;
    }
    public String getCompany(){

        return company;
    }
    public String getPrefix(){

        return prefix;
    }

    public String getPosition() {
        return position;
    }
    public String toString(){
        return prefix + " " + first + " " + last + ", recruiting for " + position + " at " + company + " (Email: " + email + ")";
    }
    public String emailFormat(){
        return "Dear " + prefix + last;
    }
}
