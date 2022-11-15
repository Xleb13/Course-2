package com.example.storage;

import DBConnector.DataBaseHandlerPerson;
import Storage.StockWorker;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;

public class Worker implements Initializable {

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
    private TableView<StockWorker> TableColumn;

    private final ObservableList<StockWorker> data = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        DataBaseHandlerPerson dbStockWorkers = new DataBaseHandlerPerson();
        MenuStockWorker.setOnAction(actionEvent -> {
            dbStockWorkers.ConclusionOfStockWorkers();
        });


        MenuCustomer.setOnAction(actionEvent -> { //Открыть Меню Клиенты
            MenuCustomer.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Customer.fxml"));
            try{
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        MenuSupplier.setOnAction(actionEvent -> { //открыть меню Поставщики
            MenuSupplier.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Supplier.fxml"));
            try{
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        MenuStock.setOnAction(actionEvent -> { //Открыть Меню Товар
            MenuStock.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Stock.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        MenuOrder.setOnAction(actionEvent -> { //Открыть Меню Заказ
            MenuOrder.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Order.fxml"));
            try{
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        MenuStorage.setOnAction(actionEvent -> { //Открыть Меню Склад
            MenuStorage.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Storage.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        MenuDelivery.setOnAction(actionEvent -> { //Открыть Меню Доставка
            MenuDelivery.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Delivery.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }


}
