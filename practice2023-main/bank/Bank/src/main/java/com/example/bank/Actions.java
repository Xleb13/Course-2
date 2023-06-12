package com.example.bank;

public class Actions {
    private int id;
    public static int id_client;
    private double deposit, withdrawal, reminder;
    private String date;

    public static double rem;

    public Actions(String date, double deposit, double withdrawal, double reminder) {
        this.deposit = deposit;
        this.withdrawal = withdrawal;
        this.reminder = reminder;
        this.date = date;
    }

    public static double getRem() {
        return rem;
    }

    public static void setRem(double rem) {
        Actions.rem = rem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getId_client() {
        return id_client;
    }

    public static void setId_client(int id_client) {
        Actions.id_client = id_client;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(double withdrawal) {
        this.withdrawal = withdrawal;
    }

    public double getReminder() {
        return reminder;
    }

    public void setReminder(double reminder) {
        this.reminder = reminder;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}

