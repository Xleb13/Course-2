package com.example.storage;

import DBConnector.DataBaseHandlerStock;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class TabelStockController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Add;

    @FXML
    private Button Delete;

    @FXML
    private Button Edit;

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
    private TableView<Stock> TableStock;
    @FXML
    private TableColumn<Stock, Integer> count;

    @FXML
    private TableColumn<Stock, Integer> id;

    @FXML
    private TableColumn<Stock, Integer> price;

    @FXML
    private TableColumn<Stock, String> stockCategories;

    @FXML
    private TableColumn<Stock, String> title;

    @FXML
    private final ObservableList<Stock> data2 = FXCollections.observableArrayList();

    DataBaseHandlerStock dataBaseHandlerStock = new DataBaseHandlerStock();

    @FXML
    void initialize() {
        navigation();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        stockCategories.setCellValueFactory(new PropertyValueFactory<>("stockCategories"));
        count.setCellValueFactory(new PropertyValueFactory<>("count"));
        dataStock();
        TableStock.setItems(data2);
        addStock();
        editStock();
        deleteStock();
    }
        private void dataStock(){ //вывод списка
            ResultSet stocks = dataBaseHandlerStock.getStocks("product");
            try {
                while (stocks.next()){
                    Stock stock = new Stock(
                            stocks.getInt(1),
                            stocks.getString(2),
                            stocks.getInt(3),
                            stocks.getString(4),
                            stocks.getInt(5));
                    data2.add(stock);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        private void addStock(){
            Add.setOnAction(e -> {
                Add.getScene();
                Parent root = null;
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddStock.fxml"));
                    root = fxmlLoader.load();
                } catch (IOException exc) {
                    System.err.println("Файл не найден");
                }
                Stage stage = new Stage();
                stage.initStyle(StageStyle.DECORATED);
                stage.setResizable(false);
                stage.setTitle("Добавление продукта");
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.initOwner(Add.getScene().getWindow());
                stage.showAndWait();
            });
        }

    private void editStock() {
        Edit.setOnAction(e -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditStock.fxml"));
                Parent root = fxmlLoader.load();

                EditStock controller = fxmlLoader.getController();
                controller.setStockData(TableStock.getSelectionModel().getSelectedItem());
                Stage stage = new Stage();
                stage.initStyle(StageStyle.DECORATED);
                stage.setResizable(false);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.UNIFIED);
                stage.setTitle("Редактирование");
                stage.setScene(new Scene(root));
                stage.show();
            } catch (Exception ex) {
                System.err.println("Ошибка открытия формы редактивания: " + ex.getMessage());
                ex.printStackTrace();
            }
        });
    }

    private void deleteStock(){
        Delete.setOnAction( event -> {
            Stock stock = TableStock.getSelectionModel().getSelectedItem();
            int id = stock.getId();
            String str = String.valueOf(id);
            String Table = "product";
            System.out.println(stock.getId());
            Object selectedItem = TableStock.getSelectionModel().getSelectedItem();
            TableStock.getItems().remove(selectedItem);
            dataBaseHandlerStock.Delete(Table,str);
        });
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





