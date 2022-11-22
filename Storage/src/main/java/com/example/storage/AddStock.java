package com.example.storage;

import DBConnector.DataBaseHandlerStock;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;



    public class AddStock {

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

        DataBaseHandlerStock dataBaseHandlerStock = new DataBaseHandlerStock();

        @FXML
        void initialize(){
           addstockButton.setOnAction(event ->{
               addstock();
               addstockButton.getScene().getWindow().hide();
            });
        }
        private void addstock() {
            Integer id = Integer.valueOf(id_stock.getText());
            String title = title_stock.getText();
            Integer price = Integer.valueOf(price_stock.getText());
            String stockCategories = stockCategories_stock.getText();
            Integer count = Integer.valueOf(count_stock.getText());

            Stock stock = new Stock(id, title, price, stockCategories, count);
            dataBaseHandlerStock.AddStock(stock);
        }
    }
