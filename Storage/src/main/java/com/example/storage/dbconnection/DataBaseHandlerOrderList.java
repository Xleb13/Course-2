package com.example.storage.dbconnection;

import java.sql.*;

public class DataBaseHandlerOrderList extends Config{
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

    public ResultSet getOrderList(String data) {
        String getList = "SELECT title, count FROM storage." + data;
        PreparedStatement prSt = null;
        try {
            prSt = getDbConnection().prepareStatement(getList);
            resultSet = prSt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
    public void Delete(String Table,String title){

        try {
            getDbConnection();
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM storage."+Table+" WHERE title= "+title);
        } catch (SQLException e) {
            throw new RuntimeException("",e);
        }
    }
}
