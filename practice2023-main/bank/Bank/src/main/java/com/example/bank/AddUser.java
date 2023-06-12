package com.example.bank;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddUser {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button cancellation;
    @FXML
    private TextField check;
    @FXML
    private TextField nameU;
    @FXML
    private Button okButton;
    @FXML
    private TextField sum;
    DataBaseHendler dbHandler = new DataBaseHendler();

    @FXML
    void initialize() {
        okButton.setOnAction(event -> {
            addUser();
            dbHandler.infUser(check.getText(), nameU.getText());
            addUAc();
            okButton.getScene().getWindow().hide();
            nextWin();
        });
        cancellation.setOnAction(event -> {
            cancellation.getScene().getWindow().hide();
            nextWin();
        });
    }
    private void addUser() {
        String account = check.getText();
        String name = nameU.getText();
        Clients clients = new Clients(account, name);
        dbHandler.signClients(clients);
    }
    private void addUAc() {
        Double reminder = Double.valueOf(sum.getText());
        Calendar calendar = Calendar.getInstance();
        DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd-HH-mm-ss");
        String date = formatter.format(calendar.getTime());
        dbHandler.addUActions(Actions.id_client, reminder, date);
    }
    private void nextWin() {
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
    }
}


