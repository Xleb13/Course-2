package com.example.storage;

public class Order {
    int id_order;
    int id_customer;
    int id_worker;
    int count;
    String title;
    String status;

    public Order(int id_order, int id_customer, int id_worker, String status) {
        this.id_order = id_order;
        this.id_customer = id_customer;
        this.id_worker = id_worker;
        this.status = status;
    }

    public Order(int id_order, String title, int count) {
        this.id_order = id_order;
        this.title = title;
        this.count = count;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public int getId_worker() {
        return id_worker;
    }

    public void setId_worker(int id_worker) {
        this.id_worker = id_worker;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}