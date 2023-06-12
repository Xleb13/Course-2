package com.example.bank;

import java.sql.*;
import static com.example.bank.Actions.id_client;
import static com.example.bank.Clients.na;
import static com.example.bank.Actions.rem;

public class DataBaseHendler extends Config {
    private static Connection con;
    private static ResultSet rs;
    private static Statement stmt;
    private PreparedStatement preparedStatement;

    public Connection getDbConnection() {
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }
    public ResultSet getL() {
        String getUser = "select c.account, c.name, act.reminder from (select id_client, max(op_date) as op_date from bank.actions group by id_client) as a\n" +
                "inner join bank.actions act on a.id_client=act.id_client and a.op_date=act.op_date inner join bank.clients as c on a.id_client=c.id";
        PreparedStatement prSt = null;
        try {
            prSt = getDbConnection().prepareStatement(getUser);
            rs = prSt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }
    public void signClients(Clients clients) {
        String insert = "insert into bank.clients (account,name) values(?,?)";
        try {
            preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, clients.getAccount());
            preparedStatement.setString(2, clients.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ResultSet getMore(String acc) {
        String getMores = "Select op_date, deposit, withdrawl, reminder \n" +
                " from bank.actions as a\n" +
                "inner join bank.clients as c\n" +
                "on a.id_client=c.id where account='" + acc + "'";
        PreparedStatement prSt = null;
        try {
            prSt = getDbConnection().prepareStatement(getMores);
            rs = prSt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }
    public void infUser(String account, String name) {
        try {
            getDbConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select id from bank.clients where account=" + "'" + account +
                    "'" + " and name=" + "'" + name + "'");
            while (rs.next()) {
                id_client = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void setName(String nme){
        try {
            getDbConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT name from bank.clients WHERE account = '" + nme + "'");
            while (rs.next()){
                na = rs.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void setId(String nme){
        try {
            getDbConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT id from bank.clients WHERE account = '" + nme + "'");
            while (rs.next()){
                id_client = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void infRem(String acc){
        try {
            getDbConnection();
            stmt = con.createStatement();
            rs =stmt.executeQuery("select act.reminder from (select id_client, max(op_date) as op_date from bank.actions group by id_client) as a" +
                    " inner join bank.actions act on a.id_client=act.id_client and a.op_date=act.op_date inner join bank.clients as c on a.id_client=c.id where c.account='" + acc + "';");
            while (rs.next()){
                rem = Double.parseDouble(rs.getString(1));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void addUActions(int id_client, Double remainde, String date) {
        String insert = "insert into bank.actions (id_client,deposit,withdrawl,reminder,op_date) values (" + id_client + ",0,0," + remainde + "," + "'" + date + "')";
        try {
            preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void transaction(int id_c,Double deposit,Double withdrawl,Double reminder,String date){
        String insert = "insert into bank.actions (id_client,deposit,withdrawl,reminder,op_date) values(" + id_c + "," + deposit + "," + withdrawl + "," + reminder + ",'"  + date + "')";
        try {
            preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
