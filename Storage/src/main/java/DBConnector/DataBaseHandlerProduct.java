package DBConnector;

import com.example.storage.Product;
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

    public ResultSet getStocks(String data) {
        String getStock = "SELECT* FROM storage." + data;
        PreparedStatement prSt = null;
        try {
            prSt = getDbConnection().prepareStatement(getStock);
            resultSet = prSt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public void AddStock(Product product) {
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
            throw new RuntimeException(e);
        }
    }

    public void EditStock(String newId, String newTitle, Integer newPrice, String newStockCategories, Integer newCount) {
        String Update = "UPDATE storage.product set title=" + "'" + newTitle + "'" +
                ",price=" + "'" + newPrice + "'" +
                ",categories=" + "'" + newStockCategories + "'" + ",count=" + newCount +
                " where id =" + newId;
        try {
            preparedStatement = getDbConnection().prepareStatement(Update);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void Delete(String Table,String id){

        try {
            getDbConnection();
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM storage."+Table+" WHERE id= "+id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

