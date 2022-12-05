package com.example.storage;

public class Supplier extends Person {

    private String INN ; //ИНН
    private String OGRN; //ОГРН

    public Supplier(int id, String name, String phonenumber, String email, String paymentdetails, String INN, String OGRN) {
        super(id, name, phonenumber, email, paymentdetails);
        this.INN = INN;
        this.OGRN = OGRN;
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public String getOGRN() {
        return OGRN;
    }

    public void setOGRN(String OGRN) {
        this.OGRN = OGRN;
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
