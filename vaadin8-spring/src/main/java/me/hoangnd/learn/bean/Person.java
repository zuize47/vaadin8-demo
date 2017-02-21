package me.hoangnd.learn.bean;

import java.time.LocalDate;

/**
 * Created by hoang on 2/21/2017.
 */
public class Person {

    String firstName;

    String lastName;

    Sex sex;

    Marital marital;

    Title title;

    LocalDate dateOfBirth;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Marital getMarital() {
        return marital;
    }

    public void setMarital(Marital marital) {
        this.marital = marital;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}


