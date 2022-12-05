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
        private TableView<Order> TableList;;

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

        private final ObservableList<Order> data15 = FXCollections.observableArrayList();
        DataBaseHandlerOrder dataBaseHandlerOrder = new DataBaseHandlerOrder();
    @FXML
    void initialize() {
        deleteOrder();
        dataOrderList();
        setOrderList();
        addOrderButton.setOnAction(event -> {
            addorder();
            addOrderButton.getScene().getWindow().hide();
        });
    }

    private void dataOrderList(){
        DataBaseHandlerOrderList dataBaseHandlerOrderList = new DataBaseHandlerOrderList();
        ResultSet ordlist= dataBaseHandlerOrderList.getOrderList("order_product");
        try {
            while (ordlist.next()) {
                Order order = new Order(
                        ordlist.getInt(1),
                        ordlist.getString(2),
                        ordlist.getInt(3));
                data15.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void setOrderList(){
        titile.setCellValueFactory(new PropertyValueFactory<>("title"));
        count.setCellValueFactory(new PropertyValueFactory<>("count"));

        TableList.setItems(data15);
    }

    private void deleteOrder(){
        DataBaseHandlerOrderList dataBaseHandlerOrderList = new DataBaseHandlerOrderList();
        deletProduct.setOnAction(event -> {
            Order order = TableList.getSelectionModel().getSelectedItem();
            int id_order = order.getId_order();
            String str = String.valueOf(id_order);
            String Tabel = "order";
            Object selectedItem = TableList.getSelectionModel().getSelectedItem();
            TableList.getItems().remove(selectedItem);
            dataBaseHandlerOrderList.Delete(Tabel, str);
        });
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