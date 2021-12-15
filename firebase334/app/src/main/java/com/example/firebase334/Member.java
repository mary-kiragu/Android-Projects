package com.example.firebase334;

public class Member {
    private String FirstName,LastName,phone,mail;



    public Member(String firstName, String lastName, String phone, String mail) {
        FirstName = firstName;
        LastName = lastName;
        this.phone = phone;
        this.mail = mail;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
