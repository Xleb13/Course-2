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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class formOne {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button addButton;
    @FXML
    private Button open;
    @FXML
    private TableColumn<Clients, String> check;
    @FXML
    private TableColumn<Clients, String> initials;
    @FXML
    private TableColumn<Clients, Double> remainder;
    @FXML
    private TableView<Clients> table;
    DataBaseHendler dataBase = new DataBaseHendler();
    private final ObservableList<Clients> data = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        openAction();
        date();
        setD();
        addButton.setOnAction(event -> {
            addButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("addUser.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 320, 170));
            stage.setResizable(false);
            stage.show();
        });
    }
    private void openAction() {
        open.setOnAction(e -> {
            open.getScene().getWindow().hide();
            Clients sd = table.getSelectionModel().getSelectedItem();
            Clients.acc = sd.account;
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("action.fxml"));
                Parent root = fxmlLoader.load();
                Action contoller = fxmlLoader.getController();
                contoller.setDetails(table.getSelectionModel().getSelectedItem());
                Stage stage = new Stage();
                stage.initStyle(StageStyle.DECORATED);
                stage.setResizable(false);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.UNIFIED);
                stage.setTitle("Детализация");
                stage.setScene(new Scene(root));
                stage.showAndWait();
                table.getItems().clear();
                date();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
    private void date() {
        ResultSet user = dataBase.getL();
        try {
            while (user.next()) {
                Clients clients = new Clients(
                        user.getString(1),
                        user.getString(2),
                        user.getDouble(3));
                data.add(clients);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void setD() {
        check.setCellValueFactory(new PropertyValueFactory<>("account"));
        initials.setCellValueFactory(new PropertyValueFactory<>("name"));
        remainder.setCellValueFactory(new PropertyValueFactory<>("reminder"));
        table.setItems(data);
    }
}

