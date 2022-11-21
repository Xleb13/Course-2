package DBConnector;

import com.example.storage.Stock;
import java.sql.*;

public class DataBaseHandlerStock extends Config {
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

        public void AddStock(Stock stock) {
        String insert = "INSERT INTO storage.product (id, title, price, categories, count) VALUES(?,?,?,?,?)";
        try {
            preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setInt(1, stock.getId());
            preparedStatement.setString(2, stock.getTitle());
            preparedStatement.setInt(3, stock.getPrice());
            preparedStatement.setString(4, String.valueOf(stock.getStockCategories()));
            preparedStatement.setInt(5, stock.getCount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        public void EditStock(String newId, String newTitle, Integer newPrice, String newStockCategories, Integer newCount) {
        String Update = "UPDATE storage.product set title="+"'"+newTitle+"'"+
                ",price="+"'"+newPrice+"'"+
                ",categories="+"'"+newStockCategories+"'"+",count="+newCount+
                " where id ="+newId;
        try {
            preparedStatement = getDbConnection().prepareStatement(Update);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}

