package com.example.storage;

public class Customer extends Person {
    private String date_of_birthday; //возраст покупателя
    private Gender gender;

    enum Gender {
        Male,
        Feminine
    }


    public Customer(int id, String name, String phonenumber, String email, String paymentdetails, String date_of_birthday, String gender) {
        super(id, name, phonenumber, email, paymentdetails);
        this.date_of_birthday = date_of_birthday;
        this.gender = Gender.valueOf(gender);
    }

    public String getDate_of_birthday() {
        return date_of_birthday;
    }

    public void setDate_of_birthday(String date_of_birthday) {
        this.date_of_birthday = date_of_birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getPhonenumber() {
        return super.getPhonenumber();
    }

    @Override
    public void setPhonenumber(String phonenumber) {
        super.setPhonenumber(phonenumber);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public String getPaymentdetails() {
        return super.getPaymentdetails();
    }

    @Override
    public void setPaymentdetails(String paymentdetails) {
        super.setPaymentdetails(paymentdetails);
    }
}