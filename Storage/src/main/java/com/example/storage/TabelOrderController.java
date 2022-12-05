package com.example.storage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.storage.dbconnection.DataBaseHandlerOrder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.StageStyle;

public class TabelOrderController {

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
    private TableView<Order> TableOrder;

    @FXML
    private TableColumn<Order, Integer> idCustomer;

    @FXML
    private TableColumn<Order, Integer> idOrder;

    @FXML
    private TableColumn<Order, Integer> idWorker;

    @FXML
    private TableColumn<Order, String> status;

    private final ObservableList<Order> data9 = FXCollections.observableArrayList();
    DataBaseHandlerOrder dataBaseHandlerOrder = new DataBaseHandlerOrder();

    @FXML
    void initialize() {
        dataOrder();
        setOrder();
        addOrder();
        editOrder();
        deleteOrder();
        navigation();
    }

    private void dataOrder() {
        ResultSet orders = dataBaseHandlerOrder.getOrders("order");
        try {
            while (orders.next()) {
                Order order = new Order(
                        orders.getInt(1),
                        orders.getInt(2),
                        orders.getInt(3),
                        orders.getString(4));
                data9.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void addOrder(){
        Add.setOnAction(event -> {
            Add.getScene();
            Parent root = null;
            try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddOrder.fxml"));
                    root = fxmlLoader.load();
            } catch (IOException e) {
                System.err.println("Файл не найден");
            }
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED);
            stage.setResizable(false);
            stage.setTitle("");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initOwner(Add.getScene().getWindow());
            stage.showAndWait();
            TableOrder.getItems().clear();
            dataOrder();
        });
    }

    private void editOrder(){
        Edit.setOnAction(event -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditOrder.fxml"));
                Parent root = fxmlLoader.load();

                EditOrder controller = fxmlLoader.getController();
                controller.setOrderData(TableOrder.getSelectionModel().getSelectedItem());
                Stage stage = new Stage();
                stage.initStyle(StageStyle.DECORATED);
                stage.setResizable(false);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.UNIFIED);
                stage.setTitle("Редактирование");
                stage.setScene(new Scene(root));
                stage.showAndWait();
                TableOrder.getItems().clear();
                dataOrder();
            } catch (Exception ex) {
                System.err.println("Ошибка открытия формы редактивания: " + ex.getMessage());
                ex.printStackTrace();
            }
        });
    }
    private void deleteOrder(){
        Delete.setOnAction(event -> {
            Order order = TableOrder.getSelectionModel().getSelectedItem();
            int id_order = order.getId_order();
            String str = String.valueOf(id_order);
            String Tabel = "order";
            Object selectedItem = TableOrder.getSelectionModel().getSelectedItem();
            TableOrder.getItems().remove(selectedItem);
            dataBaseHandlerOrder.Delete(Tabel, str);
        });
    }
    public void setOrder(){
        idOrder.setCellValueFactory(new PropertyValueFactory<>("id_order"));
        idCustomer.setCellValueFactory(new PropertyValueFactory<>("id_customer"));
        idWorker.setCellValueFactory(new PropertyValueFactory<>("id_worker"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));

        TableOrder.setItems(data9);
    }


    public void navigation() {
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