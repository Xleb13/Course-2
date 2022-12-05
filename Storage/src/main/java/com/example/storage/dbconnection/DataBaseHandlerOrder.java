package com.example.storage.dbconnection;

import com.example.storage.Order;

import java.sql.*;

public class DataBaseHandlerOrder extends Config{
    private PreparedStatement preparedStatement;
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public Connection getDbConnection(){
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    public void addOrders(Order order){
        String insert = "INSERT INTO storage.order (id_order, id_customer, id_worker, status) VALUES (?,?,?,?)";
        try{
            preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setInt(1,order.getId_order());
            preparedStatement.setInt(2,order.getId_customer());
            preparedStatement.setInt(3,order.getId_worker());
            preparedStatement.setString(4,order.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void Delete(String Table,String id){

        try {
            getDbConnection();
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM storage."+Table+" WHERE id_order= "+id);
        } catch (SQLException e) {
            throw new RuntimeException("Error DeleteProduct",e);
        }
    }

    public ResultSet getOrders(String data) {
        String getOrder = "SELECT* FROM storage."+data;
        PreparedStatement prSt = null;
        try {
            prSt = getDbConnection().prepareStatement(getOrder);
            resultSet = prSt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
}
