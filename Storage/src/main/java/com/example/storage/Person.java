package com.example.storage;

public class Person {
    private int id; //id аккаунта
    private String name; //ФИО пользователя или название организации
    private String phonenumber; //Контактный телефон
    private String email; //Контактная электронная почта
    private String paymentdetails; //платежные данные

    public Person(int id, String name, String phonenumber, String email) {
        this.id = id;
        this.name = name;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public Person(int id, String name, String phonenumber, String email, String paymentdetails) {
        this.id = id;
        this.name = name;
        this.phonenumber = phonenumber;
        this.email = email;
        this.paymentdetails = paymentdetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaymentdetails() {
        return paymentdetails;
    }

    public void setPaymentdetails(String paymentdetails) {
        this.paymentdetails = paymentdetails;
    }
}