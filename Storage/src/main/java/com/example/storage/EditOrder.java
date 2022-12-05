package com.example.storage;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.storage.dbconnection.DataBaseHandlerOrder;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class EditOrder {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button EditOrderButton;

    @FXML
    private TableView<Order> TableList;

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
    private TableColumn<Order, Integer> titile;

    @FXML
    private TextField title;

    DataBaseHandlerOrder dataBaseHandlerOrder = new DataBaseHandlerOrder();
    private int id;

    @FXML
    void initialize() {
        EditOrderButton.setOnAction(event -> {
            editorder();
            EditOrderButton.getScene().getWindow().hide();
        });
    }

    public void editorder() {
        String newId = Integer.valueOf(id).toString();
        Integer newId_customer = Integer.valueOf(idCustomer.getText());
        Integer newId_worker = Integer.valueOf(idWroker.getText());
        String newStatus = statuS.getText();
        dataBaseHandlerOrder.editOrders(newId, newId_customer, newId_worker, newStatus);
    }

    public void setOrderData(Order selectedItem) {
        id = selectedItem.getId_order();
        idCustomer.setText(String.valueOf(selectedItem.getId_customer()));
        idWroker.setText(String.valueOf(selectedItem.getId_worker()));
        statuS.setText(String.valueOf(selectedItem.getStatus()));
    }
}
