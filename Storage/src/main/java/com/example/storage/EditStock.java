package com.example.storage;

import DBConnector.DataBaseHandlerStock;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditStock {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField count_stock;

    @FXML
    private Button editButton;

    @FXML
    private TextField id_stock;

    @FXML
    private TextField price_stock;

    @FXML
    private TextField stockCategories_stock;

    @FXML
    private TextField title_stock;
    DataBaseHandlerStock dataBaseHandlerStock = new DataBaseHandlerStock();
    private int id;

    @FXML
    void initialize() {
        editButton.setOnAction(event -> {
            editstock();
            editButton.getScene().getWindow().hide();
        });
    }

    public void editstock(){
        String newId = Integer.valueOf(id).toString();
        String newTitle = title_stock.getText();
        Integer newPrice = Integer.valueOf(price_stock.getText());
        String newStockCategories = stockCategories_stock.getText();
        Integer newCount = Integer.valueOf(count_stock.getText());
        dataBaseHandlerStock.EditStock(newId, newTitle, newPrice, newStockCategories, newCount);
    }
    public void setStockData(Stock selectedItem) {
        id = selectedItem.getId();
        title_stock.setText(String.valueOf(selectedItem.getTitle()));
        price_stock.setText(String.valueOf(selectedItem.getPrice()));
        stockCategories_stock.setText(String.valueOf(selectedItem.getStockCategories()));
        count_stock.setText(String.valueOf(selectedItem.getCount()));
    }

}