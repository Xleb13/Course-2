package com.example.storage;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.storage.dbconnection.DataBaseHandlerProduct;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditStorage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField count_storage;

    @FXML
    private Button editButton;

    @FXML
    private TextField id_storage;

    @FXML
    private TextField idsupplier;

    @FXML
    private TextField stockCategories_storage;

    @FXML
    private TextField title_storage;
    DataBaseHandlerProduct dataBaseHandlerProduct = new DataBaseHandlerProduct();
    private int id;

    @FXML
    void initialize() {
        editButton.setOnAction(event -> {
            editstorage();
            editButton.getScene().getWindow().hide();
        });
    }

    public void editstorage(){
        String newId = Integer.valueOf(id).toString();
        String newTitle = title_storage.getText();
        String newStockCategories = stockCategories_storage.getText();
        Integer newCount = Integer.valueOf(count_storage.getText());
        Integer newIdSupplier = Integer.valueOf(idsupplier.getText());
        dataBaseHandlerProduct.editStorage(newId, newTitle, newStockCategories, newCount, newIdSupplier);
    }

    public void setStorageData(Storage selectedItem) {
        id = selectedItem.getId();
        title_storage.setText(String.valueOf(selectedItem.getTitle()));
        stockCategories_storage.setText(String.valueOf(selectedItem.getStockCategories()));
        count_storage.setText(String.valueOf(selectedItem.getCountst()));
        idsupplier.setText(String.valueOf(selectedItem.getId_supplier()));
    }
}
