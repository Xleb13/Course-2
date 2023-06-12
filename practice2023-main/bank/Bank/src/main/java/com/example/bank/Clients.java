package com.example.bank;

public class Clients {
    public int id;
    public double reminder;
    public String account;
    public static String na;
    public static String acc;
    public String name;

    public Clients(String account, String name, double reminder) {
        this.reminder = reminder;
        this.account = account;
        this.name = name;
    }

    public Clients(String account, String name) {
        this.account = account;
        this.name = name;
    }

    public Clients(String name) {
        this.name = name;
    }

    public void setReminder(double reminder) {
        this.reminder = reminder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getReminder() {
        return reminder;
    }

    public void setReminder(Double reminder) {
        this.reminder = reminder;
    }

    public static String getAcc() {
        return acc;
    }

    public static void setAcc(String acc) {
        Clients.acc = acc;
    }

    public static String getNa() {
        return na;
    }

    public static void setNa(String na) {
        Clients.na = na;
    }
}
