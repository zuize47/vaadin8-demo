package me.hoangnd.lean;

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
enum Sex{
    Male("Nam"),
    Female("Nữ");
    private final String name;

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    private Sex(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
class Title{
    String code;

    String name;

    public Title(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
enum Marital{
    SINGLE("Độc thân"), MARRIED("Đã kết hôn"), DIVORCED("Li dị"), SEPARATE("Ly thân");

    private final String name;

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    private Marital(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}