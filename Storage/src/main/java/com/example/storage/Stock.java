package com.example.storage;



public class Stock {
    private int id; // id товара
    private String title; // Название товара
    private int price; // Цена товара
    private StockCategories stockCategories; //Категория товара
    private int count; //количество товара

    enum StockCategories {
        SmartPhones, //Мобильные телефоны
        PCcomponents, //Комплектующие для пк
        Appilance, //Бытовая техника
        ProtectiveSystem, //Защитные системы
        SpareParts, //Ремонтные детали
    }

    public Stock(int id, String title, int price, String stockCategories, int count) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.stockCategories = StockCategories.valueOf(stockCategories);
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public StockCategories getStockCategories() {
        return stockCategories;
    }

    public void setStockCategories(StockCategories stockCategories) {
        this.stockCategories = stockCategories;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}