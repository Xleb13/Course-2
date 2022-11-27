package com.example.storage;

import com.example.storage.dbconnection.DataBaseHandlerProduct;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class AddProduct {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Button addstockButton;

    @FXML
    private TextField count_stock;

    @FXML
    private TextField id_stock;

    @FXML
    private TextField price_stock;

    @FXML
    private TextField stockCategories_stock;

    @FXML
    private TextField title_stock;

    DataBaseHandlerProduct dataBaseHandlerProduct = new DataBaseHandlerProduct();

    @FXML
    void initialize(){
        addstockButton.setOnAction(event ->{
            addstock();
            addstockButton.getScene().getWindow().hide();
        });
    }
    private void addstock() { //заполнение таблички добавления товара
        Integer id = Integer.valueOf(id_stock.getText());
        String title = title_stock.getText();
        Integer price = Integer.valueOf(price_stock.getText());
        String stockCategories = stockCategories_stock.getText();
        Integer count = Integer.valueOf(count_stock.getText());

        Product product = new Product(id, title, price, stockCategories, count);
        dataBaseHandlerProduct.addProducts(product);
    }
}