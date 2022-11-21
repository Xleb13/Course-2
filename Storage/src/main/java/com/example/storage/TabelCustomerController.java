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

public class TabelCustomerController implements Initializable {

    @FXML
    private TableView<Customer> TabelCustomerController;

    @FXML
    private TableColumn<Customer, String> email;

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
    private TableColumn<Customer, String> date_of_birthday;

    @FXML
    private TableColumn<Customer, String> gender;

    @FXML
    private TableColumn<Customer, Integer> id;

    @FXML
    private TableColumn<Customer, String> name;

    @FXML
    private TableColumn<Customer, String> paymentdetails;

    @FXML
    private TableColumn<Customer, String> phonenumber;
    @FXML
    private final ObservableList<Customer> data5 = FXCollections.observableArrayList();

    DataBaseHandlerPerson dataBaseHandlerPerson = new DataBaseHandlerPerson();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        navigation();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        phonenumber.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        paymentdetails.setCellValueFactory(new PropertyValueFactory<>("paymentdetails"));
        date_of_birthday.setCellValueFactory(new PropertyValueFactory<>("date_of_birthday"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        dataCustomer();
        TabelCustomerController.setItems(data5);
    }

    public void dataCustomer(){
        ResultSet customers = dataBaseHandlerPerson.getCustomers("customer");
        try {
            while (customers.next()){
                Customer customer = new Customer(
                        customers.getInt(1),
                        customers.getString(2),
                        customers.getString(3),
                        customers.getString(4),
                        customers.getString(5),
                        customers.getString(6),
                        customers.getString(7));
                data5.add(customer);
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

