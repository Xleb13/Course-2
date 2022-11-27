package com.example.storage;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.storage.dbconnection.DataBaseHandlerProduct;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddStorage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addstockButton;

    @FXML
    private TextField count_storage;

    @FXML
    private TextField id_storage;

    @FXML
    private TextField idsupplier;

    @FXML
    private TextField stockCategories_storage;

    @FXML
    private TextField title_storage;
    DataBaseHandlerProduct dataBaseHandlerProduct = new DataBaseHandlerProduct();

    @FXML
    void initialize(){
        addstockButton.setOnAction(event ->{
            addstock();
            addstockButton.getScene().getWindow().hide();
        });
    }
    private void addstock() { //заполнение таблички добавления товара
        Integer id = Integer.valueOf(id_storage.getText());
        String title = title_storage.getText();
        String stockCategories = stockCategories_storage.getText();
        Integer countst = Integer.valueOf(count_storage.getText());
        Integer id_supplier = Integer.valueOf(idsupplier.getText());

        Storage storage = new Storage(id, title, stockCategories, countst, id_supplier);
        dataBaseHandlerProduct.addStorages(storage);
    }
}