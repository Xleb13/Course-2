package com.example.storage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.storage.dbconnection.DataBaseHandlerPerson;
import com.example.storage.dbconnection.DataBaseHandlerProduct;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.StageStyle;

public class TabelStorageController {

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
    private TableView<Storage> TableStorage;

    @FXML
    private TableColumn<Storage, String> categories;

    @FXML
    private TableColumn<Storage, Integer> count;

    @FXML
    private TableColumn<Storage, Integer> id;

    @FXML
    private TableColumn<Storage, Integer> id_supplier;

    @FXML
    private TableColumn<Storage, String> title;

    @FXML
    private final ObservableList<Storage> data8 = FXCollections.observableArrayList();

    DataBaseHandlerProduct dataBaseHandlerProduct = new DataBaseHandlerProduct();
    @FXML
    void initialize() {
        setStorage();
        TableStorage.setItems(data8);
        dataStorage();
        navigation();
        editStorage();
        deleteStorage();
        addStorage();
    }

    private void dataStorage(){
        ResultSet storages = dataBaseHandlerProduct.getStorages("storage");
        try {
            while (storages.next()){
                Storage storage = new Storage(
                        storages.getInt(1),
                        storages.getString(2),
                        storages.getString(3),
                        storages.getInt(4),
                        storages.getInt(5));
                        data8.add(storage);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void addStorage() { //добавления товара в базу данных
        Add.setOnAction(e -> {
            Add.getScene();
            Parent root = null;
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddStorage.fxml"));
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
            TableStorage.getItems().clear();
            dataStorage();
        });
    }

    private void deleteStorage() { //удаление товара
        Delete.setOnAction(event -> {
            Storage storage = TableStorage.getSelectionModel().getSelectedItem();
            int id = storage.getId();
            String str = String.valueOf(id);
            String Table = "storage";
            Object selectedItem = TableStorage.getSelectionModel().getSelectedItem();
            TableStorage.getItems().remove(selectedItem);
            dataBaseHandlerProduct.Delete(Table, str);
        });
    }

    private void editStorage() { //изменение товара в базе данных
        Edit.setOnAction(e -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditStorage.fxml"));
                Parent root = fxmlLoader.load();

                EditStorage controller = fxmlLoader.getController();
                controller.setStorageData(TableStorage.getSelectionModel().getSelectedItem());
                Stage stage = new Stage();
                stage.initStyle(StageStyle.DECORATED);
                stage.setResizable(false);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.UNIFIED);
                stage.setTitle("Редактирование");
                stage.setScene(new Scene(root));
                stage.showAndWait();
                TableStorage.getItems().clear();
                dataStorage();
            } catch (Exception ex) {
                System.err.println("Ошибка открытия формы редактивания: " + ex.getMessage());
                ex.printStackTrace();
            }
        });
    }

    public void setStorage(){
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        categories.setCellValueFactory(new PropertyValueFactory<>("stockCategories"));
        count.setCellValueFactory(new PropertyValueFactory<>("countst"));
        id_supplier.setCellValueFactory(new PropertyValueFactory<>("id_supplier"));
    }

    public void navigation() { //интерфейсная навигация между окнами
        MenuCustomer.setOnAction(actionEvent -> { //Открыть Меню Клиенты
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
            try {
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
            try {
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
                root = FXMLLoader.load((getClass().getResource("Product.fxml")));
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
            try {
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
    }
}

