package com.example.storage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.storage.dbconnection.DataBaseHandlerOrder;
import com.example.storage.dbconnection.DataBaseHandlerOrderList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AddOrder {


        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private TableView<Order> OrderData;

        @FXML
        private Button addOrderButton;

        @FXML
        private Button addProduct;

        @FXML
        private TableColumn<Order, Integer> count;

        @FXML
        private TextField countS;

        @FXML
        private Button deletProduct;

        @FXML
        private TextField idCustomer;

        @FXML
        private TextField idOrder;

        @FXML
        private TextField idWroker;

        @FXML
        private TextField statuS;

        @FXML
        private TableColumn<Order, String> titile;

        @FXML
        private TextField title;

        private final ObservableList<Order> data12 = FXCollections.observableArrayList();
        DataBaseHandlerOrder dataBaseHandlerOrder = new DataBaseHandlerOrder();
        DataBaseHandlerOrderList dataBaseHandlerOrderList = new DataBaseHandlerOrderList();

    @FXML
    void initialize() {
        addOrderButton.setOnAction(event -> {
            addorder();
            dataOrderList();
            setOrderList();
            addOrderButton.getScene().getWindow().hide();
        });
    }

    private void dataOrderList(){
        ResultSet ordlist= dataBaseHandlerOrderList.getOrderList("order_product");
        try {
            while (ordlist.next()) {
                Order order = new Order(
                        ordlist.getString(1),
                        ordlist.getInt(2));
                data12.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setOrderList(){
        titile.setCellValueFactory(new PropertyValueFactory<>("title"));
        count.setCellValueFactory(new PropertyValueFactory<>("count"));
        OrderData.setItems(data12);
    }

        //order_product
    private void addorder() {
        Integer id_order = Integer.valueOf(idOrder.getText());
        Integer id_customer = Integer.valueOf(idCustomer.getText());
        Integer id_worker = Integer.valueOf(idWroker.getText());
        String status = statuS.getText();

        Order order = new Order(id_order, id_customer, id_worker, status);
        dataBaseHandlerOrder.addOrders(order);
    }
}