package com.example.bank;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
public class Action {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField account;
    @FXML
    private Button backButton;
    @FXML
    private Button addButton;
    @FXML
    private TableColumn<Actions, Double> deposit;
    @FXML
    private TextField name;
    @FXML
    private TableView<Actions> table;
    @FXML
    private TableColumn<Actions, String> op_date;
    @FXML
    private TableColumn<Actions, Double> reminder;
    @FXML
    private TableColumn<Actions, Double> withdrawal;
    DataBaseHendler dataBase = new DataBaseHendler();
    private final ObservableList<Actions> data = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        dataMore();
        setMore();
        addOp();
        backButton.setOnAction(event -> {
            backButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("formOne.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 600, 400));
            stage.setResizable(false);
            stage.show();
        });
    }
    public void setDetails(Clients selectedItem){
        account.setText(selectedItem.getAccount());
        name.setText(selectedItem.getName());
    }
    public void setMore(){
        op_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        deposit.setCellValueFactory(new PropertyValueFactory<>("deposit"));
        withdrawal.setCellValueFactory(new PropertyValueFactory<>("withdrawal"));
        reminder.setCellValueFactory(new PropertyValueFactory<>("reminder"));
        table.setItems(data);
    }
    private void dataMore(){
    ResultSet mores = dataBase.getMore(Clients.acc);
    try {
        while (mores.next()) {
            Actions actions = new Actions(
                    mores.getString(1),
                    mores.getDouble(2),
                    mores.getDouble(3),
                    mores.getDouble(4));
            data.add(actions);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }
    private void addOp() {
        addButton.setOnAction(event -> {
            addButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("addop.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 600, 400));
            stage.setResizable(false);
            stage.show();
        });
    }
}