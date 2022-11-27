package com.example.storage.dbconnection;

import com.example.storage.Product;
import com.example.storage.Storage;

import java.sql.*;

public class DataBaseHandlerProduct extends Config {
    private PreparedStatement preparedStatement;
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static Connection getDbConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
//"SELECT storage.product.id, storage.product.title, storage.product.price,storage.product.categories,storage.product.count, storage.storage.count FROM storage.product, storage.storage WHERE storage.product.title = storage.storage.title"
    public ResultSet getProducts() { //вывод таблицы товаров из базы данных
        String getStock = "SELECT storage.product.id, storage.product.title, storage.product.price,storage.product.categories,storage.product.count, storage.storage.count FROM storage.product left join storage.storage on storage.product.title = storage.storage.title";
        PreparedStatement prSt = null;
        try {
            prSt = getDbConnection().prepareStatement(getStock);
            resultSet = prSt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException("Error getStrock",e);
        }
        return resultSet;
    }

    public void addProducts(Product product) { //добавление товара в базу данных
        String insert = "INSERT INTO storage.product (id, title, price, categories, count) VALUES(?,?,?,?,?)";
        try {
            preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getTitle());
            preparedStatement.setInt(3, product.getPrice());
            preparedStatement.setString(4, String.valueOf(product.getStockCategories()));
            preparedStatement.setInt(5, product.getCount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error AddStock",e);
        }
    }

    public void editProducts(String newId, String newTitle, Integer newPrice, String newStockCategories, Integer newCount) { //редактирование данных в таблице товары
        String Update = "UPDATE storage.product set title=" + "'" + newTitle + "'" +
                ",price=" + "'" + newPrice + "'" +
                ",categories=" + "'" + newStockCategories + "'" + ",count=" + newCount +
                " where id =" + newId;
        try {
            preparedStatement = getDbConnection().prepareStatement(Update);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error editStock",e);
        }
    }

    public void Delete(String Table,String id){

        try {
            getDbConnection();
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM storage."+Table+" WHERE id= "+id);
        } catch (SQLException e) {
            throw new RuntimeException("Error DeleteProduct",e);
        }
    }

    public ResultSet getStorages(String data){ //вывод списка склада
        String getStorages = "SELECT* FROM storage."+data;
        PreparedStatement prSt = null;
        try {
            prSt = getDbConnection().prepareStatement(getStorages);
            resultSet = prSt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }


    public void addStorages(Storage storage){
        String insert = "INSERT INTO storage.storage (id, title, categories, count, id_supplier) VALUES(?,?,?,?,?)";
        try{
            preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setInt(1,storage.getId());
            preparedStatement.setString(2,storage.getTitle());
            preparedStatement.setString(3, String.valueOf(storage.getStockCategories()));
            preparedStatement.setInt(4,storage.getCountst());
            preparedStatement.setInt(5,storage.getId_supplier());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editStorage(String newId, String newTitle, String newStockCategories, Integer newCount, Integer newIdSupplier) { //редактирование данных в таблице товары
        String Update = "UPDATE storage.storage set title=" + "'" + newTitle + "'" +
                ",categories=" + "'" + newStockCategories + "'" + ",count=" + "'" + newCount +
                "'" + ",id_supplier=" + newIdSupplier +
                " where id =" + newId;
        try {
            preparedStatement = getDbConnection().prepareStatement(Update);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error editStock",e);
        }
    }


}