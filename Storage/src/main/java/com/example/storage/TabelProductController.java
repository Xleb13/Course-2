package com.example.storage;

import com.example.storage.dbconnection.DataBaseHandlerProduct;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
import java.util.ResourceBundle;

public class TabelProductController {

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
    private TableView<Product> TableStock;
    @FXML
    private TableColumn<Product, Integer> count;

    @FXML
    private TableColumn<Product, Integer> id;

    @FXML
    private TableColumn<Product, Integer> price;

    @FXML
    private TableColumn<Product, String> stockCategories;

    @FXML
    private TableColumn<Product, String> title;

    @FXML
    private TableColumn<Storage, Integer> availability;

    @FXML
    private final ObservableList<Product> data2 = FXCollections.observableArrayList();

    DataBaseHandlerProduct dataBaseHandlerProduct = new DataBaseHandlerProduct();

    @FXML
    void initialize() {
        dataProduct();
        setProduct();
        TableStock.setItems(data2);
        addProduct();
        editProduct();
        deleteProduct();
        navigation();
    }

    private void dataProduct() { //заполенение таблицы данными из бд
        ResultSet stocks = dataBaseHandlerProduct.getProducts();
        try {
            while (stocks.next()) {
                Product product = new Product(
                        stocks.getInt(1),
                        stocks.getString(2),
                        stocks.getInt(3),
                        stocks.getString(4),
                        stocks.getInt(5),
                        stocks.getInt(6));
                data2.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void addProduct() { //добавления товара в базу данных
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
            TableStock.getItems().clear();
            dataProduct();
        });
    }

    public void setProduct(){ //обозначения табличек
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        stockCategories.setCellValueFactory(new PropertyValueFactory<>("stockCategories"));
        count.setCellValueFactory(new PropertyValueFactory<>("count"));
        availability.setCellValueFactory(new PropertyValueFactory<>("countst"));
    }

    private void editProduct() { //изменение товара в базе данных
        Edit.setOnAction(e -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditStock.fxml"));
                Parent root = fxmlLoader.load();

                EditProduct controller = fxmlLoader.getController();
                controller.setStockData(TableStock.getSelectionModel().getSelectedItem());
                Stage stage = new Stage();
                stage.initStyle(StageStyle.DECORATED);
                stage.setResizable(false);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.UNIFIED);
                stage.setTitle("Редактирование");
                stage.setScene(new Scene(root));
                stage.showAndWait();
                TableStock.getItems().clear();
                dataProduct();
            } catch (Exception ex) {
                System.err.println("Ошибка открытия формы редактивания: " + ex.getMessage());
                ex.printStackTrace();
            }
        });
    }

    private void deleteProduct() { //удаление товара
        Delete.setOnAction(event -> {
            Product product = TableStock.getSelectionModel().getSelectedItem();
            int id = product.getId();
            String str = String.valueOf(id);
            String Table = "product";
            Object selectedItem = TableStock.getSelectionModel().getSelectedItem();
            TableStock.getItems().remove(selectedItem);
            dataBaseHandlerProduct.Delete(Table, str);
        });
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
