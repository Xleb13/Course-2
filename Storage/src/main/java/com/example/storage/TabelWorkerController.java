package com.example.storage;

import DBConnector.DataBaseHandlerPerson;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TabelWorkerController implements Initializable {

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
    private TableView<StockWorker> TabelStockWorker;

    @FXML
    private TableColumn<StockWorker, String> email;

    @FXML
    private TableColumn<StockWorker, Integer> id;

    @FXML
    private TableColumn<StockWorker, String> jobtitle;

    @FXML
    private TableColumn<StockWorker, String> name;

    @FXML
    private TableColumn<StockWorker, String> phonenumber;

    @FXML
    private final ObservableList<StockWorker> data3 = FXCollections.observableArrayList();

    DataBaseHandlerPerson dataBaseHandlerPerson = new DataBaseHandlerPerson();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        navigation();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        phonenumber.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        jobtitle.setCellValueFactory(new PropertyValueFactory<>("jobtitle"));
        dataStockWorker();
        TabelStockWorker.setItems(data3);

    }

    private void dataStockWorker(){
        ResultSet stockworkers = dataBaseHandlerPerson.getStockWorkers("stockworkers");
        try {
            while (stockworkers.next()){
                StockWorker stockWorker = new StockWorker(
                        stockworkers.getInt(1),
                        stockworkers.getString(2),
                        stockworkers.getString(3),
                        stockworkers.getString(4),
                        stockworkers.getString(5));
                data3.add(stockWorker);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void navigation()
    {MenuCustomer.setOnAction(actionEvent -> { //Открыть Меню Клиенты
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
        stage.setResizable(false); //запрет изменения размера окна
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
            stage.setResizable(false); //запрет изменения размера окна
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        MenuStockWorker.setOnAction(actionEvent -> { //Открыть Меню Работники Склада
            MenuStockWorker.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Worker.fxml"));
            try{
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setResizable(false); //запрет изменения размера окна
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
            stage.setResizable(false); //запрет изменения размера окна
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
            stage.setResizable(false); //запрет изменения размера окна
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
            stage.setResizable(false); //запрет изменения размера окна
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
            stage.setResizable(false); //запрет изменения размера окна
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });}
}
