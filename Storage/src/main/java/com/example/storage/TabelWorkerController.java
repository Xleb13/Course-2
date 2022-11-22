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
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Customer.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.setScene(new Scene(root, 900, 600));
        stage.setResizable(false);
        stage.show();
    });

        MenuSupplier.setOnAction(actionEvent -> { //открыть меню Поставщики
            MenuSupplier.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            Parent root = null;
            try{
                root = FXMLLoader.load(getClass().getResource("Supplier.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 900, 600));
            stage.setResizable(false);
            stage.show();
        });

        MenuStockWorker.setOnAction(actionEvent -> { //Открыть Меню Работники Склада
            MenuStockWorker.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            Parent root = null;
            try{
                root = FXMLLoader.load(getClass().getResource("Worker.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 900, 600));
            stage.setResizable(false);
            stage.show();
        });

        MenuStock.setOnAction(actionEvent -> { //Открыть Меню Товар
            MenuStock.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            Parent root = null;
            try {
                root = FXMLLoader.load((getClass().getResource("Stock.fxml")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 900, 600));
            stage.setResizable(false);
            stage.show();
        });


        MenuOrder.setOnAction(actionEvent -> { //Открыть Меню Заказ
            MenuOrder.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            Parent root = null;
            try{
                root = FXMLLoader.load(getClass().getResource("Order.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 900, 600));
            stage.setResizable(false);
            stage.show();
        });

        MenuStorage.setOnAction(actionEvent -> { //Открыть Меню Склад
            MenuStorage.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("Storage.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 900, 600));
            stage.setResizable(false);
            stage.show();
        });

        MenuDelivery.setOnAction(actionEvent -> { //Открыть Меню Доставка
            MenuDelivery.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("Delivery.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 900, 600));
            stage.setResizable(false);
            stage.show();
        });}
}
