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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddOP {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField account;
    @FXML
    private Button chancelButton;
    @FXML
    private Button check;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private TextField name;
    @FXML
    private Button okButton;
    @FXML
    private TextField op_date;
    @FXML
    private TextField remind;
    @FXML
    private TextField sum;
    DataBaseHendler dataBase = new DataBaseHendler();

    @FXML
    void initialize() {
        okButton.setVisible(false);
        chancel();
        loadDate();
        inf();
        check.setOnAction(event -> {
            String selecteditems = comboBox.getValue();
            String choose = selecteditems;
            if (choose == null) {
                System.out.println("Не выбрано действие");
            }
            else{
                if(choose == "Приход"){
                    dataBase.infRem(Clients.acc);
                    Double acc = Actions.rem;
                    Double deposit = Double.valueOf(sum.getText());
                    if(deposit>0) {
                        Double reminder = acc + deposit;
                        Double withdrawl = 0.0;
                        remind.setText(String.valueOf(reminder));
                        okButton.setVisible(true);
                        okButton.setOnAction(event1 -> {
                            Calendar calendar = Calendar.getInstance();
                            DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd-HH-mm-ss");
                            String date = formatter.format(calendar.getTime());
                            int id_c = Actions.id_client;
                            dataBase.transaction(id_c, deposit, withdrawl, reminder, date);
                            okButton.getScene().getWindow().hide();
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
                    else{
                        remind.setText("Введите число >0");
                    }
                }
                else{
                    dataBase.infRem(Clients.acc);
                    Double acc = Actions.rem;
                    Double withdrawl = Double.valueOf(sum.getText());
                    if(acc>=withdrawl){
                        Double reminder = acc-withdrawl;
                        Double deposit = 0.0;
                        remind.setText(String.valueOf(reminder));
                        okButton.setVisible(true);
                        okButton.setOnAction(event1 -> {
                            Calendar calendar = Calendar.getInstance();
                            DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd-HH-mm-ss");
                            String date = formatter.format(calendar.getTime());
                            int id_c = Actions.id_client;
                            dataBase.transaction(id_c, deposit, withdrawl, reminder, date);
                            okButton.getScene().getWindow().hide();
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
                    else{
                        remind.setText("Недостаточно средств");
                        okButton.setVisible(false);
                    }
                }
            }
        });
    }
    private void inf(){
        String nme = account.getText();
        dataBase.setName(nme);
        name.setText(Clients.na);
        dataBase.setId(nme);
        String [] choose = {"Приход","Расход"};
        comboBox.getItems().addAll(choose);
    }
    private void loadDate(){
        account.setText(Clients.acc);
        Calendar calendar = Calendar.getInstance();
        DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd-HH-mm-ss");
        String date = formatter.format(calendar.getTime());

        Calendar calendar1 = Calendar.getInstance();
        DateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        String date1 = format.format(calendar1.getTime());
        op_date.setText(date1);}
    private void chancel() {
        chancelButton.setOnAction(event -> {
            chancelButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("action.fxml"));
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
