package com.example.storage;

import DBConnector.DataBaseHandlerPerson;
import DBConnector.DataBaseHandlerStock;

import java.net.URL;
import java.util.ResourceBundle;

import DBConnector.DataBaseHandlerStock;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button MenuCustomer;

    @FXML
    private Button MenuDelivery;

    @FXML
    private Button MenuOrder;

    @FXML
    private Button MenuStock;

    @FXML
    private Button MenuStockWorker;

    @FXML
    private Button MenuStorage;

    @FXML
    private Button MenuSupplier;

    @FXML
    void initialize() {
        DataBaseHandlerPerson dbCustomer = new DataBaseHandlerPerson();
        DataBaseHandlerPerson dbSupplier = new DataBaseHandlerPerson();
        DataBaseHandlerPerson dbStockWorkers = new DataBaseHandlerPerson();
        DataBaseHandlerStock dbStock = new DataBaseHandlerStock();

        MenuCustomer.setOnAction(actionEvent -> {
            dbCustomer.ConslusionOfCustomer();
        });

        MenuSupplier.setOnAction(actionEvent -> {
            dbSupplier.ConclusionOfSupplier();
        });

        MenuStockWorker.setOnAction(actionEvent -> {
            dbStockWorkers.ConclusionOfStockWorkers();
        });

        MenuStock.setOnAction(actionEvent -> {
            dbStock.ConslusionOfStock();
        });
    }

}

