package com.dailycodebuffer.model;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int age;
    private Sex gender;
    private String email;

    public Person() {
    }

    public Person(String name, int age, Sex gender, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public static List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("mohamed", 33, Sex.MALE, "mohamed@gmail.com"));
        persons.add(new Person("mostafa", 23, Sex.MALE, "mostafa@gmail.com"));
        persons.add(new Person("ali", 15, Sex.MALE, "ali@gmail.com"));
        persons.add(new Person("mona", 36, Sex.FEMALE, "mona@gmail.com"));
        return persons;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age= " + age +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printPerson() {
        System.out.println(this.toString());
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   public enum Sex {
        MALE, FEMALE
    }
}


