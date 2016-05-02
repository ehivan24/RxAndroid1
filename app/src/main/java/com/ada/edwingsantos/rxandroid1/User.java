package com.ada.edwingsantos.rxandroid1;

/**
 * Created by edwingsantos on 5/1/16.
 */
public class User {

    public enum SEX{
        MALE, FEMALE
    }



    public User(SEX gender, String name, String country, int age, String email ){
        this.gender = gender;
        this.name = name;
        this.country = country;
        this.age = age;
        this.email = email;
    }

    SEX gender;
    String name;
    String email;
    int age;
    String country;


    public SEX getGender(){
        return gender;
    }
    public void setGender(SEX gender){
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return getName() + "\t" + getGender();
    }
}
