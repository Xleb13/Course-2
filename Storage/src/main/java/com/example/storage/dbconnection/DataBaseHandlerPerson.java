package com.example.storage.dbconnection;

import java.sql.*;

public class DataBaseHandlerPerson extends Config {
    private PreparedStatement preparedStatement;
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public Connection getDbConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    public ResultSet getStockWorkers(String data){//вывод списка работнков
        String getStockWorker = "SELECT* FROM storage."+data;
        PreparedStatement prSt = null;
        try {
            prSt = getDbConnection().prepareStatement(getStockWorker);
            resultSet = prSt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException("Error getStockWorker",e);
        }
        return resultSet;
    }

    public ResultSet getSuppliers(String data){ //вывод списка поставщиков
        String getSuppliers = "SELECT* FROM storage."+data;
        PreparedStatement prSt = null;
        try{
            prSt = getDbConnection().prepareStatement(getSuppliers);
            resultSet = prSt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException("Error getSupplier",e);
        }
        return resultSet;
    }

    public ResultSet getCustomers(String data){ //вывод списка покупателй
        String getCustomers = "SELECT* FROM storage."+data;
        PreparedStatement prSt = null;
        try{
            prSt = getDbConnection().prepareStatement(getCustomers);
            resultSet = prSt.executeQuery();
        } catch (SQLException e){
            throw new RuntimeException("Error getCustomer",e);
        }
        return resultSet;
    }
}