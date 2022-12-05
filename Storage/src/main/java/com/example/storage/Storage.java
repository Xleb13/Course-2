package com.example.storage;

public class Storage {
    private int id; // id товара
    private String title; // Название товара
    private Product.StockCategories stockCategories; //Категория товара
    private int countst; //наличие товара
    private int id_supplier;

    enum StockCategories {
        SmartPhones, //Мобильные телефоны
        PCcomponents, //Комплектующие для пк
        Appilance, //Бытовая техника
        ProtectiveSystem, //Защитные системы
        SpareParts, //Ремонтные детали
    }

    public Storage(int id, String title, String stockCategories, int countst, int id_supplier) {
        this.id = id;
        this.title = title;
        this.stockCategories = Product.StockCategories.valueOf(stockCategories);
        this.countst = countst;
        this.id_supplier = id_supplier;
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

    public Product.StockCategories getStockCategories() {
        return stockCategories;
    }

    public void setStockCategories(Product.StockCategories stockCategories) {
        this.stockCategories = stockCategories;
    }

    public int getCountst() {
        return countst;
    }

    public void setCountst(int countst) {
        this.countst = countst;
    }

    public int getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(int id_supplier) {
        this.id_supplier = id_supplier;
    }
}